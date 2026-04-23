# 🔥 Burn Binary Tree (Time to Burn Entire Tree)

---

## 📌 Definition

> Given a binary tree and a **target node**,
> find the **minimum time required to burn the entire tree**.

👉 Fire spreads to:

* left child
* right child
* parent

👉 Each spread takes **1 unit time**

---

## 🌲 Example (Tree)

```id="burn-tree"
        1
      /   \
     2     3
    /       \
   4         6
    \
     7
   /
  5
```

---

## 👀 Example Query

```id="burn-query"
Target = 2
```

---

## 🔥 Burning Process (Level-wise)

```id="burn-flow"
Time 0 → [2]
Time 1 → [1, 4]
Time 2 → [3, 7]
Time 3 → [6, 5]
```

👉 Total Time = **3**

---

## 🧠 Core Idea

👉 Fire spreads in **all directions**

```text id="burn-dir"
left + right + parent
```

👉 But tree only allows downward movement

So we:

```text id="burn-key"
Add parent mapping to simulate bidirectional movement
```

---

## ❓ Why Parent Mapping?

```text id="burn-parent"
Tree nodes don’t store parent reference
```

👉 Without it:

* Fire cannot go upward ❌
* Tree won’t burn completely ❌

---

## ❓ Why Visited Map?

Once parent is added:

```text id="burn-cycle"
Traversal becomes cyclic
```

Example:

```text id="burn-loop"
2 → 1 → 2 → 1 → ...
```

👉 Infinite loop ❌

So:

```text id="burn-visited"
Use visited to avoid revisiting nodes
```

---

## ❓ Why BFS?

👉 Fire spreads **level by level**

```text id="burn-bfs"
Each level = 1 unit time
```

👉 Perfect match for BFS ✔

---

## 🔁 Working Principle

### Step 1️⃣ Build Parent Map

```text id="burn-step1"
Store child → parent mapping
```

---

### Step 2️⃣ BFS from Target

* Start from target node
* Explore in 3 directions:

```text id="burn-step2"
left → right → parent
```

---

### Step 3️⃣ Count Time

* Each level = 1 unit time
* Increase time only if new nodes are burned

---

## 🎯 Intuition (Tree → Spread)

```id="burn-intuition"
        2
      /   \
     4     1
      \     \
       7     3
      /       \
     5         6
```

🔥 Fire spreads outward like a wave

---

## 🔄 Flow

```id="burn-levels"
Start from 2

Level 0 → [2]
Level 1 → [1, 4]
Level 2 → [3, 7]
Level 3 → [6, 5]
```

👉 Each level = 1 second

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(N)

---

## ⚠️ Important Notes

```text id="burn-note"
Parent map → enables upward spread
Visited → avoids cycles
BFS → tracks time correctly
```

---

## ❌ Common Mistakes

* ❌ Not using parent mapping
* ❌ Forgetting visited → infinite loop
* ❌ Using DFS (incorrect timing)
* ❌ Increasing time unnecessarily

---

## 🎯 Interview Insight

Best explanation:

👉
“I treat the burning process like BFS from the target node. I add parent references to allow upward spread and use a visited set to avoid cycles. Each BFS level represents one unit of time.”

---

## 🔥 Key Insight

```text id="burn-final"
Burning = multi-directional BFS from target
```

---

## 🚀 Key Takeaways

* BFS models spreading problems
* Parent mapping enables full traversal
* Level = time
* Similar to graph problems

---

## 🔥 Pattern Connection

* Burn Tree → BFS + Graph-like traversal
* Distance K → BFS from node
* LCA → DFS

---
