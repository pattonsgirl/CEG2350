#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main() 
{
	pid_t pid = fork();
	// after fork, two copies of this code are running
	//	parent and child.
	//	the pid compare determines if code 
	//	is for parent or child
	
	//      if pid == 0, then it is the child process.
        //      This first part is run by the child, not the parent

	if (pid == 0)
	{
		printf("Child process reporting:\n");
		printf("Child : Child's PID %d\n", getpid());
		printf("Child : Parent's PID %d\n", getppid());

	}
	else
	{
		printf("Parent process reporting: \n");
		printf("Parent : Parent's PID %d\n", getpid());
		printf("Parent : Child's PID %d\n", pid);
		//if no wait, parent terminates "first" child is 
		//	orphaned, given to PPID 1
		wait(NULL);
	}
	return 0;
}
