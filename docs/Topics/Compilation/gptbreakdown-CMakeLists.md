## ChatGPT Breakdown - ascii-patrol CMakeLists

Original file: [https://github.com/msokalski/ascii-patrol/blob/master/CMakeLists.txt](https://github.com/msokalski/ascii-patrol/blob/master/CMakeLists.txt)

This is a **CMake configuration file (`CMakeLists.txt`)** used to build the **ASCIIpatrol** project — a C++ program that can target **different platforms** (Linux/Unix, Windows, or WebAssembly using Emscripten).

Let’s go through it **step by step** 👇

---

### 🧩 Basic setup

```cmake
cmake_minimum_required(VERSION 3.14)
```

* Requires **CMake version 3.14 or higher**.
* Ensures access to newer CMake features and syntax.

```cmake
project(ASCIIpatrol LANGUAGES CXX)
```

* Declares the **project name** (`ASCIIpatrol`).
* Specifies that it uses the **C++ language** (`CXX`).

---

### ⚙️ Optional build type

```cmake
option(web "build WASM using emscripten")
```

* Defines a **build option** named `web` (boolean).
* If enabled (`cmake -Dweb=ON`), it builds for **WebAssembly (WASM)** using **Emscripten**.
* If not set, it defaults to a native build (UNIX or Windows).

---

### 🧹 Auto-ignore build directory

```cmake
if(NOT EXISTS ${PROJECT_BINARY_DIR}/.gitignore)
  file(WRITE ${PROJECT_BINARY_DIR}/.gitignore "*")
endif()
```

* Ensures the **build folder** (where CMake generates files) has a `.gitignore` file containing `*`.
* This prevents accidentally committing build outputs to Git.

---

### 📦 External library setup

```cmake
find_package(Threads)
```

* Looks for the system’s **threading library** (e.g., pthreads on Linux).

---

#### 🕸 If building for Web (Emscripten)

```cmake
if(web)
  find_path(EMSCRIPTEN_INCLUDE_DIR NAMES emscripten.h REQUIRED)
```

* Searches for Emscripten’s `emscripten.h` include path.
* Fails if not found.

---

#### 🐧 If building for Unix (Linux / macOS)

```cmake
elseif(UNIX)
  find_package(X11 REQUIRED)
  find_library(XI_LIBRARY NAMES Xi REQUIRED)
  find_path(XI_INCLUDE_DIR NAMES X11/extensions/XInput2.h REQUIRED)
  find_library(PULSEAUDIO_LIBRARY NAMES pulse REQUIRED)
  find_path(PULSEAUDIO_INCLUDE_DIR NAMES pulse/pulseaudio.h REQUIRED)
```

* Locates dependencies:

  * **X11** (the window system)
  * **Xi** (X Input Extension for keyboard/mouse)
  * **PulseAudio** (sound library)
* Each `find_*` checks system locations for include paths and libraries.

---

### 🧱 Main executable target

```cmake
add_executable(asciipat
manual.cpp mo3.cpp unmo3.cpp stb_vorbis.cpp
conf.cpp gameover.cpp inter.cpp
twister.cpp game.cpp temp.cpp menu.cpp assets.cpp
)
```

* Defines the **main executable** target named `asciipat`.
* Lists the common `.cpp` source files to compile for all platforms.

---

### ⚠️ Compiler-specific flags

```cmake
if(CMAKE_CXX_COMPILER_ID MATCHES "(Clang|GNU)")
  target_compile_options(asciipat PRIVATE -Wno-multichar)
endif()
```

* Adds `-Wno-multichar` only for **Clang** or **GCC** compilers.
* Suppresses warnings about multi-character constants (like `'ABCD'`).

---

### 🪟 Windows symbol export (optional)

```cmake
set(CMAKE_WINDOWS_EXPORT_ALL_SYMBOLS ON)
```

* Tells CMake to **export all symbols** automatically when building on Windows (useful for DLLs).

---

### 📦 Install rule

```cmake
install(TARGETS asciipat)
```

* Allows you to run `cmake --install .` to install the binary system-wide.

---

### 🧭 Platform-specific configuration

#### 🌐 Web (Emscripten)

```cmake
if(web)
  target_compile_definitions(asciipat PRIVATE WEB)
  target_sources(asciipat PRIVATE spec_web.cpp)
	target_include_directories(asciipat PRIVATE ${EMSCRIPTEN_INCLUDE_DIR})
```

* Defines `WEB` macro for preprocessor (`#ifdef WEB` in code).
* Adds web-specific source file `spec_web.cpp`.
* Adds Emscripten’s include path.

---

#### 🐧 UNIX (Linux/macOS)

```cmake
elseif(UNIX)
  target_compile_definitions(asciipat PRIVATE NIX)
  target_sources(asciipat PRIVATE spec_nix.cpp)
  target_link_libraries(asciipat PRIVATE X11::X11 ${XI_LIBRARY} ${PULSEAUDIO_LIBRARY})
  target_include_directories(asciipat PRIVATE ${XI_INCLUDE_DIR} ${PULSEAUDIO_INCLUDE_DIR})
```

* Defines `NIX` macro for Linux-specific code.
* Adds `spec_nix.cpp` source file.
* Links against `X11`, `Xi`, and `PulseAudio` libraries.
* Adds necessary include directories.

---

#### 🪟 Windows

```cmake
elseif(WIN32)
  target_compile_definitions(asciipat PRIVATE WIN
  "$<$<BOOL:${MSVC}>:NOMINMAX;_CRT_SECURE_NO_WARNINGS>"
  )
  target_sources(asciipat PRIVATE spec_win.cpp)
  target_link_libraries(asciipat PRIVATE dsound winmm gdi32 dxguid)
```

* Defines `WIN` for Windows-specific builds.
* Adds Windows-specific file `spec_win.cpp`.
* Links with system libraries:

  * `dsound` — DirectSound
  * `winmm` — multimedia
  * `gdi32` — graphics
  * `dxguid` — DirectX GUIDs
* The special `$<$<BOOL:${MSVC}>:...>` syntax adds extra defines **only when using Microsoft’s compiler (MSVC)**.

---

#### 🧱 Fallback

```cmake
else()
  message(FATAL_ERROR "DOS is not yet handled.")
endif()
```

* If none of the above conditions match (e.g., DOS target), CMake will **abort** the configuration.

---

### 🧵 Link with threads (if found)

```cmake
if(Threads_FOUND)
  target_link_libraries(asciipat PRIVATE Threads::Threads)
endif()
```

* Links against the system’s thread library (`pthread` on UNIX, Win32 threads on Windows).

---

### 🧠 Summary Table

| Section                               | Purpose                                                |
| ------------------------------------- | ------------------------------------------------------ |
| `cmake_minimum_required`, `project()` | Basic project setup                                    |
| `option(web ...)`                     | Enables WebAssembly build mode                         |
| `.gitignore` write                    | Keeps build directory out of version control           |
| `find_package(Threads)`               | Adds threading support                                 |
| `find_*` blocks                       | Locate platform-specific dependencies                  |
| `add_executable`                      | Defines the main program                               |
| `target_compile_options`              | Adds compiler flags                                    |
| `install()`                           | Defines installation behavior                          |
| Platform-specific `if/elseif` blocks  | Configure OS- or platform-dependent code and libraries |
| `target_link_libraries(Threads)`      | Link threads if available                              |

---

### 🚀 In short:

This CMake file sets up **ASCIIpatrol** to build **cross-platform**:

* ✅ **Linux/macOS:** Uses X11 and PulseAudio.
* ✅ **Windows:** Uses DirectSound and Win32 APIs.
* ✅ **WebAssembly:** Uses Emscripten to compile to the web.

It automatically picks the right source files, libraries, and defines for each platform — making one codebase portable across all targets.
