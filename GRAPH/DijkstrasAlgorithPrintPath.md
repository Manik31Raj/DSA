# 🚀 Dijkstra’s Algorithm: Shortest Path from Source to Destination

---

## 📌 Problem

> Given a weighted graph, find the **shortest path from a source node to a destination node**.

This version not only calculates the shortest distance but also reconstructs the **actual path**.

---

## ✅ Works For

```text
Weighted graphs with NON-NEGATIVE edge weights
```

---

## ❌ Does NOT Work For

```text
Graphs with negative edge weights
Graphs with negative cycles
```

---

# 🔥 Core Idea

```text
Use Dijkstra’s Algorithm to compute shortest distances
and store parent information to reconstruct the path.
```

---

# 🧠 Why Parent Array?

Whenever we find a shorter path to a node:

```text
parent[child] = currentNode
```

This stores from where we reached the node optimally.

Later we backtrack using this parent array.

---

# 🔷 Data Structures Used

---

## 1️⃣ Distance Array

```text
dist[node] = shortest known distance from source
```

---

## 2️⃣ Parent Array

```text
parent[node] = previous node in shortest path
```

Used to reconstruct the actual route.

---

## 3️⃣ Min Heap (Priority Queue)

Stores:

```text
(distance, node)
```

Smallest distance node is processed first.

---

# 🔁 Working Principle

---

## Step 1: Initialize

```text
dist[source] = 0
dist[others] = ∞
parent[source] = source
```

Push source into priority queue.

---

## Step 2: Extract Minimum Distance Node

Pop the node having the smallest tentative distance.

---

## Step 3: Relax Adjacent Edges

For every edge:

```text
curr → next (weight w)
```

If:

```text
dist[next] > dist[curr] + w
```

then update:

```text
dist[next] = dist[curr] + w
parent[next] = curr
```

---

## Step 4: Repeat Until Heap Becomes Empty

Eventually shortest distances for all reachable nodes are finalized.

---

# 🔄 Path Reconstruction

After Dijkstra completes:

Start from destination node and move backward using parent array.

---

## Example

Suppose:

```text
parent[4] = 2
parent[2] = 3
parent[3] = 0
parent[0] = 0
```

Backtracking gives:

```text
4 → 2 → 3 → 0
```

Reverse it:

```text
0 → 3 → 2 → 4
```

This becomes the shortest path.

---

# 🌲 Example Graph

```text
0 --2-- 1 --5-- 4
|      / \     /
1     4   5   1
|    /     \  /
3 --3------- 2
```

Source = `0`
Destination = `4`

---

## ✅ Shortest Path

```text
0 → 3 → 2 → 4
```

Total Cost:

```text
1 + 3 + 1 = 5
```

---

# 🧠 Important Optimization

Your code uses:

```java
if(dis > dist[curr]) continue;
```

This skips stale entries from the priority queue.

This is a standard optimized Dijkstra implementation.

---

# ⚠️ Important Notes

```text
Parent array is required for path reconstruction
```

Without it, only shortest distance can be obtained.

---

# ❌ Common Mistakes

* ❌ Forgetting to update parent array
* ❌ Forgetting to reverse the path
* ❌ Using Dijkstra on negative weighted graph
* ❌ Not handling unreachable destination
* ❌ Thinking priority queue automatically removes stale states

---

# ⚡ Complexity

* **Time Complexity:** O((V + E) log V)
* **Space Complexity:** O(V)

---

## ❓ Why?

* Heap operations take `log V`
* Every edge relaxation may insert into heap

---

# 🎯 Interview Insight

👉
“I use Dijkstra’s Algorithm with a priority queue to compute shortest distances. Alongside that, I maintain a parent array so that after all relaxations, I can reconstruct the actual shortest route by backtracking from destination to source.”

---

# 🔥 Key Insight

```text
Dijkstra + Parent Tracking = Shortest Path Reconstruction
```

---

# 🚀 Key Takeaways

* Dijkstra works for non-negative weighted graphs
* Priority queue helps process minimum distance first
* Parent array reconstructs actual shortest path
* Reverse path after backtracking

---

# 🔥 Pattern Connection

* Greedy shortest path
* Weighted graph traversal
* Parent tracking
* Path reconstruction

---
