# 🌐 City With Smallest Number of Neighbours at Threshold Distance

---

## 📌 Problem

> Given a weighted graph, find the city that can reach the **smallest number of other cities** such that the shortest distance is **within a given threshold**.

---

## 🎯 Goal

For every city:

* find shortest distances to all other cities
* count how many cities are reachable with distance `<= threshold`

Return the city with the **smallest count**.

---

## 🌲 Example

```text
n = 4
threshold = 4

Edges:
0 --3-- 1
1 --1-- 2
1 --4-- 3
3 --2-- 1
```

---

# 🔥 Core Idea

```text
First compute all-pairs shortest paths,
then count neighbours within threshold for each city.
```

This is a classic **Floyd-Warshall + counting** problem.

---

# 🔷 Why Floyd-Warshall?

We need shortest distance between **every pair of cities**.

So instead of running shortest path from every city separately, we use:

* adjacency matrix
* Floyd-Warshall all-pairs shortest path

---

# 🔁 Working Principle

---

## Step 1: Build adjacency matrix

* initialize all entries with `INF`
* set diagonal to `0`
* fill edge weights

Since the graph is undirected:

```text
u → v
v → u
```

both directions are filled.

---

## Step 2: Run Floyd-Warshall

Try every city as an intermediate node:

```text
cost[j][k] = min(cost[j][k], cost[j][i] + cost[i][k])
```

After this, `cost[i][j]` becomes the shortest distance from city `i` to city `j`.

---

## Step 3: Count reachable cities

For each city `i`:

* count all cities `j`
* where `i != j`
* and `cost[i][j] <= threshold`

That count is the number of neighbours reachable within threshold distance.

---

# 🎯 Intuition

```text
Floyd-Warshall gives the shortest distance matrix,
then we simply count how many cities are close enough.
```

---

# 🔄 Example Thinking

Suppose after shortest path computation:

```text
City 0 → reachable cities within threshold = 2
City 1 → reachable cities within threshold = 3
City 2 → reachable cities within threshold = 1
City 3 → reachable cities within threshold = 2
```

Then the answer is the city with the **smallest count**.

---

# ⚠️ Important Tie-Break Rule

In the standard problem, if multiple cities have the same minimum count:

```text
Choose the city with the greatest index
```

This is a very important interview/detail point.

---

# ⚠️ Important Notes

```text
This approach works because we need all-pairs shortest distances
```

That is exactly what Floyd-Warshall is designed for.

---

# ❌ Common Mistakes

* ❌ Forgetting to make the graph undirected
* ❌ Not initializing diagonal to 0
* ❌ Not using INF check before addition
* ❌ Forgetting tie-break rule
* ❌ Counting the city itself as neighbour

---

# ⚡ Complexity

* **Time Complexity:** O(n³)
* **Space Complexity:** O(n²)

---

## ❓ Why?

Floyd-Warshall uses 3 nested loops over all cities.

---

# 🎯 Interview Insight

👉
“I first compute all-pairs shortest paths using Floyd-Warshall. Then for each city, I count how many other cities are reachable within the threshold distance. Finally, I select the city with the minimum count, and if there is a tie, the city with the larger index.”

---

# 🔥 Key Insight

```text
City selection = Floyd-Warshall + threshold counting + tie-break
```

---

# 🚀 Key Takeaways

* Use Floyd-Warshall for all-pairs shortest paths
* Count cities with distance `<= threshold`
* Exclude the city itself
* Apply tie-break rule if needed

---

# 🔥 Pattern Connection

* All-pairs shortest path
* Matrix DP
* Threshold-based graph counting

---
