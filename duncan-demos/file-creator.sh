# todo list
# declare an interpreter
#! /usr/bin/bash

help_function () {
        echo "the wrong arg was $1"
        echo "first arg is a number, second is a base name"
        echo "Sample usage: file-creator.sh 55 .txt"
}

create () {
	#how may, what base
	for ((i = 1 ; i <= $1 ; i++)); do
  		#echo "Counter: $i"
		if [ -f file-$i$2 ]; then
			echo "File already exists, not making"
		else 
			touch file-$i$2
		fi
	done
}

# read in two args - one tht defines how many, another base name

# which args will hold which values?
# check use gave me two args
# num_files=$1
if [ $# -eq 2 ]; then
	# check first arg is a num
	if [ $1 -gt 0 ]; then
		echo "Heard, I will create $1 files"
	else
		help_function $1
	fi	

	# check string for arg 2
	# check to see if the string given begins with a .
	if [ -n $2 ]; then
		echo "Heard, base name is $2"
	else
		help_function $2
	fi
	create $1 $2
else 
	echo "I said only two only args.  Bye."
	exit
fi

# function to print help

# function to create files

# test args for how many and naimed what
