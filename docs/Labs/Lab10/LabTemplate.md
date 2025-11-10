## Lab 09

- Name:
- Email:

Instructions for this lab: https://pattonsgirl.github.io/CEG2350/Labs/Lab09/Instructions.html

## Part 1 - Game the system

- Game name: 
- How to install:
- Location of game executable:
- How to run game:

## Part 2 - Process Control

1. Table of process related commands:

|  Action   |  Command or Keybind   |  
| ---       | --- | 
| Check process CPU/memory usage |     |
| Show running processes         |     |
| Show detailed process tree     |     |
| Find a process by name         |     |
| Kill a process by PID          |     |
| Force kill a process by PID    |     |
| Pause / suspend a process by PID  |     |
| Resume a suspended process by PID |     |

2. `ps` fields table:

| `ps` field | Meaning |
| ---        | ---     |
| PID        |         |
| PPID       |         |
| UID / USER |         |
| TTY        |         |
| STAT       |         |
| COMMAND / CMD |         |
| %CPU       |         |
| %MEM       |         |
| PSR        |         |

3. `ps` command:
4. Output of `ps` with two shells, one running the game:
```
Output of command goes here
```
5. For the game:
   - Process id: 
   - Parent process id: 
   - What is the parent process: 
6. `kill` to kill only the game:
   - Describe what the effect was: 
7. `kill` to kill the game and it's parent process: 
   - Describe what the effect was:
8. Describe what happens if you close / `exit` your connection with Shell C and determine if you can reenter the game (resume the process).
   - Answer: 

## Part 3 - back and fore

1. Fill out the following table of job control commands and keybinds:

|  Action   |  Command or Keybind   |  
| ---       | --- | 
| Show current jobs               |     |
| Run a command in background     |     |
| Pause current foreground job    |     |
| Send job to the background      |     |
| Bring job to the foreground     |     |
| Kill a background / stopped job |     |

2. Run in the foreground: 
3. `STOP` signal to suspend it: 
4. Proof of life from `ps` output:
```
insert line here
```
5. Resume in the foreground:
6. `TERMINATE` signal to kill it: 
7. Start as a background process: 
8. Output of `jobs` from controlling terminal:
```
Insert output here
```
Output of `ps`:
```
Insert output here
```
9. Kill job:
10. Move job to the foreground: 
11. Describe what happens, using process knowledge in your description, if you close / `exit` your connection with this shell and determine if you can reenter the game (resume the process).
   - Answer: 

## Part 4 - Detach

1. Table of `tmux` commands and keybinds:

|  Action   |  Command or Keybind   |  
| ---       | --- | 
| Start a new session and set a name   |     |  
| List `tmux` sessions                 |     |
| Attach to session by name            |     |
| Kill session by name                 |     |
| Detach from session                  |     |
| Split pane horizontally              |     |
| Split pane vertically                |     |
| Switch panes                         |     |
| Close pane                           |     |

2. Create a `tmux` session:
3. Detach from the session:
4. `ps` command:
```
Output of command goes here
```
5. Command to list `tmux` sessions:
```
Output of command goes here
```
6. How can you determine if your `tmux` session with your game running is available?
   - Answer: 
7. Reattach to `tmux` session:
8. Kill `tmux` session: 

## Citations

To add citations, provide the site and a summary of what it assisted you with.  If generative AI was used, include which generative AI system was used and what prompt(s) you fed it.
