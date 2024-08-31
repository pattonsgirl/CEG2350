# Lab 02 - UNRELEASED

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - clone wars](#part-1---clone-wars)
- [Part 2 - git going](#part-2---git-going)
- [Part 3 - Bits of permissions](#part-3---bits-of-permissions)
- [Part 4 - Regular `bob`](#part-4---regular-bob)
- [Part 5 - Get a `crew`](#part-5---get-a-crew)
- [User & Group Resources](#user--group-resources)
- [Part 6 - `sudo` make me a sandwich](#part-6---sudo-make-me-a-sandwich)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/68834/modules/items/6128516)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350x##-yourgithubusername`).

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - clone wars

`ssh` to your AWS instance for this part (finish setup from Part 4). It is highly recommended you look at the Resources listed below.

- **Useful commands for this part: `ssh-keygen`, `cat`, `git clone`, `git add`, `git commit`, `git push`**

1. Create an SSH key pair on your AWS Ubuntu instance.
2. Add the public key to GitHub
3. Clone your repository (a.k.a. repo) to the `ubuntu` user's home directory

- **Resources:**
- [GitHub - How to Use - My Guide](../../GitHubSetup.md)
- [GitHub - Generating a New SSH Key](https://docs.github.com/en/enterprise-server@3.3/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)
- [GitHub - Adding SSH key to your GitHub Account](https://docs.github.com/en/enterprise-server@3.0/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)

## Part 2 - git going

- **Useful commands for this part: `git add`, `git commit`, `git push`, `git pull`, `git status`**

1. In your repository folder (the folder you `clone`d from GitHub), create a folder named `Lab02`
2. In the `Lab02` folder, create a file named `Lab02.md`
3. Paste the contents of the [LabTemplate.md](LabTemplate.md) into this file
   - [Link to raw LabTemplate](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab02/LabTemplate.md)
4. `add` `Lab02.md` for tracking, `commit` changes as you go, `push` to synchronize with GitHub, and `pull` if you make an edit in GitHub and need to synchronize your cloned folder
5. Fill in the Part 1 Answers with a simple guide for taking a new, locally created file in your repository, and syncing it with GitHub.

Reminder: if you make edits to your repository in GitHub using the browser, you'll need to `pull` to sync content in your `clone`d repository.

**Resources**
- [freeCodeCamp - Learn the Basics of Git in Under 10 Minutes](https://www.freecodecamp.org/news/learn-the-basics-of-git-in-under-10-minutes-da548267cc91/)
   - this is a useful read to understand the context of what the above commands do.  His setup is not the same as yours
- [git cheat sheet](https://rogerdudler.github.io/git-guide/files/git_cheat_sheet.pdf)
   - yes, there are more git commands than are on this sheet 

## Part 3 - Bits of permissions

For each command below, write a verbose description of what it does.  

Sample:
   - `chmod 777 file.txt`
   - Full credit: "For file.txt, it allows the owner/ user to read, write, and execute, the group to read, write and execute, and others to read, write, and execute"
   - No credit: "It does 777"

- **Useful commands for this part: `chmod, man`**

1. `chmod u+r bubbles.txt`
2. `chmod u=rw,g-w,o-x banana.cabana`
3. `chmod a=w snow.md`
4. `chmod 751 program`
5. `chmod -R ug+w share`

**Resources**
- [RedHat - Linux File Permissions Explained](https://www.redhat.com/sysadmin/linux-file-permissions-explained)
- [Linuxize - Understanding File Permissions](https://linuxize.com/post/understanding-linux-file-permissions/)

## Part 4 - Regular `bob`

For these exercises, replace `bob` with a username based on **your** first initial followed by last name.  For example, "John Smith" would be `jsmith`

Perform the following exercise on your AWS instance.  

- **Useful commands for this part: `adduser, sudo, su, chown, pwd, cd, whoami, exit`**

1. Create a new user named `bob` (replace with your username, see above)
2. What is the path to `bob`'s `home` directory?
3. Can `ubuntu` add files to `bob`'s home directory? Why or why not?
   - For credit, answer must include what was to to justify answer.
4. Switch to the user `bob`
5. Get to `bob`'s `home` directory
6. Can `bob` add files to `bob`'s home directory? Why or why not?
   - For credit, answer must include what was to to justify answer.
7. Switch back to the `ubuntu` user
   - Note that the `ubuntu` user does not have an account password.  You'll have to find a more administrative way to switch accounts...
8. Return to the `ubuntu` user's `home` directory

## Part 5 - Get a `crew`

Perform the following exercise on your AWS instance. 

Create a folder named `share` in the `ubuntu` user's `home` directory and create some files in the folder to play with.

Reminder to replace references to `bob` with your username of first initial, last name (ex. `jsmith`)

- **Useful commands for this part: `addgroup, usermod, chown, chgrp, su, sudo, mkdir`**

1. Create a new group named `crew`
2. Add `ubuntu` and `bob` to the `crew` group (replace with your username, see note)
3. Change `share` in the `ubuntu` user's `home` directory so that `crew` is the group for the whole folder
   - Yes, including contents in `share`
4. Switch user to `bob`
5. As `bob` create a file in `share`.
6. Why was this successful?

### User & Group Resources

- [RedHat - How to manage users and groups in Linux](https://www.redhat.com/sysadmin/linux-user-group-management)
- [Linuxize - how to use `useradd`](https://linuxize.com/post/how-to-create-users-in-linux-using-the-useradd-command/)
   - I recommend using `adduser` in the lab, but this is a great breakdown of the pieces `adduser` uses and `useradd` needs you to specify
- [Linuxize - groups and users](https://linuxize.com/post/how-to-add-user-to-group-in-linux/)

## Part 6 - [`sudo` make me a sandwich](https://xkcd.com/149/)

Perform the following exercise on your AWS instance.

- **Useful commands for this part: `sudo`**

1. In the `ubuntu` user's `home` directory, make a file with `sudo` named `sudowho.txt`
2. What are the permissions and ownership of this file?
   - Rephrased, who (which categories) can do what?
3. Without modifying the permissions or ownership of the file, edit the file and add some text, and save the changes.
4. Modify the permissions and ownership to make `ubuntu` the owner and `crew` the group associated with the file.

**Resources**
- [RedHat - Linux command line basics: sudo](https://www.redhat.com/sysadmin/sudo)
- [Linuxize - `sudo`](https://linuxize.com/post/sudo-command-in-linux/)
   - Note: on your AWS instance, the `ubuntu` user has passwordless sudo - as in you won't be prompted for your account password.  If you try `sudo` in the terminal on your machine, you will be prompted for a password

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab02` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350s24-YOURGITHUBUSERNAME/tree/main/Lab02.md

## Rubric

- Part 1 - 3 pts
- Part 2 - 5 pts
- Part 3 - 5 pts
- Part 4 - 8 pts
- Part 5 - 6 pts
- Part 6 - 4 pts

