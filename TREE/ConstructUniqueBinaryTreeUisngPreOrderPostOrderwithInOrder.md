# 🌳 Construct Unique Binary Tree from Traversals

---

## 📌 Problem

> Given traversal arrays, construct the **unique binary tree**.

---

## 🔑 Key Combinations

| Traversals           | Can we build unique tree? |
| -------------------- | ------------------------- |
| Inorder + Preorder   | ✅ YES                     |
| Inorder + Postorder  | ✅ YES                     |
| Preorder + Postorder | ❌ NO                      |

---

## 🧠 Why Inorder is Important?

```text id="in-imp"
Inorder tells us LEFT and RIGHT subtree separation
```

👉 Inorder structure:

```text
[ LEFT | ROOT | RIGHT ]
```

👉 Without this split:

* We don’t know which nodes go left ❌
* Which go right ❌

---

# 🔷 Case 1: Inorder + Preorder

---

## 🔁 Core Idea

```text id="pre-core"
Preorder → ROOT first
Inorder  → splits LEFT and RIGHT
```

---

## 🎯 Steps

1. First element in preorder = **root**
2. Find root in inorder
3. Left side → left subtree
4. Right side → right subtree
5. Repeat recursively

---

## 🌲 Example

```id="pre-example"
Preorder = [10, 20, 40, 50, 30, 60]
Inorder  = [40, 20, 50, 10, 60, 30]
```

---

## 🧠 Intuition

```id="pre-flow"
Preorder → 10 is root

Inorder:
[40, 20, 50] 10 [60, 30]
   LEFT            RIGHT
```

👉 Build left subtree first
👉 Then right subtree

---

# 🔷 Case 2: Inorder + Postorder

---

## 🔁 Core Idea

```text id="post-core"
Postorder → ROOT last
Inorder   → splits LEFT and RIGHT
```

---

## 🎯 Steps

1. Last element in postorder = **root**
2. Find root in inorder
3. Left side → left subtree
4. Right side → right subtree
5. Build **right subtree first** (important)

---

## 🌲 Example

```id="post-example"
Postorder = [40, 50, 20, 60, 30, 10]
Inorder   = [40, 20, 50, 10, 60, 30]
```

---

## 🧠 Intuition

```id="post-flow"
Postorder → 10 is root

Inorder:
[40, 20, 50] 10 [60, 30]
```

👉 Build right subtree first
👉 Then left subtree

---

# ❌ Why Preorder + Postorder Cannot Build Unique Tree?

---

## 🔥 Key Reason

```text id="fail-core"
No information to split LEFT and RIGHT
```

---

## 🧠 Example

```id="fail-example"
Preorder  = [1, 2, 3]
Postorder = [3, 2, 1]
```

---

## 🤯 Possible Trees

### Tree 1:

```text
    1
   /
  2
 /
3
```

---

### Tree 2:

```text
    1
     \
      2
       \
        3
```

---

👉 Both give SAME traversals

```text id="same-trav"
Preorder  → 1 2 3
Postorder → 3 2 1
```

👉 So:

```text id="no-unique"
Tree is NOT uniquely defined ❌
```

---

## ⚠️ Special Case

👉 If tree is **Full Binary Tree**:

```text id="special"
Every node has 0 or 2 children
```

👉 Then Pre + Post can work ✔

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(N)

---

# 🎯 Interview Insight

Best explanation:

👉
“Inorder traversal is crucial because it tells how to split the tree into left and right subtrees. Preorder gives root-first, postorder gives root-last. Without inorder, we cannot uniquely determine structure.”

---

# 🔥 Key Insights

```text id="key1"
Inorder = structure (left/right split)
Pre/Post = root position
```

---

# 🚀 Key Takeaways

* Inorder is mandatory for uniqueness
* Preorder → root first
* Postorder → root last
* Pre + Post alone → ambiguous

---

# 🔥 Pattern Connection

* Tree Construction → Divide & Conquer
* Recursion → subtree building
* HashMap → fast index lookup

---
