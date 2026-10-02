
You can use a command in support of your answer, but we are evaluating your written response.

Name field

Check formatting (block quotes), font choices

1. `.tasks` contains the lines below. Which lines are left after running `tt remove "lab"` if the `remove` action uses `sed -i "/$2/d" "$HOME/.tasks"`, and why?
```
Submit lab report
Study for lab quiz
Buy groceries
```

2. A student runs `grep -E "\d{3}$" access.log` to find status codes, but gets no output. Why, and what is one way to fix it?

3. Given the lines below from `access.log`, how many lines will `grep -E "13:2[0-9]" access.log` output, and why?
```
192.168.1.10 - [10/Oct/2024:13:21:05] "GET /contact HTTP/1.1" 200
10.0.21.4 - [10/Oct/2024:13:29:59] "POST /cart HTTP/1.1" 404
172.16.5.22 - [10/Oct/2024:13:30:12] "GET /faq HTTP/1.1" 200
192.10.1.7 - [10/Oct/2024:13:45:33] "GET /checkout HTTP/1.1" 500
```

4. A student runs the command below on the line `<li>Apples</li><li>Pears</li>` and gets `<li>Apples` as output. Why was `<li>Pears` removed too?
```
sed 's/<\/.*>//g' sedfile.md
```

5. A student runs `sed 's/Batches/Matches/g' sedfile.md` and sees `Matches` in the output, but `cat sedfile.md` still shows `Batches`. Why?

6. Given the lines below from `sales.txt`, what will the following command print?
```
awk -F',' '$5 >= 100 {print $2}' sales.txt
```
```
2024-01-15,Laptop,Electronics,3,899.99,2699.97
2024-02-03,Blender,Kitchen,5,49.99,249.95
2024-02-10,TV,Electronics,2,450.00,900.00
```

7. What does the following snippet from `.bashrc` do?
```bash
if [ -f ~/.bash_aliases ]; then
    . ~/.bash_aliases
fi
```

8. Given the `getopts` line below, a user runs `bash dotinstall -a 'alias ls="ls -lah"'`. Why is `$OPTARG` empty when the `a)` case runs?
```bash
while getopts "hsdar" opt; do
```

9. `.bash_aliases` contains the two aliases below. A user runs `bash dotinstall -r ls`, which runs the `sed` command shown. What is the bug?
```
alias ls="ls -lah"
alias lsb="lsblk -f"
```
```bash
sed -i "/alias $OPTARG/d" ~/.bash_aliases
```

10. Given the `git log --oneline` output below for the `dotinstall` script, why would this commit history not meet the commit requirement?  
Note: `git log --oneline` shows the commit ID followed by the commit message
```
c7d8e9f Lab06 done
e4f5a6b stuff
a1b2c3d update
```