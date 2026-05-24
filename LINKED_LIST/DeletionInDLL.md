# 🗑️ Deletion in Doubly Linked List (DLL)

---

## 📌 Problem

> Delete a node from a **doubly linked list** in different ways:

* delete head
* delete tail
* delete node at Kth position
* delete node by value

---

# 🔥 Core Idea

```text
In DLL, deletion is done by changing both next and prev links
```

That is the main advantage over singly linked list.

---

# 🌟 Example DLL

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 ⇄ 10 → null
```

---

# 🔷 Why DLL Deletion is Easier?

In singly linked list, we need the previous node to delete.

In doubly linked list:

```text
prev and next both are available
```

So link adjustment is easier.

---

# 🔷 1) Delete Head

---

## 🧠 Logic

```text
Move head to the next node and break backward link
```

---

## 🔁 Steps

1. If list is empty or has one node, return `null`
2. Move head to `head.next`
3. Set `head.prev = null`

---

## 🎯 Intuition

```text
oldHead is removed, new head becomes first node
```

---

# 🔷 2) Delete Tail

---

## 🧠 Logic

```text
Move to last node, then disconnect it from previous node
```

---

## 🔁 Steps

1. If list is empty or has one node, return `null`
2. Traverse to the last node
3. Let `newTail = temp.prev`
4. Set `newTail.next = null`
5. Break old tail’s `prev`

---

## 🎯 Intuition

```text
secondLast.next = null
```

---

# 🔷 3) Delete Node at Kth Position

---

## 🧠 Logic

```text
Find Kth node and remove it using both links
```

---

## 🔁 Special Case

If `k == 1`, delete head.

---

## 🔁 Steps

1. If `k == 1`, move head ahead
2. Traverse until position `k`
3. If node is last:

   * set `temp.prev.next = null`
4. Else:

   * connect `temp.prev.next = temp.next`
   * connect `temp.next.prev = temp.prev`

---

## 🎯 Intuition

```text
prev ↔ temp ↔ next
becomes
prev ↔ next
```

---

# 🔷 4) Delete Node by Value

---

## 🧠 Logic

```text
Search for first node with given value and remove it
```

---

## 🔁 Steps

1. If head contains the value:

   * delete head
2. Otherwise traverse until found
3. Use prev and next pointers to bypass the node

---

## 🎯 Intuition

```text
remove the node from both sides
```

---

# 🌲 Example Deletion Flow

Original:

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 ⇄ 10 → null
```

---

## Delete Head

```text
null ← 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 ⇄ 10 → null
```

---

## Delete Tail

```text
null ← 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 6 ⇄ 7 ⇄ 8 ⇄ 9 → null
```

---

## Delete Node at Kth Position (`k = 5`)

```text
null ← 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 7 ⇄ 8 ⇄ 9 → null
```

---

## Delete Node with Value `8`

```text
null ← 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ 7 ⇄ 9 → null
```

---

# ⚠️ Important Notes

```text
DLL deletion must update both prev and next pointers correctly
```

If one pointer is missed, the list structure breaks.

---

# ❌ Common Mistakes

* ❌ Forgetting to update `prev` link
* ❌ Forgetting to update `next` link
* ❌ Not handling head separately
* ❌ Not handling single-node list
* ❌ Breaking the list by not disconnecting removed node

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
“In a doubly linked list, deletion is easier because each node knows both its previous and next node. So removing a node is just a matter of reconnecting the previous and next pointers and fixing the head or tail when needed.”

---

# 🔥 Key Insight

```text
DLL deletion = reconnect prev and next
```

---

# 🚀 Key Takeaways

* DLL stores both prev and next pointers
* Head deletion is O(1)
* Middle/tail deletion needs traversal
* Both links must be updated
* Edge cases are important

---

# 🔥 Pattern Connection

* Pointer manipulation
* Linked list operations
* Linear traversal

---

## ✅ Small Code Note

In this code:

* `deleteHead()` moves head ahead and clears `prev`
* `deleteTail()` finds last node and disconnects it
* `deleteNodeAtKthPosition()` updates both neighbors
* `deleteNodeWithValue()` searches and removes matching node
