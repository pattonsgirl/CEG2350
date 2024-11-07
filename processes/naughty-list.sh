date >> /home/ubuntu/naughty-list.txt
grep "Invalid user" /var/log/auth.log | awk '{print $(NF-4), $(NF-2)}' | sort | uniq -c | sort -nr >> /home/ubuntu/naughty-list.txt
