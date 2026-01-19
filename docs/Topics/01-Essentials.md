## 01 - Essentials

- Overview of main OSes
- Command line navigation
- OS structure, Directories, and Files​
- SSH keys & usage
- Git Command basics
- Permissions
- Users & groups

### Overview of Core OSes
> An operating system (OS) is system software that manages computer hardware and software resources, and provides common services for computer programs. - [Wikipedia](https://en.wikipedia.org/wiki/Operating_system)

[Timeline of Operating Systems](https://en.wikipedia.org/wiki/Timeline_of_operating_systems)

This course will be discussing OSes for Personal Computers (PCs). Therefore our conversations will focus on Linux, Windows, and Mac. You will specifically be learning about OS Concepts and Usage through Linux based Operating Systems.

[Windows vs MacOS vs Linux – Operating System Handbook - FreeCodeCamp](https://www.freecodecamp.org/news/an-introduction-to-operating-systems/)

**Video** - [Operating Systems: Creash Course Computer Science](https://www.youtube.com/watch?v=26QPDBe-NB8)

Key takeaways:
- What are the requirements behind the different OSes (what hardware can they run on)
- What are the file system structure differences

### Command Line Navigation

First off, know the terminology differences between a [terminal, console, shell, and command line](https://www.tutorialspoint.com/difference-between-terminal-console-shell-and-command-line)

**Terminal**:  
> Terminal: A software application (emulator) that simulates a physical terminal, allowing interaction with the system from anywhere, even remotely. 

- Windows Terminal [Windows]
- Terminal [Mac]
- GNOME Terminal, Konsole, etc [Linux]

**Console**:
> Console: The original hardware (monitor/keyboard) directly linked to the computer, used for primary system access, boot messages, and low-level tasks. 

> Video game systems are called "consoles" because the term originally described a self-contained control panel or unit that consolidated electronic functions, fitting early game devices like the Magnavox Odyssey, and the name stuck as it distinguished them from general-purpose computers, even as they evolved into dedicated gaming machines with a fixed purpose

**Command Line Shells**:

Command Line Interface:  
> A CLI is a method of user interaction where the user types commands as lines of text to operate software or the operating system, rather than using visual elements like icons and buttons.

Command Line Shell: 
> The specific program that interprets the commands typed into the CLI, executes the corresponding tasks, and manages the interaction between the user and the operating system's kernel. While the term "shell" often implies a command-line interpreter in Unix-like systems, technically a desktop environment like Windows Explorer can also be considered a graphical "shell" (GUI). 

- Bash (Bourne-Again Shell) - default for most Linux OSes
- Zsh (Z Shell) - default for most macOS systems (tied with bash)
- Powershell- default for Windows, now cross-platform
- `cd`, `ssh`, and `git` are all considered command line interfaces

**Shell Commandments**:

1. Thou shalt always read thine output after running a command​
- No output = something worked. So what did you run and what did it do? ​
- Was it what you wanted?​

2. When asking for help, thou shalt give the command AND the output​
- Additionally, whatever steps you remember - some results are a sum of a series of descisions / previously run commands

Commands that you run will likely do one of three things:​
- Succeed quietly​
- Succeed and move to the next step / ask for more info​
- Error and give you a message​

​The errors should be read carefully​
- The errors tell you why the command couldn’t run.

Using your shell gets easier as you pick up customizations, tips and tricks. [7 Linux terminal basics every beginner should learn first](https://www.zdnet.com/article/7-linux-terminal-basics-every-beginner-should-learn-first-and-why/)

**Shell Information**  
At the beginning line in a shell:

- Linux `bash` shells:​ `name@system:~/folder$​`
    - Who you are signed in as​: `name@​`
    - The name of the system​: `@system​`
    - The folder you are in (sometimes)​: `~/folder​`
    - The user mode you are using (sometimes)​
        - `$` = normal user
        - `#` = root user

- Windows `Powershell`: `PS C:\Users\w010ked>`
    - Your shell will have the priviledges of the currently logged in user (to the operating system)
    - `PS` to inform you are using Powershell - no `PS` may mean you are in the Command Prompt `cmd` shell, not Powershell
    - `C:\Users\w010ked` the drive and directory you are in 
    - User mode (admin vs not) will be in the application name
        - `Administrator: Windows Powershell` = Admin mode
        - `Windows Powershell` = normal user

**Core Commands**  

- `man`
- `help`
- `history`
- `pwd`
- `ls`
- `cd`
- `cat`
- `touch`
- `vim` & `nano`
- `mkdir`
- `cp`
- `mv`
- `rm`
- `rmdir`

Most command will support *options*, also called *flags*. Look these up everytime whil you are learning, and do not assume that an option in one command is used the same in another. For any given command:
- Use `[command] --help` (or -h) for quick, immediate, and concise information about a command's options and usage.
- Use `man [command]` for in-depth, detailed, and comprehensive documentation, including detailed descriptions, author info, and sometimes examples.
- Use `help [command]` specifically for Bash shell built-in commands (like cd, echo, alias). 

**Bonus Recommendations**  
Be a `vim` power user:
- `vimtutor`
- [OpenVim](https://openvim.com/)
- [vim Adventures](https://vim-adventures.com/)

### OS structure, Directories, and Files​

![Comparing Linux, Mac, and Windows Filesystem Structure](imgs/filesystemcompare.png)

Some rules of thumb:
- Hidden files and folders will have a `.` in front of the name. Ex, `.bashrc`
- The shell is case sensitive. Upper and lowercase matter
- If a file or directory name has spaces or special characters, you may need to use quotes (`"` or `'`) around the name

For your OS and Linux OSes, you should know the general structure and purpose behind how the OS is organized on the filesystem:
- [Linux Directory Structure - Linux Handbook](https://linuxhandbook.com/linux-directory-structure/)
- Mac OS Filesystem Basics - see [macOS Standard Directories: Where Files Reside - Apple Developer Guide](https://developer.apple.com/library/archive/documentation/FileManagement/Conceptual/FileSystemProgrammingGuide/FileSystemOverview/FileSystemOverview.html#//apple_ref/doc/uid/TP40010672-CH2-SW6)
- [Windows 10 - and 11 - Directory Structure - Wikipedia](https://en.wikipedia.org/wiki/Directory_structure#Windows_10)

**Directories, aka Folders**:
Every directory has a parent directory it belongs to​

The top level directory is parent of itself​

In a directory, if you run "ls –lah", you'll see two listings with dots​

- `.` is a reference to itself​
- `..` is a reference to it's parent
- `*` is a wildcard pattern matcher​
    - `/etc/*-release` will match anything that ends in `-release` in `/etc/`

Relative pathing is a path relative to where you are​
- `class-examples/my_file.txt​`
- `file_open(my_file);​`

Absolute pathing is the full directory path, no shortcuts​
- `/home/ubuntu/class-examples/my_file.txt​`
- `file_open(C:\Users\kduncan\Documents\data\my_file.txt)`


### Permissions & Admin

### Users and Groups

### SSH Keys & Usage

### Git Command Basics

