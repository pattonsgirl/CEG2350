# Lab 06 - Dotfile Installer Script

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - bash aliases](#part-1---bash-aliases)
- [Part 2 - Dotfile Installer Script](#part-2---dotfile-installer-script)
- [Part 3 - Retrospective](#part-3---retrospective)
- [Part 4 - Usage Guide](#part-4---usage-guide)
- [Extra Credit - Improvements](#extra-credit---improvements)
- [Submission](#Submission)
- [Rubric](#Rubric)
- [`getopts` and Error Handling](#getopts-and-error-handling)

## Lab Procedure

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab06`.

Create a file named `README.md` in the `Lab06` folder.  Copy into the file the contents of the [Lab 06 Template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab06/LabTemplate.md)

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

## Part 1 - bash aliases

Craft an `alias` with a name of your choice that pipes a `fortune` to a `cowsay` cow of your choice (`-f` flag)

Craft an `alias` with a name of your choice to something "fun".  Checkout these as suggestions.  You may need to install these programs first with `apt`.
   - `curl wttr.in`
   - `telnet towel.blinkenlights.nl`
   - have `cat` use `lolcat` instead
   - `asciiaquarium` 

Add the aliases to a file named `.bash_aliases` in your user's home directory.

Read through the `.bashrc` file in your user's home directory for a section that is relevant to "enabling" usage of the `.bash_aliases` file.  Copy and paste the snippet into your lab template and describe what it does.

Confirm that your aliases continuously work as long as the conditions are met.

Copy your `.bash_aliases` file to your GitHub repository in your `Lab06` folder.

You may delete the `.bash_aliases` file in your user's home directory as needed through this lab.

## Part 2 - Dotfile Installer Script

Your tasking is to write a script that sets up your user account to use your `.bash_aliases` To accomplish this, you will create an "installation" script that accomplishes these taskings.  

> [!WARNING] 
> You must have a **minimum** of **3 (THREE) COMMITS** made for this script.  Your commit messages must describe what's currently working / tested.  When (after which steps / testing) you make a commit is your choice.  Your commits must demonstrate an incremental building process - a bulk dump and then making a spelling change or two will not get you out of the penalty in the rubric.

1. Create a script named `dotinstall` in your `Lab06` folder.

2. Create a function called `printHelp`. `printHelp` should output the following:

```
Usage: dotinstall [-OPTION] [ARG]
  -s setup - attempts to create a symbolic link .bash_aliases file to user's home directory
  -d disconnect - removes symbolic link
  -a append - adds a new alias to .bash_aliases file
  -r remove - removes an alias from .bash_aliases file
```

2. Use `getopts` to read in options and save arguments that correlate with options. `getopts` should support the following options in the `OPTSTRING`

   - `-h`
     - call `printHelp` function and exit script
   - `-s`
     - calls function to attempt to create a symbolic link between the `.bash_aliases` in the `Lab06` folder to a `.bash_aliases` in the user's home directory
     - if `.bash_aliases` already exists, prompt the user to confirm the most appropriate action before overwriting the existing file
   - `-d`
     - calls function to remove symbolic link from user's home directory
   - `-a`
      - is followed by an argument - a string containing an alias
      - calls a function to append the given alias to `.bash_aliases`
   - `-r`
      - is followed by an argument - a string containing an alias name
      - calls a function to search for and remove the alias of the name from `.bash_aliases`
      - user should be notified if no matching alias was found
   - `\?`
     - use as case when option is not part of `OPTSTRING`
     - call `printHelp` and exit script

```
# Sample runs of working script

$ bash dotinstall -h
Usage: dotinstall [-OPTION] [ARG]
  -s setup - attempts to create a symbolic link .bash_aliases file to user's home directory
  -d disconnect - removes symbolic link
  -a append - adds a new alias to .bash_aliases file
  -r remove - removes an alias from .bash_aliases file

$ bash dotinstall -s -a 'alias ls=ls -lah'
No .bash_aliases file found in /home/ubuntu
Creating symbolic link in /home/ubuntu named .bash_alaises
Adding alias to .bash_alaises
User should the following to reload the shell:
   source ~/.bashrc

$ bash dotinstall -r ls
Found alias for ls in .bash_aliases
Alias for ls removed from .bash_aliases

$ bash dotinstall -d 
Removing symbolic link in /home/ubuntu named .bash_alaises
User should the following to reload the shell:
   source ~/.bashrc

$ bash dotinstall -z
Option not supported.
Usage: dotinstall [-OPTION] [ARG]
  -s setup - attempts to create a symbolic link .bash_aliases file to user's home directory
  -d disconnect - removes symbolic link
  -a append - adds a new alias to .bash_aliases file
  -r remove - removes an alias from .bash_aliases file
```

**Resources**
Before panicking, keep in mind that `getopts` is mostly a while loop iterating through arguments with a `switch` statement to define what to do on finding certain options.  Play with the demos linked below before diving all in.  Plan plan plan!

- [getopts-basics.sh](getopts-basics.sh)
- [cfgetopts.sh](cfgetopts.sh)
- [`getopts` tutorial - shellscript](https://www.shellscript.sh/tips/getopts/)
- [breaking down how `getopts` works - assertnotmagic](https://www.assertnotmagic.com/2019/03/08/bash-advanced-arguments/)
- [parse Arguments In Bash Scripts Using `getopts` - ostechnix](https://ostechnix.com/parse-arguments-in-bash-scripts-using-getopts/)

## Part 3 - Retrospective

1. How would you explain `getopts` to a friend?
2. What did you get stuck on while working on this script?  How did you overcome it?
3. What feature would you add to this script?

## Part 4 - Usage Guide

Fill out the Usage Guide section in your lab template.  It should contain a minimum of the following:
1. Information on your script's purpose 
2. Information on what is in `.bash_aliases`
2. Examples of script usage and output

**Resources**
- [GitHub markdown cheat sheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

Examples of bad README / Usage Guides:
- [bash wordle](https://gist.github.com/huytd/6a1a6a7b34a0d0abcac00b47e3d01513)
   - as discussed in class there was a hidden dependency of a word file, we needed to make it executable, and what if you didn't know how to play wordle?

Examples of good README / Usage Guides:
- [pokeget](https://github.com/talwat/pokeget)
   - this is far more thorough than what you are writing, but note here how much detail is included.

## Extra Credit - Improvements

Add a feature to the `dotinstall` script.  Ideas:
- If there is more than one alias name that could be deleted, output the options to the user - ask them to be more specific and exit or prompt the user to pick one in the moment
- Test the alias before adding it to `.bash_aliases`.  If its use doesn't error, then add it.  If it does, output the error to the user and exit so that they can fix it before they run the script again or prompt them to provide an alternative
- If an alias or command already exists with the same name as the desired alias, prompt the user that the given alias already exists and exit.

Add notes to your documentation about your added feature and show examples of it in action.

## Submission

1. Verify that your GitHub repo has a `Lab06` folder with at minimum:

   - `README.md`
   - `dotinstall`
   - `.bash_aliases`

2. In the Pilot Dropbox, paste the URL to the `Lab06` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab06

## Rubric

- Required files exist in `Lab06` folder - 3 pts
- `.bash_aliases` contains minimum of two functional aliases - 1 pt
- `dotinstall` script:
   - **minimum of 3 commits on with incremental building not met** - (-4) points
   - `getopts` checks for `-h`, `-s`, `-d`, `-a`, `-r` and exits after printing help if option is not allowed - 2 pts
   - `-h` flag calls `printHelp` function print help guide - 1 pt
   - `-s` flag calls function to generate symbolic link - 1 pt
   - user is prompted for what to do if `.bash_aliases` exists & program performs request - 1 pt
   - `-d` flag calls function to remove symbolic link - 1 pt
   - `-a` flag calls function to add user's alias to `.bash_aliases` - 1 pt
   - `-r` flag calls function to remove alias specified by user - 1 pt
- `README.md`:
   - contains `.bashrc` section relevant to `.bash_aliases` - 1 pt
   - description of what this section does - 1 pt
   - Retrospective answers - 1 pt each / 3 pts total
   - `dotfiles` Usage Guide contains 
      - description of `dotinstall` script - 1 pt
      - description of `.bash_aliases` script - 1 pt
      - **truthful** demonstrations of `dotinstall` script based on parts implemented - 1 pt
      - good use of markdown formatting - 1 pt

## `getopts` and error handling

I don't not require any error handling outside of the sample program runs provided. However...

If you are reading this, you may have noted that `getopts` still doesn't solve all user abuse cases by default.

For example, `getopts` can have a hard time "detecting" a missing argument after an option. `bash namechanger -r -f​` would not "count" as `-r` missing an argument, because `OPTARG` would read `-f` as the argument for `-r`. Fun right?

There are many ways to detangle this problem, some using `getopts`. You could play some quick games before running `getopts`, such as checking number of arguments passed... It isn't failsafe, but it would help.

So let's use what we have - stored values in variables. And we have an ability to check if those values contain anything... catch my drift? Check out the second answer in this post: https://unix.stackexchange.com/questions/50563/how-can-i-detect-that-no-options-were-passed-with-getopts

There are games you can play within the case statement to do this check, but it's a little clunky. If you're curious: https://stackoverflow.com/questions/43425556/getopts-behaves-not-as-expected-when-option-parameter-is-missing
