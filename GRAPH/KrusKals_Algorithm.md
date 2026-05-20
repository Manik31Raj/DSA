# 🌳 Kruskal’s Algorithm for Minimum Spanning Tree (MST)

---

## 📌 Problem

> Given a **weighted undirected graph**, find a **Minimum Spanning Tree (MST)**.

An MST:

* connects all vertices
* has no cycle
* has minimum total weight

---

## 🌲 Example Graph

```text
5 --9-- 4
5 --4-- 1
1 --1-- 4
4 --5-- 3
4 --3-- 2
1 --2-- 2
2 --3-- 3
3 --8-- 6
2 --7-- 6
```

---

## 🧠 Core Idea

```text
Pick the smallest edges first,
but only if they do NOT form a cycle
```

That is exactly what Kruskal’s Algorithm does.

---

# 🔷 Why DSU?

We need to know quickly:

```text
Do these two nodes already belong to the same component?
```

If yes, adding the edge will create a cycle.

So we use **Disjoint Set Union (DSU)** to check connectivity efficiently.

---

# 🔁 Working Principle

---

## Step 1: Sort edges by weight

Edges are sorted in ascending order of weight.

---

## Step 2: Process edges one by one

For each edge `(u, v, w)`:

* check if `u` and `v` have different ultimate parents
* if yes → include edge in MST
* if no → skip it, because it forms a cycle

---

## Step 3: Union the components

If the edge is accepted:

* add its weight to MST sum
* merge the two sets using DSU

---

## Step 4: Stop early

Once MST has:

```text
V - 1 edges
```

we can stop.

Because a tree with `V` vertices always has `V - 1` edges.

---

# 🎯 Intuition

```text
Kruskal = greedy edge picking + cycle avoidance
```

It keeps choosing the cheapest safe edge.

---

# 🔷 Why Sorting Helps

If we always consider smaller edges first:

* we try to keep total weight minimum
* DSU ensures we do not create cycles

So the combination of:

* sorting
* DSU

gives the MST.

---

# 🔷 Meaning of DSU in Kruskal

DSU stores connected components.

If two nodes have the same ultimate parent:

```text
they are already connected
```

So adding the edge would create a cycle.

---

# 🔄 Example Flow

Sorted edges:

```text
1 --4-- 5
1 --1-- 4
1 --2-- 2
2 --3-- 4
2 --3-- 3
...
```

Kruskal checks each edge:

* if safe, add it
* if cycle forms, skip it

This continues until MST is complete.

---

# ⚠️ Important Notes

```text
Kruskal works on weighted UNDIRECTED graphs
```

It is especially useful when the graph is sparse.

---

# ❌ Common Mistakes

* ❌ Not sorting edges first
* ❌ Forgetting to use DSU
* ❌ Adding cycle-forming edges
* ❌ Using Kruskal on directed graph
* ❌ Not stopping after V-1 edges

---

# ⚡ Complexity

* **Time Complexity:** O(E log E)
* **Space Complexity:** O(V)

---

## ❓ Why O(E log E)?

* sorting edges takes `O(E log E)`
* DSU operations are almost constant time

---

# 🎯 Interview Insight

👉
“I sort all edges by weight and process them in increasing order. For each edge, I use DSU to check whether the two endpoints are already connected. If not, I add the edge to MST and merge the sets.”

---

# 🔥 Key Insight

```text
Kruskal = sort edges + DSU + cycle check
```

---

# 🚀 Key Takeaways

* Greedy MST algorithm
* Picks smallest safe edge
* DSU avoids cycles
* Stops at V-1 edges

---

# 🔥 Pattern Connection

* Minimum spanning tree
* Greedy + DSU
* Cycle detection in graphs

---

## ✅ Small Code Note

In this code:

* `Arrays.sort(edges, Comparator.comparingInt(a -> a[2]))` sorts edges by weight
* `findUltimateParent()` checks connectivity
* `unionByRank()` merges components
* `MST.size() == V - 1` stops when MST is complete
