# 🌳 BST Iterator (Inorder Iterator)

---

## 📌 Problem

> Design an iterator over a **Binary Search Tree (BST)** that returns elements in **sorted order**.

---

## 🧠 Key Property

```text id="key-prop"
🔥 Inorder traversal of BST → ASCENDING sorted order 🔥
```

---

## 🎯 Goal

```text id="goal"
next()    → returns next smallest element  
hasNext() → checks if more elements exist  
```

---

## 🌲 Example

```id="iter-tree"
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

## 🧠 Core Idea

```text id="core"
Simulate inorder traversal using stack
```

---

## 🔷 How It Works

---

### 🔁 Initialization

```text id="init"
Push all LEFT nodes from root into stack
```

👉 Stack will contain smallest element on top

---

### 🔁 next()

```text id="next"
1. Pop top node  
2. Process it  
3. Push all left nodes of its RIGHT subtree  
```

---

### 🔁 hasNext()

```text id="hasnext"
Check if stack is not empty
```

---

## 🎯 Intuition

```id="intuition"
Stack maintains next smallest elements

Always go LEFT first
Then ROOT
Then RIGHT
```

---

## 🔄 Flow Example

```text id="flow"
Initial stack → [5 → 3 → 2 → 1]

next() → 1  
next() → 2  
next() → 3  
next() → 4  
...
```

---

## 🔥 Key Insight

```text id="insight"
Iterator does NOT store full traversal → works lazily
```

---

## ⚡ Complexity

* **Time Complexity:**

  * next() → O(1) amortized
  * hasNext() → O(1)

* **Space Complexity:** O(H)

---

## ❓ Why O(1) Amortized?

```text id="tc"
Each node is pushed and popped exactly once
```

---

## ⚠️ Important Notes

```text id="note"
Stack stores path from root to current node
```

---

## ❌ Common Mistakes

* ❌ Forgetting to push left subtree
* ❌ Pushing entire tree (wrong)
* ❌ Not handling right subtree
* ❌ Returning wrong order

---

## 🎯 Interview Insight

👉
“I simulate inorder traversal using a stack and process nodes lazily, ensuring O(1) amortized time per operation.”

---

## 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
BST Iterator = Controlled inorder traversal
```

---

## 🚀 Key Takeaways

* Uses stack to simulate recursion
* Returns elements in sorted order
* Efficient and lazy evaluation
* Only stores path, not full traversal

---

## 🔥 Pattern Connection

* Inorder traversal → sorted order
* Stack-based DFS
* Iterator design pattern

---
