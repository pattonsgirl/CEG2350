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

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/13249/modules/items/1136419)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab03`

This lab will have you creating input files, scripts, and output files. All of your work should be found here.

Some questions will need you to write anwers in `Lab03.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab03/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - IO Redirection

This and the following parts are meant to be done in your AWS instance in your `Lab03` folder in your repo. You can still stick with the two terminal flow for fun, whatever is floating your boat.

- **Useful commands for this part: `man, vim, sort, <, >, >>`**

1. Create a file called `input.txt` with the following contents:

```
9.1
43.7
2.2
62.1
2.1
9.3
43.5
4.6
44.6
4.7
42.7
47.4
46.6
4.5
55.6
4
9.2
66.6
2
2.3
```

2. Use the `sort` command to sort `input.txt`.
3. Use the `sort` command to sort `input.txt` and direct the output to `output.txt`.

- **Resources:**
- [An Intro to Linux IO Redirection](https://www.digitalocean.com/community/tutorials/an-introduction-to-linux-i-o-redirection)
- [IO Redirection](https://tldp.org/LDP/abs/html/io-redirection.html)
- [Unix `sort` command](https://www.computerhope.com/unix/usort.htm)

## Part 2 - Intro to Scripts

1. Create a bash script called `sorting-party`. The script should have the following features:

   - Reads in a filename as an argument.
     - Runs with `sorting-party filename`
   - Sorts the contents of the file given in the argument using the `sort` command.
   - Outputs the sorted data to a file called `sorted.txt`

- Hint: To run your script you may need / want to play with the file permissions.

- **Resources:**
- [Command Line Arguments in Shell Script](https://tecadmin.net/tutorial/bash-scripting/bash-command-arguments/)
- [Use Command Line Arguents in Bash Script](https://www.baeldung.com/linux/use-command-line-arguments-in-bash-script)
- [Positional Parameters](http://linuxcommand.org/lc3_wss0120.php)

## Part 3 - Intro to Regular Expressions

1. Add an `if` statement to your script that checks if the file in the argument ends in `.txt`
2. If the file does **not** end in `.txt` your script should exit with an error message: `File extension not allowed`

- Hint: maybe make some other files with other file extensions to test your conditional statement

- **Resources:**
- [How to Use Regex in Bash](https://www.poftut.com/how-to-use-regular-expression-regex-in-bash-linux/)
- [Regex 101](https://regex101.com/)

## Part 4 - Docs and Repos

1. Fill in the "Script Usage Guide" section with at least the specified elements
   - You are welcome to replace this with any additonal markdown you would like to make it look good
2. Verify that your GitHub repo has a `Lab03` folder with:
   - `input.txt`
   - `output.txt`
   - `sorting-party`
   - `Lab03.md`

## Part 5 - .profile and PATH

1. What is the value of the `PATH` environment variable?

2. Read through your `~/.profile`. Determine where your binary files and scripts should go in order to be part of the PATH variable. Write the path.

3. Make the folder required in the location required. Write the command(s) used and the full path of the folder.

4. Reload `~/.profile` either with `source` or by closing and opening the terminal. What is the value of the `PATH` environment variable? What was added now vs. in your answer to 1?

5. Copy `sorting-party` into the folder. Write the command(s) used.

6. Modify the permissions so that you can run your script on the command line from any location. Write the modifications needed.

7. In terms of user, group, and other, explain who is allowed to run the script.

## Extra Credit - Colorize Me, Captain

Colorize the error condition from your script (`File format not allowed`). Maybe go for traditional red? How does purple make you feel? Rainbow and plaid are also welcome to this party.

Make sure you `commit` and `push` your script changes for grading.

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab03` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab03

## Rubric

- Part 1 - 2 pts
- `sorting-party` script can do the following: (5 pts total)
  - Reads in a filename as an argument - 1 pt
  - Sorts the contents of the file given in the argument using the `sort` command - 1 pt
  - Outputs the sorted data to a file called `sorted.txt` - 1 pt
  - Condition verifies input file has extension `input.txt` - 1 pt
  - If condition is not met, error message is output to standard output - 1 pt
- Part 4 - 2 pts
  - script usage guide - 1 pt
  - specificed files exist in `Lab03` folder - 1 pt
- Part 5 - 3.5 pts total
  - 0.5 pts each
- The extra credit is worth 0.625 pts
  - translates to 5%
