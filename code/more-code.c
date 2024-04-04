#include "codeheader.h"

void function_elsewhere (int num){
  printf ("\n\nI'm in here!!!\n\n");
  num = 9001;
}

void sort_list (char groceries[5][40]){
  printf("I am in my sort function\n");
  char temp[40];
  for (int i = 0; i < 5; i++){
    for (int j = i+1; j < 5; j++){
      if(strcmp(groceries[i], groceries[j]) > 0){
        //strcpy()
        printf("%s should not be before %s\n", groceries[i], groceries[j]);
        //swap
        //strcpy(dest,src);
        strcpy(temp, groceries[i]);
        strcpy(groceries[i], groceries[j]);
        strcpy(groceries[j], temp);
      }
      //printf("%d\n", temp);
    }
  } 
}
