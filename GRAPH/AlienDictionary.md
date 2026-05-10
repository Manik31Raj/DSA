# 🗣️ Alien Dictionary

---

## 📌 Problem

> Given a sorted dictionary of an alien language, find the **order of characters**.

---

## 🧠 Key Idea

```text
From the given sorted words,
find ordering constraints between characters
```

---

# 🔷 Why This Works

If the dictionary is already sorted, then for every adjacent pair of words:

* the first different character tells us the ordering rule
* that becomes a directed edge in the graph

---

## 🌲 Example Words

```text id="words"
wrt
wrf
er
ett
rftt
rfzz
zg
zga
zgb
zx
```

---

# 🔥 Core Observation

For two adjacent words:

```text
word1 = "wrt"
word2 = "wrf"
```

First mismatch:

```text
t → f
```

So:

```text
t comes before f
```

---

# 🔷 Graph Construction

---

## 🧠 Rule

For every adjacent pair of words:

* compare character by character
* find the first mismatch
* create edge `char1 → char2`

---

## ❗ Invalid Prefix Case

Example:

```text
abc
ab
```

This is invalid because:

* first word is longer
* second word is its prefix
* but first word appears before prefix word

👉 This cannot happen in a valid sorted dictionary.

---

## ✅ In Your Code

```text id="prefix"
if (!found && s1.length() > s2.length()) return false;
```

👉 This detects the invalid prefix case.

---

# 🔷 Directed Graph Meaning

If we add edge:

```text
u → v
```

It means:

```text
u must come before v
```

---

# 🔷 Topological Sorting

Once the graph is built, the character order is found using **Kahn’s Algorithm**.

---

## 🧠 Why Topological Sort?

Because alien language order is nothing but a **dependency order**.

If:

```text
a → b
b → c
```

Then final order must respect that:

```text
a before b before c
```

---

# 🔁 Working Principle

---

## Step 1: Build graph

From adjacent words, extract ordering constraints.

---

## Step 2: Compute indegree

```text
indegree[node] = number of incoming edges
```

Characters with indegree `0` can appear first.

---

## Step 3: Use queue

Push all indegree `0` nodes into queue.

---

## Step 4: Process in order

* remove node from queue
* add it to answer
* reduce indegree of its neighbors
* if indegree becomes `0`, push it to queue

---

# 🎯 Intuition

```text
Graph edges represent character precedence
Topological sort gives valid alien alphabet order
```

---

# 🔄 Example Constraints from Your Input

From adjacent words:

```text
wrt → wrf   => t → f
wrf → er    => w → e
er  → ett   => r → t
ett → rftt  => e → r
rftt → rfzz => t → z
rfzz → zg   => r → z
zg  → zga   => g → a
zga → zgb   => a → b
zgb → zx    => b → x
```

These form the alien ordering constraints.

---

# ⚡ Complexity

* **Time Complexity:** O(N + K)
* **Space Complexity:** O(K + E)

Where:

* `N` = total characters in all words
* `K` = number of unique characters
* `E` = number of ordering constraints

---

# ⚠️ Important Notes

```text
This only works if the dictionary order is valid
```

If there is a cycle, alien ordering is not possible.

---

# ❌ Common Mistakes

* ❌ Comparing entire words instead of first mismatch
* ❌ Forgetting invalid prefix case
* ❌ Not building graph correctly
* ❌ Ignoring cycle detection

---

# 🎯 Interview Insight

👉
“I compare adjacent words and use the first different character to build a directed graph of character precedence. Then I run topological sort to get the alien dictionary order.”

---

# 🔥 Key Insight

```text
Alien Dictionary = Graph of character precedence + Topological Sort
```

---

# 🚀 Key Takeaways

* Compare adjacent words only
* First mismatch gives ordering
* Prefix case can make input invalid
* Topological sort gives answer
* Cycle means no valid alien order

---

# 🔥 Pattern Connection

* Topological sorting
* Dependency graph
* Kahn’s algorithm
* Directed acyclic graph

---
