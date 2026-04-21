# 🌳 Iterative Inorder Traversal (Using Stack)

---

## 📌 Definition

**Inorder Traversal** follows:

> **Left → Root → Right**

* First visit **left subtree**
* Then process **root**
* Then visit **right subtree**

---

## 🌲 Example Tree

```id="kz8w1q"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 📊 Output

```id="w7n2lc"
4 → 2 → 5 → 1 → 6 → 3 → 7
```

---

## 🧠 Core Idea

* Simulate recursion using a **stack**
* Traverse as far left as possible
* Then process nodes while backtracking

---

## 🔁 Working Principle

1. Start from root
2. Keep moving to **left child**, pushing nodes into stack
3. When no left exists:

   * Pop from stack
   * Process the node
   * Move to its **right child**
4. Repeat until:

   * Stack is empty
   * Current node is null

---

## 🔄 Flow of Traversal

* Go **deep left first**
* Then come back to parent
* Then go **right**

👉 Exactly mimics recursive inorder

---

## 📦 Stack Behavior (Important)

* Stack stores nodes **waiting to be processed**
* Nodes are added while going left
* Nodes are processed when coming back

---

## 🎯 Intuition

Think of recursion:

* Keep calling left
* When left ends → process node
* Then go right

👉 Stack manually simulates this process

---

## ⚡ Why This Works

* Ensures correct order:

  * Left subtree first
  * Then root
  * Then right subtree

* No need for recursion → avoids call stack

---

## 📊 Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

Where:

* N = number of nodes
* H = height of tree

---

## ⚠️ Common Mistakes

* Not pushing all left nodes
* Forgetting to move to right subtree
* Breaking loop too early
* Confusing with preorder logic

---

## 🎯 Interview Insight

Best explanation:

👉 “I simulate recursion using a stack by pushing all left nodes, then processing nodes while backtracking and moving to the right subtree.”

---

## 🚀 Key Takeaways

* Stack replaces recursion
* Always go **left first**
* Process node when popping
* Very common and important tree pattern

---
