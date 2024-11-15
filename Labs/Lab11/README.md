# Lab 11

- [Lab Procedure](#lab-procedure)
- [Part 1 - tar it up](#part-1---tar-it-up)
- [Part 2 - SFTP](#part-2---sftp)
- [Part 3 - SSH Keys](#part-3---ssh-keys)
- [Submission](#submission)
- [Rubric](#rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/68834/modules/items/6128516)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

**Create a new directory, `Lab11`**

Write answers in `Lab11.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab11/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - tar it up
With the semester wrapping up, it's time to prepare to lose access to your instances.  Identify folders of work on your AWS instance you would like to save.  If you have none, use the folder that contains your local copy of your GitHub repository.  While using GitHub to save work is an option, it is just as common to need to compress and transfer information.  It is not required, but is interesting to look the the size of these folders pre and post compression

Do the following on your AWS instance.  

1. For the `tar` command, write what each option below does:
   - `-c`
   - `-v`
   - `-f`
   - `-z`
   - `-x`
2. `tar` and compress folders of your choice. Write the command you used. You will not be committing this to GitHub - it does not need to be in your repository folder and may in fact be too large to push to GitHub.

- **Resources**
- [cyberciti - tar on the command line](https://www.cyberciti.biz/faq/how-to-tar-a-file-in-linux-using-command-line/)
- [tecmint - tar command examples](https://www.tecmint.com/18-tar-command-examples-in-linux/)
- [Linux for Devices - Understanding the tar Command in Linux](https://www.linuxfordevices.com/tutorials/linux/tar-command-in-linux)

## Part 2 - SFTP

For this part, start on your local system, likely in WSL2.  

1. Connect to your AWS instance via `sftp`.
2. Describe what the following options do:
   - `ls`
   - `lls`
   - `put`
   - `get`
3. Retrieve the `tar` and compressed file (`.tar.gz`) from your AWS instance and download it to your local system
4. Decompress & extract the file (`.tar.gz`) to a folder on your system (you can remove it after you get the command right, I'm not a space hog)

- **Resources**
- [DigitalOcean - how to use sftp](https://www.digitalocean.com/community/tutorials/how-to-use-sftp-to-securely-transfer-files-with-a-remote-server)

## Part 3 - Extract & Profit

For this part, you will be installing an open source web server to your AWS instance, extracting a compressed archive containing a static website, and testing that it works!

Do the following on your AWS instance.

1. Install `apache2` or `nginx` with `apt`
2. Confirm that your chosen web serving service is running.
3. Download [`simple-site.tar.gz`](simple-site.tar.gz) to your AWs instance.
4. Change the permissions for the folder `/var/www/html` so that your user is the owner and primary group, your user (and members of your group) can read and write, and others can only read.
5. Extract the compressed archive to `/var/www/html`
6. Edit the `index.html` file in `/var/www/html` with:
   - your name where `YOUR LAST NAME HERE` is.  Make this `div` visible
   - replace `Insert something fun here` with a fact about you
   ```html
   <section>
            <h2>CEG 2350 Lab 11</h2>
            <div style="display:none">YOUR NAME HERE</div>
            <h3>Facts about me</h3>
            <p>Insert something fun here</p>
            
   </section>
   ```
7. View your website & confirm the changes requested were made (and visible!).  Take a screenshot with the URL bar included.

## Part 4 - `ssh` keys

Without practice, `ssh` connections and authentication just seem like magic. Really, it is all about files and information being in the right spot as defined in rules in configuration files. The goal of this part is to practice where keys go when you have a new `ssh` keypair. This is a common task to do when you gain access to a system - put your public key in the `authorized_keys` file in the `.ssh` folder of your remote account, then connect from your system to the remote system's account.

When you see a reference to **local system**, Windows users should assume I am referring to using WSL2

- **Useful commands: `adduser`, `getent passwd <username>`, `ssh-keygen`, `vim`, `ssh`**

1. On your local system, make a new key pair - with a non-default name.  Change at minimum the default name
2. On your AWS instance, create a user & user home directory or use the user from old labs
3. Put the public key of the key pair you created in the user's `~/.ssh/authorized_keys` file on the AWS instance
4. From your local system, `ssh` in to the AWS instance using the user's username and the private key of the keypair you created.
   - Format of `ssh` without an entry in the `config` file: `ssh -i path/to/privatekey username@hostname_or_ip`
5. Write an entry in your local system's `~/.ssh/config` file with the new connection information.
6. Write the `ssh` command that will use your `config` file information if correctly entered.

- **Resources**
- I do this manually, but there are some neat command shortcuts to explore
- [DigitalOcean - How to Configure SSH Key Based Authentication](https://www.digitalocean.com/community/tutorials/how-to-configure-ssh-key-based-authentication-on-a-linux-server)

## Submission

1. Verify that your GitHub repo has a `BonusLab` folder with at minimum:

   - `BonusLab.md`

2. In the Pilot Dropbox, paste the URL to the `BonusLab` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/BonusLab

## Rubric

- Part 1 - 2 pts (1 pt each)
- Part 2 - 4 pts (1 pt each)
- Part 3 - 6 pts (1 pt each)