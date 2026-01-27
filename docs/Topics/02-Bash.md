## 02 - Bash

- Environment variables, shell config files, PATH
- File manipulation
- Regular expressions
- grep, sed, awk
- Scripting

### Environment variables, shell config files, PATH

**Core Commands:**
- `which`
- `type`
- `whereis`
- `printenv`
- `export`
- `alias` / `unalias`

#### Environment Variables

In Linux, **Environment Variables** are dynamic values that affect the behavior of processes on your system. Think of them as a global "settings" dictionary that every program can look at to figure out how to behave.

**What are they?**

An environment variable consists of a **Name** and a **Value**. By convention, they are almost always written in `UPPERCASE`.

* **NAME:** The key used to access the data (e.g., `PATH`).
* **VALUE:** The actual data stored (e.g., `/usr/bin:/bin`).

**Shell Variables vs. Environment Variables**

It is important to distinguish between a "local" variable and an "environment" variable.

* **Shell Variable:** Only exists in the current terminal session. If you start a new script or a sub-shell, it disappears.
* **Environment Variable:** Is "exported." It is inherited by any child process or script started from that terminal.

**The `export` Command**

To turn a local variable into an environment variable, you use `export`:

```bash
MY_SETTING="Dark Mode"  # Local variable
export MY_SETTING      # Now it's an environment variable

```

**The "Big Players" (Standard Variables)**

Your system relies on several pre-defined variables to function:

| Variable | Purpose |
| --- | --- |
| **`$PATH`** | A colon-separated list of directories where the system looks for commands. |
| **`$HOME`** | The path to the current user's home directory. |
| **`$USER`** | The name of the logged-in user. |
| **`$PWD`** | The **P**resent **W**orking **D**irectory. |
| **`$SHELL`** | The path to the binary of the shell you are currently using (e.g., `/bin/bash`). |

**Viewing and Setting Variables**

* **`printenv`**: Lists all current environment variables.
* **`echo $NAME`**: Displays the value of a specific variable.
* **`env`**: Runs a program in a modified environment (or lists variables).

**Persistence: Making Changes Stick**

If you type `export VAR=Value` in your terminal, it dies the moment you close the window. To make it permanent, you must add it to your **Shell Configuration Files**:

1. **`~/.bashrc`**: The most common place. Loaded for every new interactive bash shell.
2. **`~/.profile` or `~/.bash_profile`**: Loaded once when you first log in.

**How to do it:**

```bash
echo 'export API_KEY="12345-abcde"' >> ~/.bashrc
source ~/.bashrc  # Apply the changes immediately

```

**Inheritance (The Parent-Child Rule)**

Environment variables flow **downward**, not upward.

1. If you set a variable in your terminal and run a script, the script **can** see it.
2. If a script sets a variable, your terminal **cannot** see it after the script finishes (unless you `source` the script).

> **Peer Note:** A common mistake is trying to change the `$PATH` inside a script and expecting it to stay changed in your terminal afterward. It won't! The script runs in a "child" process; when it ends, that environment is destroyed.

---

#### PATH

The `$PATH` variable is arguably the most important environment variable in Linux. It acts as a **search map** for your operating system. Without it, you couldn’t just type `ls` or `python`; you would have to type the full location of every program, like `/usr/bin/ls`.

**How it Works**

