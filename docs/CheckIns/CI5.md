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

2. A student is playing `nsnake` in Shell A. From Shell B, they find the game with the `ps` command below and run `kill -9 1588`. Shell A returns to a prompt, but nothing the student types shows up on the screen. Why did this happen, and why is `kill 1588` (without `-9`) usually the better first choice?
```
$ ps -o pid,ppid,tty,stat,cmd -u ubuntu | grep nsnake
   1588    1403 pts/0    S+   nsnake
```

3. Given the `jobs` output below, a student types `fg`. Which job comes back to the foreground, and how can you tell? What command would bring job 1 to the foreground instead?
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

7. A student creates a branch locally, makes a commit, and runs `git push`. Why does git respond with the output below?
```
$ git push
fatal: The current branch part2-compiling has no upstream branch.
To push the current branch and set the remote as upstream, use

    git push --set-upstream origin part2-compiling
```

8. A student finishes their work on the `part1-compilers` branch and wants to merge it into `main`. They run the commands below. Why does `main` still not have the changes, and what should they have done instead?
```
$ git branch
  main
* part1-compilers
$ git merge main
Already up to date.
```

9. While merging `part6-libraries` into `main`, a student sees the following in `Makefile`. Which line came from which branch, and what steps finish the merge?
```
<<<<<<< HEAD
SRCS = main.c todo.c
=======
SRCS = main.c todo.c display.c
>>>>>>> part6-libraries
```

10. After compiling their program for the first time, a student ran `git add .` in the program's folder and committed. Later, they add the `.gitignore` below to the root of their repository, rebuild the program, and run `git status`. Why do the build files still show up, and how do they fix it?
```
todo_app
*.o
```
```
Changes not staged for commit:
        modified:   Lab10/todo-lab/main.o
        modified:   Lab10/todo-lab/todo.o
        modified:   Lab10/todo-lab/todo_app
```

11. A student runs the commands below. Why did both `gcc -c` commands succeed when `main.c` calls `add_task`, but the last command fails? What should the last command have been?
```
$ gcc -c main.c
$ gcc -c todo.c
$ gcc main.o -o todo_app
/usr/bin/ld: main.o: in function `main':
main.c:(.text+0xf2): undefined reference to `add_task'
collect2: error: ld returned 1 exit status
```

12. `display.c` starts with `#include <curses.h>`. `gcc --version` works, so why does compiling it fail, and what fixes it?
```
$ gcc -c display.c
display.c:12:10: fatal error: curses.h: No such file or directory
```

13. Given the `Makefile` below, a student runs `make build` twice in a row and sees the output shown. How does `make` decide that it has nothing to do the second time, and what would make it compile again?
```make
build: todo_app

todo_app: main.c todo.c
	gcc main.c todo.c -o todo_app
```
```
$ make build
gcc main.c todo.c -o todo_app
$ make build
make: Nothing to be done for 'build'.
```

14. A student fixes a bug on the branch `fix-remove`, merges it into `main` on the command line, and pushes both branches. When they open a Pull Request from `fix-remove` to `main`, GitHub says there isn't anything to compare. Why, and what order should they have done things in?