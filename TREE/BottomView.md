
# 🌳 Bottom View of Binary Tree

---

## 📌 Definition

**Bottom View** of a binary tree is:

> The set of nodes visible when the tree is viewed from the **bottom**.

---

## 🌲 Example Tree

```id="bv-tree"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 👀 Visual Idea

Imagine looking from **below the tree**:

👉 Only the **lowest (last) node** at each vertical position is visible

---

## 🧭 Horizontal Distance (Key Concept)

Assign each node a value:

* Root → **0**
* Left child → **-1**
* Right child → **+1**

---

## 📍 Node Positions

```id="bv-coord"
        1 (0)
       /     \
  2 (-1)    3 (+1)
   /   \      /   \
4(-2) 5(0) 6(0) 7(+2)
```

---

## 🎯 Bottom View Selection

Pick the **last node encountered** at each horizontal distance:

```id="bv-pick"
x = -2 → 4  
x = -1 → 2  
x =  0 → 5 or 6 (depends on traversal, but last seen)  
x = +1 → 3  
x = +2 → 7  
```

👉 With BFS, deeper nodes overwrite earlier ones

---

## 📊 Final Output

```id="bv-out"
4 → 2 → 6 → 3 → 7
```

*(Note: At x = 0, node 6 appears after 5, so it becomes visible in bottom view)*

---

## 🧠 Core Idea

* Track nodes using **horizontal distance (x)**
* Use **BFS traversal**
* Always **update value at each x** (overwrite previous)

---

## 🔁 Working Principle

1. Start from root with x = 0
2. Use a **queue (BFS)**
3. For each node:

   * Update map[x] = node value (overwrite)
4. Move:

   * Left → x - 1
   * Right → x + 1

---

## 🎯 Why Overwriting Works

* BFS ensures nodes are visited level by level
* Deeper nodes come later → overwrite earlier ones
* Final stored value = bottom-most node

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

* Not overwriting values
* Using DFS incorrectly
* Not tracking horizontal distance
* Confusing with Top View logic

---

## 🎯 Interview Insight

Best explanation:

👉 “I use BFS and track horizontal distance. For each vertical line, I overwrite the value so that the last (bottom-most) node remains.”

---

## 🚀 Key Takeaways

* Bottom view = **last node at each vertical line**
* BFS ensures correct ordering
* Overwriting is key difference from Top View
* Very common tree view problem

---

## 🔥 Top View vs Bottom View (Quick Diff)

| Feature    | Top View        | Bottom View      |
| ---------- | --------------- | ---------------- |
| Selection  | First node at x | Last node at x   |
| Map Update | Only if absent  | Always overwrite |
| Visibility | From top        | From bottom      |

---
