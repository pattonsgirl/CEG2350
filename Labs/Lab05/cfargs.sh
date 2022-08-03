#!/bin/bash
# Usage: fsarg.sh 10 spaces .
# fsargs.sh spaces 5 .
# Problems: order matters.  Entering an argument wrong will lead to disaster

echo "$1 files with added mistake of $2 in directory $3"

if [[ -z $1 ]] || [[ -z $2 ]] || [[ -z $3 ]]; then
	echo "No."
	exit
fi

# should check args have content
# need to check directory existence

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
