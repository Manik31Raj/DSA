# 🔄 Reverse a Doubly Linked List (DLL)

---

# 📌 Problem

Reverse the doubly linked list.

---

# 🌟 Original DLL

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 ⇄ 10 → null
```

After reversing:

```text
null ← 10 ⇄ 9 ⇄ 8 ⇄ 7 ⇄ 6 ⇄ 5 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 1 → null
```

---

# 🔥 Core Idea

In DLL every node has:

```text
prev pointer
next pointer
```

To reverse DLL:

```text
Swap prev and next for every node
```

---

# 🔷 Method 1 : Reverse by Changing Links (Optimal)

---

# 🧠 Intuition

Suppose a node looks like:

```text
2 ← 3 → 4
```

After reversing:

```text
4 ← 3 → 2
```

So:

```text
prev becomes next
next becomes prev
```

---

# 🔥 Main Logic

```java
temp.prev = temp.next;
temp.next = last;
```

This swaps links.

---

# 🌲 Dry Run

---

# 🌟 Initial DLL

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 → null
```

---

# 🔹 Iteration 1 (Node 1)

Before:

```text
null ← 1 → 2
```

Swap:

```text
2 ← 1 → null
```

Move:

```java
temp = temp.prev;
```

Why?

Because after swapping:

```text
old next becomes new prev
```

---

# 🔹 Iteration 2 (Node 2)

Before:

```text
1 ← 2 → 3
```

After swap:

```text
3 ← 2 → 1
```

---

# 🔹 Final Structure

```text
null ← 4 ⇄ 3 ⇄ 2 ⇄ 1 → null
```

---

# 🔥 Important Variable

```java
Node last = null;
```

Stores previous connection during swapping.

---

# 🔥 Why Return `last.prev` ?

At the end:

```text
temp becomes null
```

and:

```text
last points to old previous node
```

So:

```java
return last.prev;
```

gives the new head.

---

# 🌟 Visual Pointer Movement

---

## Before Swap

```text
prev ← current → next
```

---

## After Swap

```text
next ← current → prev
```

---

# 🔥 Complete Traversal Flow

```text
1 ⇄ 2 ⇄ 3 ⇄ 4
↓
4 ⇄ 3 ⇄ 2 ⇄ 1
```

---

# 🔷 Method 2 : Reverse Using Stack

---

# 🧠 Idea

Instead of changing links:

```text
Store all node values in stack
```

Then:

```text
Overwrite node values in reverse order
```

---

# 🌟 Example

Original:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4
```

Stack:

```text
TOP
4
3
2
1
```

After popping:

```text
4 ⇄ 3 ⇄ 2 ⇄ 1
```

---

# ⚠️ Important Difference

---

## Link Reversal Method

✅ Actual DLL structure changes

---

## Stack Method

❌ Links do NOT change
✅ Only data changes

---

# 🔥 Which is Better?

| Method        | Time | Space | Better?     |
| ------------- | ---- | ----- | ----------- |
| Reverse Links | O(N) | O(1)  | ✅ Best      |
| Stack Method  | O(N) | O(N)  | Extra space |

---

# ❌ Common Mistakes

* ❌ Forgetting to swap both links
* ❌ Moving using wrong pointer after swap
* ❌ Returning wrong head
* ❌ Confusing prev and next
* ❌ Forgetting empty list case

---

# ⚡ Complexity

| Method           | Time | Space |
| ---------------- | ---- | ----- |
| Reverse by Links | O(N) | O(1)  |
| Reverse by Stack | O(N) | O(N)  |

---

# 🎯 Interview Explanation

👉

“In a doubly linked list reversal, I swap the prev and next pointers for every node. Since the links are reversed, traversal continues using the updated prev pointer. Finally, the last processed node becomes the new head.”

---

# 🔥 Key Insight

```text
DLL reversal = swap(prev,next) for every node
```

---

# 🚀 Key Takeaways

✅ DLL reversal is easier than SLL reversal
✅ Swap prev and next pointers
✅ Move using updated prev
✅ Return new head correctly
✅ Link reversal is optimal

---

# 🌟 Final Visualization

---

## Original

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 → null
```

---

## Reversed

```text
null ← 4 ⇄ 3 ⇄ 2 ⇄ 1 → null
```
