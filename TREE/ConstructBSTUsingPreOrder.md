# 🌳 Construct BST from Preorder Traversal

---

## 📌 Problem

> Construct a **Binary Search Tree (BST)** from its **Preorder traversal**

---

## 🧠 Key Property

```text id="key-prop"
🔥 Preorder = ROOT → LEFT → RIGHT 🔥
```

---

## 🧠 BST Rule Reminder

```text id="bst-rule"
Left subtree < Root < Right subtree
```

---

## 🌲 Example

```text id="example"
Preorder = [8, 5, 1, 7, 10, 12]
```

---

## 🎯 Constructed BST

```id="bst-constructed"
        8
      /   \
     5     10
    / \      \
   1   7      12
```

---

# 🔥 Core Idea

```text id="core"
Use preorder order + BST bound to build tree
```

---

## ❓ Key Question

👉 How do we know where left subtree ends?

---

## 💡 Answer: Use "BOUND"

```text id="bound"
Each subtree has an upper limit (bound)
```

---

# 🔷 Working Principle

---

## 🧠 Step-by-Step

1. Maintain index (`i`) in preorder
2. Current value = `preorder[i]`
3. If value > bound → stop (belongs to another subtree)
4. Create node
5. Recursively build:

```text id="flow"
Left subtree → bound = root.data  
Right subtree → bound = previous bound  
```

---

## 🎯 Intuition

```text id="intuition"
Preorder ensures root comes first  
Bound ensures correct placement
```

---

## 🔄 Flow Example

```text id="flow-example"
Start: bound = ∞

8 → root  
Left (bound=8):
   5 → left  
   Left (bound=5):
       1 → left  
   Right (bound=8):
       7 → right  

Right (bound=∞):
   10 → right  
   Right (bound=∞):
       12 → right  
```

---

## 🔥 Key Insight

```text id="insight"
Bound prevents invalid placement of nodes
```

---

## ⚠️ Important Implementation Detail

```text id="index"
Use array wrapper (int[]) for index to maintain state across recursion
```

---

## ❌ Common Mistakes

* ❌ Not using bound
* ❌ Using multiple loops → O(N²)
* ❌ Passing index incorrectly
* ❌ Forgetting preorder nature

---

## ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(H)

---

## ❓ Why O(N)?

```text id="tc"
Each element is processed exactly once
```

---

## 🎯 Interview Insight

👉
“I use preorder property to pick root and a bound to restrict subtree values. This allows constructing BST in O(N) time without searching.”

---

## 🔥 Key Insight (VERY IMPORTANT)

```text id="key"
Preorder gives order, bound gives structure
```

---

## 🚀 Key Takeaways

* Preorder alone is enough
* Bound controls subtree
* Single pass solution
* Efficient O(N) approach

---

## 🔥 Pattern Connection

* BST construction problems
* Recursion with constraints
* Similar → build tree using ranges

---
