# Lab 12 - Networking & Firewalls

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Linux Network Command Cheat Sheet](#part-1---linux-network-command-cheat-sheet)
- [Part 2 - Network Info](#part-2---network-info)
- [Part 3 - Security](#part-3---security)
- [Part 4 - Socket to Me](#part-4---socket-to-me)
- [Part 5 - It's Alive!  Maybe...](#part-5---its-alive-maybe)
- [Extra Credit - Tattle Tale](#extra-credit---tattle-tale)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab12`.

Create a file named `README.md` in the `Lab12` folder.  The [Lab 12 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab12/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab12/LabTemplate.md`

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

## Part 1 - Linux Network Command Cheat Sheet

The commands below are all Linux commands to show or modify network information.  Provide a brief statement / summary (not a multi-paragraph copy paste) about what each command does **and** find an internet resource that provides a basic guide to what the command does and examples of usage.  You'll be using these commands in other parts of this lab.

| Command                                                | Description | Resource |
|--------------------------------------------------------|-------------|----------|
| `hostname`                                             |             |          |
| `ipconfig` (Powershell)                                   |             |          |
| `ifconfig`                                             |             |          |
| `ip a`                                                 |             |          |
| `route`                                                |             |          |
| `iptables -L`                                          |             |          |
| `Invoke-RestMethod ifconfig.me` (Powershell)              |             |          |
| `curl <IP_or_hostname>`                                |             |          |
| `curl ifconfig.me` OR `curl ipinfo.io`                 |             |          |
| `ping <IP_or_hostname>`                                |             |          |
| `nslookup <IP_or_hostname>`                            |             |          |
| `traceroute <IP_or_hostname>`                          |             |          |
| `nmap -p <IP_or_hostname>`                             |             |          |
| `tcpdump -i <networkinterface> -n host <IP_or_hostname>` |          |          |

## Part 2 - Network Info

Find the following network information for the following systems / networks:
- your host OS on your PC 
- your AWS instance

You may utilize a mix of command line utilities and GUI applications to discover the networking information requested.  You should not need download any additional tools to find this information - you may need to install some network utilities, like `ifconfig` or `nmap`.

**Useful Commands**
- PowerShell on Windows: `hostname`, `ipconfig /all`, `route PRINT`, `Invoke-RequestMethod`
- Linux: `hostname`, `ip a`, `ifconfig`, `route`, `nslookup`, `curl`

For each system and network the system is connected to: 

1. Find and copy into your lab a summary of the device's network settings for a minimum of the network it is connected to.

2. Identify specifically the values of the following fields for the device and network connection to:

| Setting                                           | Value |
|---------------------------------------------------|-------|
| Hostname of the device                            |       |
| MAC address of the NIC                            |       |
| Private IPv4 address                              |       |
| Subnet mask                                        |       |
| Gateway address                                    |       |
| DHCP enabled? (y/n)                                |       |
| DHCP address (if yes)                              |       |
| DNS server address                                 |       |
| Public IPv4 address                                |       |

- Useful Notes:
   - The gateway address is typically the same as your DHCP address
   - Using `nslookup` will tell you the DNS server used to lookup the hostname's IP address
   - For `Public IPv4 address`, look up your public IP (typically from your ISP) - you can literally ask Google what is your IP and / or try out the queries to sites like `ipinfo.io` or `ifconfig.me`.  Since your AWS service needs to be singuarly addressable from external devices (clients), it is leasing a public IP address.
   - These results are going to look boring at home - your router tends to be serving all these network roles. It's more interesting on to view on complex / enterprise networks, like Wright State or Starbucks. 
      - At home you likely have one device (your router) that is the first stop for most requests (DHCP, DNS, and gateway to route traffic to the next stop). 
      - On a complex / enterprise network, you'll see these addresses getting distributed to different devices - there is a device to connect to to request an address and network information (DHCP server), another that is a first stop for DNS resolution, and maybe another that is the gateway address that packets outside the network are forwarded to to find their destination.
   - Public IPv4 addresses are only used when you are trying to send communications outside your local (private) subnet.  The vast majority of networks utilize this scheme of Network Address Translation (NAT).  It allows many devices to be on one network, which then "share" a public IPv4 address when sending packets and receiving communication back from network devices external to your network.

**Resources**
- [How To use the Powershell IPConfig Command and Options Explained - The Lazy Admin](https://lazyadmin.nl/it/ipconfig-command/)
- [Demystifying ifconfig and network interfaces in Linux - Yury Pitsishin](https://codewithyury.com/demystifying-ifconfig-and-network-interfaces-in-linux/)
- [Linux IP Command Explained With Examples - Logic Web](https://www.logicweb.com/knowledge-base/linux-tips/linux-ip-command-explained-with-examples/#3--displaying-ip-addresses)
- [Exploring the Linux ‘ip’ Command - with comparisons against other commands - Cisco Blog](https://blogs.cisco.com/learning/exploring-the-linux-ip-command)

## Part 3 - Security

Your AWS instance is protected by a firewall - the AWS service to configure this firewall is called a *Security Group*.  When you created this stack, it came with a configured Security Group similar to the one in the screenshot below:

![AWS Default Security Group Rules](Default-SGRules.JPG)

Rule 1 is an Inbound / Ingress rule that states as long as the source IP starts with 10.0.0, accept all protocols of communication on any port.

Rule 2 is an Inbound / Ingress rule that states any source IP can communicate with the TCP protocol on any port.

If you break your access to your AWS instance in the exercise below, you can "reset" using this screenshot of rules.

---

Your instance is running two services (assuming you completed Lab 11) - **SSH and Apache HTTP Server**.  

SSH is a protocol and service that enables secure and encrypted communication between two points.  By default, the `ssh` service listens on port `22`.  By `ssh`ing to your instance, you gain access to a shell where you can run commands, or can securely transfer files with `sftp`, or securely copy files with `scp`.  Your firewall should only allow `ssh` connections from *trusted* IP sources.

Apache HTTP server listens on port 80 (by default) for incoming HTTP requests.  After receiving a request, it send the client back the requested resource, if available.  The client then assembles and "displays" the result in an application, such as `curl` or a browser.  Websites (and specifically the servers that serve them) are assumed to be publicly viewable - as long as a client knows the IP or hostname, it can make an HTTP request to the server.

All software, such as SSH and Apache HTTP Server, has vulnerabilities.  For all software we track Common Vulnerabilities and Exposures (CVEs).  
- [SSH CVE reports](https://www.cvedetails.com/vulnerability-list/vendor_id-120/SSH.html)
- [Apache HTTP Server CVE reports](https://www.cvedetails.com/version-list/0/17262/1/)

It is a combination of credentials (identity) and network rules that keep systems safe, and allow people to only access and interact with what they need.

---

Your task is to revise the Inbound / Ingress Security Group Rules for your instance and replace them with rules that 
- restrict access to SSH (port 22) if the source IP is "trusted"
- allow ANY IP to connect to port 80
- allow ANY *OR* only trusted IPs to access port 8080 (setup for Part 4)

Assuming you have hit "Start Lab" and have opened your console via the "AWS" link after the lab has started (timer is counting down), this [link will quick drop you to your Security Groups](https://us-east-1.console.aws.amazon.com/ec2/home?region=us-east-1#SecurityGroups:).  Find the Security Group named **`ceg2350-Lab1SecurityGroup`** (or similar).  Click the checkbox next to that entry or the link in the "Security Group ID" column to focus on only this Security Group.  **Only edit the Inbound Rules**

> If the link doesn't work, the full set of things to click is: go to the the Learner Lab Module -> Click Start Lab -> once started, Click the AWS link (green circle will be next to it).  Click EC2 -> Click Instances Running -> click checkbox next to instance -> in the menu below, click Security, scroll down a little, click the link under Security Groups to hot drop to your rules that go with your instance.  inbound Rules are where you'll be focusing for the lab.

1. Remove the two original rules.  
2. Create a rule that allows SSH access from any WSU IPv4 address, which will be all address from 130.108.0.0 to 130.108.255.255
3. Create a rule that allows SSH access from your home public IPv4 address
   - required even if you live on campus
4. Create a rule that allows HTTP access from any IPv4 address or all accresses from 0.0.0.0 - 255.255.255.255
5. Create a rule (or rules) that allow access to port 8080 from any (or only trusted) IPv4 address
6. Describe why should HTTP allow any IP, while SSH has restrictions?  Your answer should show a reflection on the purpose of these two protocols.
7. Describe how you validated or can validate if your rules are working.

## Part 4 - Socket to Me

Review the following resource to get an overall feel for the difference between ports, sockets, and URLs:
- [Ports, Sockets, and URLs](ports_sockets_url_compare.md)

For this part you'll need two source code files - we have provided Java and Python client and server source code that uses the socket library.

- [Java Client & Server Source Code](https://github.com/pattonsgirl/CEG2350/tree/main/Labs/Lab12/Java)
- [Python Client & Server Source Code](https://github.com/pattonsgirl/CEG2350/tree/main/Labs/Lab12/Python)

Download the source code to your GitHub repository folder - add it for tracking and commit it.

**Create a branch - push this branch to GitHub.  Do not delete the branch after merging**

On this branch:

1. Edit the source code - add comments to help **you** understand what it is doing.  Cite sources that helped you understand.
2. Edit the client side code to refer to your AWS instance using its public IP.
3. Run (compile as well depending on language) the server code on your AWS instance.
4. Run (compile as well depending on language) the client code on your personal system.
5. Send messages to the server from the client.  Add a screenshot to your lab showing the communications between the client and server.
6. Merge your changes to the `main` branch.  Do not delete the branch where you were editing your code.

**Resources**
- [How to Execute and Run Java Code from the Terminal - FreeCodeCamp](https://www.freecodecamp.org/news/how-to-execute-and-run-java-code/)
- [Java Socket Programming - Socket Server, Client example - DigitalOcean](https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client)
- [Socket Programming in Python (Guide) - RealPython](https://realpython.com/python-sockets/)

## Part 5 - It's Alive! Maybe...

Figuring out how to tell if a server is on is one of those MFUS (Most Frequently Used Skills).  Sites like [Down Detector](https://downdetector.com/) are highly informative, but sometimes you need to have other utilities in hand.  The two things we generally ask about servers are: "Is it responding?" and "Is the web page available?".

In this exercise, you will get a set of IPs to test the useful commands on, then a series of questions to guide what I'd like you to understand about them.  You may use external resources, including ChatGPT, to help with your understanding, but you **must cite** your sources, or in the case of generative AI, the prompt used.  You should summarize from resources, not plagiarize.  Your responses should prove how you can validate your answer by testing against the IPs referred to and the commands recommended.

- **Useful Commands:** `ping`, `traceroute`, `nslookup`, `curl`

**Server IPs / Domain Names / URLs**
- `8.8.8.8`
- `5.9.243.187` -> `wttr.in` -> `https://wttr.in`
- Your AWS instance public IP
- `34.117.59.81` -> `ipinfo.io` -> `https://ipinfo.io`

1. What are each of the above, what do they respond to, and what requests do they ignore?
2. Does `ping` tell you if a server is "working"?
3. What protocol does `ping` use?  What does this mean about the server firewalls?
4. Why won't `ping` work if you specify `https://` before the domain name?
5. Does an IP lookup always result in finding the correct domain name / URL to access the resource, and vice versa?
6. What happens at when an `http` request is made to a server with `https` enabled?  

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
