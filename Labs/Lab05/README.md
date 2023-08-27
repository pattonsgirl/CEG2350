# Lab 05 - NOT FINALIZED

- [Lab Procedure](#Lab-Procedure)
- [Name Change Script](#Name-Change-Script)
- [Extra Credit - Bulk Renamer](#Extra-Credit---Bulk-Renamer)
- [Submission](#Submission)
- [Rubric](#Rubric)
- [Additional getopts Resources](#Additional-getopts-Resources)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/36184/modules/items/3080473)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab05`

This lab may have you creating input files, scripts, and output files. All of your work should be found here.

Some questions will need you to write answers in `README.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab05/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Name Change Script

The following will ask you to write a script that changes a file's name.  The script will allow the user to provide the search pattern to replace, and the replacement for the found pattern.  A sample of using the script, where `namechange` is the name of the script file:

```
namechange -f find -r replace filename
```

1. Create a script in your `Lab05` folder named `namechange`. 
2. Create some files in your folder with common errors (spaces in the filename, a misspelling, etc.).  Sample errors:
   - `.jpg` is misspelled as `.jgp`
   - spaces in file names that could be replaced with `-`
   - files with `foo` in them need to become `bar`

**Implement the following features in the `namechange` script:**

1. Use `getopts` to read in options and do actions based on arguments. `getopts` should support the following options in the `OPTSTRING`

   - `-h`
     - call `printHelp` function and exit script
   - `-f`
     - option followed by argument specifying pattern to find in the filename
   - `-r`
     - option followed by argument specifying what to replace the found pattern with in the filename
   - `\?`
     - use as case when option is not part of `OPTSTRING`
     - call `printHelp` and exit script
   - there are `getopts` demos linked in resources, as well as in this folder
     - [getopts-basics.sh](getopts-basics.sh)
     - [cfgetopts.sh](cfgetopts.sh)

2. Create a function called `printHelp`. `printHelp` should output the following:

```
Usage: namechange -f find -r replace "string to modify"
 -f The text to find in the filename
 -r The replacement text for the new filename
```

3. If no `filename` was provided OR if `filename` does not exist:
   - Output `User must provide valid filename`
   - Call the `printHelp` function
4. Using argument in field `filename`, find the pattern to be replaced and replace it with the pattern requested using `sed`
   - Hint: you may just want to have `sed` use the `-E` option
5. Rename the file.

```
# Sample runs of working script

$ bash namechange -h
Usage: namechange -f find -r replace filename
 -f The text to find in the filename
 -r The replacement text for the new filename

$ bash namechange -f "\s" -r "-" "hello world.md"
Renamed "hello world.md" to hello-world.md

$ bash namechange -f "er+" -r "error" spellingerrrr.txt
Renamed spellingerrrr.txt to spellingerror.txt
```

**Document your `namechange` script**

1. Create a Usage Guide in a file named `README.md` in your `Lab05` folder
   - Information on how users should use your script
   - Examples of script usage and output
   - Use good markdown so that this documentation is pretty and clean on GitHub.

**Resources**
- [bash-hackers - `getopts` tutorial](https://wiki.bash-hackers.org/howto/getopts_tutorial)
- [assertnotmagic - breaking down how getopts works](https://www.assertnotmagic.com/2019/03/08/bash-advanced-arguments/)
- [`sed` with string, not input file](https://stackoverflow.com/questions/13055889/sed-with-literal-string-not-input-file)
- [cyberciti - using Logical NOT in if statements](https://bash.cyberciti.biz/guide/Logical_Not_!)
- [linuxize - functions](https://linuxize.com/post/bash-functions/)
- [GitHub markdown cheat sheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

## Extra Credit - Bulk Renamer

This builds on the script created for Part 1. Since the core is similar, I would `cp` this to a new script named `bulkrenamer`.

1. Download and run one of the create files scripts to generate some dummy files for this part.
   - [createfiles.sh](createfiles.sh) will just create 30 files in the directory you run it from (10 of each error type below)
   - [cfargs.sh](cfargs.sh) will let you create a number of files with the error type of your choice (spaces or spelling) in the directory you specify
   - [cfgetopts.sh](cfgetopts.sh) will let you do the same as `cfargs.sh`, but with options
   - Errors in these file names that can be corrected with a script:
     - `jpg` is misspelled as `jgp`
     - spaces in file names that could be replaced with `-`
     - files with `foo` in them need to become `bar`
2. The script will run as: `bulkrenamer -f find -r replace FILES_TO_RENAME*`
3. For each file given (or all files in a given folder), rename according to the find / replace arguments provided.

**Resources**
- [linuxize - for loops](https://linuxize.com/post/bash-for-loop/)

## Submission

1. Verify that your GitHub repo has a `Lab05` folder with at minimum:

   - `README.md` (`namechage` Usage Guide)
   - `namechange` (script)
   - `bulkrenamer` - for extra credit
   - Usage Guide for `bulkrenamer` - for extra credit

2. In the Pilot Dropbox, paste the URL to the `Lab05` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab05

## Rubric

- `namechange` Usage Guide in `README.md` contains clear explanation - 1pt
- `namechange` exists in repo - 1pt
- `getopts` checks for `-h`, `-r`, `-f` and exits if option is not allowed - 2pts
- `case` statements for `-r` and `-f` save argument values after option - 1pt
- `printHelp` function called to print help guide - 1pt
- if `filename` not given, calls `printHelp` and exits - 1pt
- if `filename` does not exist, calls `printHelp` and exits - 1pt
- `filename` is modified according to find / replace arguments - 1pt
- `filename` given is renamed according to find / replace arguments - 1pt
- Extra Credit - 20% - 2pts

## Additional getopts Resources

- [ostechnix - breaking down how getopts works](https://ostechnix.com/parse-arguments-in-bash-scripts-using-getopts/)
- [shellscript - `getopts` tutorial](https://www.shellscript.sh/tips/getopts/)

### getopts and error handling

I don't not require any error handling outside of the sample program runs provided. However...

If you are reading this, you may have noted that `getopts` still doesn't solve all user abuse cases by default.

For example, `getopts` can have a hard time "detecting" a missing argument after an option. `bash namechanger -r -f​` would not "count" as `-r` missing an argument, because `OPTARG` would read `-f` as the argument for `-r`. Fun right?

There are many ways to detangle this problem, some using `getopts`. You could play some quick games before running `getopts`, such as checking number of arguments passed... It isn't failsafe, but it would help.

So let's use what we have - stored values in variables. And we have an ability to check if those values contain anything... catch my drift? Check out the second answer in this post: https://unix.stackexchange.com/questions/50563/how-can-i-detect-that-no-options-were-passed-with-getopts

There are games you can play within the case statement to do this check, but it's a little clunky. If you're curious: https://stackoverflow.com/questions/43425556/getopts-behaves-not-as-expected-when-option-parameter-is-missing
