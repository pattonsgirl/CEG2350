## Lab 08

- Name:
- Email:

Instructions for this lab: https://pattonsgirl.github.io/CEG2350/Labs/Lab08/Instructions.html

## Part 1 - What do we have?

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


## Part 2 - Something new

1. `gdisk` main menu options
   - `p`:
   - `o`:
   - `n`:
   - `i`:
   - `w`:
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

## Part 3 - File it away

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
   
## Part 4 - Take a `fstab` at this

1. Commands used:
2. Line you added to `/etc/fstab`:
3. How did you confirm that the mount point changed? (Commands used or explain process):
4. **If you restored `/etc/fstab`**, write here why you did not feel comfortable leaving your changes in place


## Part 5 - What is dead may still be read

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

## Extra Credit - Create a Virtual Filesystem

Report on how to perform (and verify completion) of making a virtual filesystem on a loop device

## Citations

To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.
