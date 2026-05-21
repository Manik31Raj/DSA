# 🏝️ Number of Islands II (Dynamic Islands using DSU)

---

## 📌 Problem

> You are given a sequence of land additions in a grid.
> After each addition, return the **current number of islands**.

---

## 🧠 What makes this problem different?

In the normal island problem:

* the grid is already fixed
* we count islands once

Here:

* land is added one by one
* after every add, the island count may change

So we need a **dynamic** structure.

---

# 🔥 Core Idea

```text
Use DSU to merge newly added land cells with their nearby land cells
```

Every new land cell starts as a new island.

Then, if it touches existing islands, we merge them.

---

# 📌 What is an Island Here?

```text
A group of 1-cells connected in 4 directions
(up, down, left, right)
```

---

# 🔷 Why DSU?

DSU helps us quickly answer:

* are two land cells already in the same island?
* if not, merge them

This makes dynamic island counting efficient.

---

# 🔁 Working Principle

---

## Step 1: Add a new land cell

When a new position `(r, c)` comes:

* if it is already land, island count does not change
* otherwise:

  * mark it as land
  * increase island count by `1`

---

## Step 2: Check 4-direction neighbors

For the new land cell:

* up
* down
* left
* right

If a neighbor is already land:

* check whether both cells belong to different DSU sets
* if yes, union them
* reduce island count by `1`

---

## Step 3: Store answer after each operation

After every insertion, record the current number of islands.

---

# 🎯 Intuition

```text
Every new land starts as a separate island.
If it touches an existing island, they become one island.
```

So the count can:

* increase by `1`
* stay same
* decrease when islands merge

---

# 🌲 Example

Suppose cells are added like this:

```text
(0,0)
(0,1)
(1,1)
(1,0)
```

Then:

* `(0,0)` → 1 island
* `(0,1)` → merges with `(0,0)` → still 1 island
* `(1,1)` → new island → 2 islands
* `(1,0)` → connects both islands → 1 island

---

# 🔷 Why `visited` is used?

```text
visited[r][c] = true means land is already present
```

This helps us ignore duplicate insertions.

If the same cell comes again:

* no new island should be added
* just record the current count again

---

# 🔷 Mapping 2D cell to DSU node

Your code does:

```text
node = currR * c + currC
```

This converts a 2D position into a single DSU index.

---

# 🔄 Example of Mapping

For `c = 5`:

```text
(0,0) -> 0
(0,1) -> 1
(1,0) -> 5
(1,1) -> 6
```

This makes DSU indexing simple.

---

# ⚠️ Important Notes

```text
Only 4-direction connectivity is used
```

Diagonal cells are NOT connected.

---

# ❌ Common Mistakes

* ❌ Treating duplicate land insertion as new island
* ❌ Forgetting to check 4 neighbors
* ❌ Not using DSU to merge already-connected lands
* ❌ Incorrect 2D → 1D mapping
* ❌ Forgetting to reduce island count after union

---

# ⚡ Complexity

For each insertion:

* **Time Complexity:** almost O(1)
* **More precisely:** O(α(N))
* **Space Complexity:** O(R × C)

Where `α(N)` is inverse Ackermann function, almost constant.

---

# 🎯 Interview Insight

👉
“I treat each new land cell as a new island first. Then I check its 4-direction neighbors. If any neighbor is already land and belongs to a different DSU set, I union them and reduce the island count. This gives the number of islands after every insertion efficiently.”

---

# 🔥 Key Insight

```text
Dynamic island count = add land + merge neighboring sets using DSU
```

---

# 🚀 Key Takeaways

* New land increases island count by 1
* Adjacent existing land may reduce count after union
* DSU is ideal for dynamic connectivity
* Duplicate cells must be ignored

---

# 🔥 Pattern Connection

* DSU
* Dynamic connectivity
* Incremental connected components
* Grid union problems

---

## ✅ Small Code Note

In this code:

* `visited[currR][currC]` checks duplicate insertions
* `node = currR * c + currC` maps grid cell to DSU node
* `island += 1` adds a new island
* union with 4-direction neighbors may reduce island count
* `ans.add(island)` stores the island count after each operation
