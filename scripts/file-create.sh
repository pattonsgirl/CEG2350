#!/bin/bash

# function help: print a menu explaining what the script does and expected args

# function make_files: take number of files as arg, create that many files in format i_file.txt
make_files() {
	num=$1
	for ((i=1; i<=$num; i++)); do
		echo $i
		touch $2/"$i"_name.txt
	done
}


# note: fuctions are being declared BEFORE we get to main.  You can make main to make this less confusing
#
#

#main()

# get a directory name
read -p "give me dir" dir_name

echo $dir_name

# check if exists, create if not
if [[ ! -d $dir_name ]]; then
	echo "it doesn't exist!"
	mkdir $dir_name
fi


# confirm to user directory files will be made in - allow user to proceed or abort
path_to_dir=$PWD/$dir_name

answer="yes"
read -p "we good? (YES/no)" answer

if [ $answer = "no" ]; then
	exit
fi


# get number of files to create

read -p "give number of files" num_files

# loop to make that many files - for or while? 

make_files $num_files $path_to_dir


#main
