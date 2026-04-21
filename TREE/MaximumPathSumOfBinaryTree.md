# 🌳 Maximum Path Sum in Binary Tree

---

## 📌 Definition

The **Maximum Path Sum** is:

> The **maximum sum of values** obtained from any path in the binary tree.

---

## ⚠️ Important Rules

* A path can start and end at **any node**
* Path must be **continuous** (parent-child connections)
* Path **cannot split into more than one branch** while returning upward

---

## 🌲 Example Tree

```id="mps-tree"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 📊 Possible Paths

* 4 → 2 → 1 → 3 → 7 = **17**
* 5 → 2 → 1 → 3 → 6 = **17**

👉 Maximum Path Sum = **17**

---

## 🧠 Core Idea

At each node:

* Calculate:

  * **Max path from left**
  * **Max path from right**

👉 Best path passing through node:

```id="mps-formula"
left + right + node
```

---

## 🔁 Key Insight

Two things happen at each node:

---

### 🔹 1. Update Global Maximum

* Consider full path passing through node
* Includes:

  * Left subtree
  * Right subtree
  * Current node

---

### 🔹 2. Return Value to Parent

* Can only return **one path (no split)**
* Choose the better side:

```id="mps-return"
node + max(left, right)
```

---

## ⚠️ Why We Ignore Negative Values

```id="mps-ignore"
Math.max(0, subtreeSum)
```

👉 If subtree gives negative sum:

* Better to **ignore it (take 0)**
* Avoid reducing total path sum

---

## 🎯 Intuition

Think of each node as a **junction**:

* You can:

  * Take left path
  * Take right path
  * Combine both (for global max)

👉 But when returning upward:

* You can only choose **one direction**

---

## 🔄 Flow

For each node:

1. Get left contribution
2. Get right contribution
3. Ignore negatives
4. Update global max
5. Return best single path

---

## 📊 Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

Where:

* N = number of nodes
* H = height of tree

---

## ⚠️ Common Mistakes

* Not handling negative values
* Returning both sides instead of one
* Forgetting global max update
* Assuming path must include root

---

## 🎯 Interview Insight

Best explanation:

👉 “At each node, I compute the maximum contribution from left and right subtrees, ignore negative paths, and update the global maximum using both sides. While returning, I only pass the maximum single path upward.”

---

## 🚀 Key Takeaways

* Path can start/end anywhere
* Use **global variable** to track max
* Ignore negative paths
* Return only one branch upward

---

## 🔥 Pattern Recognition

This pattern is used in:

* Diameter of Tree (without sum)
* Tree DP problems
* Path-based optimizations

---
