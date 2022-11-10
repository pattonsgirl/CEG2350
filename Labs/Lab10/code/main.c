//libraries
//files that we need to include
#include "codeheader.h"

//void sort_list (char [5][40]);
//void sort_list (char *[40]);

int main(void) {
  function_elsewhere(22);
  char sentence [200] =("hangman");
  char sentence_unguessed [200]=("*******");
  char guess = 'n';
  for (int i=0; i < strlen(sentence); i++){
    if (guess == sentence[i]){
      sentence_unguessed [i] = sentence [i];
      printf("n is here\n");
    }
  }
  printf("phrase was %s\n", sentence);
  printf("guessed so far %s\n", sentence_unguessed);
  int which_comes_first;
  strcpy(sentence_unguessed, sentence);
  which_comes_first = strcmp(sentence, sentence_unguessed);
  printf("Return value is %d\n",which_comes_first);

  

  char groceries[5][40] = {
    "milk", //9
    "bananas",  //3
    "honey nut cheerios",  //8
    "apples",
    "salmon"
  };
  //groceries[1];
  sort_list(groceries);


  char item[40] ="apples";
  for (int i = 0; i < 5; i++){
    if (strcmp(groceries[i], item) == 0)
      printf("%s is in the list\n", item);
  }

  for (int i = 0; i < 3; i++){
    printf("%s\n", groceries[i]); 
  }
  
  return 0;
}
