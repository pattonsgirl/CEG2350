/*
 * display.c - a full screen view of the to-do list
 *
 * This file uses the ncurses library, which controls the terminal screen:
 * placing text at a position, adding color, and reading single key presses.
 *
 * Using a library takes two things:
 *   1. Its header, so the compiler knows what functions exist
 *   2. Its compiled code, so the linker can connect your calls to them
 */

#include <curses.h>   /* From the library: initscr, mvprintw, getch, and more */
#include "display.h"
#include "todo.h"     /* Gives this file access to tasks and num_tasks */

/* ncurses colors come in numbered pairs of text color and background color */
#define PAIR_DONE 1
#define PAIR_OPEN 2

void display_tasks(void) {
    /* A static variable inside a function keeps its value between calls */
    static int started = 0;

    /* initscr() should only run once - refresh() resumes after endwin() */
    if (!started) {
        initscr();    /* Takes control of the terminal screen */
        started = 1;
    } else {
        refresh();
    }
    cbreak();   /* Get key presses right away, without waiting for Enter */
    noecho();   /* Don't print the keys the user presses */

    /* Set up our color pairs, if this terminal supports color */
    if (has_colors()) {
        start_color();
        init_pair(PAIR_DONE, COLOR_GREEN, COLOR_BLACK);
        init_pair(PAIR_OPEN, COLOR_YELLOW, COLOR_BLACK);
    }

    clear();   /* Start from a blank screen */

    /* attron turns a text style on, and attroff turns it back off */
    attron(A_BOLD);
    /* mvprintw is printf at a position: mvprintw(row, column, text) */
    mvprintw(0, 2, "===== To-Do List =====");
    attroff(A_BOLD);

    if (num_tasks == 0) {
        mvprintw(2, 2, "Nothing to do!");
    }

    /* Draw one task per row, starting at row 2 */
    for (int i = 0; i < num_tasks; i++) {
        int pair = tasks[i].completed ? PAIR_DONE : PAIR_OPEN;
        attron(COLOR_PAIR(pair));
        mvprintw(i + 2, 2, "[%c] %s", tasks[i].completed ? 'x' : ' ', tasks[i].name);
        attroff(COLOR_PAIR(pair));
    }

    mvprintw(num_tasks + 3, 2, "Press any key to return to the menu");

    refresh();   /* Nothing appears until refresh() draws it on the screen */
    getch();     /* Wait for a key press */
    endwin();    /* Give the terminal back to normal use */
}
