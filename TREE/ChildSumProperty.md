# 🌳 Children Sum Property (Convert Binary Tree)

---

## 📌 Definition

> Modify the tree such that **every node follows:**

```text id="def1"
Node value = Left child + Right child
```

### ⚠️ Important Constraint

```text id="def2"
We can INCREASE node values (any number of times)
We CANNOT decrease any node value
```

---

## 🌲 Example (Before → After)

```id="cs-side"
Before Tree                     →        After Tree

        50                               86
      /    \                           /    \
     7      2                         55     31
    / \    / \                       /  \   /  \
   3   5  1   30                   50   5  1   30
```

👉 Now every node satisfies:

```text id="check"
Parent = Left + Right
```

---

## 🧠 Core Idea

* Traverse tree using **DFS (Recursion)**
* Fix violations **top-down**
* Then correct values **bottom-up**

---

## 🔁 Working Principle

### Step 1️⃣ (Top → Down)

At each node:

* Calculate sum of children

If:

```text id="cond1"
children >= node
```

👉 update node = children

Else:

```text id="cond2"
push parent value to children
```

👉 Increase child values (never decrease)

---

### Step 2️⃣ (Bottom → Up)

After recursion:

```text id="cond3"
node = left + right
```

---

## 🎯 Intuition

👉 Constraint drives the solution:

```text id="intu1"
Since we cannot decrease values,
we push values DOWN first
```

👉 Then:

```text id="intu2"
While backtracking, we fix parent using children
```

---

## 🔄 Two Phase Thinking

| Phase     | Direction      | Purpose           |
| --------- | -------------- | ----------------- |
| Top-down  | Parent → Child | Increase children |
| Bottom-up | Child → Parent | Fix parent        |

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

---

## ⚠️ Important Note

```text id="note1"
Only INCREMENT operations are allowed
```

---

## ❌ Common Mistakes

* ❌ Trying to decrease values
* ❌ Skipping push-down step
* ❌ Forgetting final recomputation

---

## 🎯 Interview Insight

👉 “Because values can only increase, I push values down first and then recompute parents while backtracking.”

---

## 🔥 Key Insight

```text id="key1"
Constraint → Algorithm design
```

---

## 🚀 Key Takeaways

* Two-phase recursion
* DFS + backtracking
* In-place modification
* Constraint-based logic

---

## 🔥 Pattern Connection

* Tree Modification
* DFS + Backtracking

---
