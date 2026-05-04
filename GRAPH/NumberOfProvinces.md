# 🌐 Number of Provinces (Connected Components)

---

## 📌 Problem

> Find the number of **provinces** (connected components) in a graph.

---

# 📌 What is a Province?

```text id="province-def"
A province is a group of nodes that are connected directly or indirectly,
and have NO connection with nodes outside the group.
```

---

## 🧠 Simple Meaning

```text id="simple"
Province = one connected component
```

---

## 🌲 Example Graph

```id="province-graph"
1 --- 2 --- 3      4 --- 5 --- 6      7 --- 8
```

---

## 🎯 Explanation

```text id="province-exp"
Group 1 → {1,2,3}  
Group 2 → {4,5,6}  
Group 3 → {7,8}
```

---

## ✅ Answer

```text id="province-ans"
Number of Provinces = 3
```

---

# 🔥 Core Idea

```text id="core"
Count how many disconnected components exist
```

---

# 🔷 Approach 1: DFS (Recursion)

---

## 🧠 Idea

```text id="dfs-core"
Start DFS from every unvisited node
```

---

## 🔁 Steps

1. Initialize visited array
2. Loop through all nodes
3. If node not visited:

```text id="dfs-steps"
- Increase province count  
- Run DFS to mark all connected nodes
```

---

## 🎯 Intuition

```text id="dfs-int"
One DFS call = one complete province
```

---

# 🔷 Approach 2: DFS using Stack (Iterative)

---

## 🧠 Idea

```text id="stack-core"
Use stack instead of recursion
```

---

## 🔁 Steps

1. For each unvisited node:

```text id="stack-steps"
- Increase province  
- Push node into stack  
- Traverse all reachable nodes  
```

---

## 🎯 Intuition

```text id="stack-int"
Same as DFS but manual stack
```

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

```text id="tc"
Each node visited once  
Each edge explored once
```

---

# ⚠️ Important Notes

```text id="note"
Graph may be disconnected → must check all nodes
```

---

# ❌ Common Mistakes

* ❌ Starting DFS from only one node
* ❌ Not looping over all nodes
* ❌ Forgetting visited array
* ❌ Counting nodes instead of components

---

# 🎯 Interview Insight

👉
“I iterate over all nodes and run DFS for each unvisited node. Each DFS call represents one connected component or province.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Number of Provinces = Number of times DFS is started
```

---

# 🚀 Key Takeaways

* Province = connected component
* DFS/BFS can solve it
* Count DFS calls
* Works for disconnected graphs

---

# 🔥 Pattern Connection

* Connected components
* Graph traversal
* Similar → islands problem

---
