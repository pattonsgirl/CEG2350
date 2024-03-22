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

## Outline
- write a program that tracks a TODO list
   - add & list tasks
   - edit & remove tasks
   - ec - implement save to file & load from file
- install compiler
- download base code for python OR java (or have in template repository?) - two students per team
   - comes with `main` and side utilities
   - functions are pre-sketched with comments on what they should do
- For each utility files, make a branch.  Complete your edits, run your tests, push commits to branch
- Build an executable
   - Java = jar
   - Python = pyinstaller your_script.py 
      - `pyi-makespec --onefile --add-data "script1.py:." --add-data "script2.py:." my_spec.spec`
      - `pyinstaller my_spec.spec`

## Submission

1. Verify that your GitHub repo has a `Lab09` folder with at minimum:

   - `Lab09.md`

2. In the Pilot Dropbox, paste the URL to the `Lab09` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab09

## Rubric

- Part 1