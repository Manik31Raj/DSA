# 🌳 Prim’s Algorithm for Minimum Spanning Tree (MST)

---

## 📌 Problem

> Given a **weighted undirected graph**, find a **Minimum Spanning Tree (MST)**.

An MST is a subset of edges that:

* connects all vertices
* has no cycle
* has minimum total weight

---

## 🌲 Example Graph

```text
0 --2-- 1
| \     |
1  1    1
|   \   |
2 --2-- 4
 \      /
  2    1
   \   /
     3
```

---

## 🧠 Core Idea

```text
Always pick the minimum weight edge that expands the current tree
```

That is why Prim’s Algorithm uses a **min-heap / priority queue**.

---

# 🔷 What Prim’s Algorithm Builds

Prim’s algorithm grows the MST **one node at a time**.

At every step:

* choose the smallest edge from the current tree to a new unvisited node
* add that edge to the MST
* continue until all nodes are included

---

# 🔁 Working Principle

---

## Step 1: Start from any node

Usually start from node `0`.

Put it into the priority queue with cost `0`.

---

## Step 2: Pick the smallest edge

Pop the edge with minimum weight from the min-heap.

If the node is already visited, skip it.

---

## Step 3: Add to MST

If the node is not visited:

* mark it visited
* add the edge to MST
* add its weight to total sum

---

## Step 4: Push all outgoing edges

For every neighbor of the current node:

* if neighbor is not visited
* push edge into priority queue

---

# 🎯 Intuition

```text
Prim’s algorithm grows a tree outward from a starting node,
always choosing the cheapest edge that connects a new node.
```

---

# 🔷 Why Priority Queue?

We need the **minimum edge** available at every step.

So we store:

```text
(weight, child, parent)
```

This helps us know:

* which edge is cheapest
* which node will be added
* from which parent it came

---

# 🔷 Meaning of `Pair`

In your code:

```text
wt     → edge weight
child  → next node to include
parent → node already in MST
```

So each heap entry represents a possible edge candidate.

---

# 🔷 Meaning of `visited[]`

```text
visited[node] = true
```

means the node is already included in MST.

This prevents cycles.

---

# 🔷 Meaning of MST Edge List

You also store:

```text
(parent, child)
```

for the final MST edge set.

This is useful if you want to print the MST structure, not only the sum.

---

# 🔄 Example Flow

Starting from node `0`:

* choose smallest edge from `0`
* maybe `0 → 2 (1)`
* then from visited set `{0,2}`, choose next smallest outgoing edge
* repeat until all nodes are included

---

# ⚠️ Important Notes

```text
Prim’s Algorithm works only for connected, weighted, undirected graphs
```

If the graph is disconnected, it will only build MST for one connected component.

---

# ❌ Common Mistakes

* ❌ Using Prim’s on directed graph
* ❌ Forgetting visited check
* ❌ Adding edges that form cycles
* ❌ Thinking the first popped edge is always accepted
* ❌ Confusing MST with shortest path tree

---

# ⚡ Complexity

* **Time Complexity:** O(E log E)
  or commonly written as O(E log V)

* **Space Complexity:** O(V + E)

---

## ❓ Why?

* each edge may be inserted into heap
* heap operations cost `log`

---

# 🎯 Interview Insight

👉
“I use Prim’s Algorithm to build an MST by expanding from a starting node. A min-heap stores candidate edges, and I always pick the smallest edge that connects a new unvisited node. Visited tracking avoids cycles.”

---

# 🔥 Key Insight

```text
Prim’s Algorithm = greedy edge picking + visited check + min-heap
```

---

# 🚀 Key Takeaways

* Builds MST greedily
* Always picks minimum edge
* Uses priority queue
* `visited[]` prevents cycles
* Stores `(weight, child, parent)` to reconstruct MST

---

# 🔥 Pattern Connection

* Greedy graph algorithm
* Minimum spanning tree
* Heap-based edge selection

---
