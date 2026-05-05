# 🎨 Flood Fill Algorithm (BFS & DFS)

---

## 📌 Problem

> Given a starting cell `(sr, sc)` and a new color,
> replace all **connected cells with same initial color**.

---

# 🧠 What is Flood Fill?

```text id="def"
Fill all connected cells (same color) with a new color
```

---

## 🌲 Example

```id="flood-grid"
1 1 1
2 2 0
2 2 2
```

---

## 🎯 Input

```text id="input"
Start = (2,0)  
New Color = 3
```

---

## ✅ Output

```text id="output"
1 1 1
3 3 0
3 3 3
```

---

# 🔷 Movement (4 Directions)

---

## 🔁 Direction Grid

```text id="dir4"
        (-1,0)
           ↑

(0,-1) ← (0,0) → (0,+1)

           ↓
        (+1,0)
```

---

## 🧠 Direction Arrays

```text id="dir-array"
dRow = {-1, 0, +1, 0}  
dCol = { 0,+1,  0,-1}
```

---

# 🔥 Core Idea

```text id="core"
Traverse all connected cells with same color
```

---

# 🔷 Approach 1: DFS

---

## 🧠 Idea

```text id="dfs-core"
Use recursion to go deep and color cells
```

---

## 🔁 Steps

1. Store initial color
2. Replace current cell
3. Explore all 4 directions

```text id="dfs-steps"
If neighbor has same color → DFS call
```

---

## 🎯 Intuition

```text id="dfs-int"
Spread like paint using recursion
```

---

# 🔷 Approach 2: BFS

---

## 🧠 Idea

```text id="bfs-core"
Use queue to spread level by level
```

---

## 🔁 Steps

1. Push starting cell into queue
2. Change its color
3. While queue not empty:

```text id="bfs-steps"
- Pop cell  
- Visit neighbors  
- Color and push valid cells
```

---

## 🎯 Intuition

```text id="bfs-int"
Spread like wave from starting cell
```

---

# ⚡ Complexity

* **Time Complexity:** O(N × M)
* **Space Complexity:** O(N × M)

---

## ❓ Why?

```text id="tc"
Each cell is visited once
```

---

# ⚠️ Important Edge Case

```text id="edge"
If initial color == new color → return immediately
```

👉 Prevents infinite loop

---

# ❌ Common Mistakes

* ❌ Not checking bounds
* ❌ Not storing initial color
* ❌ Infinite recursion
* ❌ Recoloring already visited cell

---

# 🔄 BFS vs DFS

| Feature   | BFS                   | DFS        |
| --------- | --------------------- | ---------- |
| Structure | Queue                 | Recursion  |
| Flow      | Level-wise            | Depth-wise |
| Use       | Safer for large grids | Simple     |

---

# 🎯 Interview Insight

👉
“I treat the grid as a graph and perform BFS/DFS from the starting cell, replacing all connected components with the same color.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Flood fill = connected component traversal in grid
```

---

# 🚀 Key Takeaways

* Works like BFS/DFS on grid
* Use 4-direction movement
* Avoid revisiting cells
* Handle edge cases carefully

---

# 🔥 Pattern Connection

* Number of Islands
* Connected Components
* Grid traversal problems

---
