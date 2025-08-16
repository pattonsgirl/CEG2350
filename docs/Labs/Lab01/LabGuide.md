# Getting Started with GitHub

Let's talk about GitHub. 
> GitHub is a website and cloud-based service that helps developers store and manage their code, as well as track and control changes to their code. - [Kinsta](https://kinsta.com/blog/what-is-github/)

For this course you'll be using GitHub, but do be aware there are others:
- GitLab
- BitBucket
- Azure DevOps
- AWS CodeCommit
- Google Cloud Source Repositories

Over this course, you'll come to know `git` which is a stand alone software. The list above all use git as the underlying tool for version control and overlay web interfaces on top.  The good news - they all have different branding around very similar features.

Think of a GitHub username. Keep it professional
- firstname-lastname or FirstnameLastname or some variant are recommended
- people *sometimes* create a separate account for companies they work for so that personal work and business work stay apart

Create a GitHub account: https://github.com/login

Return to Pilot and follow the link to Create / Access your Course Repository.

In Lab 01, you will also be taked with making your own repository to build a GitHub **profile repository**.  This means you'll start your git journey with two whole repos!

[!WARN] There will be an extra credit open at the end of the semester to submit a repository for work done outside of this course.  This could be a personal project, a repo for another course, or a repo created for some competition.  Don't wait til the last minute, plan ahead!

# Lab Procedure

In your lab session, you'll see in-class demos for:
- Getting started with your profile repository & making edits via the GitHub browser editor
- Working with the lab answer templates
- Cloning your repo(s) to work in VSCode
- What repository History shows
- Submitting your lab work

[!WARN] The answers templates **will not** give the full lab writeup.  The Lab Instructions contain what your taskings are and recommended resources to get started.  The templates will keep your answers organized so that the TAs can effeciently find them.  **You are always welcome to add your own additional notes to your lab work, or additional note files for your use**

# Your System & Navigation

Objectives:
- definitions of terminal, console, shell, and command prompt
- know your system's shell
- understand how to structure requests to your OS
- practice commands to navigate your filesystem

## History Lesson - Definitions

Terminals & consoles are OG.  Desktop environments are fairly "new".  You now use virtual consoles or terminal emulators to access a shell, which in turn enables the use of the command line.

### Terminal

> A *terminal* refers to a wrapper program which runs a shell. Decades ago, this was a physical device consisting of little more than a monitor and keyboard. As Unix/Linux systems added better multiprocessing and windowing systems, this terminal concept was abstracted into software. 

> Other terminals, sometimes called pseudo-terminals or pseudo-ttys, are provided (through a thin kernel layer) by programs called terminal emulators. Some types of terminal emulators include:
- SSH, which connects a terminal on one machine with programs on another machine
    - You'll see this soon... dun dun dun...
- GUI applications running in the X Window System: Xterm, Gnome Terminal, Konsole, Terminator, etc.
    - You'll see this in our virtual machines lab
- Screen and tmux, which provides a layer of isolation between a program and another terminal
    - You'll see this in our process control lab

### Console

> The *console* is a special sort of terminal. Historically, the console was a single keyboard and monitor plugged into a dedicated serial console port on a computer used for direct communication at a low level with the operating system. Modern Linux systems provide virtual consoles. 

Virtual consoles are synonymous with virtual terminals today.

> These are accessed through key combinations (e.g. Alt+F1 or Ctrl+Alt+F1; the function key numbers different consoles) which are handled at low levels of the Linux operating system -- this means that there is no special service which needs to be installed and configured to run. Interacting with the console is also done using a shell program.

> The *shell* is the program which actually processes commands and returns output. Most shells also manage foreground and background processes, command history and command line editing. These features (and many more) are standard in bash, the most common shell in modern Linux systems.

### Command Line [Interface]

> A *command line* is an interface where the user types a command (which is expressed as a sequence of characters — typically a command name followed by some parameters) and presses the Return key to execute that command.

### Shell

> *shell* has specialized to mean a command-line shell, centered around entering the name of the application one wants to start, followed by the names of files or other objects that the application should act on, and pressing the Enter key. Other types of environments (with the notable recent exception of Gnome Shell) usually don't use the word “shell”; for example, window systems involve “window managers” and “desktop environments”, not a “shell”.

There are many different unix shells. Ubuntu's default shell is Bash (like most other Linux distributions). Popular alternatives include zsh (which emphasizes power and customizability) and fish (which emphasizes simplicity).

> Command-line shells include flow control constructs to combine commands. In addition to typing commands at an interactive prompt, users can write scripts. The most common shells have a common syntax based on the Bourne_shell. When discussing “shell programming”, the shell is almost always implied to be a Bourne-style shell. Some shells that are often used for scripting but lack advanced interactive features include the Korn shell (ksh) and many ash variants. Pretty much any Unix-like system has a Bourne-style shell installed as /bin/sh, usually ash, ksh or bash. On Ubuntu, /bin/sh is Dash, an ash variant (chosen because it is faster and uses less memory than bash).

> In unix system administration, a user's shell is the program that is invoked when they log in. Normal user accounts have a command-line shell, but users with restricted access may have a restricted shell or some other specific command (e.g. for file-transfer-only accounts).

#### Citations:

- https://askubuntu.com/questions/506510/what-is-the-difference-between-terminal-console-shell-and-command-line
- https://superuser.com/questions/144666/what-is-the-difference-between-shell-console-and-terminal

## Your System's Terminal Emulator & Shell

Each OS environment started with terminal access, development of a shell to interface with the operating system, and command line utilities.

Since Windows was later game, you'll find online disagreements about using the word "shell" in reference to Window's command line utilities.  In this course, refer to the correct program / application name to keep everyone happy.

Windows did decide to "play ball" with existing styles.  PowerShell and CMD have built-in *aliases* with commonly used Linux-style commands (bash commands) when it comes to basic navigation and some common utility calls.

The similarities are going to cap at navigation & some common utilities that are protocol based or cross-platform (git and SSH are among that set).  File and folder permissions, for example, are going to be unique tools built to that Operating System's filesystem.  More on that later.

### Windows

- Terminal Emulation Program (recommendations): Windows Terminal, MobaXTerm
- Available shells:
    - PowerShell
        - [PowerShell Cheat Sheet - Command Structure Focus](https://github.com/ab14jain/PowerShell)
        - [PowerShell Cheat Sheet - Scripting Focus](https://gist.github.com/pcgeek86/336e08d1a09e3dd1a8f0a30a9fe61c8a)
    - Command Prompt (CMD)
        - [CMD Cheat Sheet](https://serverspace.us/support/help/windows-cmd-commands-cheat-sheet/)

[PowerShell vs CMD - What's the Difference?](https://phoenixnap.com/kb/powershell-vs-cmd)

![PowerShell labels](imgs/PowerShell-MarkedUp.png)

### Unix / Linux

- Terminal Emulation Program: Xterm, Gnome Terminal, Konsole, Terminator
- Default shell: bash = Bourne Again Shell

[Bash Commands Cheat Sheet](https://github.com/RehanSaeed/Bash-Cheat-Sheet)

[Bash Scripting Cheat Sheet](https://devhints.io/bash)

![Ubuntu / bash labels](imgs/Ubuntu-MarkedUp.png)

### Mac

- Terminal Emulation Program: Terminal
- Default shell: zsh = Z shell

[Bash & zsh Commands Cheat Sheet](https://www.datacamp.com/cheat-sheet/bash-and-zsh-shell-terminal-basics-cheat-sheet)

[Some highlighted differences between zsh and bash](https://news.learnenough.com/macos-bash-zshell#learn_enough_command_line)

[Changing the default shell](https://support.apple.com/guide/terminal/change-the-default-shell-trml113/mac)

[Customizing zsh](https://ohmyz.sh/)

## Communicating with your OS via a Shell

All shells will have a common structure to their commands:
```bash
command options what-to-operate-on
```

All shells will have a way to get help with a given command - assuming the developers wrote a help guide:
```bash
help command        # prints included help guide for given command
man command         # takes to manual page for given command.  Press `q` to quit guide
```

You should practice looking at these pages - although internet documentation will contain more examples or an example similar to what you are trying to do.

