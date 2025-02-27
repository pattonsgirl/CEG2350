# Lab 10

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Compilers](#part-1---compilers)
- [Part 2 - Compiling](#part-2---compiling)
- [Part 3 - Document](#part-3---document)
- [Part 4 - `makey makey`](#part-4---makey-makey)
- [Extra Credit - Ignore That](#extra-credit---ignore-that)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/68834/modules/items/6128516)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

**Create a new directory, `Lab10`**

Write answers in `README.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab10/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - Compilers

For your OS **and** for your AWS instance, find how to install the following compilers / interpreters:

- Java
- C++
- Python

Find recommended web based IDEs that allow you to program and compile in:

- Java
- C++
- Python

## Part 2 - [Compiling](https://xkcd.com/303/)

Use your AWS instance.

**Useful Commands: `gcc`, `g++`, `wget`**

1. Select from either [TODO-C](TODO-C) or [TODO-CPP](TODO-CPP). Download the files in the folder to the `Lab10` folder in your repository folder.  `add`, `commit` and `push` the source code files.
2. Install the C / C++ compiler on your AWS instance.
3. Verify the installation of the C / C++ compiler on your AWS instance.
   - It is recommended to query for the version of the program to validate installation.
4. Using your AWS instance, compile the source code into an executable program.
5. Using your AWS instance, run the executable program.

Resources:
- [Scaler - Compilation Process in C](https://www.scaler.com/topics/c/compilation-process-in-c/)
- [Dartmouth - Compiling With Multiple Source Files](https://www.dartmouth.edu/~rc/classes/softdev_linux/complex_compile.html)

## Part 3 - Document

Use your AWS instance.

**Useful `git` commands: `branch`, `switch`, `commit`, `push`, `merge`**

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

## Part 4 - [`makey makey`](https://www.youtube.com/watch?v=X1mYalegtdI&ab_channel=MakeyMakey)

Use your AWS instance.

We are aware of how generative tools respond to the prompt below.  It adds additional things not asked by this exercise.  Your answer may only perform these tasks, not additional tasks.

**Useful commands: `make`**

Write a `Makefile` in the directory with your code files.

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

## Extra Credit - Ignore That

In the root folder of your GitHub repository, create a `.gitignore` file and prevent tracking of your executable programs.  

If you already added your executable for tracking, remove it from future tracking with `git rm --cached <file_name>`, then `commit` & `push` the change.
   - Just `git rm` would delete it from your working directory ("filesystem") and from tracking.  The `--cached` flag remove it only from tracking.

Resources:
- [GitHub Docs - Ignoring files](https://docs.github.com/en/get-started/getting-started-with-git/ignoring-files)
- [Git Docs - `gitignore` Documentation](https://git-scm.com/docs/gitignore)
- [Example `.gitignore` file](../../.gitignore)

## Submission

1. Verify that your GitHub repo has a `Lab10` folder with at minimum:

   - `README.md`
   - source code files
   - `Makefile`

2. In the Pilot Dropbox, paste the URL to the `Lab10` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab10

## Rubric

- Part 1 - 9 pts total, 1 point per answer

- Part 2 - 5 pts total, 1 point per question

- Part 3 - 6 pts total, 1 point for each item below:
   - User Guide clearly addresses each category
   - branch made with commits (and visible in GitHub)
   - 7 comment blocks added to source code
   - Each comment block includes description, parameters, and return values
   - branch merged to `main` (and commented code visible from `main`)
   - `git` `branch` Guide filled out with commands
   - 0 points will be given if your assignment repository does not contain a branch

- Part 4 - 5 pts total, 1 point for each item below:
   - `Makefile` exists in `Lab10` folder
   - `Makefile` has target to build executable program (given dependencies exist)
   - `Makefile` has target execute program (given dependencies exist)
   - `Makefile` has target remove executable program
   - Commands to use `Makefile` added to guide
   - 0 points will be awarded if `Makefile` contains additional taskings / suspicion of generative AI use

- Extra Credit - 1 point