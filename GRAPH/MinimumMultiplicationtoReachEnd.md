# 🔢 Minimum Multiplication to Reach End

---

## 📌 Problem

> Given a starting number, an ending number, and an array of multipliers,
> find the **minimum number of multiplications** needed to reach the end number.

At every step:

* choose one number from the array
* multiply it with the current number
* take modulo `100000`

---

## 🌲 Example

```text
arr   = [2, 5, 7]
start = 3
end   = 84
```

---

## 🎯 Output

```text
Minimum Multiplication = 2
```

One possible path:

```text
3 → 21 → 84
```

Using:

```text
3 × 7 = 21
21 × 4?  (not allowed unless in array)
```

So the actual path depends on reachable states through allowed multipliers.

---

# 🔥 Core Idea

```text
Treat every number as a node in a graph
An edge exists if we can multiply by one allowed value
```

Each multiplication counts as **1 step**.

So this becomes a **shortest path problem in an unweighted graph**.

---

# 🧠 Why BFS?

```text
BFS finds the minimum number of steps
```

Since every multiplication has the same cost `1`, BFS is the correct approach.

---

# 🔷 State Representation

Each state stores:

* current number
* steps taken so far

```text
(number, steps)
```

---

# 🔁 Working Principle

## Step 1: Start from source

Queue initially contains:

```text
(start, 0)
```

---

## Step 2: Generate next states

For the current number `node`, try every multiplier:

```text
next = (node * arr[i]) % 100000
```

---

## Step 3: Update distance

If we can reach `next` in fewer steps:

* update its distance
* push it into the queue

---

## Step 4: Stop when end is found

The first time we reach `end` in BFS:

```text
that is the minimum number of multiplications
```

---

# 🎯 Intuition

```text
Numbers are nodes
Multiplication by allowed values are edges
BFS explores all reachable numbers level by level
```

---

# 🔄 Example Flow

Start:

```text
3
```

Next possible values:

```text
3 × 2 = 6
3 × 5 = 15
3 × 7 = 21
```

Then expand those states further until `84` is reached.

---

# ⚠️ Important Notes

```text
Modulo 100000 keeps numbers inside a fixed range
```

This prevents the values from growing too large.

---

# ❌ Common Mistakes

* ❌ Using DFS instead of BFS
* ❌ Forgetting modulo operation
* ❌ Not maintaining visited/dist array
* ❌ Returning late instead of stopping early when end is reached

---

# ⚡ Complexity

* **Time Complexity:** O(100000 × arr.length)
* **Space Complexity:** O(100000)

---

## ❓ Why?

* each number from `0` to `99999` may be visited once
* for each number, we try all multipliers

---

# 🎯 Interview Insight

👉
“I treat every reachable value as a node in an implicit graph. From each node, I can move to new nodes by multiplying with allowed numbers. Since each move has equal cost, BFS gives the minimum number of multiplications.”

---

# 🔥 Key Insight

```text
Minimum multiplications = shortest path in implicit graph
```

---

# 🚀 Key Takeaways

* Use BFS
* Track state as current number and steps
* Apply modulo at every multiplication
* First time reaching target gives minimum steps

---

# 🔥 Pattern Connection

* Unweighted shortest path
* State-space BFS
* Implicit graph search

---
