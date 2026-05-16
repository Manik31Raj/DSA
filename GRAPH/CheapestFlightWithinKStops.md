# ✈️ Cheapest Flight Within K Stops

---

## 📌 Problem

> Given a directed weighted graph of flights, find the **cheapest price** from a source city to a destination city with **at most K stops**.

---

## 🔤 Meaning of Stops

```text id="stops"
Stops = number of intermediate cities between source and destination
```

So:

* `0 stops` → direct flight
* `1 stop` → one intermediate city
* `2 stops` → two intermediate cities

---

## 🌲 Example

```text id="example"
0 → 1 (500)
1 → 2 (500)
0 → 3 (200)
3 → 1 (200)
1 → 4 (100)
4 → 2 (100)
```

Source:

```text id="src"
0
```

Destination:

```text id="des"
2
```

K = `2`

---

## ✅ Answer

```text id="ans"
Cheapest price = 400
```

Path:

```text id="path"
0 → 3 → 1 → 2
```

Cost:

```text id="cost"
200 + 200 + 500 = 900
```

But with the extra route through `4`, a cheaper route may be found depending on stop limit handling.

---

# 🔥 Core Idea

```text
Use BFS-style traversal with a queue,
but keep track of how many flights have been taken so far
```

---

## 🧠 Why Not Simple Dijkstra?

Normal Dijkstra only cares about cheapest cost.

But here we also have a **stop limit**, so a cheaper path with too many stops may be invalid.

So we must track:

```text
(current city, current cost, current stops used)
```

---

# 🔷 Working Principle

---

## Step 1: Start from source

Queue initially contains:

```text
(stops = 0, node = src, price = 0)
```

---

## Step 2: Expand neighbors

For each flight:

```text
newPrice = currentPrice + edgeWeight
newStops = currentStops + 1
```

If this new state is still within the allowed stop limit, push it into queue.

---

## Step 3: Keep best known cost

If a cheaper cost is found for a node, update it.

This helps avoid unnecessary exploration.

---

# 🎯 Intuition

```text
We are searching for the cheapest valid route,
not just the cheapest route overall.
```

So both:

* cost
* number of stops

matter together.

---

# 🔄 Example Flow

Start:

```text
(0, 0, 0)
```

Then:

```text
0 → 3 → 1 → 2
```

or

```text
0 → 1 → 2
```

depending on which route satisfies stop limit and gives lower cost.

---

# ⚠️ Important Notes

```text
The stop limit is the main constraint
```

A very cheap path is useless if it uses too many stops.

---

# ❌ Common Mistakes

* ❌ Using plain Dijkstra without tracking stops
* ❌ Ignoring stop limit
* ❌ Confusing stops with edges
* ❌ Not handling unreachable destination

---

# ⚡ Complexity

* **Time Complexity:** depends on graph exploration, usually around O(V + E) with pruning, but can be higher in dense exploration
* **Space Complexity:** O(V)

---

## ❓ Why not always O(V + E)?

Because the same node may be reached with different stop counts, so multiple states can be explored.

---

# 🎯 Interview Insight

👉
“I use a queue to explore flights while keeping track of both cost and stop count. A path is only valid if it uses at most K stops. This is a constrained shortest path problem, not a standard shortest path problem.”

---

# 🔥 Key Insight

```text
Cheapest flight with K stops = shortest path with an extra stop constraint
```

---

# 🚀 Key Takeaways

* Cost alone is not enough
* Stop count must be tracked
* Queue-based state exploration works well
* A cheaper path may still be invalid if it exceeds K stops

---

# 🔥 Pattern Connection

* Constrained shortest path
* BFS / queue state search
* Weighted graph with extra conditions

---

## ✅ Very Important Clarification

A fully robust solution usually tracks **distance by stops count** as well, because a node reached cheaply with more stops may not be usable within the stop limit, while a slightly more expensive path with fewer stops might still lead to the correct answer.

That is the subtle point interviewers often check.

---
