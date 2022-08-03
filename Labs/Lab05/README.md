# Lab 05

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Name Change](#Part-1---Name-Change)
- [Part 2 - Self Discovery](#Part-2---Self-Discovery)
- [Extra Credit - Bulk Renamer](#Extra-Credit---Bulk-Renamer)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/13249/modules/items/1136419)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab05`

This lab may have you creating input files, scripts, and output files. All of your work should be found here.

Some questions will need you to write anwers in `Lab05.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab05/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - Name Change

1. Create a script in your `Lab05` folder named `namechange` that meets the following specifications. The script will run as: `namechange -f find -r replace string-to-modify`
2. Use `getopts` to utilize both arguments and functions.

   - `-r` = what to replace in the filename string. Should have an argument after, save to a variable
   - `-f` = what to find in the filename string. Should have an argument after, save to a variable
   - `-h` = printHelp, a function that has a help guide

3. Create a function called `printHelp`. `printHelp` should output the following:

```
Usage: namechange -f find -r replace "string to modify"
 -f The text to find in the filename
 -r The replacement text for the new filename
```

4. If `-r` or `-f` have empty (no) arguments after them, output "User must provide string for find and string for replace" following by the usage guide in the `printHelp` function
   - `getopts` has built in ways to handle this checking
5. For the string given, `string-to-modify`, find the pattern to be replaced and replace it with the pattern requested using `sed` - you may just want to have `sed` use the `-E` option ;)

```
# Sample runs of working script

$ bash namechange -h
Usage: namechange -f find -r replace "string to modify"
 -f The text to find in the filename
 -r The replacement text for the new filename

$ bash namechange -f "\s" -r "-" "hello world"
hello-world

$ bash namechange -f "er+" -r "error" "spellingerrrr"
spellingerror
```

- **Resources**
- [bash-hackers - `getopts` tutorial](https://wiki.bash-hackers.org/howto/getopts_tutorial)
- [ostechnix - breaking down how getopts works](https://ostechnix.com/parse-arguments-in-bash-scripts-using-getopts/)
- [assertnotmagic - breaking down how getopts works](https://www.assertnotmagic.com/2019/03/08/bash-advanced-arguments/)
  - [shellscript - `getopts` tutorial](https://www.shellscript.sh/tips/getopts/)
- [`sed` with string, not input file](https://stackoverflow.com/questions/13055889/sed-with-literal-string-not-input-file)
- [linuxize - functions](https://linuxize.com/post/bash-functions/)
- [linuxize - for loops](https://linuxize.com/post/bash-for-loop/)
- Checking for multiple arguments:
  - getopts : case can only check for a one argument missing case. bash namechanger -r -f​ would not "count" as it would read -f as the next OPTARG and count it as the "argument". Fun right?
  - So let's use what we have - stored values in variables. And we have an ability to check if those values contain anything... catch my drift? Check out the second answer in this post: https://unix.stackexchange.com/questions/50563/how-can-i-detect-that-no-options-were-passed-with-getopts
  - There are games you can play within the case statement to do this check, but it's a little clunky. If you're curious: https://stackoverflow.com/questions/43425556/getopts-behaves-not-as-expected-when-option-parameter-is-missing

## Part 2 - Self Discovery

Find out the following information about your personal system. Write the answers to the information requested. Part of this is learning about your system, so some info will not be findable. Provide confirmation of your findings where possible.

For example, my laptop does not have a dedicated gpu card. I can run commands whose output will confirm there is no GPU

- You can use the manufactuers website / manuals
- Windows users, I recommend `msinfo`
- You should _not_ need to install additional programs to find this information. If someone tells you to install something, run away.

1. CPU brand, number of cores, and number of logical cores
2. Physical memory size (translate to GB)
3. Virtual memory size (translate to GB)
   - Does your system have a pagefile, and if so where is it?
4. Disk type / model
5. Disk size (translate to GB)
6. Remaining disk space (translate to GB)
7. File system used on primary partition
   - C partition for Windows users
   - / partition for Linux / Mac(?) users
8. BIOS mode / version
9. Note whether or not your BIOS / UEFI is accessible, and what steps should let you access it.

## Extra Credit - Bulk Renamer

This build on the script created for Part 1. Since the core is similar, I would `cp` this to a new script named `bulkrenamer`.

1. Download and run [this script](createfiles.sh). It will generate some dummy files for this part.
   - Errors in these file names that can be corrected with a script:
     - `jpg` is mispelled as `jgp`
     - spaces in file names that could be replaced with `-`
     - files with `foo` in them need to become `bar`
2. The script will run as: `bulkrenamer -f find -r replace FILES_TO_RENAME*`
3. For each file given (or all files in a given folder), create a new filename using `sed` to replace the match in the filename string with the supplied replacement. Use `mv` to change the filename to the new filename. Include a useful output statement to see what changed.

```
# Hint:
for file in $@:
do
   echo $file
done
```

## Submission

1. Verify that your GitHub repo has a `Lab05` folder with at minimum:

   - `Lab05.md`
   - `namechange`
   - `bulkrenamer` - for extra credit

2. In the Pilot Dropbox, paste the URL to the `Lab05` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab05

## Rubric

- Part 1 - 6 pts total
  - `namechanger` exists in repo - 1pt
  - `getopts` checks for `-r`, `-f`, and `-?` - 1pt
  - check if arguments for options exist (using `getopts` or another method) - 1pt
  - `printHelp` function called to print help guide if - 1pt
    - `-?` is the option
    - bad usage (no args or bad option)
  - string given has pattern found and replaced as specified by arguments - 2pts
- Part 2 - 1 pt per question - 9 pts total
- Extra Credit - 20% - 3pts
