#include <stdio.h>
#include <stdlib.h>
#include "todo.h"

static void show_menu(void) {
    printf("\n===== To-Do List Menu =====\n");
    printf("1. Add Task\n");
    printf("2. Mark Task as Completed\n");
    printf("3. Remove Task\n");
    printf("4. View To-Do List\n");
    printf("5. Exit\n");
    printf("Enter your choice (1-5): ");
}

int main(void) {
    char line[16];

    while (1) {
        show_menu();
        if (fgets(line, sizeof(line), stdin) == NULL) {
            return 0;
        }

        switch (atoi(line)) {
            case 1:
                add_task();
                break;
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
            default:
                printf("Invalid choice. Please enter a number from 1 to 5.\n");
        }
    }
}
