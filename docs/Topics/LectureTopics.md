Day 1:

- Syllabus
- 3 OSes
- Your system's shell
    - Powershell (Windows)
    - bash (Linux)
    - zsh (Mac)
- Navigation
    - `pwd`, `cd`, `ls`
    - all shells support these, may be aliases to the program / command
- Practice
    - Using your shell (Powershell for Windows users), try to use commands (pwd, cd, and ls) to navigate to places like Downloads, a specific document, and where an app is installed (like Discord). Be curious!

Day 2:

- Windows and OneDrive
    - If you created your system account by providing an email with OneDrive, your files (Documents, Downloads, etc) may be in your user folder in the OneDrive directory. Local account will have Docs, Downloads, etc in their user directory.
- playing with pathing - absolute vs relative
    - Absolute / full paths start with the top of the filesystem - `C` or volume letter in Windows, `\` in Linux / Mac
    - Relative paths *assume* parts. Examples: just giving directory or file name, using `../filename`, using `~` in the path
    - `~` (tilde) refers to the currently signed in user's home directory
        - `C:\Users\username` in Windows
        - `\home\username` in Linux / Mac
- User / system identification
    - `whoami` (currently signed in user), `hostname` (pc name of current system)
- files and directories
    - `touch`, `vim` - Linux / Mac
    - `ni`, `notepad.exe` - Windows
    - `mkdir`
    - `rmdir` (if directory is empty), `rm` for just files
- *Bonus* for Windows users - install WSL2 and Ubuntu
    - Powershell as Administrator - `wsl --install`
    - (Might need) Open Windows Features, check and Apply / OK "Windows Subsystem for Linux"
    - reboot
    - Open Microsoft Store, install Ubuntu
    - create username (all lowercase, no symbols)
    - create password (field will not show characters as you type)
- git
    - Installer for git - https://git-scm.com/
    - GitHub is a web host for git repositories
    - (recommended) install VSCode - https://code.visualstudio.com/
    - (recommended) open shell, run these two commands to set authorship of your `commit` messages
        - `git config --global user.name "Your Name"`
        - `git config --global user.email "your.email@example.com"`
    - Open VSCode in new window
    - Source Control extension (along left sidebar) should show if git is installed
    - Select *Clone Repository* then select *Clone from GitHub*. Authenticate to GitHub. Should now show your repositories. Select a repo to `clone`
    - Key words / actions
        - `clone` repo from GitHub to git copy on system
        - *stage changes* to files by using `add` button next to changed / new files
        - write a message summarizing your changes and make a `commit`
        - synchronize commits to GitHub via a `push`
        - `pull` to synchronize changes in GitHub with your system's copy
- Practice
    - clone your repo (probably your profile repo for now) and play with making `commit`s and synchronizing changes
    - navigate to your cloned repo on the command line. Open / create files and make edits. Use VSCode to commit and synchronize changes
    - the GitHub repository for your course work will be live Friday

Day 3:

- navigate to github repo (course one). Use command line to make file. Talk through
    - `git` core: `clone`, `status`, `add`, `commit`, `push`, `pull`
    - git commit authorship (once per system / account)
    - `git config --global user.name "Your Name"`
    - `git config --global user.email "your.email@example.com"`
    - `clone` - don't forget auth

Day 4:

- Sandbox env
- permissions
    - Windows
    - Linux
    - Mac?
    - user, group, other
        - `chown`, `chgrp`
        - `id`, `groups`, `getent passwd`, `getent group`
        - `adduser`, `addgrp`
    - read (`r`), write (`w`), execute (`x`) - Numeric (Octal) notation and Character (Symbolic) notation
        - `chmod`, `ls -la`, `stat`
    - system files - `/etc/passwd`, `/etc/shadow`, `/etc/group`
- `man`

Day 5:

- `ssh` stage 1:
    - `ssh` = secure shell
    - public key authentication method
    - private key & permissions
    - public key (adding to account settings (ie GitHub) or viewing in `~/.ssh/authorized_keys`)
    - creating a key pair with `ssh-keygen`
    - Common flags / uses:
        - `ssh -i priv_key_file account@hostname_or_ip` = create a secure shell connection to a remote system account
            - NOTE: if no private key is specified, `ssh` will look for a key to try in `~/.ssh`
        - `ssh -T account@hostname_or_ip` = "test" authentication to remote system account
            - NOTE: since no private key is specified, `ssh` will looks for a key to try in `~/.ssh` - `id_ed25519`
- `git clone git@github.com:repo_owner/repo_name.git`
    - clone with ssh as the public key authentication method - make sure `SSH` is selected after using the Code dropdown
- `sudo`, `root` (the user, not `\` of the filesystem), permissions "review"
    - `usermod -aG groupname username`
- `history` and use of `!!`


Day 6: 

- bash script intro
    - Why use `.sh` as file extension
    - (If no execute permissions) - `bash scriptname`
    - (If execute permissions) - `./scriptname` (if in current dir) or `path/scriptname` (if elsewhere)
- globbing
- wildcards
    - `*.txt` matches all names / strings with `.txt` pattern after *something*
    - `l?.txt` matches all names / strings with `l_.txt` where the blank is a single character
    - additional ref: https://linuxize.com/post/linux-wildcards-and-globbing/
- file streams
    - standard input (0), output (1), and error (2)
    - output redirection - `>`, `>>`
    - input redirection - `<`
    - piping -  `|` - standard output of one command as standard input of another
- data processing programs (basic level)
    - `grep`
    - `wc`
    - `sort`
    - `uniq`
    - `diff`
- Practice exercises: https://github.com/pattonsgirl/CEG2350/tree/main/fileio
    - You can ignore `&>` and `tee` - they are just in the "neat to know bucket"

Day 7:

- The point of `PATH`
    - list of directories system uses to search for executables, in order of listing
- variables
    - `printenv` show environment variables
    - set one - `var_name=val`
    - view / use value in one - `$var_name`
    - read from user and store - `read -p "user prompt" var_name`
    - use args from the command line
        - `$1` refers to first arg, `$2` is second arg, and so on
        - `$@` = all args (list)
        - `$#` = number of args
