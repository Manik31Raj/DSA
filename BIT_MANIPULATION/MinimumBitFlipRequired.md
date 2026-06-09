# 🔄 Minimum Bit Flips to Convert One Number into Another

---

# 📌 Problem

Given two integers:

```java
start
goal
```

Find the minimum number of bit flips required to convert:

```text
start → goal
```

A bit flip means:

```text
0 → 1
or
1 → 0
```

---

# 🌲 Example

```java
start = 10
goal  = 7
```

Binary:

```text
10 = 1010
 7 = 0111
```

Required Answer:

```text
3
```

---

# 🔥 Core Idea

Use XOR.

```java
start ^ goal
```

XOR tells exactly which bits are different.

```text
Same Bit      → 0
Different Bit → 1
```

Number of 1s in XOR result = Number of flips required.

---

# 🧠 Why XOR?

Suppose:

```text
10 = 1010
 7 = 0111
```

Perform XOR:

```text
1010
0111
----
1101
```

Result:

```text
1101
```

Count set bits:

```text
1 + 1 + 0 + 1 = 3
```

Therefore:

```text
Minimum flips = 3
```

---

# 🔷 Algorithm

### Step 1

Find differing bits.

```java
int num = start ^ goal;
```

---

### Step 2

Count set bits.

```java
while(num != 0){
    num = num & (num - 1);
    count++;
}
```

---

### Step 3

Return count.

---

# 🎯 Dry Run

```java
start = 10
goal  = 7
```

---

## XOR

```text
1010
0111
----
1101
```

```java
num = 13
```

---

## Iteration 1

```text
1101
1100
----
1100
```

Count:

```text
1
```

---

## Iteration 2

```text
1100
1011
----
1000
```

Count:

```text
2
```

---

## Iteration 3

```text
1000
0111
----
0000
```

Count:

```text
3
```

Loop ends.

---

## Answer

```text
3 Bit Flips Required
```

---

# 🔥 Why `num & (num-1)`?

It removes the rightmost set bit.

Example:

```text
1101
1100
----
1100
```

One set bit removed.

Thus:

```text
Number of loop iterations
=
Number of set bits
```

---

# ⚡ Complexity

### Using Brian Kernighan Algorithm

```java
num = num & (num-1)
```

| Complexity | Value |
|------------|--------|
| Time | O(Number of Set Bits) |
| Space | O(1) |

---

### Alternative Method

```java
while(num > 0){
    count += num & 1;
    num >>= 1;
}
```

| Complexity | Value |
|------------|--------|
| Time | O(log N) |
| Space | O(1) |

---

# 🚀 Quick Revision

| Step | Formula |
|--------|---------|
| Find Different Bits | `start ^ goal` |
| Count Set Bits | `num & (num-1)` |
| Answer | Number of Set Bits |

---

# 🎯 Remember Trick

```text
XOR shows differences

0 → Same Bit
1 → Different Bit

Count 1s in XOR
=
Minimum Bit Flips
```

---

# 🌟 Example Summary

```text
10 = 1010
 7 = 0111

XOR = 1101

Set Bits = 3

Answer = 3
```

---

# 🔥 Pattern Connection

* Bit Manipulation
* XOR Properties
* Brian Kernighan Algorithm
* Set Bit Counting
* Interview Favourite

---

# ✅ Interview Explanation

👉

"To convert one number into another, only the differing bits need to be flipped. XOR gives 1 at positions where bits differ. Therefore, the problem reduces to counting the number of set bits in `start ^ goal`. I use Brian Kernighan's algorithm (`n & (n-1)`) to count set bits efficiently."
