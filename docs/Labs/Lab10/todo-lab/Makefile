# Makefile - instructions for building the program
#
# Run "make" or "make build" in this folder to use it.  Lines that start
# with # are comments.

# Variables keep settings in one place.  Use one by writing $(NAME).

# The compiler to use
CC = gcc

# Compiler options: show warnings and include debugging info
CFLAGS = -Wall -Wextra -g

# The name of the program to build
TARGET = todo_app

# The source code files that make up the program
SRCS = main.c

# A rule tells make how to create something:
#
#   target: dependencies
#   <TAB>command to run
#
# The target is what gets made, and the dependencies are what it needs first.
# make only runs the command if a dependency is newer than the target.
#
# Commands MUST start with a TAB character.  Spaces will give you an error.

# "build" is the first rule, so it's what plain "make" runs.  It has no
# command of its own - it just needs $(TARGET) to be up to date.
build: $(TARGET)

# Compiles everything listed in SRCS into the program
$(TARGET): $(SRCS)
	$(CC) $(CFLAGS) $(SRCS) -o $(TARGET)

# .PHONY lists targets that are actions, not files that get created
.PHONY: build
