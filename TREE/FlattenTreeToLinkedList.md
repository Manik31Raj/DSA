# 🌳 Flatten Binary Tree to Linked List

---

## 📌 Problem

> Convert a binary tree into a **linked list (in-place)** following **preorder traversal**

👉 Final structure:

```text id="goal"
All nodes → right pointer
Left pointer → null
```

---

## 🌲 Example (Before → After)

```id="flatten-tree"
Before Tree                →        Flattened List

        1                           1
      /   \                          \
     2     5                          2
    / \     \                          \
   3   4     6                          3
                \                        \
                 7                        4
                                           \
                                            5
                                             \
                                              6
                                               \
                                                7
```

---

## 🧠 Core Idea

```text id="core"
Flatten tree in PREORDER → ROOT → LEFT → RIGHT
```

---

# 🔷 Approach 1: Reverse Preorder (Recursion)

---

## 🔁 Idea

```text id="rev-pre"
Traverse in reverse preorder → RIGHT → LEFT → ROOT
```

---

## 🧠 Why Reverse?

👉 So we can connect nodes while **coming back**

```text id="rev-int"
Maintain previous node and link current → prev
```

---

## ⚙️ Steps

1. Go right subtree
2. Go left subtree
3. Set:

```text id="rev-link"
root.right = prev
root.left = null
prev = root
```

---

## 🎯 Intuition

```text id="rev-flow"
Build list from back to front
```

---

# 🔷 Approach 2: Stack (Iterative)

---

## 🔁 Idea

👉 Simulate preorder using stack

---

## ⚙️ Steps

1. Push root
2. While stack not empty:

   * Pop node
   * Push right child
   * Push left child
   * Connect:

```text id="stack-link"
curr.right = next node (stack top)
curr.left = null
```

---

## 🧠 Why push right first?

```text id="stack-why"
So left is processed first (LIFO)
```

---

## 🎯 Intuition

```text id="stack-int"
Explicitly simulate recursion stack
```

---

# 🔷 Approach 3: Morris (Optimal)

---

## 🔁 Idea

👉 Modify tree using **threading (no stack, no recursion)**

---

## ⚙️ Steps

1. For each node:

   * If left exists:

     * Find rightmost node of left subtree
     * Connect it to current's right

```text id="morris-step"
prev.right = curr.right
curr.right = curr.left
curr.left = null
```

2. Move to right

---

## 🧠 Intuition

```text id="morris-int"
Insert left subtree between node and right subtree
```

---

## 🎯 Visualization

```text id="morris-flow"
Before:
   1
  / \
 2   5

After step:
   1
    \
     2
      \
       (rest continues)
```

---

# ⚖️ Comparison of Approaches

---

## 📊 Table

| Approach  | Space | Easy     | Modifies Tree | Idea             |
| --------- | ----- | -------- | ------------- | ---------------- |
| Recursion | O(H)  | ✅ Easy   | ❌ No          | Reverse preorder |
| Stack     | O(H)  | ✅ Medium | ❌ No          | Simulate DFS     |
| Morris    | O(1)  | ❌ Hard   | ✅ Yes         | Threading        |

---

## ⚠️ Tradeoff

```text id="trade"
Morris → best space but hardest logic
```

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:**

  * Recursion → O(H)
  * Stack → O(H)
  * Morris → O(1)

---

# ❌ Common Mistakes

* ❌ Forgetting to nullify left pointer
* ❌ Wrong order in stack push
* ❌ Losing right subtree in Morris
* ❌ Not maintaining prev in recursion

---

# 🎯 Interview Insight

👉
“I flatten the tree in preorder. This can be done using recursion, stack, or Morris traversal. Morris is optimal with O(1) space by rearranging pointers.”

---

# 🔥 Key Insight

```text id="key"
All approaches simulate preorder, difference is how memory is handled
```

---

# 🚀 Key Takeaways

* Preorder defines final order
* Left subtree comes before right
* Morris avoids extra space
* In-place modification required

---

# 🔥 Pattern Connection

* Flatten Tree → Tree Transformation
* Morris → space optimization
* DFS → traversal control

---
