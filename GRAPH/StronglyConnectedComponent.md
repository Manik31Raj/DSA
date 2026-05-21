# 🔁 Strongly Connected Components (Kosaraju’s Algorithm)

---

## 📌 Problem

> Find all **Strongly Connected Components (SCCs)** in a **directed graph**.

---

## 📌 Definition

```text
A strongly connected component is a group of vertices such that
every vertex can reach every other vertex in the same group.
```

---

## 🌲 Example Graph

```text
0 → 1 → 2
↑    ↓   ↓
└────  ← 3 → 4 → 5 → 6 → 7
             ↑         ↓   ↑
             └──────────┘   └──
```

---

## 🧠 Core Idea

```text
If a node can reach every other node in its group and also be reached back,
then all such nodes belong to the same SCC.
```

---

# 🔥 Why Kosaraju Works

Kosaraju uses **two DFS passes**:

1. First DFS to record finishing order
2. Reverse the graph
3. Second DFS in stack order to collect SCCs

---

# 🔷 Step 1: DFS on Original Graph

We perform DFS and push nodes into a stack **after** visiting all their neighbors.

```text
This gives nodes in decreasing finishing time order
```

That order is important because it helps us process SCCs correctly.

---

# 🔷 Step 2: Reverse the Graph

We reverse every directed edge:

```text
u → v  becomes  v → u
```

This turns the graph around while preserving SCC structure.

---

# 🔷 Step 3: DFS on Reversed Graph

Now pop nodes from the stack:

* if the node is not visited
* run DFS on the reversed graph
* all nodes reached in that DFS belong to one SCC

---

# 🎯 Intuition

```text
First DFS = decide processing order
Second DFS = extract strongly connected groups
```

---

# 🔄 Why Stack Order Matters

Nodes that finish later in the first DFS are likely the starting points of SCC traversal in the reversed graph.

That is why we must process nodes in **stack order**.

---

# 🌳 Example Thinking

Suppose we have:

```text
0 → 1 → 2 → 0
```

This forms one SCC because:

* 0 reaches 1
* 1 reaches 2
* 2 reaches 0

So all three are mutually reachable.

---

# ⚠️ Important Notes

```text
SCCs exist only in directed graphs
```

For undirected graphs, connected components are enough.

---

# ❌ Common Mistakes

* ❌ Forgetting to reverse the graph
* ❌ Using one DFS only
* ❌ Not using stack finishing order
* ❌ Treating SCC as normal connected component
* ❌ Using undirected graph logic

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V + E)

---

## ❓ Why O(V + E)?

* first DFS visits every vertex and edge once
* graph reversal takes O(E)
* second DFS visits every vertex and edge once again

---

# 🎯 Interview Insight

👉
“I use Kosaraju’s Algorithm: first DFS to store finishing order in a stack, then reverse the graph, and finally process nodes in stack order to extract each strongly connected component.”

---

# 🔥 Key Insight

```text
SCC = mutually reachable group in directed graph
```

---

# 🚀 Key Takeaways

* SCC is a directed graph concept
* Kosaraju uses two DFS passes
* Stack order is based on finishing time
* Reverse graph preserves SCCs

---

# 🔥 Pattern Connection

* Directed graph traversal
* DFS finishing order
* Graph reversal
* Component extraction

---

## ✅ Small Code Note

In this code:

* first `dfs(...)` fills the stack in finishing order
* `revAdj` stores the reversed graph
* second `dfs(...)` collects nodes of each SCC
* each `temp` list is one SCC

Also, your printed text should be:

```text
Strongly Connected Components (SCC) of Graph present
```

not `Stringly Connected Component`.
