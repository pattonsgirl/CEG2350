# main.py
import utility

def main():
    todo_dict = {}  # Dictionary to store tasks and their statuses

    while True:
        utility.display_menu()
        choice = input("Enter your choice (1-5): ")

        if choice == '1':
            utility.add_task(todo_dict)
        elif choice == '2':
            utility.mark_task_completed(todo_dict)
        elif choice == '3':
            utility.delete_task(todo_dict)
        elif choice == '4':
            utility.view_todo_list(todo_dict)
        elif choice == '5':
            print("Exiting program. Goodbye!")
            break
        else:
            print("Invalid choice. Please enter a number from 1 to 5.")

if __name__ == "__main__":
    main()
