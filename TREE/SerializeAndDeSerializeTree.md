# 🌳 Serialize & Deserialize Binary Tree

---

## 📌 Definition

> Convert a binary tree into a **string representation (serialize)**
> and reconstruct the same tree back from the string (**deserialize**).

---

## 🎯 Goal

```text id="goal"
Tree → String → Same Tree
```

👉 Structure + values must be preserved ✔

---

## 🌲 Example

```id="ser-tree"
        1
      /   \
     2     13
          /  \
         4    5
```

---

## 🔁 Serialized Form

```text id="ser-out"
1,2,13,#,#,4,5,#,#,#,#,
```

👉 `#` represents **null nodes**

---

## 🧠 Core Idea

👉 Use **Level Order Traversal (BFS)**

```text id="why-bfs"
BFS preserves structure level by level
```

---

# 🔷 Serialization

---

## 🔁 Working Principle

1. Use **Queue**
2. Traverse tree level-wise
3. For each node:

   * If not null → store value
   * If null → store `#`
4. Push left and right children into queue

---

## ⚠️ Important Implementation Detail

👉 Use **StringBuilder instead of String**

---

### ❓ Why not String?

```text id="str-problem"
String is immutable
```

👉 Every append creates a new object:

```text id="str-cost"
str = str + "data" → new object each time
```

👉 Time complexity becomes:

```text id="str-tc"
O(N²)
```

---

### ✅ Why StringBuilder?

```text id="sb-adv"
StringBuilder is mutable
```

👉 Append happens in-place:

```text id="sb-op"
append() → no new object creation
```

👉 Time complexity:

```text id="sb-tc"
O(N)
```

---

### 🎯 In Your Code

```text id="sb-usage"
StringBuilder str = new StringBuilder();
str.append(value).append(",");
```

👉 Efficient + optimal ✔

---

## 🧠 Important Insight

```text id="ser-key"
Null nodes are necessary to preserve structure
```

---

# 🔷 Deserialization

---

## 🔁 Working Principle

1. Split string into array
2. First element = root
3. Use **Queue**
4. For each node:

   * Assign left child
   * Assign right child
5. Skip `#`

---

## 🧠 Intuition

```text id="des-flow"
Parent → left → right → move forward
```

---

# ⚠️ Important Points

```text id="imp"
Queue → maintains level order
'#' → preserves structure
StringBuilder → improves performance
```

---

# ❌ Common Mistakes

* ❌ Using String instead of StringBuilder
* ❌ Ignoring null nodes
* ❌ Incorrect index increment
* ❌ Breaking order

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(N)

---

# 🎯 Interview Insight

👉
“I use BFS to serialize including null markers, and StringBuilder for efficient string construction. Then I rebuild the tree using a queue in level order.”

---

# 🔥 Key Insight

```text id="key"
Efficient string building matters in large inputs
```

---

# 🚀 Key Takeaways

* BFS preserves structure
* `#` is essential
* Queue rebuilds tree
* StringBuilder optimizes performance

---

# 🔥 Pattern Connection

* BFS → structure problems
* Queue → reconstruction
* StringBuilder → performance optimization

---
