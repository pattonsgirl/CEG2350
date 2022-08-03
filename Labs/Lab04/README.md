# Lab 04

- [Lab Procedure](#Lab-Procedure)
- [regex resources](#regex-resources)
- [Part 1 - grep](#Part-1---grep)
- [Part 2 - sed](#Part-2---sed)
- [Part 3 - awk](#Part-3---awk)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/13249/modules/items/1136419)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab04`

This lab will have you creating input files, scripts, and output files. All of your work should be found here.

Some questions will need you to write anwers in `Lab04.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab04/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## regex resources

- [Mozilla - regex cheatsheet](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_Expressions/Cheatsheet)
- [regexone - practice regex patterns](https://regexone.com/)
- [regex101 - test regex patterns](https://regex101.com/)
- [rubular - test regex patterns](https://rubular.com/)

## Part 1 - grep

`grep` is a handy command to find patterns in text. `egrep` is `grep`, but allows for extended regex patterns. If a regex search with `grep` is misbehaving, you may need to use `grep -e` or `egrep`, OR enable POSIX regex using the `-P` option

```
grep [OPTIONS] PATTERN [FILE...]
```

Create a file named `grepdata.txt` in your `Lab04` folder. Put the contents of [grepdata.txt](grepdata.txt) in the file. Use `grep` or `egrep` to complete the searches below. Only write the command that makes the required match. DO NOT paste the results.

1. Print all lines that contain a phone number with an extension (the letter x or X followed by four digits).
   - Your answer must use the \{ and \} repetition specifier.
2. Print all lines that begin with three digits followed by a blank.
   - Your answer must use the \{ and \} repetition specifier.
3. Print all lines that contain a date after the year 2000.
4. Print all lines that contain CA in either uppercase or lowercase.
5. Print all lines that contain an email address (they have an @ in them), preceded by the line number (as in which line the match occured on).

- **Resources**
- [linuxize - use grep to search patterns](https://linuxize.com/post/how-to-use-grep-command-to-search-files-in-linux/)

## Part 2 - sed

`sed` is mostly commonly used as a search and replace command. In [sedfile.html](sedfile.html) you'll find a simple html file. But we want to change it into markdown. Your task is to do this only using `sed` commands. Your fixed file should be named `sedfile.md`.

I recommend using `sed` without modifying the file at first - once you know your replacement patterns work, then edit the file.

Only write the command that performs the required task. DO NOT paste the results.

1. Remove all html end tags - anything with `</stuff>`
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

`awk` is a full blown scripting language dedicated to text manipulation. Create a file in your `Lab04` folder named `records.txt`. Put the contents of [records.txt](records.txt) in your file, and do the following tasks using `awk`

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
5. Replace emails from domain `space.edu` with `universe.edu`. Write all records to `update1.txt`
6. Replace all passwords with `N0T@PL@!NP@$$W0RD`. Write all records to `update2.txt`

- **Resources**
- [linuxize - awk with examples](https://linuxize.com/post/awk-command/)
- [cyberbiz - awk find and replace](https://www.cyberciti.biz/faq/awk-find-and-replace-fields-values/)

## Submission

1. Verify that your GitHub repo has a `Lab04` folder with at minimum:

   - `grepdata.txt`
   - `sedfile.html`
   - `sedfile.md`
   - `records.txt`
   - `update1.txt`
   - `update2.txt`
   - `Lab04.md`

2. In the Pilot Dropbox, paste the URL to the `Lab04` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab04

## Rubric

- Part 1 - 1 pt per question
- Part 2 - 1 pt per question
- Part 3 - 1 pt per question

## Credit

- grep exercises: http://evc-cit.info/cit052/grep1.html
