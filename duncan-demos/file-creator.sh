# todo list
# declare an interpreter
#! /usr/bin/bash

help_function () {
        echo "the wrong arg was $1"
        echo "first arg is a number, second is a base name"
        echo "Sample usage: file-creator.sh 55 .txt"
}

# read in two args - one tht defines how many, another base name

# which args will hold which values?
# check use gave me two args
if [ $# -eq 2 ]; then
	# check first arg is a num
	if [ $1 -gt 0 ]; then
		echo "Heard, I will create $1 files"
	else
		help_function $1
	fi	

	# check string for arg 2
	if [ -n $2 ]; then
		echo "Heard, base name is $2"
	else
		help_function $2
	fi
else 
	echo "I said only two only args.  Bye."
	exit
fi

# function to print help

# function to create files

# test args for how many and naimed what
