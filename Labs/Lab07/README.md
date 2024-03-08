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

- **Useful Commands: `df`, `lsblk`, `parted`**

Information on `/dev/xvda` - current usage & partition table

**Resources**
- [IBM - Displaying partition information using `parted`](https://developer.ibm.com/tutorials/l-lpic1-104-1/#displaying-partition-information-using-parted)

## Part 2 - Something new

- **Useful Commands: `df`, `lsblk`, `blkid`, `gdisk`**

1. Using the `gdisk` GPT partition table manipulator, find out what the following main menu options do:
   - `p`
   - `o`
   - `n`
   - `i`
   - `w`
2. Edit the `xvbd` block device with `gdisk`. Using the main menu, configure the disk to use the GPT partition table type, have at least 1 partition, and have that partition use the Linux filesystem type. Save your changes to the disk.
   - Hint: remember disks devices are in the `/dev/` folder
3. Partition table of `xvdb`

**Resources**
- [DigitalOcean - click "Interactive partitioning with `gdisk`"](https://docs.digitalocean.com/products/volumes/how-to/partition/)
- [IBM - Partitioning an GPT disk using `gdisk`](https://developer.ibm.com/tutorials/l-lpic1-104-1/#partitioning-an-gpt-disk-using-gdisk)

## Part 3 - File it away

- **Useful Commands: `mkfs`, `mount`**

5. Make an ext4 filesystem on the new partition
6. Make a folder in `/mnt/` called `expanse`
7. Mount the partition to `expanse`
12. `umount` the partition. Can you still interact with the files and folders?

**Resources**
- [IBM - Creating Filesystems](https://developer.ibm.com/tutorials/l-lpic1-104-1/#creating-filesystems)

## Part 4 - Take a `fstab` at this

1. Make a backup of the current version of `/etc/fstab`
2. Add your partition and the mount point (`/mnt/expanse`) to `/etc/fstab`
   - Line added to `/etc/fstab`:
3. Test your changes using the `mount -a` and `df`
4. Reboot, if you're brave enough... test that your partition was automounted to `/mnt/expanse`
5. If you are not brave enough, I admire your honestly. Delete changes made to `fstab`

- Resources:
  - [HowToGeek - How to write an fstab file on Linux](https://www.howtogeek.com/444814/how-to-write-an-fstab-file-on-linux/)
  - [linuxconfig - fstab](https://linuxconfig.org/how-fstab-works-introduction-to-the-etc-fstab-file-on-linux)
  - [ubuntu - fstab](https://help.ubuntu.com/community/Fstab)

## Part 5 - What is dead may still be read

- **Useful Commands: `df`, `lsblk`, `blkid`, `gdisk`, `mkfs`, `mount`, `strings`**

8. Create some files (with and without text) and directories in the folder where your partition is mounted
9. Run `strings` on the partition - read through the output and determine what `strings` is outputting

   - Like other commands we have played with, `strings` has more capabilities. We are going to use it to show you something interesting about data...

10. Delete a file that you created on the partition. Run `strings` on the partition again - read through the output and see if anything surprises you - what do you see?

    - This is a neat trick that starts getting towards digital forensics. You can assume most people trust that when they hit delete, stuff got deleted. But the contents may still exist on the disk until they are overwritten...

11. Read through this article: [techmint - permanently and securely delete files in Linux](https://www.tecmint.com/permanently-and-securely-delete-files-directories-linux/) and determine a way to truly delete a file. Write a short report of steps and proof that the file is no longer readable on the disk.

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

1. Verify that your GitHub repo has a `Lab08` folder with at minimum:

   - `Lab08.md`

2. In the Pilot Dropbox, paste the URL to the `Lab08` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab08

## Rubric

- Part 1 - 1 pt per question - 12 pts total
- Part 2 - 1 pt per question - 6 pts total
- Extra credit - 10% (2 pts)
