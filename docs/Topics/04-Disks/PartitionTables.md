# Partition Tables

A partition table is essentially the **"Map of the World"** for your hard drive. It tells the BIOS or UEFI exactly where one partition ends and the next begins. Without it, the computer would see the entire disk as a giant, unorganized pile of raw binary data.

There are two main standards you will encounter: **MBR (Master Boot Record)** and **GPT (GUID Partition Table)**.

---

### 1. MBR (Master Boot Record)

Introduced in 1983, MBR is the "Legacy" standard. It stores the partition table in the very first sector of the disk (Sector 0).

* **Partition Limits:** You can only have **4 Primary partitions**. To have more, you must create an "Extended" partition and fill it with "Logical" drives.
* **Size Limit:** It uses 32-bit addressing, which limits the total disk size to **2 Terabytes (2 TB)**.
* **Single Point of Failure:** The partition map is stored in only one place. If Sector 0 is corrupted, the entire disk "disappears" to the OS.

---

### 2. GPT (GUID Partition Table)

GPT is the modern standard that replaced MBR. it is part of the **UEFI** (Unified Extensible Firmware Interface) standard.

* **Partition Limits:** In Linux, GPT supports up to **128 partitions** by default, with no need for "logical" or "extended" hackery.
* **Size Limit:** It uses 64-bit addressing, allowing for disks up to **9.4 Zettabytes** (essentially limitless for current technology).
* **Redundancy:** GPT stores a backup copy of the partition table at the very end of the disk. If the primary header is damaged, the system can automatically recover.
* **CRC Protection:** It uses cyclic redundancy checks to detect if the partition table itself has been corrupted.

---

### 3. Key Components of a Partition Table

Regardless of the type, every entry in a partition table contains four vital pieces of information:

1. **Start Sector:** The physical address where the partition begins.
2. **End Sector:** The physical address where it stops.
3. **Type Code/UUID:** A code that tells the OS what is inside (e.g., `83` for Linux, `07` for NTFS, or a long UUID for GPT).
4. **Bootable Flag:** A marker (mostly used by MBR) indicating which partition contains the bootloader.

---

### 4. How to View Your Partition Table

You can use several tools to see which "map" your drives are currently using:

* **`lsblk -m`**: Shows the alignment and basic layout.
* **`sudo fdisk -l`**: Lists all disks. Look for the "Disklabel type" line. It will say either `dos` (which means MBR) or `gpt`.
* **`sudo parted -l`**: Provides a very clean view of the "Partition Table" type.

---

### Summary Comparison

| Feature | MBR (Legacy) | GPT (Modern) |
| --- | --- | --- |
| **Max Disk Size** | 2 TB | 9.4 ZB (Zettabytes) |
| **Max Partitions** | 4 Primary | 128+ |
| **Redundancy** | None (Risk of data loss) | Backup header at end of disk |
| **Firmware** | BIOS | UEFI |
| **Identifier** | 32-bit Disk ID | 128-bit GUID |

---

# `gdisk`, `fdisk`, and `parted`

When managing partitions from the CLI, the tool you choose often depends on whether you are dealing with "Legacy" MBR disks or modern GPT disks. While they all perform the same basic task—editing the partition table—their interfaces and safety mechanisms differ significantly.

---

## 1. fdisk (The Classic)

`fdisk` is the most famous partitioning tool in the Linux world. For decades, it was strictly for MBR disks, but modern versions (util-linux 2.26+) now have full support for GPT.

* **Interface:** Menu-driven. You type a single-letter command (e.g., `n` for new, `d` for delete) and follow the prompts.
* **Safety:** **Buffered.** Your changes are kept in memory. Nothing is written to the physical disk until you explicitly type `w` (write). If you make a mistake, you can simply quit with `q` without saving.
* **Best For:** Quick edits on standard MBR or GPT disks where you want a safety net before committing changes.

---

## 2. gdisk (The GPT Specialist)

