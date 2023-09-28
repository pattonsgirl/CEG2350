add() {
	echo "Add function called"
	sum=( $1 + $2 )
	echo "$1 and $2 added = $sum"
}

subtract() {
	echo "Subtract function called"
}

#add
#echo "My print"
#subtract

# have user give mode add / subtract
if [[ $1 == "add" ]]; then
	add $2 $3
elif [[ $1 == "subtract" ]]; then
	subtract $2 $3
else 
	echo "Bad option"
fi
# have user give two numbers

# output result of operation
