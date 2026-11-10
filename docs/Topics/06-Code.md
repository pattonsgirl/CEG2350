**Core Commands:**
- `strace`
- `ldd`
- `gcc` / `g++` or `gpp`
- `java` and `javac`
- `python`
- `make`

Historic Connections:
- [Interview with Ken Thompson, creator of Unix - Computer History Museum](https://computerhistory.org/blog/a-computing-legend-speaks/)
    - [UNIX v4 source code - Gunkies](https://gunkies.org/wiki/UNIX_Fourth_Edition)

Open Source - The good and the bad
- [12 Open Source Projects Born from Resistance - It's FOSS](https://itsfoss.com/community-strikes-back-with-forks/)

Video Games:
- [The story of Zork - Hackaday](https://hackaday.com/2019/05/22/zork-and-the-z-machine-bringing-the-mainframe-to-8-bit-home-computers/)

## Interesting Little Demo - bridges compilation, symbol inspection, and basic assembly-level reverse engineering using a simple password-checker program.

---

### Part 1: The Source Code (`check.c`)

Save this code in a file named `check.c`. It takes a command-line argument, checks it against a hardcoded string, and branches based on the result.

```c
#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: %s <password>\n", argv[0]);
        return 1;
    }

    // Hardcoded check for students to find via disassembly
    if (strcmp(argv[1], "secret123") == 0) {
        printf("Access Granted! Welcome, admin.\n");
    } else {
        printf("Access Denied. Incorrect password.\n");
    }

    return 0;
}

```

---

### Part 2: The Makefile

Save this in the same directory as `Makefile`. It uses standard variables (`CC`, `CFLAGS`) and includes a clean target.

```make
CC = gcc
CFLAGS = -Wall -Wextra -g

all: check

check: check.c
	$(CC) $(CFLAGS) check.c -o check

clean:
	rm -f check

```

---

### Part 3: Student Lab Instructions & Commands

Have your students open a terminal in the directory containing the files and walk through the following exercises:

#### Step 1: Compile and Test

```bash
# Compile the program
make

# Run it incorrectly
./check wrongpassword

# Run it correctly
./check secret123

```

#### Step 2: Inspecting Symbols (`nm`)

Ask students to look at the binary's symbol table to see what function names are preserved.

```bash
nm check | grep -E "main|strcmp|printf"

```

* **Discussion Question:** Can they see `strcmp` and `printf`? Point out that because it's dynamically linked, those functions point to external references resolved at runtime.

#### Step 3: Disassembly & Finding the Branch (`objdump`)

Have students dump the assembly instructions for the `main` function to locate the conditional logic:

```bash
objdump -d check | grep -A 40 main

```

* **What to look for:**
1. Look for the call to `strcmp`.
2. Right after `strcmp`, look for a comparison instruction (`cmp` or `test`) and a conditional jump instruction like `je` (Jump if Equal) or `jne` (Jump if Not Equal).
3. Explain to students: *This* single assembly instruction is what decides whether the user sees "Access Granted" or "Access Denied."



#### Step 4: The Reverse Engineering Challenge

* **The Task:** Without modifying the source code file, can a student figure out what the password is just by reading the assembly or running strings on the binary?
* **Bonus Tool (`strings`):** Show them how running `strings check` immediately reveals plain-text strings embedded in the binary data segment (including `"secret123"`, `"Access Granted!"`, and `"Access Denied."`), highlighting why hardcoding clear-text secrets in binaries is insecure.