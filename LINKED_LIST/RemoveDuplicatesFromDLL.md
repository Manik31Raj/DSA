# 🧹 Remove Duplicates from Sorted Doubly Linked List

---

## 📌 Problem

> Given a **sorted doubly linked list**, remove all duplicate nodes so that only one copy of each value remains.

---

## 🌲 Example

```text
1 ⇄ 1 ⇄ 2 ⇄ 2 ⇄ 4 ⇄ 6 ⇄ 6 ⇄ 8 ⇄ 9 ⇄ 9 ⇄ 10
```

After removing duplicates:

```text
1 ⇄ 2 ⇄ 4 ⇄ 6 ⇄ 8 ⇄ 9 ⇄ 10
```

---

# 🔥 Core Idea

```text
Since the DLL is sorted, all duplicates stay next to each other.
So we can scan once and skip repeated nodes.
```

---

# 🧠 Why Sorting Helps

Because the list is sorted:

```text
same values appear in consecutive blocks
```

Example:

```text
1 ⇄ 1 ⇄ 1 ⇄ 2 ⇄ 2 ⇄ 4
```

So we only need to compare:

* current node
* next node

No extra data structure is needed.

---

# 🔁 Working Principle

---

## Step 1: Traverse with `temp`

`temp` points to the current unique node we are keeping.

---

## Step 2: Check consecutive duplicates

For each node:

* store `nextNode = temp.next`
* move `nextNode` forward while it has the same value as `temp`

This skips the duplicate block.

---

## Step 3: Reconnect links

After skipping duplicates:

```text
temp.next = nextNode
```

If `nextNode` exists:

```text
nextNode.prev = temp
```

This reconnects the list and removes duplicates.

---

# 🔗 Most Important Part: Inner While Loop

This part is the heart of the code:

```java
while(nextNode != null && nextNode.data == temp.data){
    nextNode = nextNode.next;
}
```

---

## What does it do?

Suppose the list is:

```text
1 ⇄ 1 ⇄ 1 ⇄ 2 ⇄ 2 ⇄ 4
```

and `temp` is pointing to the first `1`.

Then:

* `nextNode` starts at the second `1`
* because `nextNode.data == temp.data`, it moves forward
* it keeps moving until it finds the first different value

So after the loop:

```text
nextNode → 2
```

This means all repeated `1`s have been skipped.

---

## Why is this safe?

Because the list is sorted, all duplicates are adjacent.

So once we find a different value, we know the duplicate block has ended.

---

# 🎯 Intuition

```text
Keep one copy of each value.
Skip all equal neighbors that come after it.
```

---

# 🌟 Dry Run

Original:

```text
1 ⇄ 1 ⇄ 2 ⇄ 2 ⇄ 4 ⇄ 6 ⇄ 6 ⇄ 8 ⇄ 9 ⇄ 9 ⇄ 10
```

---

## At first `1`

* `temp = 1`
* `nextNode` moves over the repeated `1`
* reconnect `temp.next = 2`

Now:

```text
1 ⇄ 2 ⇄ 2 ⇄ 4 ⇄ 6 ⇄ 6 ⇄ 8 ⇄ 9 ⇄ 9 ⇄ 10
```

---

## At `2`

* `temp = 2`
* `nextNode` skips the duplicate `2`
* reconnect to `4`

Now:

```text
1 ⇄ 2 ⇄ 4 ⇄ 6 ⇄ 6 ⇄ 8 ⇄ 9 ⇄ 9 ⇄ 10
```

---

## At `6`

* `nextNode` skips repeated `6`
* reconnect to `8`

Now:

```text
1 ⇄ 2 ⇄ 4 ⇄ 6 ⇄ 8 ⇄ 9 ⇄ 9 ⇄ 10
```

---

# ⚠️ Important Notes

```text
This logic works only because the DLL is sorted
```

If the list is not sorted, duplicate values may not be adjacent, and this method will not work correctly.

---

# ❌ Common Mistakes

* ❌ Forgetting to update `nextNode.prev`
* ❌ Assuming duplicates exist in sorted order when the list is unsorted
* ❌ Moving `temp` incorrectly after skipping duplicates
* ❌ Breaking the list by not reconnecting properly
* ❌ Not handling empty or single-node lists

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

---

# 🎯 Interview Insight

👉
“I traverse the sorted doubly linked list once. For each node, I keep moving a secondary pointer forward while the next values are equal. Then I reconnect the current node directly to the first different node, which removes all duplicate nodes in place.”

---

# 🔥 Key Insight

```text
Sorted DLL duplicate removal = skip same-valued neighbors
```

---

# 🚀 Key Takeaways

* Works because the list is sorted
* Duplicate nodes are adjacent
* Use one pointer to scan and another to skip repeats
* Update both `next` and `prev` links
* O(1) extra space

---

# 🔥 Pattern Connection

* Linked list pointer manipulation
* In-place deletion
* Sorted structure optimization

---

## ✅ Small Code Note

In this code:

* `temp` marks the current unique value
* `nextNode` skips all consecutive duplicates
* `temp.next = nextNode` removes duplicate block
* `nextNode.prev = temp` restores backward link
