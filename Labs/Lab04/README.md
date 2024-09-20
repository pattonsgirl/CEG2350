# Lab 04 - UNRELEASED

- [Lab Procedure](#lab-procedure)
- [Part 1 - Task Tracker](#part-1---task-tracker)
- [Part 2 - Sample Runs](#part-2---sample-runs)
- [Part 3 - PATH for all](#part-3---path-for-all)
- [Extra Credit - TODO](#extra-credit---todo)
- [Submission](#submission)
- [Rubric](#rubric)

## Lab Procedure

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab04`

This lab will have you creating input files, scripts, and output files. All of your work should be found in your `Lab04` folder.

Some questions will need you to write answers in `Lab04.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab04/LabTemplate.md)

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - Task Tracker

Use your AWS instance for this part since your repository is cloned there and `ssh` authentication with GitHub should be set up.  But I'm just a set of instructions with good advice.

The overall goal is to create a task tracking script using bash.  Your script will allow you to add tasks and complete (remove) them and will store the tasks in a file named `.tasks` in the user's `HOME` directory.

**BEFORE YOU BEGIN**
- One of `add` or `complete` or `view` must call a function that performs the actions described.  Your choice on which action is implemented as a function.
- You must have a **minimum** of **3 (THREE) COMMITS** made for this script.  Your commit messages must describe what's currently working / tested.  When (after which steps / testing) you make a commit is your choice.

Create a script named `tt` for task tracker.

Your script must take one OR two arguments from the command line.  The first argument will always be the *task tracker* action - `add` or `complete`.  The second argument (if given) is a string, enclosed in quotes, that is the task description (ex. `"Walk the dog"`).

Your script must use a case statement to evaluate if the first argument contained `add` or `complete` or `view` or `clear` or `help` and do actions based on each.  If no valid action was given, output `Invalid argument` and print a user guide from the function `user-guide`.

If the action is to `add` a task, check if a second argument was given - if a second argument was not given, prompt the user for the task description.  Append the task to a file named `.tasks` in the user's `HOME` directory.  Let the user know the task was added.

If the action is to `complete` a task, check if a second argument was given - if a second argument was not given, prompt the user for the task description.  Remove the task from the file named `.tasks` in the user's `HOME` directory based on the description.  Let the user know if the task was successfully removed or if it was not found.

If the action is to `view`, output all tasks in the file named `.tasks` in the user's `HOME` directory.

If the action is to `clear`, prompt the user to confirm that they would like to remove all tasks, then remove the file named `.tasks` in the user's `HOME` directory.

If the action is to `help`, call the function `user-guide`.

The function `user-guide` outputs, using good formatting, guidance and examples of how the user can interact with your script to have it `add` a task, `complete` a task, `view` all tasks, or show `help`.

**Resources**
- [Digital Ocean - How to Read Command Line Arguments in Shell Scripts?](https://www.digitalocean.com/community/tutorials/read-command-line-arguments-in-shell-scripts)
- [Linuxize - bash case statement](https://linuxize.com/post/bash-case-statement/)
- [Linuxize - bash functions](https://linuxize.com/post/bash-functions/)
- [Linux Handbook - Remove lines containing a string](https://linuxhandbook.com/remove-lines-file/#remove-lines-containing-a-string)
- [ShellCheck - finds bugs in your shell scripts](https://www.shellcheck.net/)

## Part 2 - Sample Runs

Reformat the user-guide you have in your function to use markdown to cleanly present usage information.

Include some sample runs (using copy and paste in code blocks) or your script in action.

## Part 3 - PATH for all

Use your AWS instance for this part since your repository is cloned there and that is where your script should be.

In Lab 03, you were asked to create a directory in which to place executable files - a directory that was specifically being tested for existence in your user's `.profile` file, which then appended that directory to `PATH` - if it existed.

This time, choose a directory that is available in any user's `PATH` variable - not one that would be uniquely appended only if the folder exists in their `HOME` directory.  

Read up on symbolic links vs hard links in Linux.  

Create either a symbolic or a hard link between your `tt` script in your GitHub repository to one of the directory locations listed in `PATH`.

Make any required modifications to permissions and ownership.

Test that you can run your `tt` script from any location on the filesystem.

Test that other user's on the system can also execute the `tt` script.

## Extra Credit - TODO

Make the `tt` script better. Ideas:
- Track task numbers so that the users can give a task number instead of the task description
- 

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab04` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab03
- Your `Lab03` folder should contain (at minimum):
  - `Lab04.md`
  - `tt`

## Rubric

- Part 1
