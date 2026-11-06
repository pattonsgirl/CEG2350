#include <curses.h>
#include "display.h"
#include "todo.h"

#define PAIR_DONE 1
#define PAIR_OPEN 2

void display_tasks(void) {
    static int started = 0;

    /* initscr() should only run once - refresh() resumes after endwin() */
    if (!started) {
        initscr();
        started = 1;
    } else {
        refresh();
    }
    cbreak();
    noecho();

    if (has_colors()) {
        start_color();
        init_pair(PAIR_DONE, COLOR_GREEN, COLOR_BLACK);
        init_pair(PAIR_OPEN, COLOR_YELLOW, COLOR_BLACK);
    }

    clear();
    attron(A_BOLD);
    mvprintw(0, 2, "===== To-Do List =====");
    attroff(A_BOLD);

    if (num_tasks == 0) {
        mvprintw(2, 2, "Nothing to do!");
    }

    for (int i = 0; i < num_tasks; i++) {
        int pair = tasks[i].completed ? PAIR_DONE : PAIR_OPEN;
        attron(COLOR_PAIR(pair));
        mvprintw(i + 2, 2, "[%c] %s", tasks[i].completed ? 'x' : ' ', tasks[i].name);
        attroff(COLOR_PAIR(pair));
    }

    mvprintw(num_tasks + 3, 2, "Press any key to return to the menu");
    refresh();
    getch();
    endwin();
}
