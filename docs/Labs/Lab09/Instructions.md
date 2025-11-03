# Lab 09 - Process Control

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Game the System](#part-1---game-the-system)
- [Part 2 - Process Control](#part-2---process-control)
- [Part 3 - back and fore](#part-3---back-and-fore)
- [Part 4 - Detach](#part-4---detach)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab09`.

Create a file named `README.md` in the `Lab09` folder.  The [Lab 09 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab09/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab09/LabTemplate.md`

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

## Can't SSH?

If you cannot `ssh` to your instance anymore, you may have run into one of these scenarios:
- You overwrote the partition table (or partitions) in `xvda` - this would erase your `root` / `/` filesystem.
- You wrote a bad entry in `/etc/fstab` - if the system cannot mount the disk, the boot process will hang and not complete 

If you think one of those scenarios happened to you, you'll need to go back to [AWS Academy Setup](/CEG2350/Topics/AWSAcademy/) and create a new stack. Once you are in the new instance, don't forget the steps to cloning your GitHub repo:
1. create a new keypair for authentication to GitHub
2. add the public key to your GitHub user settings
3. clone with `ssh`

## Part 1 - Game the system

- **Useful commands: `apt`, `which`, `whereis`**

Choose a command line game from this site: [It's Foss - Top 10 Command Line Games for Linux](https://itsfoss.com/best-command-line-games-linux/)
   - `bastet` is what this lab was tested on

In the answer template, document the game name, how you installed it, where the executable is located, and how to run the game.

For the remainder of this lab, you will be running this game to practice controlling processes.

## Part 2 - Process control

Create a second `ssh` session to your AWS instance.  You should now have two `ssh` sessions to your AWS instance.  This will be referred to as Shell A and Shell B in the exercises below - you decide which is A and which is B.

- **Useful Commands: `pstree`, `ps`, `kill`, `pgrep`, `top` / `htop`**

1. Fill out the following table of process related commands:

|  Action   |  Command or Keybind   |  
| ---       | --- | 
| Check process CPU/memory usage |     |
| Show running processes         |     |
| Show detailed process tree     |     |
| Find a process by name         |     |
| Kill a process by PID          |     |
| Force kill a process by PID    |     |
| Pause / suspend a process by PID  |     |
| Resume a suspended process by PID |     |

2. Explain the meaning of the following `ps` fields:

| `ps` field | Meaning |
| ---        | ---     |
| PID        |         |
| PPID       |         |
| UID / USER |         |
| TTY        |         |
| STAT       |         |
| COMMAND / CMD |         |
| %CPU       |         |
| %MEM       |         |
| PSR        |         |

3. Craft a `ps` command for processes owned by your user that will show the fields: USER / UID, PID, PPID, TTY, STAT, and COMMAND / CMD
4. In Shell A, run the game.  Using Shell B, run your `ps` command.
Provide answers to the following, using Shell B to observe the process statuses:
5. For the game:
   - What is it's process id?
   - What is it's parent process id?
   - What process is the parent process?
6. Use `kill` to kill only the game.
   - Describe what the effect was.
7. [Run the game again] Use `kill` to kill the game and it's parent process.
   - Describe what the effect was.
8. Create a new `ssh` session - Shell C - and run the game again.  Watch the processes from the other terminal.  Describe what happens, using process knowledge in your description, **if you close / `exit` your connection with Shell C and determine if you can reenter the game (resume the process)**.

**Resources**
- [Linuxize - Ps Command in Linux (List Processes)](https://linuxize.com/post/ps-command-in-linux/)
- [Digital Ocean - How To Use `ps`, `kill`, and `nice` to Manage Processes in Linux](https://www.digitalocean.com/community/tutorials/how-to-use-ps-kill-and-nice-to-manage-processes-in-linux)

## Part 3 - back and fore

- **Useful Commands: `pstree`, `ps`, `kill`, `bg`, `job`, `fg`**

1. Fill out the following table of job control commands and keybinds:

|  Action   |  Command or Keybind   |  
| ---       | --- | 
| Show current jobs               |     |
| Run a command in background     |     |
| Pause current foreground job    |     |
| Send job to the background      |     |
| Bring job to the foreground     |     |
| Kill a background / stopped job |     |

2. Run the game in the foreground.  
3. Send a `STOP` signal to suspend it.
4. Use `ps` to confirm the process is still alive, but has been stopped.  Provide the line of output that relates to the process.
5. Resume the process in the foreground.
6. Send a `TERMINATE` signal to kill it.
7. Start the game as a background process.  Repeat 3 times.
8. Display the output of `jobs` and your custom output format `ps` command
   - If `jobs` is empty, make sure you are running it in the same shell, the controlling terminal, that you created the background jobs.
9. Kill one job.
10. Move one job to the foreground.
11. Describe what happens, using process knowledge in your description, if you close / `exit` your connection with this shell and determine if you can reenter the game (resume the process).

**Resources**
- [Introduction To Unix Signals Programming - Sending Signals To Processes](https://www.cs.kent.edu/~ruttan/sysprog/lectures/signals.html)
- [Digital Ocean - How To Use Bash's Job Control to Manage Foreground and Background Processes](https://www.digitalocean.com/community/tutorials/how-to-use-bash-s-job-control-to-manage-foreground-and-background-processes)

## Part 4 - Detach

The perhaps obtuse goal of the previous two exercises is to understand process control, but also to realize that with these methods, your shell connection must remain active.  If you end your shell session, the processes attached to it also end.  There are tools that allow you to run processes detach from your shell session.  This lab will have you use `tmux`, but other tools exist.

1. Fill out the following table of `tmux` commands and keybinds:

|  Action   |  Command or Keybind   |  
| ---       | --- | 
| Start a new session and set a name   |     |  
| List `tmux` sessions                 |     |
| Attach to session by name            |     |
| Kill session by name                 |     |
| Detach from session                  |     |
| Split pane horizontally              |     |
| Split pane vertically                |     |
| Switch panes                         |     |
| Close pane                           |     |

2. Create a `tmux` session.  Run the game in the session.
3. Leaving your game running, detach from the session.
4. Run your custom formatted `ps` command, showing processes without a controlling terminal
5. Use `tmux` to list sessions
6. Close your `ssh` shell session to your instance, then `ssh` in again.  How can you determine if your `tmux` session with your game running is available?
7. Reattach to your `tmux` session running the game.
8. Kill the `tmux` session

**Resources**
- [RedHat - A beginner's guide to `tmux`](https://www.redhat.com/sysadmin/introduction-tmux-linux)

## Submission

1. Verify that your GitHub repo has a `Lab09` folder with at minimum:

   - `README.md`

2. In the Pilot Dropbox, paste the URL to the `Lab09` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab09

## Rubric

Your files should be cleanly presented in your GitHub repository.  Citations should be included as needed.  Include which generative AI system was used and what prompts were used if generative AI was used.

[Rubric](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab09/Rubric.md)
