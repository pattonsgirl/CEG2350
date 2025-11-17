# Lab 11 - tar, sftp, and ssh

- [Lab Procedure](#lab-procedure)
- [Part 1 - tar it up](#part-1---tar-it-up)
- [Part 2 - SFTP](#part-2---sftp)
- [Part 3 - Extract & Profit](#part-3---extract--profit)
- [Part 4 - SSH Keys](#part-4---ssh-keys)
- [Submission](#submission)
- [Rubric](#rubric)

## Lab Procedure

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab11`.

Create a file named `README.md` in the `Lab11` folder.  The [Lab 11 Template can be copied from this link](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab11/LabTemplate.md):

- `https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab11/LabTemplate.md`

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

## Part 0 - branch control

Determine and **create** one or more GitHub Issues for this lab.

Determine and **create** one or more `branch`es to resolve the Issues for this lab.

In the end, your lab submission (`README.md`) should be visible on the `main` branch.

## Part 1 - tar it up

With the semester wrapping up, it's time to prepare to lose access to your instances.  Identify folders of work on your AWS instance you would like to save.  If you have none, use the folder that contains your local copy of your GitHub repository.  While using GitHub to save work is an option, it is just as common to need to compress and transfer information.  It is not required, but is interesting to look the the size of these folders pre and post compression

Do the following on your AWS instance.  

**Useful commands: `tar`, `gzip`, `file`**

1. For the `tar` command, fill in the table describing the most frequently used flags:

| tar Option | Description      |
|--------|------------------------|
| `-c`   |                        |
| `-v`   |                        |
| `-f`   |                        |
| `-z`   |                        |
| `-x`   |                        |
| `-t`   |                        |

2. `tar` and compress folders of your choice using `gzip` compression. Write the command you used. 

**Do NOT add and commit your `tar` and compressed file to GitHub.** It does not need to be in your repository folder and may in fact be too large to push to GitHub.

3. Determine *at least* one method to confirm your `tar` and compressed file is a `tar` and compressed file. Just stating it has a `.tar.gz` extension will not be sufficient for credit.

**Resources**
- [tar on the command line - cyberciti](https://www.cyberciti.biz/faq/how-to-tar-a-file-in-linux-using-command-line/)
- [tar command examples - tecmint](https://www.tecmint.com/18-tar-command-examples-in-linux/)
- [Understanding the tar Command in Linux - Linux for Devices](https://www.linuxfordevices.com/tutorials/linux/tar-command-in-linux)

## Part 2 - SFTP

1. For the `sftp` command, fill in the table describing the most frequently used commands within the program:

| sftp Command | Description |
|---------|------------------------|
| `ls`    |                        |
| `lls`   |                        |
| `cd`    |                        |
| `lcd`   |                        |
| `pwd`   |                        |
| `lpwd`  |                        |
| `put`   |                        |
| `get`   |                        |
| `exit` / `bye` |                 |

Confirm you are on your local system using the terminal you normally use to `ssh` to your instance. *Do not `ssh` to your instance*

2. Connect to your AWS instance via `sftp`.
3. Retrieve the `tar` and compressed file (ending with `.tar.gz`) from your AWS instance and download it to your local system
4. Decompress & extract the file (`.tar.gz`) to a folder on your system 
   - You can remove it after you get the command right, I'm not a space hog

**Resources**
- [DigitalOcean - how to use sftp](https://www.digitalocean.com/community/tutorials/how-to-use-sftp-to-securely-transfer-files-with-a-remote-server)

## Part 3 - Extract & Profit

For this part, you will be installing an open source web server to your AWS instance, extracting a compressed archive containing a static website, and testing that it works!

Do the following on your AWS instance.

- **Useful commands: `apt`, `systemctl`, `wget`, `chown`, `chmod`, `tar`, `vim`, `curl`**

1. Install `apache2` or `nginx` with `apt`
2. Confirm that your chosen web serving service is running
3. Download [`simple-site.tar.gz`](https://github.com/pattonsgirl/CEG2350/blob/main/Labs/Lab11/simple-site.tar.gz) to your AWS instance
   - [URL to download .tar.gz file](https://github.com/pattonsgirl/CEG2350/raw/refs/heads/main/Labs/Lab11/simple-site.tar.gz)
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

When you use `ssh`, you specify a `hostname` after the `@` sign. Typically a `hostname` is a pretty name the associates with the IP address of the server. We do not have a pretty name set up for your AWS instances, so the only way to address them is by their public IP address (as you've been doing all semester).

7. Open a browser on your local system (can't do it in AWS &#128540;). Type your AWS instance's public IP into the URL bar. If your page shows, take a screenshot with the URL bar included.
   - **Note**: you may need to explicitly type `http://` in front of your AWS instance's public IP. We'll talk about it later.

**Resources**
- [Digital Ocean - Apache vs Nginx: Practical Considerations](https://www.digitalocean.com/community/tutorials/apache-vs-nginx-practical-considerations)

## Part 4 - `ssh` keys

Without practice, `ssh` connections and authentication just seem like magic. Really, it is all about files and information being in the right spot as defined in rules in configuration files. The goal of this part is to practice where keys go when you have a new `ssh` keypair. This is a common task to do when you gain access to a system - put your public key in the `authorized_keys` file in the `.ssh` folder of your remote account, then connect from your system to the remote system's account.

When you see a reference to **local system**, this means your system - *not your AWS instance*

- **Useful commands: `adduser`, `getent passwd <username>`, `ssh-keygen`, `vim`, `ssh`**

1. Fill in the following table of commonly configured `ssh` files:

| ssh File Path / Name          | Purpose            |
|---------------------------------|--------------------|
| `~/.ssh/config`                 |                    |
| `~/.ssh/id_rsa`                 |                    |
| `~/.ssh/id_rsa.pub`             |                    |
| `~/.ssh/id_ed25519`             |                    |
| `~/.ssh/id_ed25519.pub`         |                    |
| `~/.ssh/authorized_keys`        |                    |
| `~/.ssh/known_hosts`            |                    |

2. Fill in the following table of options commonly used in a `config` file for `ssh`:

| ssh config Option   | Description  |
|---------------|------------------------|
| `Host`        |                        |
| `HostName`    |                        |
| `User`        |                        |
| `Port`        |                        |
| `IdentityFile`|                        |

3. On your local system, make a new key pair - with a non-default name.  Change at minimum the default name
4. On your AWS instance, create a user & user home directory or use the your `firstinitiallastname` account
5. Put the public key of the key pair you created in the AWS instnace user's `~/.ssh/authorized_keys` file on the AWS instance
6. From your local system, `ssh` in to the AWS instance using the user's username and the private key of the keypair you created.
   - Format reminder: `ssh -i path/to/privatekey username@hostname_or_ip`
7. Write an entry in your local system's `~/.ssh/config` file with the new connection information.
8. Write the `ssh` command that will use your `config` file information if correctly entered.

**Resources**
- [Linuxize - Using the SSH Config File](https://linuxize.com/post/using-the-ssh-config-file/)
- [DigitalOcean - How to Configure SSH Key Based Authentication](https://www.digitalocean.com/community/tutorials/how-to-configure-ssh-key-based-authentication-on-a-linux-server)

## Submission

1. Verify that your GitHub repo has a `Lab11` folder with at minimum:

   - `README.md`

2. In the Pilot Dropbox, paste the URL to the `Lab11` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab11

## Rubric

Your files should be cleanly presented in your GitHub repository.  Citations should be included as needed.  Include which generative AI system was used and what prompts were used if generative AI was used.

[Rubric](https://raw.githubusercontent.com/pattonsgirl/CEG2350/refs/heads/main/docs/Labs/Lab11/Rubric.md)
