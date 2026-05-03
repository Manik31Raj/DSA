# 🌐 Depth First Search (DFS) – Recursion & Stack

---

## 📌 Problem

> Traverse a graph using **Depth First Search (DFS)** using:

* Recursion (implicit stack)
* Explicit Stack (iterative)

---

## 🔤 Notation

```text id="ve-def"
V → Number of Vertices (nodes)  
E → Number of Edges (connections)
```

---

## 🌲 Example Graph

```id="dfs-graph"
1 --- 2 --- 5
|     |
3     6
| \
4  7
    \
     8
```

---

## 🧠 Core Idea

```text id="core"
Go deep into graph before exploring other paths
```

---

## 🔁 Traversal Pattern

```text id="pattern"
Node → Deep → Backtrack → Next path
```

---

# 🔷 Approach 1: Recursion (DFS)

---

## 🧠 Idea

```text id="rec-core"
Use recursion → system call stack handles traversal
```

---

## 🔁 Steps

1. Mark node as visited
2. Add to result
3. Traverse all unvisited neighbors recursively

---

## 🎯 Intuition

```text id="rec-int"
Function calls act like stack
```

---

## 📦 Call Stack

```text id="rec-stack"
dfs(1)
 → dfs(2)
   → dfs(5)
   → dfs(6)
 → dfs(3)
   → dfs(4)
   → dfs(7)
     → dfs(8)
```

---

# 🔷 Approach 2: Iterative (Using Stack)

---

## 🧠 Idea

```text id="stack-core"
Use explicit stack to simulate recursion
```

---

## 🔁 Steps

1. Push starting node into stack
2. While stack not empty:

```text id="stack-steps"
- Pop node  
- If not visited:
    mark visited  
    add to result  
    push neighbors (in reverse order)
```

---

## 🎯 Why Reverse Order?

```text id="reverse"
To match recursion DFS order
```

---

## 📦 Stack Visualization

```text id="stack-vis"
Top
[ 2 ]
[ 3 ]
Bottom
```

👉 Last inserted node is processed first

---

# ⚡ Complexity

* **Time Complexity:** O(V + E)
* **Space Complexity:** O(V)

---

## ❓ Why O(V + E)?

```text id="tc"
Each node visited once (V)  
Each edge explored once (E)
```

---

# ⚠️ Important Notes

```text id="note"
Visited array is mandatory to avoid cycles
```

---

# ❌ Common Mistakes

* ❌ Not marking visited
* ❌ Infinite loop in cyclic graph
* ❌ Wrong neighbor order in stack
* ❌ Forgetting reverse push

---

# 🔄 Recursion vs Stack

---

## 📊 Comparison

| Feature        | Recursion       | Stack         |
| -------------- | --------------- | ------------- |
| Implementation | Easy            | Medium        |
| Space          | O(H) call stack | O(V) explicit |
| Control        | Less            | More          |
| Interview      | Standard        | Bonus         |

---

# 🎯 Interview Insight

👉
“I can implement DFS using recursion or explicitly using a stack. Both follow the same logic, but stack gives more control over traversal.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
DFS = Stack-based traversal (explicit or implicit)
```

---

# 🚀 Key Takeaways

* DFS explores deeply
* Recursion = implicit stack
* Stack method = manual control
* Order can vary

---

# 🔥 Pattern Connection

* Backtracking
* Cycle detection
* Topological sort

---
