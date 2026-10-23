You can use a command in support of your answer, but we are evaluating your written response.

1. A user runs `./check` with no arguments and gets `[: -gt: unary operator expected`. Why?
```bash
#!/bin/bash
if [ $1 -gt 1 ]; then
    echo "Valid"
fi
```

2. A student runs the script below with `./compare`. It prints `3 is greater than 10`, and `ls` now shows a new file named `10` in the directory. Why?
```bash
#!/bin/bash
num=3
if [ "$num" > 10 ]; then
    echo "$num is greater than 10"
fi
```

3. A user enters `0` at the prompt and the script prints `Must be greater than 1` forever. What is the bug?
```bash
read -p "Sides: " sides
while [ "$sides" -le 1 ]; do
    echo "Must be greater than 1"
done
```

4. Given the loop below, how many lines are printed when a user runs `./tasks "Buy milk" "Walk dog"`, and why?
```bash
for task in $@; do
    echo "$task"
done
```

5. Given the script below, a user runs `./dotinstall -a -h` and sees `Adding: -h`, but the user guide never displays. Why?
```bash
while getopts "ha:r:" opt; do
    case $opt in
        h) user_guide ;;
        a) echo "Adding: $OPTARG" ;;
        r) echo "Removing: $OPTARG" ;;
    esac
done
```

6. A script uses `while getopts "v" opt` to handle a `-v` flag, then runs `echo "File: $1"` after the loop. A user runs `./script -v notes.txt` and sees `File: -v`. Why, and what is one way to fix it?

7. Given the lines below from `nums.txt`, which lines will `grep "[^0-9]" nums.txt` output, and why?
```
42
3.14
-5
100
```

8. A student runs `grep "3.14" values.txt` and the output includes the line `3014`. Why?

9. Given the lines below from `emails.txt`, only `bob@gmail.com` is output by `grep -E "^[a-z]+@[a-z]+\.com$" emails.txt`. Why did each of the other lines not match?
```
kay@wright.edu
bob@gmail.com
Sally@gmail.com
dana@mail.gmail.com
```

10. A student runs the command below to change a path in a config file and gets `sed: -e expression #1, char 9: unknown option to 's'`. Why, and what is one way to fix it?
```
sed 's//home/ubuntu//home/kay/g' config.txt
```

11. The `remove` action in `tt` runs the line below, but the task is never deleted from `.tasks`, even though `$task` holds a description that is in the file. Why?
```bash
sed -i '/$task/d' "$HOME/.tasks"
```

12. Given the lines below from `sales.txt`, why does `awk '{print $2}' sales.txt` print only blank lines?
```
2024-01-15,Laptop,Electronics,3,899.99,2699.97
2024-02-03,Blender,Kitchen,5,49.99,249.95
```

13. A script contains the line below. Why does it print each entire line of `sales.txt` instead of just the second field?
```bash
awk -F',' "{print $2}" sales.txt
```