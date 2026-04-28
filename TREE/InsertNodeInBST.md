# 🌳 Insert Node in Binary Search Tree (BST)

---

## 📌 Problem

> Insert a new node into a **Binary Search Tree** while maintaining BST properties.

---

## 🌳 What is BST Rule?

```text id="bst-rule"
Left subtree < Root < Right subtree
```

👉 This rule must remain valid after insertion

---

## 🌲 Example (Before → After)

```id="bst-insert"
Before Tree                →        After inserting 10

        4                           4
      /   \                       /   \
     2     7                     2     7
    / \                           / \     \
   1   3                         1   3     10
```

---

## 🧠 Core Idea

```text id="core"
Follow BST property to find correct position
```

---

## 🔁 Working Principle

At each node:

```text id="logic"
If value > node → go RIGHT  
If value < node → go LEFT  
```

👉 Stop when null position is found
👉 Insert new node there

---

# 🔷 Approach 1: Recursive

---

## 🧠 Idea

👉 Traverse tree recursively

---

## 🔁 Steps

1. If root is null → create node
2. If value > root → insert in right subtree
3. If value < root → insert in left subtree
4. Return root

---

## 🎯 Intuition

```text id="rec-int"
Keep going down until you find empty spot
```

---

# 🔷 Approach 2: Iterative

---

## 🧠 Idea

👉 Use loop instead of recursion

---

## 🔁 Steps

1. Start from root
2. Traverse until null position
3. Insert node directly

---

## ⚠️ Important Detail

```text id="iter-note"
If curr.data <= value → go RIGHT
```

👉 Means duplicates go to **right subtree** .But in general same nodes are not given.

---

## 🎯 Intuition

```text id="iter-int"
Move like binary search until insertion point
```

---

# ⚡ Complexity

* **Time Complexity:** O(H)
* **Space Complexity:**

  * Recursive → O(H)
  * Iterative → O(1)

---

## ❓ Why O(H)?

```text id="tc"
Only one path from root to leaf is traversed
```

---

# ⚠️ Important Notes

```text id="note"
BST structure must be preserved
```

👉 Do not insert randomly ❌

---

# ❌ Common Mistakes

* ❌ Violating BST property
* ❌ Not handling duplicates
* ❌ Forgetting to return root (recursive)
* ❌ Infinite loop in iterative

---

# 🎯 Interview Insight

👉
“I traverse the BST based on value comparison and insert the node at the correct leaf position while maintaining BST properties.”

---

# 🔥 Key Insight

```text id="key"
Insertion path is same as search path
```

---

# 🚀 Key Takeaways

* BST insertion = search + attach node
* Only one path traversal
* Can be recursive or iterative
* Structure must remain valid

---

# 🔥 Pattern Connection

* BST Insert → BST Search pattern
* Binary Search → similar decision making
* Tree construction problems

---

