# Merge Two Sorted Linked Lists

---

# 📌 Problem

Given two sorted linked lists, merge them into a single sorted linked list such that the final linked list is also sorted.

---

# 🌲 Example

Input:

L1:

1 → 3 → 6 → 9

L2:

2 → 5 → 7 → 8 → 13

Output:

1 → 2 → 3 → 5 → 6 → 7 → 8 → 9 → 13

---

# 🔥 Core Idea

```text
Always choose the smaller node from the front
of the two sorted linked lists.
```

Since both lists are already sorted, the smallest available node must be at one of the two heads.

---

# 🧠 Why This Works

Suppose:

```text
L1 : 1 → 3 → 6 → 9
L2 : 2 → 5 → 7 → 8
```

The smallest value among all remaining nodes must be either:

```text
1 (head of L1)
or
2 (head of L2)
```

After selecting the smaller one, we repeat the same process on the remaining nodes.

---

# 🔷 Dummy Node Trick

We create a dummy node:

```java
Node dummy = new Node(-1);
Node curr = dummy;
```

Initially:

```text
dummy
  |
  v
 -1
```

The dummy node helps us build the answer list easily without handling the first node separately.

---

# 🔄 Dry Run

Initial Lists:

```text
L1 : 1 → 3 → 6 → 9
L2 : 2 → 5 → 7 → 8 → 13
```

---

## Step 1

Compare:

```text
1 and 2
```

Take 1.

```text
Merged:
1
```

Move L1.

```text
L1 : 3 → 6 → 9
L2 : 2 → 5 → 7 → 8 → 13
```

---

## Step 2

Compare:

```text
3 and 2
```

Take 2.

```text
Merged:
1 → 2
```

Move L2.

---

## Step 3

Compare:

```text
3 and 5
```

Take 3.

```text
Merged:
1 → 2 → 3
```

Move L1.

---

## Step 4

Compare:

```text
6 and 5
```

Take 5.

```text
Merged:
1 → 2 → 3 → 5
```

Move L2.

---

## Step 5

Compare:

```text
6 and 7
```

Take 6.

```text
Merged:
1 → 2 → 3 → 5 → 6
```

Move L1.

---

## Step 6

Compare:

```text
9 and 7
```

Take 7.

```text
Merged:
1 → 2 → 3 → 5 → 6 → 7
```

Move L2.

---

## Step 7

Compare:

```text
9 and 8
```

Take 8.

```text
Merged:
1 → 2 → 3 → 5 → 6 → 7 → 8
```

Move L2.

---

## Step 8

Compare:

```text
9 and 13
```

Take 9.

```text
Merged:
1 → 2 → 3 → 5 → 6 → 7 → 8 → 9
```

Move L1.

Now:

```text
L1 = null
```

---

# 🔗 Remaining Nodes

Loop stops because one list is finished.

Still remaining:

```text
13
```

Attach directly:

```java
curr.next = temp2;
```

Final:

```text
1 → 2 → 3 → 5 → 6 → 7 → 8 → 9 → 13
```

---

# ⚙️ Understanding This Part

```java
if(temp1 != null)
    curr.next = temp1;
else
    curr.next = temp2;
```

---

## Case 1

```text
L1 finished first
```

Example:

```text
Merged :
1 → 2 → 3 → 5 → 6 → 7 → 8 → 9

temp1 = null

temp2 :
13
```

Attach:

```java
curr.next = temp2;
```

Result:

```text
1 → 2 → 3 → 5 → 6 → 7 → 8 → 9 → 13
```

---

## Case 2

```text
L2 finished first
```

Example:

```text
L1 :
20 → 25 → 30

temp2 = null
```

Attach:

```java
curr.next = temp1;
```

Result:

```text
... → 20 → 25 → 30
```

---

# 🎯 Why Direct Attachment Works

Because the remaining nodes are already sorted.

Example:

```text
temp2 :
13 → 18 → 21 → 30
```

No need to compare again.

Simply attach:

```java
curr.next = temp2;
```

---

# ⚠️ Common Mistakes

### Forgetting Dummy Node

Makes handling first node complicated.

---

### Forgetting Remaining Nodes

Wrong:

```java
while(temp1!=null && temp2!=null)
```

and directly return.

Some nodes remain unprocessed.

---

### Creating New Nodes Unnecessarily

Not needed.

We simply reuse existing nodes.

---

# ⚡ Complexity

| Complexity | Value |
|------------|--------|
| Time | O(N + M) |
| Space | O(1) |

Where:

- N = length of first list
- M = length of second list

---

# 🎯 Interview Explanation

"Since both linked lists are already sorted, I compare the current nodes of both lists and always attach the smaller node to the merged list. I continue this until one list becomes empty, then directly attach the remaining part of the other list because it is already sorted. Using a dummy node simplifies handling the head of the merged list."

---

# 🔥 Key Insight

```text
Merge Sorted LL
=
Merge step of Merge Sort
```

At every step:

```text
Choose the smallest front node
and move forward.
```

---

# 🚀 Pattern

✅ Linked List

✅ Two Pointers

✅ Merge Sort Merge Step

✅ Dummy Node Technique
