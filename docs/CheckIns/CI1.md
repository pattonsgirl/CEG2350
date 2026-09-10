## Git / GitHub Workflow & Command Line (Lab 01)

1. In git, what is the difference between / when should I use a commit versus a sync (push)?

2. Explain the difference between an absolute path and a relative path to a directory.

3. Explain the difference between `cp` and `mv`

4. Explain the when to use `rmdir boat-folder` vs `rm -r boat-folder`

5. Explain the difference between `ls` and `ls -lah`

## Linux Permissions (Lab 02)

6. Describe the permissions set by the following command with respect to user, groups, and other `chmod 751 program` 

7. Describe the permissions set by the following command with respect to user, groups, and other `chmod a=w snow.md`

## Users, Groups, and Privilege (Lab 02)

8. After creating a new user bob with adduser, explain why bob can write files into his own home directory without sudo, but ubuntu might not be able to write into bob's home directory without sudo. What permission concept explains both halves of that?

9. Describe what it means to add both ubuntu and bob to a group called squad, and explain what additional step (beyond just creating the group) is required before members of squad can actually read and modify files inside a shared folder.
ubuntu can run sudo without a password, but bob cannot run sudo at all by default. 

10. Explain the underlying reason for this difference, and describe what you would need to check or change to give bob similar sudo privileges.