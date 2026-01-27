### Environment variables, PATH, shell config files

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
