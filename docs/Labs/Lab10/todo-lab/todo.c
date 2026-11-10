/*
 * todo.c - the code that manages the to-do list
 *
 * The functions promised in todo.h are written here.
 */

/*
 * #include copies in the contents of a header file.
 *   <angle brackets>  = headers from the system or an installed library
 *   "double quotes"   = headers from this project's folder
 */
#include <stdio.h>    /* printf, fgets */
#include <string.h>   /* strcmp, strcspn */
#include "todo.h"     /* Task, MAX_TASKS, and our function prototypes */

/*
 * The actual list.  todo.h announced these with "extern", and this is the
 * one place they are created.  The list starts out empty.
 */
Task tasks[MAX_TASKS];
int num_tasks = 0;

/*
 * Prompts the user and stores what they type in name, without the newline
 * from pressing Enter.
 *
 * "static" means only code in this file can call this function.  It's a
 * helper for todo.c, which is why it isn't listed in todo.h.
 */
static void read_name(const char *prompt, char *name) {
    printf("%s", prompt);

    /* fgets reads one line of input, and returns NULL if there's none left */
    if (fgets(name, MAX_NAME_LENGTH, stdin) == NULL) {
        name[0] = '\0';   /* '\0' marks the end of text, so this is "empty" */
        return;
    }

    /* strcspn finds where the newline is, then we end the text there */
    name[strcspn(name, "\n")] = '\0';
}

/*
 * Searches the list for a task with this name.
 * Returns its index in the tasks array, or -1 if there's no match.
 */
static int find_task(const char *name) {
    for (int i = 0; i < num_tasks; i++) {
        /* C can't compare text with ==.  strcmp returns 0 when it matches. */
        if (strcmp(tasks[i].name, name) == 0) {
            return i;
        }
    }
    return -1;
}

/* Adds a new, not completed task to the end of the list. 
 *
 * Updates the total number of tasks to reflect the increased list size.
 * */
void add_task(void) {
    if (num_tasks >= MAX_TASKS) {
        printf("Cannot add more tasks. To-do list is full.\n");
        return;
    }

    /* The next open spot in the array is at index num_tasks */
    read_name("Enter task name: ", tasks[num_tasks].name);
    tasks[num_tasks].completed = 0;
    num_tasks++;
    printf("Task added to the to-do list.\n");
}

/* Finds a task by name and marks it as completed */
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

/*
 * Finds a task by name and takes it off the list.  An array can't have a gap
 * in the middle, so the tasks after it each move over to fill the space.
 *
 * Updates the total number of tasks to reflect the reduced list size.
 */
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

/* Prints each task with its number and status */
void view_tasks(void) {
    printf("\n===== To-Do List =====\n");
    for (int i = 0; i < num_tasks; i++) {
        /*
         * %d prints a number and %s prints text.  Arrays count from 0, so
         * i + 1 gives a friendlier number to show on screen.
         *
         * "condition ? a : b" picks a if the condition is true, otherwise b.
         */
        printf("%d. %s - %s\n", i + 1, tasks[i].name,
               tasks[i].completed ? "Completed" : "Not Completed");
    }
}
