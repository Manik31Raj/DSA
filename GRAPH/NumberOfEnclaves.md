# 🏝️ Number of Enclaves

---

## 📌 Problem

> Given a binary matrix:

* `0` → water
* `1` → land

Find the number of **land cells that cannot reach the boundary**.

👉 These land cells are called **enclaves**.

---

## 🌲 Example

```text
    Initial                       After
 0  0  0  1  1                0  0  0  1  1 
 0  0  1  1  0                0  0  1  1  0 
 0  1  0  0  0    ------>     0  2  0  0  0 
 0  1  1  0  0                0  2  2  0  0 
 0  0  0  1  1                0  0  0  1  1 
```

👉 Cells marked `3` are **enclaves**

---

## ✅ Answer

```text id="ans"
Number of Enclaves = 3
```

---

# 📌 What is an Enclave?

```text id="def"
A land cell (1) that is not connected to any boundary land cell
```

👉 If a land region can reach the boundary, it is **not** an enclave.

---

# 🔥 Core Idea

```text id="core"
Mark all land cells connected to the boundary
Then count the remaining unvisited land cells
```

---

# 🔷 Why Boundary Matters?

Boundary-connected land can escape to outside the grid.

```text id="boundary"
Boundary land = safe / not enclave  
Inner land = possible enclave
```

---

# 🧭 Movement Rule

```text id="dir"
Only 4-direction movement is allowed:
Up, Right, Down, Left
```

👉 Diagonals are **not** connected.

---

# 🔁 Working Principle

### Step 1️⃣ Mark boundary land

* Scan all boundary cells
* If boundary cell is `1`, add it to queue and mark visited

### Step 2️⃣ BFS from boundary land

* Spread to all connected land cells
* Mark them as visited

### Step 3️⃣ Count remaining land cells

* Any inner cell with `1` and `not visited`

  * is an enclave
  * mark it as `2` in output
  * count it

---

# 🎯 Intuition

```text id="intuition"
Boundary-connected land is eliminated first
What remains inside is enclave
```

---

# 🔷 Boundary Marking

```text id="mark"
Top boundary  
Right boundary  
Bottom boundary  
Left boundary
```

👉 All boundary land cells are pushed into queue first.

---

# 🔷 BFS Flood from Boundary

```text id="bfs"
Start from all boundary land cells
Spread only through land cells (1)
Mark every reachable land cell as visited
```

---

# ⚡ Complexity

* **Time Complexity:** O(N × M)
* **Space Complexity:** O(N × M)

---

## ❓ Why?

```text id="tc"
Each cell is visited at most once
```

---

# ⚠️ Important Notes

```text id="note"
Only 4-direction connectivity is used
```

---

# ❌ Common Mistakes

* ❌ Counting all inner `1`s directly
* ❌ Forgetting boundary traversal
* ❌ Considering diagonals connected
* ❌ Using only DFS from one side

---

# 🎯 Interview Insight

👉
“I first mark all land cells connected to the boundary using BFS. Then I count the remaining unvisited land cells as enclaves.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Enclave = land cell that cannot reach boundary
```

---

# 🚀 Key Takeaways

* Boundary-connected land is safe
* BFS/DFS can mark safe cells
* Remaining land cells are enclaves
* Final count gives answer

---

# 🔥 Pattern Connection

* Number of islands
* Surrounded regions
* Grid BFS / DFS
* Connected components

---
