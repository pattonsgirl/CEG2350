/*
 * main.c - where the program starts
 *
 * This file only handles the menu.  The work of managing the list happens in
 * todo.c, and main.c knows those functions exist because it includes todo.h.
 */

#include <stdio.h>    /* printf, fgets */
#include <stdlib.h>   /* atoi */
#include "todo.h"     /* add_task, complete_task, remove_task, view_tasks */

/* Prints the menu.  "static" means only this file can call it. */
static void show_menu(void) {
    printf("\n===== To-Do List Menu =====\n");
    printf("1. Add Task\n");
    printf("2. Mark Task as Completed\n");
    printf("3. Remove Task\n");
    printf("4. View To-Do List\n");
    printf("5. Exit\n");
    printf("Enter your choice (1-5): ");
}

/* Every C program starts running at main.  Returning 0 means success. */
int main(void) {
    char line[16];   /* Holds what the user types at the menu */

    /* while (1) loops forever - the program ends at one of the returns */
    while (1) {
        show_menu();

        /* Read the user's choice.  NULL means there's no more input. */
        if (fgets(line, sizeof(line), stdin) == NULL) {
            return 0;
        }

        /* atoi turns text into a number, then switch jumps to that case */
        switch (atoi(line)) {
            case 1:
                add_task();
                break;   /* break leaves the switch, back to the top of the loop */
            case 2:
                complete_task();
                break;
            case 3:
                remove_task();
                break;
            case 4:
                view_tasks();
                break;
            case 5:
                printf("Exiting program. Goodbye!\n");
                return 0;
            default:   /* Runs when no case above matched */
                printf("Invalid choice. Please enter a number from 1 to 5.\n");
        }
    }
}
