# 🗑️ Delete All Occurrences of a Key in Doubly Linked List

---

## 📌 Problem

> Delete **all nodes** in a doubly linked list whose value matches a given key.

---

## 🌲 Example

```text
1 ⇄ 4 ⇄ 1 ⇄ 6 ⇄ 1
```

If `key = 1`, then after deletion:

```text
4 ⇄ 6
```

---

# 🔥 Core Idea

```text
Traverse the list node by node.
Whenever the current node matches the key,
remove it by fixing both prev and next links.
```

---

# 🧠 Why DLL Makes This Easy

In a doubly linked list, each node already knows:

* its previous node
* its next node

So removing a node is just a matter of reconnecting both sides.

---

# 🔁 Working Principle

---

## Step 1: Traverse with `temp`

Move through the list from head to tail.

---

## Step 2: If current node matches key

Suppose current node is:

```text
prev ⇄ temp ⇄ next
```

Then delete it by doing:

```text
prev.next = next
next.prev = prev
```

---

## Step 3: Handle head separately

If the node to delete is the head:

```text
head = head.next
```

Then the new head must have:

```text
head.prev = null
```

---

# 🎯 Intuition

```text
Delete a node by cutting it out from both directions.
```

That is the key idea in a doubly linked list.

---

# 🌟 Step-by-Step Connection Logic

---

## Case 1: Node is in the middle

Before deletion:

```text
A ⇄ X ⇄ B
```

After deletion:

```text
A ⇄ B
```

Code logic:

```java
if(nextNode != null) nextNode.prev = prevNode;
if(prevNode != null) prevNode.next = nextNode;
```

---

## Case 2: Node is the head

Before deletion:

```text
X ⇄ A ⇄ B
```

After deletion:

```text
A ⇄ B
```

Code logic:

```java
if(temp == head){
    head = head.next;
}
```

This moves head forward.

---

## Case 3: Node is the tail

Before deletion:

```text
A ⇄ B ⇄ X
```

After deletion:

```text
A ⇄ B
```

Since `nextNode == null`, only:

```java
prevNode.next = null;
```

is needed.

---

# 🔄 Dry Run

Original:

```text
1 ⇄ 4 ⇄ 1 ⇄ 6 ⇄ 1
```

Key = `1`

---

## First 1 (head)

Delete head:

```text
4 ⇄ 1 ⇄ 6 ⇄ 1
```

---

## Middle 1

Delete it:

```text
4 ⇄ 6 ⇄ 1
```

---

## Last 1

Delete it:

```text
4 ⇄ 6
```

Done ✅

---

# ⚠️ Important Notes

```text
After deleting a node, move temp to nextNode
```

This is important because `temp` is removed from the list.

So in your code:

```java
temp = nextNode;
```

prevents skipping nodes and keeps traversal safe.

---

# ❌ Common Mistakes

* ❌ Forgetting to update `nextNode.prev`
* ❌ Forgetting to update `prevNode.next`
* ❌ Not moving `temp` after deletion
* ❌ Not updating head when deleting first node
* ❌ Breaking the list when deleting tail

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

---

# 🎯 Interview Insight

👉
“I traverse the doubly linked list and whenever a node matches the key, I remove it by reconnecting its previous and next nodes. If the node is the head, I move the head pointer forward. I continue until the entire list is processed, so all occurrences are deleted.”

---

# 🔥 Key Insight

```text
DLL deletion = reconnect both neighbors
```

---

# 🚀 Key Takeaways

* Delete all matching nodes
* Update both `prev` and `next`
* Handle head separately
* Keep traversal safe by moving to `nextNode`
* O(1) extra space

---

# 🔥 Pattern Connection

* DLL pointer manipulation
* In-place deletion
* Linear traversal

---

## ✅ Small Code Note

In this code:

* `temp == head` handles deletion at the front
* `prevNode` and `nextNode` are used to reconnect neighbors
* `temp = nextNode` ensures traversal continues correctly after deletion
