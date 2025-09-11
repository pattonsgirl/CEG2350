#! /usr/bin/bash

echo "Hello world"

# printf (I would get no newline)


# TODO:
var=""

# read in text
read var

# print out said text
echo $var

# compare that text with a fixed word: "test"
if [[ $var = "test" ]]
	echo "It's a match"
fi

# loop until done
