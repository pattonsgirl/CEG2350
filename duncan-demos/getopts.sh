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

shift $((OPTIND -1))
# TODO: I need to remember to read in filename
#echo "here all my args $@"


# Design it with intent
# Reviting either file maker OR the awk seeks from 2/16
