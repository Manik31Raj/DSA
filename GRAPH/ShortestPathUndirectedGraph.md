# 🌐 Shortest Path in Unweighted Graph

---

## 📌 Problem

> Given an **undirected unweighted graph** and a source node, find the minimum distance from the source to every node.

---

## 🧠 What “Shortest Path” Means Here

```text
Shortest path = minimum number of edges from source to each node
```

Because all edges have the same weight `1`, the answer depends only on **number of steps**, not edge cost.

---

## 🌲 Example Graph

```text
0 --- 1 --- 2 --- 6 --- 7
|           / \     \    |
3 ---------       5  8 --- 
|
4 --- 5
```

Source:

```text
src = 3
```

---

## 🎯 Goal

Find minimum distance from `3` to every node.

Example distances:

```text
3 → 0 = 1
3 → 4 = 1
3 → 1 = 2
3 → 5 = 2
3 → 2 = 3
3 → 6 = 3
3 → 7 = 4
3 → 8 = 4
```

---

# 🔥 Core Idea

```text
Use BFS because BFS visits nodes level by level
```

👉 In an unweighted graph, the first time we reach a node is through the shortest path.

---

# 🔷 Why BFS Works

BFS explores:

* all nodes at distance `1`
* then all nodes at distance `2`
* then distance `3`
* and so on

So when a node is reached first, that is its minimum distance.

---

# 🔁 Working Principle

## Step 1: Initialize distance array

```text
dist[source] = 0
dist[others] = INF
```

---

## Step 2: Push source into queue

```text
queue = [source]
```

---

## Step 3: Process queue

For every popped node:

* check all neighbors
* if going through current node gives a smaller distance:

  * update neighbor distance
  * push neighbor into queue

---

## Step 4: Repeat until queue is empty

At the end, `dist[]` contains the shortest distance from the source to all nodes.

---

# 🧠 Intuition

```text
BFS is like spreading out in waves from the source
```

Each wave represents one more edge away from the source.

---

# 🔄 Example Flow

Source = `3`

```text
Level 0 → 3
Level 1 → 0, 4
Level 2 → 1, 5
Level 3 → 2, 6
Level 4 → 7, 8
```

So shortest distances become:

```text
3: 0
0: 1
4: 1
1: 2
5: 2
2: 3
6: 3
7: 4
8: 4
```

---

# ⚠️ Important Notes

```text
This approach works only for unweighted graphs
```

If edges have different weights, BFS is not enough.

---

# ❌ Common Mistakes

* ❌ Using BFS on weighted graph
* ❌ Forgetting to initialize distance with INF
* ❌ Not updating distance before pushing into queue
* ❌ Thinking visited array alone is enough for all cases

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

* each node can be processed
* each edge is checked once in BFS traversal

---

# 🎯 Interview Insight

👉
“I use BFS because all edges have equal weight. BFS explores level by level, so the first time a node is reached gives its shortest distance from the source.”

---

# 🔥 Key Insight

```text
Unweighted shortest path = BFS
```

---

# 🚀 Key Takeaways

* BFS gives shortest path in unweighted graphs
* Distance = number of edges
* Queue ensures level-wise processing
* Not suitable for weighted graphs

---

# 🔥 Pattern Connection

* BFS traversal
* Level order processing
* Grid shortest path problems

---
