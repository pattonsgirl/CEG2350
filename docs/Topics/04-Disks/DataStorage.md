# Data Storage - Sectors, Blocks, and inodes

Understanding the relationship between sectors, blocks, and inodes is key to grasping how a computer moves from raw magnetic or flash storage to a searchable file system. While they all deal with data storage, they exist at different layers of the "stack."

---

## 1. Sectors: The Physical Layer

A **sector** is the smallest physical storage unit on a hard drive platter or flash chip. It is defined by the hardware manufacturer.

* **Size:** Traditionally **512 bytes**, though modern "Advanced Format" drives use **4096 bytes (4K)**.
* **Role:** This is the hard-wired division of the disk. The drive controller reads and writes data in whole sectors; you cannot physically change half a sector.
* **Analogy:** Think of a sector as a single physical brick in a building.

---

## 2. Blocks: The Operating System Layer

A **block** (sometimes called a "file system block" or "cluster") is a logical unit used by the Operating System (OS) to manage data. It is a group of one or more contiguous sectors.

* **Size:** Commonly **4096 bytes (4K)** in Linux (Ext4) and Windows (NTFS).
* **Role:** The OS finds it inefficient to track every 512-byte sector, so it bundles them into blocks. When you save a 1 KB file, the OS still allocates one full 4 KB block for it.
* **Relationship:** If a sector is 512 bytes and a block is 4096 bytes, then $1 \text{ Block} = 8 \text{ Sectors}$.
* **Analogy:** If a sector is a brick, a block is a "pallet" of bricks. The construction crew (the OS) moves data one pallet at a time.

---

## 3. Inodes: The Metadata Layer

An **inode** (index node) is a data structure in a Unix-style file system that describes a file or directory. It does **not** contain the actual contents of the file, but rather the "directions" to find it.

* **Contents:** It stores metadata: file size, owner, permissions, timestamps, and—most importantly—**pointers** to the disk blocks where the data is actually stored.
* **Identification:** Every file has exactly one inode number. You can see this by running `ls -i` in a terminal.
* **The Disconnect:** The filename itself is not stored in the inode; filenames are stored in directory files that map a name to an inode number.
* **Analogy:** The inode is the "library card" in a catalog. It tells you the book's title and author, and exactly which "shelves" (blocks) the pages are sitting on.

---

## Summary Comparison

| Feature | Sector | Block | Inode |
| --- | --- | --- | --- |
| **Layer** | Hardware (Physical) | OS (Logical) | File System (Metadata) |
| **Defined By** | Manufacturer (HDD/SSD) | Operating System / Format | File System (Ext4, XFS, etc.) |
| **Stores** | Raw binary data | User data (parts of files) | File info and block pointers |
| **Addressable** | By LBA (Logical Block Address) | By Block Number | By Inode Number |

### How they work together:

When you ask to read a file called `notes.txt`:

1. The OS looks at the directory to find the **Inode Number** for `notes.txt`.
2. It goes to the **Inode**, which lists which **Blocks** contain the data.
3. The OS translates those Block addresses into physical **Sectors** for the disk controller to read.

---

To see how these concepts live on your actual system, you can use a few standard Linux utilities. Since you are likely working with a typical Linux distribution, these commands will help you "see" the abstraction layers we discussed.

---

### 1. Viewing Inodes with `ls` and `stat`

The `ls` command normally hides the inode number, but the `-i` flag reveals it. The `stat` command provides even more metadata stored within that inode.

* **Try this:** `ls -i /etc/passwd`
* The first number in the output is the **Inode Index**.


* **Try this:** `stat /etc/passwd`
* This shows the **Inode number**, **Links** (how many filenames point to this inode), and the specific **Blocks** allocated to it.



---

### 2. Checking Block Size and File System Capacity

To see the logical **Block size** of your file system and how many total **Inodes** your disk can support, use `tune2fs` (for Ext4) or `df`.

* **View Block Size:** `sudo tune2fs -l /dev/sda1 | grep "Block size"`
* *Note: Replace `/dev/sda1` with your actual partition.*


* **View Inode Usage:** `df -i`
* This is a "gotcha" for many sysadmins: you can run out of **Inodes** (too many tiny files) even if you have gigabytes of **Disk Space** left.



---

### 3. Finding the Physical Sector Size

To see the hardware layer—the **Sectors**—you need to query the block device directly using `fdisk`.

* **Try this:** `sudo fdisk -l`
* Look for a line that says: `Sector size (logical/physical): 512 bytes / 4096 bytes`.
* This tells you if your drive is using **Advanced Format (4K)** internally while emulating **512-byte** sectors for compatibility.



---

### Summary Table of Commands

| If you want to see... | Use this command |
| --- | --- |
| **Inode Number** | `ls -i [file]` |
| **Full Metadata** | `stat [file]` |
| **Inode Capacity** | `df -i` |
| **Logical Block Size** | `blockdev --getbsz /dev/[device]` |
| **Physical Sector Size** | `smartctl -a /dev/[device]` or `fdisk -l` |

---

TODO: how **hard links** vs. **symbolic links** interact with these inode numbers

