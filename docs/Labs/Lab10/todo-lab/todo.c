#include <stdio.h>
#include <string.h>
#include "todo.h"

Task tasks[MAX_TASKS];
int num_tasks = 0;

/* Prompts for a task name and stores it in name without the newline */
static void read_name(const char *prompt, char *name) {
    printf("%s", prompt);
    if (fgets(name, MAX_NAME_LENGTH, stdin) == NULL) {
        name[0] = '\0';
        return;
    }
    name[strcspn(name, "\n")] = '\0';
}

/* Returns the index of the task called name, or -1 if there isn't one */
static int find_task(const char *name) {
    for (int i = 0; i < num_tasks; i++) {
        if (strcmp(tasks[i].name, name) == 0) {
            return i;
        }
    }
    return -1;
}

void add_task(void) {
    if (num_tasks >= MAX_TASKS) {
        printf("Cannot add more tasks. To-do list is full.\n");
        return;
    }

    read_name("Enter task name: ", tasks[num_tasks].name);
    tasks[num_tasks].completed = 0;
    num_tasks++;
    printf("Task added to the to-do list.\n");
}

void complete_task(void) {
    char name[MAX_NAME_LENGTH];
    read_name("Enter task name to mark as completed: ", name);

    int index = find_task(name);
    if (index == -1) {
        printf("Task not found in the to-do list.\n");
        return;
    }

    tasks[index].completed = 1;
    printf("Task marked as completed.\n");
}

void remove_task(void) {
    char name[MAX_NAME_LENGTH];
    read_name("Enter task name to remove: ", name);

    int index = find_task(name);
    if (index == -1) {
        printf("Task not found in the to-do list.\n");
        return;
    }

    /* Move every task after the removed one a position to the left */
    for (int i = index; i < num_tasks - 1; i++) {
        tasks[i] = tasks[i + 1];
    }
    printf("Task removed from the to-do list.\n");
}

void view_tasks(void) {
    printf("\n===== To-Do List =====\n");
    for (int i = 0; i < num_tasks; i++) {
        printf("%d. %s - %s\n", i + 1, tasks[i].name,
               tasks[i].completed ? "Completed" : "Not Completed");
    }
}
