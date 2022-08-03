# Lab 01

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Play with directories and naming](#Part-1---Play-with-directories-and-naming)
- [Part 2 - Create and edit a file](#Part-2---Create-and-edit-a-file)
- [Part 3 - Play with hidden files](#Part-3---Play-with-hidden-files)
- [Part 4 - Regular `bob`](#Part-4---Regular-bob)
- [Part 5 - Get a `crew`](#Part-5---Get-a-crew)
- [Part 6 - `sudo` make me a sandwich](#Part-6---sudo-make-me-a-sandwich)
- [Extra Credit - Test your skills](#Extra-Credit---Test-your-skills)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Pre-Reqs

This lab assumes

1. That you have a working Linux / Unix based terminal

   - Windows users: WSL2
   - Mac users: Terminal
   - Linux / Unix users: Terminal

2. You have created a GitHub account and clicked the link in Pilot to generate your GitHub  
   repository for this course

   - If you forgot to bookmark it, the URL is similar to:
   - `https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME`

## Lab Procedure

For each lab in this course, you will be provided with a lab template to fill in your lab answers. The [Lab 01 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab01/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab01/LabTemplate.md`

In your browser, go to your GitHub repository - `https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME`

Click the `Add File` button, then select "Create new file"

Name the file `Lab01.md`. In the edit file box, **paste** the contents of the lab template.

For each part below, you will be asked to perform an action or answer a question. The actions are going to be commands - **you will write the command(s) you used as "answers" to the action requested**. You are allowed to use multiple commands to solve an action. Just make sure to write every command you used to complete the action. Check with the TAs if you need clarification.

```
Example:
Prompt: Create a file named bubbles.txt
Answer: `touch bubbles.txt`
```

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

When you are ready to save your work (or take a break), scroll to the bottom to view the dialog regarding `commit`ting your work. For the moment, think of commits as save points. For each save point, you will write a message about what changed.

- Notice there are two textboxes in the commit field - skinny and paragraph sized. The skinny box is where you'll place a quick description - this one is required to create a `commit`. The paragraph sized box is where you can add bigger details about changes.
- The radio button defaults to select `Commit directly to the main branch.` - leave this as is.
- Select the green `Commit` button when you are ready to save your work.

To continue editing your file:

- Click on the file
- Click on the "Edit this file" pencil icon towards the right
- When you are done editing, repeat the steps above to `commit` your work.

## Part 1 - Play with directories and naming

- **Useful commands for this part: `man, mkdir, cd, ls, pwd, mv`**

1. Create a directory called `DirA`
2. Create a directory called `Dir B`
   - You must end up with a folder named `Dir B`
3. How do you go into `Dir B`?
4. Which of these uses a better naming convention, and why?
5. Rename `Dir B` to `DirB`

## Part 2 - Create and edit a file

- **Useful commands for this part: `touch, vim`**

1. In `DirA`, create a file called `test.txt`
2. Put at least three lines of text in `test.txt` using `vim`

## Part 3 - Play with hidden files

- **Useful commands for this part: `cp, mv, ls`**

1. Make a copy of `test.txt` inside `DirA` named `.hiddentext.txt`
2. Write the command and flags needed to see the file in `DirA`

## Part 4 - Regular `bob`

- **Useful commands for this part: `adduser, sudo, su, chown, pwd, cd, whoami, exit`**
- Mac users: see [note](#mac-users-note)

1. Create a new user named `bob`
2. What is the path to `bob`'s `home` directory?
3. Can your user add files to `bob`'s home directory? Why or why not?
4. Switch to the user `bob`
5. Get to `bob`'s `home` directory
6. Can `bob` add files to `bob`'s home directory? Why or why not?
7. Switch back to the your user
8. Return to the your user's `home` directory

## Part 5 - Get a `crew`

- **Useful commands for this part: `addgroup, usermod, chown, chgrp`**
- Mac users: see [note](#mac-users-note)

1. Create a new group named `crew`
2. Add your user and `bob` to the `crew` group
3. Change `DirA` in your user's home directory so that `crew` is the group for the whole folder
   - Yes, including contents in `DirA`
4. Switch user to `bob`
5. As `bob` create a file in `DirA`.
6. Why was this successful?

## Part 6 - [`sudo` make me a sandwich](https://xkcd.com/149/)

- **Useful commands for this part: `sudo`**
- Mac users: see [note](#mac-users-note)

1. In the your user's `home` directory, make a file with `sudo` named `sudowho.txt`
2. What are the permissions of this file?
3. Without modifying the permissions of the file, edit the file and add some text, and save the changes.

## Extra Credit - Test your skills

- **Useful commands for this part: All of the above!**
- Mac users: see [note](#mac-users-note)

1. Create a file in `DirB` with the following permission set:
   - `-rw------- sally crew [size] [datetime] mydiary.txt`
   - where `[size]` and `[datetime]` are going to be unique for you
   - write all steps needed to make this happen
2. Your user would like to edit `sally`'s `mydiary.txt` file, just to mess with her. How can your user do this without changing the permissions?
3. `bob` wants in on the joke to edit `sally`'s `mydiary.txt` file, just to mess with her. How can `bob` do this without changing the permissions?

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab01.md` file in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/blob/main/Lab01.md

## Rubric

- Each question is worth 1 point.
- This lab is worth a total of 26 points
- The extra credit is also worth 1 point per question
- This makes the extra credit worth ~11.54%

## Mac Users Note

You caught me, no, I have not played much with Macs. Command line management of users and groups on Mac OS is doable, but quite messy. Therefore, please take note of the following workaround.

It is easiest to come to campus and use WSL2 on the labs. If this is not possible for you for reasons:
This is a browser based Linux system (written in javascript; it's neat): https://bellard.org/jslinux/vm.html?url=alpine-x86.cfg&mem=192

Using the terminal provided here, you can create users, play with sudo, etc. By default, only the root user exists. In order to recreate the lab scenario, I recommend starting by creating a user that you can think of as yourself (useradd), then switch to that account (su). You'll need to make some directories in your user's directory to make things interesting, and the rest should be as expected.

Starting next week we will roll out access to AWS, which will help put everyone in a uniform environment and avoid conflicts of OS in the future.
