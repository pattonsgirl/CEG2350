## Lab 08

- Name:
- Email

## Part 1 - Game the system

- Game name: 
- How to install:
- Location of game executable:
- How to run game:

## Part 2 - Process Control

1. `ps` field descriptions:
   - USER / UID:
   - PID:
   - PPID:
   - TTY:
   - STAT:
   - COMMAND / CMD:
2. `ps` command:
3. Output of `ps` with two shells, one running the game:
```
Output of command goes here
```
4. For the game:
   - Process id: 
   - Parent process id: 
   - What is the parent process: 
5. `kill` to kill only the game:
   - Describe what the effect was: 
6. `kill` to kill the game and it's parent process: 
   - Describe what the effect was:
7. Describe what happens if you close / `exit` your connection with Shell C and determine if you can reenter the game (resume the process).
   - Answer: 

## Part 3 - back and fore

1. Run in the foreground: 
2. `STOP` signal to suspend it: 
3. Proof of life from `ps` output:
```
insert line here
```
4. Resume in the foreground:
5. `TERMINATE` signal to kill it: 
6. Start as a background process: 
7. Output of `jobs` from controlling terminal:
```
Insert output here
```
Output of `ps`:
```
Insert output here
```
8. Kill job:
9. Move job to the foreground: 
10. Describe what happens, using process knowledge in your description, if you close / `exit` your connection with this shell and determine if you can reenter the game (resume the process).
   - Answer: 

## Part 4 - Detach

1. Create a `tmux` session:
2. Detach from the session:
3. `ps` command:
```
Output of command goes here
```
4. Command to list `tmux` sessions:
```
Output of command goes here
```
5. How can you determine if your `tmux` session with your game running is available?
   - Answer: 
7. Reattach to `tmux` session:
8. Kill `tmux` session: 
