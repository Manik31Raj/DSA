# 🌳 Recover Binary Search Tree (RecoverBST)

---

## 📌 Problem

> Two nodes in a BST are swapped by mistake.
> Restore the BST **without changing structure**.

---

## 🧠 Key Property

```text id="key-prop"
🔥 Inorder traversal of BST → ASCENDING sorted order 🔥
```

👉 If BST is valid → inorder is sorted
👉 If NOT → there will be **violations**

---

## ❌ Example (Swapped BST)

```text id="invalid"
Inorder: 2 5 7 10 12 18 15 25 30 ...
                      ↑   ↑
                 violation
```

---

## 🎯 Goal

```text id="goal"
Identify the two swapped nodes and fix them
```

---

# 🔥 Core Idea

```text id="core"
Find violations in inorder traversal
```

---

## 🧠 What is a Violation?

```text id="violation"
prev.data > current.data
```

👉 This should NEVER happen in BST

---

# 🔷 Case 1: Non-Adjacent Swap

---

## 🧠 Pattern

```text id="case1"
first violation → first = prev, middle = curr  
second violation → last = curr
```

---

## 🔄 Example

```text id="case1-ex"
... 10 25 15 30 ...

Violations:
25 > 15
```

👉 Swap:

```text id="case1-fix"
first ↔ last
```

---

# 🔷 Case 2: Adjacent Swap

---

## 🧠 Pattern

```text id="case2"
Only one violation:
first = prev  
middle = curr
```

---

👉 Swap:

```text id="case2-fix"
first ↔ middle
```

---

# 🔷 Approach 1: Recursive 

---

## 🧠 Idea

👉 Perform inorder traversal
👉 Track:

```text id="track"
first, middle, last, prev
```

---

## 🔁 Steps

1. Traverse left
2. Check violation
3. Update pointers
4. Traverse right
5. Swap nodes after traversal

---

## 🎯 Intuition

```text id="rec-int"
Inorder should be sorted → find where it breaks
```

---

# 🔷 Approach 2: Morris Traversal (Optimal)

---

## 🧠 Idea

```text id="morris-core"
Use Morris traversal → no recursion, no stack
```

---

👉 Same violation logic, but:

```text id="morris-adv"
Space = O(1)
```

---

## 🎯 Key Benefit

```text id="benefit"
Avoid recursion stack
```

---

# ⚖️ Comparison

---

## 📊 Table

| Approach  | Time | Space | Difficulty |
| --------- | ---- | ----- | ---------- |
| Recursion | O(N) | O(H)  | Easy       |
| Morris    | O(N) | O(1)  | Medium     |

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:**

  * Recursion → O(H)
  * Morris → O(1)

---

## ❓ Why O(N)?

```text id="tc"
Each node is visited exactly once
```

---

# ⚠️ Important Notes

```text id="note"
Do NOT change tree structure → only swap values
```

---

# ❌ Common Mistakes

* ❌ Trying to rebuild tree
* ❌ Not detecting both violations
* ❌ Forgetting adjacent case
* ❌ Not resetting global variables

---

# 🎯 Interview Insight

👉
“I use inorder traversal to detect violations in sorted order. Based on whether nodes are adjacent or not, I swap either first-last or first-middle.”

---

# 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
BST recovery = fix broken inorder sequence
```

---

# 🚀 Key Takeaways

* Inorder must be sorted
* Violations indicate swapped nodes
* Two cases: adjacent / non-adjacent
* Morris gives optimal space

---

# 🔥 Pattern Connection

* Inorder traversal → sorted order
* BST validation problems
* Similar → Kth smallest, successor

---
