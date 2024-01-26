# Lab 03

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - IO Redirection](#Part-1---IO-Redirection)
- [Part 2 - Intro to Scripts](#Part-2---Intro-to-Scripts)
- [Part 3 - Intro to Regular Expressions](#Part-3---Intro-to-Regular-Expressions)
- [Part 4 - Docs and Repos](#Part-4---Docs-and-Repos)
- [Part 5 - .profile and PATH](#Part-5---.profile-and-PATH)
- [Extra Credit - Colorize Me, Captain](#Extra-Credit---Colorize-Me,-Captain)
- [Submission](#Submission)
- [Rubric](#Rubric)

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

## Part 1 - IO Redirection

- **Resources:**
- [An Intro to Linux IO Redirection](https://www.digitalocean.com/community/tutorials/an-introduction-to-linux-i-o-redirection)

## Part 2 - Rolling the Dice

It is recommended to use your AWS instance for this part since your repository is cloned there and `ssh` authentication with GitHub should be set up.  But I'm just a set of instructions with good advice.

The overall goal is to create a script that randomly generates a set of random numbers within the range specified by the script user.  In steps 1 - 5, assume you are rolling one die.

To complete the overall task, perform the steps listed below.  After each step is complete and tested, create a `commit` with your changes.  `push` `commit`s as you wish, just remember the `push` saves all the `commit`s to the mighty GitHub cloud.

If you don't make it through all of a step or don't complete all 6 steps, leave heavy comments for partial credit considerations.

1. Create a bash script named `roll`.  Output a random number between 1 and 20.
    - Script should run when `roll` is typed on command line.  Think about permissions.
    - Output should say: `You rolled a ##`, where `##` is the randomly generated number.

2. Change script to prompt the user for a number.  If the number is less than 1, output an error message.  Output a random number between 1 and the user's number.

3. Change script to take an argument from the command line instead of prompting the user.  If no argument is passed, output an error message.  Output a random number between 1 and the argument passed.
    - Script should run when `roll ##` is typed on command line, where `##` is a number

4. Change script to also check if the given argument is greater than 1.  If no argument was given, prompt user for a number, and check that it was greater than 1.  Output a random number between 1 and the number.

5. Change the script to prompt the user for a valid number if the argument was not provided or was not greater than 1.  Prompting continues until a number greater than 1 is given.  Output a random number between 1 and the valid number.

6. Change script to take **two** arguments from the command line.  The first argument will indicate number of dice to roll.  The second will indicate how many sides of the dice.  If there are less than or more than two arguments, or if the arguments are not greater than one, prompt the user for valid values for number of dice and number of side.  Output a random number between 1 and the number of sides for each die.
    - Script should run when `roll ## ##` is typed on command line.
    - Output should say: `Die 1 rolled a ##    Die 2 rolled a ##`, where `##` are two randomly generated numbers, one for each die.

**Resources:**
- [IO Flood: Bash Shell Scripting | Random Number Generation](https://ioflood.com/blog/bash-random-number/)
- [IO Flood: Bash read man page | Using the Linux read command](https://ioflood.com/blog/bash-read-man-page-using-the-linux-read-command/)
- [Digital Ocean - How to Read Command Line Arguments in Shell Scripts?](https://www.digitalocean.com/community/tutorials/read-command-line-arguments-in-shell-scripts)
- [Cloudzy - Bash If Statement: Syntax, Variations, Use Cases, Commands, and More!](https://cloudzy.com/blog/bash-if-statement/)
- [IO Flood - Bash While Loop: Shell Scripting Reference Guide](https://ioflood.com/blog/bash-while-loop/)
- [ShellCheck - finds bugs in your shell scripts](https://www.shellcheck.net/)

## Part 3 - Retrospective

A retrospective is a moment of refection after a task.

1. Where and when did it go wrong while working on your script tasks?
2. Was anything familiar working with a new language compared to one you are used to?
3. Assuming you `push`ed your `commit`s to GitHub, view your `commit` history.  Did you write good `commit`` messages that refer to what tasks were completed at each commit?  What would you improve?

## Part 4 - .profile and PATH

In this part, your task is to read `~/.profile` and focus on the `if` statements that would change the value of `PATH`, `if` they were `true`.  Your goal is to create the things needed for **one** of the conditions to evaluate to `true`.  

DO NOT MODIFY THE CONTENT of the `.profile` file.  Right now, both conditions evaluate to `false`.  
  - Remember, the `test` command is what is being used when you see `[` (square brackets).  
  - The flag / relational condition being checked is an option of the `test` command.

1. What is the current value of the `PATH` environment variable?

2. Read through your `~/.profile`. Determine where your binary files and scripts should go in order to be part of the `PATH` variable. Write the directory path.

3. Make the folder required in the location required. Write the command(s) used and the full path of the folder.

4. Reload `~/.profile` either with `source` or by closing and opening the terminal. What is the value of the `PATH` environment variable? What was added now vs. in your answer to 1?

5. Copy `roll` into the folder. Write the command(s) used.

6. Modify the permissions so that you can run your script on the command line from any location. Write the modifications needed.
   - Note: if you already modified permissions, fill in this question with what you modified.

8. In terms of user, group, and other, explain who is allowed to run the script.

## Extra Credit - Room for Improvement

Make a notable improvement to the `roll` script.  This could be another feature, an additional boundary check on allowed conditions, experimenting with colored text for standard and error output... If you have an idea, you are encouraged to run it by the TAs first to make sure it is worthy.

Make sure you `commit` and `push` your script changes for grading and add a note of what you did in the answer template.

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab03` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab03

## Rubric

- Part 1 - 2 pts
- `sorting-party` script can do the following: (5 pts total)
  - Reads in a filename as an argument - 1 pt
  - Sorts the contents of the file given in the argument using the `sort` command - 1 pt
  - Outputs the sorted data to a file called `sorted.txt` - 1 pt
  - Condition verifies input file has extension `.txt` - 1 pt
  - If condition is not met, error message is output to standard output - 1 pt
- Part 4 - 2 pts
  - script usage guide - 1 pt
  - specified files exist in `Lab03` folder - 1 pt
- Part 5 - 3.5 pts total
  - 0.5 pts each
- The extra credit is worth 5% 
  - translates to 0.625 pts