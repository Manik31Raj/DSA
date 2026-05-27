# 🔗 Collision Point of Two Linked Lists

---

## 📌 Problem

> Find the **intersection / collision point** of two singly linked lists.

A collision point means:

```text
Both linked lists start sharing the same actual nodes
```

So after the collision, both lists point to the **same memory nodes**, not just same values.

---

## 🌲 Example

Linked List 1:

```text
1 → 2 → 3 → 4 → 5 → 4 → 3 → 2
```

Linked List 2:

```text
1 → 5 → 4 → 3 → 2
```

Here, the common part is:

```text
5 → 4 → 3 → 2
```

So the collision point is node `5`.

---

# 🔥 Core Idea

```text
Use two pointers and let each pointer travel through both lists
```

This equalizes the path length automatically.

---

# 🧠 Why This Works

Suppose:

* `head1` has length `a + c`
* `head2` has length `b + c`

where:

* `a` = unique part of list1
* `b` = unique part of list2
* `c` = shared part

When we switch pointers after one list ends:

* pointer1 walks `a + c + b`
* pointer2 walks `b + c + a`

So both pointers travel the **same total distance**.

That is why they meet at the collision point.

---

# 🔁 Working Principle

---

## Step 1: Start two pointers

```text
temp1 = head1
temp2 = head2
```

---

## Step 2: Move both pointers

At every step:

* move to next node
* if pointer reaches null, jump it to the other list head

This is the key trick.

---

## Step 3: Stop when they meet

When:

```text
temp1 == temp2
```

that node is the collision point.

If both become `null`, then there is no intersection.

---

# 🎯 Intuition

```text
Both pointers are forced to walk the same total distance
```

So they align automatically at the common node.

---

# 🌟 Example With Your Code

You build:

* `arr1 = {1,2,3,4}`
* `arr2 = {1}`
* `common = {5,4,3,2}`

So:

```text
Linked list 1: 1 → 2 → 3 → 4 → 5 → 4 → 3 → 2
Linked list 2: 1 → 5 → 4 → 3 → 2
```

The shared node starts at:

```text
5
```

So answer is:

```text
Collision Point = 5
```

---

# 🔷 Why the Nodes Must Be Shared

This is important:

```text
Collision means same node reference, not same value
```

Two lists can have equal values without intersecting.

They only collide if they share the **same node object**.

---

# ⚠️ Important Notes

```text
This method works only for actual linked list intersection
```

It is not about matching values.

It is about matching node addresses/references.

---

# ❌ Common Mistakes

* ❌ Comparing node values instead of node references
* ❌ Forgetting to switch to the other head after null
* ❌ Thinking same data means collision
* ❌ Not handling no-intersection case
* ❌ Creating separate nodes instead of sharing common nodes

---

# ⚡ Complexity

* **Time Complexity:** O(N + M)
* **Space Complexity:** O(1)

---

## ❓ Why?

Each pointer traverses both lists once.

No extra memory is needed.

---

# 🎯 Interview Insight

👉
“I use two pointers that traverse both linked lists. When one reaches the end, I redirect it to the head of the other list. This makes both pointers cover the same total distance, so they meet at the intersection node if one exists.”

---

# 🔥 Key Insight

```text
Collision point = first shared node in memory
```

---

# 🚀 Key Takeaways

* Collision means same node reference
* Two-pointer switching balances path length
* Works in O(1) space
* Returns null if no intersection exists

---

# 🔥 Pattern Connection

* Two pointers
* Linked list intersection
* Pointer switching technique

---

## ✅ Small Code Note

In this code:

* `temp1` and `temp2` traverse both lists
* when one becomes `null`, it jumps to the other head
* the loop ends when both pointers meet
* returned node is the collision point
