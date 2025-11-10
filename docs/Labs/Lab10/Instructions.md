# Lab 10 - Compiling, Makefiles, and git Branching

- [Lab Procedure](#Lab-Procedure)
- [Part 0 - Issues & Branches](#part-0---issues--branches)
- [Part 1 - Common Compilers](#part-1---compilers)
- [Part 2 - Compiling](#part-2---compiling)
- [Part 3 - Ignore That](#part-3---ignore-that)
- [Part 4 - Document](#part-4---document)
- [Part 5 - `makey makey`](#part-5---makey-makey)
- [Extra Credit - `git` tools](#extra-credit---git-tools)
- [Submission](#Submission)
- [Rubric](#Rubric)

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
1. In your GitHub repository, go to the `Issues` tab.  Create an Issue **for each part** of this lab.
2. Through this lab, you will create **one** branch **for each** issue.
3. Merge the branch with the `main` branch as your **complete each part**.  You may then mark your issue as complete.
4. If you make **adjustments after merging** you need to create an Issue describing what needs correcting, then resolve the issue.

**One merge** must be completed via a **Pull Request** - all others should be done via branch merging on the command line.

Let's practice!

1. Create an Issue - title it `git guide - Part 0`.
2. Create a branch - on the branch, open your lab template file, fill in the `git` guide below.  Make `commit`s on the branch.
3. `push` your changes to your `branch` - GitHub won't know what branch you are talking about - read the output, it will help you do the next step to `push` your `branch` to GitHub!
4. Verify that you like the way the markdown turned out now that it's been pushed to GitHub (make sure you are viewing the right `branch`!)
5. `merge` your change from your branch to `main`.
6. Mark your issue as resolved!  Optionally, you make close the branch.


Fill out the `git` guide table so you have a resource of useful commands you can refer to throughout the lab!  The Notes column should have any "notes to self" you want to leave behind - easy oopsies to make, double check something, etc.

| Task                                                    | Command(s) / Steps | Notes |
| ------------------------------------------------------- | ------------------ | ----- |
| **Create a branch**                                     |                    |       |
| **Change to branch**                                    |                    |       |
| **Add branch to remote if created locally (GitHub)**    |                    |       |
| **Steps to `merge` changes to another branch (`main`)** |                    |       |
| **Steps to resolve a `merge` conflict**                 |                    |       |


## Part 1 - Compilers

Fill out the following charts regarding the three most commonly used languages - C/C++, Java, and Python.  The bonus is you'll make a guide for yourself on how to install these or how to check if they are already available.  I'm going to give you the answers for C / C++ - you'll need to complete the chart for Java and Python.

**Installing the compiler for different OSes**

| Language         | Compiler           | Linux (Ubuntu/Debian)    | macOS       |Windows        | 
| ---------------- | ------------------ | ------------------------ | ----------- | ------------- | 
| **C / C++**      | GCC / G++          | `sudo apt install build-essential`     | `xcode-select --install`  | Install **MinGW** via [MSYS2](https://www.msys2.org/) <br>→ `pacman -S mingw-w64-x86_64-gcc` |
| **Java**         | OpenJDK            |                          |             |                |                |
| **Python**       | Python             |                          |             |                |                |

**Verifying install location & verison**

| Language       | OS                    | Confirm Installation Command | Check Version Command | Expected Output Example                          |
| -------------- | --------------------- | ---------------------------- | --------------------- | ------------------------------------------------ |
| **C (GCC)**    | Linux                 | `which gcc`                  | `gcc --version`       | `gcc (Ubuntu 13.2.0) 13.2.0`                     |
|                | macOS                 | `which gcc`                  | `gcc --version`       | `Apple clang version 15.0.0 (clang-1500.0.40.1)` |
|                | Windows (MSYS2/MinGW) | `where gcc`                  | `gcc --version`       | `gcc.exe (Rev10, Built by MSYS2 project) 13.2.0` |
| **C++ (G++)**  | Linux                 | `which g++`                  | `g++ --version`       | `g++ (Ubuntu 13.2.0) 13.2.0`                     |
|                | macOS                 | `which clang++`              | `clang++ --version`   | `Apple clang version 15.0.0`                     |
|                | Windows               | `where g++`                  | `g++ --version`       | `g++.exe (Rev10, Built by MSYS2 project) 13.2.0` |
| **Java (JDK)** | Linux                 |                              |                       |                                                  |
|                | macOS                 |                              |                       |                                                  |
|                | Windows               |                              |                       |                                                  |
| **Python 3**   | Linux                 |                              |                       |                                                  |
|                | macOS                 |                              |                       |                                                  |
|                | Windows               |                              |                       |                                                  |


## Part 2 - [Compiling](https://xkcd.com/303/)

**Useful Commands: `gcc`, `g++`, `wget`**

1. Select from either [TODO-C](https://github.com/pattonsgirl/CEG2350/tree/main/Labs/Lab10/TODO-C) or [TODO-CPP](https://github.com/pattonsgirl/CEG2350/tree/main/Labs/Lab10/TODO-CPP). Download the files in the folder to the `Lab10` folder in your repository folder.  `add`, `commit` and `push` the source code files.
2. Install the C / C++ compiler on your AWS instance.
3. Verify the installation of the C / C++ compiler on your AWS instance.
   - It is recommended to query for the version of the program to validate installation.
4. Using your AWS instance, compile the source code into an executable program.
5. Using your AWS instance, run the executable program.

Resources:
- [Scaler - Compilation Process in C](https://www.scaler.com/topics/c/compilation-process-in-c/)
- [Compiling With Multiple Source Files - Emory](http://www.cs.emory.edu/~cheung/Courses/255/Syllabus/1-C-intro/declare-func1b.html)

## Part 3 - Ignore That

In the root folder of your GitHub repository, create a `.gitignore` file and prevent tracking of your executable programs.  

If you already added your executable for tracking, remove it from future tracking with `git rm --cached <file_name>`, then `commit` & `push` the change.
   - Just `git rm` would delete it from your working directory ("filesystem") and from tracking.  The `--cached` flag remove it only from tracking.

Resources:
- [GitHub Docs - Ignoring files](https://docs.github.com/en/get-started/getting-started-with-git/ignoring-files)
- [Git Docs - `gitignore` Documentation](https://git-scm.com/docs/gitignore)
- [Example `.gitignore` file](/.gitignore)

## Part 4 - Document

1. Fill in the User Guide section with a user guide for the program.  Provide clear and concise instructions on what the program is (its purpose), how to build and run it, and how to use the program.
2. Create a branch in your repository folder.  Create commits on the branch to complete the task 3.  Push your commits on the branch to GitHub.
3. For all functions in the `.c` or `.cpp` files, add a comment block that includes the following:
   - What function does
   - What its parameter values are
   - what values it returns (if a function returns one type of value usually, and another value to indicate an error, your comment should describe both of these types of return values).
```cpp
/*
 * Function:  approx_pi 
 * --------------------
 * computes an approximation of pi using:
 *    pi/6 = 1/2 + (1/2 x 3/4) 1/5 (1/2)^3  + (1/2 x 3/4 x 5/6) 1/7 (1/2)^5 +
 *
 *  n: number of terms in the series to sum
 *
 *  returns: the approximate value of pi obtained by suming the first n terms
 *           in the above series
 *           returns zero on error (if n is non-positive)
 */

double approx_pi(int n) {
  ...
}
```
4. Test that your program still compiles and the resulting executable still works as expected.
5. Merge your commits with the `main` branch - do not delete the branch.  Make sure what's visible in GitHub is:
   - your branch where you made the commits to comment the code base (do not delete the branch)
   - the code files, visible in `main`, now with comments on functions after the merge
6. Fill out the `git` `branch` Guide with commands used to work with branches.

Resources:
- [(Video) SuperSimpleDev - Git Branching and Merging Tutorial](https://www.youtube.com/watch?v=Q1kHG842HoI&ab_channel=SuperSimpleDev)
- [SuperSimpleDev - `git` / GitHub reference guide](https://supersimpledev.github.io/references/git-github-reference.pdf)
- [FreeCodeCamp - Git Branching Commands Explained with Examples](https://www.freecodecamp.org/news/git-branching-commands-explained/)
- [Geeks for Geeks - How to Set Upstream Branch on Git?](https://www.geeksforgeeks.org/how-to-set-upstream-branch-on-git/)
- [MIT - Git command-line interface](https://missing.csail.mit.edu/2020/version-control/)

## Part 5 - [`makey makey`](https://www.youtube.com/watch?v=X1mYalegtdI&ab_channel=MakeyMakey)

**Useful commands: `make`**

Write a `Makefile` in the directory with your code files.

**Make a commit after creating (and testing the operation of) each target**

At minimum, craft the following targets:
- `build`
   - depends on source code files
   - builds an executable from the source code
- `run`
   - depends on the executable with name defined above
   - executes (runs) the executable
- `clean`
   - removes the executable

Test the targets in your `Makefile`.

Create a set of instructions for using your `Makefile` to perform its different taskings.

Resources:
- [In-Class `Makefile` demonstration](../../processes/Makefile)
   - See slide deck for explanation and use to use `make` to call targets
- [RedSwitches - `make` command in Linux](https://www.redswitches.com/blog/make-command-in-linux/)
- [IOFlood - `make` command](https://ioflood.com/blog/make-linux-command/)
   - Includes CMake and AutoTools, which are out of scope for course but good to note.

## Extra Credit - `git` tools



## Submission

The TAs will be checking your repository for Issues (open & closed), branches (open and closed), and commit history.

1. Verify that your GitHub repo has a `Lab10` folder with at minimum:

   - `README.md`
   - source code files
   - `Makefile`
   - `.gitignore` file *in the root directory of your repository*

2. In the Pilot Dropbox, paste the URL to the `Lab10` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab10

## Rubric

Your files should be cleanly presented in your GitHub repository.  Citations should be included as needed.  Include which generative AI system was used and what prompts were used if generative AI was used.

[Rubric](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab10/Rubric.md)