- quotes:
    - double quote = expansion
    - single quote = literal
    - backticks (or enclosing in `$()` ) = run as command
- `test` / `[ `
    - compare strings, numbers, etc
    - use man to see flags supported

Day 8: 

- where is main?
    - To use a main function in Bash, define it like a regular function and explicitly call it at the very bottom of your script
    - Recommended: pass the script's command-line arguments (`$@`) to it - so `main $@`
- overview of bash structure (logic, loops, functions)
    - cheatsheet of convenience: https://linuxize.com/cheatsheet/bash/
    - played "fill in the template" based on script requirements: https://github.com/pattonsgirl/CEG2350/blob/75692eaca54bd5fb777bc2cad76b79cebdbbe946/scripts/file-create.sh 
- intro to regex
    - learn / reinforce regular expression symbols: https://regexone.com/

Day 9:

- regex cheatsheet
    - https://pattonsgirl.github.io/CEG2350/Topics/02-Bash/Regex.html
- tiny practice challenges:
    - https://github.com/pattonsgirl/CEG2350/blob/main/regex/tiny-challenges.md
- regex in the wild - wordle
    - https://gist.github.com/huytd/6a1a6a7b34a0d0abcac00b47e3d01513
- `grep` - search
    - https://pattonsgirl.github.io/CEG2350/Topics/02-Bash/TextTools.html
- `sed` - search and replace
    - https://pattonsgirl.github.io/CEG2350/Topics/02-Bash/TextTools.html

Some silly data demos:

```
let's make password
5nak3IceCream
1234swim!
p@55w0rd
password
---
filter rules
^.{8,15}$ - password length
[A-Z] - must have a capital letter
[a-z] - must have a lower case letter
\d.*\d - must have two or more digits - match anything between 2 digits
```

```
Loving the #sunsetvibes tonight, way better than #Monday. Also check out 
#TBT202
#MON093
#TBT234
#093MON
----
# - match all cases of hashtag
#[A-Z]{3}[\d]{3} - require capital letters, repeat three times; require digits, repeat three times
```

Day 10:

- `awk` - data processing for FORMATTED data
    - https://pattonsgirl.github.io/CEG2350/Topics/02-Bash/TextTools.html
- Using tools in combo - challenge series
    - https://github.com/pattonsgirl/CEG2350/tree/main/regex

Day 11:

- getopts
    - https://pattonsgirl.github.io/CEG2350/Topics/02-Bash/Scripting.html

Day 12:

- user dotfiles
    - generically, dotfiles are a set of scripts and files that configure the user environment or system.
    - .ssh
        - When you generate an SSH key pair using a tool like ssh-keygen, the keys are stored here by default. They usually appear in pairs with names corresponding to the encryption algorithm used - ex. id_ed25519 & id_ed25519.pub
        - `authorized_keys` (server side) - contains a list of trusted public keys belonging to clients who are allowed to log into your account without a password
        - `known_hosts` (client side) - The first time you connect to a new remote server, SSH asks if you trust the host. Once you accept, the server's unique fingerprint is saved in the known_hosts file. On future connections, SSH checks this file to ensure the server hasn't been intercepted or tampered with (preventing man-in-the-middle attacks)
        - `config` (client side - optional) - allows you to create nicknames and shortcuts for servers you connect to frequently. Instead of typing ssh user@192.168.1.50 -p 2222 -i ~/.ssh/custom_key, you can define those parameters in the config file and simply type ssh myserver
    - .gitconfig
        - stores settings, preferences, and custom commands that alter how Git behaves on your system
        - [user]: Stores your identity. Git attaches this information to every commit you make
            - `git config --global user.name` && `git config --global user.email`
    - .profile
        - configures the user's shell environment upon logging in.
            - Key Characteristics
            - Location: Stored directly in the user's home directory as ~/.profile (the leading dot makes it a hidden file).
            - Execution: Automatically run by Bourne-compatible login shells (like sh, ksh, or bash if specific override files are absent) the moment a user logs in.
            - Shell-Agnostic: Designed to use standard POSIX syntax so that settings carry across different shell interpreters
    - .bashrc
        - customizes your Bash terminal environment every time you open a new interactive, non-login window
        - Key Purposes
            - Aliases: Create short shortcuts for long commands (like alias ll='ls -la').
            - Environment Variables: Set paths and variables using export commands.
            - Shell Functions: Define custom reusable functions for the command line.
            - Prompt Customization: Change the colors and layout of your terminal prompt.
    - .bash_history
        - stores a sequential record of command-line commands previously executed in the Bash shell
- Exam 1 - all topics covered: https://pattonsgirl.github.io/CEG2350/ExamReviews/exam1-review.html
- Exam 1 - TA review guide: https://github.com/aidenc17/CEG2350-Exam1-Review
- Study recommendations:
    - review questions from Check In
    - Use Claude / Gemini to create an interactive quiz about a set of topics.
        - Try asking a challenging questions - not just true / false or multiple choice!
    - Practice answering queries like `login.log` - https://github.com/pattonsgirl/CEG2350/tree/main/regex#using-loginlog---most-similar-to-exam-1-questions-


Day 13:

- Exam 1

Day 14:

- PC hardware overview