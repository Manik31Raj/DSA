# 🌳 All Traversals in One Stack

---

## 📌 Traversal Definitions

### 🔹 Preorder (Root → Left → Right)

* Visit the **root first**
* Then traverse **left subtree**
* Then traverse **right subtree**

---

### 🔹 Inorder (Left → Root → Right)

* Traverse **left subtree first**
* Then visit the **root**
* Then traverse **right subtree**

---

### 🔹 Postorder (Left → Right → Root)

* Traverse **left subtree**
* Then traverse **right subtree**
* Visit the **root at the end**

---

## 🌲 Example Tree

```
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```
# 🎬 Live Traversal Demo (Markdown Simulation)

<details>
<summary>▶️ Click to Start Demo</summary>

---

### ▶️ Step 0 — Initialize

```
Stack: [(1,1)]

Pre : -
In  : -
Post: -
```

---

### ▶️ Step 1 — Process (1,1)

```
Action: Preorder → 1

Stack: [(1,2), (2,1)]

Pre : 1
In  : -
Post: -
```

---

### ▶️ Step 2 — Process (2,1)

```
Action: Preorder → 2

Stack: [(1,2), (2,2), (4,1)]

Pre : 1 → 2
```

---

### ▶️ Step 3 — Process (4,1)

```
Action: Preorder → 4

Stack: [(1,2), (2,2), (4,2)]

Pre : 1 → 2 → 4
```

---

### ▶️ Step 4 — Process (4,2)

```
Action: Inorder → 4

Stack: [(1,2), (2,2), (4,3)]

In : 4
```

---

### ▶️ Step 5 — Process (4,3)

```
Action: Postorder → 4

Stack: [(1,2), (2,2)]

Post: 4
```

---

### ▶️ Step 6 — Process (2,2)

```
Action: Inorder → 2

Stack: [(1,2), (2,3), (5,1)]

In : 4 → 2
```

---

### ▶️ Step 7 — Process (5 full cycle)

```
Pre : 1 → 2 → 4 → 5
In  : 4 → 2 → 5
Post: 4 → 5

Stack: [(1,2), (2,3)]
```

---

### ▶️ Step 8 — Process (2,3)

```
Action: Postorder → 2

Stack: [(1,2)]

Post: 4 → 5 → 2
```

---

### ▶️ Step 9 — Process (1,2)

```
Action: Inorder → 1

Stack: [(1,3), (3,1)]

In : 4 → 2 → 5 → 1
```

---
</details>

## 📊 Applying Definitions

* **Preorder:** 1 → 2 → 4 → 5 → 3 → 6 → 7
* **Inorder:** 4 → 2 → 5 → 1 → 6 → 3 → 7
* **Postorder:** 4 → 5 → 2 → 6 → 7 → 3 → 1

---

## 🧠 Core Idea (Single Stack)

Instead of running three traversals separately:

* Use **one stack**
* Track each node with a **state (1, 2, 3)**
* Process the same node multiple times

---

## 🔁 Node Lifecycle (Very Important)

Each node goes through **three stages**:

1. **State 1 → Preorder**

   * Node is visited for the first time
   * Add to **Preorder**
   * Move to left subtree

2. **State 2 → Inorder**

   * Left subtree is done
   * Add to **Inorder**
   * Move to right subtree

3. **State 3 → Postorder**

   * Right subtree is done
   * Add to **Postorder**
   * Node is completely processed

---

## 🔄 How Stack Simulates This

* Stack stores **(node, state)**
* When a node is processed:

  * It is **pushed back with next state**
  * Child nodes are pushed accordingly
* This mimics **recursive call behavior**

---

## 🎯 Intuition (Connect with Recursion)

Think in terms of recursion:

* Enter node → **Preorder**
* Return from left → **Inorder**
* Return from right → **Postorder**

👉 Stack + state = manual simulation of recursion

---

## ⚡ Why This Works

* Every node is processed exactly **3 times**
* No repeated traversal
* All results built in **single pass**

---

## 📊 Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(N)

---

## 🧠 Key Takeaways

* Traversals differ only by **when node is visited**
* State helps track **execution stage**
* Stack replaces recursion
* Very important pattern for tree problems

---

## 🔥 Interview Insight

Best way to explain:

👉 “Each node is pushed into the stack and processed 3 times using states—
state 1 for preorder, state 2 for inorder, and state 3 for postorder—
which simulates recursion in a single traversal.”

---


