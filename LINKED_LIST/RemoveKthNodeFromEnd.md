# 🗑️ Remove Kth Node from End of Linked List

---

## 📌 Problem

> Given a linked list, remove the **Kth node from the end**.

---

## 🌲 Example

```text
1 → 2 → 4 → 3 → 6 → 9 → 12 → 5
```

If `k = 5`, then remove the node that is 5th from the end.

---

# 🔥 Core Idea

```text
Use two pointers:
1. fast pointer moves k steps ahead
2. then move fast and slow together
```

When `fast` reaches the end, `slow` will be just before the node to delete.

---

# 🧠 Why This Works

We do not need to count the full length first.

By keeping a gap of `k` nodes between `fast` and `slow`, we can directly locate the target node in one traversal.

---

# 🔷 Working Principle

---

## Step 1: Move fast pointer k steps ahead

```java
for(int i=0;i<k;i++){
    fast = fast.next;
}
```

After this, the gap between `fast` and `slow` is `k`.

---

## Step 2: Handle special case

If `fast == null` after moving `k` steps:

```text
The node to delete is the head node
```

So we return:

```java
head.next
```

---

## Step 3: Move both pointers together

```text
while(fast.next != null){
    fast = fast.next;
    slow = slow.next;
}
```

Now:

* `fast` is at the last node
* `slow` is just before the node to delete

---

## Step 4: Delete the target node

```java
slow.next = slow.next.next;
```

This skips the Kth node from the end.

---

# 🎯 Intuition

```text
Keep a fixed gap of k nodes.
When the front pointer reaches the end,
the back pointer is at the correct deletion point.
```

---

# 🔄 Example Dry Run

List:

```text
1 → 2 → 4 → 3 → 6 → 9 → 12 → 5
```

Let `k = 5`

---

## Move fast 5 steps ahead

```text
fast at node 9
slow at node 1
```

---

## Move both together

Eventually:

* `fast` reaches the last node
* `slow` stops before the node to remove

So the target node gets skipped.

---

# ⚠️ Important Edge Cases

---

## Case 1: `k` is larger than list length

```text
K out of range
```

Your code checks this while moving `fast`.

---

## Case 2: Remove the head node

If `fast == null` after moving `k` steps:

```text
delete head
```

---

## Case 3: Single node list

If the only node is removed, the result becomes:

```text
null
```

---

# ❌ Common Mistakes

* ❌ Forgetting to handle `k > length`
* ❌ Not checking `fast == null`
* ❌ Starting slow too late
* ❌ Deleting the wrong node
* ❌ Forgetting that k is counted from the end

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

---

# 🎯 Interview Explanation

👉
“I use two pointers. First, I move the fast pointer `k` steps ahead. Then I move fast and slow together until fast reaches the last node. At that point, slow is just before the Kth node from the end, so I skip that node by changing links.”

---

# 🔥 Key Insight

```text
Kth from end = fixed gap + two pointers
```

---

# 🚀 Key Takeaways

* Fast pointer moves `k` steps first
* Slow pointer follows behind
* If fast becomes null, head is removed
* Only one traversal is needed
* O(1) extra space

---

# 🔥 Pattern Connection

* Two pointers
* Linked list traversal
* Pointer skipping technique
