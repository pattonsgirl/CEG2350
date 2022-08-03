# Regex cheat sheet

## Special characters

- \ = Indicates that the following character should be treated specially, or "escaped"
- ^ = Matches the beginning of input
- $ = Matches the end of input
- x\* = Matches the preceding item "x" 0 or more times
- x+ = Matches the preceding item "x" 1 or more times. Equivalent to {1,}
- x? = Matches the preceding item "x" 0 or 1 times

## Character classes

- \w = Matches any alphanumeric character from the basic Latin alphabet, including the underscore. Equivalent to [A-Za-z0-9_]
- \W = Matches any character that is not a word character from the basic Latin alphabet. Equivalent to [^a-za-z0-9_]
- \d = Matches any digit (Arabic numeral). Equivalent to [0-9]
- \D = Matches any character that is not a digit (Arabic numeral). Equivalent to [^0-9]
- \s = Matches a single white space character, including space, tab, form feed, line feed, and other Unicode spaces
- \S = Matches a single character other than white space.
