# 🌳 Surrounded Regions

---

## 📌 Problem

> Given a matrix of `'X'` and `'O'`,
> convert all **surrounded `'O'` regions** into `'X'`.

👉 A region of `'O'` should be flipped only if it is **not connected to the boundary**.

---

## 🌲 Example

```text
    Initial                       After
 X  X  X  X  X                X  X  X  X  X 
 X  O  O  X  O                X  X  X  X  O 
 X  X  O  X  O    ------>     X  X  X  X  O 
 X  O  X  O  X                X  O  X  X  X 
 O  O  X  X  X                O  O  X  X  X 
```

---

## 🧠 Core Idea

```text id="core"
Boundary-connected O's are safe
All remaining O's are surrounded and must be changed to X
```

---

## 🔷 Key Observation

```text id="obs"
If an O touches the boundary directly or indirectly, it must NOT be flipped
```

---

# 🔶 Why Boundary Matters?

A region is surrounded only if it cannot reach the border.

```text id="boundary-rule"
Boundary O = safe  
Inner O = candidate for flipping
```

---

## 🧭 Movement Rule

```text id="dir"
Only 4-direction movement is allowed:
Up, Right, Down, Left
```

👉 Diagonals are **not** connected.

---

## 🔁 Working Principle

### Step 1️⃣ Mark all boundary-connected `'O'`

* Scan:

  * top row
  * bottom row
  * left column
  * right column

* For every boundary `'O'`, run DFS and mark all connected `'O'` cells as **visited**

---

### Step 2️⃣ Flip inner `'O'`

* Traverse only inner cells
* If a cell is `'O'` and **not visited**

  * it is surrounded
  * change it to `'X'`

---

# 🌳 Intuition (Visual)

```text id="intuition"
Boundary O's are like "escape points"
Inner O's without escape are trapped
```

---

## 🖼️ Visual Meaning

```text id="visual"
Before:
X X X X X
X O O X O
X X O X O
X O X O X
O O X X X

After:
X X X X X
X X X X O
X X X X O
X O X X X
O O X X X
```

👉 The bottom-left `'O'` cells stay because they touch the boundary
👉 The others are surrounded and flipped

---

# 🔷 Approach 1: DFS from Boundary

---

## 🧠 Idea

```text id="dfs-core"
Start DFS from boundary O's and mark all safe O's
```

---

## 🔁 Steps

1. Check all boundary cells
2. If boundary cell is `'O'`, DFS from it
3. Mark all reachable `'O'` as visited
4. Traverse inner cells and flip unvisited `'O'` to `'X'`

---

## 🎯 Why DFS?

```text id="why-dfs"
DFS helps mark the whole connected safe region easily
```

---

# 🔷 Why `visited` Array?

```text id="visited"
visited tells us which O's are safe (boundary-connected)
```

👉 Without visited:

* we cannot distinguish safe vs surrounded O's
* we may flip boundary-connected O's incorrectly

---

# ⚠️ Important Notes

```text id="note"
This problem uses 4-direction connectivity only
```

---

# ❌ Common Mistakes

* ❌ Flipping boundary-connected O's
* ❌ Considering diagonals connected
* ❌ Not marking boundary regions first
* ❌ Forgetting to track visited cells

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

# 🎯 Interview Insight

👉
“I first mark all boundary-connected O's using DFS. Then I traverse the inner cells and flip only those O's that were not marked visited.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Boundary-connected O's are safe, everything else is surrounded
```

---

# 🚀 Key Takeaways

* Boundary cells decide safety
* DFS/BFS can mark safe region
* Only inner unvisited O's are flipped
* 4-direction traversal is used

---

# 🔥 Pattern Connection

* Flood Fill
* Number of Islands
* Graph traversal on grid

---
