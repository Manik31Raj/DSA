# 🌐 Number of Provinces using DSU

---

## 📌 Problem

> Given a graph with connected groups, find the number of **provinces**.

A province is a group of nodes where every node is connected directly or indirectly.

---

## 🧠 Definition

```text
Province = one connected component
```

If two nodes belong to the same province, they are in the same DSU set.

---

## 🌲 Example

```text
1 --- 2 --- 3

4 --- 5

6 --- 7
```

---

## ✅ Answer

```text
Number of Provinces = 3
```

---

# 🔥 Core Idea

```text
Use Disjoint Set Union to merge all connected nodes,
then count how many final parents remain.
```

---

# 🔷 Why DSU?

DSU is perfect here because we need to know:

* which nodes are connected
* how many separate groups remain

Instead of running DFS/BFS repeatedly, we simply union all connected pairs.

---

# 🔁 Working Principle

---

## Step 1: Initialize DSU

Every node starts as its own parent.

```text
parent[i] = i
size[i] = 1
rank[i] = 0
```

---

## Step 2: Union all edges

For every connection:

```text
union(u, v)
```

This merges the two nodes into the same set.

---

## Step 3: Count ultimate parents

After all unions, every connected component has one root.

Count how many nodes are their own parent:

```text
if findUltimateParent(i) == i
    provinces++
```

---

# 🎯 Intuition

```text
Each connected component becomes one DSU tree.
The number of DSU roots = number of provinces.
```

---

# 🔄 Example Flow

For:

```text
(1,2), (2,3), (4,5), (6,7)
```

After unions:

```text
{1,2,3}
{4,5}
{6,7}
```

So the number of provinces is:

```text
3
```

---

# ⚠️ Important Notes

```text
This works when edges represent undirected connections
```

---

# ❌ Common Mistakes

* ❌ Counting edges instead of components
* ❌ Forgetting to count only ultimate parents
* ❌ Using DFS/BFS when DSU is enough for repeated unions
* ❌ Not handling 1-based indexing correctly

---

# ⚡ Complexity

* **Time Complexity:** O(E · α(V))
* **Space Complexity:** O(V)

Where `α(V)` is inverse Ackermann function, which is almost constant.

---

## ❓ Why so fast?

Because DSU uses:

* path compression
* union by size/rank

So operations become nearly O(1) amortized.

---

# 🎯 Interview Insight

👉
“I use DSU to merge all connected nodes. After processing every edge, each connected component has exactly one ultimate parent. Counting those roots gives the number of provinces.”

---

# 🔥 Key Insight

```text
Number of Provinces = Number of DSU roots after all unions
```

---

# 🚀 Key Takeaways

* Province = connected component
* DSU merges connected nodes
* Count unique roots at the end
* Very efficient for connectivity problems

---

# 🔥 Pattern Connection

* Connected components
* Graph union problems
* DSU / Union-Find usage

---

## ✅ Small Code Note

In this code:

* `unionBySize(edges[i][0], edges[i][1])` merges connected nodes
* `findUltimateParent(i) == i` checks whether `i` is a root
* each root corresponds to one province
