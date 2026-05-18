# 🌐 Floyd-Warshall Algorithm

---

## 📌 Problem

> Find the **shortest distance between every pair of vertices** in a weighted graph.

---

## ✅ Works For

```text
Directed or undirected weighted graph
Can include negative edge weights
```

---

## ❌ Does NOT Work For

```text
Graphs with negative cycles for shortest-path answers
```

Because distances can keep decreasing forever.

---

# 🔥 Core Idea

```text
Try every node as an intermediate node
and update shortest paths through that node
```

---

# 🧠 Why Floyd-Warshall?

This algorithm is used when we want:

* all-pairs shortest path
* not just source to destination
* a matrix-based dynamic programming approach

---

# 🔷 Graph Representation

Floyd-Warshall uses an **adjacency matrix**.

```text
cost[u][v] = edge weight from u to v
```

If no direct edge exists:

```text
cost[u][v] = INF
```

And:

```text
cost[i][i] = 0
```

---

# 🔁 Working Principle

---

## Step 1: Initialize matrix

* fill all cells with `INF`
* set diagonal to `0`
* insert given edges

---

## Step 2: Choose an intermediate node `i`

For every pair `(j, k)`:

```text
if cost[j][i] + cost[i][k] < cost[j][k]
    update cost[j][k]
```

This means going through `i` gives a shorter path.

---

## Step 3: Repeat for all intermediate nodes

Try every node as a possible middle point.

After all iterations, matrix contains shortest distances between every pair.

---

# 🧠 Intuition

```text
If a route j → i → k is cheaper than direct j → k,
then use the intermediate node i.
```

So each iteration improves the matrix by allowing one more possible middle node.

---

# 🔄 Example Thinking

Suppose:

```text
0 → 1 = 2
1 → 2 = 3
0 → 2 = 10
```

Then via node `1`:

```text
0 → 1 → 2 = 2 + 3 = 5
```

So update:

```text
0 → 2 = 5
```

---

# ⚠️ Important Notes

```text
Floyd-Warshall is all-pairs shortest path
```

This is different from Dijkstra/Bellman-Ford which usually compute from one source.

---

# ❗ Negative Cycle Detection

After the algorithm, if any diagonal entry becomes negative:

```text
cost[i][i] < 0
```

then a **negative cycle exists**.

---

## Why?

Because a node can reach itself with negative total cost, meaning the distance can keep decreasing.

---

# ❌ Common Mistakes

* ❌ Forgetting to initialize diagonal to 0
* ❌ Using Floyd-Warshall on adjacency list directly
* ❌ Not checking `INF` before addition
* ❌ Forgetting negative cycle detection
* ❌ Thinking this is a single-source algorithm

---

# ⚡ Complexity

* **Time Complexity:** O(V³)
* **Space Complexity:** O(V²)

---

## ❓ Why?

There are 3 nested loops:

* intermediate node
* start node
* end node

So total is cubic.

---

# 🎯 Interview Insight

👉
“I use Floyd-Warshall when I need shortest paths between every pair of nodes. It works by trying every node as an intermediate and updating the distance matrix. If any diagonal becomes negative, that indicates a negative cycle.”

---

# 🔥 Key Insight

```text
Floyd-Warshall = all-pairs shortest path via dynamic programming
```

---

# 🚀 Key Takeaways

* All-pairs shortest path
* Matrix-based DP
* Works with negative edges
* Negative cycle detected using diagonal values

---

# 🔥 Pattern Connection

* Dynamic programming on graphs
* All-pairs shortest path
* Matrix relaxation

---
