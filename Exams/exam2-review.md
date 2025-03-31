# Exam 2 Review for CEG 2350

## Intro topics

1. Shells
   - Windows: powershell, cmd
   - Linux / Mac: bash, sh, zsh
2. SSH
   - the command, its options, and structure of information
   - private key files (location and permissions)
   - public keys and the authorized_keys file

## Files, directories, and OS structure

1. Filesystem structure in Linux, Mac, and Windows
2. Files vs directories
3. Commands: ls, cp, mkdir, rmdir, vim, mv, rm, cd, cat, touch, head/tail, less/more, ln
4. Importance of names and extensions (file)
5. Ownership & sharing
   - rwx permissions in Linux
   - user vs. group vs. other
   - creating users & groups (and naming rules)
   - chmod, chown, chgrp, adduser, deluser
   - sudo & the root user

## Scripting

1. Environment variables
   - HOME
   - USER
   - SHELL
   - PATH
2. Aliases & customizations (.bashrc, .profile)
3. Commands: diff, find, file, wc, sort, uniq, whereis, which
4. IO streams (standard input, output (1) and error (2)) and redirection (<, >, >>, |, tee)
5. executing scripts
   - within current bash shell (source (or `.`)
   - by specifying interpreter (bash)
   - by specifying the interpreter with `#!` (`./`)
   - by name from any location (adding path to PATH)
6. Scripting languages: bash
   - variables
   - reading input
   - printf vs echo
   - arguments
   - conditionals (`test`)
   - if
   - for
   - while
   - case
   - getopts
   - functions
7. Regular expressions
8. grep (search)
9. sed (search and replace)
10. awk (manipulate formatted data)

## Computer Hardware & VMs

1. Computer Hardware:
   - CPU
   - RAM
   - Motherboard
   - Disks (HDD, SSD, NVME)
   - GPU (discrete / dedicated vs integrated)
2. VMs
   - hypervisor
   - host considerations when creating VMs
   - installing guest VMs

## Boot Process

1. BIOS / UEFI
2. POST
3. bootloader
4. kernel
5. OS

## Filesystems & Disks

1. Partition tables & partitions
   - Tools: parted, gdisk, fdisk
2. Filesystems
   - Windows
   - Linux
   - Mac
   - compatibility, metadata, structure
3. Mounting & "ejecting"
   - mounting to /
   - automounting with `fstab` entries

## Process Control

1. Terminology
   - process
   - application
   - service / daemon
2. Process states
   - Running
   - Sleeping
   - Stopped
   - Zombie
   - Orphan
3. Process metadata
   - PID
   - PPID
   - User
   - Command
   - Controlling terminal
4. Process manipulation
   - viewing active processes
   - killing processes
   - foreground vs background processes
   - "pseudo terminals" via `tmux`
5. Service manipulation with `systemctl`
   - enable vs disable
   - start, stop, reload / restart
6. init / systemd
   - systemctl (manage services
   - journalctl (manage service logging)

## Git (version control)

1. Version control as a concept
2. Steps to clone with `ssh` for authentication
3. Basic commands:
   - clone
   - add
   - commit
   - push
   - pull
   - status
