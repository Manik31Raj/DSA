# 🏝️ Number of Islands (Grid BFS)

---

## 📌 Problem

> Given a 2D grid of `0` (water) and `1` (land),
> find the **number of islands**.

---

# 📌 What is an Island?

```text id="island-def"
An island is a group of connected 1’s (land)
surrounded by 0’s (water)
```

---

# 🔷 Connection Types (VERY IMPORTANT)

---

## 🔹 4-Direction (Standard)

```text id="dir4"
Up, Down, Left, Right
```

---

## 🔹 8-Direction 

```text id="dir8"
Includes diagonals also
```

---

## 🔁 Directions Used in this Code

```text id="directions"
(-1,-1) (-1,0) (-1,1)
( 0,-1) (0,0)  (0,1)
( 1,-1) (1,0)  (1,1)
```

---

# 🌲 Example Grid

```id="grid-example"
1 1 0 0
0 1 0 1
1 0 0 1
0 0 1 1
```

---

# 🧠 Key Observation

```text id="obs"
Cell (2,0) is diagonally connected to (1,1)
```

👉 So it is **NOT a separate island**

---

# 🎯 Correct Answer 

```text id="ans"
Number of Islands = 2 ✅
```

---

# 🔄 Why NOT 3?

---

## ❌ Wrong assumption

```text id="wrong"
Treating diagonal cells as disconnected
```

---

## ✅ Correct logic

```text id="correct"
Diagonal connections ARE allowed
```

👉 So islands merge

---

# 🔄 Comparison

---

## 🔹 If 4-direction only

```text id="case4"
Islands = 3
```

---

## 🔹 If 8-direction 

```text id="case8"
Islands = 2
```

---

# 🔥 Core Idea

```text id="core"
Count connected components in grid
```

---

# 🔷 Approach: BFS

---

## 🧠 Idea

```text id="bfs-core"
Start BFS from every unvisited land cell
```

---

## 🔁 Steps

1. Traverse grid
2. If cell = 1 and not visited:

```text id="steps"
- Increase island count  
- Run BFS to mark entire island
```

---

## 🎯 Intuition

```text id="intuition"
One BFS traversal = one island
```

---

# 🔷 BFS Working

---

## 📦 Queue Stores

```text id="queue"
(row, col)
```

---

## 🔁 For each cell

```text id="bfs-steps"
- Explore all 8 directions  
- Check bounds  
- If land and not visited → add to queue  
```

---

# ⚡ Complexity

* **Time Complexity:** O(N × M)
* **Space Complexity:** O(N × M)

---

# ⚠️ Important Notes

```text id="note"
Always clarify connectivity (4-dir vs 8-dir)
```

---

# ❌ Common Mistakes

* ❌ Ignoring diagonal connections
* ❌ Wrong direction loops
* ❌ Revisiting nodes
* ❌ Boundary errors

---

# 🎯 Interview Insight

👉
“I treat the grid as a graph and count connected components. The result depends on whether we consider 4-direction or 8-direction connectivity.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Island count depends on connection definition
```

---

# 🚀 Key Takeaways

* Grid = graph problem
* BFS/DFS both work
* Direction choice changes answer
* Always clarify in interview

---

# 🔥 Pattern Connection

* Number of provinces
* Flood fill
* Connected components

---
