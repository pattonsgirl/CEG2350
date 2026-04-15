
## 1. Physical & Local Identity
Before we send a packet, we need to know who we are on the local network.

* **Command:** `ip addr` (Linux) or `ipconfig` (Windows)
* **The Lesson:** This displays your **Local IP** and your **MAC Address**.
* **Packet Context:** This is the "Source IP" that will be stamped on every packet you send.

---

## 2. The Decision: Routing Table
The computer looks at the destination (Google) and asks: "Is this in my house, or do I need to go to the Gateway?"

* **Command:** `netstat -rn` (macOS/Linux) or `route print` (Windows)
* **The Lesson:** The **Default Gateway** (usually `0.0.0.0`) tells your computer to send anything it doesn't recognize to the router.



---

## 3. The Handshake: ARP Table
To send a packet to the router, your computer needs the router's hardware ID (MAC address).

* **Command:** `arp -a`
* **The Lesson:** This maps the Router's IP to its physical hardware address. Without this, your Wi-Fi card doesn't know which physical device to "talk" to.

---

## 4. Addressing: DNS Lookup
* **Command:** `nslookup google.com`
* **The Lesson:** We get the **Destination IP**. We now have the two main pieces of the "envelope": Source IP (Me) and Destination IP (Google).

---

## 5. Packet Formation: Sockets and Ports
This is where we define the **Source Port** and **Destination Port**.

* **Command:** `netstat -an | grep ESTABLISHED` (Run this *while* you have a website open)
* **The Lesson:** A packet isn't just IPs; it needs ports to reach the right app.
    * **Server Port (Destination):** For Google (HTTPS), this is almost always **443**.
    * **Client Port (Source):** Your computer picks a random high-number port (e.g., **54321**). This allows your computer to know that the reply from Google belongs to *this* specific browser tab and not your Spotify app.



---

## 6. Mapping the Path: Traceroute
* **Command:** `traceroute google.com`
* **The Lesson:** Watch the packet travel through the "Gateways" of the world.

---

## 7. The Full Conversation: Curl
* **Command:** `curl -v https://www.google.com`
* **The Lesson:** Look closely at the output. You will see:
    * `* Connecting to www.google.com (142.250.190.46) port 443 (#0)`
    * This shows the **Full Socket**: `[Your_IP]:[Random_Port] -> [Google_IP]:443`.

---

### The "Anatomy of a Packet" Summary
When your students run these commands, they are seeing how this "envelope" is built:

| Packet Part | Value Example | Command to Find It |
| :--- | :--- | :--- |
| **Source MAC** | `a1:b2:c3:d4:e5:f6` | `ip addr` |
| **Source IP** | `192.168.1.15` | `ip addr` |
| **Source Port** | `58293` (Random) | `netstat` |
| **Dest. Port** | `443` (Web/HTTPS) | `curl -v` |
| **Dest. IP** | `142.250.190.46` | `nslookup` |
| **Dest. MAC** | `z9:y8:x7:w6:v5:u4` | `arp -a` |
