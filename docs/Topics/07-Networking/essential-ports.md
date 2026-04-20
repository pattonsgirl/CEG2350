This collection moves from "how the internet works" to "how a machine manages its doors and windows." To really explain **Sockets**, you need to show the binding of an IP address to a port, and how a Firewall decides whether to let a guest through that door.

For every **Server Port** (like 80 or 443), there is a **Client Port** (usually a high number like 52431). The server "listens" on a fixed port, but the client uses a temporary (ephemeral) port to receive the reply.

--- 

## 0. Core Ports

HTTPS - 443
HTTP - 80
SSH - 22 

[Wiki - Ports and expected protocols](https://en.wikipedia.org/wiki/List_of_TCP_and_UDP_port_numbers)

---

## 1. Finding Open "Doors": netstat & ss
See what services are currently "listening" for a connection on their machine.

* **Command:** `ss -tunlp` (Linux) or `netstat -an | grep LISTEN` (macOS/Windows)
* **The Lesson:** This shows the **Socket**. A socket is the combination of an **IP Address + Port**. 
* **What to look for:** The `0.0.0.0:80` or `127.0.0.1:22`. Explain that `0.0.0.0` means the door is open to the *entire world*, while `127.0.0.1` means it’s only open to the *machine itself*.

---

## 2. Who Owns the Door? lsof
"What program is actually using that port?"

* **Command:** `sudo lsof -i :[PORT_NUMBER]` (e.g., `sudo lsof -i :443`)
* **The Lesson:** This connects a **Network Port** to a **Process ID (PID)**. It proves that a port isn't just a number; it is a direct line to a specific piece of software (like Chrome, Zoom, or Spotify).

---

## 3. Creating a Socket: Netcat (nc)
`nc` can be used as a dummy version of Lab 12's Echo program - open a port on the server, connect to it with the client.

* **The Demo:** 1.  **Student A (The Server):** Runs `nc -l 9999` (This "opens" port 9999).
    2.  **Student B (The Client):** Runs `nc [Student_A_IP] 9999`.
* **The Lesson:** They can now type back and forth. This is a raw TCP socket connection. If they run `netstat` while this is active, they will see the connection state change from `LISTEN` to `ESTABLISHED`.

---

## 4. The External View: Nmap (The Scanner)
**DO NOT USE `nmap` UNLESS YOU ARE THE SERVER OWNER**

Now, look at the machine from the perspective of an outsider (or an attacker).

* **Command:** `nmap -sT localhost` or `nmap [Target_IP]`
* **The Lesson:** This demonstrates how a scanner "knocks" on every door to see which ones are open, closed, or filtered.
* **Key Concept:** **Stealth.** Show them `nmap -sS` (SYN scan), which knocks but hangs up before the handshake completes to avoid being logged.

### Nmap Version Scanning
A standard scan (SYN scan) just looks for a "handshake" response. A Version Scan goes further: it sends specific "probes" to the open port to see how the service responds, then matches that fingerprint against a database of thousands of known services.

* **Command:** `nmap -sV localhost` or `nmap -sV [Target_IP]`
* **The Lesson:** This moves from Port Discovery to Service Enumeration.
** What to look for:** Instead of just seeing 80/tcp open http, you might see 80/tcp open http Apache httpd 2.4.41 ((Ubuntu)).

---

## 5. The Guard: Firewall Interaction


To show how a firewall (like `ufw` on Linux or `iptables` or AWS Security Groups) affects these commands, block the port you opened with `nc`.

- [Configuring AWS Security Groups](https://docs.aws.amazon.com/vpc/latest/userguide/working-with-security-group-rules.html)
- [UFW Essentials: Common Firewall Rules and Commands for Linux Security](https://www.digitalocean.com/community/tutorials/ufw-essentials-common-firewall-rules-and-commands)
    - `sudo ufw deny 9999`
- [Iptables Essentials: Common Firewall Rules and Commands](https://www.digitalocean.com/community/tutorials/iptables-essentials-common-firewall-rules-and-commands)
    - `sudo iptables -A INPUT -p tcp --dport 9999 -j DROP`

**Warning** Before messing with system level rules like `ufw` or `iptables`, add rules you *currently need* for access. For example, if using `ufw`, be sure to explicitly add a rule for ssh access from your public ip before enabling other rules. Security Groups can be changed anytime. If you modify a system (instance's) firewall rules they are in place right away - no oopsies button.

* **Configure:** In the security Groups, add Inbound Rules for only SSH and the `nc` port 
* **The Action:** Try the Netcat connection again. 
* **The Lesson:** The port might be "Open" on the application side, but if the Firewall is "Filtering" it, the packet is dropped before it ever reaches the software. 
* **The Nmap result:** Run Nmap again; the port status will change from `open` to `filtered`.

---

### The "Security Stack" Summary

| Level | Tool | Question it Answers |
| :--- | :--- | :--- |
| **Active Sockets** | `ss` / `netstat` | Which ports are currently waiting for a connection? |
| **Ownership** | `lsof` | Which specific app (PID) is sitting behind that port? |
| **Creation** | `nc` | How do I manually open a port to send/receive data? |
| **Observation** | `nmap` | What does my "house" look like to a stranger on the street? |
| **Defense** | `ufw` / `iptables` | How do I block a port even if an app wants it open? |

