# 🌳 Nodes Present at Distance K from Target Node

---

## 📌 Definition

> Given a binary tree, a **target node**, and an integer `K`,
> find all nodes that are exactly **K distance away** from the target.

---

## 🌲 Example (Tree)

```id="dk-tree"
            6
         /     \
        3       8
       / \     / \
      4  10   1  30
         /  \
        12  21
```

---

## 👀 Example Query

```id="dk-query"
Target = 3
K = 2
```

```id="dk-ans"
Output → [12, 21, 8]
```

---

## 🧠 Core Idea

👉 From target, we need to move in **all directions**

```text id="dir"
left + right + parent
```

👉 But binary tree only allows:

```text id="lim"
parent → child (downward only)
```

---

## 🔥 Key Insight

```text id="key0"
We DO NOT build a full graph,
we just add parent references to enable bidirectional traversal
```

---

## ❓ Why Parent Mapping?

```text id="why-parent"
Tree nodes don’t store parent reference
```

👉 Without it:

* Cannot move upward ❌
* Cannot reach nodes like:

```text id="ex1"
3 → 6 → 8
```

👉 So we store:

```text id="ex2"
child → parent mapping
```

👉 Now traversal becomes:

```text id="ex3"
left + right + parent
```

---

## ❓ Why Visited Map?

Once we allow parent traversal:

```text id="cycle"
Tree behaves like a graph with cycles
```

Example:

```text id="cycle-ex"
3 → 6 → 3 → 6 → ...
```

👉 Infinite loop ❌

So we use:

```text id="visited"
visited map
```

👉 To ensure each node is visited only once

---

## ❓ Why BFS?

We need nodes at **exact distance K**

👉 BFS works level-wise:

```text id="bfs-level"
Level = Distance
```

| Level | Meaning    |
| ----- | ---------- |
| 0     | target     |
| 1     | neighbors  |
| 2     | distance 2 |

👉 Perfect match ✔

---

## 🔁 Working Principle

### Step 1️⃣ Parent Mapping

```text id="step1"
Store parent of each node
```

👉 Enables upward movement

---

### Step 2️⃣ BFS from Target

* Start from target
* Traverse in:

```text id="step2"
left → right → parent
```

* Mark visited nodes

---

### Step 3️⃣ Stop at K

```text id="step3"
When level == K → stop
```

👉 Remaining nodes = answer

---

## 🎯 Intuition (Tree → Graph-like)

```id="dk-intuition"
Tree                          →        Graph-like behavior

        3                              3
      /   \                          / | \
     4    10        →              4 10  6
         /  \                         / \
        12  21                      12 21
```

👉 Not a full graph
👉 But traversal is now **bidirectional**

---

## 🔄 Flow

```id="dk-flow"
Start from 3

Level 0 → [3]
Level 1 → [4, 10, 6]
Level 2 → [12, 21, 8]
```

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(N)

---

## ⚠️ Important Notes

```text id="note1"
Parent map → enables upward traversal
Visited map → prevents cycles
BFS → ensures exact distance
```

---

## ❌ Common Mistakes

* ❌ Thinking we build full graph
* ❌ Skipping visited → infinite loop
* ❌ Using DFS → difficult for exact distance
* ❌ Forgetting parent traversal

---

## 🎯 Interview Insight

Best explanation:

👉
“I don’t explicitly build a graph, but by storing parent pointers I allow bidirectional traversal, and then I use BFS from the target node to get nodes at distance K.”

---

## 🔥 Key Insight

```text id="key1"
Tree + parent mapping = graph-like traversal
```

---

## 🚀 Key Takeaways

* No full graph needed
* Parent mapping is enough
* BFS handles distance perfectly
* Think bidirectional traversal

---

## 🔥 Pattern Connection

* Distance K → BFS + Graph-like traversal
* LCA → DFS
* Width → BFS + indexing

---
