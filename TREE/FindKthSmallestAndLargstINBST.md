# 🌳 Kth Smallest & Kth Largest in BST

---

## 📌 Problem

> Find the **Kth smallest** and **Kth largest** element in a Binary Search Tree.

---

## 🧠 BST Property Reminder

```text id="bst-prop"
🔥 Inorder traversal of BST → ASCENDING sorted order 🔥
```

👉 This is the **most important property** used in this problem

---

## 🌲 Example

```id="kth-tree"
          25
       /       \
     10         35
    /  \       /  \
   5   15     30   40
  / \  / \
 2  7 12 18
```

---

## 🎯 Example Queries

```text id="kth-query"
K = 5 (smallest) → 12  
K = 3 (largest)  → 30
```

---

# 🔷 Kth Smallest Element

---

## 🧠 Core Idea

```text id="small-core"
Inorder → LEFT → ROOT → RIGHT → Ascending order
```

---

## 🔁 Approach 1: Recursion

---

### ⚙️ Steps

1. Traverse left subtree
2. Visit node → increment counter
3. If counter == k → return value
4. Traverse right

---

## 🎯 Intuition

```text id="small-int"
Visit nodes in increasing order
```

---

# 🔷 Kth Largest Element

---

## 🧠 Core Idea

```text id="large-core"
Reverse Inorder → RIGHT → ROOT → LEFT → Descending order
```

---

## 🔁 Approach 1: Recursion

---

### ⚙️ Steps

1. Traverse right subtree
2. Visit node → increment counter
3. If counter == k → return value
4. Traverse left

---

## 🎯 Intuition

```text id="large-int"
Visit nodes in decreasing order
```

---

# 🔷 Morris Traversal (Optimal)

---

## 🧠 Idea

```text id="morris-core"
Use Morris traversal to avoid recursion and stack
```

---

## 🔁 Kth Smallest (Morris)

👉 Same as inorder traversal

---

## 🔁 Kth Largest (Morris)

👉 Same as reverse inorder

---

## 🎯 Key Insight

```text id="morris-key"
Stop traversal as soon as counter == k
```

---

# ⚖️ Comparison

---

## 📊 Table

| Approach  | Space | Easy   | Idea      |
| --------- | ----- | ------ | --------- |
| Recursion | O(H)  | ✅ Easy | Inorder   |
| Morris    | O(1)  | ❌ Hard | Threading |

---

# ⚡ Complexity

* **Time Complexity:** O(H + K)
* **Space Complexity:**

  * Recursion → O(H)
  * Morris → O(1)

---

## ❓ Why O(H + K)?

```text id="tc"
We traverse only till Kth element, not the entire tree
```

---

# ⚠️ Important Notes

```text id="note"
Counter must be reset before each function call
```

---

# ❌ Common Mistakes

* ❌ Not resetting counter
* ❌ Wrong traversal order
* ❌ Traversing full tree unnecessarily
* ❌ Confusing smallest vs largest

---

# 🎯 Interview Insight

👉
“I use inorder traversal because it gives sorted order in BST. I stop when I reach the Kth element. For optimization, I can use Morris traversal to reduce space to O(1).”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Kth smallest/largest = position in sorted order
```

---

# 🚀 Key Takeaways

* BST inorder gives sorted order
* Reverse inorder gives descending order
* Early stopping improves efficiency
* Morris traversal optimizes space

---

# 🔥 Pattern Connection

* BST Traversal → Sorted order
* Binary Search concept
* Order statistics problems

---
