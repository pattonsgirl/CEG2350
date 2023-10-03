# help function
printHelp(){
	echo "Usage guide"
	echo " Call with calc.sh followed by calculator option (add or subtract) and two numbers"
	# TODO: print menu of options: -a for add
	echo 'calc.sh -a 4 6'
}

add() {
	echo "Add function called"
	if [[ -n $1 && -n $2 ]]
	then
		sum=$(( $1 + $2 ))
		echo "$1 and $2 added = $sum"
	else
		echo "No numbers given"
	fi
}

subtract() {
	echo "Subtract function called"
	if [[ -n $1 && -n $2 ]]
        then
		result=$(( $1 - $2 ))
		echo "$1 minus $2 = $result"
	else
		echo "No numbers given"
	fi
}

#add
#echo "My print"
#subtract

# have user give mode add / subtract
echo $#
echo $@
option=$1
# print just numbers given as arguments
shift
echo $#
totalargs=$#
for (( i=0; i <= $totalargs; i++ )); do
	echo $1
	shift
done

case $option in
	"-a")
		add $2 $3
		;;
	"-s")
		subtract $2 $3
		;;
	"-h")
		printHelp
		;;
	*)
		echo "Bad option"
		printHelp
		;;
esac
# have user give two numbers

# output result of operation
