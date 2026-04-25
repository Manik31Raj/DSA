# 🌳 Search in Binary Search Tree (Track Path)

---

## 📌 What is a Binary Search Tree (BST)?

> A **Binary Tree** where every node follows:

```text id="bst-def"
Left subtree < Root < Right subtree
```

---

## 🔑 Properties of BST

```text id="bst-prop"
1. Left subtree contains smaller values
2. Right subtree contains greater values
3. No duplicates (generally assumed)
4. Inorder traversal gives sorted order
```

---

## 🎯 Why BST is Powerful?

```text id="bst-why"
Reduces search space at every step
```

👉 Similar to **Binary Search**

---

## 📌 Problem

> Search a node in a **Binary Search Tree (BST)**
> and also track the **path taken from root to target**.

---

## 🌲 Example Tree

```id="bst-tree"
        8
      /   \
     3     10
    / \      \
   1   6      14
      / \     /
     4   7   13
```

---

## 🎯 Example Query

```id="bst-query"
Target = 6
```

---

## 🧭 Path Output

```text id="bst-path"
Root → Left → Right → Found
```

---

## 🧠 Core Idea

```text id="bst-core"
Use BST property to decide direction
```

---

## 🔁 Working Principle

At each node:

```text id="bst-decision"
If target == node → Found  
If target < node → go LEFT  
If target > node → go RIGHT  
```

---

## 🧠 Path Encoding (Your Code)

| Symbol | Meaning      |
| ------ | ------------ |
| S      | Start (Root) |
| L      | Move Left    |
| R      | Move Right   |
| E      | Found (End)  |
| X      | Not Found    |

---

## 🎯 Intuition

```id="bst-intuition"
Search 6:

8 → go Left
3 → go Right
6 → Found
```

👉 Path becomes:

```text id="bst-int"
S → L → R → E
```

---

# 🔷 Approach 1: Recursive Search

---

## 🧠 Idea

👉 Follow BST rules using recursion

---

## 🔁 Flow

```text id="rec-flow"
Call → decide → recurse → repeat
```

---

## ⚠️ Extra Behavior

```text id="rec-extra"
Adds 'X' if node becomes null
```

---

# 🔷 Approach 2: Iterative Search

---

## 🧠 Idea

👉 Same logic using loop

---

## 🔁 Flow

```text id="iter-flow"
Loop until found or null
```

---

## 🎯 Advantage

```text id="iter-adv"
No recursion stack → O(1) space
```

---

# ⚡ Complexity

* **Time Complexity:** O(H)
* **Space Complexity:**

  * Recursive → O(H)
  * Iterative → O(1)

---

## ❓ Why O(H)?

```text id="bst-tc"
Only one path is explored
```

---

# ⚠️ Important Notes

```text id="bst-note"
Works only for BST
```

---

# ❌ Common Mistakes

* ❌ Ignoring BST property
* ❌ Searching both sides
* ❌ Not handling null
* ❌ Not resetting path

---

# 🎯 Interview Insight

👉
“I use BST property to move left or right, reducing search complexity. I also track the traversal path.”

---

# 🔥 Key Insight

```text id="bst-key"
BST behaves like binary search on tree
```

---

# 🚀 Key Takeaways

* BST enables fast search
* Only one path traversal
* Inorder gives sorted order
* Path tracking helps visualization

---

# 🔥 Pattern Connection

* BST Search → Binary Search
* Tree Path → DFS tracking
* Similar → Insert / Delete BST

---
