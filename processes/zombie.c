#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main()
{	
	//ZOMBIE:
	//	Created when child exits, but 
	//	parent is busy and hasn't called WAIT
		
	//fork returns process id in parent process
	pid_t child_pid = fork();

	// parent process
	// 	if child_pid == 0, then it is the child process.
	// 	This first part won't run by the child, only by the parent
	if (child_pid > 0){
		//increment this time to force parent 
		//	to not call wait on child
		printf("I am the parent process, PID %d\n.", getpid());
		printf("Instead of wait, I am going to sleep");
		sleep(500);
	}
	//child process
	else {
		printf("I am child process, PID %d\n", getpid());
		printf("I am going to exit, and see if PARENT PID %d notices me", getppid());
		printf("Use `ps au` in another terminal to see the zombie!");
		exit(0);
	}
	return 0;
}
