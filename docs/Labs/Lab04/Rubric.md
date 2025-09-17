## Rubric

Your answers should be cleanly presented in your GitHub repository.  Citations should be included as needed.  Include which generative AI system was used and what prompts were used if generative AI was used.

### Total Points: 

- Part 1 - 10 pts
  - [ ] `ft` exists
  - [ ] `ft` uses case statement to evaluate if arg 1 was `add` or `remove` or `view` or `clear` or `help`; if none, outputs guide and exists
  - [ ] `ft` `add` and `complete` uses arg 2 or prompts user if arg 2 not given
  - [ ] ONE of `ft` actions - `add`, `remove`, or `view` - calls a function in which task is performed
  - [ ] `ft` `add` appends record to `.finance` in `HOME`
  - [ ] `ft` `complete` removes record from `.finance` in `HOME`
  - [ ] `ft` `view` shows all records in `.finance` in `HOME`
  - [ ] `ft` `clear` removes `.finance` in `HOME`
  - [ ] `ft` `help` calls `user-guide` function
  - [ ] `ft` `user-guide` function outputs a well formatted, meaningful help guide to the user on script usage

- Part 2 - 2 pts
  - [ ] user guide is a well formatted, meaningful help guide to the user on script usage
  - [ ] sample inserted of script performing each action

- Part 3 - 6 pts
  - [ ] valid directory in default PATH  
  - [ ] thoughtful justification of using a symbolic vs hard link in this scenario
  - [ ] valid command to create selected type of link
  - [ ] permissions thoughtfully modified with good scoping in mind
  - [ ] sufficient testing demonstrated / described to validate that `ft` can be run from anywhere on filesystem
  - [ ] sufficient testing demonstrated / described to validate that `ft` can be run by other users

- EC - 1.8 pts
  - (+10%) - requirements to earn:
    - [ ] bonus feature added to script (commit history still reflects a working original script)
    - [ ] bonus feature included in an updated user guide along with example runs

- Point Deductions:
  - [ ] (-50%) / -9 pts - did not record a minimum of three commits while building the `ft` script
  - [ ] (-10%) / -1.8 pts - poor styling / `.md` files do not use good formatting
