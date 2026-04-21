# 🌳 Symmetric Binary Tree (Mirror Tree)

---

## 📌 Definition

A **Binary Tree is Symmetric** if:

> The left subtree is a **mirror image** of the right subtree across a vertical line passing through the root.

---

## 🌲 Example (Symmetric Tree)

```id="sym-final1"
          1
        / │ \
       2  │  2
      / \ │ / \
     3   4│4   3
          │
      Mirror Line
```

---

## 🔍 Mirror Mapping (Key Understanding)

```id="sym-final-map"
Left Side        Right Side
---------        ----------
   2      ↔         2
  / \              / \
 3   4    ↔       4   3
```

👉 Cross comparison:

* Left.left  ↔ Right.right
* Left.right ↔ Right.left

---

## 🌲 Example (Not Symmetric)

```id="sym-final2"
          1
        / │ \
       2  │  2
        \ │   \
         3│    3
          │
      Mirror Line
```

❌ Structure does not mirror → Not symmetric

---

## 🧠 Core Idea

To check symmetry:

* Compare **left subtree** and **right subtree**
* But in a **mirror (cross) manner**

---

## 🔁 Mirror Condition

Two nodes are mirror if:

1. Their values are **equal**
2. Left’s **left child** matches Right’s **right child**
3. Left’s **right child** matches Right’s **left child**

---

## 🔄 Working Principle

Start from root:

* Compare left and right subtree
* Recursively check:

```id="sym-final-rule"
(left.left ↔ right.right)
(left.right ↔ right.left)
```

---

## 🎯 Intuition

Imagine folding the tree along the **vertical line at root**:

👉 If both halves overlap perfectly → symmetric

---

## 📦 Recursion Behavior

At each step:

* Compare two nodes
* Move outward in mirror direction
* Continue until all pairs match

---

## ⚡ Base Conditions

* Both nodes null → ✅ symmetric
* One null, one not → ❌ not symmetric
* Values different → ❌ not symmetric

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

Where:

* N = number of nodes
* H = height of tree

---

## ⚠️ Common Mistakes

* Comparing left with left instead of mirror
* Ignoring structure (only checking values)
* Not handling null cases properly

---

## 🎯 Interview Insight

Best explanation:

👉 “I compare left and right subtrees in a mirror way—checking left.left with right.right and left.right with right.left recursively.”

---

## 🚀 Key Takeaways

* Symmetry = **mirror structure + equal values**
* Always compare in **cross direction**
* Vertical mirror line passes through **root**
* Classic recursion problem

---
