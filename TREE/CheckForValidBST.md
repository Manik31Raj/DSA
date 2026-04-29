# 🌳 Validate Binary Search Tree (BST)

---

## 📌 Problem

> Check whether a given binary tree is a **valid Binary Search Tree (BST)**.

---

## 🧠 BST Rule Reminder

```text id="bst-rule"
For every node:
Left subtree < Node < Right subtree
```

---

## ❗ Important Clarification

```text id="important"
BST condition must hold for ALL nodes (not just immediate children)
```

---

## 🌲 Example

```id="valid-tree"
        13
      /    \
     10     15
    / \     / \
   7  12   14 17
```

👉 Valid BST ✔

---

## ❌ Invalid Example

```id="invalid-tree"
        13
      /    \
     10     15
    / \     
   7  20   ❌ (20 is in left subtree but > 13)
```

👉 Not a BST ❌

---

## 🧠 Core Idea

```text id="core"
Each node must lie within a valid range
```

---

## 🔁 Working Principle

For each node:

```text id="logic"
min < node < max
```

---

## 🔄 Flow

1. Start with range:

```text id="range"
(-∞, +∞)
```

---

2. For left subtree:

```text id="left-range"
(min, root.data)
```

---

3. For right subtree:

```text id="right-range"
(root.data, max)
```

---

4. Recursively validate all nodes

---

## 🎯 Intuition

```id="intuition"
Node 13 → range (-∞, +∞)

Left child (10) → (-∞, 13)
Right child (15) → (13, +∞)

Keep narrowing range
```

---

## ⚠️ Why This Works

```text id="why"
Ensures global BST property, not just local
```

---

## ❌ Wrong Approach (Common Mistake)

```text id="wrong"
Checking only:
left < root < right
```

👉 This fails for deeper nodes ❌

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

---

## ❓ Why O(N)?

```text id="tc"
Every node is visited exactly once
```

---

## ⚠️ Important Implementation Detail

```text id="long"
Use long instead of int for min/max
```

👉 To handle edge values safely

---

## ❌ Common Mistakes

* ❌ Only checking immediate children
* ❌ Using int instead of long
* ❌ Not passing updated range
* ❌ Allowing duplicates incorrectly

---

## 🎯 Interview Insight

👉
“I validate BST by ensuring each node lies within a valid range. This guarantees the global BST property.”

---

## 🔥 Key Insight

```text id="key"
BST validation = range checking
```

---

## 🚀 Key Takeaways

* BST must satisfy global constraints
* Use min-max range approach
* Traverse entire tree
* Avoid local-only checks

---

## 🔥 Pattern Connection

* BST validation → range recursion
* Similar → subtree constraints
* Used in many tree problems

---
