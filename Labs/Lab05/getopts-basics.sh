#!/bin/bash

# function usageGuide prints usage guide on -h (help) option
# could use if bad options provided as well
usageGuide() {
	echo "Usage guide for script"
	echo "Call this function with usageGuide"
}

# getopts OPTSTRING VARNAME
# OPTSTRING - tells getopts which options to expect and where to expect arguments
# VARNAME - tells getopts which shell-variable to use for option reporting
while getopts ":ha:bc:" opt; do
	echo "OPTARG = $OPTARG = which argument is being looked at"
	echo "OPTIND = $OPTIND = which index of arguments is being looked at"
	# a switch (case) statement appears!
	# find matching case based on value in opt variable
	case $opt in
	h)
		echo "h was given, printing help"
		usageGuide
		exit
		;;
	a)	
		# Once a case matches, OPTARG and OPTIND move forward
		# If option was supposed to have arg after
		# a: in OPTSTRING means -a should have arg after
		echo "arg after a is $OPTARG"
		echo "index looked at (where arg for a is) is $OPTIND"
		# store arg in variable to use later
		num=$OPTARG
		;;
	b) 	
		echo "b had no arg after, so OPTARG is $OPTARG"
		echo "OPTIND remain $OPTIND"
		;;
	c) 	
		# c does expect an arg after
		echo "arg after c is $OPTARG"                                                                          echo "index looked at (where arg for c is) is $OPTIND"
		;;
	\?)	
		# case if no matching case
      		echo "Invalid option: -$OPTARG" >&2
      		;;
	esac
done

#printf "\n\ngetopts is done. \nValue of OPTARG is $OPTARG \nValue of OPTIND is $OPTIND\n\n"
# remember $@ and how it prints all arguments?
#echo "All arguments, pre shift: $@"
# shift allows to "shift" arguments forward
# guess what we have?  getopts still knows what index it last looked at
#shift $((OPTIND-1))
#echo "Arguments remianing, post shift: $@"
