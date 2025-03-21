# Lab 08 - Disks & Filesystems

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

Make sure to return to the AWS Learner Lab page (link in Pilot if you forgot to bookmark it) and hit "Start Lab" to turn on your sandbox / AWS instance.

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab08`.

Create a file named `README.md` in the `Lab08` folder.  Copy into the file the contents of the [Lab 08 Template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab08/LabTemplate.md)

You may refer to additional resources outside of the recommended resources provided.  

Any resource that you use that contributes to your understanding of exercises in this lab should be cited in the `Citations` section of your lab answers.  To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.

If you make mistakes with commands in the lab, note them!  Writing down what went wrong and what the correction was will significantly help your learning journey.  If you cannot find a correction, it will help the TAs or myself understand what point you reached and determine some potential solutions.

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
4. Use `blkid` to view information of `xvda` and it's partitions.  Play with `*` to get all matches that start with `\dev\xvda`  
5. For the partition with the root filesystem:
    - What is the device name?
    - What is the partition label?
    - What type of filesystem is on the partition?
6. Use `df` to view file system disk space usage in human readable format (meaning it prints MB/KB/GB)
7. For the root filesystem:
    - What is the total size?
    - How much space is used?
    - Where is it mounted to?
8. View the contents of the filesystem table in `/etc/fstab`
9. Explain fields & purpose of fields in the entry that mounts the root filesystem.

**Resources**
- [IBM - Displaying partition information using `parted`](https://developer.ibm.com/tutorials/l-lpic1-104-1/#displaying-partition-information-using-parted)
- [linuxconfig - How fstab works – introduction to the `/etc/fstab` file on Linux](https://linuxconfig.org/how-fstab-works-introduction-to-the-etc-fstab-file-on-linux)


## Part 2 - Something new

You have had an unformatted disk available on your AWS instance all along.  The disk is `xvdb` - you can see it, but that it has no partitions, if you run `lsblk`. Time to create a partition table and a partition on `/dev/xvdb` so that in the next Part we can create a filesystem on the partition and mount it for use.  
- **Useful Commands: `df`, `lsblk`, `blkid`, `gdisk`**

1. Using the `gdisk` GPT partition table manipulator, find out what the following main menu options do:
   - `p`
   - `o`
   - `n`
   - `i`
   - `w`
2. Edit the `xvdb` block device with `gdisk`. Using the main menu, configure the disk to use the GPT partition table type, have at least 1 partition, and have that partition use the Linux filesystem type. Save your changes to the disk.
    - This will be the only partition, so it can use the recommended sizes, which is to say, start at the end of the GPT partition table, and span to the last block of the disk.
3. View the partition table of `xvdb`
4. Answer the following about `xvdb` in its current state:
    - What is the device name of the only partition?
    - What is the size of the only partition?
    - What filesystem type will be used on the only partition?

**Resources**
- [DigitalOcean - click "Interactive partitioning with `gdisk`"](https://docs.digitalocean.com/products/volumes/how-to/partition/)
- [IBM - Partitioning an GPT disk using `gdisk`](https://developer.ibm.com/tutorials/l-lpic1-104-1/#partitioning-an-gpt-disk-using-gdisk)

## Part 3 - File it away

Now that you have a partition, you can create a filesystem on it in order to interact with it to store and organize files and create permissions for the files.

- **Useful Commands: `mkfs`, `mount`**

1. Make an `ext4` filesystem on the partition on `xvdb`
2. Use `blkid` to view information of the partition on `xvdb`
3. Make a directory in `/mnt/` named `expanse`
4. Mount the partition on `xvdb` to `expanse`
5. In `expanse` create some files and directories
6. `umount` the partition on `xvdb`
7. When can I interact with files on the filesystem on the partition in `xvdb`?

**Resources**
- [IBM - Creating Filesystems](https://developer.ibm.com/tutorials/l-lpic1-104-1/#creating-filesystems)
      - Information on `ext4` is folded into `ext3` since it makes slight improvements over `ext3`
- [TechMint - How to Change Linux Partition Label Names on EXT4 / EXT3 / EXT2](https://www.tecmint.com/change-modify-linux-disk-partition-label-names/)

## Part 4 - Take a `fstab` at this

Right now, every time you want to access your new filesystem on `xvdb1` after a system reboot you need to mount it.  It would be handy to have it auto-mount. The filesystem table file - `fstab` is a file that stores information about what to mount when the system boots. Your task in this part is to **append** a new entry to `fstab` to automount the filesystem on `xvdb1`.

1. Make a backup of the current version of `/etc/fstab` to `/etc/fstab.bak`
2. Add a line to `/etc/fstab` to mount the partition on `xvdb` to the mount point (`/mnt/expanse`)
3. Test your changes using `mount -a` to mount / remount records entries in `etc/fstab` and then check that your additional entry worked (make sure `xvdb1` is unmounted first, then test and verify)
4. **If you do not think your changes are correct** restore `/etc/fstab` from `/etc/fstab.bak`.  If you think they are correct, you may leave your changes in place.

**Resources**
- [HowToGeek - How to write an fstab file on Linux](https://www.howtogeek.com/444814/how-to-write-an-fstab-file-on-linux/)
- [linuxconfig - fstab](https://linuxconfig.org/how-fstab-works-introduction-to-the-etc-fstab-file-on-linux)
- [ubuntu - fstab](https://help.ubuntu.com/community/Fstab)

## Part 5 - What is dead may still be read

When you delete a file, you are used to it no longer being accessible, or to it still being temporarily available / recoverable via the Recycle Bin.  But once you can't open it anymore, it should be gone, including from the disk, right?  Right?!?

This part will have you acknowledge that to truly make data gone and no longer readable, there are extra steps involved.  The general recommendation is to trust nothing, and take disks that have had important data on it, like tax returns, credit card info, passwords, etc, taken to a shredding center and properly ripped to computer-illegible pieces.

- **Useful Commands: `mount`, `strings`**

1. On the filesystem you created on the `xvdb` partition, create **two** files, each with a different FAKE secret about you.
2. Find out information on the `strings` command. If you referred to an internet resource, make sure you cite it by including the URL.
3. Run `strings` on the filesystem partition on `xvdb` - read through the output and make an analysis about what output you are viewing.
4. Delete **one** of the files with a secret. 
5. Run `strings` on the filesystem partition on `xvdb` - read through the output and determine if the secret, while no longer accessible via the filesystem, is still readable on the partition.
6. Find out information on the `shred` command. If you referred to an internet resource, make sure you cite it by including the URL.
7. Use `shred` to overwrite the contents of your second secret file on the disk.  Write a short report of steps and provide proof that the file is no longer readable on the disk or accessible in the filesystem.  Include an explanation of flags used (if any).

**Resources**
- [freeCodeCamp - How to Securely Erase a Disk and File using the Linux shred Command](https://www.freecodecamp.org/news/securely-erasing-a-disk-and-file-using-linux-command-shred/)

## Extra Credit - Create a Virtual Filesystem

Now that you have made a virtual machine, a thought might be how does it use the disk space on your host.  In the context of a virtual machine, the reserved space on the host has a partition table, partitions, and a filesystem mounted to `/`

Use guides to create a guide on how to complete this tasking.

1. Check for used / available loop device labels
2. Use **either** `dd` or `fallocate` to reserve 2 GB of space (a "file") from `/dev/xvda`.
3. Create the loop device and have it use the 2 GB space reserved from the command above.
4. Make a filesystem on the loop device.
5. Mount the filesystem to `/mnt/vfs` (vfs for virtual filesystem).

**Resources**
- [LinuxOPsys - How to use `fallocate`](https://linuxopsys.com/topics/fallocate-command-in-linux)
- [LinuxOPsys - Creating virtual filesystem with `dd`](https://linuxopsys.com/topics/linux-dd-command-with-examples#2_Creating_virtual_filesystemBackup_images_of_CD_or_DVDs_as_iso_files)
- [DZone - Loop Device in Linux](https://dzone.com/articles/loop-device-in-linux)

## Submission

1. Verify that your GitHub repo has a `Lab08` folder with at minimum:

   - `README.md`

2. In the Pilot Dropbox, paste the URL to the `Lab08` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350s24-YOURGITHUBUSERNAME/tree/main/Lab08

## Rubric

- Part 1 - 1 pt per question - 9 pts total
- Part 2 - 1 pt per question - 4 pts total
- Part 3 - 1 pt per question - 6 pts total
- Part 4 - 1 pt per question - 3 pts total
- Part 5 (+ how to truly delete file data) - 1 pt per question - 6 pts total
- Extra credit - 10% (2.8 pts)
