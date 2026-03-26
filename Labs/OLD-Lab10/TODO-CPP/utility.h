#ifndef TODOLIST_H
#define TODOLIST_H

#include <iostream>
#include <vector>
#include <algorithm>

struct Task {
    std::string name;
    bool completed;
};

class TodoList {
private:
    std::vector<Task> tasks;

public:
    TodoList(); // Constructor
    void displayMenu();
    void addTask();
    void markTaskAsCompleted();
    void removeTask();
    void viewTodoList();
    void run();
};

#endif // TODOLIST_H