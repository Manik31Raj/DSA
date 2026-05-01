# 🌳 Inorder Successor & Predecessor in BST

---

## 📌 Problem

> Find the **Inorder Successor** and **Inorder Predecessor** of a given node in a BST.

---

## 📌 Definition

```text id="def"
Successor   → Next greater element  
Predecessor → Next smaller element
```

---

## 🧠 Key Property

```text id="key-prop"
🔥 Inorder traversal of BST → ASCENDING sorted order 🔥
```

👉 So:

```text id="relation"
Successor   = next element in inorder  
Predecessor = previous element in inorder  
```

---

## 🌲 Example

```id="succ-tree"
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

## 🎯 Example Query

```text id="query"
Key = 4
```

```text id="ans"
Successor   = 5  
Predecessor = 3
```

---

# 🔷 Inorder Successor

---

## 🧠 Core Idea

```text id="succ-core"
Find smallest node > key
```

---

## 🔁 Working Principle

```text id="succ-logic"
If root > key → candidate → go LEFT  
Else → go RIGHT
```

---

## 🎯 Intuition

```text id="succ-int"
Move left to minimize greater value
```

---

# 🔷 Inorder Predecessor

---

## 🧠 Core Idea

```text id="pred-core"
Find largest node < key
```

---

## 🔁 Working Principle

```text id="pred-logic"
If root < key → candidate → go RIGHT  
Else → go LEFT
```

---

## 🎯 Intuition

```text id="pred-int"
Move right to maximize smaller value
```

---

# 🔄 Flow Summary

```text id="flow"
Successor   → move LEFT when greater  
Predecessor → move RIGHT when smaller
```

---

# ⚡ Complexity

* **Time Complexity:** O(H)
* **Space Complexity:** O(1)

---

## ❓ Why O(H)?

```text id="tc"
Only one path is traversed using BST property
```

---

# ⚠️ Important Notes

```text id="note"
Works efficiently only for BST
```

---

# ❌ Common Mistakes

* ❌ Traversing full tree (O(N))
* ❌ Not updating candidate
* ❌ Confusing successor with right child directly
* ❌ Not handling null case

---

# 🎯 Interview Insight

👉
“I use BST property to track the closest greater and smaller values while traversing from root.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="insight"
Successor = smallest greater  
Predecessor = largest smaller
```

---

# 🚀 Key Takeaways

* Based on inorder ordering
* Single path traversal
* Maintain candidate during traversal
* Efficient O(H) solution

---

# 🔥 Pattern Connection

* Floor & Ceil → similar logic
* BST Search → same traversal
* Binary Search concept

---
