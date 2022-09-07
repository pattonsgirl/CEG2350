# Environment Setup

This guide is for new users who need to set up their environment.

- [Text Editors](#Text-Editors)
- [Windows Users](#Windows-Users)
  - [Install WSL 2](#Install-WSL-2)
    - [WSL2 Troubleshooting](#WSL-2-Install-Errors)
  - [Terminal Manager](#Terminal-Manager)
  - [MobaXTerm](#Install-MobaXTerm)
    - [cygutils for MobaXTerm](#cygutils-for-MobaXTerm)
- [Mac and Linux Users](#Mac-and-Linux-Users)
  - Use terminal already installed on your system
  - Let me (the instructor) or your ta's know if this needs updating
- [Chromebook Users](#Chromebook-Users)

## Text Editors

I recommend [Visual Studio Code](https://code.visualstudio.com/) as a cross platform solution (plus dark mode looks cool).  
You can also use any default text editor on your system (Notepad, Notepad++, or whatever Mac's have).

## Windows Users

### Install WSL 2

1. Open Powershell as Administrator
2. Enter the following command: `wsl --install`
3. Reboot your machine
4. This should have also downloaded and installed a program called "Ubuntu", which you can find in your apps.

   - If this is **not** true, perform the following steps:
   - Go to Microsoft Store
   - Search for "Ubuntu"
   - Select "Get"
   - Done
   - **Untested** alternative to Windows Store:
     - Open Powershell as Administrator
     - Enter the following command: `wsl --install -d Ubuntu`

5. When you first open WSL2, you will be greeted with something similar to the following:
   ![Ubuntu Install](Images/ubuntuinstall.png)

   - Create a username - do not use spaces or special characters
   - Create a password - yes, it is taking your input. Press backspace a lot if you think you made a typo

- Resources:
  - [How to Geek WSL2 installation guide](https://www.howtogeek.com/744328/how-to-install-the-windows-subsystem-for-linux-on-windows-11/)
  - [Instructions on the Windows blog](https://docs.microsoft.com/en-us/windows/wsl/setup/environment)
- Common pitfalls:
  - Windows is not fully up to date.
  - Need to enable CPU virtualization in the BIOS. See the user manual for your computer
  - Your username cannot have special characters or spaces or you will get a rules error

### Terminal Manager

In later labs, you will need two terminals open. It is absolutely alright to open multiple instances of WSL2 Ubuntu, but it can be convenient  
to have a "tab" based setup. I recommend `Windows Terminal` (can be found in the Windows Store) or `MobaXTerm` (installation instructions below)

#### Install MobaXTerm

[Download MobaXterm Home Edition: Installer Edition](https://download.mobatek.net/2152021112100754/MobaXterm_Installer_v21.5.zip)

- Extract the contents to your Desktop.
- Double-click to run the installer
- Once installed, run the program one time - this finishes the installation
- You can now delete the installation files
- Open Moba. You can now choose to run WSL Ubuntu
  - To change terminals, go to Settings -> Configuration. Select the Terminal tab. In the dropdown at the bottom, change from `bash` to `WSL Ubuntu`
- Keep your SSH session "alive" - prevent timeouts from not interacting
  - `Settings` -> `Configuration`. In `SSH` tab, checkmark the box corresponding to `SSH keepalive`

##### cygutils for MobaXTerm

If you **do not have administrative privileges** and therefore cannot install WSL2 on your Windows system (or have a much older system), you  
will need to install MobaXTerm (above) and install Cygutils (instructions below) in order to perform the labs.

- In Moba, select the Packages icon at the top.
- Wait for the package menu to appear.
- In the search bar, type "cygutils". Select the package from the result listings
- Select Install / Update.
- Restart Moba. Start Local Terminal should work
- In the toolbar for Moba, go to Settings -> Configuration
- In the General tab, check the following two fields are populated with the following values:
  - Persistent home directory: `_MyDocuments_\MobaXterm\home`
  - Persistent root directory: `_MyDocuments_\MobaXterm\slash`

## Mac and Linux Users

- You should have a terminal already installed. Hunt it down ;)

## Chromebook Users

This guide here refers to a [Chrome Extension for SSH connections](https://www.lifewire.com/how-to-use-chromebook-ssh-client-4690108)

- To use your AWS Educate Private Key, you'll need to select "Import..." and browse to your  
  key file - you can then select your key from the dropdown.
- You may need to make a "failed" connection in order to get the permission to access files  
  questions to pop up.

### WSL 2 Install Errors

- After running `wsl --install` in Powershell as Administrator, I get the following error:

  - `"The term 'wsl' is not recognized as the name of a cmdlet, function, script file, or operable program."`
  - See steps 3 & 4 of the following the link to get the install the Windows feature needed for WSL2:
  - https://docs.microsoft.com/en-us/windows/wsl/install-manual#step-3---enable-virtual-machine-feature

- **WSL2 says I am the `root` user by default**

  - Close out of Ubuntu (the app).
  - Hit the Windows key, and search for Ubuntu -> don't open the app.
  - Instead click on "App Settings", then scroll down and select "Reset".
  - Next time you open Ubuntu (the app) it will prompt for a username and password.

- **Forgot password for account in WSL2**

  - Close out of Ubuntu (the app).
  - Hit the Windows key, and search for Ubuntu -> don't open the app.
  - Instead click on "App Settings", then scroll down and select "Reset".
  - Next time you open Ubuntu (the app) it will prompt for a username and password.

- **WSL2 Installation Error message**

```
The requested operation could not be completed due to a virtual disk system limitation.
Virtual hard disk files must be uncompressed and unencrypted and must not be sparse.
```

- Follow [WSL2 VHD Issue Guide](https://utf9k.net/blog/wsl2-vhd-issue/)

## WSL2 Common Problems

- Forgot account password
  - https://itsfoss.com/reset-linux-password-wsl/
