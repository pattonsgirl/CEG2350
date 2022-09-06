# Lab 01

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Play with directories and naming](#Part-1---Play-with-directories-and-naming)
- [Part 2 - Create and edit a file](#Part-2---Create-and-edit-a-file)
- [Part 3 - Play with hidden files](#Part-3---Play-with-hidden-files)
- [Part 4 - AWS Academy Setup](#Part-1---AWS-Academy-Setup)
- [Part 5 - git cloning](#Part-2---git-cloning)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Pre-Reqs

This lab assumes

1. That you have a working Linux / Unix based terminal

   - Windows users: WSL2
   - Mac users: Terminal
   - Linux / Unix users: Terminal

2. You have created a GitHub account and clicked the link in Pilot to generate your GitHub  
   repository for this course

   - If you forgot to bookmark it, the URL is similar to:
   - `https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME`

## Lab Procedure

For each lab in this course, you will be provided with a lab template to fill in your lab answers. The [Lab 01 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab01/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab01/LabTemplate.md`

In your browser, go to your GitHub repository - `https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME`

Click the `Add File` button, then select "Create new file"

Name the file `Lab01.md`. In the edit file box, **paste** the contents of the lab template.

For each part below, you will be asked to perform an action or answer a question. The actions are going to be commands - **you will write the command(s) you used as "answers" to the action requested**. You are allowed to use multiple commands to solve an action. Just make sure to write every command you used to complete the action. Check with the TAs if you need clarification.

```
Example:
Prompt: Create a file named bubbles.txt
Answer: `touch bubbles.txt`
```

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

When you are ready to save your work (or take a break), scroll to the bottom to view the dialog regarding `commit`ting your work. For the moment, think of commits as save points. For each save point, you will write a message about what changed.

- Notice there are two textboxes in the commit field - skinny and paragraph sized. The skinny box is where you'll place a quick description - this one is required to create a `commit`. The paragraph sized box is where you can add bigger details about changes.
- The radio button defaults to select `Commit directly to the main branch.` - leave this as is.
- Select the green `Commit` button when you are ready to save your work.

To continue editing your file:

- Click on the file
- Click on the "Edit this file" pencil icon towards the right
- When you are done editing, repeat the steps above to `commit` your work.

## Part 1 - Play with directories and naming

- **Useful commands for this part: `man, mkdir, cd, ls, pwd, mv`**

1. Create a directory called `DirA`
2. Create a directory called `Dir B`
   - You must end up with a folder named `Dir B`
3. How do you go into `Dir B`?
4. Which of these uses a better naming convention, and why?
5. Rename `Dir B` to `DirB`

## Part 2 - Create and edit a file

- **Useful commands for this part: `touch, vim`**

1. In `DirA`, create a file called `test.txt`
2. Put at least three lines of text in `test.txt` using `vim`

## Part 3 - Play with hidden files

- **Useful commands for this part: `cp, mv, ls`**

1. Make a copy of `test.txt` inside `DirA` named `.hiddentext.txt`
2. Write the command and flags needed to see the file in `DirA`

## Part 4 - AWS Academy Setup

An email was sent to your wright.edu account inviting you to join AWS Academy.  
Follow the instructions in [AWS Academy](../../AWSAcademySetup.md) to set up your AWS instance.

## Part 5 - git cloning

`ssh` to your AWS instance for this part (finish setup from Part 4). It is highly recommended you look at the Resources listed below.

- **Useful commands for this part: `ssh-keygen`, `cat`, `git clone`, `git add`, `git commit`, `git push`**

1. Create an SSH key pair on your AWS Ubuntu instance.
2. Add the public key to GitHub
3. Clone your repository (a.k.a. repo) to the `ubuntu` user's home directory

- **Resources:**
- [GitHub Classrooms - How to Use](../../GitHubSetup.md)
- [GitHub - Generating a New SSH Key](https://docs.github.com/en/enterprise-server@3.3/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)
- [GitHub - Adding SSH key to your GitHub Account](https://docs.github.com/en/enterprise-server@3.0/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)

## Submission

- In the Pilot Dropbox, paste the URL to the `Lab01.md` file in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/blob/main/Lab01.md

## Rubric

- Each question is worth 1 point.
- This lab is worth a total of 11 points
