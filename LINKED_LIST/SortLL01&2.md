# 🔄 Sort a Linked List of 0s, 1s and 2s

---

## 📌 Problem

> Given a linked list containing only `0`, `1`, and `2`,
> sort the linked list.

---

## 🌲 Example

```text
1 → 0 → 0 → 1 → 1 → 2 → 0 → 1 → 2 → 2 → 1
```

After sorting:

```text
0 → 0 → 0 → 1 → 1 → 1 → 1 → 2 → 2 → 2
```

---

# 🔥 Core Idea

Instead of sorting traditionally:

```text
Create 3 separate lists:
1. list for 0s
2. list for 1s
3. list for 2s
```

Then connect them together.

---

# 🧠 Why This Approach?

Since values are only:

```text
0, 1, 2
```

we do not need merge sort or bubble sort.

We can simply:

* group nodes
* reconnect lists

This makes the solution:

✅ Faster
✅ Simpler
✅ O(N)

---

# 🔷 Dummy Nodes Used

```java
Node dummy0 = new Node(-1);
Node dummy1 = new Node(-1);
Node dummy2 = new Node(-1);
```

These are starting points for:

| Dummy  | Stores      |
| ------ | ----------- |
| dummy0 | all 0 nodes |
| dummy1 | all 1 nodes |
| dummy2 | all 2 nodes |

---

# 🔁 During While Loop

Suppose current node is:

```text
1
```

Then:

```java
dummy1.next = temp;
dummy1 = dummy1.next;
```

This appends the node to the 1-list.

Same logic for 0 and 2.

---

# 🌟 After While Loop

At this point:

You have **3 separate linked lists**.

Example:

---

## 0-list

```text
start0 → 0 → 0 → 0
```

---

## 1-list

```text
start1 → 1 → 1 → 1 → 1
```

---

## 2-list

```text
start2 → 2 → 2 → 2
```

---

# 🔥 MOST IMPORTANT PART

# 🔗 CONNECTION LOGIC EXPLAINED STEP BY STEP

This is the section you asked for.

---

# ✅ Step 1

```java
dummy0.next = (start1.next != null) ? start1.next : start2.next;
```

---

## What does this mean?

Connect:

```text
0-list  --->  1-list
```

BUT...

what if no 1 exists?

Then connect:

```text
0-list ---> 2-list
```

---

## Why `dummy0`?

At the end of while loop:

```text
dummy0 points to LAST node of 0-list
```

So:

```java
dummy0.next = ...
```

means:

```text
Attach something after the last 0
```

---

## Example

Suppose:

```text
0-list = 0 → 0 → 0
1-list = 1 → 1
2-list = 2 → 2
```

Then:

```java
dummy0.next = start1.next;
```

becomes:

```text
0 → 0 → 0 → 1 → 1
```

---

# ✅ Step 2

```java
dummy1.next = start2.next;
```

---

## Meaning

Connect:

```text
1-list ---> 2-list
```

---

## Why `dummy1`?

At end of loop:

```text
dummy1 points to LAST node of 1-list
```

So:

```java
dummy1.next = start2.next;
```

means:

```text
Attach 2-list after 1-list
```

---

## Example

Before:

```text
1 → 1
2 → 2
```

After connection:

```text
1 → 1 → 2 → 2
```

---

# ✅ Step 3

```java
dummy2.next = null;
```

---

## Why needed?

Very important.

Without this:

last node of 2-list may still point to old nodes.

That can create:

❌ cycles
❌ garbage links
❌ incorrect traversal

So we terminate the final list properly.

---

# 🔥 Final Structure

After all connections:

```text
0-list → 1-list → 2-list
```

---

# 🌟 Visual Representation

Suppose original list:

```text
1 → 0 → 2 → 1 → 0
```

---

## After grouping

```text
0-list : 0 → 0
1-list : 1 → 1
2-list : 2
```

---

## After connecting

### Step 1

```text
0 → 0 → 1 → 1
```

### Step 2

```text
0 → 0 → 1 → 1 → 2
```

### Step 3

```text
2.next = null
```

DONE ✅

---

# 🔷 Why `start0.next` is returned?

Because:

```text
start0 
is dummy node (-1)
```

Actual list starts from:

```text
start0.next
```

---

# ⚠️ Important Insight

```text
dummy pointers move,
start pointers stay fixed
```

Example:

| Pointer | Purpose               |
| ------- | --------------------- |
| dummy0  | moves while inserting |
| start0  | remembers beginning   |

---

# ❌ Common Mistakes

* ❌ Forgetting `dummy2.next = null`
* ❌ Returning `dummy0.next`
* ❌ Losing start pointers
* ❌ Not handling missing 1-list
* ❌ Creating cycles accidentally

---

# ⚡ Complexity

* **Time Complexity:** O(N)
* **Space Complexity:** O(1)

(No extra nodes created except dummy nodes)

---

# 🎯 Interview Explanation

👉
“I create three separate linked lists for 0s, 1s, and 2s using dummy nodes. Then I connect the three lists together carefully. First, I attach the 1-list after the 0-list. Then I attach the 2-list after the 1-list. Finally, I terminate the last node properly with null.”

---

# 🔥 Key Insight

```text
Grouping + reconnecting is easier than sorting
```

---

# 🚀 Final Takeaways

* Use 3 dummy nodes
* Group nodes by value
* Connect:

  ```text
  0-list → 1-list → 2-list
  ```
* Always terminate final node with null
* Keep start pointers unchanged
