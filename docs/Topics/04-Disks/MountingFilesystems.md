# How the Root Filesystem is Mounted

The process of loading the root file system (`/`) is a coordinated handoff between the hardware, the bootloader, and a temporary mini-operating system called the **initramfs**.

Because the kernel cannot read the hard drive until it has the proper drivers—and the drivers are usually stored *on* the hard drive—Linux uses a "bootstrap" method to bridge the gap.

---

### 1. The Kernel and the Initramfs

Once the bootloader (usually **GRUB**) loads the Linux kernel into memory, it also loads a compressed archive called the **initramfs** (Initial RAM File System).

* **What it is:** A tiny, temporary file system that lives entirely in RAM.
* **What it contains:** Essential kernel modules (drivers for storage controllers like NVMe, SATA, or RAID), networking scripts, and the basic tools needed to find the real disk.

---

### 2. Finding the "Real" Root

Inside the initramfs, a script (often named `init`) runs. Its job is to find the physical partition that contains the actual `/` file system. It uses parameters passed from the bootloader, such as:

* `root=UUID=550e8400-e29b-...`
* `root=/dev/nvme0n1p2`

The kernel uses its built-in drivers or the modules loaded from the initramfs to "see" the hardware devices and identify the correct UUID.

---

### 3. Mounting the Superblock

Once the device is identified (e.g., `/dev/sda1`), the kernel performs a **mount** operation:

1. **Read the Superblock:** The kernel reads the "magic block" at the start of the partition to identify the filesystem type (Ext4, XFS, etc.) and its geometry.
2. **Verify Integrity:** It checks the "clean" flag in the superblock. If the system crashed previously, it might trigger a filesystem check (`fsck`) at this stage.
3. **Root Inode:** The kernel locates **Inode #2** (the standard inode for the root directory `/`) to begin mapping the file tree.

---

### 4. The "Switch Root" (The Great Handoff)

This is the most critical step. The system is currently running off the RAM-based initramfs, but it needs to transition to the disk-based filesystem.

* The kernel uses a command called `switch_root` (or `pivot_root`).
* It moves the mount point of the real disk to `/`.
* It then removes the temporary initramfs from memory to save space.

---

### 5. Starting Init (systemd)

Now that the real `/` is mounted, the kernel looks for the first user-space program to run, typically located at `/sbin/init` (which is usually a symbolic link to **systemd**).

Systemd then takes over, reading `/etc/fstab` to mount all other filesystems (like `/home` or `/var`) and starting the background services (daemons) that make the system functional.

---

### Summary of the "Chain of Trust"

| Component | Responsibility |
| --- | --- |
| **Bootloader** | Loads Kernel and Initramfs into RAM. |
| **Initramfs** | Provides the drivers to "talk" to the hard drive. |
| **Kernel** | Reads the Superblock and mounts the physical partition. |
| **switch_root** | Swaps the temporary RAM-disk for the real disk. |
| **systemd** | Starts the OS services from the real disk. |

---

# When is `fstab` used?

While the kernel and the bootloader handle the "magic" of mounting the **root (/)** filesystem, `/etc/fstab` (the Filesystem Table) comes into play immediately afterward during the **User Space** initialization.

Think of it as a two-stage process: the kernel gets the "foundation" (the root) ready, and then `systemd` (or your init system) uses `fstab` to build the rest of the "house."

---

### 1. The Timing: Post-Switch Root

The system cannot read `/etc/fstab` until the root filesystem is already mounted.

1. **Kernel/Initramfs:** Mounts `/` (the root) using the `root=` parameter from the bootloader.
2. **The Handoff:** The system performs the `switch_root` to the real disk.
3. **The Read:** Once the real disk is `/`, the init process (systemd) finally has access to the file path `/etc/fstab`.

---

### 2. How systemd Uses fstab

Modern Linux systems use **systemd**, which doesn't just "read" the fstab file; it converts it.

* **Generator Phase:** During early boot, a tool called `systemd-fstab-generator` runs. It parses `/etc/fstab` and dynamically creates **systemd mount units** (e.g., `home.mount` or `data.mount`) in a temporary directory (`/run/systemd/generator/`).
* **Dependency Mapping:** Systemd uses these units to figure out the order of operations. For example, if you have a separate partition for `/var/log`, it knows it must mount `/var` before it can mount `/var/log`.

---

### 3. The Mounting Sequence

Once the generators have finished, the system starts the `local-fs.target`. This is the point in the boot sequence where:

1. **Integrity Check:** The system looks at the `pass` column (the 6th field) in `fstab` to see if it needs to run `fsck` on those partitions.
2. **Mounting:** It executes the mount commands for all entries that do not have the `noauto` option.
3. **Remote Filesystems:** Later in the boot process, after the network is up, it reaches the `remote-fs.target` and mounts things like NFS or SMB shares defined in `fstab`.

---

### 4. What happens if fstab is wrong?

Because `fstab` is processed so early, errors can be critical:

* **Missing Critical Partition:** If a partition marked with default options (which implies `auto`) fails to mount, the system may drop into **Emergency Mode** (a bare-bones shell) because it considers the system state "incomplete."
* **The `nofail` Option:** If you have an external drive or a non-essential partition, adding `nofail` to the options column in `fstab` tells the system to keep booting even if that specific device is missing.

---

### Summary Table: / vs. fstab

| Feature | Root (/) Mounting | fstab Mounting |
| --- | --- | --- |
| **Triggered By** | Kernel / Initramfs | systemd (Init System) |
| **Source of Info** | Bootloader (GRUB) cmdline | `/etc/fstab` file |
| **Target** | Only the Root partition | `/home`, `/var`, `/tmp`, swap, etc. |
| **Error Result** | Kernel Panic (VFS: Unable to mount) | Emergency Mode / Maintenance Shell |

