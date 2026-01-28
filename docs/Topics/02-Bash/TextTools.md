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

### Resources for grep, sed, and awk

- [grep - Digital Ocean](https://www.digitalocean.com/community/tutorials/grep-command-in-linux-unix)
- [sed - Digital Ocean](https://www.digitalocean.com/community/tutorials/the-basics-of-using-the-sed-stream-editor-to-manipulate-text-in-linux)
- [awk - Digital Ocean](https://www.digitalocean.com/community/tutorials/awk-command-linux-unix)
    - [awk substitution - GNU awk Manual](https://www.gnu.org/software/gawk/manual/html_node/String-Functions.html#index-gensub_0028_0029-function-_0028gawk_0029-1)

**Challenges**
- [`sed` mastery challenge - iximiuz playground](https://labs.iximiuz.com/challenges/sed-command-basics-1-b2c4c9e9)
- [`awk` mastery challenge - iximiuz playground](https://labs.iximiuz.com/challenges/Mastering-awk-command-challenge-01-efd63f6f)