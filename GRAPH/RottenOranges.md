# 🍊 Rotten Oranges (Multi-Source BFS)

---

## 📌 Problem

> Given a grid:

* `0` → Empty cell
* `1` → Fresh orange
* `2` → Rotten orange

👉 Every minute, rotten oranges infect adjacent fresh ones.
Find **minimum time to rot all oranges** OR return impossible.

---

## 🌲 Example

```id="rotten-grid"
1 2 1
0 1 0
0 2 1
```

---

## 🎯 Output

```text id="output"
Time = 2 minutes
```

---

# 🔥 Core Idea

```text id="core"
Spread rot level by level using BFS
```

---

# 🔷 Why BFS?

```text id="why"
Infection spreads in waves (levels)
```

👉 Perfect match for BFS

---

# 🔷 Multi-Source BFS

---

## 🧠 Idea

```text id="multi"
Start BFS from ALL rotten oranges at once
```

---

## 🎯 Why?

```text id="why-multi"
All rotten oranges spread simultaneously
```

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
- Add all rotten oranges (2) to queue  
- Count total fresh oranges
```

---

## 🔁 Step 2: BFS Traversal

```text id="step2"
For each level (minute):
  - Process all current rotten oranges  
  - Infect neighbors  
  - Add newly rotten oranges to queue
```

---

## 🔁 Step 3: Time Tracking

```text id="step3"
If any infection happens → increase time
```

---

## 🔁 Step 4: Final Check

```text id="step4"
If fresh oranges remain → impossible
```

---

# 🎯 Intuition

```text id="intuition"
Rot spreads like fire in all directions simultaneously
```

---

# ⚡ Complexity

* **Time Complexity:** O(N × M)
* **Space Complexity:** O(N × M)

---

## ❓ Why?

```text id="tc"
Each cell is visited once
```

---

# ⚠️ Important Notes

```text id="note1"
Use multi-source BFS (all 2's at start)
```

```text id="note2"
Track fresh oranges count
```

---

# ❌ Common Mistakes

* ❌ Starting BFS from one rotten orange only
* ❌ Not tracking fresh oranges
* ❌ Incorrect time increment
* ❌ Revisiting cells

---

# 🔄 Key Observation

```text id="obs"
Time = number of BFS levels
```

---

# 🎯 Interview Insight

👉
“I use multi-source BFS where all rotten oranges act as sources, and each level represents one minute of infection spread.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
This is NOT normal BFS → it's multi-source BFS
```

---

# 🚀 Key Takeaways

* Multiple starting points
* BFS level = time
* Track fresh count
* Stop when no fresh left

---

# 🔥 Pattern Connection

* Multi-source BFS
* Shortest distance in grid
* Similar → 01 Matrix

---
