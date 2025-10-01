while getopts "a:vr:" opt; do
  case $opt in
	a) new_record="$OPTARG"
	       add_record $new_record	;;
	r) trash_me="$OPTARG" ;;
	v) print_all_records ;;
	\?) echo "Invalid option: -$OPTARG" ;;
  esac
done

echo "value after -a flag is $new_record"
echo "value after -r flag is $trash_me"
