## Git / GitHub Workflow & Command Line (Lab 01)

1. What is the difference between a commit and a sync (push)?

2. Explain the difference between an absolute path and a relative path to a directory. Why does it matter which one you use when navigating from your home directory into DirA?

3. Explain the difference between `cp` and `mv`

4. You're asked to delete Dir B and the file fodder.txt inside it using a single command. Explain why a plain rm Dir B would fail, and what about rm's behavior requires you to change your approach.

## Linux Permissions (Lab 02)

5. Explain what the three permission categories (owner, group, other) mean and why a system would separate permissions this way instead of just having a single "allowed users" list.

6. Compare chmod 751 program to chmod a=w snow.md. For each, explain what it does and whether you'd consider it a reasonable choice for that file, defending your reasoning the way the lab's rubric expects.

7. Explain, in your own words, why a plain text file having execute permission is usually a red flag, using chmod 777 file.txt as your example.

## Users, Groups, and Privilege (Lab 02)

8. After creating a new user bob with adduser, explain why bob can write files into his own home directory without sudo, but ubuntu might not be able to write into bob's home directory without sudo. What permission concept explains both halves of that?

9. Describe what it means to add both ubuntu and bob to a group called squad, and explain what additional step (beyond just creating the group) is required before members of squad can actually read and modify files inside a shared folder.
ubuntu can run sudo without a password, but bob cannot run sudo at all by default. 

10. Explain the underlying reason for this difference, and describe what you would need to check or change to give bob similar sudo privileges.