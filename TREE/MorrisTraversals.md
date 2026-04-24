# 🌳 Morris Traversal (Inorder, Preorder, Postorder)

---

## 📌 Definition

> Morris Traversal is a way to traverse a binary tree **without recursion and without stack**.

```text id="def"
Uses O(1) space by modifying tree temporarily
```

---

## 🧠 Core Idea

👉 Instead of stack/recursion, we create **temporary links (threads)**

```text id="core"
Connect rightmost node of left subtree → current node
```

👉 This allows us to come back without stack

---

## 🔑 Key Concept: Threading

```text id="thread"
prev.right = curr   (temporary link)
```

👉 After use:

```text id="restore"
prev.right = null   (restore tree)
```

---

## 🌲 Example

```id="morris-tree"
        1
      /   \
     2     3
    / \     
   4   5    
        \
         6
```

---

# 🔷 Morris Inorder Traversal

---

## 🔁 Logic

```text id="in-logic"
LEFT → ROOT → RIGHT
```

---

## 🧠 Steps

1. If left is null → visit node → go right
2. Else:

   * Find rightmost node in left subtree

   * If thread not created:

     ```text id="in-step1"
     create thread → go left
     ```

   * If thread exists:

     ```text id="in-step2"
     remove thread → visit → go right
     ```

---

## 🎯 Intuition

```text id="in-int"
Visit node AFTER coming back from left
```

---

# 🔷 Morris Preorder Traversal

---

## 🔁 Logic

```text id="pre-logic"
ROOT → LEFT → RIGHT
```

---

## 🧠 Steps

1. If left is null → visit → go right
2. Else:

   * Find rightmost in left subtree

   * If thread not created:

     ```text id="pre-step1"
     visit node → create thread → go left
     ```

   * If thread exists:

     ```text id="pre-step2"
     remove thread → go right
     ```

---

## 🎯 Intuition

```text id="pre-int"
Visit node BEFORE going left
```

---

# 🔷 Morris Postorder Traversal (Tricky)

---

## 🔁 Logic

```text id="post-logic"
LEFT → RIGHT → ROOT
```

---

## 🧠 Trick Used

```text id="post-trick"
Do reverse of (ROOT → RIGHT → LEFT)
Then reverse result
```

---

## 🧠 Steps

1. Traverse like modified preorder:

```text id="post-step1"
ROOT → RIGHT → LEFT
```

2. Store result
3. Reverse at end

---

## 🎯 Intuition

```text id="post-int"
Reverse traversal gives correct postorder
```

---

# ⚠️ Important Notes

```text id="notes"
Tree is modified temporarily
But restored back correctly
```

---

# ❌ Common Mistakes

* ❌ Forgetting to remove thread
* ❌ Infinite loop due to wrong linking
* ❌ Confusing visit timing
* ❌ Postorder logic misunderstanding

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

---

# 🔥 Why Morris is Powerful?

```text id="why"
Removes need of recursion/stack
```

👉 Useful when:

* Memory is constrained
* Stack overflow risk

---

# 🎯 Interview Insight

👉
“Morris traversal uses threaded binary tree concept. It temporarily modifies pointers to avoid recursion and achieves O(1) space traversal.”

---

# 🔥 Key Insight

```text id="key"
Control WHEN to visit node → defines traversal
```

---

# 🚀 Key Takeaways

* No recursion
* No stack
* Uses threading
* Restore tree after traversal

---

# 🔥 Pattern Connection

* Morris → Threaded Trees
* DFS → stack/recursion alternative
* Advanced traversal technique

---

#### EXTRA

# ⚖️ Morris vs Stack vs Recursion

---

## 📊 Comparison Table

| Approach  | Space Complexity |     Implementation    | Modifies Tree | Use Case         |
| --------- | ---------------- | ----------------- | ------------- | ---------------- |
| Recursion | O(H)             | ✅ Easy           | ❌ No          | Default approach |
| Stack     | O(H)             | ✅ Medium         | ❌ No          | Iterative DFS    |
| Morris    | O(1)             | ❌ Hard            | ✅ Yes (temp)  | Space optimized  |

---

## 🧠 Key Differences

### 🔹 Recursion

```text id="rec"
Uses system stack implicitly
```

👉 Clean & simple
👉 Risk of stack overflow for deep trees

---

### 🔹 Stack (Iterative)

```text id="stack"
Explicitly manage traversal using stack
```

👉 More control
👉 Still uses extra space

---

### 🔹 Morris Traversal

```text id="morris"
Uses no stack, no recursion
```

👉 Uses **threading (temporary links)**
👉 Space optimized

---

## ⚠️ Important Tradeoff

```text id="trade"
Morris saves space but increases complexity
```

---

## 🎯 Interview Insight

👉
“If space is not a constraint → use recursion
If recursion not allowed → use stack
If space must be O(1) → use Morris”

---

---

# 🔍 Morris Traversal: Step-by-Step Pointer Movement

---

## 🌲 Example

```id="morris-step-tree"
        1
      /   \
     2     3
    / \     
   4   5    
```

---

## 🧠 Goal (Inorder)

```text id="goal"
LEFT → ROOT → RIGHT
```

---

## 🔁 Step-by-Step

---

### Step 1

```text id="step1"
curr = 1
```

👉 Has left → find rightmost of left subtree

```text id="step1a"
Rightmost of 2 → 5
```

👉 Create thread:

```text id="step1b"
5 → 1
```

👉 Move left → `curr = 2`

---

### Step 2

```text id="step2"
curr = 2
```

👉 Has left → find rightmost

```text id="step2a"
Rightmost of 4 → 4
```

👉 Create thread:

```text id="step2b"
4 → 2
```

👉 Move left → `curr = 4`

---

### Step 3

```text id="step3"
curr = 4
```

👉 No left → visit 4
👉 Move right → goes to **thread (2)**

---

### Step 4

```text id="step4"
curr = 2 (via thread)
```

👉 Thread exists → remove it
👉 Visit 2
👉 Move right → `curr = 5`

---

### Step 5

```text id="step5"
curr = 5
```

👉 No left → visit 5
👉 Move right → goes to **thread (1)**

---

### Step 6

```text id="step6"
curr = 1
```

👉 Thread exists → remove it
👉 Visit 1
👉 Move right → `curr = 3`

---

### Step 7

```text id="step7"
curr = 3
```

👉 No left → visit 3

---

## 🎯 Final Inorder

```text id="final"
[4, 2, 5, 1, 3]
```

---

## 🔥 Key Observation

```text id="obs"
Each node is visited at most twice:
1 → create thread
2 → remove thread
```

---

## 💡 Intuition

👉 Instead of stack:

```text id="intuition"
We create a temporary return path
```

---

## 🚀 Final Takeaways

* Morris = space optimization
* Thread = return path
* Remove thread after use
* Visit timing defines traversal

---

