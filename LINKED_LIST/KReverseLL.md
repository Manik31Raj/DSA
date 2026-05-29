# 🔄 Reverse Nodes in K-Group

---

## 📌 Problem

> Given a linked list and an integer `k`, reverse the nodes of the list **in groups of k**.

---

## 🌲 Example

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10
```

If `k = 3`, then:

```text
3 → 2 → 1 → 6 → 5 → 4 → 9 → 8 → 7 → 10
```

The last group is not reversed because it has fewer than `k` nodes.

---

# 🔥 Core Idea

```text
Take one group of k nodes,
reverse that group,
then connect it to the previous reversed group.
```

---

# 🧠 Why This Works

We process the list block by block:

* find the kth node of the current block
* temporarily cut the block
* reverse that block
* connect it back to the previous part

This is an in-place solution.

---

# 🔷 Main Helpers

---

## 1) `getKthNode(temp, k)`

```text
Find the kth node starting from temp
```

If there are not enough nodes, return `null`.

---

## 2) `reverse(temp)`

```text
Reverse the current isolated segment
```

Before reversing, the segment is cut using:

```java
kthNode.next = null;
```

So `reverse(temp)` only reverses that group.

---

# 🔁 Working Principle

---

## Step 1: Start from head

```text
temp = head
prevLast = null
```

* `temp` → start of current group
* `prevLast` → last node of previous reversed group

---

## Step 2: Find kth node

```java
Node kthNode = getKthNode(temp, k);
```

If `kthNode == null`:

* current group has less than `k` nodes
* do not reverse it
* attach it as it is to previous part

---

## Step 3: Cut the group

Before reversing, store:

```java
Node nextNode = kthNode.next;
kthNode.next = null;
```

This isolates the group:

```text
temp ... kthNode
```

becomes a separate list.

---

## Step 4: Reverse the isolated group

```java
reverse(temp);
```

Now the group becomes reversed.

For example:

```text
1 → 2 → 3
```

becomes:

```text
3 → 2 → 1
```

---

## Step 5: Connect reversed group

Now we connect it to the already processed part.

---

### First group

If this is the first group:

```java
if(temp == head){
    head = kthNode;
}
```

This updates the head to the new group head.

---

### Later groups

If this is not the first group:

```java
prevLast.next = kthNode;
```

This attaches the previous reversed group to the current reversed group.

---

## Step 6: Update `prevLast` and move forward

```java
prevLast = temp;
temp = nextNode;
```

Important:

* after reversal, `temp` becomes the **tail** of the current reversed group
* `nextNode` is the start of the next group

So:

* `prevLast` becomes the tail of current group
* `temp` moves to next block

---

# 🌟 Very Important Connection Logic

This is the part that usually confuses people.

---

## Before reversing a group

Suppose current group is:

```text
temp = 1 → 2 → 3
kthNode = 3
nextNode = 4
```

After doing:

```java
kthNode.next = null;
```

the group becomes isolated:

```text
1 → 2 → 3 → null
```

---

## After reversing

```text
3 → 2 → 1
```

Now:

* `kthNode` is the new head of this reversed group
* `temp` is now the tail of this reversed group

---

## How it connects

### If this is the first group:

```java
head = kthNode;
```

So head becomes:

```text
3
```

---

### If previous group exists:

```java
prevLast.next = kthNode;
```

So previous tail points to current group head.

---

### Then update tail reference:

```java
prevLast = temp;
```

Because `temp` is now the last node of this reversed group.

---

### Move to next block:

```java
temp = nextNode;
```

---

# 🎯 Intuition

```text
Reverse every complete block of k nodes,
and stitch the blocks together one by one.
```

---

# 🔄 Example Dry Run

Input:

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10
```

`k = 3`

---

## First block

```text
1 → 2 → 3
```

Reversed:

```text
3 → 2 → 1
```

Connect head:

```text
head = 3
prevLast = 1
temp = 4
```

---

## Second block

```text
4 → 5 → 6
```

Reversed:

```text
6 → 5 → 4
```

Connect:

```text
1 → 6
```

Update:

```text
prevLast = 4
temp = 7
```

---

## Third block

```text
7 → 8 → 9
```

Reversed:

```text
9 → 8 → 7
```

Connect:

```text
4 → 9
```

Update:

```text
prevLast = 7
temp = 10
```

---

## Last block

```text
10
```

Less than `k`, so it stays as it is.

Connect:

```text
7 → 10
```

Final list:

```text
3 → 2 → 1 → 6 → 5 → 4 → 9 → 8 → 7 → 10
```

---

# ⚠️ Important Notes

```text
Only full groups of k nodes are reversed
```

If the last group has fewer than `k` nodes, it remains unchanged.

---

# ❌ Common Mistakes

* ❌ Forgetting to cut the group before reversing
* ❌ Forgetting to connect previous reversed block
* ❌ Not updating head for the first group
* ❌ Losing the pointer to next block
* ❌ Reversing incomplete last group

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

---

# 🎯 Interview Insight

👉
“I process the list in blocks of k nodes. For each block, I first find the kth node, cut the block, reverse it, and then connect it to the previous reversed block. If the remaining nodes are fewer than k, I leave them as they are.”

---

# 🔥 Key Insight

```text
K-group reversal = isolate block + reverse block + reconnect
```

---

# 🚀 Key Takeaways

* Reverse list in chunks of size `k`
* Only complete groups are reversed
* Use `prevLast` to connect groups
* Keep track of next block before reversing
* O(1) extra space

---

# 🔥 Pattern Connection

* Linked list reversal
* Group-wise processing
* Pointer stitching technique

---

## ✅ Small Code Note

In this code:

* `getKthNode(temp, k)` finds the end of the current block
* `kthNode.next = null` isolates the block
* `reverse(temp)` reverses that isolated group
* `if(temp == head)` updates the new head
* `prevLast.next = kthNode` connects previous reversed block to current one
* `prevLast = temp` stores the tail of the current reversed block
