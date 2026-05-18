# 🚦 Bellman-Ford Algorithm

---

## 📌 Problem

> Find the **shortest path from a source node to all other nodes** in a weighted graph.

This algorithm also detects whether a **negative cycle** exists.

---

## ✅ Works For

```text
Directed or undirected weighted graph
Can contain negative edge weights
```

---

## ❌ Does NOT Work For

```text
Graphs with negative cycles for shortest-path answers
```

Because in a negative cycle, distance can keep decreasing forever.

---

# 🔥 Core Idea

```text
Relax all edges repeatedly
If shortest distances still improve after V-1 rounds,
then a negative cycle exists
```

---

# 🧠 Why Bellman-Ford?

Dijkstra fails when there are negative weights.

Bellman-Ford works because it does **not** assume that the best distance is finalized early.

Instead, it keeps improving distances by relaxing edges multiple times.

---

# 🔷 What is Relaxation?

For an edge:

```text
u → v with weight w
```

If:

```text
dist[u] + w < dist[v]
```

then update:

```text
dist[v] = dist[u] + w
```

This means we found a better path to `v`.

---

# 🔁 Working Principle

---

## Step 1: Initialize

```text
dist[source] = 0
dist[others] = INF
```

---

## Step 2: Repeat V-1 times

For every edge `(u, v, w)`:

* if `dist[u]` is known
* and going through `u` gives a smaller distance to `v`
* then update `dist[v]`

---

## Step 3: Check for negative cycle

Do one more pass over all edges.

If any distance can still be improved:

```text
Negative cycle exists
```

---

# 🎯 Why V-1 Rounds?

A shortest path without cycles can use at most:

```text
V-1 edges
```

So after `V-1` relaxation rounds, all shortest paths should be settled.

If improvement still happens after that, it means a cycle is helping reduce the cost.

---

# 🌲 Example Edges

```text
0 → 1 (5)
1 → 2 (-2)
1 → 5 (-3)
5 → 3 (1)
3 → 2 (6)
3 → 4 (-2)
2 → 4 (3)
```

---

# 🧠 Intuition

```text
Bellman-Ford tries every edge again and again,
slowly propagating the best distances through the graph
```

So unlike Dijkstra, it does not need all weights to be non-negative.

---

# 🔄 Example Flow

Starting from source `0`:

* first round updates direct neighbors
* second round updates nodes reachable in 2 edges
* third round updates longer paths
* after `V-1` rounds, shortest paths are finalized

---

# ❗ Negative Cycle Detection

Suppose we still find:

```text
dist[u] + w < dist[v]
```

on the extra pass.

Then:

```text
there is a negative cycle reachable from source
```

In your code, this is returned as `-1`.

---

# ⚠️ Important Notes

```text
Bellman-Ford can handle negative weights
but not meaningful shortest paths when a reachable negative cycle exists
```

---

# ❌ Common Mistakes

* ❌ Using Dijkstra for negative weights
* ❌ Forgetting the final negative-cycle check
* ❌ Not initializing distances to INF
* ❌ Missing the `dist[u] != INF` guard
* ❌ Assuming one pass is enough

---

# ⚡ Complexity

* **Time Complexity:** O(V × E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V × E)?

* We relax all edges `V-1` times
* Each round processes all `E` edges

---

# 🎯 Interview Insight

👉
“I use Bellman-Ford when the graph may contain negative weights. I relax all edges `V-1` times to compute shortest distances, and then do one extra pass to detect whether a negative cycle exists.”

---

# 🔥 Key Insight

```text
Bellman-Ford = repeated relaxation + negative cycle detection
```

---

# 🚀 Key Takeaways

* Handles negative edge weights
* Uses edge relaxation repeatedly
* Detects negative cycles
* Slower than Dijkstra but more general

---

# 🔥 Pattern Connection

* Shortest path with negative weights
* Relaxation-based algorithms
* Negative cycle detection

---
