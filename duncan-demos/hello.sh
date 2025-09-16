#! /usr/bin/bash

echo "Hello world"

# printf (I would get no newline)


# TODO:
var=""

# read in text
read var

# print out said text
echo $var

words=($(grep '^\w\w\w\w\w$' /usr/share/dict/words | tr '[a-z]' '[A-Z]'))
actual=${words[$[$RANDOM % ${#words[@]}]]}

# compare a random word
if [[ $var = $actual ]]; then
	echo "It's a match"
fi

echo "Out of attempts, word was $actual"
# loop until done
