# 🌳 Boundary Traversal of Binary Tree

---

## 📌 Definition

**Boundary Traversal** means:

> Printing all the **boundary (outer) nodes** of a binary tree in **anti-clockwise order**.

---

## 🌲 Example Tree

```id="btree"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 🎯 Boundary Includes

Boundary traversal consists of **3 parts**:

1. **Left Boundary** (excluding leaf nodes)
2. **Leaf Nodes** (all leaves from left to right)
3. **Right Boundary** (excluding leaf nodes, added in reverse)

---

## 📊 Boundary Output

```id="b-out"
1 → 2 → 4 → 5 → 6 → 7 → 3
```

---

## 🧭 Visual Understanding

```id="b-vis"
        1
      /   \
     2     3
    / \   / \
  [4]  5 6  [7]

Boundary Path:
1 → 2 → 4 → 5 → 6 → 7 → 3
```

---

## 🧠 Core Idea

Traverse tree in **three phases**:

---

### 🔹 1. Root Node

* Add root (if not a leaf)

---

### 🔹 2. Left Boundary

* Move from root → left side
* Add nodes **excluding leaf nodes**
* Always prefer:

  * Left child
  * Else right child

---

### 🔹 3. Leaf Nodes

* Traverse entire tree
* Add all **leaf nodes** (left → right)

---

### 🔹 4. Right Boundary

* Move from root → right side
* Add nodes **excluding leaf nodes**
* Always prefer:

  * Right child
  * Else left child
* Add in **reverse order**

---

## 🔄 Traversal Order (Important)

```id="order-boundary"
Root → Left Boundary → Leaves → Right Boundary (reverse)
```

---

## ⚠️ Important Conditions

* Do **not include leaf nodes** in left/right boundary
* Leaf nodes should be added **only once**
* Right boundary must be added in **reverse order**

---

## 🎯 Intuition

Imagine walking around the tree:

👉 Start from root
👉 Go down left side
👉 Cover all bottom leaves
👉 Come up from right side

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

---

## ⚠️ Common Mistakes

* Including leaf nodes twice
* Not reversing right boundary
* Wrong traversal direction
* Missing edge cases (single node tree)

---

## 🎯 Interview Insight

Best explanation:

👉 “I divide the boundary into left boundary, leaf nodes, and right boundary. I collect them separately while avoiding duplicates and finally combine them in anti-clockwise order.”

---

## 🚀 Key Takeaways

* Boundary = outer nodes only
* Split into **3 logical parts**
* Handle leaf nodes carefully
* Right boundary must be reversed

---
