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

### Useful References for Bash Scripting

- Online "Textbooks"
  - [Introduction to Bash Scripting for Developers - Bobby Iliev](https://github.com/bobbyiliev/introduction-to-bash-scripting?tab=readme-ov-file#-chapters)
  - [bash scripting tutorial - Ryan's Tutorials](https://ryanstutorials.net/bash-scripting-tutorial/)
- Bash Debuggers
  - [ShellCheck - Browser Shell Debugging](https://www.shellcheck.net/)
  - [ShellCheck - Install and use on the Linux Command Line](https://github.com/koalaman/shellcheck)
