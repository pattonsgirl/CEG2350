# Exam 1 Review for CEG 2350

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
4. IO streams (standard input, output (1) and error (2)) and redirection (`<, >, >>, |, tee`)
5. executing scripts
   - within current bash shell (source (or `.`)
   - by specifying interpreter (bash)
   - by specifying the intepreter with `#!` (`./`)
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
7. Regular expressions
8. grep (search)

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
