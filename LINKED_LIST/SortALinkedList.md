# 📊 Sort a Linked List using Merge Sort

---

# 📌 Problem

Given an unsorted linked list, sort it in ascending order.

---

# 🌲 Example

Input:

```text
10 → 2 → 1 → 8 → 6 → 9 → 12 → 5
```

Output:

```text
1 → 2 → 5 → 6 → 8 → 9 → 10 → 12
```

---

# 🔥 Core Idea

```text
Use Merge Sort on the linked list
```

Merge Sort works very well on linked lists because:

- splitting is easy using slow and fast pointers
- merging two sorted lists is also easy

---

# 🧠 Why Merge Sort?

Linked list does not support random access like arrays.

So:

- Quick sorting is not as convenient
- Merge Sort is natural for linked lists
- It gives O(N log N) time

---

# 🔷 Main Idea of Merge Sort

```text
1. Find middle
2. Split list into left and right halves
3. Sort both halves recursively
4. Merge the two sorted halves
```

---

# 🔁 Working Principle

---

## Step 1: Find the middle node

We use slow and fast pointers.

- slow moves 1 step
- fast moves 2 steps

When fast reaches the end, slow is at the middle.

---

## Step 2: Split the list

After finding the middle:

```java
Node righthead = middle.next;
middle.next = null;
```

Now the list is divided into two parts:

- left half
- right half

---

## Step 3: Sort both halves recursively

```java
lefthead = sort(lefthead);
righthead = sort(righthead);
```

Each half is again divided until only one node remains.

A single node is already sorted.

---

## Step 4: Merge two sorted lists

Once both halves are sorted, merge them using the standard merge technique.

---

# 🎯 Intuition

```text
Divide the list into smaller and smaller parts,
then merge them in sorted order.
```

This is exactly the same strategy as array merge sort, but adapted for linked lists.

---

# 🌟 Dry Run

Input:

```text
10 → 2 → 1 → 8 → 6 → 9 → 12 → 5
```

---

## First Split

Left:

```text
10 → 2 → 1 → 8
```

Right:

```text
6 → 9 → 12 → 5
```

---

## Split Again

Left side:

```text
10 → 2
1 → 8
```

Right side:

```text
6 → 9
12 → 5
```

---

## Split Until Single Nodes

```text
10   2   1   8   6   9   12   5
```

---

## Merge Back

Merge sorted pairs:

```text
2 → 10
1 → 8
6 → 9
5 → 12
```

Then merge again:

```text
1 → 2 → 8 → 10
5 → 6 → 9 → 12
```

Final merge:

```text
1 → 2 → 5 → 6 → 8 → 9 → 10 → 12
```

---

# 🔷 Why `findMiddle()` Uses `fast = head.next`

This helps split the list into two almost equal parts.

Example:

```text
1 → 2 → 3 → 4 → 5
```

Middle becomes:

```text
2
```

So split:

```text
1 → 2
3 → 4 → 5
```

This avoids very unbalanced partitions.

---

# 🔷 Merge Function

The merge function compares the front nodes of both sorted lists.

At every step:

- attach the smaller node
- move forward in that list

When one list ends, attach the remaining nodes of the other list.

---

# ⚠️ Important Notes

```text
Merge Sort on linked list is stable and efficient
```

It does not require extra array space for splitting.

---

# ❌ Common Mistakes

* ❌ Forgetting to break the list at middle
* ❌ Not handling base case for 0 or 1 node
* ❌ Using wrong middle pointer
* ❌ Forgetting to return `dummy.next` in merge
* ❌ Creating new nodes unnecessarily

---

# ⚡ Complexity

* **Time Complexity:** O(N log N)
* **Space Complexity:** O(log N)

---

## Why?

- Each level of recursion processes all nodes once
- There are `log N` levels due to halving

The extra space comes from recursion stack.

---

# 🎯 Interview Explanation

👉  
“I sort the linked list using Merge Sort. First I find the middle using slow and fast pointers, then split the list into left and right halves, recursively sort both halves, and finally merge the two sorted lists. This gives O(N log N) time and is very suitable for linked lists.”

---

# 🔥 Key Insight

```text
Linked List Sorting = Merge Sort
```

Because linked lists are easy to split and merge.

---

# 🚀 Key Takeaways

* Use slow and fast pointers to split
* Recursively sort both halves
* Merge two sorted linked lists
* Time is O(N log N)
* Very natural for linked lists

---

# 🔥 Pattern Connection

* Divide and conquer
* Linked list merge
* Recursion
* Merge sort

---

## ✅ Small Code Note

In this code:

- `findMiddle(head)` finds the split point
- `middle.next = null` separates the two halves
- `sort(lefthead)` and `sort(righthead)` recursively sort both halves
- `merge(lefthead, righthead)` merges them into a sorted list
