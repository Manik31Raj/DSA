# 🌳 Top View of Binary Tree

---

## 📌 Definition

**Top View** of a binary tree is:

> The set of nodes visible when the tree is viewed from the **top**.

---

## 🌲 Example Tree

```id="tv-tree"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 👀 Visual Idea

Imagine looking from **above the tree**:

👉 Only the **topmost node** at each vertical position is visible

---

## 🧭 Horizontal Distance (Key Concept)

Assign each node a value:

* Root → **0**
* Left child → **-1**
* Right child → **+1**

---

## 📍 Node Positions

```id="tv-coord"
        1 (0)
       /     \
  2 (-1)    3 (+1)
   /   \      /   \
4(-2) 5(0) 6(0) 7(+2)
```

---

## 🎯 Top View Selection

Pick the **first node encountered** at each horizontal distance:

```id="tv-pick"
x = -2 → 4  
x = -1 → 2  
x =  0 → 1  
x = +1 → 3  
x = +2 → 7  
```

---

## 📊 Final Output

```id="tv-out"
4 → 2 → 1 → 3 → 7
```

---

## 🧠 Core Idea

* Track nodes using **horizontal distance (x)**
* Use **BFS (level order traversal)**
* Store the **first node encountered** at each x

---

## 🔁 Working Principle

1. Start from root with x = 0
2. Use a **queue** for BFS
3. For each node:

   * If x not seen before → store node
4. Move:

   * Left → x - 1
   * Right → x + 1

---

## 🎯 Why BFS is Important

* Ensures nodes are processed **level by level**
* First node at each x is the **topmost**

---

## 📦 Data Structure

* **TreeMap** → keeps x sorted
* **Queue** → BFS traversal

---

## ⚡ Complexity

* **Time Complexity:** O(N log N)
* **Space Complexity:** O(N)

---

## ⚠️ Common Mistakes

* Using DFS → may give wrong order
* Overwriting existing values in map
* Not tracking horizontal distance properly

---

## 🎯 Interview Insight

Best explanation:

👉 “I use BFS and track horizontal distance. For each vertical line, I store the first node encountered, which represents the top view.”

---

## 🚀 Key Takeaways

* Top view = **first node at each vertical line**
* BFS ensures correct ordering
* Horizontal distance is key
* Very common “view” problem

---

## 🔥 Pattern Connection

Related problems:

* Bottom View → last node at each x
* Vertical Traversal → all nodes grouped by x
* Left/Right View → level-based visibility

---
