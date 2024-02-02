# Lab 04

- [Lab Procedure](#Lab-Procedure)
- [regex resources](#regex-resources)
- [Part 1 - validator](#Part-1---validator)
- [Part 2 - sed](#Part-2---sed)
- [Part 3 - awk](#Part-3---awk)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/68834/modules/items/6128516)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab04`

This lab will have you creating input files, scripts, and output files.

Some questions will need you to write answers in `Lab04.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab04/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## regex resources

These are useful resources for remembering regex syntax and testing your expressions against smaller cases.

- [Mozilla - regex cheatsheet](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_Expressions/Cheatsheet)
- [regexone - practice regex patterns](https://regexone.com/)
- [regex101 - test regex patterns](https://regex101.com/)
- [rubular - test regex patterns](https://rubular.com/)

## Part 1 - validator

Your task is to write a bash script that cleans a file full of emails.  The email validation script should, given an input file, output to a final file unique and valid emails.

`grep` is a handy command to find patterns in text. There are two flags that enable enhanced regular expressions: `-E` and `-P`. `-E` handles most things, but does not work with special regex letter the represent ranges -`\w` and `\d` for example. To use these characters for the ranges they represent, use the `-P` flag instead of the `-E` flag.

```
grep [OPTIONS] PATTERN [FILE...]
```

The list of email to use in this exercise is [here](data/emails.txt).
   - [Raw version of emails.txt](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab04/data/emails.txt)

To complete the overall task, perform the steps listed below.  **After each step is complete and tested**, create a `commit` with your changes.  `push` `commit`s as you wish, just remember the `push` saves all the `commit`s to the mighty GitHub cloud.  **Your `commit` message must include which task you completed.**

If you don't make it through all of a step or don't complete all steps, leave heavy comments for partial credit considerations.

1. Create a bash script named `validator`.  The script should take a file name as input.  If the file does not exist, have script print an error message and exit.  If the file does exist, have script sort the content & remove duplicate entries. Output unique entries to a file named `clean1.txt`
2. Add to script to use content of `clean1.txt` and **match** only entries that start with a combination of letters (case-insensitive) or digits.  Output only valid matches to `clean2.txt`
3. Add to script to use content of `clean2.txt` and **remove matching** entries that contain consecutive (2 or more in a row) non-alphanumeric characters, such as dots (.), underscores (_), and hyphens (-).  Output only matches that do not contain consecutive non-alphanumeric characters to `clean3.txt`
4. Add to script to use content of `clean3.txt` and **match** entries that end in a valid domain name.  A domain name is after the @ sign and must consist of letters (case-insensitive) or digits, followed by a dot (.), and end with a top-level domain (TLD) of `com` OR `org`OR `net`.  Output only valid matches to `clean4.txt`

`emails.txt` has 104 emails listed.  After getting unique entries & applying the pattern filters, `clean4.txt` contained 19 emails that met the valid rules.

**Resources**
- [linuxize - use grep to search patterns](https://linuxize.com/post/how-to-use-grep-command-to-search-files-in-linux/)
- [RedHat - Beginners Guide to regular expressions with grep](https://developers.redhat.com/articles/2022/09/14/beginners-guide-regular-expressions-grep#)

## Part 2 - sed

`sed` is mostly commonly used as a search and replace command. In [sedfile.html](data/sedfile.html) you'll find a simple html file. Your task is to change it into markdown. Do this only using `sed` commands. Your converted file should be named `sedfile.md`.
   - [Raw version of sedfile.html](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab04/data/sedfile.html)

The following picture shows how `sedfile.html` (the original) looks compared to `sedfile.md` when the files are viewed in GitHub.

![sed Before and After](data/sed-before-after.PNG)

I recommend making a copy of `sedfile.html` and naming it `sedfile.md`. Then use `sed` without modifying the file - once you know your replacement patterns work, then save the changes using `sed`'s `-i` flag.

```
sed -i 's/SEARCH_REGEX/REPLACEMENT/g' INPUTFILE
# -i option tells sed to edit files in place. If an extension is supplied (ex -i.bak), a
# backup of the original file is created otherwise the changes are written back to INPUTFILE
```

Only write the command that performs the required task. DO NOT paste the results.

1. Remove all html end tags - anything with `</stuff>`
   - `stuff` here represents anything surrounded by the HTML close tag: `</ > `
2. Replace all `<li>` tags and the whitespace before the tag with the markdown format for a bullet point: `- `
   - Note that is a dash followed by a single space
3. Replace `<h1>` tags with markdown for header tags: `# `
   - Note that is a hashtag followed by a single space
4. Replace `<h2>` tags with markdown for header tags: `## `
   - Note that is TWO hashtags followed by a single space
5. Remove the `<ul>` tags & remove the `<html>` tag
6. Replace the word `Batches` with the word `Matches`

- **Resources**
- [linuxize - use sed to find and replace](https://linuxize.com/post/how-to-use-sed-to-find-and-replace-string-in-files/)

## Part 3 - awk

`awk` is a full blown scripting language dedicated to text manipulation. Create a file in your `Lab04` folder named `records.txt`. Copy the contents of [records.txt](data/records.txt) to a file, and do the following tasks using `awk`
   - [Raw version of records.txt](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab04/data/records.txt)

`records.txt` contains the following fields:

```
first last email fav_number university password
```

Only write the command that performs the required task. DO NOT paste the results.

1. Print only first names that start with `Bil`
2. Print only the email addresses of records whose favorite number is 42
3. For users who have a `wright.edu` email, print only their last name, first name, and email in the following format:
   - `Last, First: Email`
4. For users who have a `wright.edu` email AND have a password of `1234`, print only their last name and favorite number in the following format:
   - `Last favorite number is: #`
5. Replace all passwords with `N0T@PL@!NP@$$W0RD`. Write all fixed records to `updaterecords.txt`

- **Resources**
- [linuxize - awk with examples](https://linuxize.com/post/awk-command/)
- [cyberbiz - awk find and replace](https://www.cyberciti.biz/faq/awk-find-and-replace-fields-values/)

## Extra Credit - validator 2.0

1. Use the Internet to find a regular expression that validates emails based on [the rules of valid email formatting](https://help.xmatters.com/ondemand/trial/valid_email_format.htm).  Provide the source.  Write the regular expression.
2. Explain what the regular expression does.
3. Create a bash script, `validator2` that uses the regular expression to simplify the step by step data cleansing.

## Submission

1. Verify that your GitHub repo has a `Lab04` folder with at minimum:

   - `validator`
   - `clean1.txt` through `clean4.txt`
   - `sedfile.html`
   - `sedfile.md`
   - `records.txt`
   - `updaterecords.txt`
   - `Lab04.md`

2. Note that if your command answers in the answer template did not make use of the backtick (`), the TAs are allowed to refuse to grade your submission.  Cleanliness and readability is your responsibility.  

3. In the Pilot Dropbox, paste the URL to the `Lab04` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab04

## Rubric

- Part 1 - 1 pt per task (4 pts total)
- Part 2 - 1 pt per `sed` command (6 pts total)
- Part 3 - 1 pt per `awk` command (5 pts total)
- Extra Credit - 1.5 pts if complete - no partial points
