# Lab 10

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Network Discovery](#Part-1---Network-Discovery)
- [Part 2 - Network Sniffing](#Part-2---Network-Sniffing)
- [Part 3 - Get Off My Port](#Part-3---Get-Off-My-Port)
- [Extra Credit - Message in a Bottle](#Extra-Credit---Message-in-a-Bottle)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/13249/modules/items/1136419)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab10`

Create a file named `Lab10.md` [based on the template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab10/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - Network Discovery

With your PC (not the AWS instance) connected to a network, identify the following information. I give you permission to use GUIs tools or a terminal on the system (don't use WSL2). You should not download any additional tools.

1. The hostname:
2. The IP address:
3. The MAC address using that IP address:
4. The subnet mask:
5. The gateway address:
6. The DHCP server address:
7. The DNS server address:
8. Identify the route your outbound packets go through in order to access the Internet through your ISP.
   - Useful commands: `traceroute` / `tracert`, `route`

- Note: These results are going to look boring at home, but interesting on more complex networks, like Wright State. At home you likely have one device (your router) that is the first stop for most requests (DHCP, DNS, and gateway to route traffic to the next stop). On a complex network, you'll see these addresses getting distributed to different devices - there is a device to connect to to request an address and network information (DHCP server), another that is a first stop for DNS resolution, and maybe another that is the gateway address that packets outside the network are forwarded to to find their destination.

## Part 2 - Network Sniffing

For this part, I have configured a server to toy with for this part. The server's IP address is `3.228.104.170`

- **Useful Commands: `nslookup`,`nmap`, `nc`**

1. Does `3.228.104.170` have a hostname?
2. Scan `3.228.104.170` for open ports. Identify which ports are open.
3. One of the server ports is hosting a webpage. How can you view the webpage?
   - It's easiest to play with this in your web browser, but `curl` is a fun command to try.
4. Find out what version of SSH is running on `3.228.104.170`.

- Resources:

- [nmap service and version detection](https://nmap.org/book/man-version-detection.html)


## Part 3 - Get Off My Port

A common issue is that a port you want to listen on (run a service on) is already taken by another service / process. Let's use one (of many) ways to find out what service is running and how to kill it. Perform the following on your AWS instance unless otherwise specified.

1. On your AWS instance, install `python3` and `pip3`
2. Run `python3 -m http.server 9000` to start a minimal web server listening on port `9000`. Leave this running in it's own terminal.
   - If this is still running from Part 2, you don't need to do it again - but you would get the exact error we are trying to hunt down! A service is already bound to that port, and you can't run something else there until the first one terminates
3. In another terminal, use `lsof` to show only the LISTEN[ing] services on the system.
   - Useful commands: `lsof`, `|`, `grep`
4. Identify the process ID and `kill` the process.

## Extra Credit - Message in a Bottle

Use `nc` (netcat) to create a simple chat server that listens and can be connected to on port 2222. You should be able to use the server's public ip to connect and chat.

Depending on what you did for part 3, your firewall may need patching to open this port externally.

Proof is documentation on what commands create, how to connect, and any changes you needed to make to your firewall.

- Hint:
- [Netcat nc command with examples](https://linuxize.com/post/netcat-nc-command-with-examples/)

## Submission

1. Verify that your GitHub repo has a `Lab10` folder with at minimum:

   - `Lab10.md`

2. In the Pilot Dropbox, paste the URL to the `Lab10` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab10

## Rubric

- 1 pt per question (16 pts total)
- EC 10% (1.6 pts)
