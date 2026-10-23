You can use a command in support of your answer, but we are evaluating your written response.

1. Given the `lscpu` output below, how many physical cores and how many logical processors does this system have, and why are the two numbers different?
```
CPU(s):                  8
Thread(s) per core:      2
Core(s) per socket:      4
Socket(s):               1
```

2. A student looks at the `free -h` output below. How much memory is available and what fields did you use to make that conclusion?
```
               total        used        free      shared  buff/cache   available
Mem:           3.8Gi       1.2Gi       412Mi       2.0Mi       2.2Gi       2.4Gi
```

3. After finishing a Linux install in a VM and rebooting, you are dropped right back into the installer's "Try or Install" menu. Why, and what is one way to fix it?

4. Given the `lsblk` output below, why does `sudo mkfs.ext4 /dev/xvdb1` fail?
```
NAME     MAJ:MIN RM  SIZE RO TYPE MOUNTPOINTS
xvda     202:0    0    8G  0 disk
├─xvda1  202:1    0    7G  0 part /
├─xvda14 202:14   0    4M  0 part
├─xvda15 202:15   0  106M  0 part /boot/efi
└─xvda16 259:0    0  913M  0 part /boot
xvdb     202:16   0    1G  0 disk
```

5. A student runs `sudo gdisk /dev/xvdb`, uses `o` (clear partition data) and `n` (new partition) to set up a GPT table and one partition (1), then exits with `q`. Why does `lsblk` still show no `xvdb1`?

6. Given the `blkid` output below, why is it better to use the `UUID` in `/etc/fstab` instead of `/dev/xvdb1`?
```
/dev/xvdb1: UUID="3f1c9a2e-7b4d-4e8a-9c1f-2d6e8b0a5c47" BLOCK_SIZE="4096" TYPE="ext4" PARTLABEL="Linux filesystem" PARTUUID="a8e3d1f0-5c2b-4f7e-b9a6-1e0d4c3b2a19"
```

7. A student forgot to mount `xvdb1`, created `notes.txt` in `/mnt/expanse`, and then ran the command below. Why does `ls /mnt/expanse` no longer show `notes.txt`, and where is the file actually stored?
```
sudo mount /dev/xvdb1 /mnt/expanse
```

8. You run `rm /mnt/expanse/secret1.txt`, then sees the output below. Why is the secret still readable on the partition?
```
$ sudo strings /dev/xvdb1 | grep -i secret
My FAKE secret is that I still sleep with a nightlight
```

9. Given the output below, why does umount fail, and how do you fix it?
```
$ pwd
/mnt/expanse
$ sudo umount /mnt/expanse
umount: /mnt/expanse: target is busy.
```