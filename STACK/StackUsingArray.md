# 📦 Stack Implementation Using Array

---

## 📌 Definition

A **Stack** follows:

> **LIFO (Last In, First Out)**

---

## 📊 Stack Visualization (With Flow)

```id="stack-fig1"
        PUSH (IN) ↓
               ↓
          ┌───────┐   ← Top
          │  30   │
          ├───────┤
          │  20   │
          ├───────┤
          │  10   │
          └───────┘
               ↑
               ↑
        POP (OUT)
```

👉 Insert (Push) happens **from top**
👉 Remove (Pop) happens **from top**

---

## 🧭 Array Representation

```id="stack-array"
Index:   0    1    2    3    4
        ------------------------
Value:  10   20   30   -    -
                ↑
               top = 2
```

---

## 🔁 Operations Flow

---

### 🔹 Push Operation

```id="push-flow"
Before Push:

          ┌───────┐
Top →     │  20   │
          ├───────┤
          │  10   │
          └───────┘

Push 30 ↓

After Push:

          ┌───────┐
Top →     │  30   │
          ├───────┤
          │  20   │
          ├───────┤
          │  10   │
          └───────┘
```

---

### 🔹 Pop Operation

```id="pop-flow"
Before Pop:

          ┌───────┐
Top →     │  30   │
          ├───────┤
          │  20   │
          ├───────┤
          │  10   │
          └───────┘

Pop ↑ (remove 30)

After Pop:

          ┌───────┐
Top →     │  20   │
          ├───────┤
          │  10   │
          └───────┘
```

---

## 🧠 Core Idea

* All operations happen at **top**
* `top` pointer tracks last inserted element

---

## 🔑 Key Formulas

```id="formulas"
Push → stack[++top] = value
Pop  → stack[top--]
Peek → stack[top]
Size → top + 1
```

---

## ⚠️ Conditions

* **Overflow:** top == maxSize - 1
* **Underflow:** top == -1

---

## 🎯 Intuition

Think of a **vertical container**:

* Elements go **in from top**
* Elements come **out from top**

👉 No middle access

---

## 🚀 Key Takeaways

* Stack = LIFO
* Push ↓, Pop ↑
* Only top is accessible
* Array + pointer = efficient

---
