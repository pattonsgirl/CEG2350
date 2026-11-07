# Lab 10 - Compiling, Makefiles, and Libraries

- [Lab Procedure](#Lab-Procedure)
- [Part 0 - Issues & Branches](#part-0---issues--branches)
- [Part 1 - Compilers](#part-1---compilers)
- [Part 2 - Compiling](#part-2---compiling)
- [Part 3 - Git Hygiene](#part-3---git-hygiene-gitignore)
- [Part 4 - Fix It](#part-4---fix-it)
- [Part 5 - `makey makey`](#part-5---makey-makey)
- [Part 6 - Libraries & Other OSes](#part-6---libraries--other-oses)
- [Part 7 - Citations & Resources](#part-7---resources--citations)
- [Extra Credit - Cross-Platform `Makefile`](#extra-credit---cross-platform-makefile)
- [Submission](#submission)
- [Rubric](#rubric)

## Lab Procedure

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab10`.

Create a file named `README.md` in the `Lab10` folder.  The [Lab 10 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab10/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab10/LabTemplate.md`

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

## Part 0 - Issues & Branches

**Useful `git` commands: `branch`, `switch`, `commit`, `push`, `merge`**

0. To begin, create and add the Lab Template to your `main` branch in your `Lab10` folder
1. In your GitHub repository, go to the `Issues` tab.  Create an Issue **for each part** of this lab - you may do this all at once or as you start each part.
2. Through this lab, you will create **one** branch **for each** issue.
3. Merge the branch with the `main` branch as your **complete each part**.  You may then mark your issue as complete.
4. If you make **adjustments after merging** you need to create an Issue describing what needs correcting, then resolve the issue.

The merge for **Part 4** must be completed via a **Pull Request** - all others should be done via branch merging on the command line.

Let's practice!

1. Create an Issue - title it `git guide - Part 0`.
2. Create a branch - on the branch, open your lab template file, fill in the `git` guide below.  Make `commit`s on the branch.
3. `push` your changes to your `branch` - GitHub won't know what branch you are talking about - read the output, it will help you do the next step to `push` your `branch` to GitHub!
4. Verify that you like the way the markdown turned out now that it's been pushed to GitHub (make sure you are viewing the right `branch`!)
5. `merge` your change from your branch to `main`.
6. Mark your issue as resolved! 
7. **DO NOT DELETE YOUR BRANCHES.  DO NOT DELETE YOUR ISSUES**


Fill out the `git` guide table so you have a resource of useful commands you can refer to throughout the lab!  The Notes column should have any "notes to self" you want to leave behind - easy oopsies to make, double check something, etc.

| Task                                                    | Command(s) / Steps | Notes |
| ------------------------------------------------------- | ------------------ | ----- |
| **Create a branch**                                     |                    |       |
| **Change to branch**                                    |                    |       |
| **Add branch to remote if created locally (GitHub)**    |                    |       |
| **Steps to `merge` changes from another branch to (`main`)** |                    |       |
| **Steps to resolve a `merge` conflict**                 |                    |       |

**Resources**
- [Quickstart for GitHub Issues - GitHub Docs](https://docs.github.com/en/issues/tracking-your-work-with-issues/learning-about-issues/quickstart)
- [Git Cheat Sheet - git-scm](https://git-scm.com/cheat-sheet)
- [(Video) SuperSimpleDev - Git Branching and Merging Tutorial](https://www.youtube.com/watch?v=Q1kHG842HoI&ab_channel=SuperSimpleDev)
- [Git Branching - Branches in a Nutshell - git-scm](https://git-scm.com/book/en/v2/Git-Branching-Branches-in-a-Nutshell)
- [Git Branching - Basic Branching and Merging - git-scm](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging)
- [About branches - GitHub Docs](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-branches)
- [Working with branches on GitHub - GitHub Docs](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-and-deleting-branches-within-your-repository)
- [Git merge conflicts - Atlassian](https://www.atlassian.com/git/tutorials/using-branches/merge-conflicts)

## Part 1 - Compilers

**Reminder** - create an Issue for this part -> create a branch to work on this issue -> make your commits to this branch -> verify your changes (no broken markdown, good spelling) -> merge to main. **DO NOT DELETE YOUR BRANCH AFTER MERGING.  DO NOT DELETE YOUR ISSUE**

**Useful commands: `apt`, `which`, `gcc`, `make`**

This lab builds a C program, so you need a C compiler and `make`.  The charts below are your reference for getting the both on different OSes.

**Installing the compiler for different OSes**

| Language    | Compiler  | Linux (Ubuntu/Debian)              | macOS                    | Windows |
| ----------- | --------- | ---------------------------------- | ------------------------ | ------- |
| **C / C++** | GCC / G++ | `sudo apt install build-essential` | `xcode-select --install` | Install **MinGW** via [MSYS2](https://www.msys2.org/) <br>→ `pacman -S mingw-w64-x86_64-gcc make` |

**Verifying install location & version**

| Language    | OS                    | Confirm Installation Command | Check Version Command | Expected Output Example                          |
| ----------- | --------------------- | ---------------------------- | --------------------- | ------------------------------------------------ |
| **C (GCC)** | Linux                 | `which gcc`                  | `gcc --version`       | `gcc (Ubuntu 13.2.0) 13.2.0`                     |
|             | macOS                 | `which gcc`                  | `gcc --version`       | `Apple clang version 15.0.0 (clang-1500.0.40.1)` |
|             | Windows (MSYS2/MinGW) | `where gcc`                  | `gcc --version`       | `gcc.exe (Rev10, Built by MSYS2 project) 13.2.0` |

1. Install the C compiler and `make` on your AWS instance.
2. Verify the installation of both.
3. In the template, note what the install and verify commands would be on **your own computer's OS**.  If your computer runs Ubuntu, pick macOS or Windows instead.

## Part 2 - [Compiling](https://xkcd.com/303/)

**Reminder** - create an Issue for this part -> create a branch to work on this issue -> make your commits to this branch -> verify your changes (no broken markdown, good spelling) -> merge to main. **DO NOT DELETE YOUR BRANCH AFTER MERGING.  DO NOT DELETE YOUR ISSUE**

**Useful commands: `wget`, `tar`, `make`, `gcc`**

The program for this lab is a small to-do list split across multiple files:

| File                      | Purpose                                                       |
| ------------------------- | ------------------------------------------------------------- |
| `main.c`                  | The menu.  Calls the functions in `todo.c`                    |
| `todo.c` / `todo.h`       | Adds, completes, removes, and lists tasks                     |
| `display.c` / `display.h` | A full screen view of the list.  Not used until Part 6        |
| `Makefile`                | A starting point.  It only knows about `main.c`               |

1. Download [todo-lab.tar.gz](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab10/todo-lab.tar.gz) to your `Lab10` folder in your repository folder.
   - `https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab10/todo-lab.tar.gz`
2. Extract the files from the `.tar.gz`.
3. Go into the `todo-lab` folder and run `make`.  **It will fail.**  Read the error, then explain in the template what `undefined reference` means and why `make` hit it.
4. Compiling has two stages, and you can run them yourself to see where it went wrong.  Without using `make`:
   - Compile `main.c` and `todo.c` each into an object file (`.o`) with `gcc -c`.
   - Link the two object files into an executable named `todo_app`.
5. Run `todo_app` and try each menu option.
6. Add the original `.tar.gz` and the `todo-lab` source files to your repository.  Do not add the compiled executable or the object files for tracking.

**Resources:**
- [Tar Command in Linux: Create and Extract Archives with Examples - Linuxize](https://linuxize.com/post/how-to-create-and-extract-archives-using-the-tar-command-in-linux/)
- [Compilation Process in C - Scaler](https://www.scaler.com/topics/c/compilation-process-in-c/)
- [Compiling With Multiple Source Files - Emory](http://www.cs.emory.edu/~cheung/Courses/255/Syllabus/1-C-intro/declare-func1b.html)

## Part 3 - Git Hygiene (`.gitignore`)

**Reminder** - create an Issue for this part -> create a branch to work on this issue -> make your commits to this branch -> verify your changes (no broken markdown, good spelling) -> merge to main. **DO NOT DELETE YOUR BRANCH AFTER MERGING.  DO NOT DELETE YOUR ISSUE**

1. Create a `.gitignore` file in the root of your repository (or update your existing one).
2. Ensure that built executables (`todo_app`) and compiled object files (`*.o`) are ignored by Git.
3. If an executable was accidentally tracked, untrack it without deleting local files with `git rm --cached <file_name>`, then `commit` & `push` the change.
   - Just `git rm` would delete it from your working directory ("filesystem") and from tracking.  The `--cached` flag removes it only from tracking.

Resources:
- [Ignoring files - GitHub Docs](https://docs.github.com/en/get-started/getting-started-with-git/ignoring-files)
- [`gitignore` Documentation - git-scm](https://git-scm.com/docs/gitignore)
- [Example `.gitignore` file](https://github.com/pattonsgirl/CEG2350/blob/main/.gitignore)

## Part 4 - Fix It

**Reminder** - create an Issue for this part -> create a branch to work on this issue -> make your commits to this branch -> verify your changes -> **merge with a Pull Request**. **DO NOT DELETE YOUR BRANCH AFTER MERGING.  DO NOT DELETE YOUR ISSUE**

The to-do program has a bug.  To see it:

1. Add two tasks.
2. Remove the first task.
3. View the list.

For this part, your documentation lives in `git`, where a teammate would look for it:

1. Write the Issue as a bug report: what you did, what you expected, and what happened instead.
2. Find and fix the bug on your branch.  Rebuild and confirm the steps above now work.
3. Write a commit message that says what changed and why.  `fixed bug` doesn't tell a teammate anything.
4. Open a Pull Request to `main`.  The description should cover:
   - What was wrong
   - What you changed to fix it
   - How you tested the fix
   - `Closes #N`, where `N` is your Issue number, so the two are linked
5. Merge the Pull Request.
6. Add links to your Pull Request and fix commit in the template.

**Resources:**
- [About Pull Requests - GitHub Docs](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests)
- [Creating a Pull Request - GitHub Docs](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request)
- [Managing pull request reviews in your repository - GitHub Docs](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/managing-repository-settings/managing-pull-request-reviews-in-your-repository)
- [Linking a pull request to an issue - GitHub Docs](https://docs.github.com/en/issues/tracking-your-work-with-issues/using-issues/linking-a-pull-request-to-an-issue)

## Part 5 - [`makey makey`](https://www.youtube.com/watch?v=X1mYalegtdI&ab_channel=MakeyMakey)

**Reminder** - create an Issue for this part -> create a branch to work on this issue -> make your commits to this branch -> verify your changes (no broken markdown, good spelling) -> merge to main. **DO NOT DELETE YOUR BRANCH AFTER MERGING.  DO NOT DELETE YOUR ISSUE**

**Useful commands: `make`, `touch`**

Now teach the `Makefile` what you did by hand in Part 2.  Edit the `Makefile` you were given rather than starting over.

**Make a commit after completing (and testing) each step**

1. Add `todo.c` to `SRCS`, then confirm `make build` creates `todo_app`.
2. Build through object files:
   - Add an `OBJS` variable listing the `.o` file for each file in `SRCS`.
   - Change the `$(TARGET)` rule to depend on `$(OBJS)` and link them.
   - Add a rule that compiles a `.c` file into its `.o` file.  It should also rebuild when `todo.h` changes.
3. Add a `run` target that depends on the executable and runs it.
4. Add a `clean` target that removes the executable and all object files.

Test it out: run `make build`, then `touch todo.c`, then `make build` again.  Only `todo.c` should recompile.  In the template, explain why that's useful and how `make` knows what to skip.

**Resources:**
- [`Makefile` example](https://github.com/pattonsgirl/CEG2350/blob/main/code/Makefile)
   - See slide deck for explanation and use to use `make` to call targets
- [Multi-file `Makefile` example](https://github.com/pattonsgirl/CEG2350/blob/main/code/Makefile-multiC)
- [`make` command in Linux - Redswitches](https://www.redswitches.com/blog/make-command-in-linux/)
- [Pattern Rules - GNU `make` Manual](https://www.gnu.org/software/make/manual/html_node/Pattern-Intro.html)
- [Automatic Variables - GNU `make` Manual](https://www.gnu.org/software/make/manual/html_node/Automatic-Variables.html)

## Part 6 - Libraries & Other OSes

**Reminder** - create an Issue for this part -> create a branch to work on this issue -> make your commits to this branch -> verify your changes (no broken markdown, good spelling) -> merge to main. **DO NOT DELETE YOUR BRANCH AFTER MERGING.  DO NOT DELETE YOUR ISSUE**

**Useful commands: `apt`, `make`, `ldd`**

`display.c` draws the list with [ncurses](https://invisible-island.net/ncurses/announce.html), a library for terminal screens.  It's code you didn't write, so your build has to find it.

**Add the library**

1. In `main.c`, include `display.h` and change menu option 4 to call `display_tasks()` instead of `view_tasks()`.
2. Add `display.c` to `SRCS`, and make sure the object rule also rebuilds when `display.h` changes.
3. Run `make build`.  You will hit up to two different errors on the way to a working build.  For each one, record the error in the template, which stage of the build it came from (compiling or linking), and what you did to fix it.
   - Hint: Remember when we said `display.c` uses `ncurses`? Practice googling the errors and seeking help, but if you need clearer hints:
     - install the `ncurses` library
     - include the library in `main.c`
     - add the linker flag to the `ncurses` library to your compilation command in your `Makefile`
4. Run the program and view your list.
5. Use `ldd` on `todo_app` to list the shared libraries it needs.  Paste the output in the template and identify the line(s) for ncurses.

**Find the equivalents**

A `Makefile` that works on Ubuntu may not work anywhere else, because a library can have a different package name, a different name to link against, or not need installing at all.  Fill out this chart in the template.  The first row is done for you.

| Library (Ubuntu)    | Ubuntu package | Link flag | macOS equivalent & how to get it | Windows (MSYS2) equivalent & how to get it |
| ------------------- | -------------- | --------- | -------------------------------- | ------------------------------------------ |
| **math**            | `libc6-dev`    | `-lm`     | Built in to the system, nothing to install | Built in to the C runtime, nothing to install |
| **ncurses**         |                |           |                                  |                                            |
| **pthreads**        |                |           |                                  |                                            |
| **readline**        |                |           |                                  |                                            |

Then answer: what in **your** `Makefile` would need to change to build this program on your own computer's OS?  If your computer runs Ubuntu, pick macOS or Windows instead.

**Resources:**
- [Ubuntu Packages Search](https://packages.ubuntu.com/)
- [Homebrew Formulae](https://formulae.brew.sh/)
- [MSYS2 Packages](https://packages.msys2.org/)
- [NCURSES Programming HOWTO - TLDP](https://tldp.org/HOWTO/NCURSES-Programming-HOWTO/)

## Part 7 - Resources & Citations

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations / Resources` section of your lab answers. You may refer to your own notes (if they are digitized into GitHub), course notes, or external resources / websites.

To add citations / resources, provide the reference / link and a summary of what it assisted you with.  

If generative AI was used, include which generative AI system was used, what prompt(s) you fed it, and a summary of what it assisted you with.

We expect a minimum of **one citation / useful resource per topic** of your lab. So this lab would require a resource for:
- git branches & Pull Requests
- setting up using the .gitignore file
- compiling & linking on the command line
- creating and using a Makefile
- finding libraries for another OS
- cross-platform `Makefile`s, **if you complete the Extra Credit**

## Extra Credit - Cross-Platform `Makefile`

**Reminder** - create an Issue for this part -> create a branch to work on this issue -> make your commits to this branch -> verify your changes (no broken markdown, good spelling) -> merge to main. **DO NOT DELETE YOUR BRANCH AFTER MERGING.  DO NOT DELETE YOUR ISSUE**

Update your `Makefile` so the same file builds the program on Linux, macOS, and Windows (MSYS2):

1. Detect the OS inside the `Makefile`.
   - `make` conditionals (`ifeq`) can check the `OS` environment variable, which is `Windows_NT` on Windows.  On Linux and macOS, `uname -s` tells them apart.
2. Use your Part 6 research to set the correct library for each OS.
3. Name the executable `todo_app.exe` on Windows and `todo_app` everywhere else.
   - `run` and `clean` should still work.  Check that `.gitignore` still covers your executable.
4. Handle any differences you find along the way, and describe them in the template.
   - Hint: check where the MSYS2 package you found installs its `curses.h`.

Show that it works on Ubuntu **and** one other OS with a screenshot of the build and running program.  If you don't have access to another OS, show the output of a dry run instead, such as `make -n build OS=Windows_NT`.

Add at least one citation / useful resource for this work to your `Citations & Resources` section.

**Resources:**
- [Conditional Parts of Makefiles - GNU `make` Manual](https://www.gnu.org/software/make/manual/html_node/Conditionals.html)
- [The `shell` Function - GNU `make` Manual](https://www.gnu.org/software/make/manual/html_node/Shell-Function.html)

## Submission

The TAs will be checking your repository for Issues (open & closed), branches, Pull Requests, and commit history.

1. Verify that your GitHub repo has a `Lab10` folder with at minimum:

   - `README.md`
   - `todo-lab.tar.gz`
   - `todo-lab` folder with your source code files and `Makefile`
   - `.gitignore` file *in the root directory of your repository*

2. In the Pilot Dropbox, paste the URL to the `Lab10` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab10

## Rubric

Your files should be cleanly presented in your GitHub repository.  Citations should be included as needed.  Include which generative AI system was used and what prompts were used if generative AI was used.

[Rubric](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab10/Rubric.md)
