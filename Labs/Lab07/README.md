# Lab 07

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Virtualize the Machine](#Part-1---Virtualize-the-Machine)
- [Part 2 - Playground](#Part-2---Playground)
- [Hints - Screenshots and markdown](#Hints---Screenshots-and-markdown)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

The focus of this lab is creating a virtual machine - you are not required to utilize the AWS instance for this lab. You will be creating a `Lab07.md` file for your work in this lab, which will mostly be documentation and screenshots. To create and edit the file, you are welcome to use your AWS instance (or anywhere your repo is cloned) or edit the file directly in the browser.

In your repository (the folder named `ceg2350-yourgithubusername):

Create a new directory, `Lab07`

Create a file named `Lab07.md` [based on the template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab07/LabTemplate.md)

## Part 1 - Virtualize the Machine

We have been talking about the boot process, computer parts, and installing operating systems, but it's hard to give you a computer to build and feel this out - so how about a virtual one!

You will need a computer that has CPU virtualization enabled. The lab machines & open lab machines in Russ are all good candidates (and may have VirtualBox already installed). For your own machine, you may need to enable CPU virtualization in your BIOS.

---

- Windows, Linux, Mac users:
  - [Download and install VirtualBox](https://www.virtualbox.org/wiki/Downloads)
  - Pick your host OS when installing
    - For example, Windows users should select "Windows hosts")
---

1. Download an ISO (installation image) for a Linux distribution of your choice.  Options include: Ubuntu Desktop, LUbuntu, Linux Mint, Elementary, Kali, Pop OS, [and many more](https://distrowatch.com/)  
   - Document:
      - which Linux distribution you selected
      - the URL you downloaded it from 
   - Note: if your selection "isn't working" you should try Ubuntu and move on with life
2. Create a Virtual Machine.  
    - Select the checkbox for "Skip unattended installation"
    - Document the hardware resources you chose for it
    - Take a screenshot of the **Summary** of your configurations then select "Finish".  
3. Start your Virtual Machine and install the Guest Operating System
    - Document:
      - how to start the installation
      - what disk it is installing to
      - the size of the partition it is installing the OS to
      - filesystem to be used on the partition
4. Remove the installation media storage device from the Virtual Machine 
    - Document:
      - how you removed the installation media
      - how you verified the installation media was removed
5. Install Guest Additions on your Virtual Machine.  [Guest Additions enables useful features](https://www.makeuseof.com/tag/virtualbox-guest-additions-what-they-are-and-how-to-install-them/) but mostly fixes resolution headaches.
    - Document:
      - how to insert Guest Additions
      - how to run the Guest Additions installer for your Guest Operating System
        - Note: likely `VBoxLinuxAdditions.run`
      - how to change resolution of the VM
6. Control the Virtual Machine state
    - Document:
      - Turning on the VM:
      - Turning off the VM:
      - Restarting the VM:
7. In your VM, open a file and type your name.  Take a screenshot of your VM.

## Part 2 - Playground

Accomplish the following tasks using the Virtual Machine you made in Part 1.

1. How to change your desktop background in your VM:
2. How to install VSCode in your VM:
3. How to connect to your AWS instance from your VM using `ssh`:
  - Think way back to labs 1 & 2 - what did you need to `ssh` in to your AWS system from a terminal?

## Hints - Screenshots and markdown

There are a lot of ways to add screenshots to a markdown file. I'm going to tell you my way. I use my system to take a screenshot, and then I upload files in my repository in GitHub.

Remember when content exists in your repository folder on GitHub, but does not exist in your local folder (the one you usually `git push` from) you need to do a `git pull` to sync back up.

We are going to be uploading images directly to our repository in GitHub, then use `git pull` pull those changes (more specifically, pull the commits which include the changes) to our cloned repositories.

1. Take the screenshots required by part 1. Store them somewhere easy to access (like your Desktop).
2. Go to your GitHub classrooms repo in a browser: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME
3. Click the "Add files" button, then click "Upload files"
4. Upload your screenshots. Write commit messages in the browser text fields, then click "Commit Changes"
   - you should now see the images in your repository in GitHub
5. Head back to a terminal where you are working on your Lab 07 documentation
   - type `git pull`
   - you should see your file names appear in the change list
   - and you should now be able to `ls` and see them
6. In your lab template, you have a lines similar to: `![Screenshot of VM running](relative_path_to_filename_here)`
   - keep the parenthesis, but fill them with the relative path to your respective photos
   - this should be relative to being in your repo folder

## Submission

1. Verify that your GitHub repo has a `Lab07` folder with at minimum:

   - `Lab07.md`
   - an `images` folder (with your screenshots inside)

2. In the Pilot Dropbox, paste the URL to the `Lab07` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab07

## Rubric

- Part 1 - 1 pt per question - 7 pts total
- Part 2 - 1 pt per question - 3 pts total

## Troubleshooting

You should reach out on Discord if you are running into headaches.  Below is stuff we have needed to lean on in the past.  As updates happen, things smooth out.

- Mac M1 Users:
    - Parallels - Wright State offers a student discount on Parallels
      - [Get Parallels via the Hub](https://www.wright.edu/information-technology/software-purchases-for-personal-use)
    - [UTM](https://mac.getutm.app/) 
      - free if you click "Download". You can support the developers by paying through the App Store.
      - there are articles online, but we have some documentation from students.
- Windows 11 Users:
  - [Enable Hyper-V Manager](https://www.groovypost.com/howto/enable-virtualization-in-windows-11/)
- Chromebook Users:
  - Chromebooks do not support virtualization.  You may need to use one of the open labs (320 OH during lab time, or Russ 152 B or D) or be prepared to use a different system you have access to.