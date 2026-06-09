# 🔢 Find the Single Number Using XOR

---

# 📌 Problem

Given an array where:

- Every element appears exactly **twice**
- Except one element which appears **once**

Find that unique element.

---

# 🌲 Example

```java
nums = [1,2,2,3,3,43,23,23,43,1,25]
```

Output:

```text
25
```

---

# 🔥 Core Idea

Use XOR (`^`).

Important XOR Properties:

```text
a ^ a = 0

a ^ 0 = a
```

So duplicate numbers cancel each other.

Only the unique number remains.

---

# 🧠 Why XOR Works?

Array:

```text
1,2,2,3,3,43,23,23,43,1,25
```

Perform XOR of all elements:

```text
1 ^ 2 ^ 2 ^ 3 ^ 3 ^ 43 ^ 23 ^ 23 ^ 43 ^ 1 ^ 25
```

Group duplicates:

```text
(1^1)
(2^2)
(3^3)
(43^43)
(23^23)
^ 25
```

Since:

```text
a ^ a = 0
```

becomes:

```text
0 ^ 0 ^ 0 ^ 0 ^ 0 ^ 25
```

Result:

```text
25
```

---

# 🔷 Algorithm

Initialize:

```java
ans = nums[0]
```

---

Traverse array:

```java
ans = ans ^ nums[i]
```

---

After all XOR operations:

```java
return ans;
```

---

# 🎯 Dry Run

```java
nums = [1,2,2,3,3,1,5]
```

---

### Start

```text
ans = 1
```

---

### XOR 2

```text
1 ^ 2 = 3
```

```text
ans = 3
```

---

### XOR 2

```text
3 ^ 2 = 1
```

```text
ans = 1
```

---

### XOR 3

```text
1 ^ 3 = 2
```

```text
ans = 2
```

---

### XOR 3

```text
2 ^ 3 = 1
```

```text
ans = 1
```

---

### XOR 1

```text
1 ^ 1 = 0
```

```text
ans = 0
```

---

### XOR 5

```text
0 ^ 5 = 5
```

```text
ans = 5
```

---

Result:

```text
5
```

---

# 🌟 Visualization

```text
1 ^ 1 = 0

2 ^ 2 = 0

3 ^ 3 = 0

0 ^ 0 ^ 0 ^ 5

= 5
```

---

# ⚡ Complexity

| Complexity | Value |
|------------|--------|
| Time | O(n) |
| Space | O(1) |

---

# ❌ Brute Force Approaches

### HashMap

```java
HashMap<Integer,Integer>
```

Count frequencies.

Time:

```text
O(n)
```

Space:

```text
O(n)
```

---

### Sorting

Sort first and find odd occurrence.

Time:

```text
O(n log n)
```

Space:

```text
O(1)
```

---

# ✅ Why XOR is Best?

| Approach | Time | Space |
|-----------|------|--------|
| HashMap | O(n) | O(n) |
| Sorting | O(n log n) | O(1) |
| XOR | O(n) | O(1) ✅ |

---

# 🚀 Quick Revision

| XOR Property | Result |
|--------------|---------|
| `a ^ a` | 0 |
| `a ^ 0` | a |
| `a ^ b ^ a` | b |
| `a ^ b ^ b` | a |

---

# 🎯 Remember Trick

```text
Same Numbers Cancel

a ^ a = 0

Only the unique number survives.
```

Example:

```text
1 ^ 2 ^ 2 ^ 1 ^ 5

↓

0 ^ 0 ^ 5

↓

5
```

---

# 🔥 Pattern Connection

* Bit Manipulation
* XOR Properties
* Single Number
* Unique Element Problems
* Interview Favourite

---

# ✅ Interview Explanation

👉

"I XOR all elements of the array. Since XOR of a number with itself becomes zero and XOR with zero returns the same number, all duplicate elements cancel each other out. The remaining value is the element that appears only once."
