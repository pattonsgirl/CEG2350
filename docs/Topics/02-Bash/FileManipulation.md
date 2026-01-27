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

### Resources for File Manipulation

- [An intro to Linux IO Redirection - Digital Ocean](https://www.digitalocean.com/community/tutorials/an-introduction-to-linux-i-o-redirection)