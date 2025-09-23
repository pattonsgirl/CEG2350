#! /usr/bin/bash

echo "Hello world"


# every arg passed
echo $@
# total number of args
echo $#

echo "First arg to script is $1"

demo () {
	#arg1=$1
	echo "In demo function, first arg to function is $1"
	echo $1 > file.txt
	return 42
}
demo "sleepin with the fishes"
# ???
echo $?

# printf (I would get no newline)


# TODO:
var=""

# read in text
#read var

# print out said text
#echo $var

words=($(grep '^\w\w\w\w\w$' /usr/share/dict/words | tr '[a-z]' '[A-Z]'))
actual=${words[$[$RANDOM % ${#words[@]}]]}
attempts=10
attempt=0

# loop for a number of attempts
while [[ attempt -lt attempts ]]
do
	echo "Guess the 5 letter word:"
	read var
	# compare a random word
	if [[ $var = $actual ]]; then
		echo "It's a match"
	else
		echo "Wrong!"
		((attempt++))
	fi
done

echo "Out of attempts, word was $actual"
