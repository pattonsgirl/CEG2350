# Lab 06

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Virtualize the Machine](#Part-1---Virtualize-the-Machine)
- [Part 2 - Playground](#Part-2---Playground)
- [Hints - Screenshots and markdown](#Hints---Screenshots-and-markdown)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

The focus of this lab is creating a virtual machine - you are not required to utilize the AWS instance for this lab. You will be creating a `Lab06.md` file for your work in this lab, which will mostly be documentation and screenshots. To create and edit the file, you are welcome to use your AWS instance (or anywhere your repo is cloned) or edit the file directly in the broswer.

In your repository (the folder named `ceg2350-yourgithubusername):

Create a new directory, `Lab06`

Create a file named `Lab06.md` [based on the template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab06/LabTemplate.md)

## Part 1 - Virtualize the Machine

We have been talking about the boot process, computer parts, and installing operating systems, but it's hard to give you a computer to build and feel this out - so how about a virtual one!

**Your deliverable is a full write up in `Lab06.md` of every step of creating a VM - from choosing the virtualized hardware to installing an OS.**

You will need a computer that has CPU virtualization enabled. The lab machines & open lab machines in Russ are all good candidates (and may have VirtualBox already installed). For your own machine, you may need to enable CPU virtualization in your BIOS.

- Windows, Linux, Mac users:
  - [Download and install VirtualBox](https://www.virtualbox.org/wiki/Downloads)
  - Pick your host OS when installing (for example, I would pick "Windows hosts")
- Mac M1 Users:
  - Install either:
    - Parallels - Wright State offers a student discount on Parallels
      - [Get Parallels via the Hub](https://www.wright.edu/information-technology/software-purchases-for-personal-use)
    - [UTM](https://mac.getutm.app/) - free if you click "Download". You can support the developers by paying through the App Store.
  - the instuctions below should apply generically, but if you are having trouble post in the general chat on Discord and we will help as we can
- Windows 11 Users:
  - Try to install VirtualBox, but it has had mixed support in Windows 11
  - [Enable Hyper-V Manager](https://www.groovypost.com/howto/enable-virtualization-in-windows-11/)  

**Do the following, and write down the steps used in `Lab06.md` Part 1 Answers.**

1. Create a Virtual Machine with the following minimum specifications:
   - Type: Linux
   - Version: Other Linux (64-bit)
   - 2 GB RAM
   - 10 GB disk space
2. Add a screenshot to your documentation of your virtualized hardware configuration
3. Download an iso (installation image) for a Linux distubution of your choice. State which Linux distrubition you picked
   - Ubuntu Desktop is a safe bet
   - Linux Mint, Elementary, Kali, Pop OS - or check distro watch
   - I will warn that if your selection "isn't working" you should try Ubuntu and move on with life
4. Start your machine and select your iso (installation image)
5. Go through the installation process for your chosen Linux distribution
   - For ease right now, I would select "Erase and install" - however that is phrased
   - Some OSes will have default partition settings that do not play well with only 10GB
     - You can, in these cases, manually create the root `/` partition to extend over the whole disk
   - You do not need to encrypt your disk, unless that is your preference
6. Remove installation media: pick your method
   - After a successful install, go to Settings and change your boot order to boot from disk first
   - After a successful install, go to Settings and remove any disks besides your virtual disk
   - Confirm that when you turn your machine on, the OS starts, not the installation media
     - A good hint here is that the log in screen comes up
7. Download [VirtualBox Extension Pack](https://download.virtualbox.org/virtualbox/6.1.32/Oracle_VM_VirtualBox_Extension_Pack-6.1.32.vbox-extpack) to your host.
   - Launch your VM, then insert the Guest Additions CD Image.
   - Run the Guest Additions installer for your system (I would do the Linux installer)
   - Reboot your VM, then Auto-resize Guest Display
8. Add a screenshot to your documentation of your running VM

## Part 2 - Playground

**Do the following, and write down the steps used in `Lab06.md` Part 2 Answers**

1. In your vm, change your desktop background.
2. In your vm, open a web browser and go to a neat website (or just Pilot).
3. In your vm, install VSCode.
4. In your vm, connect to your AWS instance from your VM. 

## Hints - Screenshots and markdown

There are a lot of ways to add screenshots to a markdown file. I'm going to tell you my way. This is going to introduce a new `git` command: `git pull`

When content exists on GitHub, but does not exist in your local folder (the one you usually `git push` from) you need to do a `git pull` to sync back up.

We are going to be adding images directly to GitHub, then using `git pull` to get our content and the content on GitHub back in sync.

1. Take the screenshots required by part 1. Store them somewhere easy to access.
2. Go to your GitHub classrooms repo in a browser: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME
3. Click the "Add files" button, then click "Upload files"
4. Upload your screenshots. Write commit messages in the browser text fields, then click "Commit Changes"
   - you should now see the images in your main folder
5. Head back to a terminal where you are working on your Lab06 documentation
   - type `git pull`
   - you should see your file names appear in the change list
   - and you should now be able to `ls` and see them
6. In your lab template, you have a line similar to: `![Screenshot of VM running](relative_path_to_filename_here)`
   - keep the parenthesis, but fill them with the relative path to your respective photos
   - this should be relative to being in your repo folder

## Submission

1. Verify that your GitHub repo has a `Lab06` folder with at minimum:

   - `Lab06.md`
   - an `images` folder (with your screenshots inside)

2. In the Pilot Dropbox, paste the URL to the `Lab06` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab06

## Rubric

- Part 1 - 1 pt per question - 8 pts total
- Part 2 - 1 pt per question - 4 pts total
