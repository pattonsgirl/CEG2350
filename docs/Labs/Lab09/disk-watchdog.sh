#!/bin/bash
while true; do
  DISK_USAGE=$(df / | grep / | awk '{ print $5 }' | sed 's/%//')
  echo "Current Disk Usage: $DISK_USAGE%"
  if [ "$DISK_USAGE" -gt 70 ]; then
    echo "WARNING: High disk usage detected!"
  fi
  sleep 60
done