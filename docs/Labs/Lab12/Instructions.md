# Lab 12 - Networking & Firewalls

- [General Instructions](#general-instructions)
- [Lab Procedure](#lab-procedure)
- [Part 1 - Networking Basics](#part-1---networking-basics)
- [Part 2 - Security](#part-2---security)
- [Part 3 - Socket Programming](#part-3---socket-programming)
- [Part 4 - Server Testing](#part-4---server-testing)
- [Part 5 - Citations / Resources](#part-5---citations--resources)
- [Extra Credit - Tattle Tale](#extra-credit---tattle-tale)
- [Submission](#submission)
- [Rubric](#rubric)
- [Resources](#resources)

## General Instructions

- You may refer to additional resources outside of the recommended ones provided. Cite any resource that contributes to your understanding in the `Citations` section of your lab answers, including the site and a summary of its assistance. If generative AI was used, include the system and prompts.
- If you make mistakes with commands, note them! Writing down what went wrong and the correction will help your learning. If stuck, this aids TAs in understanding where you may have misunderstood or misconfigured a core step.

## Lab Procedure

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab12`.

Create a file named `README.md` in the `Lab12` folder. The [Lab 12 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab12/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab12/LabTemplate.md`

## Part 1 - Networking Basics

### Linux Network Command Cheat Sheet

The commands below are essential for gathering network information or network testing. Provide a brief statement / summary (**not a multi-paragraph copy paste**) about what each command does **and** find an internet resource that provides a basic guide to what the command does and examples of usage.

| Command                                                | Description | Resource |
|--------------------------------------------------------|-------------|----------|
| `hostname`                                             |             |          |
| `ipconfig` (Powershell)                                |             |          |
| `ifconfig`                                             |             |          |
| `ip a`                                                 |             |          |
| `route`                                                |             |          |
| `iptables -L`                                          |             |          |
| `Invoke-RestMethod ifconfig.me` (Powershell)           |             |          |
| `curl <IP_or_hostname>`                                |             |          |
| `curl ifconfig.me` OR `curl ipinfo.io`                 |             |          |
| `ping <IP_or_hostname>`                                |             |          |
| `nslookup <IP_or_hostname>`                            |             |          |
| `traceroute <IP_or_hostname>`                          |             |          |
| `tracert <IP_or_hostname>` (Powershell)                |             |          |
| `netstat -an \| grep ESTABLISHED`                       |             |          |
| `nmap -p <IP_or_hostname>`                             |             |          |
| `tcpdump -i <networkinterface> -n host <IP_or_hostname>` |          |          |

### Network Info

Find network information for the following systems using the commands and resources from above:
- your host OS on your PC 
- your AWS instance
   - Note: you may need to install the appropriate network utilities to use commands like `ifconfig`

Only complete this for the internet accessible network the system is connected to:
- usually `eth0` for your AWS instance 
- usually `Wireless LAN adapter Wi-Fi` for your laptop

For each system: 

1. Use a command to identify the system's network information. Copy the output into your lab writeup.

2. Use the network info and other commands to fill in the following table for the system's network information:

| Setting                                           | Value |
|---------------------------------------------------|-------|
| Hostname of the device                            |       |
| MAC address of the NIC                            |       |
| Private IPv4 address                              |       |
| Subnet mask                                       |       |
| Gateway address                                   |       |
| DHCP address (if enabled)                         |       |
| DNS server address                                |       |
| Public IPv4 address                               |       |

**Useful Notes**
- At home, the gateway address is typically the same as your DHCP address. It basically says, "use the router for all of it".
- Use `nslookup` to find the DNS server for hostname lookups. At home this may be your ISP DNS server, sometimes it is just the router IP again.
- To resolve the public IPv4 you are using from your ISP, check sites like `ipinfo.io` or `ifconfig.me`. AWS instances have public IPs associated with them.

**Resources** on parsing `ipconfig`, `ifconfig` / `ip` output:
- [How To use the Powershell IPConfig Command and Options Explained - The Lazy Admin](https://lazyadmin.nl/it/ipconfig-command/)
- [Demystifying ifconfig and network interfaces in Linux - Yury Pitsishin](https://codewithyury.com/demystifying-ifconfig-and-network-interfaces-in-linux/)
- [Linux IP Command Explained With Examples - Logic Web](https://www.logicweb.com/knowledge-base/linux-tips/linux-ip-command-explained-with-examples/#3--displaying-ip-addresses)
- [Exploring the Linux 'ip' Command - with comparisons against other commands - Cisco Blog](https://blogs.cisco.com/learning/exploring-the-linux-ip-command)


## Part 2 - Security

Your AWS instance is protected by a firewall via an AWS tool called Security Groups. The default rules created allow broad access (e.g., any IP on any port).

![Default Security Group Rules](Default-SGRules.JPG)

Your instance runs SSH (port 22) and Apache HTTP Server (port 80). In Part 3, you'll play with running a program that listens on another port - 8080. 
- SSH enables secure shell access - access to use this service should be limited to trusted network devices or devices on trusted networks
- Apache serves web content - typically is you host a webpage you want the world (any network device) to be able to request to view the content

Revise Inbound Rules in Security Group `ceg2350-Lab1SecurityGroup`:
- Remove original rules.
- Allow SSH from WSU IPs (130.108.0.0/16).
- Allow SSH from your home public IP
   - Hint: remember how to view query for your public IP from Part 1
- Allow HTTP (port 80) from any IP.
- Allow port 8080 from any (or trusted) IPs.

**AWS Navigation**:
- Start Lab, open AWS console.
- Go to EC2 > Security Groups > Select `ceg2350-Lab1SecurityGroup`.
- Edit Inbound Rules only.

1. Remove the two default rules.  
2. Create a rule that allows SSH access from any WSU IPv4 addresses - 130.108.0.0/16
   - 130.108.0.0/16 = all IPs in range 130.108.0.0 to 130.108.255.255
3. Create a rule that allows SSH access from your home public IPv4 address
   - required even if you live on campus
4. Create a rule that allows HTTP access from any IPv4 address or all addresses from 0.0.0.0 - 255.255.255.255
5. Create a rule (or rules) that allow access to port 8080 from any (or only trusted) IPv4 address
6. Describe how you validated your rules are working.
   - When doing security testing, a base a validation testing is:
      - Something expected to work
      - Something expected to **not** work

If you break access - can no longer `ssh` to your instance - take a screenshot of your rules so you can get assistance, "reset" to default rules shown in the image and try again.

## Part 3 - Socket Programming

Review the following resource to get an overall feel for the difference between ports, sockets, and URLs:
- [Ports, Sockets, and URLs](ports_sockets_url_compare.md)

We have provided tar archives of Java and Python client and server source code that uses the socket library.

- [Java Client & Server Source Code](https://github.com/pattonsgirl/CEG2350/tree/main/Labs/Lab12/Echo-Java.tar.gz)
- [Python Client & Server Source Code](https://github.com/pattonsgirl/CEG2350/tree/main/Labs/Lab12/Echo-Python.tar.gz)

Download and extract the tar archive of choice to your GitHub repository folder in `Lab12`.

1. Make a commit of the original source code files
2. Edit the both the client and server source code files - add comments to help **you** understand what it is doing. Commit and push your changes. 
   - Cite sources that helped you understand by adding them to the comments or to your citations section.
3. Edit the client side code to use your AWS Instance's public IP as the `host`. Commit and push your changes.
4. Run (compile as well depending on language) the server code on your AWS instance.
5. Run (compile as well depending on language) the client code on your personal system - laptop / desktop / virtual machine.
6. Send messages to the server from the client.  Add a screenshot(s) to your lab showing the communications between the client and server.

**Resources**
- [How to Execute and Run Java Code from the Terminal - FreeCodeCamp](https://www.freecodecamp.org/news/how-to-execute-and-run-java-code/)
- [Java Socket Programming - Socket Server, Client example - DigitalOcean](https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client)
- [Socket Programming in Python (Guide) - RealPython](https://realpython.com/python-sockets/)

## Part 4 - Server Testing

The two things we generally ask about servers are: "Is it responding?" and "Is the service available?".

In this exercise, you will run a test suite of commands against each IP / URL in the table below, document your findings in a results table, and answer reflection questions based on what you discover.

### Test Servers

| Server IPs | Domain Names | URLs  |
| ---       | ---          | ---    |
| `8.8.8.8` |  `dns.google` |        |
| `5.9.243.187` | `wttr.in` | `https://wttr.in` |
| Your AWS instance public IP |     |     |
| `34.117.59.81` | `ipinfo.io` | `https://ipinfo.io` |

### Test Suite

Run the following commands against **each IP / domain name / url** as appropriate in the table above. Document the result (output, error, or behavior) in the Results Table.

| Test | Command | What to observe |
| ---  | ---     | ---             |
| ICMP Reachability  | `ping -c 10 <IP / Domain Name>`            | Does the server respond? |
| HTTP Request       | `curl -v http://<IP / Domain Name>`  | Response code, headers, content |
| HTTPS Request      | `curl -v https://<IP / Domain Name>` | Response code, SSL errors, redirects |
| Forward DNS Lookup | `nslookup <Domain Name>`                   | Does it resolve to one or more IPs?   |
| Reverse DNS Lookup | `nslookup <IP>`                            | Does it resolve to a domain name?     |

### Reflection questions:

1. **ICMP and Firewalls**: Why do some IPs not respond to `ping` even though they have active services running? What does this tell you about their firewall configuration?

2. **HTTP vs HTTPS**: Using `wttr.in`, compare the results when you `curl -v http://<IP / Domain Name>` versus `curl -v https://<IP / Domain Name>` for the same server. What differences did you observe? Why?

3. **Raw Packet Capture**: In a new tab, but on the same system you are using to run the `curl` commands, run a raw packet viewer for `wttr.in`: `sudo tcpdump -i any -nn -A port 80 or port 443 and host <IP / Domain Name>`. In another tab, `curl` using `http` and `https`, watching the packet dump after each `curl` request. Why can you "read" the weather info from the `http` request but not the `https` request?

4. **DNS Lookup**: When using `nslookup`, which IPs resolved to domain names and which domain names resolved to IPs? Why might this matter?

5. **Real-World Application**: How would you use these commands if someone reported "the server is down"? What would be your troubleshooting strategy?  

## Part 5 - Citations and Resources

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations / Resources` section of your lab answers. You may refer to your own notes (if they are digitized into GitHub), course notes, or external resources / websites.

To add citations / resources, provide the reference / link and a summary of what it assisted you with.  

If generative AI was used, include which generative AI system was used, what prompt(s) you fed it, and a summary of what it assisted you with.

Since the networking command table and the socket program already asked for resources, you only need to cite additional resources used in completing the other lab taskings.

## Extra Credit - Tattle Tale

[auth_logs.csv](auth_logs.csv) is a cleaned up version of standard SSH logs, and contains only the username used in the connection attempt and the IPv4 address the attempt came from.  Take the provided data and give me 2 reports:
- the top 5 IP addresses that generated connection attempts and how many attempts they made
- the top 5 usernames used and how many times they were used

Your reports must contain the set of commands used to create the reports.

- Note: if you are curious about how I parsed `auth.log` to generate the `csv` file, you can [check out my documentation here](https://github.com/pattonsgirl/api-projects/tree/main/ip-mapper/data) - there are likely prettier ways to do it.

## Submission

1. Verify that your GitHub repo has a `Lab12` folder with at minimum:

   - `README.md`
   - Java or python client code with comments / corrected IP ref
   - Java or python server code with comments

2. In the Pilot Dropbox, paste the URL to the `Lab12` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab12

## Rubric

Your files should be cleanly presented in your GitHub repository.  Citations should be included as needed.  Include which generative AI system was used and what prompts were used if generative AI was used.

[Rubric](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab12/Rubric.md)

## Additional Resources

### Code to use sockets
- [How to Execute and Run Java Code from the Terminal - FreeCodeCamp](https://www.freecodecamp.org/news/how-to-execute-and-run-java-code/)
- [Java Socket Programming - Socket Server, Client example - DigitalOcean](https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client)
- [Socket Programming in Python (Guide) - RealPython](https://realpython.com/python-sockets/)

### Network Admin Toolkit
- [Down Detector](https://downdetector.com/)
