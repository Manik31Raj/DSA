# ➕ Insertion in Doubly Linked List (DLL)

---

## 📌 Problem

> Insert a node in a doubly linked list in different ways:

* insert at head
* insert at tail
* insert at Kth position
* insert after a node with given value

---

# 🔥 Core Idea

```text
Insertion in DLL = create new node + adjust both prev and next links
```

That is the main difference from singly linked list.

---

# 🌟 Example DLL

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 ⇄ 10 → null
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

1. Create new node
2. Set `newHead.next = head`
3. Set `head.prev = newHead`
4. Return new head

---

## 🎯 Intuition

```text
newNode ⇄ oldHead
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

1. Traverse to the last node
2. Set `last.next = newNode`
3. Set `newNode.prev = last`
4. Return original head

---

## 🎯 Intuition

```text
oldTail ⇄ newNode
```

---

# 🔷 3) Insert at Kth Position

---

## 🧠 Logic

```text
Insert new node before the Kth node
```

---

## 🔁 Special Cases

* If `k == 1`, insert at head
* If list is empty and `k == 1`, create single node
* If `k` is out of bounds, insertion is not possible

---

## 🔁 Steps

1. Traverse until the Kth node
2. Create new node
3. Connect:

   * `newNode.prev = prevNode`
   * `newNode.next = currentNode`
   * `prevNode.next = newNode`
   * `currentNode.prev = newNode`

---

## 🎯 Intuition

```text
prev ⇄ newNode ⇄ current
```

---

# 🔷 4) Insert After a Node with Given Value

---

## 🧠 Logic

```text
Find the first node with value target and insert new node after it
```

---

## 🔁 Steps

1. Traverse list until `temp.data == target`
2. Create new node
3. If target node is last:

   * attach at tail
4. Otherwise:

   * connect new node between `temp` and `temp.next`

---

## 🎯 Intuition

```text
target ⇄ newNode ⇄ next
```

---

# 🌲 Example Update Flow

Original:

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 ⇄ 10 → null
```

---

## Insert at Head: `18`

```text
null ← 18 ⇄ 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 ⇄ 10 → null
```

---

## Insert at Tail: `45`

```text
null ← 18 ⇄ 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 ⇄ 10 ⇄ 45 → null
```

---

## Insert at Kth Position: `33` at `k = 5`

```text
null ← 18 ⇄ 1 ⇄ 2 ⇄ 3 ⇄ 33 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 ⇄ 10 ⇄ 45 → null
```

---

## Insert `99` after `33`

```text
null ← 18 ⇄ 1 ⇄ 2 ⇄ 3 ⇄ 33 ⇄ 99 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 ⇄ 10 ⇄ 45 → null
```

---

# ⚠️ Important Notes

```text
DLL insertion must update both prev and next pointers correctly
```

If any pointer is missed, the list breaks.

---

# ❌ Common Mistakes

* ❌ Forgetting to update `prev`
* ❌ Forgetting to update `next`
* ❌ Losing connection to the rest of the list
* ❌ Not handling head separately
* ❌ Not handling empty list

---

# ⚡ Complexity

| Operation              | Time | Space |
| ---------------------- | ---- | ----- |
| Insert at Head         | O(1) | O(1)  |
| Insert at Tail         | O(N) | O(1)  |
| Insert at Kth Position | O(N) | O(1)  |
| Insert after Value     | O(N) | O(1)  |

---

# 🎯 Interview Insight

👉
“In a doubly linked list, insertion is done by creating a new node and adjusting both prev and next references. For head insertion, I directly change the head. For middle or tail insertion, I traverse to the correct place and reconnect both sides around the new node.”

---

# 🔥 Key Insight

```text
DLL insertion = connect both sides properly
```

---

# 🚀 Key Takeaways

* DLL uses both `prev` and `next`
* Head insertion is O(1)
* Tail and middle insertions need traversal
* Always reconnect both links
* Handle boundary cases carefully

---

# 🔥 Pattern Connection

* Pointer manipulation
* Linked list operations
* Double-ended traversal

---

## ✅ Small Code Note

In this code:

* `insertAtHead()` creates a new first node
* `insertAtTail()` walks to the last node and appends
* `insertNodeAtKthPosition()` inserts before the Kth node
* `insertNodeWithValueAfterNode()` inserts after the node with value `target`
