# 🌐 Bipartite Graph

---

## 📌 Problem

> Check whether a graph is **bipartite** or not.

---

## 📌 Definition

```text
A graph is bipartite if its vertices can be divided into 2 sets
such that no edge connects vertices of the same set.
```

---

## 🎨 Two-Color View

```text
Colour 0 = Black
Colour 1 = White
```

👉 If we can color the whole graph using only **2 colors** such that:

* adjacent nodes always have different colors
* then the graph is **bipartite**

---

## 🌲 Example of Bipartite Graph

```text
Set A      Set B
  1  ----   2
  |         |
  4  ----   3
```

---

## ❌ Example of Non-Bipartite Graph

```text
1 --- 2
 \   /
   3
```

👉 This forms an **odd cycle**
👉 So it cannot be bipartite

---

## 🔥 Important Insight

```text
A graph is bipartite if and only if it has NO odd cycle
```

---

## 🧠 Core Idea

```text
Try to color all connected components using 2 colors
```

If any adjacent node gets the same color → not bipartite.

---

# 🔷 Why Coloring Works?

If two adjacent vertices had the same color, then they belong to the same set, which breaks the bipartite rule.

```text
Adjacent nodes must always have different colors
```

---

# 🔷 Color Array

```text
-1 → no color assigned yet
 0 → black
 1 → white
```

---

# 🔁 Working Principle

1. Initialize all nodes with color `-1`
2. Traverse every node, because graph can be disconnected
3. If a node is uncolored:

   * start DFS/BFS from it
   * assign one color
4. For every neighbor:

   * if uncolored → assign opposite color
   * if already colored with same color → return false

---

# 🔷 DFS Approach

## 🧠 Idea

Use recursion to color neighbors with opposite colors.

---

## 🔁 DFS Logic

```text
current node = colour[curr]
neighbor should be = 1 - colour[curr]
```

If neighbor already has same color as current → cycle of odd length or conflict → not bipartite.

---

## 🎯 Intuition

```text
Go deep, color opposite colors level by level
```

---

# 🔷 BFS Approach

## 🧠 Idea

Use queue and color nodes level wise.

---

## 🔁 BFS Logic

* Start with source color `0`
* Push into queue
* For each popped node:

  * check neighbors
  * color them opposite
  * if same color found → false

---

## 🎯 Intuition

```text
BFS naturally colors level by level
```

---

# 🌲 Visual Example from Your Graph

```text
1 --- 2 --- 3 --- 4
      |     |     |
      6 --- 9 --- 5
            |
            7 --- 8
```

👉 Try coloring:

* 1 = Black
* 2 = White
* 3 = Black
* 4 = White
* 5 = White/Black depending on path
* if any edge connects same color → fail

---

# ⚠️ Why We Check All Nodes

```text
Graph may be disconnected
```

So we must run DFS/BFS for every uncolored node.

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

* Every vertex is visited once
* Every edge is checked once

---

# ❌ Common Mistakes

* ❌ Checking only one component
* ❌ Not using color array
* ❌ Forgetting opposite color assignment
* ❌ Ignoring odd cycle condition

---

# 🎯 Interview Insight

👉
“A graph is bipartite if we can color it using two colors such that adjacent nodes always have opposite colors. I use DFS/BFS to propagate colors and detect conflicts.”

---

# 🔥 Key Insight

```text
Bipartite graph = 2-colorable graph = no odd cycle
```

---

# 🔄 BFS vs DFS

| Method | Data Structure | Style          |
| ------ | -------------- | -------------- |
| DFS    | Recursion      | Deep coloring  |
| BFS    | Queue          | Level coloring |

---

# 🚀 Key Takeaways

* Use 2 colors only
* Adjacent nodes must differ
* Works on disconnected graphs
* Odd cycle means not bipartite

---

# 🔥 Pattern Connection

* Graph coloring
* Cycle detection
* BFS / DFS on graphs

---
