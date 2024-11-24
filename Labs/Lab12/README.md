# Lab 12

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Linux Network Command Cheat Sheet](#part-1---linux-network-command-cheat-sheet)
- [Part 2 - Network Info](#part-2---network-info)
- [Part 3 - Subnet Translation](#part-3---subnet-translation)
- [Part 4 - Security](#part-4---security)
- [Part 5 - It's Alive!  Maybe...](#part-5---its-alive-maybe)
- [Extra Credit - Tattle Tale](#extra-credit---tattle-tale)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/68834/modules/items/6128516)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

**Create a new directory, `Lab12`**

Write answers in `Lab12.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab12/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - Linux Network Command Cheat Sheet

The commands below are all Linux commands to show or modify network information.  Provide a brief statement / summary (not a multi-paragraph copy paste :wink:) about what each command does **and** find an internet resource that provides a basic guide to what the command does and examples of usage.  You'll be using these commands in other parts of this lab.

- `hostname`
- `ifconfig`
- `ip a`
- `route`
- `iptables -L`
- `curl <IP_or_hostname>`
- `ping <IP_or_hostname>`
- `nslookup <IP_or_hostname>`
- `traceroute <IP_or_hostname>`
- `nmap -p <IP_or_hostname>`
- `tcpdump -i <networkinterface> -n host <IP_or_hostname>`

## Part 2 - Network Info

For your PC and for your AWS instance, find the following network information.  You may utilize a mix of command line utilities and GUI applications to determine the networking information requested.

The point is to find networking info using two different OSes to explore the different utilities (Windows and Linux OR Mac and Linux).  If you do not have access to a non-Linux OS you can use the laptops or desktops provided in the lab rooms or in Russ 152 B & D. 

You should not download any additional tools to find this information (despite what online articles may request).

- **Useful Commands - PowerShell on Windows:** `ipconfig \all`, `route PRINT`, 

1. Hostname of the device:
2. MAC address of the NIC connected to the network:
3. IPv4 address:
4. Subnet mask:
5. Gateway address:
6. Does the device use DHCP to receive a network address? (y/n):
7. DNS server address:
8. Public IPv4 address:

- Notes: 
   - These results are going to look boring at home, but interesting on more complex networks, like Wright State or Starbucks.  While you are welcome to do this using your home network, play with these commands on other networks as well. At home you likely have one device (your router) that is the first stop for most requests (DHCP, DNS, and gateway to route traffic to the next stop). On a complex network, you'll see these addresses getting distributed to different devices - there is a device to connect to to request an address and network information (DHCP server), another that is a first stop for DNS resolution, and maybe another that is the gateway address that packets outside the network are forwarded to to find their destination.
   - Public IPv4 addresses are only used when you are trying to send communications outside your local (private) subnet.  The vast majority of networks utilize this scheme of Network Address Translation (NAT).  It allows many devices to be on one network, which then "share" a public IPv4 address when sending packets and receiving communication back from network devices external to your network.

## Part 3 - Subnet Translation

The notation of ranges to define a subnet is an important skill.  Your task is to practice on some easy ones.  The below steps are, in general, how to break this down:

Example task: Write CIDR notation subnet given range 10.0.0.0 - 10.0.1.255
   1. Translate addresses to binary
   2. Set 1's for the matching bits until there is a mismatch - these are the network bits. Remaining bits are 0's - these are the host bits
   3. Add up the total number of 1's

|                          |                                      |
| ------------------------ | ------------------------------------ |
| 10.0.0.0                 | 00001010.00000000.00000000.000000000 |
| 10.0.1.255               | 00001010.00000000.00000001.111111111 |
| 1's match (network bits) | 11111111.11111111.11111110.00000000  |
| Subnet mask (base 10)    | 255.255.254.0                        |
| CIDR                     | /23                                  |
| Final form:              | 10.0.0.0/23 OR 10.0.1.0/23           |

**Resources**
- [CCExpert - Using Prefixes to Represent a Subnet Mask](https://www.ccexpert.us/network-design/using-prefixes-to-represent-a-subnet-mask.html)
- [Subnet Calculator](https://www.davidc.net/sites/default/subnets/subnets.html)

Translate the below CIDR blocks to their IP ranges:
1. `130.108.0.0/16`
2. `34.117.59.81/32`
3. `10.25.121.90/8`

Translate the below IP ranges to their CIDR notation subnets:
1. `172.18.5.0 - 172.18.5.255`
2. `5.9.243.187 - 5.9.243.187`
3. `192.168.0.0 - 192.168.1.255`

## Part 4 - Security

Your AWS instance has a rule one okay rule, and one generally bad rule.  Specifically, they look like this:
![AWS Default Security Group Rules](Default-SGRules.JPG)

Rule 1 is an Inbound / Ingress rule that states as long as the source IP starts with 10.0.0, accept all protocols of communication on any port.

Rule 2 is an Inbound / Ingress rule that states any source IP can communicate with the TCP protocol on any port.

If you break your access to your AWS instance in the exercise below, you can "reset" using this screenshot of rules.

Let's discuss what we have.  Your instance is running two services (assuming you completed Lab 11) - **SSH and Apache HTTP Server**.  

SSH is a protocol and service that enables secure and encrypted communication between two points.  By `ssh`ing to your instance, you gain access to a shell where you can run commands.  Your instance should only allow `ssh` connections from *trusted* IP sources.

Apache HTTP server listens on port 80 (by default) for incoming HTTP requests.  After receiving a request, it send the client back the requested resource, if available.  The client then assembles and "displays" the result in an application, such as `curl` or a browser.  Websites (and specifically the servers that serve them) are assumed to be publicly viewable - as long as a client knows the IP or hostname, it can make an HTTP request to the server.

All software, such as SSH and Apache HTTP Server, has vulnerabilities.  For all software we track Common Vulnerabilities and Exposures (CVEs).  
- [SSH CVE reports](https://www.cvedetails.com/vulnerability-list/vendor_id-120/SSH.html)
- [Apache HTTP Server CVE reports](https://www.cvedetails.com/version-list/0/17262/1/)

It is a combination of credentials (identity) and network rules that keep systems safe, and allow people to only access what they need.

Your task is to revise the Inbound / Ingress Security Group Rules for your instance and replace them with rules that set more appropriate restrictions.  

Assuming you have hit "Start Lab" and have opened your console via the "AWS" link after the lab has started (timer is counting down), this [link will quick drop you to your Security Groups](https://us-east-1.console.aws.amazon.com/ec2/home?region=us-east-1#SecurityGroups:).  Find the Security Group named **`ceg2350-Lab1SecurityGroup`** (or similar).  Click the checkbox next to that entry or the link in the "Security Group ID" column to focus on only this Security Group.  **Only edit the Inbound Rules**

>[!TIP]
>If the link doesn't work, the full set of things to click is: go to the the Learner Lab Module -> Click Start Lab -> once started, Click the AWS link (green circle will be next to it).  Click EC2 -> Click Instances Running -> click checkbox next to instance -> in the menu below, click Security, scroll down a little, click the link under Security Groups to hot drop to your rules that go with your instance.  inbound Rules are where you'll be focusing for the lab.

1. Remove the two original rules.  
2. Create a rule that allows SSH access from any WSU IPv4 address, which will be all address from 130.108.0.0 to 130.108.255.255
3. Create a rule that allows SSH access from your home public IPv4 address
   - required even if you live on campus
4. Create a rule that allows HTTP access from any IPv4 address
5. Describe why should HTTP allow any IP, while SSH has restrictions?  Your answer should show a reflection on the purpose of these two protocols.
6. Describe how you validated or can validate if your rules are working with the restrictions given.

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

   - `Lab12.md`

2. In the Pilot Dropbox, paste the URL to the `Lab12` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab12

## Rubric

- Part 1 - 5.5 points (0.5 pt. / command)
   - summary of what command does (0.25)
   - resource to description & usage of command (0.25)
- Part 2 - 8 points (0.5 pt. each)
- Part 3 - 6 points (1 pt. each)
- Part 4 - 6 points
   - 1 point for removing original rules
   - 1 point per Security Group Rule (3 total)
   - 1 point for addressing restrictive vs non-restrictive protocols
   - 1 point for thoughtful tests to check SG is working as intended for each protocol
   - No screenshot in markdown = -3 points
- Part 5 - 4.5 points
   - 0.5 point per purpose, response, and no response per server (4 total)
   - 0.5 point per response to question, with understanding & experimentation documented (5 total)
   - No citations = -4.5 points
- Extra Credit - 10% (3 points)
