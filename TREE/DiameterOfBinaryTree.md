# 🌳 Diameter of Binary Tree

---

## 📌 Definition

The **Diameter of a Binary Tree** is:

> The **length of the longest path between any two nodes** in the tree.

* The path **does not have to pass through the root**
* Length is measured in **number of edges** (sometimes nodes, depending on definition)

---

## 🌲 Example Tree

```id="9xq3df"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 🎯 Understanding Diameter

Possible longest paths:

* 4 → 2 → 1 → 3 → 7
* 5 → 2 → 1 → 3 → 6

👉 These are the **longest paths**, so diameter = **4 edges**

---

## 🧠 Core Idea

At every node:

* Find **height of left subtree (lh)**
* Find **height of right subtree (rh)**

👉 The longest path passing through that node is:

```id="formula"
lh + rh
```

---

## 🔁 Key Insight

* Diameter is the **maximum value of (lh + rh)** across all nodes
* Not necessarily at the root

---

## 🔄 How It Works

For each node:

1. Recursively calculate:

   * Left subtree height
   * Right subtree height

2. Compute:

   * Path through current node = `lh + rh`

3. Update global diameter:

   * Take maximum over all nodes

4. Return:

   * Height of current node → `1 + max(lh, rh)`

---

## 🎯 Intuition

Think of each node as a **bridge**:

* Left height → distance to deepest node on left
* Right height → distance to deepest node on right

👉 Combining both gives longest path through that node

---

## 📊 Why Single Traversal Works

* Height and diameter are computed together
* No repeated calculations
* Each node contributes once

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

Where:

* N = number of nodes
* H = height of tree

---

## 🧠 Important Observations

* Diameter may or may not pass through root
* Height is used as a **helper to compute diameter**
* We track diameter using a **global variable / reference**

---

## ⚠️ Common Mistakes

* Assuming diameter always passes through root
* Calculating height separately → leads to O(N²)
* Confusing nodes count vs edges count

---

## 🎯 Interview Insight

Best way to explain:

👉 “At each node, I calculate left and right subtree heights, and the sum gives the longest path through that node. I keep track of the maximum across all nodes in a single traversal.”

---

## 🚀 Key Takeaways

* Diameter = max(lh + rh) over all nodes
* Use height as a helper
* Solve in **one DFS traversal**
* Classic tree problem testing recursion depth understanding

---
