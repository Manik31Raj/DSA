# 🌳 Balanced Binary Tree

## 📌 Definition

A **Balanced Binary Tree** is a binary tree where, for **every node**, the difference between the heights of its left and right subtrees is **at most 1**.

✔️ Formally:
| height(left) - height(right) | ≤ 1
---

## 🎯 Key Idea

At each node:

* Compute height of left subtree
* Compute height of right subtree
* Check if their difference is ≤ 1
* This condition must hold **for all nodes**

---

## ⚖️ Balance Condition

* If the height difference exceeds 1 at **any node**, the tree is **not balanced**
* Balance is a **local + global property** (must hold everywhere)

---

## 🧠 Approaches

### 1. Brute Force Approach

* For every node:

  * Calculate left subtree height
  * Calculate right subtree height
  * Check balance condition
* Then recursively verify for left and right subtrees

**Drawback:**

* Repeated height calculations
* Inefficient for large trees

---

### 2. Optimized Approach (Preferred)

* Combine **height calculation + balance checking** in one traversal
* Use a special signal value (like `-1`) to indicate imbalance

**Core Insight:**

* If any subtree is unbalanced → propagate failure upward immediately
* Avoid unnecessary computations

---

## 🔁 Working Principle

* Traverse tree in **post-order** (left → right → node)
* At each node:

  * Get left and right subtree results
  * If either indicates imbalance → stop further checks
  * If height difference > 1 → mark as unbalanced
  * Otherwise → return height

---

## 📊 Complexity

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Brute Force | O(N²)           | O(H)             |
| Optimized   | O(N)            | O(H)             |

* **N** = number of nodes
* **H** = height of tree (recursion stack)

---

## 🧩 Important Observations

* A tree can be height-balanced but still not perfectly balanced
* Balance must be verified **at every node**, not just the root
* Early termination (in optimized approach) improves performance significantly

---

## ⚠️ Common Mistakes

* Only checking balance at root
* Recomputing heights multiple times
* Not handling early exit when imbalance is found
* Incorrectly combining conditions (logical errors)

---

## 🎯 Interview Insight

* Very common tree problem
* Often used to test:

  * Recursion understanding
  * Tree traversal (especially post-order)
  * Optimization thinking

---

## 🚀 Summary

* Balanced Binary Tree ensures efficient tree operations
* Brute force is simple but inefficient
* Optimized approach uses a **single traversal**
* Key trick: detect imbalance early and propagate it upward

---
