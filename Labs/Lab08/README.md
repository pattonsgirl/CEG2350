# Lab 08

- [Lab Procedure](#Lab-Procedure)

- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/68834/modules/items/6128516)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab08`

Write answers in `Lab08.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab08/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Can't SSH?

If you cannot `ssh` to your instance anymore, you may have run into one of these scenarios:
- You overwrote the partition table (or partitions) in `xvda` - this would erase your `root` / `/` filesystem.
- You wrote a bad entry in `/etc/fstab` - if the system cannot mount the disk, the boot process will hang and not complete 

If you think one of those scenarios happened to you, you'll need to go back to [Lab 01](../Lab01/) and create a new stack. Once you are in the new instance, don't forget the steps to cloning your GitHub repo:
1. create a new keypair for authentication to GitHub
2. add the public key to your GitHub user settings
3. clone with `ssh`

## Part 1 - Game the system

**Useful commands: `apt`, `which`, `whereis`**

Choose a command line game from this site: [It's Foss - Top 10 Command Line Games for Linux](https://itsfoss.com/best-command-line-games-linux/)
   - `bastet` is what this lab was tested on

In the answer template, document the game name, how you installed it, where the executable is located, and how to run the game.

For the remainder of this lab, you will be running this game to practice controlling processes.

## Part 2 - 

## Submission

1. Verify that your GitHub repo has a `Lab08` folder with at minimum:

   - `Lab08.md`

2. In the Pilot Dropbox, paste the URL to the `Lab08` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab08

## Rubric

- Part 1 - 1 pt per answer - 4 pts total
- Part 2 - 1 pt per question - 6 pts total
- Extra credit - 10% (2 pts)
