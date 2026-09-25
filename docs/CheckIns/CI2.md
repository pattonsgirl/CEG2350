You can use a command in support of your answer, but we are evaluating your written response.

1. In git, what is the difference between / when should I use an add versus a commit?

2. Given the following `git status` output, which file's changes will be saved if you run `git commit -m "tt view working"` right now, and why?
```
Changes to be committed:
        modified:   Lab04/README.md

Changes not staged for commit:
        modified:   Lab04/tt
```

3. You try to push and see the following. What command should you run before pushing again, and why?
```
 ! [rejected]        main -> main (fetch first)
error: failed to push some refs to 'github.com:WSU-kduncan/ceg2350-lastname-f26.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally.
```

4. Explain why `bash roll` runs successfully but `./roll` returns `Permission denied`.

6. Given the script below, what is the range of numbers that can be output when a user runs `./roll 6`?
```bash
#!/bin/bash
echo "You rolled a $(( RANDOM % $1 + 1 ))"
```

7. Given the snippet below, what is output when a user runs `./roll 3`, and why?
```bash
if [ $# -ne 2 ]; then
    echo "Usage: ./roll <number of dice> <number of sides>"
    exit 1
fi
```

8. A user runs `tt add Submit lab report` (no quotes). What is the value of `$2`, and why?

9. Given the `add` action below, what is the bug if a user adds three tasks in a row and then runs `tt view`?
```bash
add)
    echo "$2" > "$HOME/.tasks"
    echo "Task added!"
    exit 0
    ;;
```

10. Given the case statement below, what happens when a user runs `tt Add "Buy milk"`, and why?
```bash
case "$1" in
    add) add_task "$2" ;;
    view) cat "$HOME/.tasks" ;;
    *) echo "Invalid argument"; user-guide; exit 1 ;;
esac
```

11. Running `./tt help` on the script below prints `user-guide: command not found`. Why?
```bash
#!/bin/bash
case "$1" in
    help) user-guide; exit 0 ;;
esac

user-guide() {
    echo "Usage: tt add|remove|view|clear|help [\"task\"]"
}
```

12. `.tasks` contains the lines below. Which lines are left after running `tt remove "lab"` if the `remove` action uses `sed -i "/$2/d" "$HOME/.tasks"`, and why?
```
Submit lab report
Study for lab quiz
Buy groceries
```

13. Given the output below, another user gets `Permission denied` when they run `tt`. Why can't they run it even though the link shows `rwxrwxrwx`?
```
$ ls -l /usr/local/bin/tt
lrwxrwxrwx 1 root root 41 Sep 24 10:15 /usr/local/bin/tt -> /home/ubuntu/ceg2350-lastname-f26/Lab04/tt
$ ls -ld /home/ubuntu
drwxr-x--- 20 ubuntu ubuntu 4096 Sep 24 10:02 /home/ubuntu
```