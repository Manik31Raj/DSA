# 🏝️ Number of Distinct Islands

---

## 📌 Problem

> Given a binary matrix:

* `0` → water
* `1` → land

Find the number of **distinct island shapes**.

👉 Two islands are considered same if their shapes are identical after translation.

---

# 📌 What is a Distinct Island?

```text id="def"
Two islands are distinct if their structures/shapes are different
```

---

## 🌲 Example Map

```text
1 1 0 1 1 0 0 1
1 0 0 0 1 0 1 1
0 0 1 0 0 0 0 0
1 1 1 0 1 1 0 0
0 0 0 0 1 0 0 1
1 1 0 0 0 0 1 1
1 1 0 1 1 0 0 1
```

---

# 🧠 Core Idea

```text id="core"
Store island shape instead of actual positions
```

---

# 🔥 Key Observation

```text id="obs"
Absolute positions do NOT matter
Only relative structure matters
```

---

## 🎯 Example

### Island 1

```text id="is1"
1 1
1 0
```

---

### Island 2

```text id="is2"
0 0 1 1
0 0 1 0
```

👉 Same shape
👉 Just shifted in position

---

# 🔷 How Shape is Stored?

---

## 🧠 Trick

Instead of storing actual coordinates:

```text id="trick"
Store relative coordinates from starting cell
```

---

## 🎯 Example

Suppose BFS starts at:

```text id="start"
(sr, sc) = (3,4)
```

---

## Relative Coordinates

```text id="relative"
(0,0)
(sr-row, sc-col)
```

---

## Example Shape Storage

```text id="shape"
[(0,0), (0,-1), (-1,0)]
```

👉 This uniquely represents shape

---

# 🔷 Why HashSet?

```text id="hashset"
HashSet automatically removes duplicate island shapes
```

---

# 🔷 Why `equals()` and `hashCode()` Needed?

---

## ❓ Problem

`HashSet` compares objects using:

```text id="compare"
hashCode()  
equals()
```

---

## ⚠️ Without overriding them

```text id="problem"
Two Index objects with same x,y
would still be treated different
```

---

## Example

```text id="eg"
new Index(1,2)
new Index(1,2)
```

Without override:

```text id="wrong"
Considered DIFFERENT objects ❌
```

---

# ✅ `equals()` Purpose

```text id="equals"
Checks logical equality of coordinates
```

👉 Returns true if:

```text id="eq"
x == other.x AND y == other.y
```

---

# ✅ `hashCode()` Purpose

```text id="hash"
Generates same hash for same coordinates
```

👉 Required for correct HashSet behavior

---

# 🔥 Very Important Rule

```text id="rule"
If equals() overridden,
hashCode() must also be overridden
```

---

# 🔷 Can We Use String Instead of Index?

## ✅ YES

Instead of:

```text id="index"
ArrayList<Index>
```

We can store:

```text id="string"
"0,0#0,-1#-1,0"
```

---

# 🔄 Index vs String

| Method       | Advantage         | Disadvantage         |
| ------------ | ----------------- | -------------------- |
| Index Object | Cleaner structure | Need equals/hashCode |
| String       | Easier hashing    | Less structured      |

---

# 🔷 BFS Working

---

## 🔁 Steps

1. Traverse matrix
2. If unvisited land found:

```text id="steps"
- Start BFS  
- Store relative coordinates  
- Add shape into HashSet
```

---

# 🎯 Intuition

```text id="intuition"
Normalize every island shape relative to starting point
```

---

# ⚡ Complexity

* **Time Complexity:** O(N × M)
* **Space Complexity:** O(N × M)

---

## ❓ Why?

```text id="tc"
Each cell visited once
```

---

# ⚠️ Important Notes

```text id="note"
Only relative structure matters
```

---

# ❌ Common Mistakes

* ❌ Storing absolute coordinates
* ❌ Forgetting visited array
* ❌ Not overriding equals/hashCode
* ❌ Comparing object references directly

---

# 🎯 Interview Insight

👉
“I store island shapes using relative coordinates so identical shifted islands generate the same structure representation.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Distinct island = unique relative shape
```

---

# 🚀 Key Takeaways

* Relative coordinates normalize shape
* HashSet removes duplicates
* equals/hashCode required for custom objects
* BFS/DFS both work

---

# 🔥 Pattern Connection

* Number of islands
* Connected components
* Shape normalization problems

---
