# 🔄 Reverse a Singly Linked List

---

## 📌 Problem

> Reverse a singly linked list so that the last node becomes the first node.

---

## 🌲 Example

```text
1 → 2 → 4 → 3 → 6 → 9 → 12 → 5
```

After reversing:

```text
5 → 12 → 9 → 6 → 3 → 4 → 2 → 1
```

---

# 🔥 Core Idea

```text
Change the direction of every next pointer
```

A singly linked list can only move forward, so to reverse it, we must flip each link one by one.

---

# 🧠 Why This Works

If we reverse the arrow of every node:

```text
A → B → C → D
```

becomes:

```text
A ← B ← C ← D
```

Then the old tail becomes the new head.

---

# 🔷 Approach 1: Iterative

---

## 🧠 Idea

Use three pointers:

* `prev` → previous node
* `temp` → current node
* `front` → next node

---

## 🔁 Working Principle

For each node:

1. store next node in `front`
2. point current node to `prev`
3. move `prev` forward
4. move `temp` forward

---

## 🎯 Intuition

```text
Reverse one link at a time while walking through the list
```

---

## 🌟 Pointer Movement

Suppose current part is:

```text
prev = null
temp = 1 → 2 → 3
```

After first step:

```text
1 → null
prev = 1
temp = 2 → 3
```

After second step:

```text
2 → 1 → null
prev = 2
temp = 3
```

And so on.

---

# 🔷 Approach 2: Recursion

---

## 🧠 Idea

Reverse the rest of the list first, then fix the current link.

---

## 🔁 Steps

1. recursively reverse from `head.next`
2. after recursion returns, connect `head.next.next = head`
3. disconnect original forward link using `head.next = null`

---

## 🎯 Intuition

```text
Let recursion reverse the smaller list,
then attach the current node at the end.
```

---

# 🌲 Recursive View

For list:

```text
1 → 2 → 3 → 4
```

Recursion reaches the base case at node `4`.

Then while returning:

* `4` becomes new head
* `3` points to `2`
* `2` points to `1`

Final result:

```text
4 → 3 → 2 → 1
```

---

# 🔥 Base Case

```text
if head is null or only one node exists,
that node is already reversed
```

So return head directly.

---

# ⚠️ Important Notes

```text
The original head becomes the tail after reversal
```

So in recursion, we must set:

```java
head.next = null;
```

Otherwise, it will still point forward and create a cycle.

---

# ❌ Common Mistakes

* ❌ Forgetting to save next node in iterative method
* ❌ Not breaking `head.next` in recursion
* ❌ Returning wrong node instead of new head
* ❌ Losing the rest of the list during pointer updates
* ❌ Confusing `temp`, `prev`, and `front`

---

# ⚡ Complexity

| Method    | Time | Space |
| --------- | ---- | ----- |
| Iterative | O(N) | O(1)  |
| Recursion | O(N) | O(N)  |

---

# 🎯 Interview Insight

👉
“I reverse a singly linked list by changing the direction of every next pointer. In iterative form, I use three pointers to walk through the list and flip the links one by one. In recursion, I reverse the smaller list first and then attach the current node at the end.”

---

# 🔥 Key Insight

```text
Reverse LL = pointer reversal
```

---

# 🚀 Key Takeaways

* Iterative reversal is optimal
* Recursion is shorter but uses stack space
* Tail becomes new head
* Always break original forward link

---

# 🔥 Pattern Connection

* Pointer manipulation
* Recursion on linked list
* In-place reversal

---

## ✅ Small Code Note

In this code:

* `reverseLLIterative()` uses `prev`, `temp`, and `front`
* `reverseLLRecurrsion()` reverses the rest first, then attaches current node
* `head.next = null` is essential in recursion to avoid cycles
