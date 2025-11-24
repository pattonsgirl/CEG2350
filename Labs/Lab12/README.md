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
