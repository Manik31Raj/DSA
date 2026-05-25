# 🔄 Odd Even Linked List Arrangement

---

## 📌 Problem

> Rearrange a linked list so that all nodes at **odd positions** come first,
> followed by all nodes at **even positions**.

⚠️ Here, **odd/even refers to index position**, not node value.

---

## 🌲 Example

```text
1 → 3 → 4 → 2 → 5 → 6 → 7
```

Positions:

```text
1st, 2nd, 3rd, 4th, 5th, 6th, 7th
```

So:

* Odd positions → `1, 4, 5, 7`
* Even positions → `3, 2, 6`

Final output:

```text
1 → 4 → 5 → 7 → 3 → 2 → 6
```

---

# 🔥 Core Idea

```text
Keep two separate chains:
1. odd-position nodes
2. even-position nodes
Then connect odd chain to even chain at the end
```

This is done **in-place** without creating new nodes.

---

# 🧠 Why This Works

We already know the next odd node is:

```text
odd.next.next
```

and the next even node is also:

```text
even.next.next
```

So we can jump through the list by skipping one node at a time.

---

# 🔷 Variables Used

| Variable    | Meaning                               |
| ----------- | ------------------------------------- |
| `odd`       | current odd-position node             |
| `even`      | current even-position node            |
| `evenStart` | first even node, used to attach later |

---

# 🔁 Working Principle

---

## Step 1: Initialize pointers

```text
odd = head
even = head.next
evenStart = even
```

So initially:

```text
odd chain starts at 1
even chain starts at 3
```

---

## Step 2: Rewire links

While even and even.next exist:

* connect odd to next odd node
* move odd forward
* connect even to next even node
* move even forward

---

## Step 3: Connect odd list to even list

At the end:

```text
odd.next = evenStart
```

This attaches the even chain after all odd-position nodes.

---

# 🎯 Intuition

```text
We are not sorting by value.
We are grouping nodes by position.
```

So the list is split into:

* odd-index chain
* even-index chain

and then merged.

---

# 🌟 Dry Run

Original:

```text
1 → 3 → 4 → 2 → 5 → 6 → 7
```

---

## Initial

```text
odd = 1
even = 3
evenStart = 3
```

---

## After first move

```text
odd chain: 1 → 4
even chain: 3 → 2
```

---

## Next move

```text
odd chain: 1 → 4 → 5
even chain: 3 → 2 → 6
```

---

## Next move

```text
odd chain: 1 → 4 → 5 → 7
even chain: 3 → 2 → 6
```

---

## Final connect

```text
1 → 4 → 5 → 7 → 3 → 2 → 6
```

---

# 🔷 Second Method: Using Dummy Nodes

Your code also includes an alternate method:

```text
arrangeAsOddEvenIndexByCreatingNewDummy()
```

This method:

* creates a new list
* first copies odd-position values
* then copies even-position values

---

## Difference Between Methods

| Method                | In-place? | Extra Space | Better?      |
| --------------------- | --------- | ----------- | ------------ |
| Pointer rearrangement | ✅ Yes     | O(1)        | ✅ Best       |
| Dummy/new nodes       | ❌ No      | O(N)        | Less optimal |

---

# ⚠️ Important Notes

```text
Odd-even arrangement is based on position, not value
```

Example:

```text
1 → 10 → 3 → 20 → 5
```

Odd positions are:

```text
1, 3, 5
```

not values like `1, 3, 5` by coincidence.

---

# ❌ Common Mistakes

* ❌ Thinking odd/even means value parity
* ❌ Breaking the list while moving pointers
* ❌ Forgetting to save `evenStart`
* ❌ Not handling short lists
* ❌ Connecting odd chain to wrong node

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

---

# 🎯 Interview Insight

👉
“I maintain two pointers: one for odd-position nodes and one for even-position nodes. I rewire the links in-place so that all odd-position nodes stay together first, followed by all even-position nodes. Finally, I connect the odd chain to the start of the even chain.”

---

# 🔥 Key Insight

```text
Odd-even arrangement = pointer rewiring by index position
```

---

# 🚀 Key Takeaways

* Odd/even refers to positions, not values
* Use two pointers: odd and even
* Save evenStart before rewiring
* In-place solution is O(1) space
* Dummy-node method is simpler but not optimal

---

# 🔥 Pattern Connection

* Linked list pointer manipulation
* In-place rearrangement
* Two-pointer traversal

---

## ✅ Small Code Note

In this code:

* `arrangeAsOddEvenIndex()` is the optimal in-place method
* `arrangeAsOddEvenIndexByCreatingNewDummy()` builds a new list using copied values
* `odd.next = evenStart` joins both chains at the end
