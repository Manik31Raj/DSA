# 🔢 Decimal to Binary & Binary to Decimal Conversion

---

# 📌 Problem

Convert:

- Decimal Number ➝ Binary Number
- Binary Number ➝ Decimal Number

---

# 🌲 Example

### Decimal to Binary

```text
13 → 1101
```

### Binary to Decimal

```text
1011 → 11
```

---

# 🔥 Core Idea

### Decimal ➝ Binary

```text
Repeatedly divide by 2
Store remainders
Reverse the result
```

---

### Binary ➝ Decimal

```text
Multiply each bit by powers of 2
and add the results
```

---

# 🧠 Why This Approach?

Binary numbers are based on powers of 2.

```text
1011

= 1×2³ + 0×2² + 1×2¹ + 1×2⁰
```

Similarly,

when converting decimal to binary,

```text
repeated division by 2
gives binary digits from right to left.
```

---

# 🔷 Method 1 : Binary to Decimal

```java
public static int binaryToDecimal(String binary)
```

---

## Working

Start from the last bit.

Maintain:

```java
int power = 1;
```

which represents:

```text
2⁰, 2¹, 2², 2³ ...
```

For every bit:

```text
If bit = 1

Add current power to answer
```

Then:

```java
power *= 2;
```

---

# 🌟 Dry Run

```text
Binary = 1011
```

| Bit | Power | Contribution |
|------|--------|-------------|
| 1 | 1 | 1 |
| 1 | 2 | 2 |
| 0 | 4 | 0 |
| 1 | 8 | 8 |

Total:

```text
1 + 2 + 0 + 8

= 11
```

Output:

```text
11
```

---

# 🔷 Method 2 : Decimal to Binary

```java
public static String decimalToBinary(int decimal)
```

---

## Working

Repeatedly divide by 2.

Store:

```text
remainder = decimal % 2
```

Then:

```java
decimal = decimal / 2
```

Continue until:

```text
decimal = 1
```

Finally reverse the string.

---

# 🌟 Dry Run

```text
Decimal = 13
```

Step 1:

```text
13 % 2 = 1
```

Step 2:

```text
6 % 2 = 0
```

Step 3:

```text
3 % 2 = 1
```

Step 4:

```text
1
```

Collected:

```text
1011
```

Reverse:

```text
1101
```

Output:

```text
1101
```

---

# 🎯 Intuition

### Decimal ➝ Binary

```text
Keep dividing by 2
and collect remainders.
```

---

### Binary ➝ Decimal

```text
Expand using powers of 2.
```

---

# ⚠️ Important Notes

### Binary Positions

```text
Bit Position:

8 4 2 1
↓ ↓ ↓ ↓
1 0 1 1
```

Value:

```text
8 + 0 + 2 + 1 = 11
```

---

### Decimal 0

Special Case:

```java
if(decimal==0)
    return "0";
```

---

# ❌ Common Mistakes

❌ Forgetting to reverse binary string

❌ Starting power from 0 instead of 1

❌ Using ASCII values instead of characters

```java
binary.charAt(i) == '1'
```

not

```java
binary.charAt(i) == 1
```

❌ Missing edge case:

```java
decimal = 0
```

---

# ⚡ Complexity

## Binary to Decimal

### Time

```text
O(N)
```

where

```text
N = number of bits
```

### Space

```text
O(1)
```

---

## Decimal to Binary

### Time

```text
O(log₂N)
```

### Space

```text
O(log₂N)
```

(Binary digits stored)

---

# 🎯 Interview Explanation

👉

"To convert binary to decimal, I traverse the binary string from right to left and multiply each set bit by its corresponding power of 2. To convert decimal to binary, I repeatedly divide the number by 2, store the remainders, and reverse the result to obtain the binary representation."

---

# 🔥 Key Insight

```text
Binary is simply powers of 2.
```

