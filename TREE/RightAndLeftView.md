# 🌳 Left View & Right View of Binary Tree

---

## 📌 Definition

### 🔹 Left View

> Nodes visible when the tree is viewed from the **left side**

### 🔹 Right View

> Nodes visible when the tree is viewed from the **right side**

---

## 🌲 Example Tree

```id="lr-tree"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 👀 Visual Understanding

### 👉 Left View

```id="lv"
1 → 2 → 4
```

* First node at each level (from left)

---

### 👉 Right View

```id="rv"
1 → 3 → 7
```

* Last node at each level (from right)

---

## 🧠 Core Idea

* Traverse tree **level by level (BFS)**
* For each level:

  * Pick **first node** → Left View
  * Pick **last node** → Right View

---

## 🔁 Working Principle

1. Use **Queue (BFS)**
2. For each level:

   * Get size of current level
   * Traverse all nodes in that level
3. Based on position:

   * First node → Left View
   * Last node → Right View

---

## 🎯 Intuition

Think level-wise:

```id="levels"
Level 1 → [1]
Level 2 → [2, 3]
Level 3 → [4, 5, 6, 7]
```

* Left View → first element of each level
* Right View → last element of each level

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(N)

---

## ⚠️ Important Note (Your Code)

Your current approach uses:

```text
TreeMap + level index
```

👉 This works but is **not the standard or safest approach**

### ❌ Issues:

* Depends on insertion order
* Can break in complex trees
* Not true “view” logic

---

## ✅ Recommended Approach

Use **level-based BFS**:

* More intuitive
* More reliable
* Matches problem definition exactly

---

## 🔄 Key Difference

| View       | Selection Rule           |
| ---------- | ------------------------ |
| Left View  | First node at each level |
| Right View | Last node at each level  |

---

## ⚠️ Common Mistakes

* Confusing with Top/Bottom view
* Using horizontal distance incorrectly
* Not tracking level size
* Overwriting values incorrectly

---

## 🎯 Interview Insight

Best explanation:

👉 “I perform level order traversal and pick the first node for left view and the last node for right view at each level.”

---

## 🚀 Key Takeaways

* Views are **level-based problems**
* BFS is the best approach
* Focus on **position within level**
* Different from vertical view problems

---

## 🔥 Pattern Connection

* Top View → vertical (x-axis)
* Bottom View → vertical (x-axis)
* Left/Right View → level-based

---
