# 🚀 Dijkstra’s Algorithm Using TreeSet

---

## 📌 Problem

> Find the **shortest path from a source node to all other nodes** in a weighted graph.

---

## ✅ Works For

```text
Weighted graph with NON-NEGATIVE edge weights
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
Always pick the node with the smallest tentative distance,
then relax its edges.
```

---

# 🔷 Why TreeSet?

`TreeSet` keeps elements in **sorted order**.

So the node with the **minimum distance** is always available at the beginning.

---

## 🧠 Why not just PriorityQueue?

Both work.

### PriorityQueue

* simpler
* may contain stale entries

### TreeSet

* keeps sorted order
* lets us remove and reinsert updated distances more cleanly

---

# 🔷 TreeSet Ordering

Your `compareTo()` does:

```text
1. smaller distance first
2. if distance same, smaller node id first
```

This is important because `TreeSet` does not allow duplicate “equal” items.

---

## 🔁 Why tie-break by node?

If two nodes have same distance:

```text
compare only by distance → TreeSet may treat them as same
```

So you also compare node id to make ordering stable.

---

# 🔷 Working Principle

---

## Step 1: Initialize

```text
dist[source] = 0
dist[others] = INF
```

Add:

```text
(0, source)
```

into `TreeSet`.

---

## Step 2: Pick smallest distance node

Use:

```text
pollFirst()
```

This gives the node with minimum current distance.

---

## Step 3: Relax all neighbors

For each edge:

```text
curr → neighbor (weight w)
```

If:

```text
dist[neighbor] > dist[curr] + w
```

then update it.

---

## Step 4: Insert updated pair

When a better distance is found:

* insert new `(distance, node)` into TreeSet

---

# 🧠 Important Observation

If a node already had an old distance in the set, your code uses:

```text
if(dis > dist[curr]) continue;
```

This skips stale entries.

That is the standard cleanup trick.

---

# 🎯 Intuition

```text
TreeSet always gives the next closest node
```

So Dijkstra becomes:

* pick smallest distance
* relax edges
* repeat

---

# 🔄 Example Flow

Suppose source is `0`:

```text
dist[0] = 0
```

Then explore neighbors:

* update `1`
* update `2`

Next smallest node is processed, and so on.

This gradually builds shortest distances for all nodes.

---

# ⚠️ Important Notes

```text
TreeSet is ordered, so it behaves like a sorted min-structure
```

But Dijkstra still requires **non-negative weights**.

---

# ❌ Common Mistakes

* ❌ Using Dijkstra with negative edges
* ❌ Forgetting stale-state check
* ❌ Not handling equal distances in compareTo
* ❌ Thinking TreeSet alone removes need for relaxations

---

# ⚡ Complexity

* **Time Complexity:** O((V + E) log V)
* **Space Complexity:** O(V)

---

## ❓ Why?

* each insertion/removal in TreeSet costs `log V`
* each edge relaxation may cause an update

---

# 🎯 Interview Insight

👉
“I use TreeSet to always extract the minimum-distance node in sorted order. This is equivalent to a priority queue approach, but the set structure also supports ordered management of distances.”

---

# 🔥 Key Insight

```text
Dijkstra = greedy shortest path + ordered set + relaxation
```

---

# 🚀 Key Takeaways

* TreeSet keeps nodes sorted by distance
* `compareTo()` must handle ties properly
* Stale entries must be skipped
* Works only for non-negative weighted graphs

---

# 🔥 Pattern Connection

* Shortest path in weighted graphs
* Greedy + ordered data structure
* Relaxation-based algorithms

---
