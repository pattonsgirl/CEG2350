## Lab 08

- Name:
- Email:

Instructions for this lab: https://pattonsgirl.github.io/CEG2350/Labs/Lab08/Instructions.html

## Part 1 - `ssh` `config` file

1. `ssh` commands for connecting to each of your sandboxes:
```bash
# to connect to original sandbox with cloned GitHub repo:

# to connect to new sandbox for this lab:

```

2. Options commonly used in a `config` file for `ssh`:

| `ssh` `config` Option   | Description  |
|---------------|------------------------|
| `Host`        |                        |
| `HostName`    |                        |
| `User`        |                        |
| `Port`        |                        |
| `IdentityFile`|                        |

3. `ssh` `config` file contents:
```
# entry to connect to original sandbox with cloned GitHub repo:

# entry to connect to new sandbox for this lab:

```

4. `ssh` commands that make use of `config` file entries:
```bash
# to connect to original sandbox with cloned GitHub repo:

# to connect to new sandbox for this lab:

```

## Part 2 - What do we have?

1. Command:
```
Output here
```
2. Command:
```
Output here
```
3. For the `xvda` partition table:
    - Does it use MBR or GPT?
    - How many partitions are on the block device?
    - What is the largest partition?
4. Command:
```
Output here
```
5. For the primary partition:
    - What partition is the root filesystem on?
    - What is the partition label?
    - What type of filesystem is on the partition?
6. Command:
```
Output here
```
7. For the root filesystem:
    - What is the total size?
    - How much space is used?
    - Where is it mounted to?
8. Command:
```
Output here
```
9. Fields & purpose of fields in entry that mount the root filesystem


## Part 3 - Something new

1. `gdisk` main menu options

| `gdisk` option | function |
| ---            | ---      |
| `p` |     |
| `o` |     |
| `n` |     |
| `i` |     |
| `w` |     |

2. Steps to create a partition table and partition on `xvdb`

3. Partition table on `/dev/xvdb`
```
Paste partition table information here
```

4. Answer these questions:
   
   a. What device name does the partition use?
      - Answer: 
        
   b. What size is the partition in GB?
      - Answer: 
        
   c. What filesystem type will be used on the partition?
      - Answer: 

## Part 4 - File it away

1. Commands used:
2. Commands used:
```
output here
```
3. Commands used:
4. Commands used:
5. Contents of `/mnt/expanse`:
```
list here
```
6. Commands used:
7. When can I interact with files on the filesystem on the partition in `xvdb`?
   - Answer:
   
## Part 5 - Take a `fstab` at this

1. Commands used:
2. Line you added to `/etc/fstab`:
3. How did you confirm that the mount point changed? (Commands used or explain process):
4. **If you restored `/etc/fstab`**, write here why you did not feel comfortable leaving your changes in place


## Part 6 - What is dead may still be read

1. Commands used:
2. What does the `strings` command do?
   - Answer:
3. Write a short explanation of what you saw in `strings` output:
4. Commands used:
5. Is the secret you deleted still showing up in the `strings` output?
6. What does the `shred` command do?
   - Answer:

### Report: How to Permanently Delete a File

**Write your report here**

## Part 7 - Citations / Resources

Add citations / resources for each core topic covered in this lab

## Extra Credit - Create a Virtual Filesystem

Report on how to perform (and verify completion) of making a virtual filesystem on a loop device

