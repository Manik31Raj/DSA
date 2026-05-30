# 🔄 Rotate a Singly Linked List

---

## 📌 Problem

> Rotate a linked list by `k` positions.

This can be done in two ways:

* **Right rotation** → last `k` nodes move to the front
* **Left rotation** → first `k` nodes move to the end

---

# 🌟 Example

Original list:

```text
1 → 2 → 3 → 4 → 5
```

If `k = 2`:

### Right rotation

```text
4 → 5 → 1 → 2 → 3
```

### Left rotation

```text
3 → 4 → 5 → 1 → 2
```

---

# 🔥 Core Idea

```text
Make the list circular first,
then break it at the correct position
```

That is the cleanest way to rotate a linked list.

---

# 🧠 Why This Works

If we connect the tail to the head:

```text
1 → 2 → 3 → 4 → 5 → back to 1
```

the list becomes a ring.

Then:

* for **left rotation**, break after the `kth` node
* for **right rotation**, break after the `(len - k - 1)th` node

So the same circular trick works for both directions.

---

# 🔷 Important Helpers

---

## 1) `getLength(head)`

Finds the total number of nodes.

---

## 2) `getTail(head)`

Finds the last node of the list.

---

# 🔁 Left Rotation

---

## 🧠 Meaning

```text
Move the first k nodes to the end
```

Example:

```text
1 → 2 → 3 → 4 → 5
```

Left rotate by `2`:

```text
3 → 4 → 5 → 1 → 2
```

---

## 🔁 Working Principle

### Step 1

Find length `len`.

### Step 2

If `k % len == 0`, no change.

### Step 3

Connect tail to head to make circular list.

### Step 4

Move to the `(k % len - 1)`th node.

### Step 5

The next node becomes the new head.

### Step 6

Break the link there.

---

## 🎯 Intuition

```text
The first k nodes go behind the list
```

So we cut the list after the k-th node and shift the head forward.

---

# 🔷 Right Rotation

---

## 🧠 Meaning

```text
Move the last k nodes to the front
```

Example:

```text
1 → 2 → 3 → 4 → 5
```

Right rotate by `2`:

```text
4 → 5 → 1 → 2 → 3
```

---

## 🔁 Working Principle

### Step 1

Find length `len`.

### Step 2

If `k % len == 0`, no change.

### Step 3

Convert to circular list by linking tail to head.

### Step 4

Find the node at position:

```text
len - k - 1
```

This node becomes the new tail.

### Step 5

The next node becomes the new head.

### Step 6

Break the link after that node.

---

## 🎯 Intuition

```text
The last k nodes are brought to the front
```

So we cut the ring at the correct position from the end.

---

# 🌲 Dry Run

Original:

```text
1 → 2 → 3 → 4 → 5
```

Length = `5`

---

## Left rotation by 2

* make list circular:

  ```text
  1 → 2 → 3 → 4 → 5 → 1
  ```

* move to node `2`

* new head = `3`

* break after `2`

Final:

```text
3 → 4 → 5 → 1 → 2
```

---

## Right rotation by 2

* make list circular:

  ```text
  1 → 2 → 3 → 4 → 5 → 1
  ```

* find node at `len - k - 1 = 2`

* that node is `3`

* new head = `4`

* break after `3`

Final:

```text
4 → 5 → 1 → 2 → 3
```

---

# ⚠️ Important Notes

```text
k can be larger than length
```

So we always use:

```text
k % len
```

to reduce unnecessary full rotations.

---

# ❌ Common Mistakes

* ❌ Forgetting to make list circular
* ❌ Forgetting to break the cycle at the end
* ❌ Not handling `k % len == 0`
* ❌ Using wrong cut position for right rotation
* ❌ Not checking empty list

---

# ⚡ Complexity

| Operation      | Time | Space |
| -------------- | ---- | ----- |
| Left Rotation  | O(N) | O(1)  |
| Right Rotation | O(N) | O(1)  |

---

# 🎯 Interview Insight

👉
“To rotate a singly linked list, I first compute the length and find the tail. Then I temporarily connect the tail to the head to form a circular list. For left rotation, I break the list after the k-th node. For right rotation, I break it after the `(len-k-1)`th node. This gives an O(N) time and O(1) space solution.”

---

# 🔥 Key Insight

```text
Rotation = make circular + cut at correct point
```

---

# 🚀 Key Takeaways

* Find length first
* Handle `k % len`
* Make the list circular
* Break at the correct node
* O(1) extra space

---

# 🔥 Pattern Connection

* Linked list pointer manipulation
* Circular list trick
* Head/tail relinking

---

## ✅ Small Code Note

In this code:

* `leftRotataion()` cuts after the `k % len - 1`th node
* `rightRotataion()` cuts after the `len - k % len - 1`th node
* `tail.next = head` makes the list circular
* `temp.next = null` breaks the cycle and finalizes the rotated list
