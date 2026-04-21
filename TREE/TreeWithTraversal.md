# 🌳 Binary Tree Traversals (Recursive)

---

## 📌 Definition

**Tree Traversal** means:

> Visiting every node of a binary tree in a specific order.

There are **three main types**:

* Preorder
* Inorder
* Postorder

---

## 🌲 Example Tree

```id="tree-basic"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

# 📖 Types of Traversals

---

## 🔹 1. Preorder Traversal

### 📌 Order:

> **Root → Left → Right**

### 🔄 Steps:

1. Visit root
2. Traverse left subtree
3. Traverse right subtree

### 📊 Output:

```id="pre-out"
1 → 2 → 4 → 5 → 3 → 6 → 7
```

---

## 🔹 2. Inorder Traversal

### 📌 Order:

> **Left → Root → Right**

### 🔄 Steps:

1. Traverse left subtree
2. Visit root
3. Traverse right subtree

### 📊 Output:

```id="in-out"
4 → 2 → 5 → 1 → 6 → 3 → 7
```

---

## 🔹 3. Postorder Traversal

### 📌 Order:

> **Left → Right → Root**

### 🔄 Steps:

1. Traverse left subtree
2. Traverse right subtree
3. Visit root

### 📊 Output:

```id="post-out"
4 → 5 → 2 → 6 → 7 → 3 → 1
```

---

## 🧠 Core Idea (Recursion)

All three traversals use the same idea:

* Break problem into:

  * Left subtree
  * Right subtree
* Only difference is **when you process the root**

---

## 🔁 Key Difference (Very Important)

| Traversal | When Root is Processed |
| --------- | ---------------------- |
| Preorder  | Before recursion       |
| Inorder   | Between left & right   |
| Postorder | After recursion        |

---

## 🎯 Intuition

Think of recursion flow:

* Enter node → possible action
* Go left
* Come back → possible action
* Go right
* Come back → possible action

👉 The **position of action defines traversal type**

---

## 📦 Recursion Behavior

For every node:

* Function calls itself on left
* Then right
* Base case: node is null

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

Where:

* N = number of nodes
* H = height of tree

---

## ⚠️ Common Mistakes

* Mixing traversal orders
* Forgetting base case (null check)
* Confusing inorder with preorder

---

## 🎯 Interview Insight

Best explanation:

👉 “All traversals are the same recursive structure; the only difference is when we process the root—before, between, or after recursive calls.”

---

## 🚀 Key Takeaways

* Traversals differ only by **root processing position**
* Recursion naturally fits tree structure
* Foundation for all advanced tree problems

---
