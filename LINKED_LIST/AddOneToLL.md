# ➕ Add One to a Number Represented by a Linked List

---

## 📌 Problem

> A linked list represents a number, and we need to add `1` to it.

---

## 🌲 Example

```text
9 → 9 → 9 → 9
```

After adding `1`:

```text
1 → 0 → 0 → 0 → 0
```

---

# 🔥 Core Idea

```text
Add 1 just like normal arithmetic addition with carry
```

The challenge is that the number is stored in a linked list, not in an array.

---

# 🧠 Why Carry Matters

When we add `1` to the last digit:

* if it becomes less than `10`, we stop
* if it becomes `10`, we write `0` and carry `1` to the previous node

So the carry may move from right to left.

---

# 🔷 Approach 1: Recursion

---

## 🧠 Idea

Go to the end of the linked list first, then add while returning back.

This is a very clean way because recursion naturally moves from tail to head.

---

## 🔁 Working Principle

### Step 1

Call recursion until the last node.

### Step 2

The base case returns carry `1`, because we want to add one.

### Step 3

While returning back:

```text
node.data += carry
```

If the value is:

* `< 10` → no more carry
* `>= 10` → store `0` and return carry `1`

---

## 🎯 Intuition

```text
Recursion behaves like reversing the traversal direction
```

So even though the list is forward only, we process it from last to first.

---

## 🌟 Dry Run

For:

```text
9 → 9 → 9 → 9
```

### Last node

```text
9 + 1 = 10
```

Store `0`, carry `1`

### Previous node

```text
9 + 1 = 10
```

Store `0`, carry `1`

### Previous node

```text
9 + 1 = 10
```

Store `0`, carry `1`

### First node

```text
9 + 1 = 10
```

Store `0`, carry `1`

Now carry still remains, so we create a new head:

```text
1 → 0 → 0 → 0 → 0
```

---

# 🔷 Approach 2: Reverse the Linked List

---

## 🧠 Idea

Reverse the list first, then add `1` from the new head, and finally reverse it back.

This converts the problem into normal left-to-right carry addition.

---

## 🔁 Working Principle

### Step 1

Reverse the linked list.

### Step 2

Add `1` starting from the first node.

### Step 3

If carry still remains after finishing all nodes, create a new node.

### Step 4

Reverse the list again to restore original order.

---

## 🎯 Intuition

```text
Reverse → add from front → reverse back
```

This makes the carry flow easy to manage.

---

# 🔄 Example

Original:

```text
9 → 9 → 9 → 9
```

Reverse:

```text
9 → 9 → 9 → 9
```

Add `1`:

```text
0 → 9 → 9 → 9
carry still 1
```

Final after reversing back:

```text
1 → 0 → 0 → 0 → 0
```

---

# ⚠️ Important Notes

```text
If all digits become 9, a new head is needed
```

Example:

```text
9 → 9 → 9
```

becomes:

```text
1 → 0 → 0 → 0
```

---

# ❌ Common Mistakes

* ❌ Forgetting to handle final carry
* ❌ Not creating a new head when carry remains
* ❌ Breaking the list during recursion
* ❌ Forgetting to reverse back in iterative approach
* ❌ Assuming carry can only affect one node

---

# ⚡ Complexity

| Method         | Time | Space |
| -------------- | ---- | ----- |
| Recursion      | O(N) | O(N)  |
| Reverse method | O(N) | O(1)  |

---

# 🎯 Interview Insight

👉
“I either use recursion to propagate carry from the end of the linked list back to the front, or I reverse the list, add one like normal addition, and reverse it back. The key is handling carry correctly, especially when all digits are 9.”

---

# 🔥 Key Insight

```text
Add One = carry propagation through linked list
```

---

# 🚀 Key Takeaways

* Carry moves from tail to head
* Recursion handles it naturally
* Reverse method is space-efficient
* New head is needed if carry remains

---

# 🔥 Pattern Connection

* Linked list arithmetic
* Carry propagation
* Recursion / reversal technique

---

## ✅ Small Code Note

In this code:

* `addHelper(head)` recursively returns carry from the end
* `addOneRecursion(head)` adds a new head if carry remains
* `addOne(head)` reverses the list, adds `1`, and reverses back
* `reverse(head)` is used to simplify addition from the front
