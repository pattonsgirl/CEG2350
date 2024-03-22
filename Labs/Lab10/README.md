# Lab 10 - NOT READY

- [Lab Procedure](#Lab-Procedure)
- [Part 1 - Write Code](#Part-1---Write-Code)
- [Part 2 - Compile a Program](#Part-2---Compile-a-Program)
- [Part 3 - Create a `Makefile`](#Part-3---Create-a-Makefile)
- [Extra Credit - Dependents](#Extra-Credit---Dependents)
- [Extra Credit - G@M3R](#Extra-Credit---G@M3R)
- [Submission](#Submission)
- [Rubric](#Rubric)
- [Bonus Content - Happy vim](#Bonus-Content---Happy-vim)

## Lab Procedure

[Return to here and select "Start Lab"](https://awsacademy.instructure.com/courses/36184/modules/items/3080473)

Use `ssh` to connect to your AWS Ubuntu instance.

Go to the folder that contains your repository (likely named `ceg2350-yourgithubusername`).

Create a new directory, `Lab10`

Create a file named `Lab10.md` [based on the template](LabTemplate.md).

- [Raw version of LabTemplate.md](https://raw.githubusercontent.com/pattonsgirl/CEG2350/main/Labs/Lab10/LabTemplate.md)

For each part below, you will be asked to do an action or answer a question. The actions are going to be commands - you will write the command you used as "answers" to the action requested. You are allowed to use multiple commands to solve an action. Just write down all that were needed to complete. Check with the TAs if you need clarification.

If you did something "wrong" make a note of it in your lab. These are learning experiences - writing them down will help you ask good questions later.

## Part 1 - Write Code

Use Java or C or C++ to write an echo program. Name your source code file `repeat` with the appropriate source code extension: `repeat.java`, `repeat.c`, `repeat.cpp`. The program should perform the following:

- prompt the user to enter text
- capture text from standard input
- output the captured text to standard output

- **Additional notes**
  - You may work together or use things found on the internet or textbooks. Practice citing your sources using comments in your code.
  - You are welcome to use an IDE you are familiar with to write test and debug your code, but you'll need to get the source code to a file on your AWS instance for the remainder of the lab.
  - There is some useful C starter code in [this guide](https://www.geeksforgeeks.org/taking-string-input-space-c-3-different-methods/) about halfway down.
    - You'll need to add another print statement before the scan statement to prompt the user to enter a string.

## Part 2 - Compile a Program

1. Identify the compiler for your source code and well as its version and installed location.
2. Compile your source code using the compiler.
3. Run your compiled code.

## Part 3 - Create a `Makefile`

1. Create a file called `Makefile`.
2. Write targets in your `Makefile` such that the following terminal commands do the corresponding actions:
   - `make` - if the source code file exists, will compile the program
       - binaries should **only** be compiled, not executed
   - `make run` - if the compiled program exists, will execute / run the program
   - `make clean` - if the compiled program exists, will delete the compiled program

- **Resources**
  - [Sample Java `Makefile` in this folder](./Makefile-Java)
  - [Sample C/C++ `Makefile` in the folder](./Makefile-C)
  - [`Makefile` in C](https://www.cs.swarthmore.edu/~newhall/unixhelp/howto_makefiles.html#C)
  - [`Makefile` in Java](https://www.cs.swarthmore.edu/~newhall/unixhelp/howto_makefiles.html#java)

## Extra Credit - Dependents

Create a folder in your `Lab10` folder called `ec`. In Java, C or C++, add or create a multi-file code project.

- Perhaps your main code file calls on a function that is detailed in the other file (function can do a simple action, like print a message)
- You may use an old / existing multifile project

Modify your `Makefile` to compile the original file & its new dependency(s). Note that your `Makefile` should have an updated version of the pre requisites to compile the program.

## Extra Credit - G@M3R

Install `nsnake` from the source, [`nsnake-3.0.1.tar.gz`](nsnake-3.0.1.tar.gz). For credit, you need to detail how you installed `nsnake` successfully by including at least the details specified below including which commands you used.

- **Useful Commands: `wget`, `tar`, `apt`, `make`**

1. Download `nsnake-3.0.1.tar.gz` to your home directory.
2. Install / check installation of `gcc` and `ncurses`.
3. Extract `nsnake` to your home directory.
4. Compile `nsnake`
5. Play `nsnake`

## Submission

1. Verify that your GitHub repo has a `Lab10` folder with at minimum:

   - `repeat.java` OR `repeat.c` OR `repeat.cpp`
   - your compiled program
   - `Makefile`
   - `Lab10.md`

2. In the Pilot Dropbox, paste the URL to the `Lab10` folder in your GitHub repo
   - URL should look like: https://github.com/WSU-kduncan/ceg2350-YOURGITHUBUSERNAME/tree/main/Lab10

## Rubric

- Part 1 - 4 pts
- Part 2 - 3 pts
- Part 3 - 3 pts
  - 1 pt per target
- Extra Credit - Dependents - 1 pt (10%)
- Extra Credit - G@M3RS - 1 pt (10%)

## Bonus Content - Happy vim

No extra credit down here.

Now don't start a rebellion, but `vim` could have been nicer this whole time. As a fun rabbit hole (seriously, go do your lab first) here are some links to ways to improve vim for different tasks

Remember `vim` was designed to stop devs from having to find / use a mouse - ever. So a lot of really neat `vim` features, extra packages, and plugins involve getting some muscle memory

- [vim colorschemes](https://vimcolorschemes.com/)
  - [jellybeans](https://github.com/nanotech/jellybeans.vim) is a personal favorite

```
mkdir -p ~/.vim/colors
cd ~/.vim/colors
curl -O https://raw.githubusercontent.com/nanotech/jellybeans.vim/master/colors/jellybeans.vim
echo "colorscheme jellybeans" >> ~/.vimrc
```

- [tricks for vim with C++](https://www.incredibuild.com/blog/vim-c-there-is-such-a-thing-tricks-to-use-vim-in-c)
- [vim with python](https://realpython.com/vim-and-python-a-match-made-in-heaven/)
- [vim for Java](https://jqno.nl/post/2020/09/09/my-vim-setup/)
  - [spacevim and Java (for the real nerd)](https://spacevim.org/use-vim-as-a-java-ide/)
