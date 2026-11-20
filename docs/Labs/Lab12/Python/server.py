# server
# TCP echo server: listens on PORT, accepts one client at a time,
# and echoes every message back with an acknowledgement.
import socket
import urllib.request
from datetime import datetime

HOST = "0.0.0.0"  # Listen on every network interface on this system
PORT = 8080       # Port to listen on (non-privileged ports are > 1023)


def now():
    """Timestamp for log lines."""
    return datetime.now().strftime("%H:%M:%S")


def log(msg):
    print(f"[{now()}] [SERVER] {msg}")


def get_private_ip():
    """IP of the network interface this system uses to reach the internet.
    connect() on a UDP socket picks a route but sends no packets."""
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
        try:
            s.connect(("8.8.8.8", 80))
            return s.getsockname()[0]
        except OSError:
            return "unavailable"


def get_public_ip():
    """Ask an outside service which IP our traffic appears to come from."""
    try:
        with urllib.request.urlopen("https://checkip.amazonaws.com", timeout=3) as r:
            return r.read().decode().strip()
    except OSError:
        return "unavailable"


def handle_client(conn, addr):
    """Echo messages from one connected client until it disconnects."""
    client_ip, client_port = addr
    local_ip, local_port = conn.getsockname()

    log(f"Client connected from {client_ip}:{client_port}")
    # A socket is identified by 4 values: local IP:port <-> remote IP:port
    log(f"Socket: {local_ip}:{local_port} <-> {client_ip}:{client_port}")

    # Each message is one line of text ending in "\n".
    # TCP is a stream of bytes, so the newline marks where a message ends.
    with conn, conn.makefile("rb") as stream:
        for line in stream:
            text = line.decode(errors="replace").rstrip("\n")
            log(f"Received {len(line)} bytes from {client_ip}:{client_port}: {text!r}")

            # Acknowledge + echo. Include the IP and port we saw the client
            # connect from so it can compare against what it thinks it is.
            reply = f"ACK {len(line)} {client_ip} {client_port} {text}\n".encode()
            conn.sendall(reply)
            log(f"Echoed {len(reply)} bytes back to {client_ip}:{client_port}")

    log(f"Client {client_ip}:{client_port} disconnected")


def main():
    log("Starting up...")
    log(f"Private IP: {get_private_ip()}")
    log(f"Public IP:  {get_public_ip()}")

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        # Allow restarting the server right away instead of waiting for the
        # OS to release the port ("Address already in use")
        s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        try:
            s.bind((HOST, PORT))
        except PermissionError:
            log(f"ERROR: not allowed to use port {PORT}. Ports below 1024 need root - pick a port above 1023.")
            return
        except OSError as e:
            log(f"ERROR: cannot listen on port {PORT}: {e}")
            log(f"Is another server already running? Check with: ss -tlnp | grep {PORT}")
            return

        s.listen()
        log(f"Listening on {HOST}:{PORT} (TCP) - press Ctrl+C to stop")

        # Serve clients one after another, forever
        while True:
            conn, addr = s.accept()
            try:
                handle_client(conn, addr)
            except ConnectionResetError:
                log(f"Client {addr[0]}:{addr[1]} dropped the connection")
            log("Waiting for next client...")


if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        print()
        log("Shutting down. Goodbye!")
