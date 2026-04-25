# 🌳 Ceil in Binary Search Tree

---

## 📌 Definition

> The **Ceil** of a given key is the **smallest value in the BST that is ≥ key**

---

## 🧠 Example

```id="ceil-tree"
        8
      /   \
     3     10
    / \      \
   1   6      14
      / \     /
     4   7   13
```

---

## 🎯 Example Query

```id="ceil-query"
Key = 9
```

```text id="ceil-ans"
Ceil = 10
```

---

## 🧠 Core Idea

```text id="ceil-core"
Use BST property to minimize search space
```

---

## 🔁 Working Principle

At each node:

```text id="ceil-logic"
If node == key → answer found  
If node > key → possible ceil → go LEFT  
If node < key → ignore → go RIGHT  
```

---

## 🎯 Intuition

```id="ceil-intuition"
Search 9:

8  → go Right
10 → candidate (ceil = 10) → go Left (to find smaller)
```

👉 Final answer = **10**

---

## 🔄 Flow

```text id="ceil-flow"
Initialize ceil = -1

Traverse tree:
- Update ceil when node > key
- Move left to minimize
- Move right when node < key
```

---

## ⚡ Complexity

* **Time Complexity:** O(H)
* **Space Complexity:** O(1)

---

## ❓ Why O(H)?

```text id="ceil-tc"
Only one path is traversed using BST property
```

---

## ⚠️ Important Notes

```text id="ceil-note"
If no value ≥ key → return -1
```

---

## ❌ Common Mistakes

* ❌ Searching both sides (unnecessary)
* ❌ Not updating ceil properly
* ❌ Returning first greater instead of smallest greater

---

## 🎯 Interview Insight

👉
“I traverse the BST and keep track of the smallest value greater than or equal to the key by moving left when possible.”

---

## 🔥 Key Insight

```text id="ceil-key"
Whenever node > key → store it and try to find smaller one on left
```

---

## 🚀 Key Takeaways

* Use BST property
* Move left to minimize answer
* Track best candidate
* Single path traversal

---

## 🔥 Pattern Connection

* Floor in BST → opposite logic
* BST Search → same traversal
* Binary Search → similar idea

---
