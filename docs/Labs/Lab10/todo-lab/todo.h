#ifndef TODO_H
#define TODO_H

#define MAX_TASKS 100
#define MAX_NAME_LENGTH 50

typedef struct {
    char name[MAX_NAME_LENGTH];
    int completed;
} Task;

/* Defined in todo.c - "extern" lets other .c files use them */
extern Task tasks[MAX_TASKS];
extern int num_tasks;

void add_task(void);
void complete_task(void);
void remove_task(void);
void view_tasks(void);

#endif
