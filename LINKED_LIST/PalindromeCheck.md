# 💖 Check if a Linked List is Palindrome

---

## 📌 Problem

> Determine whether a singly linked list reads the same from left to right and right to left.

---

## 🌲 Example

```text
1 → 3 → 4 → 5 → 7 → 5 → 4 → 3 → 1
```

This is a palindrome because:

```text
forward  = 1 3 4 5 7 5 4 3 1
backward = 1 3 4 5 7 5 4 3 1
```

---

# 🔥 Core Idea

```text
Find the middle,
reverse the second half,
then compare both halves
```

This is the standard optimal approach for palindrome linked list.

---

# 🧠 Why This Works

A palindrome must satisfy:

```text
first half == reversed second half
```

So instead of comparing from both ends directly, we:

1. locate the middle
2. reverse the latter half
3. compare node by node

---

# 🔷 Working Principle

---

## Step 1: Find middle using slow and fast pointers

* `slow` moves one step at a time
* `fast` moves two steps at a time

When `fast` reaches the end, `slow` is at the middle.

---

## Step 2: Reverse second half

For even length:

* reverse from `slow`

For odd length:

* skip the middle node
* reverse from `slow.next`

---

## Step 3: Compare both halves

* `first` starts from head
* `second` starts from reversed second half

Compare values one by one.

If all match, it is a palindrome.

---

# 🎯 Intuition

```text
A palindrome list is symmetric around the center
```

So we split the list into two parts and check if they mirror each other.

---

# 🌟 Example Walkthrough

Original:

```text
1 → 3 → 4 → 5 → 7 → 5 → 4 → 3 → 1
```

---

## Middle Finding

After slow/fast traversal:

* `slow` reaches the center

Since length is odd, the middle element `7` is skipped while reversing the second half.

---

## Reverse Second Half

Second half becomes:

```text
1 → 3 → 4 → 5
```

---

## Compare

Compare:

```text
1 with 1
3 with 3
4 with 4
5 with 5
```

All match ✅

So the list is palindrome.

---

# ⚠️ Important Notes

```text
For odd-length lists, the middle node is ignored during comparison
```

Because the middle element does not affect symmetry.

---

# 🔄 Even vs Odd Length

---

## Even Length

Example:

```text
1 → 2 → 2 → 1
```

* reverse from `slow`

---

## Odd Length

Example:

```text
1 → 2 → 3 → 2 → 1
```

* reverse from `slow.next`
* skip `3`

---

# ❌ Common Mistakes

* ❌ Forgetting to skip the middle node in odd-length lists
* ❌ Not reversing the second half
* ❌ Comparing wrong number of nodes
* ❌ Losing the list structure after reversal
* ❌ Not restoring the list if needed

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

---

# 🎯 Interview Insight

👉
“I use slow and fast pointers to find the middle of the linked list. Then I reverse the second half and compare it with the first half node by node. If all values match, the list is a palindrome.”

---

# 🔥 Key Insight

```text
Palindrome LL = middle finding + reverse second half + compare
```

---

# 🚀 Key Takeaways

* Slow/fast pointers find middle
* Reverse second half
* Compare both halves
* Works in O(N) time and O(1) extra space

---

# 🔥 Pattern Connection

* Two pointers
* Linked list reversal
* Symmetry checking

---

## ✅ Small Code Note

In this code:

* `slow` and `fast` find the middle
* `reverseLLIterative(...)` reverses the second half
* `first` and `second` compare the two halves
* after comparison, the list can be restored if needed
