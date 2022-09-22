#!/bin/bash

# function usageGuide prints usage guide on -h (help) option
# could use if bad options provided as well
usageGuide() {
	echo "Usage guide for file creator"
	echo "Sample: cfgetopts.sh -n 5 -t spelling ."
	printf "\t-n number of files\n"
	printf "\t-t type of error - spaces or spelling\n"
	echo "final arg = directory to create files"
}

# :hn:t:
# h is an option, does not require an arg (thus h)
# n is an option, does require an arg (thus n:)
# t is an option, does require an arg (thus t:)
# The leading colon:  switches getopts to "silent error reporting mode"
# So that you can handle errors yourself (think you handle Exceptions)
while getopts ":hn:t:" opt; do
	#echo "$OPTARG is currently stored in OPTARG"
	#echo "$OPTIND is the index point in OPTIND"
	case $opt in
	h)
		usageGuide
		exit 1
		;;
	n)	#echo $OPTARG
		num=$OPTARG
		;;
	t) 	
		error=$OPTARG
		;;
	\?)
      		echo "Invalid option: -$OPTARG" >&2
      		;;
	:)
      		# this is surprisingly useless.  Take out the arg for -n.
		# -t will then be read as the argument
		# Try it: cfgetopts.sh -n
		# Try it: cfgetopts.sh -n 5 -t
		echo "Option -$OPTARG requires an argument." >&2
      		exit 1
      		;;
	esac
done

# TODO: before echoing, check that both variables have contents.  
# If no contents, print usage guide and exit

# getopts has keep a running index of options checked so far
# move to end of scanned options - in this case with expected usage
# what "remains" is the folder specified
shift $((OPTIND-1))

echo "The user wants $num files"
echo "File names should have $error errors"
echo "Files should be created in $@"

if [[ -d $@ ]];then
	echo "Directory $@ exists"
else
	echo "Directory $@ does not exist bye"
	usageGuide
	exit	
fi

for (( i=1; i<=$num; i++ ))
do
	echo $i
	if [[ $error == "spaces" ]]; then
		touch $@/"$i file name.txt"
	elif [[ $error == "spelling" ]]; then
		touch $@/"$i-pic.jgp"
	else
		echo "Bad: $error"
	fi
done

