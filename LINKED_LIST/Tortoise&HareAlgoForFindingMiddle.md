# 🐢🐇 Find Middle Node of Linked List

## (Tortoise & Hare Algorithm)

---

# 📌 Problem

Find the middle node of a singly linked list.

Example:

```text
1 → 2 → 4 → 3 → 9 → 12 → 5
```

Middle node is:

```text
3
```

---

# 🔥 Main Idea

Use two pointers:

| Pointer | Speed         |
| ------- | ------------- |
| slow    | moves 1 step  |
| fast    | moves 2 steps |

---

# 🧠 Why This Works

```text
When fast reaches the end,
slow will be at the middle
```

Because:

* fast moves twice as quickly
* so slow covers only half the distance

---

# 🔁 Dry Run

Linked List:

```text
1 → 2 → 4 → 3 → 9 → 12 → 5
```

---

## Initial Position

```text
slow = 1
fast = 1
```

---

## Iteration 1

```text
slow = slow.next
fast = fast.next.next
```

Moves:

```text
slow = 2
fast = 4
```

---

## Iteration 2

Moves:

```text
slow = 4
fast = 9
```

---

## Iteration 3

Moves:

```text
slow = 3
fast = 5
```

Now:

```text
fast.next == null
```

Loop stops.

---

# ✅ Answer

```text
slow = 3
```

which is the middle node.

---

# 🎯 Visual Representation

```text
Step 0:
S,F
1 → 2 → 4 → 3 → 9 → 12 → 5

Step 1:
    S       F
1 → 2 → 4 → 3 → 9 → 12 → 5

Step 2:
        S           F
1 → 2 → 4 → 3 → 9 → 12 → 5

Step 3:
            S               F
1 → 2 → 4 → 3 → 9 → 12 → 5
```

---

# 🔷 Even Length Case

Example:

```text
1 → 2 → 3 → 4 → 5 → 6
```

Your algorithm returns:

```text
4
```

because loop stops after slow reaches second middle.

---

# 📌 Why Second Middle?

Condition:

```java
while(fast != null && fast.next != null)
```

allows one extra move for slow.

So:

```text
Even length → returns second middle
```

---

# ⚡ Complexity

| Complexity | Value |
| ---------- | ----- |
| Time       | O(N)  |
| Space      | O(1)  |

---

# 🔥 Why Called Tortoise & Hare?

| Pointer | Meaning     |
| ------- | ----------- |
| slow    | tortoise 🐢 |
| fast    | hare 🐇     |

One moves slowly, the other quickly.

This pattern is widely used in linked list problems.

---

# 🚀 Applications of This Technique

This same algorithm is used in:

* Finding middle node
* Detecting cycle in LL
* Finding cycle start
* Checking palindrome LL
* Splitting linked list
* Merge sort on LL

---

# 🔍 Your Code Flow

```java
Node slow = head;
Node fast = head;
```

Both start at head.

---

Loop:

```java
while(fast != null && fast.next != null)
```

Ensures fast can safely jump 2 nodes.

---

Inside loop:

```java
slow = slow.next;
fast = fast.next.next;
```

* slow moves 1 step
* fast moves 2 steps

---

Finally:

```java
return slow;
```

slow points to middle node.

---

# ✅ Key Insight

```text
Fast moves twice as fast as slow,
so when fast finishes,
slow reaches halfway.
```

---

# 🎯 Interview Explanation

👉

“I use the tortoise and hare approach where slow moves one step and fast moves two steps. When fast reaches the end of the linked list, slow automatically points to the middle node.”
