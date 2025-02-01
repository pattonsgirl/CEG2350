# Lab 03

- [Lab Procedure](#lab-procedure)
- [Part 2 - IO Redirection](#part-2---io-redirection)
- [Part 3 - Rolling the Dice](#part-3---rolling-the-dice)
- [Part 4 - Retrospective](#part-4---retrospective)
- [Extra Credit - Room for Improvement](#extra-credit---room-for-improvement)
- [Submission](#submission)
- [Rubric](#rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/68834/modules/items/6128516)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab03`

This lab will have you creating input files, scripts, and output files. All of your work should be found in your `Lab03` folder.

Some questions will need you to write answers in `Lab03.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab03/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.


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


## Part 1 - git Guide

In your lab template, fill out the Description column with what the corresponding `git` command does.  You'll be using these commands all semester long to interact with your GitHub repository from your AWS instance.

| git command         | Description |
| ---                 | ---         | 
| `git clone repo_URI`|             |
| `git status`        |             |
| `git add filename`  |             |
| `git commit`        |             |
| `git push`          |             |
| `git pull`          |             |

**Resources**
- [freeCodeCamp - Learn the Basics of Git in Under 10 Minutes](https://www.freecodecamp.org/news/learn-the-basics-of-git-in-under-10-minutes-da548267cc91/)
   - this is a useful read to understand the context of what the above commands do.

## Part 2 - clone

`ssh` to your AWS instance for this part. It is highly recommended you look at the Resources listed below.

- **Useful commands for this part: `ssh-keygen`, `cat`, `git clone`**

1. Create an SSH key pair on your AWS Ubuntu instance.
2. Add the public key to GitHub
3. To clone your student repository for this course, go to your repository page in a browser: https://github.com/WSU-kduncan/ceg2350s25-YOURGITHUBUSERNAME
    - Select the Code dropdown.  Make sure SSH is selected.

- **Resources:**
- [GitHub - How to Use - My Guide](../../GitHubSetup.md)
- [GitHub - Generating a New SSH Key](https://docs.github.com/en/enterprise-server@3.3/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)
- [GitHub - Adding SSH key to your GitHub Account](https://docs.github.com/en/enterprise-server@3.0/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)

## Part 2 - IO Redirection

Find out what each command (including its flags) does and write a description beside it.  Don't forget to lookup commands & flags using `man` and / or some Google-fu (ability to use Google search) to find out. All of the commands can be run - a note is included if there is any additional setup to make it work.

Sample:
  - `echo "This is easy" > button`
  - Full credit: `echo` prints "This is easy" to standard output, which is redirected to the file named `button` in the current directory.  `button` now contains the text, "This is easy".

1. `printenv HOME > thishouse`
2. `cat doesnotexist 2>> hush.txt`
3. `cat nums.txt | sort -n >> all_nums.txt`
    - To run: create a file named `nums.txt` containing random numbers, each on a new line
4. `cat << "DONE" > here.txt`
5. `ls -lt ~ | head`
6. `history | grep ".md"`

**Resources:**
- [An Intro to Linux IO Redirection](https://www.digitalocean.com/community/tutorials/an-introduction-to-linux-i-o-redirection)
- [RedHat - How to manipulate files with shell redirection and pipelines in Linux](https://www.redhat.com/sysadmin/linux-shell-redirection-pipelining)
- [freeCodeCamp - How to Set an Environment Variable in Linux](https://www.freecodecamp.org/news/how-to-set-an-environment-variable-in-linux/)
- [Linuxize - How to Set and List Environment Variables in Linux](https://linuxize.com/post/how-to-set-and-list-environment-variables-in-linux/)

## Part 3 - Rolling the Dice

Use your AWS instance for this part since your repository is cloned there and `ssh` authentication with GitHub should be set up.  But I'm just a set of instructions with good advice.

The overall goal is to create a script that randomly generates a set of random numbers within the range specified by the script user.  In steps 1 - 5, assume you are rolling one die.

To complete the overall task, perform the steps listed below.  **After each step is complete and tested**, create a `commit` with your changes.  `push` `commit`s as you wish, just remember the `push` saves all the `commit`s to the mighty GitHub cloud.  **Your `commit` message must include which task you completed.**

If you don't make it through all of a step or don't complete all 6 steps, leave heavy comments for partial credit considerations.

1. Create a bash script named `roll`.  Output a random number between 1 and 20.
    - Script should run when `./roll` OR `bash roll` is typed on command line.  Think about permissions.
    - Output should say: `You rolled a ##`, where `##` is the randomly generated number.

2. Change script to prompt the user for a number.  If the number is less than 1, output an error message.  Output a random number between 1 and the user's number.

3. Change script to take an argument from the command line instead of prompting the user.  If no argument is passed, output an error message.  Output a random number between 1 and the argument passed.
    - Script should run when `./roll ##` is typed on command line, where `##` is a number

4. Change script to also check if the given argument is greater than 1.  If no argument was given, prompt user for a number, and check that it was greater than 1.  Output a random number between 1 and the number.

5. Change the script to prompt the user for a valid number if the argument was not provided or was not greater than 1.  Prompting continues until a number greater than 1 is given.  Output a random number between 1 and the valid number.

6. Change script to take **two** arguments from the command line.  The first argument will indicate number of dice to roll.  The second will indicate how many sides of the dice.  If there are less than or more than two arguments, or if the arguments are not greater than one, prompt the user for valid values for number of dice and number of side.  Output a random number between 1 and the number of sides for each die.
    - Script should run when `./roll ## ##` is typed on command line.
    - Output should say: `Die 1 rolled a ##    Die 2 rolled a ##`, where `##` are two randomly generated numbers, one for each die.

**Resources:**
- [IO Flood: Bash Shell Scripting | Random Number Generation](https://ioflood.com/blog/bash-random-number/)
- [IO Flood: Bash read man page | Using the Linux read command](https://ioflood.com/blog/bash-read-man-page-using-the-linux-read-command/)
- [Digital Ocean - How to Read Command Line Arguments in Shell Scripts?](https://www.digitalocean.com/community/tutorials/read-command-line-arguments-in-shell-scripts)
- [Cloudzy - Bash If Statement: Syntax, Variations, Use Cases, Commands, and More!](https://cloudzy.com/blog/bash-if-statement/)
- [IO Flood - Bash While Loop: Shell Scripting Reference Guide](https://ioflood.com/blog/bash-while-loop/)
- [ShellCheck - finds bugs in your shell scripts](https://www.shellcheck.net/)

## Part 4 - Retrospective

A retrospective is a moment of refection after a task.

1. Where and when did it go wrong while working on your script tasks?
2. Was anything familiar working with a new language compared to one you are used to?
3. Assuming you `push`ed your `commit`s to GitHub, view your `commit` history.  Did you write good `commit` messages that refer to what tasks were completed at each commit?  What would you improve?

## Extra Credit - Room for Improvement

Make a notable improvement to the `roll` script.  This could be another feature, an additional boundary check on allowed conditions, experimenting with colored text for standard and error output... If you have an idea, you are encouraged to run it by the TAs first to make sure it is worthy.

Make sure you `commit` and `push` your script changes for grading and add a note of what you did in the answer template.

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab03` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab03
- Your `Lab03` folder should contain (at minimum):
  - `Lab03.md`
  - `roll`

## Rubric

- Part 1 - 3 pts
  - 0.5 pts / question
- Part 2 - 6 pts
- Part 3 - 6 pts
  - minimum of 6 commits, each commit completes 1 task
  - 1 complete task = 1 pt
- Part 4 - 3 pts
- Extra Credit - 1 pt
- Point deductions:
  - minus 2 pts = no commits for each part && no commit messages indicating parts building on each other
  - minus 1 pt = commits / comments indicate parts building on each other, but not all commits were broken out as asked
