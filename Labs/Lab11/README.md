# Lab 10 - UNRELEASED

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Linux Network Command Cheat Sheet](#part-1---linux-network-command-cheat-sheet)
- [Part 2 - Network Info](#part-2---network-info)
- [Part 3 - Subnet Translation](#part-3---subnet-translation)
- [Part 4 - Security](#part-4---security)
- [Extra Credit - Tattle Tale](#extra-credit---tattle-tale)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/68834/modules/items/6128516)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

**Create a new directory, `Lab10`**

Write answers in `Lab10.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab10/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - Linux Network Command Cheat Sheet

The commands below are all Linux commands to show or modify network information.  Provide a brief statement / summary (not a multi-paragraph copy paste :wink:) about what each command does.  You'll be using these commands in Part 2 to find networking info for your AWS instance.

- `hostname`
- `ifconfig`
- `ip addr show`
- `route`
- `cat /var/lib/dhcp/dhclient.leases`
- `cat /etc/resolv.conf`
- `curl ipinfo.io`
- `iptables -L`
- `nmap -p <IP_or_hostname>`
- `tcpdump -i <networkinterface> -n host <IP_or_hostname>`

## Part 2 - Network Info

For your PC and for your AWS instance, find the following network information.  The point is to find networking info using two different OSes (Windows and Linux OR Mac and Linux).  If you do not have access to a non-Linux OS you can use the laptops or desktops provided in the lab rooms. You should not download any additional tools.

**Additional Useful Commands**  
Windows: `ipconfig \all`

1. Hostname of the device:
2. MAC address of the NIC connected to the network:
3. IPv4 address:
4. Subnet mask:
5. Gateway address:
6. DHCP server address:
7. DNS server address:
8. Public IPv4 address:

- Notes: 
   - These results are going to look boring at home, but interesting on more complex networks, like Wright State or Starbucks.  While you are welcome to do this using your home network, play with these commands on other networks as well. At home you likely have one device (your router) that is the first stop for most requests (DHCP, DNS, and gateway to route traffic to the next stop). On a complex network, you'll see these addresses getting distributed to different devices - there is a device to connect to to request an address and network information (DHCP server), another that is a first stop for DNS resolution, and maybe another that is the gateway address that packets outside the network are forwarded to to find their destination.
   - Public IPv4 addresses are only used when you are trying to send communications outside your local (private) subnet.  The vast majority of networks utilize this scheme.  It allows many devices to be on one network, which then "share" a public IPv4 address when sending packets and receiving communication back from network devices external to your network.

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

Translate the below CIDR notation subnets to their IP ranges:
1. `130.108.0.0/16`
2. `192.168.1.0/8`
3. `8.8.8.8/32`

Translate the below IP ranges to their CIDR notation subnets:
1. `192.168.1.0 - 192.168.1.255`
2. `172.16.0.0 - 172.16.255.255`
3. `132.189.13.78 - 132.189.13.78`

## Part 4 - Security

Your AWS instance has a rule that allows in all traffic from any source, to any port on your AWS instance.  Specifically, they look like this:
![AWS Default Security Group Rules](Default-SGRules.JPG)

Normally, if you had physical access to your instance, we would look at this from the perspective of `iptables` and / or `ufw` rules to allow only trusted networks to access ports on your system, like port 22, which runs a service, SSH, that allows us shell access to the system.  Physical access makes it easy to undo mistakes.  Since we don't, we will use AWS to manage our instance's security rules.

SSH is just software - code - in the end, and code has vulnerabilities.  For all software we track Common Vulnerabilities and Exposures (CVEs).  Specifically for SSH, you can [view the CVE reports here](https://www.cvedetails.com/vulnerability-list/vendor_id-120/SSH.html)

It is a combination of credentials (identity) and network rules that keep systems safe, and allow people to only access what they need.

Your task is to remove both terrible rules from your security group and replace them with the rules outlined below.  Assuming you have hit "Start Lab" and have opened your console via the "AWS" link after the lab has started (timer is counting down), this [link will quick drop you to your Security Groups](https://us-east-1.console.aws.amazon.com/ec2/home?region=us-east-1#SecurityGroups:).  Find the Security Group named **`ceg2350-Lab1SecurityGroup`** (or similar).  Click the checkbox next to that entry or the link in the "Security Group ID" column to focus on only this Security Group.  You will be editing only the **Inbound Rules**

If the link doesn't work, the full set of things to click is: go to the the Learner Lab Module -> Click Start Lab -> once started, Click the AWS link (green circle will be next to it).  Click EC2 -> Click Instances Running -> click checkbox next to instance -> in the menu below, click Security, scroll down a little, click the link under Security Groups to hot drop to your rules that go with your instance.  inbound Rules are where you'll be focusing for the lab.

1. Remove the two default rules.  
   - If you lose the ability to connect to your instance, you can recreate them by referring to the Security Group rules picture above.
2. Create a rule that allows SSH access from any WSU IPv4 address, which will be all address from 130.108.0.0 to 130.108.255.255
3. Create a rule that allows SSH access from your home public IPv4 address
   - required even if you live on campus
4. Create a rule that allows HTTP access from any IPv4 address
5. Describe why should HTTP allow any IP, while SSH has restrictions?  Your answer should show a reflection on the purpose of these two protocols.

## Extra Credit - Tattle Tale

[auth_logs.csv](auth_logs.csv) is a cleaned up version of standard SSH logs, and contains only the username used in the connection attempt and the IPv4 address the attempt came from.  Take the provided data and give me 2 reports:
- the top 5 IP addresses that generated connection attempts and how many attempts they made
- the top 5 usernames used and how many times they were used

Your reports must contain the set of commands used to create the reports.

- Note: if you are curious about how I parsed `auth.log` to generate the `csv` file, you can [check out my documentation here](https://github.com/pattonsgirl/api-projects/tree/main/ip-mapper/data) - there are likely prettier ways to do it.

## Submission

1. Verify that your GitHub repo has a `Lab10` folder with at minimum:

   - `Lab10.md`

2. In the Pilot Dropbox, paste the URL to the `Lab10` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab10

## Rubric

- Part 1 - 10 points (1 pt each)
- Part 2 - 16 points (1 pt each)
- Part 3 - 6 points (1 pt each)
- Part 4 - 4 points
   - 1 point per Security Group Rule
   - 1 point for answer to protocol question
- Extra Credit - 10% (3.6 points)
