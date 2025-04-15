## Lab 12

- Name:
- Email:

## Part 1 - Linux Network Command Cheat Sheet

- `hostname`
    - Resource on `hostname`:
- `ifconfig`
    - Resource on `ifconfig`:
- `ip a`
    - Resource on `ip`:
- `route`
    - Resource on `route`:
- `iptables -L`
    - Resource on `iptables`:
- `curl <IP_or_hostname>`
    - Resource on `curl`:
- `ping <IP_or_hostname>`
    - Resource on `ping`:
- `nslookup <IP_or_hostname>`
    - Resource on `nslookup`:
- `traceroute <IP_or_hostname>`
    - Resource on `traceroute`:
- `nmap -p <IP_or_hostname>`
    - Resource on `nmap`:
- `tcpdump -i <networkinterface> -n host <IP_or_hostname>`
    - Resource on `tcpdump`: 

## Part 2 - Network Info

### Network Info for <Your OS Here>

1. Hostname of the device:
2. MAC address of the NIC connected to the network:
3. IPv4 address:
4. Subnet mask:
5. Gateway address:
6. Does the device use DHCP to receive a network address? (y/n):
7. DNS server address:
8. Public IPv4 address:

### Network Info for AWS Instance

1. Hostname of the device:
2. MAC address of the NIC connected to the network:
3. IPv4 address:
4. Subnet mask:
5. Gateway address:
6. Does the device use DHCP to receive a network address? (y/n):
7. DNS server address:
8. Public IPv4 address:

## Part 3 - Subnet Translation

Translate the below CIDR blocks to their IP ranges:
1. `130.108.0.0/16`
2. `34.117.59.81/32`
3. `10.25.121.90/8`

Translate the below IP ranges to their CIDR notation subnets:
1. `172.18.5.0 - 172.18.5.255`
2. `5.9.243.187 - 5.9.243.187`
3. `192.168.0.0 - 192.168.1.255`

## Part 4 - Security

Screenshot of your changed Inbound Security Group rules.  
![Inbound Rules for Lab 12](relative/path/to/image)

> Why should HTTP allow any IP, while SSH has restrictions?

> Describe how you validated or can validate if your rules are working with the restrictions given.

## Part 5 - It's Alive!  Maybe...

1. For the given server IP, describe purpose and what types of requests it does / doesn't respond to:
    - `8.8.8.8`
        - Purpose:
        - Responds to:
        - Does not respond to: 
    - `5.9.243.187` -> `wttr.in` -> `https://wttr.in`
        - Purpose:
        - Responds to:
        - Does not respond to: 
    - Your AWS instance public IP
        - Purpose:
        - Responds to:
        - Does not respond to: 
    - `34.117.59.81` -> `ipinfo.io` -> `https://ipinfo.io`
        - Purpose:
        - Responds to:
        - Does not respond to: 
2. Does `ping` tell you if a server is "working"?
3. What protocol does `ping` use?  What does this mean about the server's firewalls?
4. Why won't `ping` work if you specify `https://` before the domain name?
5. Does an IP lookup always result in finding the correct domain name / URL to access the resource, and vice versa?
6. What happens at when an `http` request is made to a server with `https` enabled?

Citations:
- <add bullets of citations / links used here>

## Extra Credit - Tattle Tale

### IPv4 Source Report

| Rank  | IPv4 Address | # of Attempts |
| ----- | ------------ | ------------- |
| 1     |              |     |
| 2     |              |     |
| 3     |              |     |
| 4     |              |     |
| 5     |              |     |

Commands to parse `csv` for report:

### Username Used Report

| Rank  | Username     | # of Attempts |
| ----- | ------------ | ------------- |
| 1     |              |     |
| 2     |              |     |
| 3     |              |     |
| 4     |              |     |
| 5     |              |     |

Commands to parse `csv` for report:

## Citations

To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.
