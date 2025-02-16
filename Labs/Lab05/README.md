# Lab 05 - regex with grep, sed, and awk

- [Lab Procedure](#Lab-Procedure)
- [regex resources](#regex-resources)
- [Part 1 - grep](#Part-1---grep)
- [Part 2 - sed](#Part-2---sed)
- [Part 3 - awk](#Part-3---awk)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab04`.

Create a file named `README.md` in the `Lab04` folder.  Copy into the file the contents of the [Lab 05 Template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab05/LabTemplate.md)

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

## Frequently Needed Resources

### regular expressions

These are useful resources for remembering regex syntax and testing your expressions against smaller cases.

- [Mozilla - regex cheatsheet](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_Expressions/Cheatsheet)
- [regexone - practice regex patterns](https://regexone.com/)
- [regex101 - test regex patterns](https://regex101.com/)

### downloading with wget

When downloading files from the internet by their URL, you'll want to make sure to get the raw file contents - not any additional page wrappers.  

`wget` is a command-line utility for downloading files from the web. With `wget`, you can download files using HTTP, HTTPS, and FTP protocols. `man` `wget` to see the options - we are only going to focus on the URL.

```
wget [options] [url]

```

View this page:  
https://github.com/pattonsgirl/CEG2350/blob/main/Labs/Lab05/data/tryme.txt

Now view this page (accessible by select `Raw` on the right side above the file contents):  
https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/Labs/Lab05/data/tryme.txt

Run the following two commands:
```
wget https://github.com/pattonsgirl/CEG2350/blob/main/Labs/Lab05/data/tryme.txt
wget https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/Labs/Lab05/data/tryme.txt
```
Use `cat` to view their contents.  The second will have only the text file.  The first comes with GitHub's page wrapper.  The second - or more importantly - the raw file contents - is what we want.

## Part 1 - grep

`grep` is a handy command to find patterns in text. There are two flags that enable enhanced regular expressions: `-E` and `-P`. `-E` handles most things, but does not work with special regex letter the represent ranges -`\w` and `\d` for example. To use these characters for the ranges they represent, use the `-P` flag instead of the `-E` flag.

```
grep [OPTIONS] PATTERN [FILE...]
```


**Resources**
- [linuxize - use grep to search patterns](https://linuxize.com/post/how-to-use-grep-command-to-search-files-in-linux/)
- [RedHat - Beginners Guide to regular expressions with grep](https://developers.redhat.com/articles/2022/09/14/beginners-guide-regular-expressions-grep#)

## Part 2 - sed

`sed` is mostly commonly used as a search and replace command. In [sedfile.html](data/sedfile.html) you'll find a simple html file. Your task is to change it into markdown using `sed` commands. Your converted file should be named `sedfile.md`.
   - [Raw version of sedfile.html](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab05/data/sedfile.html)

The following picture shows how `sedfile.html` (the original) looks compared to `sedfile.md` after being fixed to use markdown when the files are viewed in GitHub.

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

`awk` is a full blown scripting language dedicated to text manipulation. Create a file in your `Lab05` folder named `records.txt`. Copy the contents of [records.txt](data/records.txt) to a file, and do the following tasks using `awk`
   - [Raw version of records.txt](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab05/data/records.txt)

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

1. Verify that your GitHub repo has a `Lab05` folder with at minimum:

   - `validator`
   - `clean1.txt` through `clean4.txt`
   - `sedfile.html`
   - `sedfile.md`
   - `records.txt`
   - `updaterecords.txt`
   - `Lab05.md`

2. Note that if your command answers in the answer template did not make use of the backtick (`), the TAs are allowed to refuse to grade your submission.  Cleanliness and readability is your responsibility.  

3. In the Pilot Dropbox, paste the URL to the `Lab05` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab05

## Rubric

- Part 1 - 1 pt per task (4 pts total)
- Part 2 - 1 pt per `sed` command (6 pts total)
- Part 3 - 1 pt per `awk` command (5 pts total)
- Extra Credit - 1.5 pts if complete - no partial points
- Poor markdown formatting (-1.5 pt deduction)
