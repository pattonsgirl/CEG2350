## Lab 10

- Name:
- Email:

## Part 0 - Issues & Branches

**`git` branch guide**

| Task                                                    | Command(s) / Steps | Notes |
| ------------------------------------------------------- | ------------------ | ----- |
| **Create a branch**                                     |                    |       |
| **Change to branch**                                    |                    |       |
| **Add branch to remote if created locally (GitHub)**    |                    |       |
| **Steps to `merge` changes to another branch (`main`)** |                    |       |
| **Steps to resolve a `merge` conflict**                 |                    |       |


## Part 1 - Compilers

**Installing the compiler for different OSes**

| Language         | Compiler           | Linux (Ubuntu/Debian)    | macOS       |Windows        | 
| ---------------- | ------------------ | ------------------------ | ----------- | ------------- | 
| **C / C++**      | GCC / G++          | `sudo apt install build-essential`     | `xcode-select --install`  | Install **MinGW** via [MSYS2](https://www.msys2.org/) <br>→ `pacman -S mingw-w64-x86_64-gcc` |
| **Java**         | OpenJDK            |                          |             |                |                |
| **Python**       | Python             |                          |             |                |                |

**Verifying install location & verison**

| Language       | OS                    | Confirm Installation Command | Check Version Command | Expected Output Example                          |
| -------------- | --------------------- | ---------------------------- | --------------------- | ------------------------------------------------ |
| **C (GCC)**    | Linux                 | `which gcc`                  | `gcc --version`       | `gcc (Ubuntu 13.2.0) 13.2.0`                     |
|                | macOS                 | `which gcc`                  | `gcc --version`       | `Apple clang version 15.0.0 (clang-1500.0.40.1)` |
|                | Windows (MSYS2/MinGW) | `where gcc`                  | `gcc --version`       | `gcc.exe (Rev10, Built by MSYS2 project) 13.2.0` |
| **C++ (G++)**  | Linux                 | `which g++`                  | `g++ --version`       | `g++ (Ubuntu 13.2.0) 13.2.0`                     |
|                | macOS                 | `which clang++`              | `clang++ --version`   | `Apple clang version 15.0.0`                     |
|                | Windows               | `where g++`                  | `g++ --version`       | `g++.exe (Rev10, Built by MSYS2 project) 13.2.0` |
| **Java (JDK)** | Linux                 |                              |                       |                                                  |
|                | macOS                 |                              |                       |                                                  |
|                | Windows               |                              |                       |                                                  |
| **Python 3**   | Linux                 |                              |                       |                                                  |
|                | macOS                 |                              |                       |                                                  |
|                | Windows               |                              |                       |                                                  |


## Part 2 - Compiling

1. Method & command to get a copy of the source code files:
2. Command(s) to install the C/C++ compiler on Ubuntu:
3. Command(s) to confirm the installation of the C/C++ compiler on Ubuntu:
4. Command(s) to compile the source code into an executable program:
5. Command(s) to execute the program:

## Part 3 - Ignore That

Remove this statement and the exclamation point from the line below so TAs can click to check for a working `.gitignore` file.  Test that the link works - if it doesn't, fix the pathing.

![`.gitignore` file in root of repository](../.gitignore)

## Part 4 - Document

### Program User Guide

#### Program Description

#### How to Build and Run Program

#### How to Use Program

## Part 5 - `makey makey`

Using `Makefile` to build executable:

Using `Makefile` to run program:

Using `Makefile` to remove compilation files, such as the executable: 

## Extra Credit - `git` tools

`git` tool selected:

How to install this tool:

Screenshot proof of it in action!

![Insert screenshot here](path/to/screenshot)

## Citations

To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.