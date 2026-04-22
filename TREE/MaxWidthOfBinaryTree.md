# 🌳 Maximum Width of Binary Tree

---

## 📌 Definition

> The **width of a level** is the distance between the **leftmost and rightmost non-null nodes**, including null nodes in between.

👉 Maximum width = **maximum among all levels**

---

## 🌲 Example Tree

```id="mw-tree"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 👀 Width Calculation

```id="mw-levels"
Level 1 → [1]              → width = 1
Level 2 → [2, 3]          → width = 2
Level 3 → [4, 5, 6, 7]    → width = 4
```

👉 Maximum Width = **4**

---

## 🧠 Core Idea

* Use **level order traversal (BFS)**
* Assign each node an **index** (like array representation of tree)

---

## 🔢 Indexing Concept

```id="mw-index"
Root → index = 0

For any node:
Left child  → 2*i + 1
Right child → 2*i + 2
```

👉 This mimics **array-based binary tree indexing**

---

## 🔁 Working Principle

1. Use **Queue (node, index)**
2. For each level:

   * Normalize indices (to avoid overflow)
   * Track:

     * First index
     * Last index
3. Width = `last - first + 1`
4. Update maximum

---

## 🎯 Intuition (Actual vs Conceptual)

```id="mw-gap-visual"
Actual Tree                  →      Conceptual Full Tree (with gaps)

        1                               1
      /   \                           /   \
     2     3                         2     3
    /       \                       / \   / \
   4         7                     4   . .   7
```

👉 Actual nodes:

```text id="mw-actual"
4       7
```

👉 Conceptually (including possible positions):

```text id="mw-conceptual"
4   .   .   7
```

👉 Width is:

```text id="mw-final"
index(7) - index(4) + 1 = 4
```

👉 Missing nodes (gaps) are counted ✔

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(N)

---

## ⚠️ Important Note

👉 Always normalize index:

```text id="mw-normalize"
cur_index = index - min_index_of_level
```

Why?

* Prevents integer overflow
* Keeps values small

---

## 🔄 Key Formula

```text id="mw-formula"
Width = last_index - first_index + 1
```

---

## ⚠️ Common Mistakes

* ❌ Not handling overflow (index grows very large)
* ❌ Using simple node count instead of index gap
* ❌ Forgetting null gaps in width calculation
* ❌ Not normalizing per level

---

## 🎯 Interview Insight

Best explanation:

👉 “I assign indices to nodes like an array representation and compute width using the difference between first and last index at each level.”

---

## 🚀 Key Takeaways

* Width ≠ number of nodes
* It includes **null gaps**
* BFS + indexing is the key
* Normalization avoids overflow

---

## 🔥 Pattern Connection

* Width → BFS + Indexing
* Vertical Traversal → BFS + coordinates
* Top/Bottom View → BFS + horizontal distance

---
