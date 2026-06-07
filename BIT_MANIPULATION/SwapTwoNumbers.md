# 🔄 Swap Two Numbers Using XOR

---

# 📌 Problem

Swap two numbers without using:

- Third Variable
- Temporary Variable

---

# 🌲 Example

```java
x = 12
y = 23
```

After swap:

```java
x = 23
y = 12
```

---

# 🔥 Core Idea

```text
a ^ a = 0
a ^ 0 = a
```

XOR allows us to store information of both numbers temporarily inside one variable.

---

# 🧠 XOR Properties Used

| Expression | Result |
|------------|---------|
| a ^ a | 0 |
| a ^ 0 | a |
| a ^ b ^ a | b |
| a ^ b ^ b | a |

---

# 🔷 Code

```java
x = x ^ y;
y = x ^ y;
x = x ^ y;
```

---

# 🎯 Dry Run

Initial:

```text
x = 12
y = 23
```

Binary:

```text
12 = 01100
23 = 10111
```

---

## Step 1

```java
x = x ^ y;
```

```text
01100
10111
-----
11011
```

```text
x = 27
y = 23
```

---

## Step 2

```java
y = x ^ y;
```

```text
11011
10111
-----
01100
```

```text
y = 12
```

Now:

```text
x = 27
y = 12
```

---

## Step 3

```java
x = x ^ y;
```

```text
11011
01100
-----
10111
```

```text
x = 23
```

Final:

```text
x = 23
y = 12
```

---

# 🔍 Why It Works?

After first step:

```text
x = originalX ^ originalY
```

Second step:

```text
y = (originalX ^ originalY) ^ originalY

  = originalX
```

Third step:

```text
x = (originalX ^ originalY) ^ originalX

  = originalY
```

Numbers get swapped.

---

# ⚠️ Important Note

Works only when:

```java
x and y refer to different memory locations
```

For example:

```java
swap(a,a)
```

is meaningless.

---

# ❌ Common Mistakes

* ❌ Forget XOR properties
* ❌ Use same variable for both values
* ❌ Assume XOR swap is faster than temp variable

Modern compilers optimize:

```java
temp = x;
x = y;
y = temp;
```

very efficiently.

---

# ⚡ Complexity

| Operation | Time | Space |
|------------|------|--------|
| XOR Swap | O(1) | O(1) |

---

# 🚀 Interview Explanation

👉

"I can swap two numbers without using an extra variable by leveraging XOR properties. XOR of a number with itself becomes 0, and XOR with 0 returns the same number. By applying XOR three times, both values get exchanged in constant time and constant space."

---

# 🔥 Key Insight

```text
a ^ b stores information of both numbers

Using XOR again extracts the original values.
```

---

# 🚀 Quick Revision

| Step | Formula |
|--------|---------|
| 1 | x = x ^ y |
| 2 | y = x ^ y |
| 3 | x = x ^ y |

---

# 🎯 Remember Trick

```text
XOR = Hide both values together

1st XOR → Mix
2nd XOR → Recover x
3rd XOR → Recover y
```

---

# 🔥 Pattern Connection

* Bit Manipulation
* XOR Properties
* Constant Space Tricks
* Number Manipulation
