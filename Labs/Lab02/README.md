# Lab 02

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - AWS Academy Setup](#Part-1---AWS-Academy-Setup)
- [Part 2 - git cloning](#Part-2---git-cloning)
- [Part 3 - ssh config](#Part-3---ssh-config)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - AWS Academy Setup

An email was sent to your wright.edu account inviting you to join AWS Academy.  
Follow the instructions in [AWS Academy](../../AWSAcademy.md) to set up your AWS instance.

## Part 2 - git cloning

- **Useful commands for this part: `ssh-keygen`, `cat`, `git clone`, `git add`, `git commit`, `git push`**

1. Create an SSH key pair on your AWS Ubuntu instance.
2. Add the public key to GitHub
3. Clone your repository (a.k.a. repo) to the `ubuntu` user's home directory
4. In your repo folder, create a folder named `Lab02`
5. In the `Lab02` folder, create a file named `Lab02.md`
6. Paste the contents of the [LabTemplate.md](LabTemplate.md) into this file
   - [Link to raw LabTemplate](https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab02/LabTemplate.md)
7. `add` `Lab02.md` for tracking, `commit` changes as you go, and `push` to synchronize with GitHub
8. Fill in the Part 2 Answers with the command(s) to do the requested action.

- **Resources:**
- [GitHub Classrooms - How to Use](../../GitHubClassrooms.md)
- [GitHub - Generating a New SSH Key](https://docs.github.com/en/enterprise-server@3.3/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)
- [GitHub - Adding SSH key to your GitHub Account](https://docs.github.com/en/enterprise-server@3.0/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)

## Part 3 - ssh config

On your local system, you used an SSH command to log on to your AWS Ubuntu instance.

1. Write the command you used to `ssh` in to your AWS instance.
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

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab02` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab02.md

## Rubric

- Submitted Lab 02 answers using the LabTemplate - 1 pts
- Part 2 - 3 pts total
  - 1 pt per question
- Part 3 - 6 pts total
  - 1 pt per question