`gdisk` (GPT fdisk) was created specifically to handle GPT disks with the same user-friendly menu style as `fdisk`.

* **Interface:** Nearly identical to `fdisk`. If you know one, you know the other.
* **Specialty:** It is the best tool for **converting MBR to GPT** without data loss and for repairing corrupted GPT headers using the "experts" menu (`x`).
* **Safety:** **Buffered.** Like fdisk, it doesn't write to the disk until you give the `w` command.
* **Best For:** Any task involving GPT disks, especially advanced recovery or conversion.

---

## 3. parted (The Power User / Scripting Tool)

`parted` (Partition Editor) is a more versatile tool that supports many partition table types (MBR, GPT, Sun, Mac, etc.) and is unique because it can **resize** partitions.

* **Interface:** Command-line driven. It can be used interactively or as a single-line command (making it perfect for Bash scripts).
* **Safety:** **Live/Immediate.** Unlike the others, `parted` writes changes to the disk **immediately** after you hit Enter on a command. There is no "undo" or "write" step.
* **Specialty:** It handles very large disks better than older tools and is the go-to for automation and resizing.
* **Best For:** Scripting, automation, and resizing existing partitions.

---

## Feature Comparison Table

| Feature | fdisk | gdisk | parted |
| --- | --- | --- | --- |
| **Primary Table** | MBR (now GPT) | GPT Only | Both + others |
| **Commit Style** | Buffered (Save at end) | Buffered (Save at end) | **Live (Immediate)** |
| **Ease of Use** | High (Menu-driven) | High (Menu-driven) | Moderate (CLI-driven) |
| **Scripting** | Difficult (needs `printf`) | Difficult | **Excellent** |
| **Resize Support** | No (Delete/Recreate) | No | **Yes** |
| **MBR to GPT Conv.** | No | **Yes** | No |

---

### Which one should you use?

* **If you are a beginner:** Use **fdisk**. The "save at the end" workflow prevents accidental data loss.
* **If you are working on a modern UEFI system:** Use **gdisk** or **fdisk**.
* **If you are writing a script** to automate a server deployment: Use **parted**.
* **If you need to shrink a partition:** Use **parted** (though often `gparted`—the GUI version—is safer for this specific task).

---

# The Boot Partition

The **boot partition** (often mounted at `/boot`) is a dedicated section of your storage drive that contains the essential files needed to start the Linux operating system.

While the "root" (`/`) partition holds your applications and data, the boot partition is the "key" that starts the engine. It must be readable by the bootloader (GRUB) before the full operating system is even loaded.

---

### 1. What stays inside the Boot Partition?

The `/boot` directory typically contains four critical types of files:

* **The Linux Kernel (`vmlinuz`):** The core of the OS. This is the actual executable file that the bootloader runs to start Linux.
* **The Initramfs (`initrd.img`):** The temporary RAM-based filesystem that contains the drivers needed to find and mount your real root partition.
* **The Bootloader Configuration (`grub/`):** The menu settings, themes, and "map" that tell GRUB where the kernels are located on the disk.
* **System Map and Config:** Files like `System.map` and `config-x.x.x` which contain kernel symbol tables and the parameters used when the kernel was compiled.

---

### 2. Why is it often a separate partition?

In modern Linux installations, `/boot` is frequently its own small partition (usually **512 MB to 1 GB**) rather than just a folder on the root drive. There are three main reasons for this:

1. **Bootloader Limitations:** Older BIOS systems and some bootloaders cannot read certain advanced file systems (like encrypted LUKS volumes, complex LVM setups, or Btrfs/ZFS arrays). By making `/boot` a simple **Ext4** or **FAT32** partition, the bootloader can easily find the kernel.
2. **Encryption:** If your entire root partition is encrypted, the computer can’t read the kernel to start the decryption process. A plain-text boot partition holds the "unlocking" tools (initramfs) needed to ask you for your password.
3. **Stability:** Keeping the boot files separate prevents them from being accidentally overwritten if the root partition fills up or becomes corrupted.

