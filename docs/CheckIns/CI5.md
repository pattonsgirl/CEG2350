You can use a command in support of your answer, but we are evaluating your written response.

1. Shell B runs the `ps` command below while the game is running. What is the game's PID, which process is its parent, and which terminal (Shell A or Shell B) is the game running in? How can you tell?
```
$ ps -o user,pid,ppid,tty,stat,cmd -u ubuntu
USER         PID    PPID TT       STAT CMD
ubuntu      1402    1401 ?        S    sshd: ubuntu@pts/0
ubuntu      1403    1402 pts/0    Ss   -bash
ubuntu      1588    1403 pts/0    S+   nsnake
ubuntu      1611    1610 ?        S    sshd: ubuntu@pts/1
ubuntu      1612    1611 pts/1    Ss   -bash
ubuntu      1650    1612 pts/1    R+   ps -o user,pid,ppid,tty,stat,cmd -u ubuntu
```

2. Using the output from question 1, a student runs `kill -9 1588` from Shell B. Shell A returns to a prompt, but nothing the student types shows up on the screen. Why did this happen, and why is `kill 1588` (without `-9`) usually the better first choice?

3. Given the `jobs` output below, a student runs `kill 2` and gets `bash: kill: (2) - Operation not permitted`. What did the student actually try to kill, and how should they have referred to job 2?
```
$ jobs
[1]   Stopped                 nsnake
[2]-  Stopped                 nsnake
[3]+  Stopped                 nsnake
```

4. A student runs the game in Shell C and in a `tmux` session, then closes both `ssh` connections. After reconnecting, only the `tmux` game is still running. Using the `pstree` output below (taken before disconnecting), explain why.
```
systemd─┬─...
        ├─sshd───sshd───sshd───bash───nsnake
        ├─sshd───sshd───sshd───bash───tmux: client
        ├─tmux: server───bash───nsnake
```

5. A student starts `disk-watchdog` with `sudo systemctl start disk-watchdog` and confirms it is running. After rebooting the instance, `systemctl status` shows the output below. Why isn't the service running, and what command fixes it?
```
○ disk-watchdog.service - Disk usage watchdog
     Loaded: loaded (/etc/systemd/system/disk-watchdog.service; disabled; preset: enabled)
     Active: inactive (dead)
```

6. Given the output below, why did `disk-watchdog.service` fail to start?
```
$ systemctl status disk-watchdog
× disk-watchdog.service - Disk usage watchdog
     Loaded: loaded (/etc/systemd/system/disk-watchdog.service; enabled; preset: enabled)
     Active: failed (Result: exit-code)
    Process: 2210 ExecStart=/usr/local/bin/disk-watchdog.sh (code=exited, status=203/EXEC)
$ ls -l /usr/local/bin/disk-watchdog.sh
-rw-r--r-- 1 root root 812 Oct 20 11:04 /usr/local/bin/disk-watchdog.sh
```

7. To trigger the watchdog, a student runs `truncate -s 5G bigfile`. `ls -lh bigfile` shows `5.0G`, but `df -h /` shows no change in usage and the watchdog never logs a warning. Why, and what command would actually spike disk usage?

8. A student creates a branch locally, makes a commit, and runs `git push`. Why does git respond with the output below?
```
$ git push
fatal: The current branch part2-compiling has no upstream branch.
To push the current branch and set the remote as upstream, use

    git push --set-upstream origin part2-compiling
```

9. A student finishes Part 1 and wants to merge their work into `main`. They run the commands below. Why does `main` still not have the Part 1 changes, and what should they have done instead?
```
$ git branch
  main
* part1-compilers
$ git merge main
Already up to date.
```

10. While merging `part1-compilers` into `main`, a student sees the following in `README.md`. Which line came from which branch, and what steps finish the merge?
```
<<<<<<< HEAD
| **Java** | OpenJDK | `sudo apt install default-jdk` |
=======
| **Java** | OpenJDK | `sudo apt install openjdk-21-jdk` |
>>>>>>> part1-compilers
```

11. A student adds `Lab10/todo` to the `.gitignore` in the root of their repository, rebuilds the program, and runs `git status`. Why is the executable still showing up, and how do they fix it?
```
Changes not staged for commit:
        modified:   Lab10/todo
```

12. A project contains `main.c`, `todo.c`, and `todo.h`. `add_task` is declared in `todo.h` and defined in `todo.c`. Why does the command below fail, and how should it be fixed?
```
$ gcc main.c -o todo
/usr/bin/ld: /tmp/ccA1b2C3.o: in function `main':
main.c:(.text+0x5e): undefined reference to `add_task'
collect2: error: ld returned 1 exit status
```

13. A student clones a terminal game's source code from GitHub and runs `make`. `gcc --version` works, so why does the build fail, and what is one way to fix it?
```
$ make
gcc -O2 -o snake snake.c -lncurses
snake.c:3:10: fatal error: ncurses.h: No such file or directory
    3 | #include <ncurses.h>
      |          ^~~~~~~~~
compilation terminated.
```

14. After fixing the build in question 13, `./snake` runs from inside the repository folder, but typing `snake` from the home directory gives `snake: command not found`. Why, and what is one way to make `snake` run from any directory?

15. Given the `Makefile` below, a student runs `make build` twice in a row. The first run compiles, the second prints `make: Nothing to be done for 'build'.` After editing `todo.c`, `make build` compiles again. How does `make` decide when to rebuild?
```make
build: todo

todo: main.c todo.c todo.h
	gcc main.c todo.c -o todo
```