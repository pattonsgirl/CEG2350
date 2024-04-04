// code from https://github.com/ShivamJoker/Todo-app-in-C
#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdbool.h>
#include <ctype.h>
#include <stdlib.h>
#include <unistd.h>

int tLength = 0;
FILE *fp;

struct Todo
{
    char title[50];
    char createdAt[50];
    _Bool isCompleted;
} todos[20];

void saveToFile()
{
    fp = fopen("todos.bin", "w");
    if (!fp)
    {
        printf("Can't save your todo\n");
    }
    else
    {
        for (size_t i = 0; i < tLength; i++)
        {
            fwrite(&todos[i], sizeof(struct Todo), 1, fp);
        }
        fclose(fp);
    }
}

void getFileSize()
{
    fseek(fp, 0L, SEEK_END);
    unsigned int long size = ftell(fp);
    fseek(fp, 0L, SEEK_SET);
    tLength = size / sizeof(struct Todo);
}

void readFromFile()
{
    fp = fopen("todos.bin", "r");
    if (!fp)
    {
        printf("We are not able to find any todos file\n");
    }
    else
    {
        getFileSize();
        for (size_t i = 0; i < tLength; i++)
        {
            fread(&todos[i], sizeof(struct Todo), 1, fp);
        }
        fclose(fp);
    }
}

void addTodo()
{
    // for todo title
    char userInput[50];
    printf("Type your todo \n>> ");
    scanf("%[^\n]s", userInput);
    strncpy(todos[tLength].title, userInput, 50);

    // add time
    char todoTime[50];
    struct tm cTime;
    time_t timeS = time(NULL);
    localtime_r(&timeS, &cTime);
    // 2/12 1:21
    snprintf(todoTime, 50, "%i/%i %i:%i", cTime.tm_mday, cTime.tm_mon + 1, cTime.tm_hour, cTime.tm_min);
    strcpy(todos[tLength].createdAt, todoTime);

    //set boolean to false
    todos[tLength].isCompleted = false;
    tLength++;
}

void printAllTodo()
{
    printf("+----+-------------------------------------+--------------+-------------+\n");
    printf("| ID |            Todo Title               |  Created at  |  Completed  |\n");
    printf("+----+-------------------------------------+--------------+-------------+\n");

    for (int i = 0; i < tLength; i++)
    {
        if (todos[i].isCompleted)
        {
            printf("\033[10m");
        }
        else
        {
            printf("\033[1m");
        }

        printf("|%3d | %-35s | %-12s | %-13s |\n", i + 1, todos[i].title, todos[i].createdAt, (!todos[i].isCompleted) ? " ❌  No  " : " ✅  Yes ");
        printf("+----+-------------------------------------+--------------+-------------+\n");
    }
}

void markAsComplete()
{
    int todoId;
    printf("Enter the ID of todo \n>>");
    scanf("%d", &todoId);
    todoId--;
    if (todoId < 0 || todoId > tLength)
    {
        printf("Invalid todo id 😑\n");
    }
    else
    {
        todos[todoId].isCompleted = true;
        printf("Todo marked as completed \n");
    }
}

void deleteTodo()
{
    int todoId;
    printf("Enter the ID of todo \n>>");
    scanf("%d", &todoId);
    if (todoId < 0 || todoId > tLength)
    {
        printf("Invalid todo id 😑\n");
    }
    else
    {
        todoId--;
        memmove(todos + todoId, todos + todoId + 1, (tLength - todoId - 1) * sizeof(*todos));
        tLength--;
        printf("Your todo has been deleted 😵\n");
    }
}

void ShowOptions()
{
    char userChoice;
    printf("Type 'A' to add, 'D' to delete & 'C' to mark complete or 'Q' to quit\n>>");
    userChoice = getchar();
    userChoice = toupper(userChoice);
    getchar();
    switch (userChoice)
    {
    case 'A':
        addTodo();
        break;
    case 'D':
        deleteTodo();
        break;
    case 'C':
        markAsComplete();
        break;
    case 'Q':
        exit(0);
        break;
    default:
        printf("Command not found 😓\n");
        ShowOptions();
        break;
    }
    saveToFile();
    printAllTodo();
    getchar();
    ShowOptions();
}

void isThisFirstTime()
{
    if (access("todos.bin", F_OK) != -1)
    {
        readFromFile();
        printAllTodo();
        ShowOptions();
    }
    else
    {
        printf("Welcome to the Great Todo App\n");
        addTodo();
        saveToFile();
        printAllTodo();
        ShowOptions();
    }
}

int main()
{
    system("clear||@cls");
    printf("\033[32;1m");
    isThisFirstTime();
}
