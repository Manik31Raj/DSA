# 🔗 Doubly Linked List (DLL) in Java

---

# 📌 What is a Doubly Linked List?

A Doubly Linked List is a linked list where each node contains:

```text
1. Data
2. Address of previous node
3. Address of next node
```

---

# 🌟 Structure

```text
prev ← [data] → next
```

Each node can move:

✅ Forward
✅ Backward

---

# 🔥 Difference from Singly Linked List

| Singly LL                  | Doubly LL                    |
| -------------------------- | ---------------------------- |
| Only next pointer          | prev + next pointers         |
| Forward traversal only     | Forward & backward traversal |
| Less memory                | More memory                  |
| Easier backward operations | Hard in SLL                  |

---

# 🌲 Visualization

Example:

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 → null
```

---

# 🔥 Node Structure

```java
class Node{
    int data;
    Node prev;
    Node next;
}
```

---

# 📌 data

Stores actual value.

---

# 📌 prev

Points to previous node.

---

# 📌 next

Points to next node.

---

# 🔥 Constructor 1

```java
Node(int data){
    this.data=data;
}
```

Creates a node with:

```text
prev = null
next = null
```

---

# 🔥 Constructor 2

```java
Node(int data,Node prev,Node next){
    this.data=data;
    this.prev=prev;
    this.next=next;
}
```

Creates a fully connected node.

---

# 🌟 Creating DLL from Array

---

# 📌 Input Array

```text
[1,2,3,4,5]
```

Goal:

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 → null
```

---

# 🔥 Step 1: Create Head

```java
Node head=new Node(arr[0]);
```

```text
null ← 1 → null
```

---

# 🔥 Step 2: Current Pointer

```java
Node curr=head;
```

Used to travel while building DLL.

---

# 🔥 Loop Traversal

```java
for(int i=1;i<arr.length;i++)
```

Creates remaining nodes.

---

# 🌟 Iteration 1

Create node:

```java
Node temp=new Node(2);
```

---

## Connect Backward

```java
temp.prev=curr;
```

```text
2.prev → 1
```

---

## Connect Forward

```java
curr.next=temp;
```

```text
1.next → 2
```

---

## Move curr

```java
curr=temp;
```

---

# 🌟 Current DLL

```text
null ← 1 ⇄ 2 → null
```

---

# 🌟 Final DLL

After all iterations:

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 → null
```

---

# 🔥 Understanding Connections

For node `3`:

```text
2 ← 3 → 4
```

Meaning:

```text
3.prev = 2
3.next = 4
```

---

# 🔥 print() Function

Purpose:

```text
Traverse and display DLL
```

---

# 🌟 Traversal Logic

```java
Node temp=head;
```

Move:

```java
temp=temp.next;
```

until:

```text
null
```

---

# 🌟 Output

```text
Doubly Linked List :
1 <--> 2 <--> 3 <--> 4 <--> 5
```

---

# ⚠️ Important Edge Cases

---

## Empty Array

```java
if(arr.length==0) return null;
```

No nodes exist.

---

## Single Node

```java
if(arr.length==1) return head;
```

DLL becomes:

```text
null ← 1 → null
```

---

# 🎯 Why DLL is Powerful?

Because we can:

✅ Traverse backward
✅ Delete node easily
✅ Insert before/after easily

without needing previous traversal.

---

# ⚡ Complexity

| Operation   | Complexity |
| ----------- | ---------- |
| Create DLL  | O(N)       |
| Traversal   | O(N)       |
| Extra Space | O(1)       |

---

# ❌ Common Mistakes

* ❌ Forgetting `temp.prev = curr`
* ❌ Forgetting `curr.next = temp`
* ❌ Losing head pointer
* ❌ Not handling empty array
* ❌ Incorrect pointer updates

---

# 🎯 Interview Explanation

👉

“A doubly linked list stores both previous and next node references.
While creating the DLL from an array, each new node is connected in both directions:

* current.next → new node
* new node.prev → current”

---

# 🔥 Key Insight

```text
DLL = Two-way linked structure
```

---

# 🚀 Key Takeaways

✅ prev enables backward traversal
✅ next enables forward traversal
✅ Easier insertion/deletion than SLL
✅ More memory than SLL
✅ Dynamic structure

---

# 🌟 Final Structure

```text
null ← 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 → null
```
