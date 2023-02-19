# Lab 06

- [Lab Procedure](#Lab-Procedure)
- [System Discovery](#System-Discovery)
- [Extra Credit - Install a VM Manager](#Extra-Credit---Install-a-VM-Manager)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

The focus of this lab is exploring your system. You will be creating a `Lab06.md` file for your work in this lab. To create and edit the file, you are welcome to use your AWS instance (or anywhere your repo is cloned) or edit the file directly in the browser.

In your repository (the folder named `ceg2350-yourgithubusername):

Create a new directory, `Lab06`

Create a file named `Lab06.md` [based on the template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab06/LabTemplate.md)

## System Discovery

Find out the following information about your personal system. Write the answers to the information requested. Part of this is learning about your system, so some info will not apply to your system (because of how your OS works with your hardware or your system's hardware). Provide confirmation of your findings where possible.

- You can use the manufacturers website / manuals
- You can post to our course Discord channel for help / hints
  - On \_\_ OS, how are you finding \_\_?
- You should _not_ need to install additional programs to find this information. If someone tells you to install something, run away.

1. CPU info:
    - CPU brand:
    - Number of cores:
    - Number of logical cores:
2. GPU info:
    - Integrated GPU info:
    - Dedicated GPU info: 
    - Link to driver for primary GPU: 
3. Memory info:
    - Physical memory (RAM) size (translate to GB)
    - Virtual memory size (translate to GB)
      - Some systems will call virtual memory a pagefile
4. Storage info (for each disk attached to your system): 
    - Disk type:
    - Disk manufacturer and model:
    - Total disk size (translate to GB):
5. Primary partition info:
    - Primary partition mount point:
      - `C` for Windows users
      - `/` for Linux / Mac(?) users
    - Remaining space on primary partition (translate to GB):
    - Filesystem on primary partition:
6. BIOS / UEFI info: 
    - BIOS or UEFI version: 
    - How to access your BIOS / UEFI: 

## Extra Credit - Install a VM Manager

This is to take some headache out of Lab 07 by having you install VirtualBox now. It is recommended to get done this week in case there are any new surprises. If you have trouble, post to the class chat in Discord so I / the TAs / your classmates can help out.

You will need a computer that has CPU virtualization enabled. The lab machines & open lab machines in Russ are all good candidates (and may have VirtualBox already installed). For your own machine, you may need to enable CPU virtualization in your BIOS / UEFI.

- Windows, Linux, Mac users:
  - [Download and install VirtualBox](https://www.virtualbox.org/wiki/Downloads)
  - Pick your host OS when installing
    - For example, Windows users should select "Windows hosts")
- Mac M1 Users:
  - VirtualBox _should_ work now, but just in case:
  - Install either:
    - Parallels - Wright State offers a student discount on Parallels
      - [Get Parallels via the Hub](https://www.wright.edu/information-technology/software-purchases-for-personal-use)
    - [UTM](https://mac.getutm.app/) - free if you click "Download". You can support the developers by paying through the App Store.
  - the instructions below should apply generically, but if you are having trouble post in the general chat on Discord and we will help as we can
- Windows 11 Users:
  - Try to install VirtualBox, but it has had mixed support in Windows 11
  - [Enable Hyper-V Manager](https://www.groovypost.com/howto/enable-virtualization-in-windows-11/)
- Chromebook Users:
  - You may need to use one of the open labs (320 OH during lab time, or Russ 152 B or D) or be prepared to use a different system you have access to.

## Submission

1. Verify that your GitHub repo has a `Lab06` folder with at minimum:

   - `Lab06.md`

2. In the Pilot Dropbox, paste the URL to the `Lab06` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab06

## Rubric

- Each bullet point = 1 point -> 16 pts total
- Extra credit - 5% = 0.8 pts
