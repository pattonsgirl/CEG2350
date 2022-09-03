# Lab 02

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - git going](#Part-1---git-going)
- [Part 2 - Regular `bob`](#Part-2---Regular-bob)
- [Part 3 - Get a `crew`](#Part-3---Get-a-crew)
- [Part 4 - `sudo` make me a sandwich](#Part-4---sudo-make-me-a-sandwich)
- [Part 5 - ssh config](#Part-5---ssh-config)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/24167/modules/items/1982401)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - git going

In Lab 01, you set up an instance on AWS **and** cloned your GitHub repository to the instance.

This part assumes you successfully cloned your repository to your instance on AWS. If you are behind here, you should talk with the instructor or TA to get back on track.

- **Useful commands for this part: `git add`, `git commit`, `git push`, `git pull`**

1. In your repository folder (the folder you `clone`d from GitHub), create a folder named `Lab02`
2. In the `Lab02` folder, create a file named `Lab02.md`
3. Paste the contents of the [LabTemplate.md](LabTemplate.md) into this file
   - [Link to raw LabTemplate](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab02/LabTemplate.md)
4. `add` `Lab02.md` for tracking, `commit` changes as you go, and `push` to synchronize with GitHub
5. Fill in the Part 1 Answers with a simple guide for taking a new, locally created file in your repository, and syncing it with GitHub.

## Part 2 - Regular `bob`

Perform the following exercise on your AWS instance

- **Useful commands for this part: `adduser, sudo, su, chown, pwd, cd, whoami, exit`**

1. Create a new user named `bob`
2. What is the path to `bob`'s `home` directory?
3. Can your user add files to `bob`'s home directory? Why or why not?
4. Switch to the user `bob`
5. Get to `bob`'s `home` directory
6. Can `bob` add files to `bob`'s home directory? Why or why not?
7. Switch back to the your user
8. Return to the your user's `home` directory

## Part 3 - Get a `crew`

Perform the following exercise on your AWS instance. Create `DirA` and `DirB` in your user's home directory.

- **Useful commands for this part: `addgroup, usermod, chown, chgrp`**

1. Create a new group named `crew`
2. Add your user and `bob` to the `crew` group
3. Change `DirA` in your user's home directory so that `crew` is the group for the whole folder
   - Yes, including contents in `DirA`
4. Switch user to `bob`
5. As `bob` create a file in `DirA`.
6. Why was this successful?

## Part 4 - [`sudo` make me a sandwich](https://xkcd.com/149/)

Perform the following exercise on your AWS instance

- **Useful commands for this part: `sudo`**

1. In the your user's `home` directory, make a file with `sudo` named `sudowho.txt`
2. What are the permissions of this file?
3. Without modifying the permissions of the file, edit the file and add some text, and save the changes.

## Part 5 - ssh config

On your local system (`exit` from your AWS instance), you used an SSH command to log on to your AWS Ubuntu instance. There is a neat configuration file that can be used to create an alias of sorts. Read the resources for this section, then configure the `.ssh/config` file for your user on your system with information on your `ssh` connection to your AWS instance.

1. Write the command you have been using to `ssh` in to your AWS instance.
2. Provide the HostName (IP address) of your AWS Ubuntu instance:
3. Provide the user name that you are logging on to the system with:
4. Provide the absolute / full path to the private key (Identity File) on your local system:
5. On your local system, edit `~/.ssh/config` to contain an entry with information about logging on to your AWS Ubuntu instance.

```
Paste your config file entry here
```

6. Write the new form of the `ssh` command to connect to your AWS instance.

- **Resources**
- [linuxize - Using the ssh config file](https://linuxize.com/post/using-the-ssh-config-file/)
- [cyberciti.biz - config file examples](https://www.cyberciti.biz/faq/create-ssh-config-file-on-linux-unix/)
- The `Port`, if you wish to include it in your `config` is `22`

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab02` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab02.md

## Rubric

- Part 1 - 3 pts
- Part 2 - 8 pts
- Part 3 - 6 pts
- Part 4 - 3 pts
- Part 5 - 3 pts
  - 0.5 pts / question
