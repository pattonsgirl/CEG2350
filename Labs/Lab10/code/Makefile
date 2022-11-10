default: main.c more-code.c codeheader.h
	gcc -Wall main.c -o main.o -c
	gcc -Wall more-code.c -o more-code.o -c
create: main.o more-code.o
	gcc -Wall -o program *.o
dothings: program
	./program
cleanup: 
	rm *.o
