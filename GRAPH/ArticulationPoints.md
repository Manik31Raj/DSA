# ✂️ Articulation Point in Graph

---

## 📌 Problem

> Find all **articulation points** in an undirected graph.

An articulation point is a node whose removal increases the number of connected components.

---

## 🧠 Definition

```text
Articulation Point = a node that breaks the graph into more pieces if removed
```

---

# 🔥 Core Idea

```text
Use DFS + discovery time + low time
```

A node becomes critical if one of its DFS children cannot reach an ancestor of that node.

---

# 🔷 What are `tin` and `low`?

---

## 1️⃣ `tin[node]`

```text
Time of insertion / discovery time of the node in DFS
```

This is the time when the node is first visited.

---

## 2️⃣ `low[node]`

```text
The smallest discovery time reachable from that node
```

This includes:

* itself
* its subtree
* any ancestor reachable through a back edge

---

# 🔥 Why Low Time Matters

If a child subtree cannot reach back to an ancestor of the current node, then the current node is an articulation point.

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
* if neighbor already visited → update `low[node]` using `tin[neighbor]`

---

## Step 3: After child returns

Update:

```text
low[node] = min(low[node], low[child])
```

Then check:

```text
if low[child] >= tin[node] and parent != -1
```

👉 current node is an articulation point.

---

# 🎯 Intuition

```text
tin = when I first saw this node
low = earliest ancestor I can still reach from here
```

If a child subtree cannot reach above the current node, then the current node is a cut point.

---

# 🌲 Special Root Case

For the DFS root:

```text
if root has more than 1 DFS child
```

then the root is an articulation point.

Why?

Because its children belong to separate DFS branches, so removing root disconnects them.

---

# 🔄 Why Parent is Skipped?

In an undirected graph, every edge appears twice.

So when DFS sees the parent again, that is normal and should not be treated as a back edge.

```text
if(x == parent) continue;
```

---

# 🌳 Example

```text
0 --- 1
|
2 --- 4 --- 6
 \         /
  \--- 5---/
```

If node `2` is removed, some nodes may become disconnected.
So `2` can be an articulation point.

---

# ⚠️ Important Notes

```text
Articulation points are defined in undirected graphs
```

For directed graphs, this logic is not used directly.

---

# ❌ Common Mistakes

* ❌ Forgetting to update low after DFS child returns
* ❌ Treating parent edge as a back edge
* ❌ Missing root special case
* ❌ Using `>` instead of `>=` for articulation condition
* ❌ Forgetting disconnected graph handling

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
“I use DFS with discovery time and low time. If a child subtree cannot reach an ancestor of the current node, then that current node is an articulation point. The root is special: if it has more than one DFS child, it is also an articulation point.”

---

# 🔥 Key Insight

```text
Articulation condition = low[child] >= tin[node]
```

---

# 🚀 Key Takeaways

* Articulation points break connectivity
* DFS + tin + low values detect them
* Root needs special handling
* Works only in undirected graphs

---

# 🔥 Pattern Connection

* DFS low-link technique
* Tarjan’s algorithm
* Bridge / cut-vertex problems

---

## ✅ Small Code Note

In this code:

* `tin[node] = low[node] = timer` marks discovery
* `low[node] = min(low[node], low[x])` after child DFS
* `low[node] = min(low[node], tin[x])` for back edges
* `if(low[x] >= tin[node] && parent!=-1)` marks a non-root articulation point
* `if(child > 1 && parent==-1)` marks the root as articulation point
