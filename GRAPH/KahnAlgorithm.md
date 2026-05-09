# 🧭 Topological Sorting (Kahn’s Algorithm)

---

## 📌 Problem

> Find a linear ordering of vertices in a **Directed Acyclic Graph (DAG)** such that for every directed edge `u → v`,
> `u` appears before `v`.

---

## 🔤 Definition

```text
Topological sort is possible only in DAG
```

---

# ❓ Why Only DAG?

Suppose graph has a cycle:

```text
1 → 2 → 3 → 1
```

Then conditions become:

```text
1 before 2
2 before 3
3 before 1
```

👉 Which means:

```text
1 before 1 ❌
```

Impossible.

---

## 🧠 Intuition

```text
Cycle creates circular dependency
```

👉 No node can come first.

---

# 🔥 Kahn’s Algorithm (BFS Based)

```text
Uses indegree + queue
```

---

# 📌 What is Indegree?

```text
Indegree of a node =
number of incoming edges to that node
```

---

## 🌲 Example

```text
5 → 2
4 → 2
```

👉 Node `2` has:

```text
Indegree = 2
```

because two edges are entering it.

---

# 🔥 Core Idea

```text
A node with indegree 0 has no dependency
so it can appear first in ordering
```

---

# 🔷 Working Principle

---

## Step 1: Calculate indegree

For every edge:

```text
u → v
```

increase:

```text
indegree[v]++
```

---

## Step 2: Push all indegree 0 nodes into queue

These nodes:

* have no incoming edges
* can appear first

---

## Step 3: BFS Traversal

Remove node from queue:

```text
node = queue.poll()
```

Add it to topological order.

---

## Step 4: Remove its outgoing edges

For every neighbor:

```text
indegree[neighbor]--
```

If indegree becomes 0:

```text
push into queue
```

---

# 🌳 Intuition

```text
Removing a node removes its dependency effect
on other nodes
```

---

# 🔁 Example

Graph:

```text
5 → 0
5 → 2
4 → 0
4 → 1
2 → 3
3 → 1
```

---

## Initial Indegree

```text
0 → 2
1 → 2
2 → 1
3 → 1
4 → 0
5 → 0
```

---

## Queue Initially

```text
[4, 5]
```

because indegree = 0.

---

## Processing

```text
Take 4
Take 5
Take 2
Take 3
Take 1
Take 0
```

---

## Final Topological Order

```text
[4, 5, 2, 3, 1, 0]
```

---

# 🔥 Detecting Cycle Using Kahn’s Algorithm

```text
Kahn’s algorithm can also detect cycle in directed graph
```

---

## 🧠 Key Observation

In a DAG:

```text
At least one node will always have indegree 0
```

But in a cycle:

```text
Every node depends on another node
```

So:

```text
No node gets indegree 0
```

---

# 🔁 Cycle Detection Logic

After BFS:

```text
if(number of processed nodes != total nodes)
```

👉 cycle exists.

---

## In Your Code

```java
if (ind != adj.size()) {
    throw new IllegalStateException(
    "Topological sort not possible: graph has a cycle");
}
```

---

# ⚠️ Important Note

```text
Topological sorting itself only works for DAG
```

But:

```text
Kahn’s algorithm can be used to DETECT cycle
in directed graphs
```

---

# ❌ Common Mistakes

* ❌ Forgetting indegree calculation
* ❌ Using undirected graph
* ❌ Not pushing indegree 0 nodes initially
* ❌ Forgetting cycle check

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

* every vertex enters queue once
* every edge is processed once

---

# 🎯 Interview Insight

👉
“Kahn’s Algorithm uses BFS with indegree tracking. Nodes with indegree 0 are processed first. If all nodes are processed, graph is DAG; otherwise cycle exists.”

---

# 🔥 Key Insight

```text
Topological sort = dependency resolution
```

---

# 🚀 Key Takeaways

* Works only for DAG
* Uses BFS + indegree
* Nodes with indegree 0 are processed first
* Can also detect cycle in directed graph

---

# 🔥 Pattern Connection

* Course Schedule
* Dependency Resolution
* Build Systems
* Task Scheduling

---
