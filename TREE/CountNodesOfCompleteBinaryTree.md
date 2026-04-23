# 🌳 Count Nodes in Complete Binary Tree

---

## 📌 Definition

> Given a **complete binary tree**, count the total number of nodes.

---

## 🌲 What is a Complete Binary Tree?

> A binary tree where:

```text id="cbt-def"
All levels are completely filled except possibly the last level,
and the last level nodes are filled from LEFT to RIGHT
```

---

### 🔍 Example

```id="cbt-example"
        1
      /   \
     2     3
    / \   /
   4   5 6
```

👉 This is a **Complete Binary Tree** ✔

---

### ❌ Not Complete

```id="cbt-wrong"
        1
      /   \
     2     3
      \     \
       5     7
```

👉 Gaps appear before filling left → ❌

---

## 🌲 Example (Tree)

```id="cn-tree"
            1
         /     \
        2       3
       / \     / \
      4   5   6   7
     / \  / \  /
    9  8 10 11 12
```

---

## 👀 Output

```id="cn-out"
Total Nodes → 12
```

---

## 🧠 Core Idea

👉 Use properties of **Complete Binary Tree**

```text id="cn-key"
If left height == right height → tree is perfect
```

👉 For perfect tree:

```text id="cn-formula"
Nodes = 2^h - 1
```

---

## ❓ Why This Works?

In a **perfect binary tree**:

```id="cn-perfect"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

👉 All levels are completely filled

👉 So we can directly calculate nodes ✔

---

## 🔁 Working Principle

### Step 1️⃣ Calculate Heights

```text id="cn-step1"
Left height → go left till null
Right height → go right till null
```

---

### Step 2️⃣ Compare Heights

```text id="cn-step2"
If left == right → perfect tree
```

👉 Use:

```text id="cn-step3"
2^h - 1
```

---

### Step 3️⃣ Otherwise

```text id="cn-step4"
count(left) + count(right) + 1
```

---

## 🎯 Intuition

```id="cn-intuition"
Perfect subtree → use formula
Not perfect → break recursively
```

👉 Avoids full traversal

---

## 🔄 Flow

```id="cn-flow"
Check root:

If perfect → return 2^h - 1
Else → count(left) + count(right) + 1
```

---

## ⚡ Complexity

* **Time Complexity:** O(log² N)
* **Space Complexity:** O(log N)

---

## ❓ Why O(log² N)?

👉 For each node:

* Height calculation → O(log N)
* Recursive calls → O(log N)

---

## ⚠️ Important Notes

```text id="cn-note"
Works ONLY for Complete Binary Tree
```

---

## ❌ Common Mistakes

* ❌ Using this for normal tree
* ❌ Ignoring left-to-right filling rule
* ❌ Doing full traversal unnecessarily

---

## 🎯 Interview Insight

👉
“I use the structure of a complete binary tree. If left and right heights are equal, it's a perfect subtree and I apply 2^h - 1, otherwise I recurse.”

---

## 🔥 Key Insight

```text id="cn-insight"
Detect perfect subtree → avoid traversal
```

---

## 🚀 Key Takeaways

* Complete tree has strict structure
* Use height comparison
* Optimize using math
* Divide and conquer

---

## 🔥 Pattern Connection

* Count Nodes → Tree Optimization
* Height → Structural property
* Similar → Divide & Conquer

---
