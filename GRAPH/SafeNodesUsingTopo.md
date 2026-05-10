# 🌐 Eventual Safe Nodes using Topological Sort (Kahn’s Algorithm)

---

## 📌 Problem

> Find all **eventual safe nodes** in a directed graph.

A node is **safe** if every path starting from it eventually ends at a **terminal node** and does **not** enter a cycle.

---

## 🧠 Definition

```text
Safe node = node from which no path can reach a cycle
```

---

## 🌲 Example Graph

```text
0 → 1 → 2 → 3 → 4 → 6 → 7
          ↓     ↘
          5       6

8 → 1
8 → 9 → 10
↑         |
|---------|
11 → 9
```

---

## ✅ Safe Nodes

```text
Nodes that eventually lead only to terminal nodes are safe
```

---

# 🔥 Core Idea

```text
Remove terminal nodes first, then keep removing nodes that become terminal.
```

This is exactly what **Kahn’s Algorithm** helps us do.

---

# ❓ Why Reverse the Graph?

In the original graph:

* safe nodes are hard to detect directly
* because we need to know who points to terminal nodes

So we reverse edges:

```text
u → v   becomes   v → u
```

Now:

* terminal nodes in original graph become starting points
* nodes that can only reach safe nodes can be processed step by step

---

# 🧠 Key Observation

In the **reversed graph**:

* nodes with indegree `0` are actually **terminal nodes** in the original graph
* processing them gradually marks more nodes as safe

---

# 🔷 Why Kahn’s Algorithm Works Here

Kahn’s Algorithm processes nodes with indegree `0`.

In this problem:

* start with terminal nodes
* remove their effect
* if another node becomes terminal, it is also safe

So safety propagates backward from terminal nodes.

---

# 🔁 Working Principle

## Step 1: Reverse all edges

Original:

```text
u → v
```

Reversed:

```text
v → u
```

---

## Step 2: Compute indegree in reversed graph

Nodes with indegree `0` in reversed graph are the starting safe nodes.

---

## Step 3: Push indegree 0 nodes into queue

These are the nodes that are safe right now.

---

## Step 4: BFS traversal

For every node removed from queue:

* mark it safe
* reduce indegree of its neighbors in reversed graph
* if a neighbor’s indegree becomes `0`, push it to queue

---

# 🎯 Intuition

```text
A node is safe only if all paths from it end safely.
```

By reversing edges, we start from terminal nodes and move backward to find all nodes that can only lead to terminal nodes.

---

# 🔄 Example Flow

Suppose a terminal node is found first.

* it is safe
* its predecessors may now also become safe
* this repeats until no more nodes can be added

Nodes that never get processed are part of or can reach a cycle.

---

# ⚠️ Important Note

```text
Nodes remaining unprocessed after Kahn’s BFS are NOT safe
```

They either:

* belong to a cycle
* or can reach a cycle

---

# ❌ Common Mistakes

* ❌ Checking only outdegree without reversing graph
* ❌ Confusing terminal node with safe node
* ❌ Forgetting that cycle nodes are unsafe
* ❌ Not processing all nodes

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V + E)

---

## ❓ Why O(V + E)?

* reverse graph construction takes `O(E)`
* Kahn’s BFS processes each node once and each edge once

---

# 🎯 Interview Insight

👉
“I reverse the graph and apply Kahn’s Algorithm. Terminal nodes become starting points, and any node that eventually leads only to terminal nodes gets marked safe.”

---

# 🔥 Key Insight

```text
Eventual safe nodes = nodes not involved in or leading to a cycle
```

---

# 🚀 Key Takeaways

* Reverse graph helps move from terminal nodes backward
* Kahn’s Algorithm finds safe nodes
* Safe nodes are exactly those processed by BFS
* Nodes not processed are unsafe

---

# 🔥 Pattern Connection

* Topological Sort
* Cycle Detection
* Directed Graph BFS
* Reverse graph thinking

---
