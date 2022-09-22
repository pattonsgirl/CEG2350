#!/bin/bash

# The following script reads 3 arguments
# Number of files
# Type of mistake: "spaces" or "spelling"
# Where to create files (in what folder)

# Usage:
# cfargs.sh spaces 5 .

# Problems: 
# order matters.  Entering an argument in wrong order will lead to disaster

echo "$1 files with added mistake of $2 in directory $3"

# if arguments are empty, abort program
# TODO: did we need to check all 3?
if [[ -z $1 ]] || [[ -z $2 ]] || [[ -z $3 ]]; then
	echo "No files for you"
	exit
fi

# TODO: check directory existence, stored in arg 3

#for i in {1..$1}
for (( i=0; i<=$1; i++ ))
do
	echo $i
	if [[ $2 == "spaces" ]]; then
		touch $3/"$i file name.txt"
	elif [[ $2 == "spelling" ]]; then
		touch $3/"$i-pic.jgp"
	else
		echo "Bad: $2"
	fi
done
