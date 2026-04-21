# 🌳 Same Tree (Check if Two Trees are Identical)

---

## 📌 Definition

Two binary trees are **identical (same)** if:

> They have the **same structure** and **same node values**.

---

## 🌲 Example (Same Trees)

```id="same1"
Tree 1            Tree 2

    1                1
   / \              / \
  2   3            2   3
```

✔️ Same structure + same values → **Identical**

---

## 🌲 Example (Not Same)

```id="same2"
Tree 1            Tree 2

    1                1
   /                  \
  2                    2
```

❌ Structure is different → **Not identical**

---

## 🧠 Core Idea

Compare both trees **node by node**:

* Values must be equal
* Structure must match

---

## 🔁 Working Principle

At each step:

1. Compare current nodes
2. Recursively check:

   * Left subtree
   * Right subtree

---

## ⚡ Base Conditions

* Both nodes null → ✅ same
* One null, one not → ❌ not same
* Values different → ❌ not same

---

## 🔄 Recursive Condition

```id="same-rule"
p.data == q.data
AND
left subtree same
AND
right subtree same
```

---

## 🎯 Intuition

Think of it as:

👉 “Walk both trees together in sync”

* Step left together
* Step right together
* Compare at every step

---

## 📦 Recursion Behavior

* Traverses both trees simultaneously
* Stops immediately if mismatch found

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

Where:

* N = number of nodes
* H = height of tree

---

## ⚠️ Common Mistakes

* Only comparing values (ignoring structure)
* Not handling null cases properly
* Checking only one subtree

---

## 🎯 Interview Insight

Best explanation:

👉 “I recursively compare both trees node by node. If both nodes are null, they match. If values differ or structure differs, I return false.”

---

## 🚀 Key Takeaways

* Must match **structure + values**
* Traverse both trees simultaneously
* Classic recursion problem

---

## 🔥 Pattern Connection

This is closely related to:

* **Symmetric Tree** → mirror comparison
* **Subtree check** → partial comparison

---
