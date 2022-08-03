#!/bin/bash

usageGuide() {
	echo "Usage guide for file creator"
	echo "Sample: cfgetopts.sh -n 5 -t spelling ."
	printf "\t-n number of files\n"
	printf "\t-t type of error - spaces or spelling\n"
	echo "final arg = directory to create files"
}

#usageGuide

while getopts ":hn:t:" opt; do
	#echo "$OPTARG is currently stored in OPTARG"
	echo "$OPTIND is the index point in OPTIND"
	case $opt in
	h)
		usageGuide
		exit
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
	esac
done

# before echoing, check that both variables have contents.  If no contents, usage guide and exit
# SCARY PASTE CHANGES EVERYTHING
echo "dollar at before shift: $@"
shift $((OPTIND-1))
echo "They told me to run dollar at: $@"

echo "the user wants $num of files"
echo "files should have $error"

echo "the 5th value is: $5"

echo "OPTARG = $OPTARG"
echo "OPTIND = $OPTIND"
#for j in $@
#do
#	echo "arg - $j"
#done

if [[ -d $@ ]];then
	echo "Directory exists"
else
	echo "does not exit bye"
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

