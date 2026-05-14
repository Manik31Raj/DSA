# 🧩 Word Ladder II (Find All Shortest Sequences)

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

👉 These are the **shortest sequences**

---

# 🔥 Core Idea

```text
Use BFS to explore level by level
Store complete paths in the queue
```

---

# 🧠 Why BFS?

```text
BFS guarantees shortest length first
```

So the first time we reach `endWord`, we know:

* sequence length is minimum
* all other sequences of same length may still exist in the same level

---

# 🔷 Main Difference from Word Ladder I

In Word Ladder I:

* we only needed shortest length

In Word Ladder II:

* we need **all shortest paths**
* so we must store the **entire path sequence** in BFS

---

# 🔁 Working Principle

---

## Step 1: Queue stores paths

Instead of storing just words, store:

```text
["hit", "hot", "dot"]
```

So each queue element is one full transformation path.

---

## Step 2: Generate next words

For the last word in the current path:

* try changing each character
* try all letters from `a` to `z`
* if the new word exists in `wordList`, add it to the path

---

## Step 3: Track words used at current level

```text
usedOnLevel
```

This is very important.

👉 We do **not** remove words from `wordList` immediately.
We remove them only after the current BFS level ends.

---

# ❓ Why remove words only after level ends?

Because there may be **multiple shortest paths** reaching the same word in the same level.

If we remove too early:

* we may lose valid shortest sequences

So we keep a temporary list:

```text
usedOnLevel
```

and remove those words only when we move to the next level.

---

# 🎯 Intuition

```text
BFS level = transformation length
All shortest answers are found in the first level where endWord appears
```

---

# 🔄 Example Flow

```text
hit
↓
hot
↓
dot   lot
↓
dog   log
↓
cog
```

Both paths have same length, so both are valid answers.

---

# ⚠️ Important Notes

```text
Stop collecting paths once paths become longer
than the first found shortest path
```

In your code:

```java
if(seq.size()==0){
    seq.add(arr);
}else if(seq.get(0).size()==arr.size()){
    seq.add(arr);
}
```

This keeps only shortest sequences.

---

# ❌ Common Mistakes

* ❌ Using DFS instead of BFS
* ❌ Removing words from dictionary too early
* ❌ Forgetting to store full paths
* ❌ Returning longer paths after shortest path is found
* ❌ Not handling multiple shortest sequences

---

# ⚡ Complexity

* **Time Complexity:** High, depends on number of paths
* **Space Complexity:** High, because full paths are stored in queue

More precisely:

```text
O(number of paths × word length × 26)
```

---

# 🎯 Interview Insight

👉
“I use BFS because I need all shortest transformation sequences. I store full paths in the queue and remove words only after finishing a BFS level so that multiple shortest paths are not lost.”

---

# 🔥 Key Insight

```text
Word Ladder II = BFS + path storage + level-wise pruning
```

---

# 🚀 Key Takeaways

* BFS finds shortest paths
* Store full sequence in queue
* Remove visited words after each level
* Keep all sequences with same minimum length

---

# 🔥 Pattern Connection

* Shortest path in unweighted graph
* State-space BFS
* Level-wise pruning

---
