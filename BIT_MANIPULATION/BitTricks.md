# 🎯 Basic Bit Manipulation Operations

---

# 📌 Problem

Perform common bit manipulation operations:

- Check ith bit
- Set ith bit
- Clear ith bit
- Toggle ith bit
- Remove last set bit
- Check power of 2
- Count set bits

---

# 🌲 Example

```java
n = 13
i = 2
```

Binary representation:

```text
13 = 1101
```

Bit positions:

```text
Index : 3 2 1 0
Bits  : 1 1 0 1
```

---

# 🔥 Core Idea

Bit Manipulation uses:

```java
&
|
^
~
<<
>>
```

to perform operations efficiently in O(1).

---

# 🧠 Important Operators

| Operator | Meaning |
|-----------|----------|
| & | AND |
| \| | OR |
| ^ | XOR |
| ~ | NOT |
| << | Left Shift |
| >> | Right Shift |

---

# 🔷 1) Check ith Bit

---

## Method 1: Left Shift

```java
(n & (1<<i)) != 0
```

### Example

```java
13 & (1<<2)

1101
0100
----
0100
```

Result:

```text
Bit is SET
```

---

## Method 2: Right Shift

```java
((n>>i) & 1) != 0
```

### Example

```java
13 >> 2

1101 -> 0011

0011 & 0001 = 1
```

Result:

```text
Bit is SET
```

---

# 🔷 2) Set ith Bit

---

## Formula

```java
n | (1<<i)
```

### Example

```java
13 | (1<<2)

1101
0100
----
1101
```

Output:

```text
13
```

Already set.

---

# 🔷 3) Clear ith Bit

---

## Formula

```java
n & ~(1<<i)
```

### Example

```java
13 & ~(4)

1101
1011
----
1001
```

Output:

```text
9
```

---

# 🔷 4) Toggle ith Bit

---

## Formula

```java
n ^ (1<<i)
```

### Example

```java
13 ^ 4

1101
0100
----
1001
```

Output:

```text
9
```

---

# 🔷 5) Remove Rightmost Set Bit

---

## Formula

```java
n & (n-1)
```

### Example

```java
13 = 1101
12 = 1100

1101
1100
----
1100
```

Output:

```text
12
```

---

# Why It Works?

```text
n      = xxxx1000...
n - 1  = xxxx0111...
```

AND removes the rightmost set bit.

---

# 🔷 6) Check Power of 2

---

## Formula

```java
(n > 0) && ((n & (n-1)) == 0)
```

### Examples

```text
8  -> 1000 ✔
16 -> 10000 ✔
13 -> 1101 ✖
```

---

# Why It Works?

Power of 2 has exactly one set bit.

```text
1000
0111
----
0000
```

---

# ⚠️ Small Bug In Your Code

You wrote:

```java
(n & n-1)
```

and

```java
(n & n-1)==0
```

Always write:

```java
(n & (n-1))
```

because `-` has higher precedence than `&`.

Correct:

```java
n & (n-1)
```

---

# 🔷 7) Count Number of Set Bits

---

## Method 1: Brian Kernighan Algorithm (Best)

```java
while(x != 0){
    x = x & (x-1);
    count++;
}
```

### Example

```text
13 = 1101

1101 -> 1100
1100 -> 1000
1000 -> 0000

Count = 3
```

---

## Complexity

| Method | Time |
|----------|------|
| Normal Bit Check | O(log n) |
| Brian Kernighan | O(Number of Set Bits) |

---

## Method 2: Right Shift

```java
while(x > 0){
    count += (x & 1);
    x >>= 1;
}
```

### Example

```text
1101

1 -> count=1
0 -> count=1
1 -> count=2
1 -> count=3
```

Output:

```text
3
```

---

# ⚡ Complexity

| Operation | Time | Space |
|------------|------|--------|
| Check Bit | O(1) | O(1) |
| Set Bit | O(1) | O(1) |
| Clear Bit | O(1) | O(1) |
| Toggle Bit | O(1) | O(1) |
| Remove Last Set Bit | O(1) | O(1) |
| Check Power of 2 | O(1) | O(1) |
| Count Set Bits | O(log n) | O(1) |

---

# 🚀 Quick Revision Sheet

| Problem | Formula |
|----------|----------|
| Check ith Bit | `(n&(1<<i))!=0` |
| Check ith Bit | `((n>>i)&1)!=0` |
| Set ith Bit | `n \| (1<<i)` |
| Clear ith Bit | `n & ~(1<<i)` |
| Toggle ith Bit | `n ^ (1<<i)` |
| Remove Last Set Bit | `n & (n-1)` |
| Check Power Of 2 | `(n>0)&&((n&(n-1))==0)` |
| Count Set Bits | `x=x&(x-1)` |

---

# 🎯 Remember Trick

```text
&  → Check / Remove
|  → Set
^  → Toggle
~  → Invert

<< → Multiply by 2
>> → Divide by 2

n&(n-1)
→ Removes last 1(set)

(n&(n-1))==0
→ Power of 2

x=x&(x-1)
→ Count set bits
```

---

# 🔥 Pattern Connection

* Bit Manipulation
* Binary Representation
* XOR Tricks
* Number Theory
* Competitive Programming
* Interview Bit Hacks
