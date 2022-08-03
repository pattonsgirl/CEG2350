#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int main ()
{
	printf("Before forking\n");
	fork();
	// after fork, both parent and child process have same tasks
	printf("After forking\n");
}
