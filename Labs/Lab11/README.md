# Lab 11 - NOT FINALIZED

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Network Discovery](#Part-1---Network-Discovery)
- [Part 2 - Network Sniffing](#Part-2---Network-Sniffing)
- [Part 3 - Get Off My Port](#Part-3---Get-Off-My-Port)
- [Extra Credit - Message in a Bottle](#Extra-Credit---Egg-Hunt)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/24167/modules/items/1982401)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab11`

Create a file named `Lab11.md` [based on the template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab11/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - Network Discovery

With your PC (not the AWS instance) connected to a network, identify the following information. I give you permission to use GUIs tools or a terminal on the system (don't use WSL2). You should not download any additional tools.

- **Useful Commands Windows: `ipconfig`, `curl ipinfo.io`**
- **Useful Commands Linux / Mac(?): `ip a`, `curl ipinfo.io`**

1. Hostname of the device:
2. MAC address of the NIC connected to the network:
3. IP address:
4. Subnet mask:
5. Gateway address:
6. DHCP server address:
7. DNS server address:
8. Public IP used for communications outside subnet:

- Note: These results are going to look boring at home, but interesting on more complex networks, like Wright State. At home you likely have one device (your router) that is the first stop for most requests (DHCP, DNS, and gateway to route traffic to the next stop). On a complex network, you'll see these addresses getting distributed to different devices - there is a device to connect to to request an address and network information (DHCP server), another that is a first stop for DNS resolution, and maybe another that is the gateway address that packets outside the network are forwarded to to find their destination.

## Part 2 - Network Sniffing

## Part 3 - Get Off My Port

Use your AWS instance for this part. A common issue is that a port you want to listen on (run a service on) is already taken by another service / process. Let's use one (of many) ways to find out what service is running and how to kill it.

- **Useful Commands: `apt`, `python3`, `pip3`, `curl`, `lsof`, `|`, `grep`, `kill`**

1. On your AWS instance, install `python3` and `pip3`, and copy the [index.html](index.html) file to your Lab 11 folder.
2. Run `python3 -m http.server 9000` to start a minimal web server listening on port `9000`. Leave this running in it's own terminal.
3. Provide commands to confirm the following:
   - Content is served using `localhost`:
   - Content is served using the system's private IP:
   - Content is served using the system's public IP:
4. What video is embedded / linked on the page, and how did you find out?
5. In another terminal, use `lsof` to show only the `LISTEN`ing services on the system.
6. Identify the process ID and `kill` the process.

## Extra Credit - Egg Hunt

For this part, I have configured a server to toy with for this part. The server's IP address is `3.228.104.170`

- **Useful Commands: `nslookup`,`nmap`, `nc`**

1. Does `IP` have a hostname?
2. Scan `IP` for open ports. Identify which ports are open.
3. One of the server ports is hosting a webpage. How can you view the webpage?
   - It's easiest to play with this in your web browser, but `curl` is a fun command to try.
4. Find out what version of SSH is running on `IP`.

- Resources:

- [nmap service and version detection](https://nmap.org/book/man-version-detection.html)

## Submission

1. Verify that your GitHub repo has a `Lab11` folder with at minimum:

   - `Lab11.md`

2. In the Pilot Dropbox, paste the URL to the `Lab11` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab11

## Rubric

- 1 pt per question (16 pts total)
- EC 10% (1.6 pts)
