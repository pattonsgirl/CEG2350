### Regular expressions

A regular expression (regex for short) allow developers to match strings against a pattern, extract submatch information, or simply test if the string conforms to that pattern.

> Usually such patterns are used by string-searching algorithms for "find" or "find and replace" operations on strings, or for input validation. - [Wiki](https://en.wikipedia.org/wiki/Regular_expression)

---

#### 🚩 The Basics: Characters & Anchors

| Symbol | Description | Example |
| --- | --- | --- |
| `.` | **Wildcard**: Matches any single character except newline. | `b.t` matches `bat`, `bet`, `bit`. |
| `^` | **Start**: Matches the beginning of a line. | `^Hello` matches "Hello world". |
| `$` | **End**: Matches the end of a line. | `bye$` matches "See ya, bye". |
| `\` | **Escape**: Lets you search for special characters like `.` or `*`. | `\.com` matches ".com". |
| ` \| ` | **OR**: Matches the pattern on the left or the right. |

---

#### 🔢 Quantifiers: "How many?"

* `*` : **0 or more** (The "greedy" one).
* `+` : **1 or more** (At least one must exist).
* `?` : **0 or 1** (Makes the character optional).
* `{n}` : **Exactly n** times (e.g., `\d{3}` matches 3 digits).
* `{n,m}` : **Between n and m** times.

---

#### 📦 Character Classes & Shorthand

| Shorthand | Meaning | Equivalent To |
| --- | --- | --- |
| `\d` | Any **Digit** | `[0-9]` |
| `\D` | Any **Non-digit** | `[^0-9]` |
| `\w` | Any **Word character** | `[a-zA-Z0-9_]` |
| `\W` | Any **Non-word character** | (symbols, spaces, etc.) |
| `\s` | Any **Whitespace** | (space, tab, newline) |
| `[abc]` | **Set**: Matches any char in brackets | `a`, `b`, or `c` |
| `[^abc]` | **Negated Set**: Matches anything *except*... | Everything but `a`, `b`, or `c` |

---

**Frequently Used Resources**
- [Regex One - Learning Tutorial](https://regexone.com/)
- [Regex 101 - Expression Generator & Validation Testing](https://regex101.com/)

**Games**
- [Regex Crossword](https://regexcrossword.com/)
- [Regex Golf](https://alf.nu/RegexGolf?world=regex&level=r00)
- [Regexle - REgex Hexagon Puzzles](https://regexle.com/)

**Examples**
- [Wordle in bash by huytd](https://gist.github.com/huytd/6a1a6a7b34a0d0abcac00b47e3d01513)
