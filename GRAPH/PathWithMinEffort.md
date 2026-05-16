# 🧗 Minimum Effort Path in Grid

---

## 📌 Problem

> Given a grid of heights, find a path from source to destination such that the **effort** of the path is minimum.

---

## 📌 What is Effort?

For a move from one cell to another:

```text
edge cost = |height1 - height2|
```

For a complete path:

```text
path effort = maximum edge cost along that path
```

👉 So we are not minimizing sum.
👉 We are minimizing the **maximum jump**.

---

## 🌲 Example Grid

```text
1 2 2
3 8 2
5 3 5
```

Source:

```text
(0,0)
```

Destination:

```text
(2,2)
```

---

## 🎯 Output

```text
Minimum effort = 2
```

---

# 🔥 Core Idea

```text
Use Dijkstra-like shortest path logic
but the path value is based on maximum edge cost
```

---

# 🧠 Why Dijkstra?

This is not a normal shortest path by sum.

Instead:

* each state has a current best effort
* we always expand the cell with the **smallest effort so far**
* if a new path has smaller effort, update it

This makes it a **minimax path problem**.

---

# 🔷 Working Principle

---

## Step 1: Distance Matrix

```text
dist[row][col] = minimum effort needed to reach this cell
```

Initialize all values to `INF`.

---

## Step 2: Priority Queue

Store:

```text
(effort, cell)
```

The cell with minimum effort is processed first.

---

## Step 3: Relax Neighbors

For each move:

```text
edgeCost = abs(currentHeight - nextHeight)
newEffort = max(currentEffort, edgeCost)
```

If:

```text
newEffort < dist[next]
```

then update it.

---

## Step 4: Stop Early

If destination is popped from the priority queue:

```text
return current effort
```

This is the minimum effort.

---

# 🎯 Intuition

```text
The best path is not the one with smallest total cost,
but the one whose biggest jump is as small as possible.
```

So we try to keep the “worst step” on the path as low as possible.

---

# 🔄 Example Thinking

Suppose two paths reach the destination:

### Path 1

```text
1 → 2 → 8 → 5
```

Edge costs:

```text
1, 6, 3
```

Path effort:

```text
6
```

---

### Path 2

```text
1 → 3 → 5 → 5
```

Edge costs:

```text
2, 2, 0
```

Path effort:

```text
2
```

👉 Path 2 is better because its maximum jump is smaller.

---

# ⚠️ Important Notes

```text
This is NOT regular BFS
This is NOT shortest sum path
This is a minimum-maximum path problem
```

---

# ❌ Common Mistakes

* ❌ Minimizing sum instead of maximum edge cost
* ❌ Using plain BFS
* ❌ Forgetting to use priority queue
* ❌ Not updating effort with max(current, edgeCost)
* ❌ Returning too late instead of stopping when destination is reached

---

# ⚡ Complexity

* **Time Complexity:** O(N × M × log(N × M))
* **Space Complexity:** O(N × M)

---

## ❓ Why?

* each cell can enter the priority queue
* heap operations cost `log(N × M)`

---

# 🎯 Interview Insight

👉
“I model the grid as a weighted graph where each move cost is the absolute height difference. The path cost is the maximum edge cost along the path, so I use a Dijkstra-style approach with a priority queue and relax neighbors using `max(currentEffort, edgeCost)`.”

---

# 🔥 Key Insight

```text
Minimum effort path = minimize the maximum edge cost on the route
```

---

# 🚀 Key Takeaways

* Path cost is max edge difference, not sum
* Use priority queue
* Relax using `max(currentEffort, edgeCost)`
* Stop when destination is reached

---

# 🔥 Pattern Connection

* Dijkstra-style graph traversal
* Grid shortest path variation
* Minimax path problems

---