When you type a command (that isn't a built-in shell function or an alias), Bash looks at the `$PATH` variable. It contains a list of directories separated by **colons** (`:`). Bash checks each directory from **left to right** until it finds an executable file with that name.

**What's in your PATH?**

You can see your current path by typing:
`echo $PATH`

**Typical output:**
`/usr/local/bin:/usr/bin:/bin:/usr/games`

1. The system looks in `/usr/local/bin`.
2. If not found, it checks `/usr/bin`.
3. If not found, it checks `/bin`, and so on.
4. If it reaches the end and finds nothing, it returns `command not found`.

**Locating a Command**

If you ever wonder *which* version of a command is being run (for instance, if you have two versions of Python installed), use the `which` or `type` command:

```bash
which python3
# Output: /usr/bin/python3

```

**How to Modify the PATH**

When you install a new tool (like a custom script folder or a language like Go), you often need to add its `bin` folder to your PATH so you can run it from anywhere.

*The Temporary Way (Current Session Only)*

```bash
export PATH=$PATH:/home/user/my_scripts

```

> **Crucial Rule:** Always include `$PATH` in your assignment. If you just ran `export PATH=/home/user/my_scripts`, you would "overwrite" the entire system path, and commands like `ls` and `cd` would "disappear" until you restart your terminal!

*The Permanent Way*

To make the change stick, add that same line to the bottom of your `~/.bashrc` file:

```bash
echo 'export PATH=$PATH:/home/user/my_scripts' >> ~/.bashrc
source ~/.bashrc

```

**Security & The "Current Directory" Trap**

In Windows, the current directory (`.`) is often included in the path by default. In Linux, it is **not** included for security reasons.

**Why?**
If you `cd` into a directory where a malicious user has placed a file named `ls`, and `.` was at the start of your PATH, you would run their malicious `ls` instead of the system one.

This is why you have to type `./script.sh` to run something in your current folder—you are explicitly telling Bash: "Don't look in the PATH; look right here."

**Prepending vs. Appending**

The order of the PATH matters.

* **Appending (`PATH=$PATH:/new/path`):** The system looks in the standard locations first. This is safer.
* **Prepending (`PATH=/new/path:$PATH`):** The system looks in your new folder **first**. Use this if you want to "override" a system command with a custom version.

**Quick Summary**

* **$PATH** is a colon-separated list of directories.
* **Order matters:** First match wins.
* **Exporting** is required for sub-processes to see the change.
* **Security:** Never put `.` (current directory) in your PATH.

---

#### Shell Configuration Files

Shell configuration files are the "DNA" of your terminal session. They determine your prompt's look, your aliases, and your environment variables.

The biggest source of confusion is that Bash loads different files depending on **how** you started the shell.

**Login vs. Non-Login Shells**

Bash distinguishes between these two states to avoid reloading heavy configurations unnecessarily.

*The Login Shell*

This happens when you physically log into a machine (via SSH or at the console). Bash looks for instructions in this order:

1. `/etc/profile` (System-wide settings)
2. `~/.bash_profile`, `~/.bash_login`, or `~/.profile` (It stops at the first one it finds).

*The Non-Login Shell*

This is what happens when you open a new terminal window inside an already-logged-in desktop or type `bash` inside a terminal.

1. Loads `~/.bashrc`

**`~/.bashrc` (The Workhorse)**

This is the most important file for individual users. Since most shells you use are non-login interactive shells, this is where you put:

* **Aliases:** `alias ll='ls -la'`
* **Functions:** Custom helper scripts.
* **Prompt Customization:** Changing your `$PS1` variable.
* **Path Additions:** `export PATH=$PATH:~/bin`

**`~/.bash_profile` (The Gatekeeper)**

On Linux, this is usually just used to call `~/.bashrc`. Because login shells don't automatically read `.bashrc`, developers often add this snippet to their `.bash_profile`:

```bash
if [ -f ~/.bashrc ]; then
    . ~/.bashrc
fi

```

**`/etc/bash.bashrc` & `/etc/profile`**

These are the global versions. If you change these, it affects **every user** on the system. Use these sparingly—usually only for corporate policy or system-wide software paths.

**Best Practices for Organizing**

As your configuration grows, your `.bashrc` can become a mess. Many pros "modularize" their setup:

1. Keep `.bashrc` for logic.
2. Create a file called `~/.bash_aliases` for your shortcuts.
3. Add this to your `.bashrc` to load it:

```bash
if [ -f ~/.bash_aliases ]; then
    . ~/.bash_aliases
fi

```

**Applying Changes: `source`**

When you edit a config file, the changes don't take effect in your open windows immediately. You have two choices:

1. Close and restart the terminal.
2. Use the `source` command (or the `.` shortcut):
`source ~/.bashrc`

**Summary Table**

| File | Scope | Shell Type | Use Case |
| --- | --- | --- | --- |
| **`/etc/profile`** | All Users | Login | Global Env Vars |
| **`~/.bash_profile`** | Single User | Login | Calling .bashrc |
| **`~/.bashrc`** | Single User | Non-Login | Aliases, Prompts, Paths |
| **`~/.bash_logout`** | Single User | Login | Cleanup when exiting |


### File manipulation

**Core Commands**
- `sort`
- `cut`
- `wc`
- `paste`
- `join`
- `head` / `tail`
- `less` / `more`
- Streams - standard input, standard output, and standard error (2)
- Stream manipulation:
    - output redirection: `>` vs `>>`
    - input redirection & heredocs: `<` vs `<<`
    - piping: `|`
- functional control
    - interpretive string (doubles quotes) `"`
    - string literals (single quotes) `'`
    - command string (backticks) \` or `$(command)`

#### Streams - input, output, and error

In the world of Linux and Bash, everything is treated as a file. When you run a command, the system automatically opens three "data pipelines" for that process. These are known as **Standard Streams**.

Each stream has a numeric file descriptor (**FD**) that the system uses to keep track of where data is going.

---

**The Three Streams**

| Name | File Descriptor | Description | Default Destination |
| --- | --- | --- | --- |
| **stdin** | `0` | Standard Input | Your Keyboard |
| **stdout** | `1` | Standard Output (Success) | Your Terminal Screen |
| **stderr** | `2` | Standard Error (Failure) | Your Terminal Screen |

---

**Output Redirection**

* `>` : Overwrites the file.
* `>>` : Appends (adds) to the end of the file.

```bash
echo "Log entry: $(date)" >> activity.log

```

**Redirecting Error (`2>`)**

Since `stdout` is `1` and `stderr` is `2`, you can isolate error messages so they don't clutter your clean data.

```bash
# This will save the error message to error.log instead of showing it
ls /folder/that/doesnt/exist 2> error.log

```

---

**Redirecting Both to Different Places**

```bash
./myscript.sh > success.log 2> failure.log

```

**Redirecting Both to the Same Place**

The syntax `2>&1` means "send stream 2 (error) to the same place stream 1 (output) is going."

```bash
# Modern Bash shorthand
./myscript.sh &> all_output.log

# Traditional method (compatible with older shells)
./myscript.sh > all_output.log 2>&1

```

**Discarding Output (`/dev/null`)**

If you don't care about the output or the errors, you can send them to `/dev/null`, the system's "black hole."

```bash
# Run a command silently
command_name > /dev/null 2>&1

```

---

**Input Redirection (`<`)**

You can feed a file into a `read` command using a `while` loop. This is the standard way to process a file line-by-line.

```bash
while read LINE; do
  echo "Processing: $LINE"
done < input_file.txt

```

---

**Heredocs (`<<`): Printing Multi-line Blocks**

If you need to print a large block of text (like a help menu or a config file), use a **Heredoc** (`<<`).

```bash
cat << EOF
----------------------------------
   SYSTEM STATUS REPORT
   Date: $(date)
   User: $USER
----------------------------------
EOF

```

> **Note:** `EOF` is just a label; you can use any word, but `EOF` (End Of File) is the standard convention.

---

**Piping: Connecting Streams**

A **Pipe** (`|`) takes the `stdout` of the first command and plugs it directly into the `stdin` of the second command.

```bash
# 'cat' outputs the file to stdout
# '|' catches that stdout and feeds it to 'grep' as stdin
cat names.txt | grep "Alice"

```

---

#### Functional Control

In Bash, quoting is less about "style" and more about **functional control**. Choosing the wrong quote can be the difference between printing a variable's value and printing the literal name of the variable.

---

#### 1. Single Quotes (`' '`): The Literal String

Single quotes are the "hands-off" option. They preserve the **literal value** of every character within the quotes. Bash will not interpret variables, backslashes, or commands.

* **Use case:** When you want exactly what you typed, no exceptions.

```bash
NAME="Gemini"
echo 'Hello $NAME' 
# Output: Hello $NAME

```

> **Note:** You cannot put a single quote inside single quotes, even with a backslash.

---

#### 2. Double Quotes (`" "`): The Interpretive String

Double quotes are "flexible." They protect the string from being split by spaces (word splitting), but they still allow the shell to interpret specific special characters like `$`, ```, and `\`.

* **Use case:** When you want to include variables or command results within a string.

```bash
NAME="Gemini"
echo "Hello $NAME"
# Output: Hello Gemini

```

##### The Difference in Action:

| Feature | Single Quotes (`'`) | Double Quotes (`"`) |
| --- | --- | --- |
| **Variable Expansion (`$VAR`)** | No (Literal) | **Yes** |
| **Command Substitution** | No (Literal) | **Yes** |
| **Backslash Escapes** | No (Literal) | **Yes** |

---

#### 3. Backticks (`` ``): The Command Substitution

Backticks are used to execute a command and capture its output into a variable or another string.

* **Modern Alternative:** While backticks still work, the modern standard is `$(command)`. It is preferred because it is easier to nest (put a command inside a command).

```bash
# Using Backticks
CURRENT_DIR=`pwd`

# Using Modern Syntax (Recommended)
CURRENT_DIR=$(pwd)

echo "You are currently in: $CURRENT_DIR"

```

---

#### The "Final Boss" Demo

Here is a single script that demonstrates how these three interact:

```bash
USER_COUNT=$(who | wc -l) # Command substitution

# 1. Double Quotes: Expands the variable
echo "There are $USER_COUNT users logged in."
# Output: There are 3 users logged in.

# 2. Single Quotes: Treats everything as text
echo 'The variable is written as $USER_COUNT'
# Output: The variable is written as $USER_COUNT

# 3. Mixing them: Using backticks inside double quotes
echo "Today is `date`"
# Output: Today is Tue Jan 27 13:21:19 EST 2026

# 3. (Modern style) Mixing them: Using backticks inside double quotes
echo "Today is $(date)"
# Output: Today is Tue Jan 27 13:21:19 EST 2026

```

**Why does this matter?**

If you have a filename with a space, like `My Resume.pdf`, and you try to run `ls $FILE` without double quotes, Bash will look for two files: `My` and `Resume.pdf`. Using `ls "$FILE"` ensures Bash treats it as one single item.

### Regular expressions

A regular expression (regex for short) allow developers to match strings against a pattern, extract submatch information, or simply test if the string conforms to that pattern.

> Usually such patterns are used by string-searching algorithms for "find" or "find and replace" operations on strings, or for input validation. - [Wiki](https://en.wikipedia.org/wiki/Regular_expression)

---

#### 🚩 The Basics: Characters & Anchors

| Symbol | Description | Example |
| --- | --- | --- |
| `.` | **Wildcard**: Matches any single character except newline. | `b.t` matches `bat`, `bet`, `bit`. |
| `^` | **Start**: Matches the beginning of a line. | `^Hello` matches "Hello world". |
| `$` | **End**: Matches the end of a line. | `bye$` matches "See ya, bye". |
| `\` | **Escape**: Lets you search for special characters like `.` or `*`. | `\.com` matches ".com". |
| ` \| ` | **OR**: Matches the pattern on the left or the right. |

---

#### 🔢 Quantifiers: "How many?"

* `*` : **0 or more** (The "greedy" one).
* `+` : **1 or more** (At least one must exist).
* `?` : **0 or 1** (Makes the character optional).
* `{n}` : **Exactly n** times (e.g., `\d{3}` matches 3 digits).
* `{n,m}` : **Between n and m** times.

---

#### 📦 Character Classes & Shorthand

| Shorthand | Meaning | Equivalent To |
| --- | --- | --- |
| `\d` | Any **Digit** | `[0-9]` |
| `\D` | Any **Non-digit** | `[^0-9]` |
| `\w` | Any **Word character** | `[a-zA-Z0-9_]` |
| `\W` | Any **Non-word character** | (symbols, spaces, etc.) |
| `\s` | Any **Whitespace** | (space, tab, newline) |
| `[abc]` | **Set**: Matches any char in brackets | `a`, `b`, or `c` |
| `[^abc]` | **Negated Set**: Matches anything *except*... | Everything but `a`, `b`, or `c` |

---

**Frequently Used Resources**
- [Regex One - Learning Tutorial](https://regexone.com/)
- [Regex 101 - Expression Generator & Validation Testing](https://regex101.com/)

**Games**
- [Regex Crossword](https://regexcrossword.com/)
- [Regex Golf](https://alf.nu/RegexGolf?world=regex&level=r00)
- [Regexle - REgex Hexagon Puzzles](https://regexle.com/)

**Examples**
- [Wordle in bash by huytd](https://gist.github.com/huytd/6a1a6a7b34a0d0abcac00b47e3d01513)

### Grep, sed, and awk

**When to use which**
- Use `grep` if you want to find or filter lines.
- Use `sed` if you want to change or delete text.
- Use `awk` for data/column manipulation. 
    - If your text looks like a table (like a CSV or log file), awk is usually the fastest tool for the job

---

#### 1. grep: The Search Engine

`grep` (Global Regular Expression Print) is used to find lines that match a specific pattern. It’s your "Find" command on steroids.

**Simple Demos:**

* **Search for a word in a file:**
`grep "error" system.log`
* **Case-insensitive search (`-i`):**
`grep -i "apple" fruit.txt` (Finds Apple, APPLE, or apple)
* **Search and show line numbers (`-n`):**
`grep -n "TODO" script.sh`
* **Invert search (`-v`):**
`grep -v "success" results.txt` (Shows everything *except* lines containing "success")

**Pro Tip: Piping to grep**

You’ll often use grep to filter the output of other commands using the pipe `|`:

```bash
# List all files, but only show the .pdf ones
ls -l | grep ".pdf"

```

---

#### 2. sed: The Stream Editor

`sed` is used to **transform** or edit text. While it can do many things, its most common use is "search and replace."

**The basic syntax:**

`sed 's/old_text/new_text/' filename`

**Simple Demos:**

* **Replace the first occurrence on each line:**
`sed 's/brown/red/' colors.txt`
* **Global replacement (`g`):**
`sed 's/brown/red/g' colors.txt` (Replaces *every* "brown" in the file)
* **Delete a line containing a pattern:**
`sed '/temporary/d' list.txt`
* **Edit the file in place (`-i`):**
`sed -i 's/localhost/127.0.0.1/g' config.conf` (Warning: This changes the actual file!)

---

**Use `grep`, then `sed`**

Imagine you have a configuration file, and you want to find all lines related to "Port" and change the port from `8080` to `9000`.

```bash
# First, use grep to see what we are working with
grep "Port" config.sys

# Now, use sed to change it
sed -i 's/8080/9000/g' config.sys

```

**The Power of RegEx**

Both commands use **Regular Expressions (RegEx)**. For example:

* `grep "^Start"` finds lines *beginning* with "Start".
* `grep "end$"` finds lines *ending* with "end".


#### 5. awk - pattern scanning and processing language

By default, `awk` sees every line as a collection of fields separated by whitespace.

**The Basics: Printing Columns**

`awk` uses `$1`, `$2`, etc., to refer to the first, second, or -th column. `$0` refers to the entire line.

```bash
# Example input: "John Doe 25"
echo "John Doe 25" | awk '{print $1, $3}'
# Output: John 25

```

---

**Changing the Delimiter (`-F`)**

If your data isn't separated by spaces (like a CSV or the system `/etc/passwd` file), you tell `awk` what the "Field Separator" is using `-F`.

```bash
# Print the usernames from the system password file (separated by :)
awk -F ":" '{print $1}' /etc/passwd

```

---

**Filtering and Math**

`awk` is actually a full programming language, so it can do things `grep` can't, like checking if a number in a specific column is greater than a certain value.

* **Find lines where the 3rd column is greater than 100:**
`awk '$3 > 100' data.txt`
* **Find a word AND print a specific column:**
`awk '/Error/ {print $5}' system.log` (Finds lines with "Error", prints 5th word)

---

**Built-in Variables: `NR` and `NF`**

* `NR` (Number of Records): The current line number.
* `NF` (Number of Fields): The count of columns in the current line.

```bash
# Print the line number followed by the first column
awk '{print NR, $1}' list.txt

# Print only lines that have exactly 3 columns
awk 'NF == 3' list.txt

```

### Scripting

#### 1. Shebang

Every Bash script should start with a Shebang. This tells the system which interpreter to use.

shebang is the combination of the `#` (pound key) and `!` (exclamation
mark)​

When it is the first two bytes of an executable (`x` mode) file, is
interpreted by the `execve`(2) system call (which executes programs)​

- `#!/bin/sh`
    – Execute the file using the Bourne shell, or a compatible shell,
assumed to be in the /bin directory​
- `#!/bin/bash`
    – Execute the file using the Bash shell​
- `#!/usr/bin/pwsh`
    – Execute the file using PowerShell​
- `#!/usr/bin/env python3`
    – Execute with a Python interpreter, using the
env program search path to find it​

---

#### 2. Variables, Reading input, Printing

No spaces around the = sign!

- Correct: `CITY="Dayton"`
- Wrong: `CITY = "Dayton"`

**Quote your variables:** Use `"$VAR"` instead of `$VAR` to prevent errors if the variable contains spaces.

**Accessing variables:** Use the `$` sign: `echo $NAME`.

**Arguments:** These are inputs passed when you run the script (e.g., `./script.sh hello 123`).

| Variable | Description |
| --- | --- |
| `$0` | The name of the script itself |
| `$1` to `$9` | The first through ninth arguments |
| `$#` | The number of arguments passed |
| `$@` | All arguments as a single list |

---

**Reading Input with `read`**

The `read` command pauses the script and waits for the user to type something.


```bash
echo "Enter your username:"
read USERNAME
echo "Welcome, $USERNAME"

```

**Pro Flags for `read`**

* **`-p` (Prompt):** Combine the echo and the read into one line.
* **`-s` (Silent):** Hide the input (perfect for passwords).
* **`-t` (Timeout):** Wait only a certain number of seconds before moving on.
* **`-n` (Character limit):** Stop reading after  characters.

```bash
read -p "Username: " USERNAME
read -sp "Password: " PASSWORD
echo -e "\nLogin successful for $USERNAME."

```

---

**`echo`: The Simple Tool**

`echo` automatically adds a newline at the end of the string.

* **`echo -n`**: Prints without the newline (keeps the cursor on the same line).
* **`echo -e`**: Enables "backslash escapes" like `\n` (newline) or `\t` (tab).

**`printf`: The Precision Tool**

`printf` (print formatted) behaves like the C function. It does **not** add a newline automatically unless you include `\n`. It is much more reliable across different Linux distributions.

**Syntax:** `printf "format string" "values"`

| Format | Description |
| --- | --- |
| `%s` | String |
| `%d` | Decimal (Integer) |
| `%f` | Float |
| `\n` | Newline |

**Example: Creating a Table Layout**

```bash
# %-10s means a string left-aligned with 10 spaces of padding
printf "%-10s %-10s\n" "USER" "ID"
printf "%-10s %-10s\n" "admin" "1001"
printf "%-10s %-10s\n" "guest" "1002"

```

---

#### 3. Conditionals and `test`

The `if` statement uses the `test` command (often written as `[ ]`) to evaluate expressions.

It is increasingly common for devs to default to the extended `test` command (often written as `[[ ]]`)

**Pro-tip:** Always put spaces inside the brackets: `[ $A == $B ]`. The brackets are representing the `test` command, which is using the values in the brackets as space separated arguments. 

**Common `test` Operators:**

* **Strings:** `==` (equal), `!=` (not equal), `-z` (is empty).
* **Numbers:** `-eq` (equal), `-ne` (not equal), `-gt` (greater than), `-lt` (less than).
* **Files:** `-f` (is a file), `-d` (is a directory).

If/Else Syntax:

```bash
if [ "$1" -gt 10 ]; then
  echo "That's a big number."
elif [ "$1" -eq 10 ]; then
  echo "Exactly ten."
else
  echo "Too small."
fi

```

---

#### 4. Loops: For and While

Loops allow you to iterate over lists of data or run commands until a condition is met.

For Loop (Iterating over a list):

```bash
for ITEM in Apple Banana Cherry; do
  echo "I like $ITEMs"
done

```

While Loop (Running until a condition changes):

```bash
COUNT=1
while [ $COUNT -le 3 ]; do
  echo "Count is $COUNT"
  ((COUNT++))
done

```

---

#### 5. Functions

Functions keep your code "DRY" (Don't Repeat Yourself). They don't take formal parameters in the parentheses; instead, they use the same `$1`, `$2` logic as the main script.

```bash
greet_user() {
  echo "Hello, $1! You are looking at the $2 directory."
}

# Calling the function
greet_user "Admin" "/home/user"

```

---

#### 6. Exit codes

**Exit Codes:** Scripts return `0` for success and non-zero for failure. You can manually set this with `exit 1`.

#### 7. Comments

**Comments:** Use `#` to explain *why* you're doing something, not just *what* the code does.

#### 8. Arguments & Scoping

This is a common point of confusion because Bash uses the same "positional parameters" (`$1`, `$2`, etc.) for both the script itself and the functions inside it.

The best way to visualize this is as **nested layers of scope**. When you are inside a function, the "global" script arguments are temporarily hidden by the function’s "local" arguments.

---

**Script Arguments (Global Scope)**

When you run a script from the terminal, the values you type after the filename are assigned to `$1`, `$2`, and so on. These are available anywhere in the script **except** inside a function that has been called with its own arguments.

**Example:** `./deploy.sh production web-server`

* `$1` is `production`
* `$2` is `web-server`

---

**Function Arguments (Local Scope)**

When you call a function, you can pass it data just like you pass data to a script. Once inside that function, `$1` no longer refers to the script's first argument; it refers to the **function's** first argument.

```bash
#!/bin/bash

# Define the function
check_status() {
  # Inside here, $1 is the argument passed TO THE FUNCTION
  echo "Function argument 1: $1"
}

# Main script logic
echo "Script argument 1: $1"

# Call the function with a specific string
check_status "Internal-Task"

```

If you ran this as `./script.sh External-Input`, the output would be:

1. `Script argument 1: External-Input`
2. `Function argument 1: Internal-Task`

---

**Passing Script Arguments into Functions**

If a function needs to know what was passed to the script, you must explicitly "pass them down" the chain.

| Method | What it does |
| --- | --- |
| `my_func "$1"` | Passes only the first script argument to the function. |
| `my_func "$@"` | Passes **all** script arguments to the function. |
| `my_func "static" "$2"` | Passes a hardcoded string as `$1` and the script's second argument as `$2`. |

**Practical Demo: The "Downstream" Effect**

```bash
#!/bin/bash

log_message() {
  local LEVEL=$1  # 'INFO' or 'ERROR'
  local MSG=$2    # The actual message
  echo "[$LEVEL] $MSG"
}

# We take the user's input from the script argument ($1) 
# and pass it into the function as the second argument ($2)
log_message "INFO" "User entered: $1"

```

---

**Key Differences Summary**

| Feature | Script Arguments | Function Arguments |
| --- | --- | --- |
| **Source** | The user/terminal | The script itself (the caller) |
| **Lifetime** | Exists for the whole script run | Exists only while function is running |
| **Variable `$0**` | The script name | **Still** the script name (not the function name) |
| **Access** | Direct | Indirect (must be passed in) |

> **Pro Tip:** Use the `local` keyword for variables inside functions (e.g., `local MY_VAR="value"`). This prevents the function from accidentally overwriting variables in the rest of your script.

#### 9. Advanced utilities

As your scripts get more professional, you’ll want to stop relying on the order of arguments (like `$1`, `$2`) and start using **flags** (like `-f file.txt` or `-v`).

The `getopts` command is the built-in Bash tool for parsing these options. It’s cleaner, handles errors automatically, and lets your users provide arguments in any order.

---

**How `getopts` Works**

`getopts` works in a `while` loop, stepping through each flag it finds.

* **The Optstring:** This is the string of allowed letters (e.g., `af:v`).
* A letter followed by a colon `:` means that flag **requires** an argument (e.g., `-f filename`).
* A letter without a colon is a standalone flag (e.g., `-v` for verbose).


* **The Variables:**
* `$OPTARG`: Holds the value of the argument (if the flag has a colon).
* `$OPTIND`: A counter that keeps track of the argument position (useful for cleanup).



---

** The `getopts` Template**

Here is a robust demo script that handles a "Name" argument and a "Verbose" toggle.

```bash
#!/bin/bash

# Initialize variables with defaults
NAME="Guest"
VERBOSE=false

# The colon at the start ":n:v" enables "silent error reporting"
# n: means -n takes an argument
# v  means -v is just a toggle
while getopts ":n:v" opt; do
  case $opt in
    n)
      NAME="$OPTARG"
      ;;
    v)
      VERBOSE=true
      ;;
    \?)
      echo "Invalid option: -$OPTARG" >&2
      exit 1
      ;;
    :)
      echo "Option -$OPTARG requires an argument." >&2
      exit 1
      ;;
  esac
done

# Shift away the parsed options so $1, $2 etc. refer to 
# any remaining non-flag arguments
shift $((OPTIND -1))

# Now we use our variables
if [ "$VERBOSE" = true ]; then
  echo "Verbose mode is ON."
fi

echo "Hello, $NAME!"

```

---

**Why the `shift` at the end?**

After `getopts` finishes, the internal counter `$OPTIND` points to the next "unprocessed" argument. If you run:
`./script.sh -n "Alice" README.txt`

`getopts` handles the `-n "Alice"` part. By running `shift $((OPTIND -1))`, you effectively "throw away" the flags you just processed. This makes `README.txt` become the new `$1`, allowing you to mix flags and file paths easily.

---

**Summary of `getopts` Syntax**

| Character | Meaning | Example |
| --- | --- | --- |
| `a` | Flag without argument | `-a` |
| `a:` | Flag with required argument | `-a "some value"` |
| `:` (at start) | Silent error mode | Prevents Bash from printing its own errors |
| `\?` | Catch-all for unknown flags | Handles `-z` (if not defined) |
| `:` (in case) | Missing argument error | Handles `-n` with nothing after it |

**Quick Comparison**

* **Positional (`$1`):** Good for quick, simple scripts where you always know the order.
* **`getopts`:** Best for tools meant for others to use, where readability and flexible ordering matter.