```text
Decimal → Binary
= Repeated division by 2

Binary → Decimal
= Sum of powers of 2
```

---

# 🚀 Key Takeaways

* Binary uses base 2
* Decimal uses base 10
* Decimal → Binary uses division by 2
* Binary → Decimal uses powers of 2
* Reverse required while converting decimal to binary

---

# 🔥 Pattern Connection

* Number System Conversion
* Bit Manipulation Basics
* Binary Representation
* Power of Two Concepts

---

# ✅ Example Outputs

```java
binaryToDecimal("1011")
```

Output:

```text
11
```

---

```java
decimalToBinary(13)
```

Output:

```text
1101
```

---

# 📚 Quick Revision

```text
Decimal → Binary
= Divide by 2 repeatedly

Binary → Decimal
= Sum(bit × power of 2)

13 → 1101

1011 → 11
```

---

# ⚡ Complexity Summary

| Operation | Time | Space |
|------------|---------|---------|
| Binary → Decimal | O(N) | O(1) |
| Decimal → Binary | O(log N) | O(log N) |

---

# 🔥 Bit Manipulation Essentials

Binary operations are heavily used in DSA and competitive programming.

---

# 1️⃣ 1's Complement

## Definition

Flip every bit.

```text
0 → 1
1 → 0
```

### Example

```text
1011

↓

0100
```

### Remember Trick 🧠

```text
1's Complement = Invert Bits
```

---

# 2️⃣ 2's Complement

## Definition

```text
2's Complement = 1's Complement + 1
```

### Example

```text
1011

1's Complement

0100

+1

0101
```

### Remember Trick 🧠

```text
Flip + Add 1
```

Used to represent negative numbers.

---

# 3️⃣ Bitwise AND (&)

## Rule

```text
1 & 1 = 1

Everything else = 0
```

### Example

```text
10 = 1010
12 = 1100

1010
1100
----
1000
```

Answer:

```text
8
```

### Remember Trick 🧠

```text
Keeps Common 1s
```

---

# 4️⃣ Bitwise OR (|)

## Rule

```text
If any bit is 1

Answer = 1
```

### Example

```text
10 = 1010
12 = 1100

1010
1100
----
1110
```

Answer:

```text
14
```

### Remember Trick 🧠

```text
Collects All 1s
```

---

# 5️⃣ Bitwise XOR (^)

## Rule

```text
Same      → 0

Different → 1
```

### Example

```text
10 = 1010
12 = 1100

1010
1100
----
0110
```

Answer:

```text
6
```

### Important Properties

```java
a ^ a = 0

a ^ 0 = a
```

### Remember Trick 🧠

```text
Same Remove

Different Keep
```

---

# 6️⃣ Bitwise NOT (~)

## Rule

Flip all bits.

### Example

```java
~5
```

```text
5 = 00000101

~5

11111010
```

Answer:

```text
-6
```

### Formula

```java
~n = -(n + 1)
```

### Examples

```java
~5  = -6

~10 = -11

~0  = -1
```

### Remember Trick 🧠

```text
~n = -(n+1)
```

---

# 7️⃣ Left Shift (<<)

## Rule

Shift bits left.

Add zeros from right.

### Formula

```java
n << k = n × 2^k
```

### Example

```java
5 << 1
```

```text
0101

↓

1010
```

Answer:

```text
10
```

### More Examples

```java
5 << 2 = 20

5 << 3 = 40
```

### Remember Trick 🧠

```text
Left Shift = Multiply by 2
```

---

# 8️⃣ Right Shift (>>)

## Rule

Shift bits right.

### Formula

```java
n >> k = n / 2^k
```

### Example

```java
20 >> 1
```

```text
10100

↓

01010
```

Answer:

```text
10
```

### More Examples

```java
20 >> 2 = 5

40 >> 3 = 5
```

### Remember Trick 🧠

```text
Right Shift = Divide by 2
```

---

