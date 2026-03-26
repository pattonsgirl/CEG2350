#include "utility.h"

TodoList::TodoList() {}

void TodoList::displayMenu() {
    std::cout << "\n===== To-Do List Menu =====" << std::endl;
    std::cout << "1. Add Task" << std::endl;
    std::cout << "2. Mark Task as Completed" << std::endl;
    std::cout << "3. Remove Task" << std::endl;
    std::cout << "4. View To-Do List" << std::endl;
    std::cout << "5. Exit" << std::endl;
}

void TodoList::addTask() {
    Task newTask;
    std::cout << "Enter task name: ";
    std::getline(std::cin, newTask.name);
    newTask.completed = false;
    tasks.push_back(newTask);
    std::cout << "Task added to the to-do list." << std::endl;
}

void TodoList::markTaskAsCompleted() {
    std::string taskName;
    std::cout << "Enter task name to mark as completed: ";
    std::getline(std::cin, taskName);

    auto it = std::find_if(tasks.begin(), tasks.end(), [&](const Task& task) {
        return task.name == taskName;
    });

    if (it != tasks.end()) {
        it->completed = true;
        std::cout << "Task marked as completed." << std::endl;
    } else {
        std::cout << "Task not found in the to-do list." << std::endl;
    }
}

void TodoList::removeTask() {
    std::string taskName;
    std::cout << "Enter task name to remove: ";
    std::getline(std::cin, taskName);

    auto it = std::find_if(tasks.begin(), tasks.end(), [&](const Task& task) {
        return task.name == taskName;
    });

    if (it != tasks.end()) {
        tasks.erase(it);
        std::cout << "Task removed from the to-do list." << std::endl;
    } else {
        std::cout << "Task not found in the to-do list." << std::endl;
    }
}

void TodoList::viewTodoList() {
    std::cout << "\n===== To-Do List =====" << std::endl;
    for (size_t i = 0; i < tasks.size(); i++) {
        std::cout << i + 1 << ". " << tasks[i].name << " - " << (tasks[i].completed ? "Completed" : "Not Completed") << std::endl;
    }
}

void TodoList::run() {
    int choice;

    while (true) {
        displayMenu();
        std::cout << "Enter your choice (1-5): ";
        std::cin >> choice;
        std::cin.ignore(); // Ignore newline character

        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                markTaskAsCompleted();
                break;
            case 3:
                removeTask();
                break;
            case 4:
                viewTodoList();
                break;
            case 5:
                std::cout << "Exiting program. Goodbye!" << std::endl;
                return;
            default:
                std::cout << "Invalid choice. Please enter a number from 1 to 5." << std::endl;
        }
    }
}
