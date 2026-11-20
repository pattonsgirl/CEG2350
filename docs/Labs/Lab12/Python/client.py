# client
# TCP echo client: connects to the server, sends messages you type,
# and shows the server's acknowledgement and echo.
import ipaddress
import socket
import time
import urllib.request
from datetime import datetime

HOST = "34.196.111.132"  # Replace with your AWS instance's public IP
PORT = 8080                  # Must match the PORT the server is listening on


def now():
    """Timestamp for log lines."""
    return datetime.now().strftime("%H:%M:%S")


def log(msg):
    print(f"[{now()}] [CLIENT] {msg}")


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


def connect():
    """Connect to the server. Returns a socket, or None after printing
    a hint about what to fix."""
    try:
        ipaddress.ip_address(HOST)
    except ValueError:
        log(f"ERROR: HOST is set to {HOST!r}, which is not an IP address.")
        log("FIX: edit HOST in client.py to your AWS instance's public IP (e.g. 3.91.24.157).")
        return None

    log(f"Connecting to {HOST}:{PORT}...")
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.settimeout(5)  # Give up if there is no answer in 5 seconds
    try:
        client.connect((HOST, PORT))
        return client
    except ConnectionRefusedError:
        log(f"ERROR: {HOST} answered, but nothing is listening on port {PORT}.")
        log("FIX: start server.py on your instance, and check that PORT matches in both files.")
    except socket.timeout:
        log(f"ERROR: no answer from {HOST}:{PORT} after 5 seconds.")
        log("FIX: check that...")
        log(f"  - your Security Group has an inbound rule allowing TCP port {PORT} from your IP")
        log("  - HOST is your instance's *public* IP (it changes if the instance is stopped and started)")
        log("  - your instance is running")
    except OSError as e:
        log(f"ERROR: could not connect: {e}")
        log("FIX: check that this system is connected to the internet.")
    client.close()
    return None


def chat(client):
    """Send messages to the server and print each acknowledgement."""
    local_ip, local_port = client.getsockname()
    server_ip, server_port = client.getpeername()

    log(f"Connected to server {server_ip}:{server_port}")
    # The OS picks a temporary (ephemeral) port for the client when it connects
    log(f"OS opened local port {local_port} for this connection")
    # A socket is identified by 4 values: local IP:port <-> remote IP:port
    log(f"Socket: {local_ip}:{local_port} <-> {server_ip}:{server_port}")

    client.settimeout(10)  # Wait at most 10 seconds for each reply

    # Each message is one line of text ending in "\n".
    # TCP is a stream of bytes, so the newline marks where a message ends.
    with client.makefile("rb") as stream:
        while True:
            try:
                msg = input("Enter message (or 'quit'): ")
            except EOFError:  # Ctrl+D
                print()
                break
            if msg.lower() == "quit":
                break
            if not msg:
                continue

            data = (msg + "\n").encode()
            start = time.perf_counter()
            client.sendall(data)
            log(f"Sent {len(data)} bytes")

            try:
                reply = stream.readline()
            except socket.timeout:
                log("ERROR: server did not reply within 10 seconds. Is server.py still running?")
                break
            rtt_ms = (time.perf_counter() - start) * 1000

            if not reply:
                log("Server closed the connection. Is server.py still running?")
                break

            # Reply format: ACK <bytes> <your ip> <your port> <message>
            _, acked, seen_ip, seen_port, echo = reply.decode(errors="replace").rstrip("\n").split(" ", 4)
            log(f"Received {len(reply)} bytes in {rtt_ms:.1f} ms")
            log(f"Server on port {server_port} acknowledged {acked} bytes")
            log(f"Echo: {echo!r}")
            log(f"You see yourself as  {local_ip}:{local_port}")
            log(f"Server sees you as   {seen_ip}:{seen_port}")


def main():
    log("Starting up...")
    log(f"Private IP: {get_private_ip()}")
    log(f"Public IP:  {get_public_ip()}")

    client = connect()
    if client is None:
        return
    with client:
        try:
            chat(client)
        except (ConnectionResetError, BrokenPipeError):
            log("Connection to server was lost. Is server.py still running?")
    log("Disconnected. Goodbye!")


if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        print()
        log("Interrupted. Goodbye!")
