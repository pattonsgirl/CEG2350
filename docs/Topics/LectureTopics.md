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

- `ssh` stage 1: private keys, command format
- file streams