---

# Making entries in `/etc/fstab`

Creating an entry in `/etc/fstab` requires a specific six-field syntax. Each field tells the system exactly how to handle the device during the boot process.

Before you start, you need the **UUID** (Universally Unique Identifier) of the partition. While you can use device names like `/dev/sdb1`, these can change if you plug in a new drive. UUIDs are permanent.

### Step 1: Get the Partition UUID

Run the following command to find the UUID and the filesystem type (TYPE) of your target partition:

```bash
lsblk -f

```

*Take note of the UUID string (e.g., `550e8400-e29b-41d4-a716-446655440000`) and the FSTYPE (e.g., `ext4`).*

---

### Step 2: The fstab Syntax

An entry consists of six fields separated by tabs or spaces:

| Field | Purpose | Example |
| --- | --- | --- |
| **1. Device** | The UUID or device path | `UUID=1234-abcd-...` |
| **2. Mount Point** | Where the folder lives in `/` | `/mnt/backup` |
| **3. Filesystem** | The format of the partition | `ext4` |
| **4. Options** | Mount behavior (read/write, etc.) | `defaults` |
| **5. Dump** | Used by backup tools (rarely used) | `0` |
| **6. Pass** | Order for `fsck` disk check | `2` |

---

### Step 3: Common Options (Field 4)

While `defaults` works for most cases, you can customize behavior:

* **`defaults`**: Includes `rw` (read-write), `suid`, `dev`, `exec`, `auto`, `nouser`, and `async`.
* **`nofail`**: If the drive is missing (like a USB drive), the system will continue booting instead of hanging.
* **`ro`**: Mounts the filesystem as Read-Only.
* **`noatime`**: Stops the system from writing "last accessed" timestamps to files (improves performance on SSDs).

---

### Step 4: Adding the Entry

1. **Create the mount point:** `sudo mkdir -p /mnt/my_data`
2. **Open fstab:** `sudo nano /etc/fstab`
3. **Add your line at the bottom:**
```text
UUID=your-uuid-here  /mnt/my_data  ext4  defaults,nofail  0  2

```


4. **Save and Exit:** (In Nano, press `Ctrl+O`, `Enter`, then `Ctrl+X`).

---

### Step 5: Test Without Rebooting (Critical)

**Never reboot immediately after editing fstab.** If there is a typo, your system might fail to boot.

Run this command to test the configuration:

```bash
sudo mount -a

```

* **If it returns nothing:** Success! The entry is correct and the drive is mounted.
* **If it returns an error:** Re-examine your `/etc/fstab` for typos or incorrect UUIDs before you restart.


# Viewing `initramfs` and the Boot Loader (GRUB)

To view these components, you have to peel back the layers of the boot process. One lives as a compressed archive on your `/boot` partition, and the other is a configuration file that dictates what you see on your monitor before Linux even starts.

---

## 1. Viewing the Initramfs

The `initramfs` is usually a compressed **CPIO** archive located in `/boot`. You cannot simply `cat` it; you need to decompress it or use a specialized tool to peek inside.

### The Easy Way: `lsinitramfs`

Most Debian/Ubuntu-based systems include a utility that lists the contents without manual decompression.

* **Command:** ```bash
lsinitramfs /boot/initrd.img-$(uname -r) | less
```

```


* **What to look for:** Look for the `scripts/` directory (where the boot logic lives) and `lib/modules/` (where the drivers for your storage and file systems are stored).

### The Manual Way (Extracting)

If you want to actually read the scripts inside, you can extract it to a temporary folder:

1. **Create a workspace:** `mkdir /tmp/initrd && cd /tmp/initrd`
2. **Extract:** `unmkinitramfs /boot/initrd.img-$(uname -r) .`
3. **Explore:** You can now `cd` into the folders and use `cat` to read the `init` script that handles the "switch root" process.

---

## 2. Viewing the Bootloader Menu (GRUB)

The "menu" you see at boot is generated by **GRUB**. While the active configuration is a complex script, the human-readable source is much easier to digest.

### The "Source" Configuration

On modern Linux systems, you should look at `/etc/default/grub`. This file controls the menu timeout, the default OS, and kernel parameters (like `root=UUID...`).

* **Command:** `cat /etc/default/grub`
* **Key Line:** `GRUB_TIMEOUT=5` (how long the menu stays up) and `GRUB_CMDLINE_LINUX_DEFAULT` (the options passed to the kernel).

### The "Active" Compiled Script

The actual file GRUB reads at boot is `/boot/grub/grub.cfg`.

* **Warning:** **Do not edit this file manually.** It is automatically generated by the `update-grub` command.
* **Command to view:** `less /boot/grub/grub.cfg`
* **What to look for:** Search for the word `menuentry`. This block defines each line you see on your boot screen, including the `linux` and `initrd` lines that point to the files we discussed earlier.

---

## 3. Testing Changes Safely

If you decide to modify your `fstab` or your GRUB configuration, you can verify your work before a reboot "breaks" the system:

* **For fstab:** Run `sudo mount -a`. If it returns no errors, your `fstab` syntax is correct and the partitions are mountable.
* **For GRUB:** After editing `/etc/default/grub`, you **must** run `sudo update-grub` to push those changes into the actual boot script.

---

### Summary Checklist

| Component | Primary Location | Command to View |
| --- | --- | --- |
| **Initramfs** | `/boot/initrd.img-...` | `lsinitramfs` |
| **GRUB Settings** | `/etc/default/grub` | `cat` |
| **GRUB Menu Logic** | `/boot/grub/grub.cfg` | `less` |
