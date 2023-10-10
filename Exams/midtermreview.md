# Midterm Review for CEG 2350

## Da Rules

- 1 attempt, 1 hour and 20 minutes once started
- Open note, open terminal
- No class - only exam.

## Intro topics

1. How did the modern computer come to be?
2. Shells
   - Windows: powershell, cmd
   - Linux / Mac: bash, sh, zsh
3. Terminals:
   - MobaXTerm
   - WSL2
   - Any program that lets you interact with a shell
4. SSH
   - the command ssh
   - private key files (where go and what permissions)
   - public keys (go where)

## Files, directories, and OS structure

1. OS structure in Linux (and Mac) vs Windows
2. Files vs directories
   - Commands: ls, cp, mkdir, rmdir, vim, mv, rm, cd, cat, touch, head/tail, less/more
3. Importance of names and extensions (file)
4. Ownership & sharing
   - rwx permissions in Linux (and Windows counterpart)
   - user vs. group vs. other
   - chmod, chown, chgrp, adduser, deluser
   - User types and groups
   - sudo & the root user
5. PATH vs path and environment variables

## Scripting

1. Aliases & customizations (.bashrc, .profile)
2. Commands: ~~diff~~, find, ~~file~~, wc, sort, uniq, whereis, which
3. IO redirection (<, >, |, streams (standard output and error) ~~tee~~)
4. executing scripts (source, ./, PATH)
5. Scripting languages: bash
   - variables
   - conditionals (`test`)
   - arguments
   - if
   - for
   - while
   - getopts
   - case
6. Regular expressions
7. grep, sed, and awk

## Computer Hardware, Boot Process, and Data on Disks:

1. Computer Hardware:
   - [Von Neumann architechure](https://www.computerscience.gcse.guru/theory/von-neumann-architecture)
   - CPU
   - RAM
   - Motherboard
   - Disks (HDD, SSD, NVME)
   - GPU
2. Booting of OS
   - ~~Power on self-test (POST)~~
   - ~~BIOS vs UEFI~~
   - ~~MBR vs GPT~~
   - ~~Boot loaders: NTLDR, GRUB~~
   - kernel vs OS
3. ~~Virtual memory~~
   - What is it and how does it work
4. ~~Disks~~
   - MBR vs GPT
   - partitions
   - ~~filesystems~~
   - ~~sectors vs blocks vs inodes~~
   - fragmentation

## Git (version control)

1. Git remote (servers) vs. clients (local)
2. Basic commands:
   - clone
   - add
   - commit
   - push
   - pull
3. merge conflicts
