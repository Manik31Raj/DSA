# 🌳 Lowest Common Ancestor (LCA) in BST

---

## 📌 Problem

> Find the **Lowest Common Ancestor (LCA)** of two nodes in a **Binary Search Tree**.

---

## 📌 Definition

```text id="lca-def"
LCA = Lowest node that has both nodes as descendants
```

---

## 🌲 Example

```id="lca-tree"
           9
        /     \
       4       15
     /   \    /   \
    1     6  12    20
     \   / \  / \   / \
      2 5   7 11 13 18 25
```

---

## 🎯 Example Query

```text id="lca-query"
Find LCA of 1 and 7
```

```text id="lca-ans"
Answer = 4
```

---

## 🧠 Core Idea (BST Property)

```text id="core"
Use BST property to decide direction
```

---

## 🔁 Working Principle

At each node:

```text id="logic"
If both values < node → go LEFT  
If both values > node → go RIGHT  
Else → current node is LCA
```

---

## 🎯 Intuition

```id="lca-intuition"
For 1 and 7:

Start at 9 → both < 9 → go left  
At 4 → one left, one right → split point
```

👉 That split point is LCA ✔

---

## 🔥 Key Insight

```text id="key"
LCA is the first node where paths diverge
```

---

# 🔷 Approach 1: Iterative (General Method)

---

## 🧠 Idea

👉 Traverse tree using loop

---

## 🔁 Steps

1. Start from root
2. Compare both values
3. Move left or right accordingly
4. Stop at split point

---

## 🎯 Advantage

```text id="iter-adv"
O(1) space
```

---

# 🔷 Approach 2: Recursive

---

## 🧠 Idea

👉 Apply same logic using recursion

---

## 🔁 Steps

1. If both values < root → go left
2. If both values > root → go right
3. Else → return root

---

## 🎯 Advantage

```text id="rec-adv"
Cleaner and easier to write
```

---

# ⚡ Complexity

* **Time Complexity:** O(H)
* **Space Complexity:**

  * Iterative → O(1)
  * Recursive → O(H)

---

## ❓ Why O(H)?

```text id="tc"
Only one path is followed from root
```

---

# ⚠️ Important Notes

```text id="note"
Works only for BST
```

👉 Not valid for general binary tree ❌

---

# ❌ Common Mistakes

* ❌ Using full traversal (O(N)) unnecessarily
* ❌ Ignoring BST property
* ❌ Not handling split condition properly

---

# 🎯 Interview Insight

👉
“I use the BST property to move left or right. The first node where the paths of the two values diverge is the LCA.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key2"
LCA = split point in BST traversal
```

---

# 🚀 Key Takeaways

* Use BST property
* No need to traverse full tree
* Split point gives answer
* Efficient O(H) solution

---

# 🔥 Pattern Connection

* BST Search → same traversal logic
* Binary Search concept
* Tree ancestor problems

---
