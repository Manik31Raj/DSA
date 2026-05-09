# 🌐 Eventual Safe Nodes

---

## 📌 Problem

> Find all **safe nodes** in a directed graph.

---

## 📌 Definition

```text
A node is safe if every possible path starting from that node
eventually ends at a terminal node (node with no outgoing edge)
and does NOT enter a cycle.
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
Nodes that do not lead to any cycle are safe
```

---

# 🔥 Core Idea

```text
A node is safe if it is NOT part of a cycle
and does NOT lead to a cycle
```

---

# 🧠 Key Observation

```text
If a node can reach a cycle by any path, it is NOT safe.
If all paths from a node end without entering a cycle, it is safe.
```

---

# 🔷 Why DFS + pathVisited?

This problem is very similar to **cycle detection in directed graph**.

---

## 1️⃣ `visited[]`

```text
Marks whether a node has already been processed
```

---

## 2️⃣ `pathVisited[]`

```text
Marks whether a node is currently in the DFS recursion path
```

👉 If we find a neighbor already in `pathVisited`, then we found a cycle.

---

## 3️⃣ `safe[]`

```text
Marks whether a node is eventually safe or not
```

---

# 🔁 Working Principle

---

## Step 1: Start DFS

For each unvisited node:

* mark it `visited`
* mark it `pathVisited`
* assume it is unsafe for now

---

## Step 2: Explore neighbors

For every outgoing edge:

* if neighbor is unvisited → DFS on it
* if neighbor is already `pathVisited` → cycle found
* if any neighbor leads to a cycle → current node is unsafe

---

## Step 3: Backtrack

If no cycle is found from current node:

* remove it from `pathVisited`
* mark it as `safe`

---

# 🎯 Intuition

```text
safe node = node that never reaches a cycle
unsafe node = node that can reach a cycle
```

---

# 🔄 Example Understanding

## Cycle part

```text
8 → 9 → 10 → 8
```

👉 All of these are unsafe because they are in a cycle.

---

## Safe part

```text
0 → 1 → 2 → 3 → 4 → 6 → 7
```

👉 These nodes are safe if they do not lead into the `8-9-10` cycle.

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

* each node is visited once
* each directed edge is processed once

---

# ⚠️ Important Notes

```text
pathVisited must be reset to false while backtracking
```

👉 Otherwise, nodes from previous DFS paths may incorrectly look like part of the current cycle.

---

# ❌ Common Mistakes

* ❌ Confusing safe nodes with terminal nodes only
* ❌ Forgetting `pathVisited[node] = false`
* ❌ Marking a node safe before confirming no cycle
* ❌ Not exploring all nodes in disconnected graph

---

# 🎯 Interview Insight

👉
“I use DFS with `visited[]` and `pathVisited[]` to detect cycles. A node is marked safe only when all paths from it are confirmed not to enter any cycle.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text
Safe node = node that cannot reach a cycle
```

---

# 🚀 Key Takeaways

* Safe nodes are not part of cycles
* `pathVisited` helps detect cycles in current DFS path
* `safe[]` stores final answer
* Works for directed graphs only

---

# 🔥 Pattern Connection

* Directed cycle detection
* DFS recursion stack
* Topological sort idea

---
