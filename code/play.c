#include <stdio.h>
#include <math.h>
#include <string.h>

// if we uncomment the below line, then the program will print AGE in the output.
// #define AGE 18
#define PI 3.14159

int main()
{
	// if `AGE` is defined then print the `AGE` else print "Not Defined"
	#ifdef AGE
		printf("Age is %d", AGE);
	#else
		printf("Not Defined");
	#endif
	
	//other_function("Hello!");
	// how about with no conditions?
	printf("The value of PI is %f", PI);

	int num = 8;
	num = num + 2;
	printf("The value of num is %d", num);

	return 0;
}
