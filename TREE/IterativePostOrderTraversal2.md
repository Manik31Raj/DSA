# 🌳 Iterative Postorder Traversal (Single Stack)

---

## 📌 Definition

**Postorder Traversal** follows:

> **Left → Right → Root**

* Traverse **left subtree**
* Then traverse **right subtree**
* Visit the **root at the end**

---

## 🌲 Example Tree

```id="q1p8zn"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 📊 Output

```id="y4j8rs"
4 → 5 → 2 → 6 → 7 → 3 → 1
```

---

## 🧠 Core Idea

Postorder is tricky because:

👉 A node must be processed **only after both left and right subtrees are done**

---

## 🔁 Key Insight

Instead of using two stacks:

* Use **one stack**
* Track whether the **right subtree is already processed**

---

## 🔄 Working Principle

1. Traverse **left as deep as possible**, pushing nodes into stack
2. When reaching null:

   * Check the **right child** of top node

---

### Two Cases:

#### 🔹 Case 1: Right child is NULL

* Process the node
* Pop it from stack
* Continue checking parent

---

#### 🔹 Case 2: Right child exists but NOT processed

* Move to **right subtree**
* Repeat left traversal

---

## 🔁 Backtracking Logic (Very Important)

After processing a node:

* Check if it was the **right child of its parent**
* If yes → parent is ready to be processed
* Continue popping and processing

---

## 🎯 Intuition

Think of recursion:

* Go left
* Then go right
* Then process node

👉 Here we manually track:

* Whether right subtree is done or not

---

## 📦 Stack Behavior

* Stack stores nodes whose processing is pending
* A node stays in stack until:

  * Left is done
  * Right is done

---

## ⚡ Why This Works

* Ensures correct order:

  ```id="order"
  Left → Right → Root
  ```
* Avoids extra space of second stack
* Mimics recursive call flow precisely

---

## 📊 Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

Where:

* N = number of nodes
* H = height of tree

---

## ⚠️ Common Mistakes

* Not checking right subtree properly
* Processing node before right subtree
* Missing backtracking condition
* Confusing with inorder logic

---

## 🎯 Interview Insight

Best explanation:

👉 “I use one stack and simulate recursion by tracking whether the right subtree has been processed before processing the node.”

---

## 🚀 Key Takeaways

* Harder than 2-stack method
* Requires careful handling of right subtree
* Stack + pointer tracking replaces recursion
* Very strong signal of deep understanding

---

## 🔥 Comparison

| Approach     | Idea                   | Space |
| ------------ | ---------------------- | ----- |
| Two Stack    | Reverse preorder       | O(N)  |
| Single Stack | Track right processing | O(H)  |

---
