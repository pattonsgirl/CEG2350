# help function
printHelp(){
	echo "Usage guide"
	echo " Call with calc.sh followed by calculator option (add or subtract) and two numbers"
	echo 'calc.sh add 4 6'
}

add() {
	echo "Add function called"
	sum=$(( $1 + $2 ))
	echo "$1 and $2 added = $sum"
}

subtract() {
	echo "Subtract function called"
	result=$(( $1 - $2 ))
	echo "$2 subtracted from $1 = $result" 
}

#add
#echo "My print"
#subtract

# have user give mode add / subtract
if [[ $1 == "add" ]]; then
	add $2 $3
	# echo ( $2 + $3 )
elif [[ $1 == "subtract" ]]; then
	subtract $2 $3
elif [[ $1 == "help" ]]; then
	printHelp
else 
	echo "Bad option"
fi
# have user give two numbers

# output result of operation
