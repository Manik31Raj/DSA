# 🔄 Find Length of Loop in Linked List

## (Floyd’s Cycle Detection + Loop Length)

---

# 📌 Problem

> Given a linked list, find the **length of the loop** if a cycle exists.
> If there is no loop, return `0`.

---

# 🌲 Example

Suppose the linked list is:

```text
1 → 2 → 4 → 3 → 9 → 12 → 5 → 6 → 7 → 8
                ↑______________________|
```

Here, the loop starts at node `3`.

So the loop length is:

```text
3 → 9 → 12 → 5 → 6 → 7 → 8 → back to 3
```

Length = `7`

---

# 🔥 Core Idea

```text
First detect the cycle using slow and fast pointers.
If they meet, then count the number of nodes in the loop.
```

---

# 🧠 Why This Works

If a cycle exists:

* slow pointer and fast pointer will meet inside the loop
* once they meet, we can keep moving one pointer around the loop until it comes back to the same node

The number of steps taken is the loop length.

---

# 🔷 Working Principle

---

## Step 1: Detect cycle

Use Floyd’s cycle detection:

* `slow` moves 1 step
* `fast` moves 2 steps

If they meet:

```text
cycle exists
```

---

## Step 2: Count loop nodes

Once a meeting point is found:

* keep one pointer fixed
* move the other pointer around the loop
* count how many moves it takes to return to the same node

That count is the loop length.

---

# 🎯 Intuition

```text
Meeting point confirms cycle
One full round around the cycle gives its length
```

---

# 🔁 Example Dry Run

For a loop like:

```text
3 → 9 → 12 → 5 → 6 → 7 → 8 → back to 3
```

If slow and fast meet at node `3`:

* move to `9` → count 2
* move to `12` → count 3
* move to `5` → count 4
* move to `6` → count 5
* move to `7` → count 6
* move to `8` → count 7
* back to `3`

So:

```text
Loop Length = 7
```

---

# 🔷 Why Two Functions?

---

## 1) `findLength()`

This function:

* checks whether a cycle exists
* if found, calls the loop counting function

---

## 2) `findLengthOfLoop()`

This function:

* assumes we already have a node inside the cycle
* walks around the loop
* counts loop size

---

# ⚠️ Important Notes

```text
If there is no cycle, loop length = 0
```

```text
If slow and fast meet, the node is guaranteed to be inside the cycle
```

---

# ❌ Common Mistakes

* ❌ Trying to count loop length without first detecting cycle
* ❌ Not stopping when pointer returns to the meeting node
* ❌ Forgetting to handle no-loop case
* ❌ Using extra memory unnecessarily
* ❌ Confusing cycle detection with cycle length

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

---

# 🎯 Interview Insight

👉
“I first detect a cycle using Floyd’s slow and fast pointer method. If the pointers meet, I keep one pointer fixed and move the other around the loop until it comes back to the same node. The number of steps taken is the loop length.”

---

# 🔥 Key Insight

```text
Loop length = number of steps needed to return to the meeting node
```

---

# 🚀 Key Takeaways

* Use Floyd’s algorithm to detect cycle
* Once meeting point is found, count loop size
* No extra memory needed
* Return 0 if no cycle exists

---

# 🔥 Pattern Connection

* Floyd cycle detection
* Two pointers
* Linked list loop problems

---

## ✅ Small Code Note

In this code:

* `findLength()` detects cycle using slow/fast pointers
* `findLengthOfLoop()` counts nodes in the loop
* `return 0` means no loop was found
