# 🌳 Vertical Order Traversal of Binary Tree

---

## 📌 Definition

**Vertical Traversal** means:

> Grouping nodes based on their **vertical position (x-axis)** from left to right.

* Nodes on the same vertical line are grouped together
* Traversal is done **column by column**

---

## 🌲 Example Tree

```id="vtree"
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
```

---

## 🧭 Coordinate System (Key Concept)

Assign each node a position:

* Root → **(x = 0, y = 0)**
* Left child → **(x - 1, y + 1)**
* Right child → **(x + 1, y + 1)**

---

## 📍 Node Positions

```id="coords"
        1 (0,0)
       /       \
  2 (-1,1)   3 (1,1)
   /   \       /   \
4(-2,2)5(0,2)6(0,2)7(2,2)
```

---

## 📊 Vertical Groups

Group nodes by **x-coordinate**:

```id="groups"
x = -2 → [4]
x = -1 → [2]
x =  0 → [1, 5, 6]
x =  1 → [3]
x =  2 → [7]
```

---

## 📈 Final Output

```id="vt-out"
[
  [4],
  [2],
  [1, 5, 6],
  [3],
  [7]
]
```

---

## 🧠 Core Idea

* Track nodes using **(x, y) coordinates**
* Use a structure to:

  * Sort by **x (vertical)**
  * Then by **y (level)**
  * Then by **value (if same position)**

---

## 📦 Data Structure Used

A nested structure:

```id="ds"
x → y → min-heap(nodes)
```

* **TreeMap (x)** → keeps vertical order sorted
* **TreeMap (y)** → keeps level sorted
* **PriorityQueue** → sorts nodes at same position

---

## 🔁 Working Principle

1. Start with root at (0,0)
2. Use **BFS (Queue)** to traverse
3. For each node:

   * Store it using its (x, y)
4. After traversal:

   * Extract values in sorted order

---

## 🎯 Why BFS is Used

* Ensures nodes are processed **level by level**
* Helps maintain correct ordering for same level

---

## ⚡ Sorting Rules (Important)

When multiple nodes share same position:

1. Sort by **level (y)**
2. If same level → sort by **value**

---

## 🔄 Intuition

Think of looking at the tree from **top view vertically**:

👉 Nodes aligned vertically fall into the same group

---

## 📊 Complexity

* **Time Complexity:** O(N log N)
* **Space Complexity:** O(N)

---

## ⚠️ Common Mistakes

* Not sorting nodes at same position
* Using DFS (can break level ordering)
* Not maintaining proper coordinates
* Ignoring duplicates at same (x, y)

---

## 🎯 Interview Insight

Best explanation:

👉 “I assign coordinates to each node and use BFS to group them by vertical level (x). I use sorted maps and a priority queue to maintain correct order when multiple nodes share the same position.”

---

## 🚀 Key Takeaways

* Use **coordinates (x, y)** to track position
* Vertical = same **x value**
* BFS + ordered maps = correct output
* PriorityQueue handles same-position sorting

---
