# 🚀 Dijkstra’s Algorithm

---

## 📌 Problem

> Find the **shortest path from a source node to all other nodes** in a **weighted graph**.

---

## ✅ Works For

```text
Weighted graph with NON-NEGATIVE edge weights
```

---

## ❌ Does NOT Work For

```text
Graphs with negative edge weights
Graphs with negative cycles
```

---

## 🧠 Core Idea

```text
Always pick the currently closest unprocessed node,
then relax its outgoing edges.
```

That is why Dijkstra uses a **min-heap / priority queue**.

---

# 🔷 Key Data Structures

---

## 1️⃣ Distance Array

```text
dist[node] = current best known distance from source
```

---

## 2️⃣ Min Heap / Priority Queue

```text
Stores (distance, node)
Smallest distance node is processed first
```

---

# 🔁 Working Principle

---

## Step 1: Initialize

* `dist[source] = 0`
* all others = `∞`

---

## Step 2: Push source into heap

```text
(distance = 0, node = source)
```

---

## Step 3: Process smallest distance node

Pop the node with minimum tentative distance.

For each neighbor:

```text
if dist[neighbor] > dist[curr] + weight
    update it
```

This is called **relaxation**.

---

## Step 4: Repeat until heap is empty

At the end, `dist[]` contains shortest distances.

---

# 🎯 Intuition

```text
Dijkstra = greedy shortest path
```

It always trusts the **current smallest distance**.

---

# 🌲 Example Graph

```text
0 --4-- 1
|       |
4       2
|     / | \
2    3  1  6
|    |      |
3    5 --2-- 4
```

Source = `0`

---

# 🔥 Why Non-Negative Weights Are Required

Dijkstra assumes:

```text
Once a node has the smallest distance, that distance is final.
```

This is only true when all edge weights are **non-negative**.

---

## ❌ What goes wrong with negative edges?

A later path may reduce the distance of a node that was already considered “final”.

### Example

```text
0 → 1 (2)
0 → 2 (5)
2 → 1 (-10)
```

If Dijkstra first finalizes node `1` with distance `2`,
later it discovers path:

```text
0 → 2 → 1 = 5 + (-10) = -5
```

👉 So the earlier “final” answer was wrong.

---

# ❌ Why Negative Cycles Break Everything

## Example

```text
1 → 2 (2)
2 → 3 (-5)
3 → 1 (1)
```

Total cycle weight:

```text
2 + (-5) + 1 = -2
```

This is a **negative cycle**.

---

## Why is this bad?

You can keep moving around the cycle:

```text
1 → 2 → 3 → 1 → 2 → 3 → 1 ...
```

and the total distance keeps decreasing.

So there is **no minimum shortest path**.

```text
Shortest path becomes undefined
```

---

# 🔷 Important Conclusion

```text
Dijkstra works only when all edges are >= 0
```

For negative weights, use:

```text
Bellman-Ford
```

---

# 🔁 In This Code

Implementation:

* uses a **PriorityQueue**
* stores `(distance, node)`
* skips stale entries:

```text
if(dis > dist[curr]) continue;
```

This is the standard optimized Dijkstra pattern.

---

# ⚠️ Important Notes

```text
Graph can be directed or undirected,
but edge weights must be non-negative
```

---

# ❌ Common Mistakes

* ❌ Using Dijkstra on negative edges
* ❌ Using Dijkstra on negative cycles
* ❌ Forgetting stale-state check
* ❌ Thinking it works for any weighted graph

---

# ⚡ Complexity

* **Time Complexity:** O((V + E) log V)
* **Space Complexity:** O(V)

---

## ❓ Why?

* each node may enter the heap
* each relaxation may push a new entry
* heap operations cost `log V`

---

# 🎯 Interview Insight

👉
“I use a min-heap to always process the smallest tentative distance first. This greedy choice is valid only because all edge weights are non-negative. Negative edges can invalidate finalization, and negative cycles make shortest paths undefined.”

---

# 🔥 Key Insight

```text
Dijkstra = greedy + min-heap + non-negative edge weights
```

---

# 🚀 Key Takeaways

* Best for non-negative weighted graphs
* Uses relaxation + priority queue
* Negative edges break the greedy guarantee
* Negative cycles make shortest path impossible

---

# 🔥 Pattern Connection

* Shortest path problems
* Greedy + heap
* Graph relaxation techniques

---
