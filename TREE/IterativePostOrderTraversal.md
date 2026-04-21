# 🌳 Iterative Postorder Traversal (Using Two Stacks)

---

## 📌 Definition

**Postorder Traversal** follows:

> **Left → Right → Root**

* First visit **left subtree**
* Then visit **right subtree**
* Process the **root at the end**

---

## 🌲 Example Tree

```id="f4n2sk"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 📊 Output

```id="x8q2lp"
4 → 5 → 2 → 6 → 7 → 3 → 1
```

---

## 🧠 Core Idea

Postorder is difficult iteratively because:

* Root must be processed **after both subtrees**

👉 Trick:

* Use **two stacks** to reverse processing order

---

## 🔁 Working Principle

1. Push root into **Stack 1**

2. While Stack 1 is not empty:

   * Pop a node
   * Push it into **Stack 2**
   * Push its **left child** into Stack 1
   * Push its **right child** into Stack 1

3. Finally:

   * Pop all elements from **Stack 2**
   * This gives **Postorder traversal**

---

## 🔄 Why This Works

* Stack 1 processes nodes in:

  ```id="flow1"
  Root → Right → Left
  ```

* Stack 2 reverses it to:

  ```id="flow2"
  Left → Right → Root
  ```

👉 Which is exactly **Postorder**

---

## 📦 Stack Behavior

### Stack 1:

* Used for traversal
* Controls visiting order

### Stack 2:

* Stores nodes in reverse order
* Final output comes from here

---

## 🎯 Intuition

Think of it like:

* First collect nodes in **modified preorder (Root → Right → Left)**
* Then reverse it → gives **Postorder**

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(N)

Where:

* N = number of nodes

---

## ⚠️ Common Mistakes

* Pushing children in wrong order
* Confusing left/right push sequence
* Forgetting final reversal step
* Trying to process directly from first stack

---

## 🎯 Interview Insight

Best explanation:

👉 “I use two stacks—first to traverse in modified preorder (root, right, left), and second to reverse that order to get postorder.”

---

## 🚀 Key Takeaways

* Postorder is hardest to simulate iteratively
* Two-stack method simplifies logic
* First stack → traversal
* Second stack → reversal
* Very common interview pattern

---
