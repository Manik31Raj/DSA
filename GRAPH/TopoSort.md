# 🧭 Topological Sorting

---

## 📌 Problem

> Find a linear ordering of vertices in a **Directed Acyclic Graph (DAG)** such that for every directed edge `u → v`,
> `u` appears before `v`.

---

## 🔤 Definition

```text
Topological sort is possible only in a DAG
```

👉 If the graph has a cycle, topological sorting is **not possible**.

---

# ❓ Why Only DAG?

Suppose graph has a cycle:

```text
1 → 2 → 3 → 1
```

Then conditions become:

```text
1 before 2
2 before 3
3 before 1
```

👉 Which means:

```text
1 before 1 ❌
```

Impossible.

---

## 🧠 Intuition

```text
Cycle creates circular dependency
```

👉 No node can come first.

---

## 🌲 Example Graph

```text id="dag"
5 → 0
5 → 2
4 → 0
4 → 1
2 → 3
3 → 1
```

---

## 🎯 One Valid Topological Order

```text id="order"
[4, 5, 2, 3, 1, 0]
```

👉 There can be **more than one valid order**.

---

# 🔥 Core Idea

```text
A node must be placed in the answer only after all nodes
reachable from it are already processed
```

---

## 🧠 Why DFS Works?

DFS goes deep first.
So a node is pushed into the stack **only after** all its children are done.

```text id="dfs-idea"
Visit all neighbors → then push current node
```

---

# 🔷 Working Principle

---

## Step 1: DFS traversal

For each unvisited node:

* mark it visited
* visit all its outgoing neighbors recursively

---

## Step 2: Push on completion

After all neighbors of a node are processed:

```text id="push"
push node into stack
```

👉 This is called **finishing time** / **postorder push**

---

## Step 3: Reverse the stack

When DFS finishes:

* pop nodes from stack
* that gives topological order

---

# 🌳 Intuition

```text
If u → v,
then v must finish first,
so v gets pushed before u.
```

That is why the stack automatically stores nodes in reverse topological order.

---

## 🔄 Visual Thinking

```text
u → v

DFS reaches v first
v is pushed first
u is pushed later

Stack top → u
Then pop gives u before v
```

---

# 🔁 Example Flow

For graph:

```text
5 → 0
5 → 2
4 → 0
4 → 1
2 → 3
3 → 1
```

DFS may produce:

```text
stack push order: 0, 1, 3, 2, 5, 4
```

Popping stack gives:

```text
4, 5, 2, 3, 1, 0
```

---

# ⚠️ Important Notes

```text
Topological sorting is only valid for DAG
```

If there is a cycle, no such linear ordering exists.

---

# ❌ Common Mistakes

* ❌ Trying topological sort on cyclic graph
* ❌ Pushing node before visiting neighbors
* ❌ Forgetting to use directed edges only
* ❌ Thinking result is unique

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

* every vertex is visited once
* every directed edge is explored once

---

# 🎯 Interview Insight

👉
“I use DFS and push each node into a stack after exploring all its outgoing edges. Popping the stack gives a valid topological ordering.”

---

# 🔥 Key Insight

```text
Topological sort = DFS + postorder stack
```

---

# 🚀 Key Takeaways

* Works only for DAG
* Every edge `u → v` means `u` comes before `v`
* DFS push-after-processing gives correct order
* Multiple valid answers may exist

---

# 🔥 Pattern Connection

* DAG processing
* Dependency ordering
* Course scheduling
* Build order problems

---
