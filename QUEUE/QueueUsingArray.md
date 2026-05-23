# 🔄 Queue Implementation Using Array (Circular Queue)

---

# 📌 What is Queue?

Queue follows:

```text
FIFO → First In First Out
```

The element inserted first gets removed first.

---

# 🎯 Operations Used

| Operation | Meaning              |
| --------- | -------------------- |
| push()    | insert element       |
| pop()     | remove front element |
| top()     | get front element    |
| size()    | current queue size   |

---

# 🔥 Why Circular Queue?

In normal array queue:

```text
Front moves ahead after pop()
```

Unused spaces remain wasted.

Example:

```text
[3 4 5 _ _]
 ^
 front moved
```

Even though space exists, insertion may fail.

---

# ✅ Circular Queue Fix

Use:

```text
(index + 1) % maxsize
```

This wraps index back to beginning.

---

# 🔄 Circular Movement

Example:

```text
maxsize = 5
```

```text
0 → 1 → 2 → 3 → 4
↑                 ↓
└─────────────────┘
```

---

# 🧠 Variables Used

| Variable | Purpose                    |
| -------- | -------------------------- |
| start    | front index                |
| end      | rear index                 |
| currSize | current number of elements |
| maxsize  | total capacity             |
| queue[]  | array storage              |

---

# 🔥 Initial State

```text
start = -1
end = -1
currSize = 0
```

Meaning:

```text
Queue is empty
```

---

# 📥 Push Operation

---

## Case 1: Queue Empty

```java
if(start==-1 && end==-1)
```

Insert first element.

```text
start = 0
end = 0
```

---

## Case 2: Normal Insert

```java
end = (end + 1) % maxsize;
```

Moves rear circularly.

---

# 🌟 Push Visualization

Suppose:

```text
maxsize = 4
```

Insert:

```text
3 4 2
```

Array:

```text
Index : 0 1 2 3
Queue : 3 4 2 _
```

```text
start = 0
end   = 2
```

---

# 📤 Pop Operation

Front element removed.

```java
int popped = queue[start];
```

Move front ahead:

```java
start = (start + 1) % maxsize;
```

---

# 🌟 Pop Example

Before pop:

```text
3 4 2 _
^
start
```

After pop:

```text
3 4 2 _
  ^
 start
```

Popped:

```text
3
```

---

# 🔥 Why Reset to -1?

When queue becomes empty:

```java
if(currSize == 0)
```

reset:

```java
start = -1;
end = -1;
```

This marks queue empty again.

---

# 📌 top()

Returns front element:

```java
queue[start]
```

without removing it.

---

# 📌 size()

Simply returns:

```java
currSize
```

---

# ⚠️ Queue Full Condition

```java
if(currSize == maxsize)
```

Queue overflow.

---

# ⚠️ Queue Empty Condition

```java
if(currSize <= 0)
```

Queue underflow.

---

# 🔄 Dry Run

---

## Insert 3

```text
[3 _ _ _]
S,E = 0
```

---

## Insert 4

```text
[3 4 _ _]
S = 0
E = 1
```

---

## Insert 2

```text
[3 4 2 _]
S = 0
E = 2
```

---

## Pop

Removes 3

```text
[3 4 2 _]
   ^
   S
E = 2
```

---

## Push 6

```text
[3 4 2 6]
```

---

## Push 8

Circular insertion:

```text
[8 4 2 6]
 ^
 E
```

---

# ⚡ Circular Queue Formula

```text
Next Index = (current + 1) % size
```

---

# ⏱ Complexity

| Operation | Time |
| --------- | ---- |
| push      | O(1) |
| pop       | O(1) |
| top       | O(1) |
| size      | O(1) |

---

# 🚀 Advantages

✅ Constant time operations
✅ Efficient memory usage
✅ No shifting required
✅ Circular reuse of array

---

# ❌ Limitation

Fixed size queue.

```text
Cannot grow dynamically
```

For dynamic size:

```text
Use LinkedList or Dynamic Queue
```

---

# 🎯 Interview Explanation

👉

“I implemented a circular queue using arrays.
To reuse empty spaces efficiently, I move indices using modulo arithmetic `(index + 1) % size`.
Both insertion and deletion work in O(1) time.”

---

# 🔥 Key Takeaway

```text
Circular Queue avoids wasted space in normal array queue
```
