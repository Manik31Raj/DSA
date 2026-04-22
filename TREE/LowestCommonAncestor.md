# 🌳 Lowest Common Ancestor (LCA) of Binary Tree

---

## 📌 Definition

> The **Lowest Common Ancestor (LCA)** of two nodes `x` and `y` is the **lowest node** in the tree that has both `x` and `y` as descendants.

---

## 🌲 Example Tree

```id="lca-tree"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 👀 Example Query

```id="lca-query"
LCA(5, 6)
```

```id="lca-ans"
→ 1
```

---

## 🧠 Core Idea

* Traverse tree using **DFS (Recursion)**
* At each node:

  * Check left subtree
  * Check right subtree
* If both sides return a node → **current node is LCA**

---

## 🔁 Working Principle

1. If current node is `null` → return `null`
2. If current node matches `x` or `y` → return it
3. Recurse left and right
4. Based on results:

   * Both sides non-null → LCA found
   * One side non-null → propagate upward

---

## 🎯 Intuition

Think like this:

```id="lca-flow"
LCA(1)
├── left → returns 5
└── right → returns 6
```

👉 Both sides returned a value
👉 So this is the **first split point**

---

## 🔄 Decision Logic

| Left Result | Right Result | Meaning             | Result                 |
| ----------- | ------------ | ------------------- | ---------------------- |
| null        | null         | nothing found       | null                   |
| node        | null         | found in left       | left                   |
| null        | node         | found in right      | right                  |
| node        | node         | found in both sides | **current node (LCA)** |

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

---

## ⚠️ Important Note

* No need to store paths ❌
* No extra data structures ❌

👉 Everything is handled via recursion itself

---

## ❌ Common Wrong Approach

```text
Store path from root to both nodes and compare
```

👉 Works but:

* Extra space
* Not optimal
* Not preferred in interviews

---

## ✅ Recommended Approach

Use **single DFS traversal with backtracking**

👉 Efficient + clean + interview standard

---

## 🔄 Key Insight

```text
First node where left ≠ null AND right ≠ null → LCA
```

---

## ⚠️ Edge Case

```id="lca-edge"
LCA(2, 5) → 2
```

👉 One node can be ancestor of another

---

## 🎯 Interview Insight

Best way to explain:

👉 “I recursively search left and right. If both return non-null, the current node is the lowest common ancestor.”

---

## 🚀 Key Takeaways

* DFS + recursion is the key
* Think in terms of **subtree results**
* First split point gives answer
* No need for extra storage

---

## 🔥 Pattern Connection

* LCA → DFS + Backtracking
* Path problems → DFS + Backtracking
* Diameter / Max Path → similar recursion pattern

---
