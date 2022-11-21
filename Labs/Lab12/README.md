# Lab 12

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - tar it up](##Part-1---tar-it-up)
- [Part 2 - SFTP](##Part-2---SFTP)
- [Part 3 - ssh keys](##Part-3---ssh-keys)
- [Part 4 - Firewall](##Part-4---Firewall)
- [Extra Credit - Solving Conflict](##Extra-Credit---Solving-Conflict)
- [Submission](#Submission)
- [Rubric](#Rubric)
- [Troubleshooting](#Troubleshooting)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/24167/modules/items/1982401)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab12`

Create a file named `Lab12.md` [based on the template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab12/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - tar it up

Do the following on your AWS instance.  
Since we are wrapping up the semester, it's time to save your work and turn things off. Identify folder(s) you want to save for step 2 of this part. It is not required, but is interesting to look the the size of these folders pre and post compression

1. For the `tar` command, write what each option below does:
   - `-c`
   - `-v`
   - `-f`
   - `-z`
   - `-x`
2. Create a tarball (`tar` and compress) folders of your choice. Write the command you used. You will not be committing this to GitHub - it does not need to be in your repository folder.

- **Resources**
- [cyberciti - tar on the command line](https://www.cyberciti.biz/faq/how-to-tar-a-file-in-linux-using-command-line/)
- [tecmint - tar command examples](https://www.tecmint.com/18-tar-command-examples-in-linux/)

## Part 2 - SFTP

For this part, start on your local system.  
On your instance, you created a compressed set of stuff to save, but how do you get it off your instance? A thought is to cheat and make `git` / GitHub do it, but there are better tools.

1. Connect to your AWS instance via `sftp`.
2. Describe what the following options do:
   - `ls`
   - `lls`
   - `put`
   - `get`
3. Retrieve the tarball (`.tar.gz`) from your AWS instance and download it to your local system
4. Uncompress the tarball (`.tar.gz`) to a folder on your system (you can remove it after you get the command right, I'm not a space hog)

- **Resources**
- [DigitalOcean - how to use sftp](https://www.digitalocean.com/community/tutorials/how-to-use-sftp-to-securely-transfer-files-with-a-remote-server)

## Part 3 - ssh keys

Without practice, `ssh` connections and authentication just seem like magic. Really, it is all about "stuff" being in the right spot. The goal of this part is to practice where keys go when you have a pair of keys. This is a common task to do when you gain access to a system - put your public key in the `authorized_keys` file in the `.ssh` folder of your account, then connect from your system to the remote system.

- **Useful commands: `adduser`, `ssh-keygen`, `vim`, `ssh`**

1. On your AWS instance, create a new user
   - In pretend world, this is your company's IT guys making you an account
2. On your system, make a new key pair - you choose the name and location.
   - In pretend world, this is you making your key pair - your private key will only be accessible by you. The public key is shared with accounts on systems you have access to.
     - Also note, normally you would either need to send IT your public key OR they would generate the key, and send you the private key.
3. Put the public key of the key pair you just made in the new user's `~/.ssh/authorized_keys` file
   - You have now set up SSH authentication to your account on (pretend) the new system!
4. From your system, `ssh` in to the AWS instance using the new user's username and the private key you generated.
   - And now (in pretend world) you would rinse and repeat for all systems you'll have an account on. Your `~/.ssh/config` file will be handy here as you collect dozens of systems that you have access to. Setting up what private key goes to what system and what that system's IP / hostname is so you don't have to keep it all in your head.

- **Resources**
- I do this manually, but there are some neat command shortcuts to explore
- [DigitalOcean - How to Configure SSH Key Based Authentication](https://www.digitalocean.com/community/tutorials/how-to-configure-ssh-key-based-authentication-on-a-linux-server)

## Part 4 - Firewall

Note: this part is last because you are most likely to break something.

1. Given a subnet range, provide the network prefix + CIDR notation of the subnet range. For example: Subnet range: `10.0.0.0 - 10.0.1.255` Would be written as `10.0.0.0/23` OR `10.0.1.0/23`
   - Subnet range for Wright State IPs: `130.108.0.0 - 130.108.255.255`
   - Subnet range for AWS public subnet: `10.0.0.0 - 10.0.0.255`
   - Subnet range for your home public IP: `your_public_ip - your_public_ip`
   - Note: What we are generating here is a list of hosts addresses that we can consider trustworthy. You, from your place of living, campus IP addresses, and other hosts on the same network as our instance.
2. Your AWS instance has no network restrictions on who can connect - any IP (`0.0.0.0/0`) can connect to any port (`1-65,535`). This is generally a bad idea. Using `iptables` AND Security Groups on AWS, give a brief writeup on **how these two statements can be confirmed** (by you on your AWS instance) and **why this is a bad practice**.
3. Using `iptables` OR Security Groups on AWS, restrict traffic to port `22` to only your trusted subnets (defined in step 1).
   - **If you used `iptables`**, write the commands you used. Include a **screenshot** of your rules once they are in place
     - `iptables` notes:
       - `iptables` are chain based - enable a rule that will keep you connected first
       - `drop` all traffic that does not meet the allowed traffic rules.
       - Do **NOT** `save` these rules. Just type them out - if something breaks, you can [reboot your instance from the AWS console](https://us-east-1.console.aws.amazon.com/ec2/home?region=us-east-1#Instances:) and the iptables will be flushed. If you `save`, well, you could permanently lock yourself out of say, port 22 (SSH).
   - **If you used Security Groups**, remove rules that enable access from any port from any IP address - your rules should be the only ones in place. Include a **screenshot** of your rules once they are in place
4. Confirm you can still `ssh` in to your AWS instance. What would be an invalid IP or network?

- **Resources**
- [Go to your AWS Security Groups](https://us-east-1.console.aws.amazon.com/ec2/home?region=us-east-1#SecurityGroups:)
  - Your instance uses a Security Group named `ceg2350-Lab1SecurityGroup`-xxx where xxx may vary. You want to focus on Inbound Rules
- [How to Geek - Beginners Guide to `iptables`](https://www.howtogeek.com/177621/the-beginners-guide-to-iptables-the-linux-firewall/)

## Extra Credit - Solving Conflict

For this extra credit, you are going to create and solve a merge conflict. I'm going to walk you into one way these are created - conflicts between branches. Conflicts can also occur when you `push` on a repo within a team - someone else on the team has also been making changes, and now you need to `pull`, figure out which changes stay, then tell `git` the conflict has been resolved.

### Setup the conflict

1. Confirm you are on the `main` branch of your repository.
2. Create a new file in your `Lab12` folder called `problem-child.txt`  
   Add some text to this file, just to get the party started.
3. `add`, `commit` and `push` the file, and confirm you see the file on GitHub.
4. Create and switch to a new branch called `improvements`
5. On the `improvements` branch, make some edits to `problem-child.txt`
6. `commit` and `push` you changes on your branch
7. Switch back to the `main` branch

- Don't `merge` yet - you'll ruin the experiment

9. Making sure you are on the `main` branch, make some edits to `problem-child.txt` and `commit` (`push` is optional)
10. `merge` the `improvements` branch with `main`

### Solve the conflict

1. Summarize the output from making the `merge` between the two branches.
2. Head to your file in the terminal. What do you see?
3. Resolve your conflict by modifying the file to no longer have the scary >>'s of doom and have the content you want to keep.
4. Run `status`. Summarize the output given and what you need to do next now that your file is in a happy state.
5. Do the things. Write the command(s) you used.

- **Resources:**
  - [Git - Basic Branching & Merging](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging)
  - [Merge conflicts](https://www.atlassian.com/git/tutorials/using-branches/merge-conflicts)

## Submission

1. Verify that your GitHub repo has a `Lab12` folder with at minimum:

   - `Lab12.md`
   - `problem-child.txt` (if extra credit)

2. In the Pilot Dropbox, paste the URL to the `Lab12` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab12

## Rubric

- Part 1 - 2 pts
- Part 2 - 4 pts
- Part 3 - 4 pts
- Part 4 - 4 pts
- Extra Credit - 2.8 pts (20%)

## Troubleshooting

Q. I used `iptables`, and enabled rules in the wrong order (I was forcefully disconnected after locking myself out). What to do?  
A. [Reboot your AWS instance](https://us-east-1.console.aws.amazon.com/ec2/home?region=us-east-1#Instances:) by going to your list of instances. Select the instance you want to reboot, then select Instance State -> Reboot Instance

- Note: this will only "save" you if you did not `save` your `iptables` rules.
