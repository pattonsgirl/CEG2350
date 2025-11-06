## C / C++ 

### Linux (Ubuntu)

`sudo apt install build-essentials`

Checks:
```
$ gcc --version
$ cmake --verson
```

### Windows

Download and install [MSYS2](https://www.msys2.org/)

Open `Msys2 MinGW64 Shell`.  Run the following:  
`pacman -S mingw-w64-x86_64-toolchain`  
`pacman -S mingw-w64-x86_64cmake`  

Add the `mingw64` binary folder to PATH: `C:\msys64\mingw64\bin`

Checks:
```
PS > gcc --version
PS > cmake --verson
```

> [!WARN] The [VSCode x MinGW instructions](https://code.visualstudio.com/docs/cpp/config-mingw#_prerequisites) **do not** include the correct `pacman` packages for `cmake`

### VS Code Extensions

[C/C++ for Visual Studio Code](https://marketplace.visualstudio.com/items?itemName=ms-vscode.cpptools)
- The C/C++ extension adds language support for C/C++ to Visual Studio Code, including editing (IntelliSense) and debugging features.

### vim plugins

[YouCompleteMe](http://github.com/ycm-core/YouCompleteMe?tab=readme-ov-file)

[clang_complete](https://github.com/xavierd/clang_complete)