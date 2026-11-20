You can use a command in support of your answer, but we are evaluating your written response.

1. A student runs the commands below to back up their repository. Why isn't the archive compressed, and what should the `tar` command have been?
```
$ tar -cvf site-backup.tar.gz ceg2350-lastname-f26
$ file site-backup.tar.gz
site-backup.tar.gz: POSIX tar archive (GNU)
```

2. A student extracts the site with the command below, but the browser still shows the Apache2 Default Page. Using the `tar -t` output, why, and what is one way to fix it?
```
$ sudo tar -xzf simple-site.tar.gz -C /var/www/html
$ tar -tzf simple-site.tar.gz
simple-site/
simple-site/about.html
simple-site/contact.html
simple-site/index.html
simple-site/styles/
simple-site/styles/style.css
```

3. From their laptop, a student connects with `sftp` to download their backup from the AWS instance and sees the output below. Why did it fail, and what command should they have used?
```
sftp> ls
ceg2350-lastname-f26    site-backup.tar.gz
sftp> put site-backup.tar.gz
stat local "site-backup.tar.gz": No such file or directory
```

4. Given the output below, the browser returns `403 Forbidden` when visiting the instance's public IP. Why, and what should the permissions on `/var/www/html` be?
```
$ ls -ld /var/www/html
drwxrwx--- 2 ubuntu ubuntu 4096 Nov 10 09:12 /var/www/html
$ ls -l /var/www/html/index.html
-rw-rw-r-- 1 ubuntu ubuntu 1203 Nov 10 09:14 /var/www/html/index.html
```

5. Logged into the instance as `ubuntu`, a student creates the user `kay`, runs `vim ~/.ssh/authorized_keys`, and appends their new public key. From their laptop, `ssh -i ~/.ssh/lab11key kay@54.210.33.12` returns `Permission denied (publickey)`, but `ssh -i ~/.ssh/lab11key ubuntu@54.210.33.12` works. Why?

6. Why does `ssh` refuse to use the key below, and how do you fix it?
```
$ ssh -i ~/.ssh/lab11key kay@54.210.33.12
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@         WARNING: UNPROTECTED PRIVATE KEY FILE!          @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
Permissions 0644 for '/home/student/.ssh/lab11key' are too open.
This private key will be ignored.
```

7. Given the `~/.ssh/config` entry below, `ssh ceg-kay` connects, but `ssh kay@54.210.33.12` returns `Permission denied (publickey)`. Why isn't the `config` entry used for the second command?
```
Host ceg-kay
    HostName 54.210.33.12
    User kay
    IdentityFile ~/.ssh/lab11key
```


9. Given the `ip a` output below from an AWS instance, what is the subnet mask, and why does the instance's public IP (`54.210.33.12`) not appear anywhere in the output?
```
2: ens5: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 9001 qdisc mq state UP group default qlen 1000
    link/ether 0a:1b:2c:3d:4e:5f brd ff:ff:ff:ff:ff:ff
    inet 172.31.22.45/20 metric 100 brd 172.31.31.255 scope global dynamic ens5
```

10. A student's home public IP is `74.83.12.9`. For the SSH rule, they enter `74.83.12.9/16` as the source. Their `ssh` works, so what is wrong with the rule, and what should it be?

11. After updating the Security Group, a student can `ssh` to their instance from home and from campus. At a coffee shop, `ssh` hangs and eventually prints `Connection timed out`. Why, and why does it time out instead of saying `Connection refused`?

12. From a phone hotspot, a student runs the commands below against their instance. Is the server down? Explain using the Lab 12 Security Group rules.
```
$ ping -c 4 54.210.33.12
4 packets transmitted, 0 received, 100% packet loss
$ curl http://54.210.33.12
<!DOCTYPE html>
<html> ...
```

15. While running `tcpdump` against `wttr.in`, a student can read the weather report in the packets from `curl http://wttr.in`, but the packets from `curl https://wttr.in` are unreadable. Why?

16. `nslookup ipinfo.io` returns `34.117.59.81`, but `nslookup 34.117.59.81` does not return `ipinfo.io`. Why can a forward lookup and a reverse lookup of the "same" server give different answers?