# Lab 02 - Permissions

- [Lab Procedure](#Lab-Procedure)
- [Part 0 - editor in training](#part-0---editor-in-training)
- [Part 1 - AWS Academy Setup](#part-1---aws-academy-setup)
- [Part 2 - Bits of permissions](#part-2---bits-of-permissions)
- [Part 3 - Regular `bob`](#part-3---regular-bob)
- [Part 4 - Get a `crew`](#part-4---get-a-crew)
- [User & Group Resources](#user--group-resources)
- [Part 5 - `sudo` make me a sandwich](#part-5---sudo-make-me-a-sandwich)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

Beginning with this lab, you will be accessing an AWS instance - a virtual system hosted on the cloud - to access a Ubuntu server environment. **If a lab or lab section explicitly states that you must work in your AWS environment, do so**. There will be a biweekly check to make sure you are using the AWS environment to try out commands and perform work.

Go to your cloned repository folder (likely named `ceg2350f25-yourgithubusername`).

Create a new directory, `Lab02`

Create a file named `README.md` in the `Lab02` folder.  The [Lab 02 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab02/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab02/LabTemplate.md`

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

## Part 0 - editor in training

For this course, you will be creating and editing files in Linux.  Therefore, you will need to get acquainted with at least one command line text editor. `vim` will be the editor used in course demonstrations.

**`vim`**
- [How to Use Vim – Tutorial for Beginners](https://www.freecodecamp.org/news/vim-beginners-guide/)
- [vim hero - online tutorial](https://www.vim-hero.com/lessons/intro-to-modes)

**`nano`**
- [How to Use Nano, the Linux Command Line Text Editor](https://linuxize.com/post/how-to-use-nano-text-editor/)

## Part 1 - AWS Academy Setup

An email was sent to your wright.edu account inviting you to join an AWS Academy Course for this class.  

Follow the instructions in [AWS Academy](../../AWSAcademySetup.md) to set up your AWS environment and make your first `ssh` connection to your AWS instance.

The written instructions are thorough, but if you would like more visuals visit the Pilot -> Content -> Labs -> Getting Started for a video companion guide to creating an instance.  The video guide sets up connections with WSL2 specifically, but PowerShell or other Terminals will have similar themes - know where you put your file, the name of it, and the system path to it.

Wherever your lab instructions state that the exercise must be completed in your instance, it must be completed in your instance.  

If you break your ability to connect to your instance, you can rebuild by repeating the instructions in AWS Academy Setup.

In the Lab Template, you will write out the where your private key file is located and the `ssh` command to use to remotely connect to the AWS instance.

**The remainder of this lab is to be completed by using your AWS instance.**

## Part 2 - Bits of permissions

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

## Part 3 - Regular `bob`

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

## Part 4 - Get a `crew`

Perform the following exercise on your AWS instance. 

Create a folder named `share` in the `ubuntu` user's `home` directory and create some files in the folder to play with.

Reminder to replace references to `bob` with your username of first initial, last name (ex. `jsmith`)

- **Useful commands for this part: `addgroup, usermod, chown, chgrp, su, sudo, mkdir`**

1. Create a new group named `crew`
2. Add `ubuntu` and `bob` to the `crew` group (replace with your username, see note)
3. Change `share` in the `ubuntu` user's `home` directory so that `crew` is the group for the whole folder and members of `crew` can make changes in the folder.
   - Yes, including contents in `share`
4. Switch user to `bob`
5. As `bob` create a file in `share`.
6. Why was this successful?

### User & Group Resources

- [RedHat - How to manage users and groups in Linux](https://www.redhat.com/sysadmin/linux-user-group-management)
- [Linuxize - how to use `useradd`](https://linuxize.com/post/how-to-create-users-in-linux-using-the-useradd-command/)
   - I recommend using `adduser` in the lab, but this is a great breakdown of the pieces `adduser` uses and `useradd` needs you to specify
- [Linuxize - groups and users](https://linuxize.com/post/how-to-add-user-to-group-in-linux/)

## Part 5 - [`sudo` make me a sandwich](https://xkcd.com/149/)

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
  - URL should look like: https://github.com/WSU-kduncan/ceg2350s24-YOURGITHUBUSERNAME/tree/main/Lab02/README.md

## Rubric

- Part 1 - 5 pts
- Part 2 - 5 pts
- Part 3 - 8 pts
- Part 4 - 6 pts
- Part 5 - 4 pts