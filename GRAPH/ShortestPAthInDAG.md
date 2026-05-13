# 🧭 Shortest Path in DAG (Topological Sort + Relaxation)

---

## 📌 Problem

> Find the **shortest path from a source node to all other nodes** in a **Directed Acyclic Graph (DAG)**.

---

## 🔤 Graph Type

```text
Directed + Weighted + Acyclic
```

👉 This is important because the solution uses **Topological Sort**.

---

## 🧠 Key Idea

```text
Topological order ensures that when we process a node,
all nodes before it are already finalized.
```

So we can safely **relax edges once** in topological order.

---

# 🔷 Why Topological Sort?

If we process nodes in topological order:

* every edge goes from an earlier node to a later node
* so when a node is processed, its shortest distance is already known

That makes shortest path very efficient in DAG.

---

## 🌲 Example Weighted Graph

```text
6 → 4 (2)
4 → 0 (3)
0 → 1 (2)
1 → 3 (1)
6 → 5 (3)
5 → 4 (1)
4 → 2 (1)
2 → 3 (3)
```

---

## 🎯 Source

```text
src = 4
```

---

# 🔥 Core Idea

```text
1. Get topological order
2. Initialize dist[source] = 0
3. Process nodes in topo order
4. Relax all outgoing edges
```

---

# 🔁 Working Principle

---

## Step 1: Topological Sort

Use DFS to push nodes into a stack after exploring their neighbors.

👉 Pop stack to get topological order.

---

## Step 2: Initialize Distance Array

```text
dist[source] = 0
dist[others] = INF
```

Where `INF` means unreachable initially.

---

## Step 3: Relax Edges

For every node in topological order:

```text
if dist[curr] is known:
    for each edge curr → next with weight w:
        dist[next] = min(dist[next], dist[curr] + w)
```

---

# 🧠 Intuition

```text
Topo order = correct processing order
Relaxation = update best distance
```

Because the graph is acyclic, we never need to revisit a node after its turn is done.

---

# 🔄 Example Flow

Suppose source is `4`:

* `dist[4] = 0`
* then relax its neighbors:

  * `4 → 0 (3)` → `dist[0] = 3`
  * `4 → 2 (1)` → `dist[2] = 1`
* then process `0`, `2`, `1`, `3`, etc.

---

# 🔷 Why DFS for Topological Sort?

DFS pushes a node into stack **after** all its outgoing edges are explored.

So when we pop the stack:

* dependencies are already handled
* this gives valid order for relaxation

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

* DFS topological sort visits every node once
* every edge is relaxed once

---

# ⚠️ Important Notes

```text
This method works only for DAG
```

If there is a cycle, topological order is not valid, so this approach cannot be used directly.

---

# ❌ Common Mistakes

* ❌ Using this on a graph with cycle
* ❌ Forgetting to initialize unreachable nodes with INF
* ❌ Not checking if dist[curr] is INF before relaxing
* ❌ Doing relaxation before topological order

---

# 🎯 Interview Insight

👉
“I first compute a topological order of the DAG, then relax edges in that order. This gives the shortest path from the source in linear time.”

---

# 🔥 Key Insight

```text
Shortest path in DAG = Topological sort + edge relaxation
```

---

# 🚀 Key Takeaways

* Only works for DAG
* Topological order ensures safe processing
* Relax each edge once
* Faster than Dijkstra for DAG

---

# 🔥 Pattern Connection

* Topological sorting
* Weighted DAG shortest path
* Dependency-based processing

---
