# 🌳 Root to Node Path

---

## 📌 Definition

**Root to Node Path** means:

> Finding the path from the **root node** to a given **target node** in a binary tree.

---

## 🌲 Example Tree

```id="rtn-tree"
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

---

## 🎯 Example

Find path to node **5**

```id="rtn-out"
1 → 2 → 5
```

---

## 🧠 Core Idea

* Traverse the tree using **DFS (Depth First Search)**
* Keep track of path while traversing
* Use **backtracking** if path is wrong

---

## 🔁 Working Principle

1. Start from root
2. Add current node to path
3. If node = target → done
4. Else:

   * Search left subtree
   * Search right subtree
5. If not found:

   * Remove current node (backtrack)

---

## 🔄 Backtracking (Key Concept)

* Add node when moving forward
* Remove node when path is incorrect

👉 Ensures path always contains correct nodes

---

## 🎯 Intuition

Think like exploring a maze:

* Move forward and record path
* If wrong path → go back (remove node)
* Try another direction

---

## 📦 Recursion Behavior

At each node:

* Try including it in path
* If it leads to solution → keep it
* Else → remove it

---

## ⚡ Base Conditions

* Node is null → ❌ not found
* Node = target → ✅ path found

---

## 📊 Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

Where:

* N = number of nodes
* H = height of tree

---

## ⚠️ Common Mistakes

* Not removing node during backtracking
* Returning wrong condition (missing OR case)
* Not checking null root
* Returning partial path

---

## 🎯 Interview Insight

Best explanation:

👉 “I use DFS with backtracking. I add nodes to the path while traversing, and if the target is not found in a subtree, I remove that node to maintain the correct path.”

---

## 🚀 Key Takeaways

* Use **DFS + backtracking**
* Path grows and shrinks dynamically
* Very important pattern for:

  * Path problems
  * Subtree problems
  * Backtracking questions

---

## 🔥 Pattern Connection

This concept is used in:

* Root to Leaf paths
* Path Sum problems
* Lowest Common Ancestor

---
