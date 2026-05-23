# 🔗 Singly Linked List in Java

---

# 📌 What is a Linked List?

A Linked List is a linear data structure where:

```text id="m1"
Each node stores:
1. Data
2. Address of next node
```

Unlike arrays:

✅ Dynamic size
✅ Non-contiguous memory allocation

---

# 🌟 Structure of Node

```java
class Node{
    int data;
    Node next;
}
```

---

# 🧠 Visualization

Example:

```text id="m2"
1 → 2 → 3 → 4 → null
```

Each box contains:

```text id="m3"
[data | nextAddress]
```

---

# 🔥 Node Class Explanation

```java
class Node{
    int data;
    Node next;
```

---

## 📌 data

Stores actual value.

Example:

```text id="m4"
1 , 2 , 3 , 4
```

---

## 📌 next

Stores reference/address of next node.

---

# 🔥 Constructor 1

```java
Node(int data){
    this.data=data;
    this.next=null;
}
```

Creates node pointing to:

```text id="m5"
null
```

Example:

```text id="m6"
[1|null]
```

---

# 🔥 Constructor 2

```java
Node(int data,Node next){
    this.data=data;
    this.next=next;
}
```

Creates node already connected to another node.

---

# 🌟 Main Flow

```java
int[] arr={1,2,3,4};
```

Convert array into Linked List.

---

# 🔄 convertArrayToLL()

---

## Step 1: Create Head

```java
Node head=new Node(arr[0]);
```

```text id="m7"
head
 ↓
[1|null]
```

---

## Step 2: mover Pointer

```java
Node mover=head;
```

Used to travel through list.

---

# 🔥 Loop Traversal

```java
for(int i=1;i<arr.length;i++)
```

Creates remaining nodes.

---

# 🌟 Iteration 1

```java
Node temp=new Node(2);
```

```text id="m8"
[2|null]
```

Connect:

```java
mover.next=temp;
```

```text id="m9"
1 → 2 → null
```

Move mover:

```java
mover=temp;
```

---

# 🌟 Iteration 2

```text id="m10"
1 → 2 → 3 → null
```

---

# 🌟 Iteration 3

```text id="m11"
1 → 2 → 3 → 4 → null
```

---

# 📌 Final Linked List

```text id="m12"
head
 ↓
1 → 2 → 3 → 4 → null
```

---

# 🔥 lengthOfLL()

Purpose:

```text id="m13"
Find number of nodes
```

---

# 🌟 Logic

```java
Node temp=head;
```

Traversal pointer.

---

# 🔄 Traversal

```java
while(temp!=null)
```

Move until:

```text id="m14"
null
```

---

# 🌟 Dry Run

```text id="m15"
1 → 2 → 3 → 4 → null
```

| temp | count |
| ---- | ----- |
| 1    | 1     |
| 2    | 2     |
| 3    | 3     |
| 4    | 4     |

Stops at:

```text id="m16"
null
```

Returns:

```text id="m17"
4
```

---

# 🔥 checkIfPresent()

Purpose:

```text id="m18"
Search element in Linked List
```

---

# 🌟 Logic

Traverse node by node.

```java
if(temp.data==val)
```

Return:

```text id="m19"
true
```

---

# 🌟 Example

Search:

```text id="m20"
2
```

Traversal:

```text id="m21"
1 → 2
```

Found:

```text id="m22"
true
```

---

# 📌 Time Complexity

| Operation          | Complexity |
| ------------------ | ---------- |
| Convert Array → LL | O(N)       |
| Find Length        | O(N)       |
| Search Element     | O(N)       |

---

# 🔥 Why Use temp Pointer?

If we directly move:

```java
head=head.next;
```

We lose original head.

So we use:

```java
Node temp=head;
```

---

# 🌟 Memory Representation

```text id="m23"
head
 ↓

[data|next] → [data|next] → [data|next]
```

---

# 🔥 Difference from Array

| Array             | Linked List    |
| ----------------- | -------------- |
| Fixed size        | Dynamic        |
| Contiguous memory | Random memory  |
| Fast indexing     | Slow indexing  |
| Insertion costly  | Easy insertion |

---

# 🚀 Interview Explanation

👉

“A singly linked list stores data and next node reference.
Traversal is done using temporary pointers.
Insertion is efficient because nodes are dynamically connected using references.”

---

# 🎯 Key Takeaways

✅ Head stores starting node
✅ next connects nodes
✅ Traversal stops at null
✅ Dynamic memory structure
✅ Sequential access only

---

# 🌟 Final Structure

```text id="m24"
head
 ↓
1 → 2 → 3 → 4 → null
```
