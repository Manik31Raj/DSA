# 🌳 Largest BST in Binary Tree

---

## 📌 Problem

> Given a binary tree, find the **size of the largest subtree that is a valid BST**

---

## 🧠 Key Idea

```text id="key"
Every subtree can either be:
1. A valid BST  
2. Not a BST
```

---

## 🌲 Example

```id="largest-bst-tree"
            50
          /    \
        30      60
       /  \    /  \
      5   20  55   70
                  /  \
                 65   80
```

---

## 🎯 Output

```text id="output"
Largest BST size = 5
```

👉 Subtree rooted at **60** is the largest BST

---

# 🔥 Core Idea

```text id="core"
Use postorder traversal to validate BST at every node
```

---

## ❓ Why Postorder?

```text id="why"
We need left and right subtree info before deciding for current node
```

---

# 🔷 What We Track (NodeData)

---

## 📦 For each node we store:

```text id="nodedata"
maxNode → maximum value in subtree  
minNode → minimum value in subtree  
maxSize → size of largest BST in subtree  
```

---

# 🔷 Working Principle

---

## 🧠 At each node:

Check:

```text id="check"
left.maxNode < root.data < right.minNode
```

---

## 🔹 If TRUE → Valid BST

```text id="valid"
Size = left.size + right.size + 1  
min = min(left.min, root.data)  
max = max(right.max, root.data)
```

---

## 🔹 If FALSE → Not BST

```text id="invalid"
Return:
Size = max(left.size, right.size)
min = -∞  
max = +∞
```

👉 This ensures parent also fails BST check

---

# 🔁 Flow

```text id="flow"
Traverse left → Traverse right → Process node
```

---

## 🎯 Intuition

```text id="intuition"
Bottom-up validation of BST property
```

---

## 🔄 Example Breakdown

```text id="breakdown"
Subtree (60,55,70,65,80) → valid BST → size = 5  
Subtree (30,5,20) → NOT BST  
```

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

---

## ❓ Why O(N)?

```text id="tc"
Each node is visited exactly once
```

---

# ⚠️ Important Notes

```text id="note"
Invalid subtree returns extreme values to break parent condition
```

---

# ❌ Common Mistakes

* ❌ Checking only immediate children
* ❌ Not propagating min/max properly
* ❌ Forgetting postorder requirement
* ❌ Using O(N²) brute force

---

# 🎯 Interview Insight

👉
“I use postorder traversal and return min, max, and size information for each subtree. This allows me to validate BST property in O(N) time.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="insight"
BST validation + size tracking combined
```

---

# 🚀 Key Takeaways

* Postorder is essential
* Combine multiple values per node
* Use min/max to validate
* Optimal O(N) solution

---

# 🔥 Pattern Connection

* BST validation → range checking
* Tree DP (return multiple values)
* Similar → diameter, max path sum

---
