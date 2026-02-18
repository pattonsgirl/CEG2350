# TODO: "lift" the structure of getopts

echo "here all all my starting args $@"

while getopts ":n:v" option; do
  echo "OPTARG is $OPTARG\n OPTIND is $OPTIND"
  case $option in
    n)
      NAME="$OPTARG"
      ;;
    v)
      VERBOSE=true
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

shift $((OPTIND -1))

echo "here all my args $@"

# Design it with intent
# Reviting either file maker OR the awk seeks from 2/16
