# Lab 04 - Task Manager Script

- [Lab Procedure](#lab-procedure)
- [Part 1 - Task Tracker](#part-1---task-tracker)
- [Part 2 - Sample Runs](#part-2---sample-runs)
- [Part 3 - PATH for all](#part-3---path-for-all)
- [Extra Credit - TODO](#extra-credit---todo)
- [Submission](#submission)
- [Rubric](#rubric)

## Lab Procedure

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Use `ssh` to connect to your AWS Ubuntu instance.

**PAUSE AND READ THIS**  Continuing with this lab you will be using your AWS instance to complete your coursework *in addition* to having it cloned to your personal system.  I would pick from one of two methods since you will now be able to access your repository from two different systems.

**Method 1**: Only work in the cloned folder on your AWS instance and use git commands to add your changes to commits, make commits, and push changes.  If you open the folder on your system (not the instance), you'll need to pull to synchronize.  

**Method 2**: Create the file for your answers on your system (not the AWS instance), and work on the script on the instance (in your repository folder).  As you make changes in the repository folder on one system you will need to remember to make commits, push the changes - *and then* pull those committed changes on the other system to get the folder up to date.

If a `push` / synchronize seems to fail / is blocked, you likely need to **pull**

**[OKAY, GO!](https://www.youtube.com/watch?v=qybUFnY7Y8w&ab_channel=OKGo)**

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab04`.

Create a file named `README.md` in the `Lab04` folder.  Copy into the file the contents of the [Lab 04 Template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab04/LabTemplate.md)

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

## Part 1 - Task Tracker

Use your AWS instance for this part.

The overall goal is to create a task tracking script using bash.  Your script will allow you to add tasks and complete (remove) them and will store the tasks in a file named `.tasks` in the user's `HOME` directory.

**BEFORE YOU BEGIN**
- One of `add` or `complete` or `view` must call a function that performs the actions described.  Your choice on which action is implemented as a function.
- You must have a **minimum** of **3 (THREE) COMMITS** made for this script.  Your commit messages must describe what's currently working / tested.  When (after which steps / testing) you make a commit is your choice.

**TASK TRACKER IMPLEMENTATION**

Create a script named `tt` for task tracker.

Your script must take one OR two arguments from the command line.  The first argument will always be the *task tracker* action - `add` or `complete`.  The second argument (if given) is a string, enclosed in quotes, that is the task description (ex. `"Walk the dog"`).

Your script must use a case statement to evaluate if the first argument contained `add` or `complete` or `view` or `clear` or `help` and do actions based on each.  If no valid action was given, output `Invalid argument` and print a user guide from the function `user-guide` and exit script.

If the action is to `add` a task, check if a second argument was given - if a second argument was not given, prompt the user for the task description.  Append the task to a file named `.tasks` in the user's `HOME` directory.  Let the user know the task was added.

If the action is to `complete` a task, check if a second argument was given - if a second argument was not given, prompt the user for the task description.  Remove the task from the file named `.tasks` in the user's `HOME` directory based on the description.  Let the user know if the task was successfully removed or if it was not found.

If the action is to `view`, output all tasks in the file named `.tasks` in the user's `HOME` directory.

If the action is to `clear`, prompt the user to confirm that they would like to remove all tasks, then remove the file named `.tasks` in the user's `HOME` directory.

If the action is to `help`, call the function `user-guide` and exits script.

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

The lab answer template will prompt you for notes and justifications for this part.

In Lab 03, you were asked to create a directory in which to place executable files - a directory that was specifically being tested for existence in your user's `.profile` file, which then appended that directory to `PATH` - if it existed.

This time, choose a directory that is available in any user's `PATH` variable - not one that would be uniquely appended only if the folder exists in their `HOME` directory.  

Read up on symbolic links vs hard links in Linux. Below is a reference - additional research is recommended to make sure you grasp the difference, and / or run some test cases to verify your understanding of how they work.
  - [Tecmint - Create Hard and Symbolic Links in Linux](https://www.tecmint.com/create-hard-and-symbolic-links-in-linux)

Create either a symbolic or a hard link between your `tt` script in your GitHub repository to one of the directory locations listed in `PATH`.

Make any required modifications to permissions and ownership.

Test that you can run your `tt` script from any location on the filesystem.

Test that other user's on the system can also execute the `tt` script.

## Extra Credit - TODO

Make the `tt` script better. Ideas:
- Make all task tracker actions utilize function calls
- Add action, `super-show` that shows all tasks in all `.tasks` files in any user's `HOME` directory
- Track task numbers so that the users can give a task number instead of the task description

If you have additional ideas, run them by the TA's first to see if they are worthy of this extra credit.

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab04` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab04
- Your `Lab04` folder should contain (at minimum):
  - `Lab04.md`
  - `tt`

## Rubric

- Part 1 - 10 pts
  - `tt` exists
  - `tt` uses case statement to evaluate if arg 1 was `add` or `complete` or `view` or `clear` or `help`; if none, outputs guide and exists
  - `tt` `add` and `complete` uses arg 2 or prompts user if arg 2 not given
  - ONE of `tt` `add`, `complete`, or `view` calls a function where task is performed
  - `tt` `add` appends task to `.tasks` in `HOME`
  - `tt` `complete` removes task from `.tasks` in `HOME`
  - `tt` `view` shows all tasks in `.tasks` in `HOME`
  - `tt` `clear` removes `.tasks` in `HOME`
  - `tt` `help` calls `user-guide` function
  - `tt` `user-guide` function outputs a well formatted, meaningful help guide to the user on script usage
- Part 2 - 2 pts
  - user guide is a well formatted, meaningful help guide to the user on script usage
  - sample inserted of script performing each action
- Part 3 - 6 pts
  - One point per response in answer template
- EC - 1.8 pts (10%)
    - can stack based on number of new features implemented
- Point Deductions:
    - (-1.8) pts (10%) - did not record a minimum of three commits while building the `tt` script.
  - added one of the suggested ideas or approved idea, additional documentation provided with description & proof of operation
