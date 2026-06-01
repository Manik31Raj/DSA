# 🌐 Browser History using Doubly Linked List

---

# 📌 Problem

Design a browser history system that supports:

- visiting a new page
- moving back by `k` steps
- moving forward by `k` steps

---

# 🌲 Example

```text
Google → Facebook → Instagram
```

Operations:

- `back(1)` → move one page backward
- `forward(1)` → move one page forward
- `visit(url)` → open a new page

---

# 🔥 Core Idea

```text
Use a doubly linked list to move backward and forward easily
```

Each page knows:

- previous page
- next page

So navigation becomes very simple.

---

# 🧠 Why Doubly Linked List?

A singly linked list can only move in one direction.

But browser history needs:

- Back
- Forward

That is exactly why a doubly linked list is perfect here.

---

# 🔷 Node Structure

```java
class Node{
    String url;
    Node back;
    Node next;
}
```

---

## 📌 url

Stores the page name or address.

Example:

```text
Google
Facebook
Instagram
```

---

## 📌 back

Points to the previous page.

---

## 📌 next

Points to the next page.

---

# 🔥 Browser Class

```java
class Browser{
    Node currentPage;
}
```

---

## Meaning

`currentPage` always points to the page currently open in the browser.

---

# 🔁 Working Principle

---

## 1) Start with home page

```java
Browser page = new Browser("Google");
```

So initially:

```text
Google
```

---

## 2) Visit a new page

```java
visit("Facebook")
```

Create a new node and connect:

- current page → new page
- new page → current page

Then move current page to the new page.

---

## 3) Move back

```java
back(steps)
```

Move `currentPage` to `back` pointer `steps` times, if possible.

---

## 4) Move forward

```java
forward(steps)
```

Move `currentPage` to `next` pointer `steps` times, if possible.

---

# 🎯 Intuition

```text
Browser history is like a two-way road
```

- `back` moves left
- `forward` moves right
- `visit` opens a fresh page

---

# 🌟 Dry Run

Initial:

```text
Google
```

---

## Visit Facebook

```text
Google ⇄ Facebook
```

Current:

```text
Facebook
```

---

## Visit Instagram

```text
Google ⇄ Facebook ⇄ Instagram
```

Current:

```text
Instagram
```

---

## back(3)

Move backward until possible:

```text
Instagram → Facebook → Google
```

Current becomes:

```text
Google
```

---

# ⚠️ Important Note

In a real browser, when you visit a new page after going back, the forward history is usually cleared.

For example:

```text
Google ⇄ Facebook ⇄ Instagram
```

If you go back to Facebook and then visit YouTube, the `Instagram` forward path should disappear.

Your current code does **not explicitly clear the forward history** when visiting a new page.

A more complete browser-history implementation would do:

```java
currentPage.next = null;
```

before attaching the new page.

---

# ❌ Common Mistakes

* ❌ Using singly linked list instead of doubly linked list
* ❌ Forgetting to update both `back` and `next`
* ❌ Not moving current page after visit
* ❌ Not clearing forward history on new visit
* ❌ Allowing movement beyond available history

---

# ⚡ Complexity

| Operation | Time | Space |
|---|---|---|
| visit | O(1) | O(1) |
| back | O(k) | O(1) |
| forward | O(k) | O(1) |

---

# 🎯 Interview Explanation

👉  
“I use a doubly linked list to model browser history because it supports both backward and forward navigation. Each page stores pointers to the previous and next pages. Visiting a new page creates a new node and updates the current pointer, while back and forward operations simply move through the back and next links.”

---

# 🔥 Key Insight

```text
Browser history = doubly linked list navigation
```

---

# 🚀 Key Takeaways

* Doubly linked list is ideal for browser history
* `back` pointer supports backward movement
* `next` pointer supports forward movement
* `visit()` creates a new current page
* Forward history should be cleared on new visit

---

# 🔥 Pattern Connection

* Doubly linked list
* Pointer navigation
* History stack / browser simulation

---

## ✅ Small Code Note

In this code:

- `visit(url)` links the new page after current page
- `back(steps)` moves through `back` pointers
- `forward(steps)` moves through `next` pointers
- `currentPage` always tracks the active page

```
