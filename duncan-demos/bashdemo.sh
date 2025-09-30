#!/bin/bash
# demo.sh - Bash script showing args, input, if, loops, and functions

##########################
# Reading arguments
##########################
echo "Script name: $0"
echo "First arg: $1"
echo "Second arg: $2"
echo "All args: $@"
echo "Number of args: $#"
#echo "The process ID of this script is: $$"

echo

##########################
# Reading user input
##########################
read -p "Enter your name: " name
echo "Hello, $name!"
echo

##########################
# If statement
##########################
if [ "$1" -gt 10 ] 2>/dev/null; then
    echo "First argument ($1) is greater than 10"
else
    echo "First argument ($1) is not greater than 10"
fi
echo

##########################
# For loop
##########################
echo "For loop (1 to 5):"
for i in {1..5}; do
    echo "Iteration $i"
done
echo

##########################
# While loop
##########################
echo "While loop (counting down from 3):"
count=3
while [ $count -gt 0 ]; do
    echo "Count: $count"
    ((count--))
done
echo

##########################
# Do-while loop (simulated with until)
##########################
echo "Do-while loop simulation (runs at least once):"
count=0
until [ $count -ge 3 ]; do
    echo "Do-while iteration: $count"
    ((count++))
done
echo

##########################
# Functions
##########################
no_params() {
    echo "This function takes no parameters"
}

with_params() {
    	# this didn't show what we wanted
	#echo "This process ID in the with_params function is: $$"
	echo "This function takes parameters: $1 and $2"
}

return_value() {
    local x=$1
    local y=$2
    local sum=$((x + y))
    echo $sum  # returning via echo
}

# Call functions
no_params
with_params "apple" "banana"

result=$(return_value 5 7)
# could also save reutn value using $?
echo "Return value function: 5 + 7 = $result"

