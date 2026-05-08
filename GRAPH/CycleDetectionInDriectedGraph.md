# 🔄 Cycle Detection in Directed Graph

---

## 📌 Problem

> Detect whether a **directed graph** contains a cycle.

---

## 📌 Definition

```text
A cycle in a directed graph exists if we can start from a node
and come back to the same node by following directed edges.
```

---

## 🌲 Example Graph

```text
1 → 2 → 3 → 4 → 5 → 6
          ↓     ↑           (Not a cycle as not reaching back to 3 (or same path))
          7 →---|
```

Another cycle example:

```text
8 → 9 → 10
↑         |
|---------|
```

---

## 🔥 Core Idea

```text
If during DFS we revisit a node that is already present in the
current recursion path, then a cycle exists.
```

---

## 🧠 Why Two Arrays?

### 1️⃣ `visited[]`

```text
Marks whether a node has been visited at least once
```

### 2️⃣ `pathVisited[]`

```text
Marks whether a node is currently in the recursion stack/path
```

👉 This is the key difference.

---

## ❓ Why `pathVisited` is needed?

In a directed graph, seeing a visited node does **not always** mean cycle.

Example:

* Node `x` may have already been fully processed earlier
* That is **not** a cycle

But if we find a node that is still in the **current DFS path**, then:

```text
Back edge found → cycle present
```

---

# 🔷 Working Principle

---

## 🔁 DFS Logic

For every node:

1. Mark it as `visited`
2. Mark it as `pathVisited`
3. Visit all outgoing neighbors

### Cases:

* If neighbor is not visited → DFS on it
* If neighbor is already `pathVisited` → cycle found
* After finishing current node, remove it from `pathVisited`

---

## 🎯 Intuition

```text
visited[]  → "Have I ever seen this node?"
pathVisited[] → "Is this node currently in my DFS path?"
```

---

# 🔄 Example Flow

Suppose we start from `1`:

```text
1 → 2 → 3 → 4 → 5 → 6
          ↑         |
          |---------|
```

When DFS reaches `5 → 6 → 8 → 9 → 10 → 8`:

* `8` is already in current DFS path
* so we found a cycle

---

# 🔷 Important Observation

```text
In directed graph, a cycle is detected using back edge
```

A **back edge** means:

```text
current node → node already in recursion path
```

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

* Every vertex is visited once
* Every directed edge is explored once

---

# ⚠️ Important Notes

```text
pathVisited must be reset (false) while backtracking
```

Otherwise, nodes from old paths will incorrectly cause cycle detection.

---

# ❌ Common Mistakes

* ❌ Using only `visited[]`
* ❌ Forgetting to reset `pathVisited[node] = false`
* ❌ Treating every visited node as cycle
* ❌ Not handling disconnected graph components

---

# 🎯 Interview Insight

👉
“In a directed graph, I use DFS with two arrays: `visited[]` to mark processed nodes and `pathVisited[]` to track the current recursion stack. If I find an edge to a node already in the current path, that indicates a cycle.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text
Directed cycle detection = DFS + visited + pathVisited
```

---

# 🚀 Key Takeaways

* `visited[]` alone is not enough
* `pathVisited[]` tracks recursion stack
* Back edge means cycle
* Works for disconnected directed graphs too

---

# 🔥 Pattern Connection

* Topological sort
* Directed graph DFS
* Recursion stack detection

---
