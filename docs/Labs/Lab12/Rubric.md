## Rubric

Your answers should be cleanly presented in your GitHub repository. Citations should be included as needed. Include which generative AI system was used and what prompts were used if generative AI was used.

### Total Points / 35

- Repo Contains - 3 pts
    - [ ] README
    - [ ] Java or Python client source code
    - [ ] Java or Python server source code

- Part 1 -  8 pts - 0.25 pt per line on table
    - [ ] Linux Command Cheat Sheet
    - [ ] Image / code block of networking settings for **student's device**
    - [ ] Settings table filled in with reasonable values
    - [ ] Image / code block of networking settings for **student's AWS instance**
    - [ ] Settings table filled in with accurate values

- Part 2 - 5 pts
    - [ ] Link to server side source code
    - [ ] Server side code with comments
    - [ ] Link to client side source code
    - [ ] Client side code with comments
    - [ ] Screenshot of communications

- Part 3 - 12 pts (2 pts each)
    - [ ] Screenshot of updated Security Group Rules
        - [ ] rule that allows SSH access from any WSU IPv4 address - 130.108.0.0 - 130.108.255.255
        - [ ] rule that allows SSH access from your home public IPv4 address - is a PUBLIC IP with a `/32` 
        - [ ] rule that allows HTTP access from any IPv4 address or all addresses from 0.0.0.0 - 255.255.255.255 - is a `/0` rule
        - [ ] rule (or rules) that allow access to port 8080 from any (or only trusted) IPv4 address
    - [ ] Validation Response

- Part 4 - 5 pts
    - [ ] ICMP & Firewalls Reflection
    - [ ] HTTP vs HTTPS
    - [ ] Raw Packet Captures
    - [ ] DNS Lookup
    - [ ] Troubleshooting Tips

- Part 5 - 2 pts (0.5 pt per part)
    - [ ] Part 1 citation (may refer to table above)
    - [ ] Part 2 citation
    - [ ] Part 3 citation
    - [ ] Part 4 citation

- Extra Credit - 3 pts
    - [ ] IPv4 Source Report Table
    - [ ] Commands to parse `csv` for report
    - [ ] Username Used Report Table
    - [ ] Commands to parse `csv` for report

- Point Deductions
    - [ ] AI Overuse / AI Generated - 0 Points
    - [ ] Submitted to incorrect repository - 0 points
    - [ ] Submitted past due date - 0 points
    - [ ] Submitted non-markdown (incorrect extensions / no use of markdown for formatting) - 0 points
    - [ ] Submitted some markdown (legible enough for grading), but needs improvement - (-10%)
    - [ ] Failure to cite resources - (-10%)
    - [ ] No branches and/or issues were created -  (-10%)
    - [ ] Only one bulk commit (not multiple commits to reflect lab progress) - (-10%)
