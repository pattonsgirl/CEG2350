# Virtual Disks

Virtual disks—whether you're looking at an **AWS EBS volume**, a **VMware VMDK**, or a **QEMU QCOW2** file—are the ultimate magic trick of modern computing. They convince an Operating System that it is talking to physical hardware (heads, platters, and sectors) when it is actually just writing to a file or a network stream.

Here is the breakdown of how that abstraction layer is built.

---

### 1. The Virtualization Layer (The Lie)

In a physical machine, the Kernel sends a command to a disk controller (SATA/NVMe). In a Virtual Machine (VM), the **Hypervisor** (KVM, Xen, Hyper-V) intercepts that command.

* **The Emulated Device:** The VM sees a "Generic VirtIO Disk" or a "SCSI Controller."
* **The Mapping:** When the VM writes to "Sector 500" of its virtual disk, the Hypervisor translates that into a specific offset inside a **disk image file** or a **network block.**

---

### 2. Format Types: Thick vs. Thin Provisioning

When you create a 100 GB virtual disk, you have to decide how that space is claimed on the physical host.

* **Thick Provisioning (Fixed):** The system immediately allocates all 100 GB of physical space. It's faster because the space is already "reserved," but it's wasteful if you only use 10 GB.
* **Thin Provisioning (Dynamic):** The disk file starts tiny (a few KB) and grows only as the VM writes data.
* *The Risk:* "Over-provisioning." You can tell ten VMs they each have 100 GB, even if you only have 500 GB of physical space. If they all fill up at once, the host crashes.



---

### 3. File-Based Disks (VMware/VirtualBox/KVM)

On a local hypervisor, a virtual disk is just a big file sitting on your host's filesystem.

* **RAW format:** A bit-for-bit image of a disk. No metadata, just data. Fast, but doesn't support snapshots.
* **QCOW2 (QEMU Copy-On-Write):** The standard for Linux virtualization. It supports **Snapshots**.
* **How it works:** When you take a snapshot, the original file becomes "read-only." All new writes go to a new "delta" file. This is why snapshots are nearly instantaneous.



---

### 4. Network Block Storage (AWS EBS / SAN)

This is how **AWS EBS (Elastic Block Store)** works. Your "disk" isn't even on the same physical server as your CPU.

* **The Connection:** The EBS volume lives on a massive storage cluster. It is connected to your EC2 instance over a high-speed dedicated network (NVMe over Fabrics).
* **Network Latency:** Because the data has to travel over a wire, AWS uses massive caching and optimized protocols to make it feel as fast as a local SSD.
* **Redundancy:** Behind the scenes, AWS replicates your "disk" across multiple physical hard drives in an Availability Zone. If one physical drive in their data center dies, your virtual disk doesn't even "hiccup."

---

### 5. Why use Virtual Disks? (The Benefits)

Virtualization gives us "Superpowers" that physical hardware doesn't have:

1. **Portability:** You can move a `.vmdk` file to a completely different server, and the OS will boot exactly the same way.
2. **Snapshots:** You can "save your game" before running a risky `sudo apt upgrade`. If it breaks, you revert in seconds.
3. **Live Resizing:** You can grow an EBS volume from 10 GB to 100 GB while the server is still running—no screwdriver required.
4. **Cloning:** You can "Template" a perfectly configured Linux OS and spawn 50 identical copies in minutes.

---

### Summary Comparison

| Feature | Local VM Disk (QCOW2/VMDK) | Cloud Block Storage (EBS) |
| --- | --- | --- |
| **Location** | File on Host Disk | Networked Storage Cluster |
| **Latency** | Extremely Low (Bus speed) | Low (Network speed) |
| **Scalability** | Limited by Host Disk | Nearly Infinite |
| **Redundancy** | Depends on Host RAID | Built-in Replication |
