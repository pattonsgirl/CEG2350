add() {
	echo "Add function called"
	if [[ -n $1 && -n $2 ]]
	then
		sum=( $1 + $2 )
		echo "$1 and $2 added = $sum"
	else
		echo "No numbers given"
	fi
}

subtract() {
	echo "Subtract function called"
	if [[ -n $1 && -n $2 ]]
        then
		result=( $1 - $2 )
		echo "$1 minus $2 = $result"
	else
		echo "No numbers given"
	fi
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
