# 📍 Distance of Nearest 1 (01 Matrix)

---

## 📌 Problem

> Given a binary matrix:

* `0` → empty cell
* `1` → source cell

Find distance of every cell from the **nearest 1**.

---

## 🌲 Example

```id="matrix-example"
0 0 0
0 1 0
1 0 1
```

---

## ✅ Output

```text id="output"
1 1 2
1 0 1
0 1 0
```

---

# 🔥 Core Idea

```text id="core"
Find shortest distance from every cell to nearest 1
```

---

# 🧠 Why Multi-Source BFS?

---

## ❓ Observation

```text id="obs"
All 1’s are already at distance 0
```

👉 So instead of starting BFS from every 0:

```text id="smart"
Start BFS from ALL 1’s simultaneously
```

---

# 🔷 Multi-Source BFS

---

## 🧠 Idea

```text id="multi"
Push all 1’s into queue initially
```

---

## 🎯 Why?

```text id="why"
Nearest 1 will always reach first in BFS
```

👉 BFS guarantees shortest distance

---

# 🔷 Movement (4 Directions)

---

```text id="dir"
        (-1,0)
           ↑

(0,-1) ← (0,0) → (0,+1)

           ↓
        (+1,0)
```

---

# 🔷 Working Principle

---

## 🔁 Step 1: Initialization

```text id="step1"
- Push all 1’s into queue  
- Mark them visited  
- Distance = 0
```

---

## 🔁 Step 2: BFS Expansion

```text id="step2"
For every popped cell:
   Explore neighbors
```

---

## 🔁 Step 3: Distance Update

```text id="step3"
ans[newCell] = ans[current] + 1
```

---

# 🎯 Intuition

```text id="intuition"
Distance spreads outward from all 1’s like waves
```

---

# 📦 Queue Visualization

---

## 🔁 Initial Queue

```text id="q1"
[(1,1), (2,0), (2,2)]
```

👉 All source cells

---

## 🔁 Next Expansion

```text id="q2"
Their neighbors become distance = 1
```

---

## 🔁 Final Expansion

```text id="q3"
Remaining cells get minimum possible distance
```

---

# ⚡ Complexity

* **Time Complexity:** O(N × M)
* **Space Complexity:** O(N × M)

---

## ❓ Why?

```text id="tc"
Each cell enters queue only once
```

---

# ⚠️ Important Notes

```text id="note"
Visited array prevents revisiting cells
```

---

# ❌ Common Mistakes

* ❌ Running BFS from every 0 separately
* ❌ Forgetting multi-source concept
* ❌ Revisiting cells
* ❌ Incorrect distance updates

---

# 🔄 Why BFS Works Best?

```text id="bfs-best"
BFS always gives shortest path in unweighted graph/grid
```

---

# 🎯 Interview Insight

👉
“I use multi-source BFS by pushing all 1’s initially because BFS naturally expands in shortest-distance order.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Nearest-source problems → Multi-source BFS
```

---

# 🚀 Key Takeaways

* Start from all sources together
* BFS guarantees shortest distance
* Distance = BFS levels
* Grid treated as graph

---

# 🔥 Pattern Connection

* Rotten Oranges
* Walls and Gates
* Shortest Path in Grid

---
