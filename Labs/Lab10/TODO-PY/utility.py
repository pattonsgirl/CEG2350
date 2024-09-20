# utility.py

def display_menu():
    print("\n===== To-Do List Menu =====")
    print("1. Add Task")
    print("2. Mark Task as Completed")
    print("3. Delete Task")
    print("4. View To-Do List")
    print("5. Exit")


def add_task(todo_dict):
    task_name = input("Enter task name: ")
    todo_dict[task_name] = False
    print(f"Task '{task_name}' added to the to-do list.")


def mark_task_completed(todo_dict):
    task_name = input("Enter task name to mark as completed: ")
    if task_name in todo_dict:
        todo_dict[task_name] = True
        print(f"Task '{task_name}' marked as completed.")
    else:
        print("Task not found in the to-do list.")


def delete_task(todo_dict):
    task_name = input("Enter task name to delete: ")
    if task_name in todo_dict:
        del todo_dict[task_name]
        print(f"Task '{task_name}' deleted from the to-do list.")
    else:
        print("Task not found in the to-do list.")


def view_todo_list(todo_dict):
    print("\n===== To-Do List =====")
    for task, completed in todo_dict.items():
        status = "Completed" if completed else "Not Completed"
        print(f"- {task}: {status}")
