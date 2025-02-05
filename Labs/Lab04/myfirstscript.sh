#!/bin/bash

echo "Hello World"
#printf "Hello World from printf"

# echo input to user

read var1

#var1="this is an override"
var1=90
echo $var1

if [[ -e hello.txt ]]; then
        echo "Found it"

fi