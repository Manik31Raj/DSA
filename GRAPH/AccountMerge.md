# 📧 Account Merge using DSU

---

## 📌 Problem

> Given a list of accounts, merge accounts that belong to the **same person** if they share **any common email**.

---

## 🌲 Example

```text
["Alexa", "a1@com", "a4@com", "a2@com"]
["Alexa", "a5@com"]
["Raj",   "r1@com", "r4@com"]
["Alexa", "a1@com", "a3@com"]
["Raj",   "r4@com", "r2@com"]
["Mohan", "m1@com", "m2@com"]
```

---

## ✅ Idea

If two accounts share even **one email**, they should be merged into the same group.

---

# 🔥 Core Idea

```text
Use DSU to group accounts by shared emails
```

Each account is treated as a node.

If two accounts have a common email, we union them.

---

# 🧠 Why DSU?

DSU is perfect here because we need to repeatedly ask:

```text
Do these two accounts belong to the same merged person?
```

If yes, we group them together.

---

# 🔷 Working Principle

---

## Step 1: Map email → account index

For each email:

* if it appears for the first time, store current account index
* if it already exists, union the current account with the previous account

---

## Step 2: Merge connected accounts

After processing all emails, DSU gives the final connected component for every account.

---

## Step 3: Collect emails by ultimate parent

For every email in the map:

* find the ultimate parent account
* add that email to that parent’s bucket

---

## Step 4: Sort emails inside each merged group

Because final output should be ordered.

---

# 🎯 Intuition

```text
Email acts like a bridge between accounts
If two accounts share a bridge, DSU puts them in the same set
```

---

# 🔄 Example Flow

Suppose:

```text
Account 0: Alexa, a1@com, a4@com, a2@com
Account 3: Alexa, a1@com, a3@com
```

Both contain:

```text
a1@com
```

So they are merged into one DSU set.

---

Then:

```text
Account 2: Raj, r1@com, r4@com
Account 4: Raj, r4@com, r2@com
```

Both contain:

```text
r4@com
```

So they are also merged.

---

# ⚠️ Important Notes

```text
The name of a merged account is usually taken from one representative account
```

In your code:

```text
details.get(i).get(0)
```

is used as the name when building the merged group.

---

# ❌ Common Mistakes

* ❌ Forgetting to union accounts with shared emails
* ❌ Not using email → account mapping
* ❌ Forgetting to collect emails by DSU parent
* ❌ Not sorting emails in final output
* ❌ Assuming all accounts with same name should merge automatically

---

# ⚡ Complexity

* **Time Complexity:** Almost O(N × α(N))
* **Space Complexity:** O(N)

Where:

* `N` = total number of emails/accounts
* `α(N)` = inverse Ackermann function, almost constant

---

# 🎯 Interview Insight

👉
“I map each email to the first account where it appears. If the same email appears again, I union those accounts using DSU. After processing all emails, I group emails by their ultimate parent and sort them for the final merged account list.”

---

# 🔥 Key Insight

```text
Account Merge = email graph + DSU
```

---

# 🚀 Key Takeaways

* Emails are the connecting link
* DSU merges accounts efficiently
* Ultimate parent represents merged account
* Final emails are collected and sorted

---

# 🔥 Pattern Connection

* DSU / Union-Find
* Connected components
* Graph-like merging by shared attribute

---

## ✅ Small Code Note

In this code:

* `mapMailNode` stores first account index of each email
* `unionBySize(i, mapMailNode.get(email))` merges linked accounts
* `mergedEmail[parent].add(mail)` groups emails by DSU root
* `Collections.sort(...)` sorts emails in each merged account

---
