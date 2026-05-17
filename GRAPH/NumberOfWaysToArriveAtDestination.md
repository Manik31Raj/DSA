# 🚗 Number of Ways to Arrive at Destination

---

## 📌 Problem

> Given a weighted graph, find the **number of shortest paths** from a source node to a destination node.

---

## 🎯 Goal

```text
Find how many different paths give the minimum distance
from source to destination.
```

---

# 🔥 Core Idea

```text
Use Dijkstra to find shortest distances,
and at the same time count how many ways each shortest distance can be achieved.
```

---

## 🧠 Key Observation

For every node, we maintain:

* `dist[node]` → shortest distance from source
* `ways[node]` → number of shortest paths to reach that node

---

# 🔷 Why Dijkstra?

This is a **weighted graph shortest path** problem.

So we cannot use plain BFS.

We need Dijkstra because:

* edges have weights
* we must process smaller distances first
* shortest distance must be finalized before counting paths correctly

---

# 🔁 Working Principle

---

## Step 1: Initialize

```text
dist[source] = 0
ways[source] = 1
```

All other distances:

```text
INF
```

All other ways:

```text
0
```

---

## Step 2: Use Priority Queue

Store:

```text
(distance, node)
```

The node with the smallest distance is processed first.

---

## Step 3: Relax Edges

For every edge:

```text
curr → next (weight w)
```

Compute:

```text
newDist = dist[curr] + w
```

Then there are 3 cases:

---

### Case 1: New distance is smaller

```text
newDist < dist[next]
```

Then:

* update `dist[next]`
* replace `ways[next] = ways[curr]`

Because we found a **new better shortest path**.

---

### Case 2: New distance is equal

```text
newDist == dist[next]
```

Then:

* add number of ways

```text
ways[next] = ways[next] + ways[curr]
```

Because we found **another shortest path of the same minimum cost**.

---

### Case 3: New distance is larger

Ignore it.

---

# 🎯 Intuition

```text
Shortest distance tells us the best cost,
ways[] tells us how many such best routes exist.
```

So we are doing:

* **shortest path computation**
* **path counting together**

---

# 🔄 Example Thinking

Suppose a node `X` can be reached by:

* Path A with cost `10`
* Path B with cost `10`
* Path C with cost `12`

Then:

* best distance = `10`
* number of ways = ways from Path A + ways from Path B
* Path C is ignored

---

# ⚠️ Important Notes

```text
This works only because we are counting shortest paths
while running Dijkstra
```

If a node is reached later with the same minimum distance, we must add the counts.

---

# 🔷 Why Mod?

```text
ways can become very large
```

So we use:

```text
mod = 1e9 + 7
```

to avoid overflow.

---

# ❌ Common Mistakes

* ❌ Using BFS on weighted graph
* ❌ Forgetting to add ways when distances are equal
* ❌ Not updating ways correctly when a shorter path is found
* ❌ Forgetting modulo
* ❌ Ignoring stale heap entries

---

# ⚡ Complexity

* **Time Complexity:** O((V + E) log V)
* **Space Complexity:** O(V)

---

## ❓ Why?

* priority queue operations take `log V`
* each relaxation may push a new state

---

# 🎯 Interview Insight

👉
“I use Dijkstra to compute the shortest distance to every node, and maintain a ways array to count how many shortest paths reach that node. When a shorter distance is found, I replace the count; when an equal shortest distance is found, I add the count.”

---

# 🔥 Key Insight

```text
Shortest path count = Dijkstra + distance array + ways array
```

---

# 🚀 Key Takeaways

* Dijkstra gives shortest distances
* `ways[]` counts shortest paths
* Equal distance means add counts
* Use modulo for large answers

---

# 🔥 Pattern Connection

* Weighted shortest path
* Path counting
* Dijkstra with extra state

---
