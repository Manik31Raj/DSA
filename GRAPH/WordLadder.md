# 🧩 Word Ladder II (BFS + Backtracking)

---

## 📌 Problem

> Given a `startWord`, an `endWord`, and a dictionary `wordList`,
> find **all shortest transformation sequences** from start to end.

---

## 🔁 Transformation Rule

At each step:

* change **only one character**
* the new word must exist in the dictionary

---

## 🌲 Example

```text
startWord = "hit"
endWord   = "cog"
wordList  = ["hot","dot","dog","lot","log","cog"]
```

---

## ✅ Output

```text
hit → hot → dot → dog → cog
hit → hot → lot → log → cog
```

---

# 🔥 Core Idea

```text
BFS gives the shortest distance of every word from startWord
Then DFS backtracks from endWord to startWord using those distances
```

---

# 🧠 Main Trick

Instead of storing full paths in BFS:

* store only the **minimum level / step** of each word in a map
* then reconstruct all shortest paths using DFS

---

# 🔷 Why This Works

BFS guarantees:

* first time a word is reached = shortest distance

So if we store:

```text
map[word] = shortest steps from startWord
```

then we can later move **backward** from `endWord` to `startWord` by always going to a word whose step is exactly `1 less`.

---

# 🔁 Working Principle

---

## Step 1: BFS from `startWord`

Use queue to find shortest distance of every reachable word.

```text
map.put(startWord, 1)
```

Each next valid word gets:

```text
map.put(nextWord, steps + 1)
```

---

## Step 2: DFS from `endWord`

Start from `endWord` and go backward.

For the current word, try all one-letter transformations:

* if transformed word exists in `map`
* and `map[prevWord] + 1 == map[currWord]`
* then it is a valid parent in a shortest path

---

## Step 3: Build sequence backward

Keep adding words while going backward.

When we reach `startWord`, reverse the sequence and store it in answer.

---

# 🧠 Intuition

```text
BFS finds shortest distance
DFS rebuilds all shortest routes
```

So this is:

* **distance calculation**
* then **path reconstruction**

---

# 🔄 Example Flow

```text
hit → hot → dot → dog → cog
hit → hot → lot → log → cog
```

BFS may assign:

```text
hit = 1
hot = 2
dot = 3
lot = 3
dog = 4
log = 4
cog = 5
```

Then DFS from `cog` checks:

* `dog` because `dog + 1 = cog`
* `log` because `log + 1 = cog`

And continues backward.

---

# 🔷 Why `map` is Important

```text
map[word] = shortest level of that word
```

This helps us:

* know whether a word belongs to a shortest path
* avoid storing all paths during BFS

---

# 🔷 Why DFS is Used After BFS

Because DFS is perfect for:

* exploring all possible parent chains
* building sequences from end to start

---

# 🔷 Why `b = startWord`

In your code:

```java
b = startWord;
```

This is used as the stopping condition in DFS:

```java
if(word.equals(b))
```

Meaning:

* once we reach the start word, the current sequence is complete

---

# ⚠️ Important Note

In this version of the code:

```text
usedOnLevel is not actually needed
```

Because you are not storing paths in BFS.
You are only storing shortest distances in `map`.

---

# ❌ Common Mistakes

* ❌ Using DFS only for shortest path
* ❌ Storing full paths in BFS when not needed
* ❌ Forgetting to reverse sequence during backtracking
* ❌ Not checking `map.get(prev) + 1 == map[curr]`
* ❌ Confusing shortest path length with all shortest sequences

---

# ⚡ Complexity

## BFS Part

```text
O(N × L × 26)
```

Where:

* `N` = number of words
* `L` = word length

---

## DFS Backtracking Part

Depends on number of shortest paths, so it can be large.

```text
O(number of shortest sequences × path length)
```

---

# 🎯 Interview Insight

👉
“I first run BFS to assign the minimum distance of each reachable word from the start. Then I backtrack from the end word using DFS, following only those words whose distance is exactly one less. This reconstructs all shortest transformation sequences.”

---

# 🔥 Key Insight

```text
Word Ladder II = BFS for distance + DFS for path reconstruction
```

---

# 🚀 Key Takeaways

* BFS finds shortest levels
* `map` stores distance of each word
* DFS reconstructs all shortest paths
* Reverse sequence when reaching startWord
* This avoids storing full paths in BFS

---

# 🔥 Pattern Connection

* Shortest path in unweighted graph
* BFS + backtracking
* State-space search
* Path reconstruction from parent-like distance map

---
