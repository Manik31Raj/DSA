# 🌳 Height (Depth) of Binary Tree

---

## 📌 Definition

The **Height (or Depth) of a Binary Tree** is:

> The **maximum number of nodes** present in the longest path from root to any leaf.

---

## 🌲 Example Tree

```id="htree"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 📊 Understanding Height

Possible paths:

* 1 → 2 → 4
* 1 → 2 → 5
* 1 → 3 → 6
* 1 → 3 → 7

👉 Longest path length = **3 nodes**

---

## 📈 Height = 3

---

## 🧠 Core Idea

At every node:

* Find height of **left subtree (lh)**
* Find height of **right subtree (rh)**

👉 Height of node =

```id="formula-ht"
1 + max(lh, rh)
```

---

## 🔁 Working Principle

1. Start from root
2. Recursively compute:

   * Left subtree height
   * Right subtree height
3. Take maximum of both
4. Add 1 (for current node)

---

## 🎯 Intuition

Think of it as:

👉 “How deep can I go from this node?”

* Go left → get depth
* Go right → get depth
* Choose deeper path

---

## 🔄 Base Case

* If node is null → height = **0**

---

## ⚡ Why This Works

* Breaks problem into smaller subproblems
* Each node depends only on its children
* Classic **Divide & Conquer**

---

## 📊 Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

Where:

* N = number of nodes
* H = height of tree

---

## ⚠️ Common Confusion

### 🔸 Height vs Depth

| Term   | Meaning                        |
| ------ | ------------------------------ |
| Height | Longest path from node to leaf |
| Depth  | Distance from root to node     |

👉 Often used interchangeably in interviews

---

## 🎯 Interview Insight

Best explanation:

👉 “I recursively calculate height by taking the maximum depth of left and right subtrees and adding 1 for the current node.”

---

## 🚀 Key Takeaways

* Height = longest path from root to leaf
* Formula → **1 + max(left, right)**
* Very important helper in many tree problems:

  * Diameter
  * Balanced Tree
  * Max Path Sum

---
