# 🌳 Delete Node in Binary Search Tree (BST)

---

## 📌 Problem

> Delete a node from a **Binary Search Tree** while maintaining BST properties.

---

## 🧠 BST Rule Reminder

```text id="bst-rule"
Left subtree < Root < Right subtree
```

---

## 🌲 Example

```id="bst-del-tree"
        9
      /   \
     8     12
    /     /  \
   5     10   13
  / \
 3   7
```

---

## 🧠 Core Idea

```text id="core"
Search the node → delete it → rearrange tree properly
```

---

# 🔥 3 Cases of Deletion

---

## 🔹 Case 1: Leaf Node

```text id="case1"
Node has no children
```

👉 Simply remove it

---

## 🔹 Case 2: One Child

```text id="case2"
Node has only one child
```

👉 Replace node with its child

---

## 🔹 Case 3: Two Children (Important)

```text id="case3"
Node has both left and right child
```

👉 Two options:

---

### ✅ Approach A (Your Iterative Helper)

```text id="approachA"
Take left subtree
Attach right subtree to rightmost node of left subtree
```

---

### 🧠 Why this works?

```text id="whyA"
All nodes in left subtree < root
Right subtree > root
```

👉 So attaching right subtree to rightmost of left keeps BST valid

---

### 🔄 Flow

```text id="flowA"
Find rightmost of left subtree
Attach right subtree there
Return left subtree as new root
```

---

### ✅ Approach B (Successor Method - Recursive)

```text id="approachB"
Replace node with its inorder successor
```

👉 Successor = smallest node in right subtree

---

### 🔄 Flow

```text id="flowB"
Find successor (min in right subtree)
Copy value to current node
Delete successor recursively
```

---

# 🔷 Approach 1: Iterative 

---

## 🧠 Idea

👉 Traverse tree to find node
👉 Use helper to delete

---

## 🎯 Key Insight

```text id="iter-key"
We modify parent’s pointer directly
```

---

## ⚠️ Special Case

```text id="iter-root"
If root itself is deleted → handle separately
```

---

# 🔷 Approach 2: Recursive

---

## 🧠 Idea

👉 Use recursion to locate and delete node

---

## 🎯 Key Insight

```text id="rec-key"
Return updated subtree after deletion
```

---

# ⚡ Complexity

* **Time Complexity:** O(H)
* **Space Complexity:**

  * Iterative → O(1)
  * Recursive → O(H)

---

## ❓ Why O(H)?

```text id="tc"
Only one path is traversed from root to node
```

---

# ⚠️ Important Notes

```text id="note"
Tree must remain a valid BST after deletion
```

---

# ❌ Common Mistakes

* ❌ Not handling 3 cases properly
* ❌ Losing subtree connections
* ❌ Forgetting to update parent pointer
* ❌ Confusing predecessor vs successor

---

# 🎯 Interview Insight

👉
“I handle deletion in three cases: leaf, one child, and two children. For two children, I either attach the right subtree to the rightmost node of the left subtree or replace with inorder successor.”

---

# 🔥 Key Insight

```text id="key"
Deletion = search + restructure
```

---

# 🚀 Key Takeaways

* Always consider 3 cases
* BST property must remain intact
* Successor method is standard
* Iterative gives better space

---

# 🔥 Pattern Connection

* BST Delete → BST Search pattern
* Tree restructuring problems
* Similar → Insert / Search / Floor / Ceil

---
