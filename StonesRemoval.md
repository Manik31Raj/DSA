# 🪨 Most Stones Removed with Same Row or Column

---

## 📌 Problem

> Given stones placed on a grid, remove as many stones as possible such that every removed stone shares its row or column with another remaining stone.

---

## 🌲 Example

```text
1 . 1 .
. . . 1
. . . .
. 1 1 .
. . . 1
```

---

## 🎯 Goal

```text
Remove maximum stones while keeping at least one stone in each connected group
```

---

# 🔥 Core Idea

```text
Treat each row and each column as nodes in DSU
A stone at (r, c) connects row r and column c
```

So every stone becomes an edge between:

* row node
* column node

---

# 🧠 Why DSU Works

If two stones share:

* the same row, or
* the same column

then they are part of the same connected component.

DSU helps us merge these connected row/column nodes efficiently.

---

# 🔷 Important Trick

Because rows and columns are different index spaces, we map them like this:

```text
row node = r
col node = c + number_of_rows
```

That avoids collision between row indices and column indices.

---

# 🔁 Working Principle

---

## Step 1: Create DSU for rows + columns

If there are `r` rows and `c` columns, DSU size is:

```text
r + c
```

---

## Step 2: Union row and column for each stone

For every stone `(i, j)`:

```text
union(i, j + r)
```

This means the stone connects its row node and column node.

---

## Step 3: Count connected components

After processing all stones, count how many DSU components contain at least one stone.

Each such component must keep **one stone**.

---

## Step 4: Compute answer

```text
maximum stones removed = total stones - number of connected components
```

---

# 🎯 Intuition

```text
In each connected component, we can remove all stones except one.
```

So if a component has `k` stones, we can remove `k - 1` stones.

Summing over all components gives:

```text
total stones - components
```

---

# 🔄 Example Thinking

Suppose there are:

* 6 stones
* 2 connected components

Then:

```text
maximum removable stones = 6 - 2 = 4
```

Because each component must keep one stone.

---

# ⚠️ Important Notes

```text
Only stones that belong to the same row/column connected group are removable together
```

Also:

* isolated stone cannot be removed
* every connected group must retain at least one stone

---

# ❌ Common Mistakes

* ❌ Treating stones as grid cells instead of row/column connections
* ❌ Not offsetting column nodes by `r`
* ❌ Counting all DSU nodes instead of only components with stones
* ❌ Forgetting that each component keeps exactly one stone

---

# ⚡ Complexity

* **Time Complexity:** O(N · α(N))
* **Space Complexity:** O(R + C)

Where:

* `N` = number of stones
* `α(N)` = inverse Ackermann function, almost constant

---

# 🎯 Interview Insight

👉
“I model each row and each column as DSU nodes. Every stone connects its row node with its column node. After all unions, each connected component needs at least one stone, so the answer is total stones minus number of components.”

---

# 🔥 Key Insight

```text
Most stones removed = total stones - connected components
```

---

# 🚀 Key Takeaways

* Rows and columns become DSU nodes
* Each stone connects one row and one column
* One stone must remain per component
* Answer = stones - components

---

# 🔥 Pattern Connection

* DSU on bipartite-like row/column graph
* Connected components
* Grid connectivity via union find

---

## ✅ Small Code Note

In this code:

* `stone++` counts total stones
* `unionBySize(i, col)` merges row and column of each stone
* `component++` counts DSU roots that belong to stone-connected parts
* final answer is:

```text
stone - component
```
