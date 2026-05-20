# 🧩 Disjoint Set Union (DSU) / Union Find

---

## 📌 Problem

> Maintain a collection of **disjoint groups** and support:

* finding which group a node belongs to
* merging two groups

---

## 🔤 Definition

```text
Disjoint Set = a data structure that keeps track of connected components
```

Each node belongs to exactly one set.

---

# 🧠 Core Idea

```text
Each set is represented by one leader called the Ultimate Parent
```

So every node points upward until it reaches the root of its set.

---

# 🔷 What DSU Helps With

DSU is used in problems like:

* connected components
* cycle detection
* Kruskal’s MST
* dynamic connectivity

---

# 🔁 Main Operations

---

## 1️⃣ Find Ultimate Parent

```text
find(node) -> returns the representative of the set
```

If a node is not its own parent, keep moving upward until the root is found.

---

## 2️⃣ Union

```text
union(u, v) -> merge the sets containing u and v
```

---

# 🔷 Why Path Compression?

When we call `find`, we directly connect nodes to the root.

That makes future queries much faster.

```text
Before:
node → parent → grandparent → root

After path compression:
node → root
```

---

# 🔷 Why Union by Rank?

```text
Attach the smaller-height tree under the bigger-height tree
```

This keeps the tree shallow.

---

# 🔷 Why Union by Size?

```text
Attach the smaller set under the larger set
```

This also keeps trees balanced.

---

# 📦 Arrays Used

---

## Parent

```text
parent[node] = immediate parent of node
```

For root nodes:

```text
parent[root] = root
```

---

## Rank

```text
rank[node] = approximate tree height
```

Used in union by rank.

---

## Size

```text
size[node] = number of nodes in that set
```

Used in union by size.

---

# 🔁 Working Principle

---

## Initialization

Every node starts in its own set:

```text
parent[i] = i
rank[i] = 0
size[i] = 1
```

---

## Find Operation

```text
if node == parent[node]
    return node
else
    recurse on parent[node]
```

Then compress the path while returning.

---

## Union by Rank

1. Find ultimate parents of both nodes
2. If same, do nothing
3. Attach smaller rank tree under larger rank tree
4. If ranks are equal, choose one root and increase its rank

---

## Union by Size

1. Find ultimate parents of both nodes
2. If same, do nothing
3. Attach smaller size tree under larger size tree
4. Update size of new root

---

# 🌲 Example

Suppose edges are:

```text
(1,2), (2,3), (4,5), (6,7), (5,6), (3,7)
```

Then DSU will gradually merge:

```text
{1,2,3}
{4,5,6,7}
```

and finally all connected through the last union.

---

# 🎯 Intuition

```text
DSU is like grouping people into clubs
Find tells which club a person belongs to
Union merges two clubs
```

---

# ⚡ Complexity

With path compression + union by rank/size:

* **Time Complexity:** nearly O(1) amortized
* **More precisely:** O(α(N))
* **Space Complexity:** O(N)

---

## ❓ Why so fast?

Because trees stay very shallow due to:

* path compression
* balanced union

---

# ⚠️ Important Notes

```text
Union by Rank and Union by Size are both valid optimizations
```

You usually use **either one**, not both together in the same implementation.

---

# ❌ Common Mistakes

* ❌ Forgetting path compression
* ❌ Updating rank/size on the wrong root
* ❌ Not checking if both nodes already share the same parent
* ❌ Confusing rank with size
* ❌ Using DSU without understanding 1-based indexing

---

# 🎯 Interview Insight

👉
“I use DSU to maintain connected components efficiently. `find` gives the ultimate parent, and `union` merges two sets using either rank or size optimization. Path compression makes future finds almost constant time.”

---

# 🔥 Key Insight

```text
DSU = find + union + path compression + balancing
```

---

# 🚀 Key Takeaways

* Tracks connected components
* `find` returns representative parent
* `union` merges sets
* Path compression speeds up queries
* Union by rank/size keeps trees balanced

---

# 🔥 Pattern Connection

* Graph connectivity
* Kruskal’s MST
* Cycle detection
* Component merging problems

---

## ✅ Small Code Note

In This code:

* `findUltimateParent()` uses **path compression**
* `unionByRank()` uses **rank balancing**
* `unionBySize()` uses **size balancing**

That is exactly the standard DSU setup.
