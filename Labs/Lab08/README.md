# Lab 08

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - To Infinity](#Part-1---To-Infinity)
- [Part 2 - Running Processes](#Part-2---Running-Processes)
- [Part 3 - `branch`ing out](#Part-3---`branch`ing-out)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/13249/modules/items/1136419)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab08`

Write anwers in `Lab08.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab08/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - To Infinity

1. In your `Lab08` folder, create a script called `infinity`.
2. Each time the loop runs it should do the following
   - Output a statement such as "Still going!" to a file called `still-going.txt`
   - Sleep for 15 seconds
   - Repeat. Infinitely!
3. Give this script executable permissions (but don't worry about adding to PATH)

- Resources:
  - [bash while loop](https://linuxize.com/post/bash-while-loop/)
  - [sleep bash scripting](https://www.cyberciti.biz/faq/linux-unix-sleep-bash-scripting/)

## Part 2 - Running Processes

For the following exercises, you are going to have two terminals open to your AWS instance, which will be refered to as Terminal A and Terminal B. We can't give terminals names, but we needed some way to say where to run what ;)

- **Useful Commands: `pstree`, `ps`, `kill`, `bg`, `job`, `fg`, `screen`, `tmux`**

1. Connect to your AWS system in two different terminals. Find the process IDs for each terminal.
   - Command to find the PID:
   - PID of "Terminal A":
   - PID of "Terminal B":
2. Use `./` to run `infinity` in Terminal B. Use Terminal A to find the PID, then kill the process
   - PID of script:
   - Command to kill script:
   - Can you still "use" Terminal B with `infinity` running?
3. Use `source` to run `infinity` in Terminal B. Use Terminal A to find the PID, then kill the process
   - PID of script:
   - Command to kill the script:
   - When you killed the script, what else was terminated?
4. Run `infinity` as a background job in Terminal B.
   - Command to run script in background:
   - Job ID of script:
   - PID of script:
   - Command to kill script via job id:
   - If you close Terminal B, is the job still running? Why or why not?
5. Run `infinity` in a `screen` or `tmux` session
   - Command(s) to run `infinity` in a screen session:
   - Detach from `screen` / `tmux` session:
   - Command to show `screen` / `tmux` sessions:
   - If you close Terminal B, is the screen session with `infinity` still running? Why or why not?
   - Command / steps to kill the `screen` / `tmux` session:

- Resources:
  - [How To Use Bash's Job Control to Manage Foreground and Background Processes](https://www.digitalocean.com/community/tutorials/how-to-use-bash-s-job-control-to-manage-foreground-and-background-processes)
  - [Understanding foreground and background Linux processes](https://linuxconfig.org/understanding-foreground-and-background-linux-processes)
  - [How to Use Linux Screen Command](https://www.howtogeek.com/662422/how-to-use-linuxs-screen-command/)
  - [Kill detached screen session](https://www.baeldung.com/linux/kill-detached-screen-session)

## Part 3 - `branch`ing out

For each step below, write the corresponding command(s) to do the action requested. We will be looking at your repos to make sure the branch exists.

1. Create a branch in your git repository called `updates`
2. Switch to the branch.
3. Edit `infinity` with some comments
   - comments in bash have a hashtag `#` at the start of the line followed by a space
4. Commit and push your changes made on your branch to remote (GitHub)
   - Note: if you try `git push` git will spit out a helpful hint
5. In the browser, go to your GitHub repo, and switch to view the `updates` branch instead of `main`
   - confirm that your edits to `infinity` exist in the `updates` branch's version of the file, but not in the `main` branch's version.
6. Back in your terminal, switch back to the `main` branch.
7. Merge the changes from the `updates` branch with the `main` branch.
8. Push the `main` branch to remote (GitHub).
9. In GitHub, confirm your changes to `infinity` now also exist in the `main` branch
10. Back in your terminal, how can you find out what branch you are on?

- Resources:

  - [Git Branches in a Nutshell](https://git-scm.com/book/en/v2/Git-Branching-Branches-in-a-Nutshell)
  - [Git - Basic Branching & Merging](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging)

## Submission

1. Verify that your GitHub repo has a `Lab08` folder with at minimum:

   - `infinity`
   - `Lab08.md`

2. In the Pilot Dropbox, paste the URL to the `Lab08` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab08

## Rubric

- Part 1 - (3 pts)
  - while loop
  - outputs text to file
  - uses sleep command to slow down output spam
- Part 2 - 10 pts
  - 2 pts / question
- Part 3 - 10 pts
  - 1 pt / question
