# Final Review for CEG 2350

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
5. Updates (Linux vs. Windows)
   - Linux - apt / package manager update request
   - Windows - click button

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
   - Von Neumann machine: Control unit; instruction fetch, decode, and execution
     - light here, do additional reading
   - CPU
   - RAM
   - Motherboard
   - Disks (HDD, SSD, NVME)
   - GPU
2. Booting of OS
   - Power on self-test (POST)
   - BIOS vs UEFI
   - MBR vs GPT
   - Boot loaders: NTLDR, GRUB
   - kernel vs OS
3. Virtual memory
   - What is it and how does it work
4. Disks
   - MBR vs GPT
   - partitions
   - fragmentation

## Git (version control)

1. Git remote (servers) vs. clients (local)
2. Basic commands:
   - clone
   - add
   - commit
   - push
   - pull
     - fetch
     - merge
   - branch
   - checkout
   - merge

## Virtual Machines

1. Set of resources virtually "defined"
2. Resource allocation managed by hypervisor
3. Can install an operating system to a disk using an iso (machine image)
4. What can you do in a virtual machine?

## Devices, Filesystems, Data Storage

1. Devices
   - block - SSD, HDD, NVME, CD, USB
   - character - /dev/null, /dev/zero, /dev/random
2. Storing data on a disk
   - partition table
   - partitions
   - filesystem
   - mounting filesystem
3. Filesystems
   - journaling
     - light here, recommend additional reading
   - Windows: vfat, ntfs
   - Linux: ext4
   - Special: swap
4. Fragmentation and block devices
5. Inodes
   - hard links
   - soft links
   - cp vs mv
6. File locks
7. Commands: df, du, mkfs, gdisk, fdisk, parted, mount, umount, stat

## Processes

1. init process / kernel level vs user level processes
2. Processes
   - parent vs child
   - System calls & kill signals
   - Fork & exec
   - wait & exit
   - zombie and orphan process states
3. Service units & service control
   - systemctl & journalctl
   - format of a service file
   - creating new service units / managing existing service units
      - stop, start, restart, enable, disable
4. Process scheduling & priorities
5. ~~Thread vs Fork~~
6. ~~CPU & kernel memory management~~
   - page faults (minor & major)
   - virtual memory
7. ~~Single CPU multi-tasking & context switching~~
8. ~~Multiple CPUs and SMP (Symmetric multiprocessing)~~
8. Commands: kill, ps, top, nice, bg, fg, jobs, screen, tmux

## Command line programming

1. Interpreted language
   - python
   - bash
2. Compiled languages
   - c / c++
     - compilation steps
       - pre-processor
       - compiler
       - assembler
       - linker
     - `gcc`/ `g++` and compilation options
     - Linux ELF (Executable & Linkable Format)
     - Windows EXE
   - java
     - compile in java compiler
     - run in JVM
3. Makefiles
   - make
   - targets
   - dependencies
   - actions
4. ~~Memory handling in programming~~
   - size of memory - Bits (1), bytes (8 bits), word (16, 32, or 64 bits)
   - stack vs. heap
6. Libraries & dynamic linking (loads and links the shared libraries needed by an executable when it is executed)
7. Overview of command line debugging
8. ~~Install from source w/ make or installation scripts~~
9. Compression (including `tar` & `gzip`)
10. Commands: make, which, whereis, python, gcc, java, javac, ~~ldd~~, ~~strace~~

## Networking

1. OSI model and TCP / IP model of networking
   - application
     - light here, scope will be what was praciticed in lab.  Additional reading recommended   
     - HTTP
     - HTTPS
       - Certificate Authorities & browser trust
     - SSH
       - private / public key pairs, `config` & `authorized_keys` files
     - SFTP
   - transport
     - ports
     - UDP
     - TCP
   - network / internet
     - IP addresses (v4 and v6)
     - DNS to resolve IP addresses
     - subnets
     - routes
     - NAT
   - data / link
     - MAC
     - NIC
   - physical
2. Ports vs sockets
   - Application opens a socket which is connected to a port
3. Pieces of a network
   - hosts (devices)
   - routers
   - switches
   - ISPs
4. Firewalls
   - inbound / INPUT / ingress
   - outbound / OUTPUT / egress
   - ~~whitelist vs blacklist & default allow vs deny~~
   - common sense rules & trusted networks
5. Commands: ip, route, arp, iptables, ping, curl, wget, tcpdump, nmap

## Excess Topics - not for studying

- X11 and RDP
- GPG and PGP
- Network file shares: NFS, Samba
- Filesystem differences in terms of implementation
- Virus scanning & types of computer diseases
- password locking files
- Torrents
