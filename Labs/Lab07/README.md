# Lab 07

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - What do we have?](#part-1---what-do-we-have)
- [Part 2 - Something new](#part-2---something-new)
- [Part 3 - File it away](#part-3---file-it-away)
- [Part 4 - Take a fstab at this](#part-4---take-a-fstab-at-this)
- [Part 5 - What is dead may still be read](#part-5---what-is-dead-may-still-be-read)
- [Extra Credit - Create a Virtual Filesystem](#extra-credit---create-a-virtual-filesystem)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

**THIS LAB MUST BE COMPLETED IN THE AWS INSTANCE YOU SETUP IN LAB 01.**

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/68834/modules/items/6128516)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab07`

Write answers in `Lab07.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab07/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - What do we have?

Your AWS instances have one block device in use - `xvda`.  In this section, you will explore commands view partition and filesystem information about `xvda`.  **Do not make any modification to `xvda`.**

Hint, remember that disk devices are in the `/dev/` folder  

- **Useful Commands: `lsblk`, `parted`, `blkid`, `df`, `cat`**

For tasks that ask you to use a command, write the command used and include the output of the command.

1. Use `lsblk` to list only information about the `xvda` block device.
2. Use `parted` to print the partition table of the `xvda` block device.
3. For the `xvda` partition table:
    - Does it use MBR or GPT?
    - How many partitions are on the block device?
    - What is the largest partition?
4. Use `blkid` to view the type of content (e.g. filesystem or swap) that current block devices hold (`xvda` being the only block device right now)
5. For the primary partition:
    - What partition is the root filesystem on?
    - What is the partition label?
    - What type of filesystem is on the partition?
6. Use `df` to view file system disk space usage in human readable format
7. For the root filesystem:
    - What is the total size?
    - How much space is used?
    - Where is it mounted to?
8. View the contents of the filesystem table in `/etc/fstab`
9. Explain the fields in the entry that mounts the root filesystem.

**Resources**
- [IBM - Displaying partition information using `parted`](https://developer.ibm.com/tutorials/l-lpic1-104-1/#displaying-partition-information-using-parted)

## Part 2 - Something new

You have had an unformatted disk available on your AWS instance all along.  Time to create a partition table and a partition on it (and in the next step create a filesystem).  The disk is `xvdb` - you can see it, but that it has no partitions, if you run `lsblk`.

- **Useful Commands: `df`, `lsblk`, `blkid`, `gdisk`**

1. Using the `gdisk` GPT partition table manipulator, find out what the following main menu options do:
   - `p`
   - `o`
   - `n`
   - `i`
   - `w`
2. Edit the `xvbd` block device with `gdisk`. Using the main menu, configure the disk to use the GPT partition table type, have at least 1 partition, and have that partition use the Linux filesystem type. Save your changes to the disk.
    - This will be the only partition, so it can use the recommended sizes, which is to say, start at the end of the GPT partition table, and span to the last block of the disk.
3. Partition table of `xvdb`
4. Answer the following about `xvbd` in its current state:
    - What device name does the partition use?
    - What size is the partition?
    - What filesystem type will be used on the partition?

**Resources**
- [DigitalOcean - click "Interactive partitioning with `gdisk`"](https://docs.digitalocean.com/products/volumes/how-to/partition/)
- [IBM - Partitioning an GPT disk using `gdisk`](https://developer.ibm.com/tutorials/l-lpic1-104-1/#partitioning-an-gpt-disk-using-gdisk)

## Part 3 - File it away

Now that you have a partition, you can create a filesystem on it in order to interact with it to store and organize files and create permissions for the files.

- **Useful Commands: `mkfs`, `mount`**

1. Make an `ext4` filesystem on the partition on `xvdb` with a label of `yourlastname_fs` where `yourlastname` is your last name.
2. Make a directory in `/mnt/` named `newworld`
3. Mount the partition on `xvdb` to `newworld`
4. In `newworld` create some files and directories
5. `umount` the partition on `xvbd`
6. When can I interact with files on the filesystem on the partition in `xvdb`?

**Resources**
- [IBM - Creating Filesystems](https://developer.ibm.com/tutorials/l-lpic1-104-1/#creating-filesystems)

## Part 4 - Take a `fstab` at this

Right now, every time you want to access your filesystem, you need to mount it - this includes after rebooting the system.  It would be handy to have it auto-mount.  The filesystem table file - `fstab` is a file that stores  information about wat to mount when the system boots.  You task in this part is to **append** a new entry to the file to automount your filesystem on the partition on `xvdb`.

1. Make a backup of the current version of `/etc/fstab` to `/etc/fstab.bak`
2. Add a line to `/etc/fstab` to mount the partition on `xvdb` to the mount point (`/mnt/newworld`)
3. Test your changes using `mount -a` to mount / remount records according to `etc/fstab` and use commands to validate your entry worked
4. **If you do not think your changes are correct** restore `/etc/fstab` from `/etc/fstab.bak`.  If you think they are correct, you may leave your changes in place.

**Resources**
- [HowToGeek - How to write an fstab file on Linux](https://www.howtogeek.com/444814/how-to-write-an-fstab-file-on-linux/)
- [linuxconfig - fstab](https://linuxconfig.org/how-fstab-works-introduction-to-the-etc-fstab-file-on-linux)
- [ubuntu - fstab](https://help.ubuntu.com/community/Fstab)

## Part 5 - What is dead may still be read

When you delete a file, you are used to it no longer being accessible, or to it still being temporarily available / recoverable via the Recycle Bin.  But once you can't open it anymore, it should be gone, including from the disk, right?  Right?!?

This part will have you acknowledge that to truly make data gone and no longer readable, there are extra steps involved.  The general recommendation is to trust nothing, and take disks that have had important data on it, like tax returns, credit card info, passwords, etc, taken to a shredding center and properly ripped to computer-illegible pieces.

We are also only focused on data stored on disks for this exercise.  If you look into this topic of data forensics, there is another prong of this that focusing on making sure RAM is cleared of information.

- **Useful Commands: `mount`, `strings`**

1. On the filesystem you created on the `xvdb` partition, create **two** files, each with a different FAKE secret about you.
2. What does the `strings` command do?
3. Run `strings` on the filesystem partition on `xvbd` - read through the output and make an analysis about what output you are viewing.
4. Delete **one** of the files with a secret. 
5. Run `strings` on the filesystem partition on `xvbd` - read through the output and determine if the secret, while no longer accessible via the filesystem, is still readable on the partition.
6. Read through this article: [techmint - permanently and securely delete files in Linux](https://www.tecmint.com/permanently-and-securely-delete-files-directories-linux/) and determine a way to truly delete a file and overwrite it's contents on the disk. Write a short report of steps and proof that the file is no longer readable on the disk.
    - `shred` is recommended

## Extra Credit - Create a Virtual Filesystem

Now that you have made a virtual machine, a thought might be how does it use the disk space on your host.  In the context of a virtual machine, the reserved space on the host has a partition table, partitions, and a filesystem mounted to `/`

Write the commands used in each step (unless otherwise stated).

1. Use **either** `dd` or `fallocate` to reserve 2 GB of space from `/dev/xvda`.  
2. Write an explanation of the command you used.
2. Make a filesystem on the reserved space.
3. Mount the filesystem to `/mnt/vfs`.

**Resources**
- [LinuxOPsys - How to use `fallocate`](https://linuxopsys.com/topics/fallocate-command-in-linux)
- [LinuxOPsys - Creating virtual filesystem with `dd`](https://linuxopsys.com/topics/linux-dd-command-with-examples#2_Creating_virtual_filesystemBackup_images_of_CD_or_DVDs_as_iso_files)

## Submission

1. Verify that your GitHub repo has a `Lab07` folder with at minimum:

   - `Lab07.md`

2. In the Pilot Dropbox, paste the URL to the `Lab07` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350s24-YOURGITHUBUSERNAME/tree/main/Lab07

## Rubric

- Part 1 - 1 pt per question - 12 pts total
- Part 2 - 1 pt per question - 6 pts total
- Extra credit - 10% (2 pts)
