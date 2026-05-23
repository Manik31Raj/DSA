# ➕ Insertion in Singly Linked List

---

## 📌 Problem

> Insert a node into a singly linked list at different positions:

* at head
* at tail
* at Kth position
* before a given value

---

# 🔥 Core Idea

```text
Insertion in linked list = create new node + adjust links
```

Unlike arrays, no shifting is needed.

---

# 🌟 Example Linked List

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 12 → 24 → null
```

---

# 🔷 1) Insert at Head

---

## 🧠 Logic

```text
New node becomes the new first node
```

---

## 🔁 Steps

1. Create a new node
2. Point its `next` to current head
3. Return the new node as head

---

## 🎯 Intuition

```text
newNode → oldHead
```

---

# 🔷 2) Insert at Tail

---

## 🧠 Logic

```text
Move to last node and attach new node there
```

---

## 🔁 Steps

1. Traverse till `temp.next == null`
2. Set `temp.next = new Node(val)`

---

## 🎯 Intuition

```text
oldTail → newNode
```

---

# 🔷 3) Insert at Kth Position

---

## 🧠 Logic

```text
Insert new node before the Kth index position
```

If `k = 1`, insert at head.

---

## 🔁 Steps

1. If `k == 1`, create new head
2. Traverse until `count == k - 1`
3. Insert new node using:

```text
temp.next = new Node(val, temp.next)
```

---

## 🎯 Intuition

```text
prev → newNode → next
```

---

# 🔷 4) Insert Before a Given Value

---

## 🧠 Logic

```text
Find the first node whose value is x,
then insert new node before it
```

---

## 🔁 Steps

1. If head itself has value `x`, insert before head
2. Otherwise traverse list
3. Check `temp.next.data == x`
4. Insert new node before that node

---

## 🎯 Intuition

```text
prev → newNode → x
```

---

# 🌲 Example Update Flow

Original:

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 12 → 24
```

---

## Insert at Head: `25`

```text
25 → 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 12 → 24
```

---

## Insert at Tail: `45`

```text
25 → 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 12 → 24 → 45
```

---

## Insert at Kth Position: `18` at `k = 6`

```text
25 → 1 → 2 → 3 → 4 → 18 → 5 → 6 → 7 → 8 → 9 → 12 → 24 → 45
```

---

## Insert `100` before `9`

```text
25 → 1 → 2 → 3 → 4 → 18 → 5 → 6 → 7 → 8 → 100 → 9 → 12 → 24 → 45
```

---

# ⚠️ Important Notes

```text
Always handle head separately when needed
```

Some insertions are impossible if the position or value does not exist.

---

# ❌ Common Mistakes

* ❌ Forgetting to update head
* ❌ Losing the rest of the list while inserting
* ❌ Not handling empty list
* ❌ Wrong Kth position logic
* ❌ Forgetting to stop after insertion

---

# ⚡ Complexity

| Operation              | Time | Space |
| ---------------------- | ---- | ----- |
| Insert at Head         | O(1) | O(1)  |
| Insert at Tail         | O(N) | O(1)  |
| Insert at Kth Position | O(N) | O(1)  |
| Insert before Value    | O(N) | O(1)  |

---

# 🎯 Interview Insight

👉
“In a singly linked list, insertion is done by creating a new node and changing pointers. At the head, I directly make the new node the head. At the tail or middle, I traverse to the correct place and adjust links so the new node fits into the chain.”

---

# 🔥 Key Insight

```text
Linked list insertion = pointer linking
```

---

# 🚀 Key Takeaways

* Head insertion is O(1)
* Tail and middle insertions need traversal
* Kth position insertion uses previous node
* Before-value insertion searches for target
* No shifting needed like arrays

---

# 🔥 Pattern Connection

* Pointer manipulation
* Linear traversal
* Singly linked list basics

---

## ✅ Small Code Note

In this code:

* `insertAtHead()` creates a new head node
* `insertAtTail()` walks to the last node and appends
* `insertKthPosition()` inserts before the Kth node
* `insertValue()` inserts before the first node having value `x`
