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
if [[ $var = "test" ]]; then
	echo "It's a match"
fi

# grab a random word
words=($(grep '^\w\w\w\w\w$' /usr/share/dict/words | tr '[a-z]' '[A-Z]'))
actual=${words[$[$RANDOM % ${#words[@]}]]}
echo $words
echo "Actual word was $actual"

# loop until done
