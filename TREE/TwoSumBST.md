# 🌳 Two Sum in BST (Two Pointer using Iterators)

---

## 📌 Problem

> Check if there exist **two nodes in BST whose sum = target**

---

## 🧠 Key Property

```text id="key-prop"
🔥 Inorder traversal → ASCENDING sorted order 🔥
```

👉 So BST behaves like a **sorted array**

---

## 💡 Core Idea

```text id="core"
Use two pointers:
Left iterator  → smallest values  
Right iterator → largest values
```

👉 Exactly like **Two Sum in sorted array**

---

## 🌲 Example

```id="twosum-tree"
            5
         /     \
        3       7
       / \     / \
      2   4   6   9
     /             \
    1               10
                   /
                  8
```

---

## 🎯 Target

```text id="target"
Target = 15
```

---

## 🔁 Working Principle

1. Initialize:

```text id="init"
l → smallest (inorder iterator)
r → largest (reverse inorder iterator)
```

---

2. Compare:

```text id="logic"
If l + r == target → found  
If l + r < target → move left iterator forward  
If l + r > target → move right iterator backward  
```

---

3. Stop when:

```text id="stop"
l >= r
```

---

## 🎯 Intuition

```text id="intuition"
Like two pointers on sorted array
```

---

# 🔷 BSTIterator (Important)

---

## 🧠 Idea

```text id="iterator"
Simulates inorder (ascending) OR reverse inorder (descending)
```

---

## 🔄 Modes

| Mode            | Traversal                       |
| --------------- | ------------------------------- |
| reverse = false | Inorder (small → large)         |
| reverse = true  | Reverse inorder (large → small) |

---

# 🔷 Approach 1: Boolean Check

---

## 🎯 Goal

```text id="bool-goal"
Return true if pair exists
```

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

---

## ❓ Why O(N)?

```text id="bool-tc"
Each node is visited at most once by iterators
```

---

# 🔷 Approach 2: Return Pair

---

## 🎯 Goal

```text id="pair-goal"
Return actual nodes forming the target sum
```

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

---

## ❓ Why Same Complexity?

```text id="pair-tc"
Still using two iterators → same traversal cost
```

---

# ⚠️ Important Notes

```text id="note"
Stop when i >= j to avoid same node reuse
```

---

# ❌ Common Mistakes

* ❌ Using full traversal + hashmap (extra space)
* ❌ Not using BST property
* ❌ Allowing same node twice
* ❌ Incorrect iterator movement

---

# 🎯 Interview Insight

👉
“I use two BST iterators to simulate two pointers on a sorted array, achieving O(N) time and O(H) space without extra storage.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
BST + Iterator = Sorted array behavior
```

---

# 🚀 Key Takeaways

* Convert BST → sorted behavior
* Two pointer technique applies
* Space optimized vs hashmap
* Clean and interview-friendly

---

# 🔥 Pattern Connection

* Two Sum → sorted array
* BST Iterator → inorder simulation
* Binary Search Tree problems

---
