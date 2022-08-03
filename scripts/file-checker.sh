#!/usr/bin/bash
#echo "Please provide a filename"
#read filename
#filename=bonk
filename=$1

if [[ -e $filename ]] # or use $1
then
	echo "You found me!"
else
	echo "No luck."
fi
