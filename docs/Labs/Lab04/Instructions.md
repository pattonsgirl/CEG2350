# Lab 04 - Finance Tracker

- [Lab Procedure](#lab-procedure)
- [Part 1 - Finance Tracker](#part-1---finance-tracker)
- [Part 2 - User Guide and Sample Runs](#part-2---user-guide-and-sample-runs)
- [Part 3 - PATH for all](#part-3---path-for-all)
- [Extra Credit - TODO](#extra-credit---todo)
- [Submission](#submission)
- [Rubric](#rubric)

## Lab Procedure

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Go to the folder that contains your repository (likely named `ceg2350f25-yourgithubusername`).

Create a new directory, `Lab04`

Create a file named `README.md` in the `Lab04` folder.  The [Lab 04 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab04/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab04/LabTemplate.md`

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

**Generative AI may not write your script for you, only assist with component and how-to type questions.**

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

## Part 1 - Finance Tracker

Use your AWS instance for this part.

The overall goal is to create a personal finance tracking script using bash.  Your script will allow you to add records and remove them and will store the records in a file named `.finances` in the user's `HOME` directory.

**BEFORE YOU BEGIN**
- One of `add` or `remove` or `view` must call a function that performs the actions required. It is your choice on which action is implemented as a function. The `user-guide` function is required per the assignment tasks.
- You must have a **minimum** of **3 (THREE) COMMITS** made for this script.  Your commit messages must describe what's currently working / tested.  When (after which steps / testing) you make a commit is your choice.

**FINANCE TRACKER IMPLEMENTATION**

Create a script named `ft` for finance tracker.

Your script must take one OR two arguments from the command line.  The first argument will always be the *finance tracker* action - `add` or `remove` or `view`.  The second argument (if given) is a string, enclosed in quotes, that is the record description (ex. `"Chipotle -12.50"`).

Your script must use a case statement to evaluate if the first argument contained `add` or `remove` or `view` or `clear` or `help` and do actions based on each.  If no valid action was given, output `Invalid argument` and print a user guide from the function `user-guide` and exit script.

If the action is to `add` a record, check if a second argument was given - if a second argument was not given, prompt the user for the record description.  Append the record to a file named `.finances` in the user's `HOME` directory.  Let the user know the record was added and exit script.

If the action is to `remove` a record, check if a second argument was given - if a second argument was not given, prompt the user for the record description.  Remove the record from the file named `.finances` in the user's `HOME` directory based on the description.  Let the user know if the record was successfully removed **or** if it was not found and exit script.

If the action is to `view`, output all records in the file named `.finances` in the user's `HOME` directory and exit script.

If the action is to `clear`, prompt the user to confirm that they would like to remove all records, then remove the file named `.finances` in the user's `HOME` directory and exit script.

If the action is to `help`, call the function `user-guide` and exit script.

The function `user-guide` must output, using good formatting, guidance and examples of how the user can interact with your script to have it `add` a record, `remove` a record, `view` all records, or show `help`.

**Resources**
- [Digital Ocean - How to Read Command Line Arguments in Shell Scripts?](https://www.digitalocean.com/community/tutorials/read-command-line-arguments-in-shell-scripts)
- [Linuxize - bash case statement](https://linuxize.com/post/bash-case-statement/)
- [Linuxize - bash functions](https://linuxize.com/post/bash-functions/)
- [Linux Handbook - Remove lines containing a string](https://linuxhandbook.com/remove-lines-file/#remove-lines-containing-a-string)
- [ShellCheck - finds bugs in your shell scripts](https://www.shellcheck.net/)

## Part 2 - User Guide and Sample Runs

Reformat the user-guide you have in your function to use markdown to cleanly present usage information.

Include some sample runs (using copy and paste in code blocks) of your script in action.

## Part 3 - PATH for all

Use your AWS instance for this part since your repository is cloned there and that is where your script should be.

The lab answer template will prompt you for notes and justifications for this part.

Choose a directory that is available in any user's `PATH` variable - not one that would be uniquely appended only if the folder exists in their `HOME` directory.  

Read up on symbolic links vs hard links in Linux. Below is a reference - additional research is recommended to make sure you grasp the difference, and / or run some test cases to verify your understanding of how they work.
  - [Tecmint - Create Hard and Symbolic Links in Linux](https://www.tecmint.com/create-hard-and-symbolic-links-in-linux)

Create either a symbolic or a hard link between your `ft` script in your GitHub repository to one of the directory locations listed in `PATH`.

Make any required modifications to permissions and ownership.

Test that you can run your `ft` script from any location on the filesystem.

Test that other user's on the system can also execute the `ft` script.

## Extra Credit - TODO

Make the `ft` script better. Ideas:
- Add action, `super-show` that shows all records in all `.finances` files in any user's `HOME` directory - the output should indicate which user in addition to that user's records
- Append record numbers so that the users can give a record number instead of a record description.  Numbers should be generated when the user gives a record.
- Append a date stamp (mm/dd/yyyy) to the record or the record file - allow a user to request a calculation of a total cost for a given day.

If you have additional ideas, run them by the TA's first to see if they are worthy of this extra credit.

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab04` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab04
- Your `Lab04` folder should contain (at minimum):
  - `README.md`
  - `ft`

## Rubric

Your files should be cleanly presented in your GitHub repository.  Citations should be included as needed.  Include which generative AI system was used and what prompts were used if generative AI was used.

[Rubric](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab04/Rubric.md)