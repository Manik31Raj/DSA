# Merge K Sorted Linked Lists

---

# 📌 Problem

Given `K` sorted linked lists, merge all of them into a single sorted linked list.

---

# 🌲 Example

Input:

```text
List 1:
1 → 3 → 6 → 9

List 2:
2 → 5 → 7 → 8 → 13

List 3:
1 → 4 → 7 → 10

List 4:
5 → 8 → 12 → 23
```

Output:

```text
1 → 1 → 2 → 3 → 4 → 5 → 5 → 6 → 7 → 7 → 8 → 8 → 9 → 10 → 12 → 13 → 23
```

---

# 🔥 Core Idea

```text
Always take the smallest node
among the heads of all K linked lists.
```

To find the smallest efficiently, we use a:

```text
Min Heap (Priority Queue)
```

---

# 🧠 Why This Works

Every linked list is already sorted.

Therefore:

```text
The smallest unprocessed element
of a list is always at its head.
```

So instead of searching through all nodes:

- Keep only the current head of each list inside a Min Heap.
- Extract the smallest node.
- Add its next node into the heap.

Repeat until the heap becomes empty.

---

# 🔷 Data Structure Used

## Priority Queue (Min Heap)

Stores:

```java
(value, node)
```

Example:

```text
(1,List1)
(2,List2)
(1,List3)
(5,List4)
```

The heap automatically keeps the smallest value at the top.

---

# 🔁 Working Principle

---

## Step 1

Create a Min Heap.

```java
PriorityQueue<Pair> pq = new PriorityQueue<>();
```

---

## Step 2

Insert the head of every linked list.

```java
for(Node n:list){
    if(n!=null){
        pq.add(new Pair(n.data,n));
    }
}
```

Heap:

```text
1(L1)
2(L2)
1(L3)
5(L4)
```

---

## Step 3

Remove the minimum node.

```java
Pair p = pq.poll();
```

Attach it to answer.

```java
curr.next = p.node;
curr = curr.next;
```

---

## Step 4

If the removed node has a next node:

```java
if(p.node.next != null)
```

insert it into heap.

```java
pq.add(new Pair(
    p.node.next.data,
    p.node.next
));
```

---

## Step 5

Repeat until heap becomes empty.

---

# 🌟 Dry Run

---

## Initial Heap

Heads of all lists:

```text
1(L1)
2(L2)
1(L3)
5(L4)
```

Heap:

```text
      1
    /   \
   1     2
  /
 5
```

---

## Iteration 1

Remove:

```text
1 (L1)
```

Answer:

```text
1
```

Insert next node:

```text
3
```

Heap:

```text
1 2 5 3
```

---

## Iteration 2

Remove:

```text
1 (L3)
```

Answer:

```text
1 → 1
```

Insert:

```text
4
```

Heap:

```text
2 3 5 4
```

---

## Iteration 3

Remove:

```text
2
```

Answer:

```text
1 → 1 → 2
```

Insert:

```text
5
```

Heap:

```text
3 4 5 5
```

---

Continue similarly...

Final:

```text
1 → 1 → 2 → 3 → 4 → 5 → 5 → 6 → 7 → 7 → 8 → 8 → 9 → 10 → 12 → 13 → 23
```

---

# 🔷 Understanding the Heap Logic

Initially:

```text
Only K nodes are inside heap.
```

One node from each list.

---

When we remove a node:

```text
Take smallest node
```

Then:

```text
Insert its next node
```

This ensures:

```text
Heap always contains
the smallest available node
from every active list.
```

---

# 🎯 Intuition

Imagine K people standing in lines.

Each line is already sorted.

You always pick:

```text
The smallest front person
among all lines.
```

After removing that person:

```text
The next person from that line
comes to the front.
```

This is exactly what the Min Heap does.

---

# ⚠️ Why Not Compare All Lists Every Time?

Suppose:

```text
K = 1000
```

For every node:

```text
Finding minimum manually
would cost O(K)
```

Very expensive.

Min Heap gives:

```text
Minimum in O(log K)
```

which is much faster.

---

# ❌ Common Mistakes

### Forgetting Null Check

Wrong:

```java
pq.add(new Pair(n.data,n));
```

If list is null:

```text
NullPointerException
```

---

### Forgetting to Add Next Node

Wrong:

```java
Pair p = pq.poll();
```

but not inserting:

```java
p.node.next
```

Then many nodes never get processed.

---

### Returning Dummy

Wrong:

```java
return dummy;
```

Correct:

```java
return dummy.next;
```

---

# ⚡ Complexity Analysis

Let:

```text
N = Total number of nodes
K = Number of linked lists
```

---

## Time Complexity

Each node:

- inserted once
- removed once

Heap operation:

```text
O(log K)
```

Total:

```text
O(N log K)
```

---

## Space Complexity

Heap stores at most:

```text
K nodes
```

Therefore:

```text
O(K)
```

---

# 🎯 Interview Explanation

"I use a Min Heap to always access the smallest node among the heads of all K sorted linked lists. Initially, I insert the head of every list into the heap. Then I repeatedly remove the minimum node, append it to the answer list, and insert its next node into the heap. Since each node is inserted and removed exactly once, the complexity is O(N log K)."

---

# 🔥 Key Insight

```text
Merge K Sorted Lists
=
Keep K current heads in a Min Heap
```

At every step:

```text
Take smallest node
Insert next node from same list
```

---

# 🚀 Pattern

✅ Linked List

✅ Priority Queue

✅ Heap

✅ K-Way Merge

✅ Merge Sorted Structures

---

# 🔥 Similar Problems

1. Merge K Sorted Arrays
2. External Sorting
3. Kth Smallest Element in Sorted Matrix
4. K Closest Elements
5. Top K Frequent Elements

All use:

```text
Priority Queue / Min Heap
```

as the core idea.

---

## ✅ Small Code Note

In this code:

```java
pq.add(new Pair(n.data,n));
```

adds the head of every list.

```java
Pair p = pq.poll();
```

extracts the smallest node.

```java
curr.next = p.node;
```

adds it to the merged list.

```java
pq.add(new Pair(
    p.node.next.data,
    p.node.next
));
```

pushes the next node of that list into the heap.

Thus the heap always contains the smallest available candidate from every list.
