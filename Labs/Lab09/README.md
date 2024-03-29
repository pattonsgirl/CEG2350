# Lab 09 - NOT READY

- [Lab Procedure](#Lab-Procedure)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/68834/modules/items/6128516)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab09`

Write answers in `Lab09.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab09/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - [Compiling](https://xkcd.com/303/)

1. Select from either [TODO-C](TODO-C) or [TODO-CPP](TODO-CPP).
2. Download the files in the folder to your repository folder.
3. Determine how to install the C / C++ compiler for both Windows and Linux, and find one option for how to compile and run C/C++ code if your OS does not support the compiler.
4. Compile the source code into an executable.
5. Run the executable.

## Part 2 - Document

**Useful `git` commands: `branch`, `switch`, `commit`, `push`, `merge`**

1. Fill in the User Guide section with a user guide for the program.
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

## Part 3 - [makey makey](https://www.youtube.com/watch?v=X1mYalegtdI&ab_channel=MakeyMakey)

**Useful commands: `make`**

Write a `Makefile` in the directory with your code files.

At minimum, craft the following targets:
- `default`
   - depends on source code files
   - builds an executable from the source code
- `run`
   - depends on the executable with name defined above
   - executes (runs) the executable
- `clean`
   - removes the executable

Test the targets in your `Makefile`.

## Extra Credit - Ignore That

In the root folder of your GitHub repository, create a `.gitignore` file and prevent tracking of your executable programs.  

## Submission

1. Verify that your GitHub repo has a `Lab09` folder with at minimum:

   - `Lab09.md`
   - source code files
   - `Makefile`

2. In the Pilot Dropbox, paste the URL to the `Lab09` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab09

## Rubric

- Part 1