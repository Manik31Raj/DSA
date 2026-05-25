# ➕ Add Two Numbers Using Linked Lists

---

## 📌 Problem

> Given two linked lists representing numbers, add them and return the sum as a linked list.

Each node contains one digit.

---

## 🌲 Example

```text
L1 = 3 → 5
L2 = 4 → 5 → 9 → 9
```

These represent numbers in reverse order:

```text
L1 = 53
L2 = 9994
```

---

## 🎯 Output

```text
7 → 0 → 0 → 0 → 1
```

Because:

```text
53 + 9994 = 10047
```

Stored in reverse order:

```text
7 → 0 → 0 → 4 → 0 → 1
```

For your input format, the logic is the same: add digit by digit with carry.

---

# 🔥 Core Idea

```text
Traverse both linked lists together,
add corresponding digits with carry,
and build the result list node by node.
```

---

# 🧠 Why Linked Lists?

This problem is basically the linked-list version of **column addition**.

Like normal addition:

* add digits
* keep carry
* move to next digit

---

# 🔷 Working Principle

---

## Step 1: Use a dummy node

```text
dummyNode → helps build answer easily
```

It avoids special handling for the first node.

---

## Step 2: Traverse while any list remains

Continue while:

```text
L1 != null OR L2 != null OR carry != 0
```

This ensures:

* all digits are processed
* leftover carry is also included

---

## Step 3: Add values

For each iteration:

```text
val = carry
if L1 exists → add L1.data
if L2 exists → add L2.data
```

---

## Step 4: Extract digit and carry

```text
carry = val / 10
digit = val % 10
```

Then create a new node with `digit`.

---

# 🎯 Intuition

```text
Just like school addition:
right to left, with carry
```

Since the linked list stores digits in reverse order, we can process from head to tail directly.

---

# 🔄 Example Dry Run

Suppose:

```text
L1 = 3 → 5
L2 = 4 → 5 → 9 → 9
```

---

## Iteration 1

```text
3 + 4 = 7
carry = 0
result = 7
```

---

## Iteration 2

```text
5 + 5 = 10
carry = 1
result = 0
```

---

## Iteration 3

```text
0 + 9 + 1 = 10
carry = 1
result = 0
```

---

## Iteration 4

```text
0 + 9 + 1 = 10
carry = 1
result = 0
```

---

## Iteration 5

```text
0 + 0 + 1 = 1
carry = 0
result = 1
```

---

# ⚠️ Important Notes

```text
Lists may have different lengths
```

So we must check each list separately before reading its data.

---

# ❌ Common Mistakes

* ❌ Forgetting carry
* ❌ Stopping when one list ends
* ❌ Not handling final carry
* ❌ Not using dummy node
* ❌ Confusing forward-order and reverse-order representations

---

# ⚡ Complexity

* **Time Complexity:** O(max(N, M))
* **Space Complexity:** O(max(N, M))

Where:

* `N` = length of first list
* `M` = length of second list

---

# 🎯 Interview Insight

👉
“I use a dummy node to build the result list easily. Then I traverse both linked lists together, add digits with carry, and keep appending the remainder digit to the answer. The loop continues until both lists and carry are exhausted.”

---

# 🔥 Key Insight

```text
Linked list addition = digit-by-digit addition with carry
```

---

# 🚀 Key Takeaways

* Use dummy node
* Process both lists together
* Keep track of carry
* Handle unequal lengths
* Append final carry if needed

---

# 🔥 Pattern Connection

* Linked list traversal
* Simulated arithmetic
* Dummy node technique

---

## ✅ Small Code Note

In this code:

* `dummyNode` stores the starting point of result
* `carry` handles overflow
* `while(L1!=null || L2!=null || carry!=0)` ensures all digits are processed
* `curr.next = new Node(val)` appends the result digit
