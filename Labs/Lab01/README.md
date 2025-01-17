# Lab 01

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - GitHub Profile](#Part-1---GitHub-Profile)
- [Part 2 - Research](#part-2---research)
- [Part 3 - Command Line Navigation](#part-3---command-line-navigation)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Pre-Reqs

- A GitHub account
- Know your OS terminal - PowerShell for Windows, Terminal for Mac / Linux
- Download and install git
- Download and install GitHub Desktop (recommended for ease)
- Download and install VS Code

For your username repository & your course repository, **clone** (copy) the repository locally by selecting "Code", then selecting "Open with GitHub Desktop".  GitHub Desktop will then open with the repository details - select Clone to continue.  Select "Open in Visual Studio Code".

Your cloned repository folder will now open in Visual Studio Code.  From here, you can add and edit files and folders into the repository folder.  Use the "Source Control" menu to write commit messages, make commits, and synchronize changes with GitHub (you can then refresh the browser page to see the changes after sync).

2. You have created a GitHub account and clicked the link in Pilot to generate your GitHub  
   repository for this course

   - If you forgot to bookmark it, the URL is similar to:
   - `https://github.com/WSU-kduncan/ceg2350s25-YOURGITHUBUSERNAME`

## Lab Procedure

For each lab in this course, you will be provided with a lab template to fill in your lab answers. The [Lab 01 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab01/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab01/LabTemplate.md`

Assuming that you have cloned your repository and can open it in VS Code...

Create a new file in your repository workspace named `Lab01.md`.  In this file, **paste** the contents of the Lab 01 template.  

As you work through the lab, practice making commits and synchronizing to your repository on GitHub.  As the course progress, a history of multiple commits will become requirements.

## Part 1 - GitHub Profile

1. Setup a profile repository that will be visible on your `https://github.com/your_username` page. Clone this repository to your system and edit the `README.md` file per the requirements below. 
  - [Instruction to set up a profile README](https://docs.github.com/en/get-started/start-your-journey/setting-up-your-profile#adding-a-profile-readme)
2. Your profile must include: 
   - your name
   - your intended major
   - pick at least two projects you are going to work on this semester (because of a course or personal projects) and give an overview of them
3. Visit some well-built profile repositories for inspiration and to form an idea of what your profile could look like as your experiences and projects mature:
   - [coderjojo - Awesome Developer Profiles](https://github.com/coderjojo/creative-profile-readme)
   - [Maximous Black - GitHub Profile collection](https://github.com/maximousblk/maximousblk)
4. Edit the Lab Template to make the link validly point to your GitHub profile - `https://github.com/your_username`

***Fun Resources***
- [Markdown cheatsheet](https://www.markdownguide.org/cheat-sheet/)
- [GitHub Emoji Support](https://www.webfx.com/tools/emoji-cheat-sheet/)

## Part 2 - Research

In your lab template, fill out the Action column associated with the Command Line commands that perform similar functions.  PowerShell for Windows aliases its Verb-Noun style commands to Unix / Linux style simply named commands.  You should see what aliases work (or don't) in Part 3 if you use Windows OS.

| Windows | Linux / Mac | Action |
| ---     | ---         | ---    |
| help    | man         |        |
| Get-Location | pwd    |        |
| Get-ChildItem | ls    |        |
| mkdir   | mkdir       |        |
| Set-Location | cd     |        |
| New-Item | touch      |        |
| Move-Item | mv        |        |
| Copy-Item | cp        |        |
| Remove-Item | rm      |        |
| notepad.exe | vim     |        |

You may, and should, look up the function of the above commands.  Your summary should be in your own words.

## Part 3 - Command Line Navigation

There are three primary Operating System categories - Windows, Mac, and Linux.  The system you are physically touching utilizes one of these three OSes.  Your first tasking is to start using the Command Line program for you operating system and learn how to use commands to get around and create folders (directories) and files.

In the lab template, make sure the `x` is appropriately located according to your OS.

For your OS, open the default shell and navigate to your user's directory (folder).  Hint:
- Windows = PowerShell
- Mac = Terminal
- Linux = [insert system terminal emulator here]

You'll perform the actions given in the numbered list below.

Cite sources, if needed, about how you found out how to do certain actions.  If you used generative AI as a source, include the platform and the prompt used.  Add your citations notes to the section in your Lab Template.

Start in your user's home directory.

1. Create a directory named `DirA`
2. Create a directory named `Dir B` - the space in this name is intentional
3. Go into `DirA`
4. Go into `Dir B` from `DirA`
5. Return to your user's home directory
6. Create a file named `test.txt`
7. Move the file named `test.txt` into `DirA`
8. Edit the contents of `test.txt` with some words of encouragement for yourself
9. Make a copy of `test.txt` named `copy.txt` in `DirA`
10. View the contents of `DirA`
11. Make a copy of `test.txt` in `Dir B` named `fodder.txt`
12. Delete / remove both `fodder.txt` AND `Dir B`
   - Challenge: delete `Dir B` and `fodder.txt` in one command

## Submission

Remember that we can only grade what we see in GitHub.  Make sure to commit and synchronize (push) your changes to your files.

- In the Pilot Dropbox, paste the URL to the `Lab01.md` file in your GitHub repo
  - URL should look like: https://github.com/WSU-kduncan/ceg2350s25-YOURGITHUBUSERNAME/blob/main/Lab01.md

## Rubric

Your answers should be cleanly presented in your GitHub repository.  Citations should be included as needed.  Include which generative AI system was used and what prompts were used if generative AI was used.

- Part 1 - GitHub profile repository - 5 pts
   - is visible
   - contains name
   - contains major
   - contains 2 project descriptions
   - looks nice
- Part 2 - Research - 10 pts
   - 1 pt / description
- Part 2 - Commands Line Navigation - 12 pts
   - 1 pt / question
