#!/bin/bash
echo "Going to create 30 files in current directory"
echo "You good with that? (y/n)"
read choice

if [[ -z $choice  ]]
then
	echo "No choice made.  Exiting..."
	exit
elif [[ $choice = "n"  ]]
then
	echo "Not good.  Aborting."
	exit
elif [[ $choice = "y" ]]
then
	echo "Deploying files"
else
	echo "Bad option.  Exiting..."
	exit
fi

for i in {1..10}
do
	echo $i
	touch "$i file name.txt"
	touch "$i-pic.jgp"
	touch "$i-foo.txt"
done
