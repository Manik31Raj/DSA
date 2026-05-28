# 🔗 Find All Pairs with Given Sum in Doubly Linked List

---

## 📌 Problem

> Given a **sorted doubly linked list** and a target sum, find all pairs of nodes whose values add up to the target.

---

## 🌲 Example

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 9
```

Target sum:

```text
5
```

Valid pair:

```text
1 + 4 = 5
```

So the answer is:

```text
[1, 4]
```

---

# 🔥 Core Idea

```text
Use two pointers:
1. left from head
2. right from tail
```

Because the list is sorted, we can move pointers intelligently instead of checking every pair.

---

# 🧠 Why This Works

In a sorted list:

* if current sum is too small, move `left` forward
* if current sum is too large, move `right` backward

This is the same idea as the **two-pointer technique**.

---

# 🔷 Working Principle

---

## Step 1: Start pointers

```text
left = head
right = tail
```

---

## Step 2: Compare sum

For each step:

```text
currSum = left.data + right.data
```

Then:

* if `currSum == target`

  * store the pair
  * move both pointers inward
* if `currSum < target`

  * move `left` forward
* if `currSum > target`

  * move `right` backward

---

## Step 3: Stop condition

Stop when pointers cross each other.

That means:

```text
left == right
or
left.prev == right
```

---

# 🎯 Intuition

```text
Small values are at the left.
Large values are at the right.
So we move pointers based on whether we need a bigger or smaller sum.
```

---

# 🌟 Example Dry Run

List:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 9
```

Target = `5`

---

## Initial

```text
left = 1
right = 9
sum = 10
```

Too large → move right backward.

---

## Next

```text
left = 1
right = 4
sum = 5
```

Found pair:

```text
[1, 4]
```

Then move both inward.

---

## Stop

Pointers cross, so traversal ends.

---

# ⚠️ Important Notes

```text
This approach works only because the DLL is sorted
```

If the list is not sorted, this two-pointer method does not work directly.

---

# ❌ Common Mistakes

* ❌ Using this method on unsorted DLL
* ❌ Forgetting to find tail first
* ❌ Not stopping when pointers cross
* ❌ Using `left != right` only, without checking crossing condition
* ❌ Missing pairs when duplicates exist

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

---

# 🎯 Interview Insight

👉
“I use a two-pointer approach on the sorted doubly linked list. One pointer starts from the head and the other from the tail. If the sum is too small, I move the left pointer forward. If the sum is too large, I move the right pointer backward. This gives all valid pairs efficiently in linear time.”

---

# 🔥 Key Insight

```text
Sorted DLL + two pointers = pair sum search
```

---

# 🚀 Key Takeaways

* DLL allows forward and backward traversal
* Tail pointer is needed for two-pointer approach
* Move left/right based on sum comparison
* Works in linear time

---

# 🔥 Pattern Connection

* Two pointers
* Sorted list pair search
* Doubly linked list traversal

---

## ✅ Small Code Note

In this code:

* `findTail(head)` gets the last node
* `left` starts from head
* `right` starts from tail
* if sum is too small → `left = left.next`
* if sum is too large → `right = right.prev`
* when sum matches, the pair is stored using `Arrays.asList(...)`
