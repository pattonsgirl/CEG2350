You can use a command in support of your answer, but we are evaluating your written response.

1. In git, when should I use an `add` versus a `commit` and what is the difference between them?

2. Given the following `git status` output, which file's changes will be saved if you run `git commit -m "tt view working"` right now, and why?
```
Changes to be committed:
        modified:   Lab04/README.md

Changes not staged for commit:
        modified:   Lab04/tt
```

3. You try to `git push` and see the following. What command should you run before pushing again, and why?
```
 ! [rejected]        main -> main (fetch first)
error: failed to push some refs to 'github.com:WSU-kduncan/ceg2350-lastname-f26.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally.
```

4. Explain why `bash roll` runs successfully but `./roll` returns `Permission denied`.

5. Given the script below, what is the range of numbers that can be output when a user runs `./roll 6`?
```bash
#!/bin/bash
echo "You rolled a $(( RANDOM % $1 + 1 ))"
```

6. A user runs `tt add Submit lab report` (no quotes). What is the value of `$2`, and why?

7. Given the snippet of code for the `add` action below, what is the bug if a user adds three tasks in a row and then runs `tt view`?
```bash
add)
    echo "$2" > "$HOME/.tasks"
    echo "Task added!"
    exit 0
    ;;
```

8. Given the case statement below, what happens when a user runs `tt Add "Buy milk"`, and why?
```bash
case "$1" in
    add) add_task "$2" ;;
    view) cat "$HOME/.tasks" ;;
    *) echo "Invalid argument"; user-guide; exit 1 ;;
esac
```

9. Given the output below, another user - not `ubuntu` or `root` - gets `Permission denied` when they run `tt`. Why can't they run it even though the link shows `rwxrwxrwx`?
```
$ ls -l /usr/local/bin/tt
lrwxrwxrwx 1 root root 41 Sep 24 10:15 /usr/local/bin/tt -> /home/ubuntu/ceg2350-lastname-f26/Lab04/tt
$ ls -l /home/ubuntu/ceg2350-lastname-f26/Lab04/tt
-rwxr-x--- 20 ubuntu ubuntu 4096 Sep 24 10:02 /home/ubuntu/ceg2350-lastname-f26/Lab04/tt
```