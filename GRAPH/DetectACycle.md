# 🔄 Cycle Detection in Undirected Graph (BFS & DFS)

---

## 📌 Problem

> Detect whether an **undirected graph contains a cycle**.

---

# 📌 What is a Cycle?

```text id="cycle-def"
A cycle is a path where we reach the same node again
through a different route.
```

---

## 🌲 Example Graph

```id="cycle-graph"
1 ----- 2
|       |
|       5
|       |
3 ----- 6
|       |
4       7
```

---

## 🔁 Cycle Present

```text id="cycle-path"
1 → 2 → 5 → 7 → 6 → 3 → 1
```

👉 Starts and ends at same node

---

## ✅ Answer

```text id="answer"
Cycle Present = TRUE
```

---

# 🔥 Core Idea

```text id="core"
If we revisit a visited node that is NOT parent,
then cycle exists.
```

---

# 🧠 Why Parent Tracking?

---

## ❓ Important Observation

In undirected graph:

```text id="obs"
Every edge appears twice
```

👉 Example:

```text id="edge"
1 ↔ 2
```

When at node `2`, going back to `1` is NORMAL
(not a cycle)

---

## ⚠️ So condition becomes

```text id="condition"
Visited node AND node != parent
```

👉 Then only cycle exists

---

# 🔷 Approach 1: DFS

---

## 🧠 Idea

```text id="dfs-core"
Go deep recursively and track parent
```

---

## 🔁 Steps

1. Mark node visited
2. Traverse neighbors

```text id="dfs-steps"
If neighbor not visited:
   DFS(neighbor)

Else if neighbor != parent:
   Cycle found
```

---

## 🎯 Intuition

```text id="dfs-int"
Reaching already visited non-parent node means loop exists
```

---

# 🔷 DFS Recursive Flow

```text id="dfs-flow"
dfs(1,-1)
 → dfs(2,1)
   → dfs(5,2)
     → dfs(7,5)
       → dfs(6,7)
         → dfs(3,6)

Now 3 connects back to 1
1 already visited and not parent
→ Cycle detected
```

---

# 🔷 Approach 2: BFS

---

## 🧠 Idea

```text id="bfs-core"
Store (node,parent) in queue
```

---

## 📦 Queue Stores

```text id="queue"
(child, parent)
```

---

## 🔁 Steps

1. Push source with parent = -1
2. Traverse neighbors

```text id="bfs-steps"
If visited neighbor != parent
→ Cycle exists
```

---

## 🎯 Intuition

```text id="bfs-int"
Track from where node was reached
```

---

# ⚡ Complexity

| Method | Time     | Space |
| ------ | -------- | ----- |
| DFS    | O(V + E) | O(V)  |
| BFS    | O(V + E) | O(V)  |

---

## ❓ Why O(V + E)?

```text id="tc"
Each vertex visited once  
Each edge explored once
```

---

# ⚠️ Important Notes

```text id="note"
Works only for UNDIRECTED graph
```

---

# ❌ Common Mistakes

* ❌ Forgetting parent tracking
* ❌ Treating parent edge as cycle
* ❌ Missing disconnected components
* ❌ Not using visited array

---

# 🔄 BFS vs DFS

| Feature         | BFS      | DFS       |
| --------------- | -------- | --------- |
| Structure       | Queue    | Recursion |
| Parent Tracking | Explicit | Recursive |
| Implementation  | Medium   | Easier    |

---

# 🎯 Interview Insight

👉
“In undirected graphs, revisiting parent is normal. A cycle exists only when we reach an already visited node that is not the parent.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Visited neighbor ≠ cycle always
Parent edge must be ignored
```

---

# 🚀 Key Takeaways

* Parent tracking is essential
* DFS/BFS both work
* Handle disconnected graphs
* Cycle = revisiting non-parent node

---

# 🔥 Pattern Connection

* Graph traversal
* Connected components
* Similar → Detect cycle in directed graph

---