---

### 3. The EFI System Partition (ESP) vs. /boot

On modern **UEFI** systems (almost all computers made after 2012), you will actually see two "boot-related" partitions:

* **The EFI Partition:** A small FAT32 partition where the UEFI firmware looks for the `.efi` bootloader files.
* **The Boot Partition:** Where the Linux-specific kernels and initrd files live.
* *Note:* In some distributions (like Arch Linux or Pop!_OS), these are combined into one single partition mounted at `/boot` or `/boot/efi`.

---

### 4. Managing the Boot Partition

Because the boot partition is small, it can eventually "fill up" as you update your system. Every time you update your Linux kernel, a new `vmlinuz` and `initrd` file are added.

* **The Danger:** If the boot partition reaches 100% capacity, future kernel updates will fail, which can leave your system in a "broken" state during the next reboot.
* **The Solution:** Most modern distributions (like Ubuntu and Fedora) automatically remove old kernels, but you can manually check space using `df -h /boot`.

---

### Summary Checklist

| Property | Typical Value |
| --- | --- |
| **Mount Point** | `/boot` |
| **Recommended Size** | 512 MB – 1024 MB |
| **File System** | Ext4 (Standard) or FAT32 (EFI) |
| **Primary Files** | `vmlinuz`, `initrd.img`, `grub.cfg` |

---

# Bonus: Cleaning up kernels

To manage your boot partition, you need to identify which kernels are currently installed and which one you are actively using. Deleting the kernel you are currently running will crash your system, so we must be precise.

### 1. Identify Your Active Kernel

Before deleting anything, check which kernel version is currently loaded into RAM:

```bash
uname -r

```

**Take note of this version.** You must never remove the files associated with this number.

---

### 2. View Files in the Boot Partition

You can see exactly how much space each kernel and its associated "initrd" (Initial RAM Disk) is taking up:

```bash
du -sh /boot/vmlinuz* /boot/initrd*

```

* **vmlinuz:** The compressed Linux kernel.
* **initrd.img:** The temporary filesystem (this is usually the largest file in `/boot`).

---

### 3. Check for "Orphaned" Kernels

Most modern Linux distributions use a package manager (like `apt` or `dnf`) to track kernels. To see all installed kernels (even those you aren't using):

**On Debian/Ubuntu:**

```bash
dpkg --list | grep linux-image

```

**On RHEL/CentOS/Fedora:**

```bash
rpm -q kernel

```

---

### 4. Safely Remove Old Kernels

**Do not use the `rm` command** to delete files in `/boot`. If you manually delete the files, the package manager will think the kernel is still there and may cause errors during future updates.

#### The "Automatic" Way (Recommended)

Most systems have a built-in "autoremove" feature that keeps the current kernel and the one previous (as a backup) while deleting everything else.

```bash
# For Ubuntu/Debian
sudo apt autoremove --purge

# For Fedora/RHEL
sudo dnf autoremove

```

#### The "Manual" Way (If autoremove fails)

If your `/boot` is 100% full, `apt` might fail because it can't write temporary files. In this specific case, you can manually remove a specific old version:

```bash
sudo apt purge linux-image-5.15.0-XX-generic

```

*(Replace `5.15.0-XX` with an old version number you found in step 3, ensuring it is NOT the one from `uname -r`).*

---

### 5. Final Step: Update the Bootloader

After removing kernels, you must tell the GRUB bootloader that those options are gone so they don't appear in the menu when you restart.

```bash
sudo update-grub

```

*(On Fedora/RHEL, this is usually `sudo grub2-mkconfig -o /boot/grub2/grub.cfg`).*

---

### Summary Checklist

| Action | Command |
| --- | --- |
| **Check Active Kernel** | `uname -r` |
| **Check Disk Space** | `df -h /boot` |
| **Clean Old Kernels** | `sudo apt autoremove` |
| **Sync Bootloader** | `sudo update-grub` |

---
