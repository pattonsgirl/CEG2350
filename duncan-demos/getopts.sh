# TODO: "lift" the structure of getopts

while getopts ":n:v" opt; do
  case $opt in
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
# Design it with intent
# Reviting either file maker OR the awk seeks from 2/16
