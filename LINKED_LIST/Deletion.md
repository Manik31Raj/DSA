# 🗑️ Deletion in Singly Linked List

---

## 📌 Problem

> Delete a node from a singly linked list using different conditions:

* delete head
* delete tail
* delete node at Kth position
* delete node by value

---

# 🔥 Core Idea

```text
Linked list deletion is done by changing links, not shifting elements
```

That is the main difference from arrays.

---

# 🌟 Example Linked List

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 12 → 24 → null
```

---

# 🔷 1) Delete Head

---

## 🧠 Logic

```text
Head moves to the next node
```

If the list has only one node, the result becomes empty.

---

## 🔁 Steps

1. Check if list is empty
2. If only one node exists, return `null`
3. Otherwise return `head.next`

---

## 🎯 Intuition

```text
Just skip the first node
```

---

# 🔷 2) Delete Tail

---

## 🧠 Logic

```text
Move to the second last node and cut its next link
```

---

## 🔁 Steps

1. If list is empty or has only one node, return `null`
2. Traverse until `temp.next.next == null`
3. Set `temp.next = null`

---

## 🎯 Intuition

```text
Remove the last node by breaking link from second last node
```

---

# 🔷 3) Delete Kth Position

---

## 🧠 Logic

```text
Traverse until the Kth node and remove it
```

---

## 🔁 Special Case

If `k == 1`, delete the head directly.

---

## 🔁 Steps

1. If `k == 1`, return `head.next`
2. Traverse with `count`
3. When count reaches `k`, bypass that node using previous node

---

## 🎯 Intuition

```text
prev.next = prev.next.next
```

This skips the Kth node.

---

# 🔷 4) Delete Node by Value

---

## 🧠 Logic

```text
Search for the first node with given value and remove it
```

---

## 🔁 Special Case

If the head itself contains the value, return `head.next`.

---

## 🎯 Intuition

```text
Find the node, then bypass it using previous node
```

---

# 🧠 Important Pointer Idea

In linked list deletion, we usually need:

* `temp` → current node
* `prev` → previous node

Because to delete a node, we must change the `next` of the previous node.

---

# 🌲 Example Deletion

Original:

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 12 → 24
```

### Delete head

```text
2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 12 → 24
```

### Delete tail

```text
2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 12
```

### Delete Kth node (`k = 5`)

```text
2 → 3 → 4 → 5 → 7 → 8 → 9 → 12
```

### Delete value `9`

```text
2 → 3 → 4 → 5 → 7 → 8 → 12
```

---

# ⚠️ Important Notes

```text
Always handle empty list and single-node list carefully
```

These are the most common edge cases.

---

# ❌ Common Mistakes

* ❌ Forgetting to handle head deletion separately
* ❌ Accessing `temp.next.next` without checking null
* ❌ Not maintaining `prev` pointer
* ❌ Forgetting `k == 1` case
* ❌ Not updating head when first node is removed

---

# ⚡ Complexity

| Operation           | Time | Space |
| ------------------- | ---- | ----- |
| Delete Head         | O(1) | O(1)  |
| Delete Tail         | O(N) | O(1)  |
| Delete Kth Position | O(N) | O(1)  |
| Delete by Value     | O(N) | O(1)  |

---

# 🎯 Interview Insight

👉
“In a singly linked list, deletion is done by changing pointers. If I want to remove a node, I first locate the previous node and then bypass the target node using `prev.next = prev.next.next`. For head deletion, I simply move the head pointer.”

---

# 🔥 Key Insight

```text
Linked list deletion = pointer bypassing
```

---

# 🚀 Key Takeaways

* Delete head by moving head
* Delete tail by stopping at second last node
* Delete Kth node using count + prev pointer
* Delete by value using search + bypass
* Handle edge cases first

---

# 🔥 Pattern Connection

* Pointer manipulation
* Linear traversal
* Singly linked list fundamentals

---

## ✅ Small Code Note

In this code:

* `deleteHead()` returns `head.next`
* `deleteTail()` stops at second last node
* `deleteKthPosition()` uses `count` and `prev`
* `deleteValue()` searches for the value and skips that node
