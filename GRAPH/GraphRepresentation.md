# 🌐 Graph Representation (Matrix vs List)

---

# 📌 What is a Graph?

```text id="graph-def"
A graph is a collection of:
Nodes (vertices) + Edges (connections)
```

👉 Represented as:

```text id="graph-form"
G = (V, E)
```

---

# 🌲 Example Graph

```id="graph-main"
       1 ----- 2
       |       | \
       |       |  5
       |       | /
       3 ----- 4
```

---

# 🔷 Basic Terminology (with Visualization)

---

## 🔹 Vertex (Node)

```id="vertex-fig"
Nodes: {1, 2, 3, 4, 5}
```

👉 Each number is a **vertex**

---

## 🔹 Edge

```id="edge-fig"
Edge examples:
(1 — 2), (2 — 5), (3 — 4)
```

👉 Represents connection between nodes

---

## 🔹 Path

```id="path-fig"
Path: 1 → 2 → 4 → 3
```

```text id="path-rule"
✔ Nodes must be connected  
✔ Node appears only once
```

---

## 🔹 Cycle

```id="cycle-fig"
Cycle: 1 → 2 → 4 → 3 → 1
```

```text id="cycle-rule"
Starts and ends at same node
```

---

## 🔹 Degree

```id="degree-fig"
Node 2 → degree = 3
(connected to 1, 4, 5)
```

---

### 🔸 Degree Types

```text id="degree-types"
Undirected → total edges  

Directed:
In-degree  → incoming edges  
Out-degree → outgoing edges  
```

---

## 🔹 Weight

```id="weight-fig"
1 --(5)-- 2
```

👉 Edge has value (cost/distance)

---

# 🔷 Types of Graphs (with Figures)

---

## 🔹 Undirected Graph

```id="undirected-fig"
1 --- 2
```

👉 No direction

---

## 🔹 Directed Graph

```id="directed-fig"
1 → 2
```

👉 Direction matters

---

## 🔹 Weighted Graph

```id="weighted-fig"
1 --(10)--> 2
```

---

## 🔹 Cyclic Graph

```id="cyclic-fig"
1 → 2 → 3 → 1
```

---

## 🔹 Acyclic Graph

```id="acyclic-fig"
1 → 2 → 3
```

---

## 🔹 Connected Graph

```id="connected-fig"
All nodes reachable
```

---

## 🔹 Disconnected Graph

```id="disconnected-fig"
1 --- 2     3 --- 4
```

---

# 🔷 Graph Representation Methods

---

## 1️⃣ Adjacency Matrix

---

## 🧠 Idea

```text id="matrix-idea"
Use 2D array:
adj[u][v] = 1 (or weight)
```

---

## ⚡ Complexity

* **Space:** O(N²)

---

## ✅ Advantages

* Fast lookup → O(1)
* Simple

---

## ❌ Disadvantages

* High memory usage
* Not good for sparse graphs

---

# 🔷 Adjacency List

---

## 🧠 Idea

```text id="list-idea"
Store neighbors using lists
```

---

## ⚡ Complexity

* **Space:** O(N + 2M)

---

## ✅ Advantages

* Memory efficient
* Best for sparse graphs

---

## ❌ Disadvantages

* Edge lookup slower

---

# 🔄 Matrix vs List

---

## 📊 Comparison

| Feature    | Matrix | List      |
| ---------- | ------ | --------- |
| Space      | O(N²)  | O(N + 2M) |
| Edge Check | O(1)   | O(degree) |
| Best Use   | Dense  | Sparse    |

---

# 🧠 Intuition

```text id="intuition"
Matrix → grid  
List → connections
```

---

# ⚠️ Important Notes

```text id="note"
Use n+1 size for 1-based indexing
```

---

# 🎯 Interview Insight

👉
“I prefer adjacency list because it is efficient for most real-world graphs.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Graph understanding = terminology + representation
```

---

# 🚀 Key Takeaways

* Graph = nodes + edges
* Path must be connected & no repetition
* Cycle = closed loop
* Degree = number of connections
* List > Matrix in most cases

---
