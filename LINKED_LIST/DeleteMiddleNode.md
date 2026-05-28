# 🗑️ Delete Middle Node of Linked List

---

## 📌 Problem

> Delete the **middle node** of a singly linked list.

For even length, this approach deletes the **second middle** node.

---

## 🌲 Example

```text
1 → 2 → 4 → 3 → 9 → 12 → 5
```

Middle node is:

```text
3
```

After deletion:

```text
1 → 2 → 4 → 9 → 12 → 5
```

---

# 🔥 Core Idea

```text
Use slow and fast pointers to find the middle,
then skip that node
```

---

# 🧠 Why This Works

* slow moves 1 step
* fast moves 2 steps

When fast reaches the end, slow is at the middle.

Then we simply do:

```text
slow.next = slow.next.next
```

to remove the middle node.

---

# 🔷 Working Principle

---

## Step 1: Handle small cases

If list is empty or has only one node:

```text
return null
```

Because after deleting the middle, nothing remains.

---

## Step 2: Find middle

Use:

* `slow = head`
* `fast = head`

Then move:

```text
slow = slow.next
fast = fast.next.next
```

until fast reaches the end.

---

## Step 3: Delete middle

Once slow is at node before the middle node’s removal position:

```text
slow.next = slow.next.next
```

This bypasses the middle node.

---

# 🎯 Intuition

```text
Fast moves twice as fast, so slow lands at the middle.
Then we cut the middle out by changing one link.
```

---

# 🔄 Example Dry Run

For:

```text
1 → 2 → 4 → 3 → 9 → 12 → 5
```

After pointer movement:

* slow reaches `4`
* slow.next is `3` which is the middle node

Delete it:

```text
4 → 9
```

So final list becomes:

```text
1 → 2 → 4 → 9 → 12 → 5
```

---

# ⚠️ Important Notes

```text
For odd length, exact middle is removed.
For even length, this logic removes the second middle.
```

---

# ❌ Common Mistakes

* ❌ Forgetting to handle single-node list
* ❌ Starting fast incorrectly
* ❌ Deleting slow instead of slow.next
* ❌ Not handling even-length middle definition
* ❌ Null pointer while doing slow.next.next

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

---

# 🎯 Interview Insight

👉
“I use slow and fast pointers to locate the middle of the linked list. Once slow reaches the node before the middle deletion point, I skip the middle node by updating `slow.next`.”

---

# 🔥 Key Insight

```text
Delete middle = find middle + bypass middle node
```

---

# 🚀 Key Takeaways

* Slow/fast pointers locate the middle
* Delete by changing one link
* Works in O(N) time and O(1) space
* For even length, this removes the second middle

---

# 🔥 Pattern Connection

* Two pointers
* Linked list traversal
* Pointer skipping technique

---

## ✅ Small Code Note

In this code:

* `fast = fast.next.next` starts fast ahead
* `while(fast != null && fast.next != null)` finds middle region
* `slow.next = slow.next.next` deletes the middle node
