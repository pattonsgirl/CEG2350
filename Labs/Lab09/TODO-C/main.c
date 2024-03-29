#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "utility.h"

int main() {
    int choice;

    while (1) {
        displayMenu();
        printf("Enter your choice (1-5): ");
        scanf("%d", &choice);
        getchar(); // Consume newline character

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
                printf("Exiting program. Goodbye!\n");
                return 0;
            default:
                printf("Invalid choice. Please enter a number from 1 to 5.\n");
        }
    }

    return 0;
}