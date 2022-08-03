# Lab 07

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - unallocated resources](#Part-1---unallocated-resources)
- [Part 2 - inode what is up](#Part-2---inode-what-is-up)
- [Extra Credit - take a fstab at this](#Extra-Credit---take-a-fstab-at-this)
- [Submission](#Submission)
- [Rubric](#Rubric)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/13249/modules/items/1136419)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab07`

Write anwers in `Lab07.md` the [LabTemplate.md is here](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/Spring2022-CEG2350/main/Labs/Lab07/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - unallocated resources

For each step below, write the answer to the question / prompt and how you found / configured the answer (commands used).

- **Useful Commands: `df`, `lsblk`, `blkid`, `gdisk`, `mkfs`, `mount`, `strings`**

1. What is the currently mounted block device?
2. Is there another drive listed in `/dev/`?
3. For the `gdisk` GPT partition table manipulator, find out what the following main menu options do:
   - `p`
   - `o`
   - `n`
   - `i`
   - `w`
4. Open the unused drive with `gdisk`. Using the main menu, configure the disk to use the GPT partition table type, have at least 1 partition, and have that partition use the Linux filesystem type. Save your changes to the disk.
5. Make an ext4 filesystem on the new partition
6. Make a folder in `/mnt/` called `expanse`
7. Mount the partition to `expanse`
8. Create some files (with and without text) and directories in the folder where your partition is mounted
9. Run `strings` on the partition - read through the output and determine what `strings` is outputting

   - Like other commands we have played with, `strings` has more capabilities. We are going to use it to show you something interesting about data...

10. Delete a file that you created on the partition. Run `strings` on the partition again - read through the output and see if anything surprises you - what do you see?

    - This is a neat trick that starts getting towards digital forensics. You can assume most people trust that when they hit delete, stuff got deleted. But the contents may still exist on the disk until they are overwritten...

11. Read through this article: [techmint - permanently and securely delete files in Linux](https://www.tecmint.com/permanently-and-securely-delete-files-directories-linux/) and determine a way to truly delete a file. Write a short report of steps and proof that the file is no longer readable on the disk.

    - `shred` is recommended

12. Umount the partition. Can you still interact with the files and folders?

## Part 2 - inode what is up

- **Useful Commands: `stat`, `ln`, `cp`, `mv`**

1. Create a file in your Lab07 folder named `original.txt`. Put some stuff in this file - couple sentences, just enough to give it body.
2. For `original.txt` identify:
   - Command to find the following info about `original.txt`:
   - inode number of `original.txt`:
   - number of blocks storing `original.txt`:
   - number of links to `original.txt`:
3. Create a hard link to `original.txt`
   - What identifiers indicate a hard link was created?
   - Does modifying the hard linked file modify `original.txt`? Explain
4. Create a symbolic link to `original.txt`
   - What identifiers indicate a symbolic link was created?
   - If `original.txt` was deleted, and a new `original.txt` was created, would the sym link still work? Explain
5. Create a copy of `original.txt`
   - Does modifying the copied file modify `original.txt`? Explain
6. Move `original.txt` to another directory.
   - Does it have the same inode? Explain
   - Was the hard link you created affected? Explain
   - Was the symbolic link you created affected? Explain

- Resources:
  - [linoxide - linux inode](https://linoxide.com/linux-inode/)
  - [how to geek - everything you ever wanted to know about inodes on linux/](https://www.howtogeek.com/465350/everything-you-ever-wanted-to-know-about-inodes-on-linux/)

## Extra Credit - take a fstab at this

1. Make a backup of the current version of `/etc/fstab`
2. Add your partition and the mount point (`/mnt/expanse`) to `/etc/fstab`
   - Line added to `/etc/fstab`:
3. Test your changes using the `mount -a` and `df`. Write what you did to prove you got it right in `/etc/fstab`
4. Reboot, if you're brave enough... test that your partition was automounted to `/mnt/expanse`
5. If you are not brave enough, I admire your honestly. Delete changes made to `fstab`

- Resources:
  - [linuxconfig - fstab](https://linuxconfig.org/how-fstab-works-introduction-to-the-etc-fstab-file-on-linux)
  - [ubuntu - Fstab](https://help.ubuntu.com/community/Fstab)

## Submission

1. Verify that your GitHub repo has a `Lab07` folder with at minimum:

   - `Lab07.md`

2. In the Pilot Dropbox, paste the URL to the `Lab07` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab07

## Rubric

- Part 1 - 1 pt per question - 12 pts total
- Part 2 - 1 pt per question - 6 pts total
- Extra credit - 10% (2 pts)
