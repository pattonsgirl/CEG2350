# Lab 11

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Fire!wall](##Part1---Fire!wall)
- [Part 2 - tar it up](##Part-2---tar-it-up)
- [Part 3 - SFTP](##Part-3---SFTP)
- [Part 4 - New account - who this](##Part--4--New-account---who-this)
- [Extra Credit - Solving Conflict](##Extra-Credit---Solving-Conflict)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/13249/modules/items/1136419)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab11`

Create a file named `Lab11.md` [based on the template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab11/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - Fire!wall

The following will have you run an HTTP web server using a python library.

1. On your AWS instance, install `python3` and `pip3`
2. On your AWS instance, go into your GitHub repo folder and run `python3 -m http.server 5000` to start a minimal web server listening on port `5000`. Leave this running.
   - you'll see why I have you go into a specific folder in a minute...
3. For your AWS instance, identify:
   - localhost IP:
   - instance private IP:
   - instance public IP:
4. On your PC, use a web browser to connect to the instance on the port your web server is running on.
   Well, neat trick, but this probably isn't something that should be accessible by just anyone (which is what is happening now).
5. Your next step is to use either `iptables` or the Security Groups on AWS, disallow this port `5000` from being public. Describe what step(s) you took and how you know the port is now blocked.
   - For `iptables`, DROP any public addresses 0.0.0.0/0 incoming to port `5000`
     - Do **NOT** `save` these rules. Just type them out - if something breaks, you can reboot and the iptables will be flushed. If you `save`, well, you could permanently lock yourself out of say, port 22 (SSH).
   - For Security Groups, if you read through the list of Inbound rules, you'll see one of these rules opens all the ports from any IP...

## Part 2 - tar it up

1. For the `tar` command, write what each option below does:
   - `-c`
   - `-v`
   - `-f`
   - `-z`
   - `-x`
2. On your AWS instance, find the size of your user's home directory.
3. tar and compress your user's home directory
4. What is the size of the tarball?

## Part 3 - SFTP

1. `sftp` on to your AWS instance.
2. Describe what the following options do:
   - `ls`
   - `lls`
   - `put`
   - `get`
3. Retrieve the tarball from your AWS instance and download it to your local system
4. Uncompress the tarball to a folder on your system, maybe `2350-archive`

## Part 4 - New account - who this

- **Useful commands: `adduser`, `ssh-keygen`, `vim`, `ssh`**

1. On your AWS instance, create a new user
2. On your system, make a new key pair - you can use the default file name and location or a name of choice.
3. Put the public key of the key pair you just made in the new user's `~/.ssh/authorized_keys` file
4. From your system, `ssh` in to the AWS instance using the new user's username and the new private key.

## Extra Credit - Solving Conflict

For this extra credit, you are going to create and solve a merge conflict. I'm going to walk you into one way these are created - conflicts between branches. Conflicts can also occur when you `push` on a repo within a team - someone else on the team has also been making changes, and now you need to `pull`, figure out which changes stay, then tell `git` the conflict has been resolved.

### Setup the conflict

1. Confirm you are on the `main` branch of your repository.
2. Create a new file in your `Lab11` folder called `problem-child.txt`  
   Add some text to this file, just to get the party started.
3. `add`, `commit` and `push` the file, and confirm you see the file on GitHub.
4. Create and switch to a new branch called `improvements`
5. On the `improvements` branch, make some edits to `problem-child.txt`
6. `commit` and `push` you changes on your branch
7. Switch back to the `main` branch

- Don't `merge` yet - you'll ruin the expirement

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

1. Verify that your GitHub repo has a `Lab11` folder with at minimum:

   - `Lab11.md`
   - `problem-child.txt` (if extra credit)

2. In the Pilot Dropbox, paste the URL to the `Lab11` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab11

## Rubric

- Part 1 - 5 pts
- Part 2 - 4 pts
- Part 3 - 4 pts
- Part 4 - 4 pts
- Extra Credit - 4 pts (20%)
