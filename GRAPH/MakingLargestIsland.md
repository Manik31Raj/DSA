# 🏝️ Making a Large Island

---

## 📌 Problem

> Given a binary grid:

* `1` → land
* `0` → water

You are allowed to **change at most one `0` into `1`**.
Find the **largest possible island size**.

---

## 🌲 Example Grid

```text
1 1 0 1 1
1 1 0 1 1
1 1 0 1 1
0 0 1 0 0
0 0 1 1 1
0 0 1 1 1
```

---

## 🎯 Goal

```text
Find the maximum island size after converting one 0 into 1
```

---

# 🔥 Core Idea

```text
First build all existing islands using DSU.
Then for every 0-cell, check which unique neighboring islands can be merged.
```

So this becomes:

1. **DSU to store island components**
2. **Try flipping every 0**
3. **Take the best possible merged size**

---

# 🧠 Why DSU?

DSU helps us quickly know:

* which land cells belong to the same island
* the size of each island component

That makes merging nearby islands very fast.

---

# 🔷 Working Principle

---

## Step 1: Merge all existing land cells

For every `1` cell:

* check its 4-direction neighbors
* if neighbor is also `1`
* union them in DSU

After this step, every island is represented by one DSU parent.

---

## Step 2: Try changing each `0` to `1`

For every water cell:

* look at all 4 neighbors
* collect the **unique DSU parents** of neighboring land cells
* sum the sizes of those unique components
* add `1` for the flipped cell itself

This gives the island size if we convert that `0`.

---

## Step 3: Keep the maximum

Take the maximum over all possible zero flips.

---

# 🎯 Intuition

```text
A 0-cell can connect multiple islands.
If we flip it to 1, all unique neighboring islands merge into one larger island.
```

---

# 🔄 Why HashSet?

When a zero cell touches multiple neighbors from the **same island**, we must count that island only once.

So we use:

```text
Set<Integer> set
```

to store unique DSU parents.

This avoids double counting.

---

# 🌲 Example Thinking

Suppose a zero cell has neighboring island sizes:

* component A = 4
* component B = 6
* component A again from another side

Then the merged size is:

```text
4 + 6 + 1 = 11
```

not:

```text
4 + 6 + 4 + 1
```

That is why `Set` is necessary.

---

# 🔷 Meaning of `size[]` in DSU

```text
size[root] = number of cells in that island
```

So when we merge components, the size of the new root is updated.

---

# 🔷 Why `maxSize` Starts at 1?

```text
If no merge is possible, flipping one 0 still creates an island of size 1
```

So minimum answer can be `1`.

---

# ⚠️ Important Notes

```text
Only 4-direction connectivity is used:
Up, Down, Left, Right
```

Diagonal cells are **not connected**.

---

# ❌ Common Mistakes

* ❌ Double counting the same island from multiple neighbors
* ❌ Forgetting to add `1` for the flipped zero cell
* ❌ Using diagonal connectivity by mistake
* ❌ Not merging existing land cells first
* ❌ Not updating island size after DSU union

---

# ⚡ Complexity

* **Time Complexity:** O(R × C × α(RC))
* **Space Complexity:** O(R × C)

Where `α` is inverse Ackermann function, almost constant.

---

# 🎯 Interview Insight

👉
“I first build all islands using DSU. Then for every zero cell, I look at its four neighbors, collect unique island parents using a set, and sum their sizes plus one for the flipped cell. The maximum of all such possibilities is the answer.”

---

# 🔥 Key Insight

```text
Largest island = existing DSU islands + best zero flip merge
```

---

# 🚀 Key Takeaways

* DSU groups all existing islands
* Zero cell can connect multiple islands
* Use Set to avoid double counting
* Add 1 for the flipped cell
* Take maximum over all zero cells

---

# 🔥 Pattern Connection

* DSU on grid
* Connected components
* Island merging
* Grid union problems

---

## ✅ Small Code Note

In this code:

* first loop builds DSU islands from existing `1`s
* second loop tries every `0`
* `set.add(par)` ensures unique neighboring islands only
* `currSize + 1` accounts for flipping the zero itself
* `maxSize` stores the best answer
