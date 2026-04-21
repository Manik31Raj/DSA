# 🌳 Iterative Preorder Traversal (Using Stack)

---

## 📌 Definition

**Preorder Traversal** follows:

> **Root → Left → Right**

* Visit the **root first**
* Then traverse the **left subtree**
* Then traverse the **right subtree**

---

## 🌲 Example Tree

```id="m2k8qp"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 📊 Output

```id="d8z4nt"
1 → 2 → 4 → 5 → 3 → 6 → 7
```

---

## 🧠 Core Idea

* Use a **stack** to simulate recursion
* Process node **immediately when visited**
* Ensure left subtree is processed before right

---

## 🔁 Working Principle

1. Start by pushing **root** into stack
2. While stack is not empty:

   * Pop the top node
   * Process it (add to preorder)
   * Push **right child first**
   * Push **left child next**

---

## 🔄 Why Right is Pushed First

* Stack is **LIFO (Last In First Out)**
* To process **left before right**, we:

  * Push **right first**
  * Then push **left**

👉 So left gets processed first when popping

---

## 📦 Stack Behavior

* Stack stores nodes **waiting to be processed**
* Order of pushing controls traversal sequence
* Ensures correct preorder flow

---

## 🎯 Intuition

Think of recursion:

* Visit node → process immediately
* Then go left
* Then go right

👉 Stack simulates this order explicitly

---

## ⚡ Why This Works

* Maintains correct traversal order:

  ```id="order-pre"
  Root → Left → Right
  ```
* Avoids recursion
* Efficient and simple

---

## 📊 Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

Where:

* N = number of nodes
* H = height of tree

---

## ⚠️ Common Mistakes

* Pushing left before right (wrong order)
* Forgetting stack behavior (LIFO)
* Not checking null root
* Confusing with inorder logic

---

## 🎯 Interview Insight

Best explanation:

👉 “I use a stack and process nodes immediately. By pushing the right child before the left, I ensure the left subtree is processed first, maintaining preorder sequence.”

---

## 🚀 Key Takeaways

* Preorder is easiest iterative traversal
* Stack replaces recursion
* Push right first, then left
* Very common and fundamental pattern

---
