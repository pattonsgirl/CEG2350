# Lab 11 - NOT FINALIZED

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Network Discovery](#Part-1---Network-Discovery)
- [Part 2 - Packet Capture](#Part-2---Packet-Capture)
- [Part 3 - Get Off My Port](#Part-3---Get-Off-My-Port)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/36184/modules/items/3080473)

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

- Note: These results are going to look boring at home, but interesting on more complex networks, like Wright State or Starbucks.  While you are welcome to do this using your home network, play with these commands on other networks as well. At home you likely have one device (your router) that is the first stop for most requests (DHCP, DNS, and gateway to route traffic to the next stop). On a complex network, you'll see these addresses getting distributed to different devices - there is a device to connect to to request an address and network information (DHCP server), another that is a first stop for DNS resolution, and maybe another that is the gateway address that packets outside the network are forwarded to to find their destination.

## Part 2 - Packet Capture

Use your AWS instance for this part. For these some exercises, you'll need to create two `ssh` connections to your AWS instance (like you did for the processes lab).

`tcpdump` is a command line utility that allows you to capture and analyze network traffic going through your system.  Mind you, this is network traffic - **packets**. in your browser, you see web content that is assembled from packets.  For this lab, you will craft a `tcpdump` command to analyze traffic over the AWS instance's network interface and apply filters so that you can focus on traffic going to / from specific hosts.

`curl` (`cURL`) stands for client URL, is a command line tool that developers use to transfer data to and from a server.  Since your AWS instance does not have a browser, `curl` is a command that will let you request data from a host and see the raw html that is returned.  
   - You can "verify" what you see as output from `curl` by going to your browser, going to a webpage, right clicking, and selecting view source. 

- **Useful Commands: `tcpdump`, `curl`**

1. Run `tcpdump` on all interfaces for about 30 seconds, then use `Ctrl+C` to stop.

   - How many packets were captured?
   - Looking through the output, what traffic are you seeing?
      - Hint: reflect on the network information you gathered above, and think about `ssh`

2. Craft a `tcpdump` that focuses on interface `eth0` and traffic to and from `host` `www.google.com` - print each packet in ASCII.  When you think you have it, leave the `tcpcump` command running in one tab.
   - What we are filtering is any traffic related to `host` `www.google.com` - this does not specify a protocol.  `HTTP` & `HTTPS` are examples of protocols that the host is configured to respond to.

3. In another terminal (also connected to your AWS instance) create one packet dump by using `curl` on `http://www.google.com` and look at the traffic captured by `tcpdump`. Create a second capture by using `curl` on `https://www.google.com`.
   - Was there a difference in output from `curl` when using `http` or `https`?
   - Was there a difference in packet content in `tcpdump` when using `http` or `https`?
   - What caused the difference?

4. Craft a capture you find interesting, and save the capture to a file (do not use output redirection - using `tcpdump` options). What command will read the capture? `commit` and `push` your capture to your `Lab11` folder.
   - it can be to another host, or a different filter, explore a bit.

- **Resources:**
  - [hackertarget - tcpdump examples](https://hackertarget.com/tcpdump-examples/)
  - [Geek Diary - 18 Practical tcpdump Command Examples](https://www.thegeekdiary.com/18-practical-tcpdump-command-examples-a-network-sniffer-tool-primer/)
  - [Cloudflare - HTTP vs HTTPS](https://www.cloudflare.com/learning/ssl/why-is-http-not-secure/)

## Part 3 - Get Off My Port

Use your AWS instance for this part. A common issue is that a port you want to listen on (run a service on) is already taken by another service / process. Let's use one (of many) ways to find out what service is running and kill it.

`python3` has a ton of neat libraries - one of them is `http.server`.  What this does is starts a minimal web server that (by default) hosts content in the current directory.  We are doing this to cheat a little - you would normally install `nginx` or `apache2` to host web content.
   - Note: in case you don't know much about web servers, they look for and serve `index.html` files in a folder first.

- **Useful Commands: `apt`, `python3`, `pip3`, `ip a`, `curl ipinfo.io`, `curl`, `lsof`, `|`, `grep`, `kill`**

1. On your AWS instance, install `python3` and `pip3`, and copy the [index.html](index.html) file to your Lab 11 folder.
2. From your Lab 11 folder, run `python3 -m http.server 9000` to start a minimal web server listening on port `9000`. Leave this running in it's own terminal.
3. Provide commands to confirm the following:
   - Content is served using `localhost`:
   - Content is served using the system's private IP:
   - Content is served using the system's public IP:
4. What video is embedded / linked on the page, and how did you find out?
5. In another terminal, use `lsof` to show only the `LISTEN`ing services on the system.
6. Identify the process ID and `kill` the process.

## Submission

1. Verify that your GitHub repo has a `Lab11` folder with at minimum:

   - your `tcpdump` capture
   - `Lab11.md`
   - `index.html` (optional)

2. In the Pilot Dropbox, paste the URL to the `Lab11` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab11

## Rubric

- 1 pt per question (16 pts total)
