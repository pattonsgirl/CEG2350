# Lab 02 - Permissions

- [Lab Procedure](#Lab-Procedure)
- [Part 0 - editor in training](#part-0---editor-in-training)
- [Part 1 - AWS Academy Setup](#part-1---aws-academy-setup)
- [Part 2 - Bits of permissions](#part-2---bits-of-permissions)
- [User & Group Resources](#user--group-resources)
- [Part 3 - Regular `bob`](#part-3---regular-bob)
- [Part 4 - Get a `squad`](#part-4---get-a-squad)
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

Follow the instructions in [AWS Academy Setup](CEG2350/Topics/AWSAcademy/) to set up your AWS environment and make your first `ssh` connection to your AWS instance that you'll use throughout the semester.

The written instructions are thorough, but if you would like more visuals visit the Pilot -> Content -> Labs -> Getting Started for a video companion guide to creating an instance.  The video guide sets up connections with WSL2 specifically, but PowerShell or other Terminals will have similar key parts - know where you put your file, the name of it, and the system path to it and locate your IPv4 address to your AWS instance once created.

Wherever your lab instructions state that the exercise must be completed in your instance, it must be completed in your instance. **If a lab or lab section explicitly states that you must work in your AWS environment, do so**. There will be a biweekly check to make sure you are using the AWS environment to try out commands and perform work. 

If you break your ability to connect to your instance by:
- forgetting / deleting your private key
- running a destructive command
- karma because you waited til the last minute to start
You can rebuild by repeating the instructions in AWS Academy Setup.

In the Lab Template, you will write out the where your private key file is located and the `ssh` command to use to remotely connect to the AWS instance.

## Part 2 - Bits of permissions

For each command below, write a verbose description of what it does. Then, assess whether or not the command as given is "good" and give an explanation to defend your stance. 

Sample:
- `chmod 777 file.txt`
- Full credit answer: 
   - Means: For file.txt, it allows the owner/ user to read, write, and execute, the group to read, write and execute, and others to read, write, and execute
   - Assessment: Not recommended. Plain text files (noted because the file has a .txt extenstion) should not have execute permissions associated with them as they are files, not programs.  In addition, this file can by edited by anyone on the system, including accounts that are not the owner or a group associated with the file.
- No credit answer: 
   - Means: It does 777
   - Assessment: Bad

- **Useful commands for this part: `chmod, man`**

1. `chmod u+r bubbles.txt`
2. `chmod u=rw,g-w,o-x banana.cabana`
3. `chmod a=w snow.md`
4. `chmod 751 program`
5. `chmod -R ug+w share`

**Resources**
- [RedHat - Linux File Permissions Explained](https://www.redhat.com/sysadmin/linux-file-permissions-explained)
- [Linuxize - Understanding File Permissions](https://linuxize.com/post/understanding-linux-file-permissions/)

## User & Group Resources

Peruse these resources before beginning work on Parts 2 & 3.  You may cite them as references in your Lab Template

- [RedHat - How to manage users and groups in Linux](https://www.redhat.com/sysadmin/linux-user-group-management)
- [Linuxize - how to use `useradd`](https://linuxize.com/post/how-to-create-users-in-linux-using-the-useradd-command/)
   - I recommend using `adduser` in the lab, but this is a great breakdown of the pieces `adduser` uses and `useradd` needs you to specify
- [Linuxize - groups and users](https://linuxize.com/post/how-to-add-user-to-group-in-linux/)

## Part 3 - Regular `bob`

Perform the following exercise on your AWS instance.  

Replace `BOB` with a **username your create** based on **your** first initial followed by last name.  For example, "John Smith" would be `jsmith`

- **Useful commands for this part: `adduser, sudo, su, chown, pwd, cd, whoami, exit`**

1. Create a new user named `BOB` 
   - **replace `BOB` with your username, see instructions above**
2. What is the path to `BOB`'s `home` directory?
3. Can `ubuntu` add files to `BOB`'s home directory? Why or why not?
   - For credit, answer must include what was to to justify answer.
4. Switch to the user `BOB`
5. Get to `BOB`'s `home` directory
6. Can `BOB` add files to `BOB`'s home directory? Why or why not?
   - For credit, answer must include what was to to justify answer.
7. Switch back to the `ubuntu` user
   - Note that the `ubuntu` user does not have an account password.  You'll have to find a command that can end your session...
8. Return to the `ubuntu` user's `home` directory

## Part 4 - Get a `squad`

Perform the following exercise on your AWS instance. 

**Reminder to replace references to `BOB` with your username of first initial, last name (ex. `jsmith`)**

- **Useful commands for this part: `addgroup, usermod, chown, chgrp, su, sudo, mkdir`**

Create a folder named `share` in the `ubuntu` user's `home` directory and create some files and sub folders in the folder to play with.

1. Create a new group named `squad`
2. Add `ubuntu` and `BOB` to the `squad` group 
   - **replace `BOB` with your username, see instructions above**
3. Allow `squad` to view the `ubuntu` user's home directory contents.
4. Change permission of the `share` directory in the `ubuntu` user's `home` directory so that `squad` is the group for the whole folder and members of `squad` can make changes in the folder.
   - Include all files and subdirectories in `share`
5. Switch user to `BOB`. Test that `BOB` can view the contents of the `ubuntu` user's home directory.
   - If not, make a note in your answer in Step 3 about additional change(s).
6. As `BOB` create a file in `share`.

## Part 5 - [`sudo` make me a sandwich](https://xkcd.com/149/)

Perform the following exercise on your AWS instance.

- **Useful commands for this part: `sudo`**

1. As the `ubuntu` user, in the `ubuntu` user's `home` directory, make a file with `sudo` named `madewithsudo.txt`
2. As the `root` user, in the `ubuntu` user's `home` directory, make a file with named `madewithroot.txt`
3. Describe the ownership and permissions associated with:
   - `madewithsudo.txt`
   - `madewithroot.txt`
4. Determine which account (`root`, `ubuntu`, and `BOB`) can view or edit:
   - Contents inside of `share`
   - `madewithsudo.txt`
5. Modify the permissions and ownership to make `ubuntu` the owner and `squad` the group associated with `madewithsudo.txt`.

**Resources**
- [RedHat - Linux command line basics: sudo](https://www.redhat.com/sysadmin/sudo)
- [Linuxize - `sudo`](https://linuxize.com/post/sudo-command-in-linux/)
   - Note: on your AWS instance, the `ubuntu` user has passwordless sudo - as in you won't be prompted for your account password.  If you try `sudo` on most Linux machines, you will be prompted for a password.  AWS has a *special* setup.

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab02` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350f24-YOURGITHUBUSERNAME/tree/main/Lab02/README.md

## Rubric

- Part 1 - 5 pts
- Part 2 - 5 pts
- Part 3 - 8 pts
- Part 4 - 6 pts
- Part 5 - 4 pts