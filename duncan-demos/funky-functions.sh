# every arg passed
echo $@
# total number of args
echo $#

echo "First arg to script is $1"

demo () {
        #arg1=$1
        echo "In demo function, first arg to function is $1"
        echo $1 > file.txt
        return 42
}
demo "sleepin with the fishes"
# capture return from function
echo $?
