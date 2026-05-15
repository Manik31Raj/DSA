# 🧩 Shortest Path in Binary Maze

---

## 📌 Problem

> Given a binary maze:

* `1` → open cell
* `0` → blocked cell

Find the **minimum number of steps** to move from a source cell to a destination cell.

---

## 🌲 Example Maze

```text
1 1 1 1
1 1 0 1
1 1 1 1
1 1 0 0
1 0 0 0
```

---

## 🎯 Query

```text
Source = (0,1)
Destination = (2,2)
```

---

## ✅ Output

```text
Shortest Path Distance = 3
```

---

# 🔥 Core Idea

```text
This is an unweighted shortest path problem on a grid
So BFS is the correct approach
```

---

# 🧠 Why BFS?

BFS explores cells level by level.

Since every move has equal cost `1`, the first time we reach the destination is the **shortest distance**.

---

# 🔷 Movement Rule

```text
Only 4-direction movement is allowed:
Up, Right, Down, Left
```

---

## 🧭 Direction Grid

```text
        (-1,0)
           ↑

(0,-1) ← (0,0) → (0,+1)

           ↓
        (+1,0)
```

---

# 🔁 Working Principle

---

## Step 1: Check Validity

If:

* source is blocked
* destination is blocked

then return `-1`.

If source and destination are same:

```text
distance = 0
```

---

## Step 2: Initialize Distance Matrix

```text
dist[row][col] = INF
```

Set source distance to `0`.

---

## Step 3: BFS from Source

Use a queue that stores:

```text
(distance, cell)
```

For every cell:

* explore 4 neighbors
* if neighbor is open and can be reached in smaller distance

  * update distance
  * push into queue

---

## Step 4: Stop Early

If destination is reached:

```text
return distance immediately
```

---

# 🎯 Intuition

```text
Think of the maze as a graph
Open cells are nodes
Valid moves are edges
```

Because all edges have equal weight, BFS naturally gives the shortest path.

---

# 🔄 Example Flow

Starting from:

```text
(0,1)
```

Possible path:

```text
(0,1) → (1,1) → (2,1) → (2,2)
```

So:

```text
Distance = 3
```

---

# ⚠️ Important Notes

```text
Blocked cells (0) cannot be visited
```

```text
Only 4-direction adjacency is allowed
```

```text
This works only because every move has equal cost
```

---

# ❌ Common Mistakes

* ❌ Using DFS for shortest path in unweighted grid
* ❌ Forgetting to check blocked source/destination
* ❌ Not using a distance matrix
* ❌ Allowing diagonal movement by mistake
* ❌ Re-visiting cells with worse distance

---

# ⚡ Complexity

* **Time Complexity:** O(N × M)
* **Space Complexity:** O(N × M)

---

## ❓ Why?

Each cell can be processed at most once with its best distance.

---

# 🎯 Interview Insight

👉
“I treat the maze as an unweighted graph and use BFS because every move has the same cost. I maintain a distance matrix to store the shortest steps to each cell, and I stop early when the destination is reached.”

---

# 🔥 Key Insight

```text
Binary maze shortest path = BFS on grid
```

---

# 🚀 Key Takeaways

* Open cells form a graph
* BFS finds minimum steps
* Use 4-direction movement
* Distance matrix avoids revisiting worse paths
* Early stop improves efficiency

---

# 🔥 Pattern Connection

* Grid BFS
* Unweighted shortest path
* Maze traversal
* Multi-step reachability problems

---
