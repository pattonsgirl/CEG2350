# Lab 04 - Task Tracker

- [Lab Procedure](#lab-procedure)
- [Part 1 - Task Tracker](#part-1---task-tracker)
- [Part 2 - User Guide and Sample Runs](#part-2---user-guide-and-sample-runs)
- [Part 3 - PATH for all](#part-3---path-for-all)
- [Extra Credit - TODO](#extra-credit---todo)
- [Submission](#submission)
- [Rubric](#rubric)

## Lab Procedure

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Go to the folder that contains your repository (likely named `ceg2350-lastname-f26`).

Create a new directory, `Lab04`

Create a file named `README.md` in the `Lab04` folder.  The [Lab 04 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab04/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab04/LabTemplate.md`

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

> **Generative AI may not write your script for you, only assist with component and how-to type questions.**

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

## Part 1 - Task Tracker

Use your AWS instance for this part.

Create a bash script named `tt` (task tracker) that lets a user add, remove, and view tasks stored in a `.tasks` file in the user's `HOME` directory.

> **BEFORE YOU BEGIN**
> One of the actions (`add`, `remove`, or `view`) must call a function that performs the required action — your choice which one.
> A `user-guide` function is mandatory.
> Make a **minimum of three commits** with descriptive messages indicating what's working and tested.

**TASK TRACKER IMPLEMENTATION**

Create a script named `tt` for task tracker.

Your script must take one OR two arguments from the command line.  The first argument will always be the *task tracker* action - `add` or `remove` or `view`.  The second argument (if given) is a string, enclosed in quotes, that is the task description (ex. `"Submit lab report"`).

Implement a case statement that evaluates the first argument. For an invalid action, output Invalid argument and call the user-guide function before exiting.

- `add` — Check whether a second argument was given; if not, prompt the user for the task description. Append the task to `.tasks` in `HOME`, confirm the addition, and `exit`.
- `remove` — Check whether a second argument was given; if not, prompt the user. Delete the matching task from `.tasks`, confirming success or reporting that the task wasn't found, then `exit`.
- `view` — Output all tasks currently in `.tasks` and `exit`.
- `clear` — Prompt the user for confirmation, then delete the `.tasks` file and `exit`.
- `help` — Call `user-guide` and `exit`.

The `user-guide` function must display well-formatted guidance and examples showing how to `add`, `remove`, and `view` tasks, and how to access help.

**Resources**
- [Digital Ocean - How to Read Command Line Arguments in Shell Scripts?](https://www.digitalocean.com/community/tutorials/read-command-line-arguments-in-shell-scripts)
- [Linuxize - bash case statement](https://linuxize.com/post/bash-case-statement/)
- [Linuxize - bash functions](https://linuxize.com/post/bash-functions/)
- [Linux Handbook - Remove lines containing a string](https://linuxhandbook.com/remove-lines-file/#remove-lines-containing-a-string)
- [ShellCheck - finds bugs in your shell scripts](https://www.shellcheck.net/)

## Part 2 - User Guide and Sample Runs

Reformat the user-guide you have in your function to use markdown to cleanly present usage information.

Include some sample runs (using copy and paste in code blocks) of your script in action.

**Resources**
- [Markdown Cheat Sheet - MarkdownGuide](http://markdownguide.org/cheat-sheet/)

## Part 3 - PATH for all

Use your AWS instance for this part since your repository is cloned there and that is where your script should be.

The lab answer template will prompt you for notes and justifications for this part.

Choose a directory that is available in any user's `PATH` variable - not one that would be uniquely appended only if the folder exists in their `HOME` directory.  

Read up on symbolic links vs hard links in Linux. Below is a reference - additional research is recommended to make sure you grasp the difference, and / or run some test cases to verify your understanding of how they work.
  - [Tecmint - Create Hard and Symbolic Links in Linux](https://www.tecmint.com/create-hard-and-symbolic-links-in-linux)

Create either a symbolic or a hard link between your `tt` script in your GitHub repository to one of the directory locations listed in `PATH`.

Make any required modifications to permissions and ownership.

Test that you can run your `tt` script from any location on the filesystem.

Test that other user's on the system can also execute the `tt` script.

## Part 4 - Citations / Resources

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations / Resources` section of your lab answers. You may refer to your own notes (if they are digitized into GitHub), course notes, or external resources / websites.

To add citations / resources, provide the reference / link and a summary of what it assisted you with.  

If generative AI was used, include which generative AI system was used, what prompt(s) you fed it, and a summary of what it assisted you with.

We expect a minimum of **one citation / useful resource per part** of your lab. So this lab would require a resource for:
- scripting (relevant to something this lab requires)
- markdown syntax reference
- PATH environment variable

## Extra Credit - TODO

> **BEFORE YOU BEGIN**
> Make sure your commit history shows a working script that meets the original requirements before you start adding extra credit features.

Enhance the `tt` script with ideas such as:

- A `super-show` action that displays all `.tasks` records across every user's `HOME` directory, labeled by user.
- Task numbering, so users can reference a task by number instead of by its exact description.
- Date stamps (mm/dd/yyyy) on each task, with the ability to list or count tasks added (or completed) on a given day.

For other ideas, check with your TAs first regarding eligibility.

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab04` folder in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-lastname-f26/tree/main/Lab04
- Your `Lab04` folder should contain (at minimum):
  - `README.md`
  - `tt`

## Rubric

Your files should be cleanly presented in your GitHub repository.  Citations should be included as needed.  Include which generative AI system was used and what prompts were used if generative AI was used.

[Rubric](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab04/Rubric.md)