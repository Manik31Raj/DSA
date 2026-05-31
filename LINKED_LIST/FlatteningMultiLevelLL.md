# 🔽 Flattening a Multi-Level Linked List

---

# 📌 Problem

> Given a multi-level linked list where:
- `next` points to the next root node
- `child` points to a sorted child linked list

Flatten the structure into **one single sorted linked list** using only the `child` pointers.

---

# 🌲 Example

Suppose the structure is:

```text
Root 1: 3
Root 2: 2 → 10
Root 3: 1 → 7 → 11 → 12
Root 4: 4 → 9
Root 5: 5 → 6 → 8
```

Each child list is already sorted.

After flattening, we want:

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10 → 11 → 12
```

using only `child` links.

---

# 🔥 Core Idea

```text
Flatten the list from right to left,
and merge two sorted child lists at a time.
```

This is very similar to **merge step of merge sort**.

---

# 🧠 Why This Works

Each child list is already sorted.

So if we flatten the list on the right side first, and then merge it with the current root’s child list, we always merge **two sorted lists**.

That means the final list stays sorted.

---

# 🔷 Structure of the Multi-Level List

Each node has:

| Pointer | Meaning |
|---|---|
| `next` | next root node |
| `child` | next node in the same vertical sublist |

Example:

```text
3 → 2 → 1 → 4 → 5    (next chain)
|   |   |   |   |
v   v   v   v   v
```

The actual children form sorted vertical chains.

---

# 🔁 Working Principle

---

## Step 1: Recursive flatten from right side

```java
Node mergedHead = flattenLinkedList(head.next);
```

This means:

- first flatten the linked list starting from the next root
- then merge current root’s child list with that flattened result

---

## Step 2: Merge two sorted child lists

```java
head = merge(head, mergedHead);
```

This merges:

- current root’s child chain
- flattened chain from the right

---

# 🔷 Base Case

```java
if(head == null || head.next == null) return head;
```

This means:

- if there is no node, return null
- if only one root node exists, it is already flattened

---

# 🔥 Merge Function

This is the most important part.

---

## Goal of `merge(n1, n2)`

Merge two sorted linked lists using the `child` pointer.

---

## Dummy Node Trick

```java
Node dummy = new Node(-1);
Node res = dummy;
```

Dummy node helps build the result list easily.

---

## Merge Logic

At every step:

- compare `n1.data` and `n2.data`
- attach the smaller node to `res.child`
- move that pointer forward

---

## Why use `child` instead of `next`?

Because after flattening, the final linked list should be formed through the `child` links only.

So:

- `next` is ignored in the flattened result
- `child` becomes the main chain

---

# 🔗 Important Part in Merge

Inside the loop:

```java
res.child = n1;
n1 = n1.child;
```

or

```java
res.child = n2;
n2 = n2.child;
```

Then:

```java
res = res.child;
res.next = null;
```

---

## Why `res.next = null`?

This is very important.

Because after flattening:

- we do not want any `next` links in the final structure
- only `child` pointers should remain

So we explicitly remove `next` links.

---

# 🌟 Dry Run

Suppose we flatten from right to left:

---

## Flatten last two lists

```text
4 → 9
5 → 6 → 8
```

Merged:

```text
4 → 5 → 6 → 8 → 9
```

---

## Merge with next list

```text
1 → 7 → 11 → 12
```

Merged:

```text
1 → 4 → 5 → 6 → 7 → 8 → 9 → 11 → 12
```

---

## Merge with next list

```text
2 → 10
```

Merged:

```text
1 → 2 → 4 → 5 → 6 → 7 → 8 → 9 → 10 → 11 → 12
```

---

## Merge with first root

```text
3
```

Final flattened list:

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10 → 11 → 12
```

---

# 🎯 Intuition

```text
Flattening a multi-level linked list is just repeated merging of sorted lists.
```

The recursion handles the right side first, so every merge happens between two already sorted lists.

---

# ⚠️ Important Notes

```text
This approach works because each child list is sorted.
```

If the child lists are not sorted, this merge-based flattening will not produce a sorted final list.

---

# ❌ Common Mistakes

* ❌ Forgetting that final list must use `child` links
* ❌ Not setting `next = null` in merged result
* ❌ Merging unsorted child lists as if they are sorted
* ❌ Forgetting recursion on `head.next`
* ❌ Returning wrong pointer from merge function

---

# ⚡ Complexity

Let total number of nodes be `N`.

* **Time Complexity:** O(N log K) in the general repeated merge sense, where `K` is number of root lists  
  In many interview explanations, this is often written as O(N × K) depending on merge strategy.
* **Space Complexity:** O(K) due to recursion stack

Here `K` = number of root-level nodes.

---

# 🎯 Interview Insight

👉  
“I flatten the list recursively from right to left. For each root node, I first flatten the list to its right, then merge the current sorted child list with that flattened list. Since both lists are sorted, merging is linear.”

---

# 🔥 Key Insight

```text
Multi-level LL flattening = recursive flatten + merge sorted child lists
```

---

# 🚀 Key Takeaways

* Root nodes are connected by `next`
* Child lists are already sorted
* Flatten from right to left
* Merge using `child` pointers
* Remove `next` links in final structure

---

# 🔥 Pattern Connection

* Linked list merge
* Recursion
* Divide and conquer
* Multi-level list processing

---

## ✅ Small Code Note

In this code:

- `flattenLinkedList(head.next)` flattens the right side first
- `merge(head, mergedHead)` merges two sorted child lists
- `res.next = null` removes `next` links in the flattened list
- `dummy.child` is returned as the new head of the flattened list
