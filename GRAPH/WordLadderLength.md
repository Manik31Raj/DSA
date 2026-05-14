# 🧩 Word Ladder

---

## 📌 Problem

> Given a `startWord`, an `endWord`, and a dictionary `wordList`,
> find the **minimum number of transformations** needed to change `startWord` into `endWord`.

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

## 🎯 Output

```text
hit → hot → dot → dog → cog
Length = 5
```

---

# 🔥 Core Idea

```text
Treat each word as a node in a graph
An edge exists if two words differ by exactly one character
```

Then find the **shortest path** from `startWord` to `endWord`.

---

# 🔷 Why BFS?

```text
BFS gives the shortest path in an unweighted graph
```

Here, every transformation costs `1`, so BFS is the correct choice.

---

# 🧠 Working Principle

## Step 1: Start from `startWord`

Put it into the queue with step count `1`.

---

## Step 2: Generate neighbors

For the current word:

* change every character position
* try all letters from `a` to `z`
* if the generated word exists in `wordList`, it is a valid next step

---

## Step 3: Mark visited

Once a word is used, remove it from `wordList`.

👉 This avoids revisiting the same word and prevents cycles.

---

## Step 4: Stop when `endWord` is found

The first time we reach `endWord` in BFS, that is the **minimum transformation length**.

---

# 🎯 Intuition

```text
Each word is a node
One-letter change is an edge
BFS explores transformation levels one by one
```

---

# 🔄 Example Flow

```text
hit
↓
hot
↓
dot / lot
↓
dog / log
↓
cog
```

---

# ⚠️ Important Notes

```text
If endWord is not reachable, return 0
```

Also, your code should call the correct method name:

```text
wordLadderLength(...)
```

not `wordLadder(...)`.

---

# ❌ Common Mistakes

* ❌ Using DFS instead of BFS
* ❌ Not removing visited words
* ❌ Forgetting to check all 26 letters
* ❌ Calling wrong method name
* ❌ Not handling unreachable endWord

---

# ⚡ Complexity

* **Time Complexity:** O(N × L × 26)
* **Space Complexity:** O(N)

Where:

* `N` = number of words in dictionary
* `L` = length of each word

---

## ❓ Why?

For each word:

* try each position
* try 26 characters
* each valid word is processed once

---

# 🎯 Interview Insight

👉
“I model the word list as an unweighted graph where words are nodes and one-letter transformations are edges. Then I use BFS to find the shortest transformation sequence.”

---

# 🔥 Key Insight

```text
Word Ladder = shortest path in word graph
```

---

# 🚀 Key Takeaways

* Use BFS
* Each word is a node
* One-letter difference makes an edge
* Remove visited words to avoid repeats
* First time reaching endWord gives shortest path

---

# 🔥 Pattern Connection

* BFS shortest path
* Unweighted graph traversal
* State-space search

---
