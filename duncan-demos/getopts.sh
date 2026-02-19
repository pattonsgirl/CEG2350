# TODO: "lift" the structure of getopts

#echo "here all all my starting args $@"


print_help() {
echo "given a user, how many log attempts = u"
echo "who had the login attempts = m"
echo "given a date, how many login attempts = d"
echo "DONT FORGET TO GIVE ME A FILE"
}

user=""
find_date=""

while getopts ":u:d:mh" option; do
  case $option in
    h)
      print_help
      ;;
    u)
      echo "given a user, how many log attempts = u"
      
      user=$OPTARG
      ;;
    m) 
       echo "who had the login attempts = m"
	;;
    d)
	echo "given a date, how many login attempts = d"
	find_date=$OPTARG
	;;
    \?)
      echo "Invalid option: -$OPTARG" >&2
      exit 1
      ;;
    :)
      echo "Option -$OPTARG requires an argument." >&2
      exit 1
      ;;
  esac
done

## what if you want the last arg
echo "user to find is $user"
echo "date to find is $find_date"
reg_date="[0-9]{4}-[0-9]{2}-[0-9]{2}"

shift $((OPTIND -1))
# TODO: I need to remember to read in filename
#echo "here all my args $@"

# TODO: is the last a file?
if [[ -f $1 ]]
then
	echo "TODO: now that I have a file, I can processing"
	if [[ -n $user ]]
	then
		echo "you gave me a user"
		# awk thing that says how loings based on a user
	elif [[ $find_date =~ $reg_date ]]
	then
		echo "OMG! It's a date!"
	fi


else
	echo "You failed to give me a file"
fi

# Design it with intent
# Reviting either file maker OR the awk seeks from 2/16
