# 🔄 Detect Loop / Cycle in Linked List

## (Floyd’s Cycle Detection Algorithm)

---

# 📌 Problem

Check whether a linked list contains a cycle (loop).

---

# 🌲 Example

Your linked list:

```text id="6a4u0m"
1 → 2 → 4 → 3 → 9 → 12 → 5 → 6 → 7 → 8
                ↑______________________|
```

Node `8` points back to node `3`.

So this linked list contains a loop.

---

# 🔥 Main Idea

Use two pointers:

| Pointer | Speed         |
| ------- | ------------- |
| slow    | moves 1 step  |
| fast    | moves 2 steps |

---

# 🧠 Why This Works

If there is a cycle:

```text id="2m3btx"
fast pointer will eventually catch slow pointer
```

because:

* both are moving inside a circular path
* fast moves quicker
* distance between them keeps reducing

Exactly like two runners on a circular track.

---

# 🐢🐇 Tortoise & Hare Algorithm

This algorithm is also called:

```text id="cncr9q"
Floyd’s Cycle Detection Algorithm
```

or

```text id="tx3x5j"
Tortoise and Hare Algorithm
```

---

# 🔁 Dry Run

Suppose:

```text id="v7ul7s"
1 → 2 → 3 → 4 → 5
          ↑     ↓
          ← ← ←
```

---

## Initial State

```text id="6r7y8l"
slow = 1
fast = 1
```

---

## Iteration 1

```text id="9xq2h8"
slow = 2
fast = 3
```

---

## Iteration 2

```text id="wgn5qd"
slow = 3
fast = 5
```

---

## Iteration 3

```text id="lnr3g2"
slow = 4
fast = 4
```

Both meet.

So:

```text id="mgsphz"
Cycle exists
```

---

# 🎯 Key Observation

If there is no cycle:

```text id="x3e6o8"
fast will reach null
```

because fast moves 2 steps.

---

# 🔷 Why Fast Meets Slow in Cycle

Suppose:

| Pointer | Speed   |
| ------- | ------- |
| slow    | 1 step  |
| fast    | 2 steps |

Difference in speed:

```text id="zvkm9d"
1 step per iteration
```

So fast gains 1 node every move.

Inside a loop:

```text id="jlwmcb"
fast must eventually catch slow
```

---

# 🔥 Visual Understanding

Inside loop:

```text id="e5drxm"
slow → → →
fast → → → →
```

Fast keeps closing the gap.

---

# ✅ Your Code Flow

---

## Step 1

```java id="c4rrp8"
Node slow = head;
Node fast = head;
```

Both start at head.

---

## Step 2

```java id="eq7uoq"
while(fast != null && fast.next != null)
```

This prevents null pointer exception.

Because fast moves 2 steps.

---

## Step 3

```java id="nyw5nv"
slow = slow.next;
fast = fast.next.next;
```

* slow moves 1 node
* fast moves 2 nodes

---

## Step 4

```java id="vowj1x"
if(slow == fast)
```

If both pointers meet:

```text id="t6l2eh"
Loop exists
```

---

## Step 5

If loop finishes:

```java id="i6m90p"
return false;
```

means no cycle.

---

# ⚡ Complexity

| Complexity | Value |
| ---------- | ----- |
| Time       | O(N)  |
| Space      | O(1)  |

---

# ❌ Why Better Than HashSet Method?

Another approach:

```text id="n5rk4x"
Store visited nodes in HashSet
```

But:

| Method          | Space |
| --------------- | ----- |
| HashSet         | O(N)  |
| Floyd Algorithm | O(1)  |

So Floyd’s algorithm is optimal.

---

# 🔥 Important Insight

```text id="9v1i6n"
Meeting point is guaranteed only if cycle exists
```

---

# 🚀 Applications

This algorithm is used in:

* Detect cycle
* Find cycle starting node
* Find cycle length
* Happy Number problem
* Circular array problems

---

# ⚠️ Small Bug in Your Code

In `convertArrayToLL()`:

```java id="hgrn5x"
mover.next = loop;
```

If `loopPoint == null`

then:

```text id="40q9z8"
last node points to null
```

otherwise cycle is created.

Safer version:

```java id="b7j6y1"
if(loop != null){
    mover.next = loop;
}
```

---

# 🎯 Interview Explanation

👉

“I use Floyd’s Cycle Detection Algorithm where slow moves one step and fast moves two steps. If a cycle exists, fast eventually meets slow inside the loop. If fast reaches null, then no cycle exists.”

---

# ✅ Key Takeaway

```text id="q7n5j1"
Fast catches slow only inside a cycle
```

That is the complete intuition behind Floyd’s algorithm.
