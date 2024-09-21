## Lab 03

- Name: Arnold Hien
- Email: hien.5@wright.edu

## Part 1 Answers

1. `ssh` command before configuring `config` file: ssh -i ./labsuser.pem ubuntu@184.73.100.164
2. HostName: 184.73.100.164
3. User:  ubuntu
4. IdentityFile: ~/labsuser.pem
5. `~/.ssh/config` contents:

```
Host 2350
        Hostname 184.73.100.164
        User ubuntu
        IdentityFile ~/labsuser.pem
        Port 22
```

6. `ssh` command after configuring an entry in the `config` file: ssh 2350

## Part 2 Answers

1. `printenv HOME > thishouse`
   - Explanation: printenv HOME prints the value of the Home environment to standard output, which is redirected to the file named thishouse in the current directory. thishouse now contains the path to the current user’s home directory as a text.
2. `cat doesnotexist 2>> hush.txt`
   - Explanation: cat will try to display the content of doesnotexist, but because doesnotexist does not exist it will produce a error message to standard output, which is redirected to the file named button in the current directory. button now contains the text, "This is easy".
3. `cat nums.txt | sort -n >> all_nums.txt`
   - Explanation: it will concatenates (cat) the contents of nums.txt, sorts the numbers in numerical order (sort -n), and appends the sorted output to all_nums.txt (>>).
4. `cat << "DONE" > here.txt`
   - Explanation: This command uses a here-document to take input until the word DONE is encountered and writes that input to here.txt
5. `ls -lt ~ | head`
   - Explanation: it lists the contents of the home directory (~) in long format (-l) and sorts them by modification time (-t), then displays the first few lines (head).
6. `history | grep ".md"`
   - Explanation: it searches the command history for any commands that include the string .md.

## Part 3

Verify that `roll` made it to your GitHub repository for this course and is in your `Lab03` folder.  No answers will be written here unless you would like to leave a note to the TAs

## Part 4 - Retrospective Answers

1. Where and when did it go wrong while working on your script tasks?
> 2 to 6 was going wrong every time. I had used while and then and was getting an error and had to find out that while goes with "do". Forgetting to put $ also gave me a hard time in my scripts.
2. Was anything familiar working with a new language compared to one you are used to?
> Yes, I used python and it was pretty familiar with the expression while, if and the random
3. Did you write good `commit` messages that refer to what tasks were completed at each commit? Yes I did but for the two first steps  thought it was personal notes so I was just telling I'm doing my homework but I correct the for last ones stating what i am doing in my scripts.  What would you improve? 
> Your reflection here: More details, because the first and last scripts are differents and I should have stated more stuff in my commits in case someone wants to track it.

## Part 5 Answers

1. PATH = /usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin
2. To set condition to `true`, I need to have "if [ -d "$HOME/bin" ]... set as true
    PATH="$HOME/bin:$PATH"
fi
3. Command(s): mkdir -p $HOME/bin
4. PATH =/home/ubuntu/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin
   - Difference: bin was added
5. Command(s): cp /home/ubuntu/ceg2350f24-nono3311/Lab03/roll $HOME/bin/
6. Commands & modification explanations:
7. Script permission breakdown: chmod +x $HOME/bin/roll
   - User
      - must be: the owner of the script.
      - has permissions to: read, write, and execute the script
   - Group
      - must be: members of the group that own the script
      - has permissions to: read and execute the script.
   - Other
      - has permissions to:read and execute the script.

## Extra Credit

1. Note here *what* you did to the script for the extra credit.
   
