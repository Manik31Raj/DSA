# 🌳 Level Order Traversal (BFS)

---

## 📌 Definition

**Level Order Traversal** means:

> Visiting all nodes of a binary tree **level by level**, from **left to right**.

👉 Also known as **Breadth-First Search (BFS)**.

---

## 🌲 Example Tree

```id="xq9l2m"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 📊 Output (Level Wise)

```
[
  [1],
  [2, 3],
  [4, 5, 6, 7]
]
```

---

## 🎯 Core Idea

* Process nodes **level by level**
* Use a **Queue (FIFO)** to maintain order

---

## 🔁 How It Works

1. Start with the **root node** in the queue
2. Repeat until queue is empty:

   * Get number of nodes at current level
   * Process all nodes of that level
   * Add their children to queue
3. Store each level separately

---

## 🧠 Key Insight

* Queue ensures:

  * First-in → First-out
  * Nodes are processed in **correct level order**

---

## 🔄 Flow of Traversal

* Level 1 → process root
* Level 2 → process children of root
* Level 3 → process grandchildren

👉 Moves **horizontally**, not vertically

---

## 📦 Why Queue is Used

* Maintains order of nodes
* Ensures left-to-right traversal
* Mimics real-world “line processing”

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(N)

Where:

* N = number of nodes

---

## 🧩 Variation: Zig-Zag Traversal

Instead of always left → right:

* Alternate direction at each level:

  * Level 1 → Left → Right
  * Level 2 → Right → Left
  * Level 3 → Left → Right

👉 Can be achieved by reversing alternate levels

---

## ⚠️ Common Mistakes

* Not tracking level size → mixes levels
* Forgetting to check null root
* Using stack instead of queue (wrong order)

---

## 🎯 Interview Insight

Best explanation:

👉 “I use a queue to process nodes level by level. For each level, I process all nodes currently in the queue and push their children, ensuring correct order.”

---

## 🚀 Key Takeaways

* BFS = level-wise traversal
* Queue is the core data structure
* Very useful for:

  * shortest path (graphs)
  * level-based problems
  * tree views (top view, bottom view)

---
