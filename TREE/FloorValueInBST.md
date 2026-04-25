# 🌳 Floor in Binary Search Tree

---

## 📌 Definition

> The **Floor** of a given key is the **largest value in the BST that is ≤ key**

---

## 🧠 Example

```id="floor-tree"
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

```id="floor-query"
Key = 5
```

```text id="floor-ans"
Floor = 4
```

---

## 🧠 Core Idea

```text id="floor-core"
Use BST property to find closest smaller value
```

---

## 🔁 Working Principle

At each node:

```text id="floor-logic"
If node == key → answer found  
If node < key → possible floor → go RIGHT  
If node > key → ignore → go LEFT  
```

---

## 🎯 Intuition

```id="floor-intuition"
Search 5:

8 → go Left
3 → candidate (floor = 3) → go Right
6 → go Left
4 → better candidate (floor = 4)
```

👉 Final answer = **4**

---

## 🔄 Flow

```text id="floor-flow"
Initialize floor = -1

Traverse:
- Update floor when node < key
- Move right to maximize
- Move left when node > key
```

---

## ⚡ Complexity

* **Time Complexity:** O(H)
* **Space Complexity:** O(1)

---

## ❓ Why O(H)?

```text id="floor-tc"
Only one path is explored using BST property
```

---

## ⚠️ Important Notes

```text id="floor-note"
If no value ≤ key → return -1
```

---

## 🔄 Ceil vs Floor (Quick View)

| Concept | Condition        | Direction |
| ------- | ---------------- | --------- |
| Ceil    | ≥ key (smallest) | Go LEFT   |
| Floor   | ≤ key (largest)  | Go RIGHT  |

---

## ❌ Common Mistakes

* ❌ Not updating floor correctly
* ❌ Searching both subtrees
* ❌ Returning first smaller instead of largest smaller

---

## 🎯 Interview Insight

👉
“I traverse the BST and keep track of the largest value less than or equal to the key by moving right whenever possible.”

---

## 🔥 Key Insight

```text id="floor-key"
Whenever node < key → store it and try to find larger one on right
```

---

## 🚀 Key Takeaways

* Mirror of Ceil problem
* Move right to maximize answer
* Track best candidate
* Efficient due to BST property

---

## 🔥 Pattern Connection

* Ceil in BST → opposite logic
* BST Search → same traversal
* Binary Search → similar thinking

---