---

# FileSystem Info

To view file system information for a specific partition in Linux, you generally use tools that query the **superblock** (for metadata like block size and inode counts) or tools that query the **kernel's mount table** (for usage and mount options).

The command you choose often depends on whether the partition is currently **mounted** or **unmounted**.

---

### 1. For Mounted Partitions: `df` and `findmnt`

If the partition is active and mounted, these are the quickest ways to see high-level stats.

* **View Inode and Block Usage:**
`df -h /dev/sda1` (Human-readable space)
`df -i /dev/sda1` (Inode usage)
* **View Mount Options and FS Type:**
`findmnt /dev/sda1`
*This shows the target mount point, the file system type (ext4, xfs, btrfs), and options like `rw` (read-write) or `relatime`.*

---

### 2. For Ext4/Ext3/Ext2: `tune2fs`

If you are using the standard Linux Ext family, `tune2fs` provides the most exhaustive "under the hood" data.

* **Command:** `sudo tune2fs -l /dev/sda1`
* **What it reveals:**
* **Block count vs. Free blocks:** Exactly how many 4096-byte units are left.
* **Inode count:** The total "file capacity" of the partition.
* **Mount count:** How many times it has been mounted since the last `fsck` (file system check).
* **Features:** Specialized flags like `has_journal`, `extent`, or `64bit`.



---

### 3. For XFS: `xfs_info`

If you are on an Enterprise Linux system (like RHEL or CentOS) using XFS, `tune2fs` won't work.

* **Command:** `xfs_info /mnt/data` (Note: XFS tools usually require the **mount point**, not the device path).
* **What it reveals:** Details on **Allocation Groups (AGs)**, which is how XFS handles high-concurrency data writing.

---

### 4. Low-Level Device Info: `lsblk` and `blkid`

To see how the partition relates to the physical hardware and its unique identifiers.

* **View UUID and Type:** `blkid /dev/sda1`
*Crucial for editing `/etc/fstab` so the system mounts the correct disk even if the drive letter changes.*
* **View Topology:** `lsblk -f`
*Provides a clean, tree-like view of every partition, its file system type, UUID, and mount point.*

---

### Summary Checklist

| If you need to know... | Use this command |
| --- | --- |
| **Is it Ext4 or XFS?** | `lsblk -f` |
| **How many Inodes are left?** | `df -i` |
| **What is the logical Block Size?** | `sudo tune2fs -l /dev/xxx |
| **Is the disk Read-Only?** | `findmnt` |
| **The UUID for fstab?** | `blkid` |

---

## Viewing the Superblock

It is the most critical metadata structure in the filesystem, containing the "magic number" (a unique hexadecimal value that identifies the filesystem type), the block size, the total number of blocks, and the status of the drive.

Because the superblock is so vital, the filesystem stores multiple redundant copies of it across the partition. If the primary one at the beginning of the disk is corrupted, the system uses these backups to recover.

---

## 1. Using `dumpe2fs` (for Ext2/Ext3/Ext4)

The `dumpe2fs` utility is the standard way to dump the superblock information for the Ext family of filesystems.

* **View the primary Superblock:**
```bash
sudo dumpe2fs -h /dev/sda1

```


*The `-h` flag ensures you only get the "header" (superblock) info and not a list of every single block group.*
* **Look for the "Magic number":** In the output, look for `Filesystem magic number: 0xEF53`. This hex code confirms it is an Ext2/3/4 filesystem.

---

## 2. Using `tune2fs`

While `tune2fs` is often used to *change* parameters, its list function is excellent for viewing the primary superblock data in a clean format.

* **Command:**
```bash
sudo tune2fs -l /dev/sda1

```


*This will show you the block size, inode count, and "Filesystem features" (like `has_journal` or `extents`).*

---

## 3. Finding Backup Superblocks

If your filesystem is corrupted and won't mount, you need to find where the **backup magic blocks** are located.

* **Command:**
```bash
sudo mke2fs -n /dev/sda1

```

* **CRITICAL:** The `-n` flag is "dry-run" mode. It tells the utility to pretend it’s formatting the drive and show you where it *would* place the superblocks. **Never run this without `-n` on a drive with data.**
* The output will provide a list of block numbers (e.g., 32768, 98304) where backups reside.

---

## 4. The Hex Dump Method (Universal)

If you want to see the "Magic Number" at the raw byte level without relying on filesystem-specific tools, you can use `dd` and `hexdump`.

* **Command:**
```bash
sudo dd if=/dev/sda1 bs=1024 skip=1 count=1 | hexdump -C

```

* **Logic:** For Ext4, the superblock starts at an offset of 1024 bytes from the start of the partition.
* In the hex output, look at offset `0x38`. For Ext4, you should see `53 ef` (the bytes are swapped due to little-endianness).

---

### Summary of Magic Numbers

| Filesystem | Magic Number (Hex) |
| --- | --- |
| **Ext2/3/4** | `0xEF53` |
| **XFS** | `0x58465342` (ASCII for "XFSB") |
| **Btrfs** | `0x91236835` |
| **NTFS** | `0xEB52904E` |

---