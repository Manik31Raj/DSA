# 🔢 Power Set Using Bit Manipulation

---

# 📌 Problem

Given an array:

```java
nums = [1,2,3]
```

Generate all possible subsets (Power Set).

---

# 🌲 Example

Input:

```java
[1,2,3]
```

Output:

```text
[]
[1]
[2]
[1,2]
[3]
[1,3]
[2,3]
[1,2,3]
```

Total subsets:

```text
2^3 = 8
```

---

# 🔥 Core Idea

Every element has only two choices:

```text
Include
Exclude
```

For `n` elements:

```text
2 × 2 × 2 × ... × 2
          n times

= 2^n subsets
```

Bit Manipulation helps represent these choices.

---

# 🧠 Bit Representation

For:

```java
nums = [1,2,3]
```

Indices:

```text
0 1 2
```

Use a binary number of length 3.

```text
Bit = 1 → Include element
Bit = 0 → Exclude element
```

---

# 🌟 Binary Mapping

| Decimal | Binary | Subset |
|----------|---------|---------|
| 0 | 000 | [] |
| 1 | 001 | [1] |
| 2 | 010 | [2] |
| 3 | 011 | [1,2] |
| 4 | 100 | [3] |
| 5 | 101 | [1,3] |
| 6 | 110 | [2,3] |
| 7 | 111 | [1,2,3] |

---

# 🔷 Why `1 << n`?

```java
int subsets = 1 << n;
```

Left shift:

```text
1 << n = 2^n
```

Example:

```java
n = 3

1 << 3

0001
↓

1000

= 8
```

So:

```java
subsets = 8
```

---

# 🔷 Outer Loop

```java
for(int i=0;i<subsets;i++)
```

Runs from:

```text
0 → 7
```

Each number represents one subset.

---

# 🔷 Inner Loop

```java
for(int j=0;j<n;j++)
```

Checks every bit position.

---

# 🔷 Important Condition

```java
(i & (1<<j)) != 0
```

Meaning:

```text
Is jth bit set?
```

If yes:

```java
subList.add(nums[j]);
```

---

# 🎯 Dry Run

## i = 5

Binary:

```text
5 = 101
```

---

### j = 0

```java
5 & (1<<0)

101
001
---
001
```

Non-zero ✔

Add:

```text
1
```

Subset:

```text
[1]
```

---

### j = 1

```java
5 & (1<<1)

101
010
---
000
```

Zero ❌

Don't add.

---

### j = 2

```java
5 & (1<<2)

101
100
---
100
```

Non-zero ✔

Add:

```text
3
```

Subset:

```text
[1,3]
```

---

# 🌟 Complete Dry Run

### i = 0

```text
000 → []
```

---

### i = 1

```text
001 → [1]
```

---

### i = 2

```text
010 → [2]
```

---

### i = 3

```text
011 → [1,2]
```

---

### i = 4

```text
100 → [3]
```

---

### i = 5

```text
101 → [1,3]
```

---

### i = 6

```text
110 → [2,3]
```

---

### i = 7

```text
111 → [1,2,3]
```

---

# 🔥 Visualization

```text
nums = [1,2,3]

000 → []
001 → [1]
010 → [2]
011 → [1,2]
100 → [3]
101 → [1,3]
110 → [2,3]
111 → [1,2,3]
```

---

# ⚡ Complexity

### Total Subsets

```text
2^n
```

### For each subset

```text
n bit checks
```

### Time Complexity

```text
O(n × 2^n)
```

---

### Space Complexity

```text
O(n × 2^n)
```

(Storing all subsets)

---

# 🚀 Quick Revision

| Formula | Meaning |
|----------|----------|
| `1<<n` | Total subsets = 2^n |
| `1<<j` | Mask for jth bit |
| `i&(1<<j)` | Check if jth bit is set |
| Bit = 1 | Include element |
| Bit = 0 | Exclude element |

---

# 🎯 Remember Trick

```text
Power Set
=
All Binary Numbers
from
0 → 2^n - 1

0 → Exclude
1 → Include
```

Example:

```text
101

1 → Take 1
0 → Skip 2
1 → Take 3

Subset = [1,3]
```

---

# 🔥 Pattern Connection

* Bit Manipulation
* Subset Generation
* Backtracking Alternative
* Combinatorics
* Power Set Problems

---

# ✅ Interview Explanation

👉

"Every subset can be represented by a binary number from `0` to `2^n - 1`. Each bit indicates whether an element is included or excluded. I iterate through all binary masks and use bitwise AND to check which elements belong to the current subset."
