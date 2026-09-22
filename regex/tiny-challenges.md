# Tiny exercises

Focus on data matching

---
```
Call me at 555-234-1189 or the office line (555) 887-2200. Fax: 555.221.0093
```

Match: all three phone numbers, regardless of formatting (dashes, parentheses, or dots).

---
```
Loving the #sunsetvibes tonight, way better than #Monday. Also check out #TBT2024!
```

Match: just the hashtags themselves (including the #), e.g. #sunsetvibes, #Monday, #TBT2024

---
```
Items: Widget $19.99, Gadget $4.50, Bulk Pack $1,299.00, Free Sample $0
```

Match: only the dollar amounts, including the ones with commas in them (so $1,299.00 should match as a whole, not get split up).

---
```
2026-09-22 08:14:03 INFO Starting service
2026-09-22 08:14:05 ERROR Connection refused
2026-09-22 08:15:41 WARN Retry attempt 2
```

Match: just the HH:MM:SS time portion from each line (not the date).

---
```
Thanks @maria_g and @dev.tom for the review! Also cc @Lin99
```

Match: each username without the leading @, e.g. maria_g, dev.tom, Lin99

---
