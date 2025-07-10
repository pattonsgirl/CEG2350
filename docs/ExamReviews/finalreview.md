# Final Review for CEG 2350

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
3. Commands: ls, cp, mkdir, rmdir, vim, mv, rm, cd, cat, touch, head/tail, less/more
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

1. Devices
   - block - SSD, HDD, NVME, CD, USB
   - character - `/dev/null`, `/dev/zero`, `/dev/random`
2. Partition tables & partitions
   - MBR vs GPT
   - Tools: parted, gdisk, fdisk
3. Filesystems
   - Standard defaults for Windows, Linux, and Mac
   - compatibility, metadata, structure
   - inodes
      - Symbolic links vs. hard links
      - Tools: `ln`, `stat`
   - Tools: `du`, `df`, `mkfs`
4. Mounting & "ejecting"
   - mounting to `/`
   - automounting with `fstab` entries
   - Tools: `mount`, `umount`
5. Compression (`tar` & `gzip`)

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
   - foreground vs background processes (`bg`, `fg`)
   - "pseudo terminals" via `tmux`
5. Service manipulation with `systemctl`
   - enable vs disable
   - start, stop, reload / restart
   - format of a service unit file
6. init / systemd
   - systemctl (manage services)
   - journalctl (view service logs)
7. Tools: `ps`, `top`, `kill`, `jobs`

## Programming

1. Languages:
   - Interpreted: bash, python
   - Compiled: C / C++, Java (JDK vs JVM)
2. Compilation (in C / C++):
   - pre-processor
   - compiler
   - assembler
   - linker
   - `gcc`/ `g++` and compilation flags
   - Linux ELF (Executable & Linkable Format)
   - Windows EXE
3. Makefiles
   - `make`
   - targets
   - dependencies
   - actions
4. Tools: `which`, `whereis`, `ldd`

## Networking
2. Core networking concepts
   - Methods of communication (physical layer): wifi, ethernet, fiber
   - Network interface (NIC)
      - communicates over physical layer
      - Media Access Control address (MAC)
   - Network concepts
      - IPv4 vs IPv6 addressing
      - DNS
      - DHCP
      - subnets
      - routes
      - border gateways / Network Address Translation (NAT)
      - ports
3. IPv4 concepts
   - Subnetting & CIDR notation
4. Firewalls
   - inbound / INPUT / ingress
   - outbound / OUTPUT / egress
   - common sense rules & trusted networks
   - applied questions will be with a view of an AWS Security Group
5. Commands: `ip`, `route`, `arp`, `iptables`, `ping`, `curl`, `wget`

### Network protocols
1. HTTP
2. HTTPS
   - certificates & Certificate Authorities
3. SSH
   - ssh
   - sftp
   - Files:
      - private key
      - public key
      - `config`
      - `known_hosts`
      - `authorized_keys`

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
   - branch
   - checkout
   - merge
4. Files:
   - `.gitignore`
