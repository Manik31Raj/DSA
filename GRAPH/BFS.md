# 🌐 Breadth First Search (BFS)

---

## 📌 Problem

> Traverse a graph using **Breadth First Search (BFS)** starting from a given node.

---

## 🌲 Example Graph

```id="bfs-graph"
1 --- 2 --- 3
|     |
6     4
|     |
7 --- 5 --- 8
      |
      9
```

---

## 🧠 Core Idea

```text id="core"
Explore graph level by level
```

---

## 🔁 Traversal Pattern

```text id="pattern"
Go to all neighbors first, then next level
```

---

## 🎯 Starting Node

```text id="start"
Start = 1
```

---

## 🔄 BFS Order

```text id="order"
1 → 2 → 6 → 3 → 4 → 7 → 9 → 5 → 8
```

---

# 🔷 Working Principle

---

## 🧠 Data Structures Used

```text id="ds"
Queue → for FIFO traversal  
Visited array → to avoid revisiting nodes
```

---

## 🔁 Steps

1. Add starting node to queue
2. Mark it as visited
3. While queue is not empty:

```text id="steps"
- Remove node from queue  
- Add it to answer  
- Push all unvisited neighbors  
```

---

## 🎯 Intuition

```text id="intuition"
Like spreading wave from source node
```

---

## 📦 Queue Visualization

---

### 🔁 Initial

```text id="q1"
Queue: [1]
Visited: {1}
```

---

### 🔁 After processing 1

```text id="q2"
Queue: [2, 6]
Visited: {1,2,6}
```

---

### 🔁 After processing 2

```text id="q3"
Queue: [6, 3, 4]
```

---

### 🔁 After processing 6

```text id="q4"
Queue: [3, 4, 7, 9]
```

---

👉 Continues level by level

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

```text id="tc"
Each node visited once + each edge processed once
```

---

# ⚠️ Important Notes

```text id="note"
Always mark visited BEFORE pushing to queue
```

👉 Prevents duplicates

---

# ❌ Common Mistakes

* ❌ Marking visited after popping
* ❌ Forgetting visited array
* ❌ Using stack instead of queue
* ❌ Infinite loop in cyclic graph

---

# 🎯 Interview Insight

👉
“I use a queue to traverse the graph level by level and a visited array to avoid revisiting nodes.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
BFS = level order traversal of graph
```

---

# 🚀 Key Takeaways

* Uses Queue (FIFO)
* Traverses level by level
* Works for shortest path (unweighted)
* Handles cycles using visited array

---

# 🔥 Pattern Connection

* Shortest path (unweighted graph)
* Level order traversal
* Multi-source BFS

---
