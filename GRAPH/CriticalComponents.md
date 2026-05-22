# 🌉 Critical Connections / Bridges in Graph

---

## 📌 Problem

> Find all **critical connections** in an undirected graph.

A **critical connection** is an edge that, if removed, increases the number of connected components.

In simple words:

```text
Bridge = edge whose removal disconnects the graph
```

---

## 🧠 Core Idea

```text
Use DFS + discovery time + low time
```

If a node cannot reach an ancestor through any back edge, then the connecting edge is a bridge.

---

# 🔷 What are `tin` and `low`?

---

## 1️⃣ `tin[node]`

```text
Time of insertion / discovery time of node in DFS
```

This is the time when the node is first visited.

---

## 2️⃣ `low[node]`

```text
Lowest discovery time reachable from that node
```

This includes:

* the node itself
* its children
* any ancestor reachable through a back edge

---

# 🔥 Why Low Time Matters

If for an edge:

```text
node → child
```

we find:

```text
low[child] > tin[node]
```

then child’s subtree cannot reach node or any ancestor of node.

So that edge is a **bridge**.

---

# 🔁 Working Principle

---

## Step 1: DFS traversal

When a node is visited:

```text
tin[node] = low[node] = timer
```

Then timer is incremented.

---

## Step 2: Explore neighbors

For each neighbor:

* if neighbor is parent → ignore
* if neighbor not visited → DFS on it
* if neighbor already visited → update low using `tin[neighbor]`

---

## Step 3: After returning from child

Update:

```text
low[node] = min(low[node], low[child])
```

Then check bridge condition:

```text
if (low[child] > tin[node]) → bridge
```

---

# 🎯 Intuition

```text
tin = when I first saw this node
low = earliest ancestor I can still reach from here
```

If a subtree cannot reach back to an ancestor, then the edge leading to it is critical.

---

# 🌲 Example Thinking

Suppose:

```text
1 — 2 — 3
```

If edge `2 — 3` is removed, node `3` becomes disconnected.

So `2 — 3` is a bridge.

---

# 🔄 Why Parent is Skipped?

In undirected graphs, every edge appears in both directions.

So when DFS sees the parent again, that is normal and should not be treated as a back edge.

```text
if(x == parent) continue;
```

---

# ⚠️ Important Notes

```text
Bridge detection works only in undirected graphs
```

For directed graphs, the concept is different.

---

# ❌ Common Mistakes

* ❌ Forgetting to update low after child DFS
* ❌ Treating parent edge as back edge
* ❌ Using bridge logic in directed graph
* ❌ Confusing `tin` and `low`
* ❌ Missing disconnected graph handling

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

* each node is visited once
* each edge is processed once in DFS

---

# 🎯 Interview Insight

👉
“I use Tarjan-style DFS with discovery time and low time. If a child subtree cannot reach any ancestor of the current node, then the edge between them is a bridge.”

---

# 🔥 Key Insight

```text
Bridge condition = low[child] > tin[node]
```

---

# 🚀 Key Takeaways

* Bridges are critical edges
* DFS + tin + low values detect them
* Parent edge must be ignored
* Works in undirected graphs

---

# 🔥 Pattern Connection

* DFS low-link technique
* Tarjan’s algorithm
* Articulation / bridge problems

---

## ✅ Small Code Note

In this code:

* `tin[node] = low[node] = timer` marks discovery
* `low[node] = min(low[node], low[x])` after DFS child
* `low[node] = min(low[node], tin[x])` for back edge
* `if(low[x] > tin[node])` identifies a bridge
