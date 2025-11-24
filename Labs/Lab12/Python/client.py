# echo_client.py
import socket

HOST = "98.89.7.161"
PORT = 8080

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client:
    client.connect((HOST, PORT))
    print("[CLIENT] Connected to server.")

    while True:
        msg = input("Enter message (or 'quit'): ")
        if msg.lower() == "quit":
            break

        client.sendall(msg.encode())
        data = client.recv(1024)

        print(f"[CLIENT] Echoed from server: {data.decode()}")