# 🎯 Most Important Interview Tricks

## Check Even / Odd

```java
(n & 1)
```

```text
0 → Even

1 → Odd
```

Example:

```java
10 & 1 = 0

11 & 1 = 1
```

---

## Multiply by 2

```java
n << 1
```

---

## Divide by 2

```java
n >> 1
```

---

## Check Power of 2

```java
(n & (n - 1)) == 0
```

Example:

```text
8 = 1000

7 = 0111

1000 & 0111 = 0
```

Power of 2 ✅

---

## Remove Rightmost Set Bit

```java
n & (n - 1)
```

Example:

```text
12 = 1100

11 = 1011

1100
1011
----
1000
```

---

## Count Set Bits

```java
int count = 0;

while(n > 0){
    n = n & (n - 1);
    count++;
}
```

---

# 🚀 Quick Revision Sheet

| Concept | Shortcut / Formula | Remember Trick 🧠 |
|----------|------------------|------------------|
| 1's Complement | Flip all bits | `0 ↔ 1` |
| 2's Complement | 1's Complement + 1 | `Flip + Add 1` |
| AND (`&`) | Common 1s survive | `Common 1s` |
| OR (`\|`) | Any 1 survives | `Collect all 1s` |
| XOR (`^`) | Same = 0, Different = 1 | `Same Remove, Different Keep` |
| NOT (`~`) | `~n = -(n+1)` | `Negative Successor` |
| Left Shift (`<<`) | `n × 2^k` | `Multiply by 2` |
| Right Shift (`>>`) | `n ÷ 2^k` | `Divide by 2` |
| Check Odd / Even | `n & 1` | `1 → Odd, 0 → Even` |
| Remove Rightmost Set Bit | `n & (n-1)` | `Deletes last 1` |
| Check Power of 2 | `(n & (n-1)) == 0` | `Only one bit set` |
| Toggle Bit | `n ^ (1<<i)` | `Flip ith bit` |
| Set Bit | `n \| (1<<i)` | `Make ith bit = 1` |
| Unset Bit | `n & ~(1<<i)` | `Make ith bit = 0` |
| Check ith Bit | `(n & (1<<i)) != 0` | `Bit present?` |
| XOR Property | `a ^ a = 0` | Same numbers cancel |
| XOR Property | `a ^ 0 = a` | Zero changes nothing |
| XOR Property | `a ^ b ^ a = b` | Pair cancellation |
| Count Set Bits | Repeatedly do `n=n&(n-1)` | Remove one 1 at a time |

---

# ⚡ Most Asked Interview Tricks

| Problem | Formula |
|----------|----------|
| Odd / Even | `n & 1` |
| Multiply by 2 | `n << 1` |
| Divide by 2 | `n >> 1` |
| Power of 2 | `(n & (n-1)) == 0` |
| Remove Last Set Bit | `n & (n-1)` |
| Extract Last Set Bit | `n & (-n)` |
| Count Set Bits | `while(n>0){ n=n&(n-1); count++; }` |
| Swap without temp | `a=a^b; b=a^b; a=a^b;` |
| Find Unique Number | XOR all elements |
| Check ith Bit | `(n & (1<<i)) != 0` |
| Set ith Bit | `n \| (1<<i)` |
| Clear ith Bit | `n & ~(1<<i)` |
| Toggle ith Bit | `n ^ (1<<i)` |

---

# 🎯 5 Things To Memorize Before Interviews

| Trick | Formula |
|---------|---------|
| Odd/Even | `n & 1` |
| Power Of 2 | `(n&(n-1))==0` |
| Remove Last Set Bit | `n&(n-1)` |
| Multiply by 2 | `n<<1` |
| Divide by 2 | `n>>1` |

---

# 🔥 Pattern Connection

* Number System Conversion
* Bit Manipulation
* Binary Arithmetic
* Power Of Two Problems
* XOR Based Problems
* Bitmasking
