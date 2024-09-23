# Lab 03

- [Lab Procedure](#lab-procedure)
- [Part 1 - `config` your connection](#part-1---config-your-connection)
- [Part 2 - IO Redirection](#part-2---io-redirection)
- [Part 3 - Rolling the Dice](#part-3---rolling-the-dice)
- [Part 4 - Retrospective](#part-4---retrospective)
- [Part 5 - .profile and PATH](#part-5---profile-and-path)
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

## Part 1 - `config` your connection

On your local system (`exit` from your AWS instance), you used an SSH command to log on to your AWS Ubuntu instance. There is a neat configuration file that can be used to create an alias of sorts. Read the resources for this section, then configure the `.ssh/config` file for your user on your system with information on your `ssh` connection to your AWS instance.

1. Write the command you have been using to `ssh` in to your AWS instance.
2. Provide the HostName (IP address) of your AWS Ubuntu instance:
3. Provide the user name that you are logging on to the system with:
4. Provide the absolute / full path to the private key (Identity File) on your local system:
5. On your local system, edit `~/.ssh/config` to contain an entry with information about logging on to your AWS Ubuntu instance.  Note that the answer template wants the contents you wrote to the file.
6. Write the new form of the `ssh` command to connect to your AWS instance.

- **Resources**
- [linuxize - Using the ssh config file](https://linuxize.com/post/using-the-ssh-config-file/)
- [cyberciti.biz - config file examples](https://www.cyberciti.biz/faq/create-ssh-config-file-on-linux-unix/)
- The `Port`, if you wish to include it in your `config` is `22`


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

## Part 5 - .profile and PATH

Use your AWS instance for this part since your repository is cloned there and that is where your script should be.

The overall goal is to, from any directory, able to refer to your script by name, `roll`, and have your script execute.  To do so, `roll` needs to have the correct permissions **and** be located in a directory listed in `PATH`.

In this part, your task is to read `~/.profile` and focus on the `if` statements that would change the value of `PATH`, **if** one of the statements was `true`.

DO NOT MODIFY THE CONTENT of the `.profile` file.  Right now, both conditions evaluate to `false`. 
  - Think about how you could confirm that statement - that both conditions are currently `false`.
  - Remember, the `test` command is what is being used when you see `[` (square brackets).  
  - The flag / relational condition being checked is an option of the `test` command.

1. What is the value of the `PATH` environment variable?

2. Read through `ubuntu`'s `~/.profile`.  Pick one condition to make `true` that, if `true`, will add the directory to be part of the `PATH` variable.  What needs to happen to make the condition `true` (what currently **does not exist**)?

3. Based on your evaluation above, use commands to create what is necessary to have the condition evaluate to `true`.

4. Reload / run the statements in `~/.profile` either with `source` or by logging out and `ssh`ing back in. 
  - What is the value of the `PATH` environment variable? 
  - What was added now vs. in your answer to question 1?

5. Copy `roll` into the folder. Write the command(s) used.
  - Note: for added fun, do a symbolic link or hard link to the original script.  Not going to show you how yet, but try Google-ing to see if you can crack it.

6. Modify the script's permissions and / or interpreter so that you can run your script on the command line from any location. Write the modification explanations and commands needed.
    - You can now run `roll` (without the leading `./` or `bash`) from anywhere
    - Note: if you already modified permissions, fill in this question with what you modified since scripts are not executable by default.

7. In terms of user, group, and other, explain who is allowed to run the script.

**Resources**
- [Tecmint - About PATH and options to modify it](https://www.tecmint.com/set-path-variable-linux-permanently/)

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

- Part 1 - 6 pts
- Part 2 - 3 pts
  - 0.5 pts / question
- Part 3 - 6 pts
- Part 4 - 6 pts
  - minimum of 6 commits, each commit completes 1 task
  - 1 complete task = 1 pt
- Part 5 - 3 pts
- Part 6 - 0.5 pts each / 3.5 pts total
- Extra Credit - 1 pt
- Point deductions:
  - minus 2 pts = no commits for each part && no commit messages indicating parts building on each other
  - minus 1 pt = commits / comments indicate parts building on each other, but not all commits were broken out as asked
