/*
 * todo.h - the "table of contents" for todo.c
 *
 * A header file tells other .c files what exists in todo.c: its types,
 * variables, and functions.  It doesn't contain the code that does the
 * work - that stays in todo.c.
 *
 * Any .c file that wants to use these writes #include "todo.h" at the top.
 */

/*
 * This is an "include guard".  If a file ends up including todo.h twice,
 * the second copy is skipped so nothing gets declared twice.
 */
#ifndef TODO_H
#define TODO_H

/* #define gives a name to a value.  The compiler swaps in the value. */
#define MAX_TASKS 100        /* The most tasks the list can hold */
#define MAX_NAME_LENGTH 50   /* The most characters in a task name */

/*
 * A struct groups related values together.  This creates a new type named
 * Task, where each Task has a name and a completed status.
 */
typedef struct {
    char name[MAX_NAME_LENGTH];  /* C stores text as an array of characters */
    int completed;               /* 0 means not done, 1 means done */
} Task;

/*
 * The to-do list itself.  These are defined in todo.c - "extern" tells other
 * .c files that they exist somewhere else, and the linker connects them.
 *
 * tasks     - an array that holds every Task, starting at index 0
 * num_tasks - how many tasks are currently in the list
 */
extern Task tasks[MAX_TASKS];
extern int num_tasks;

/*
 * Function prototypes.  Each line promises the compiler that this function
 * exists, so main.c can call it.  The compiler trusts that promise, and it's
 * the linker's job to find the actual code when the program is put together.
 *
 * "void" return means nothing is returned, and (void) means no parameters.
 */
void add_task(void);       /* Asks for a name and adds it to the list */
void complete_task(void);  /* Asks for a name and marks that task as done */
void remove_task(void);    /* Asks for a name and takes that task off the list */
void view_tasks(void);     /* Prints every task in the list */

#endif
