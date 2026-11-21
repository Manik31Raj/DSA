# 🃏 Insertion Sort

---

# 📌 Problem

Sort an array of `n` elements in **ascending order** in-place by building a sorted prefix one element at a time and inserting each new element into its proper spot.

---

# 🌲 Example

### Input

```text
[6, 8, 3, 4, 2]
```

### Output

```text
[2, 3, 4, 6, 8]
```

---

# 🔥 Core Idea

### Partition at Index `i`

```text
[ Sorted Left (0 .. i - 1) ] | [ Key (i) ] [ Unsorted Right (i + 1 .. n - 1) ]
```

### In Every Step

```text
Pick current element key = arr[i]
Shift larger elements in the sorted left portion one slot right
Place key into the opened slot at index (j + 1)
```

---

# 🧠 Why This Approach?

Think of sorting cards in your hand:

```text
A single element at index 0 is already sorted
Take the next card (key = arr[i])
Slide larger cards right until you find its spot
Insert key cleanly without extra arrays
```

Because elements already to the left of `i` are sorted:

```text
As soon as arr[j] <= key, the insertion point is found
```

---

# 🔷 Method Signature & Key Logic

```java
public static int[] insertionSort(int[] arr)
```

---

## Working

Start from index `1` and save the candidate element:

```java
int key = arr[i];
int j = i - 1;
```

Shift elements greater than `key` to the right:

```java
while (j >= 0 && arr[j] > key) {
    arr[j + 1] = arr[j];
    j--;
}
```

Drop `key` into its sorted position:

```java
arr[j + 1] = key;
```

---

# 🌟 Pass-by-Pass Overview

```text
Array = [6, 8, 3, 4, 2]
```

| Pass (`i`) | `key` | Shifts in Left Portion | Array After Inserting `key` |
| :--- | :--- | :--- | :--- |
| 1 | `8` | None (`6 > 8` is false) | `[6, 8, 3, 4, 2]` |
| 2 | `3` | Shift `8` right, shift `6` right | `[3, 6, 8, 4, 2]` |
| 3 | `4` | Shift `8` right, shift `6` right | `[3, 4, 6, 8, 2]` |
| 4 | `2` | Shift `8`, `6`, `4`, `3` right | `[2, 3, 4, 6, 8]` |

---

# 🌟 Detailed Dry Run (Pass `i = 2`)

```text
Array before pass: [6, 8, 3, 4, 2]
key = 3, j = 1
```

Check 1 (`j = 1`, `arr[1] = 8`):

```text
1 >= 0 && 8 > 3 → True ✔ → arr[2] = 8, j becomes 0 → [6, 8, 8, 4, 2]
```

Check 2 (`j = 0`, `arr[0] = 6`):

```text
0 >= 0 && 6 > 3 → True ✔ → arr[1] = 6, j becomes -1 → [6, 6, 8, 4, 2]
```

Loop ends (`j = -1` fails `j >= 0`). Insert `key` at `arr[j + 1] = arr[0]`:

```text
arr[0] = 3 → [3, 6, 8, 4, 2]
```

---

# 🎯 Intuition

### Outer Loop (`i`)

```text
Selects the next unsorted element (`key`) to insert into the growing sorted prefix.
```

---

### Inner `while` Loop (`j`)

```text
Walks backward through the sorted prefix, shifting elements right to make room for `key`.
```

---

# ⚠️ Important Notes

### Base Case Guard

```java
if (arr.length <= 1) return arr;
```

An array of length `0` or `1` is trivially sorted.

---

### `j + 1` Insertion Index

```text
When the while loop stops, `j` points to the last element `<= key` (or `-1` if `key` is smallest), so `j + 1` is always the exact target slot.
```

---

### Stability & Online Behavior

```text
Insertion Sort IS stable and online
```

- Using `arr[j] > key` (strictly greater) preserves the relative order of equal values.
- Can sort streaming elements one at a time as they arrive.

---

# ❌ Common Mistakes

❌ Writing `arr[j] = key` inside the `while` loop instead of shifting `arr[j + 1] = arr[j]`

❌ Putting `j >= 0` after `arr[j] > key` (if order were reversed without short-circuiting, `arr[-1]` would throw `ArrayIndexOutOfBoundsException`)

❌ Inserting `key` at `arr[j]` instead of `arr[j + 1]`

❌ Using `arr[j] >= key` unnecessarily (shifts equal elements even when not needed)

---

# ⚡ Complexity

## Time Complexity

### Best Case

```text
O(N)
```

(Already-sorted array: inner `while` condition fails immediately on every pass)

### Average Case

```text
O(N²)
```

### Worst Case

```text
O(N²)
```

(Reverse-sorted array: every element shifts across the entire sorted prefix)

---

## Space Complexity

### Auxiliary Space

```text
O(1)
```

(Sorts in-place using only `key`, `j`, and loop index `i`)

---

# 🎯 Interview Explanation

👉

"Insertion Sort builds a sorted left subarray one element at a time. For each element `key` at index `i` from `1` to `n - 1`, it shifts elements larger than `key` one position to the right and places `key` into its open spot. It runs in `O(N)` best-case time on nearly or already sorted data, `O(N²)` in average and worst cases, uses `O(1)` extra space, and stays stable."

---

# 🔥 Key Insight

```text
Keep the left side sorted by shifting larger items right and dropping `key` into the gap.
```

```text
Insertion Sort
= Sorted left prefix + Unsorted right suffix
+ Right shifts instead of full swaps
+ O(N) best case, O(N²) worst case
+ O(1) space & Stable
```

---

# 🚀 Key Takeaways

- Sorts in-place with `O(1)` auxiliary space
- Stable sorting algorithm when shifting only on `arr[j] > key`
- Runs in `O(N)` time on already-sorted or nearly-sorted arrays
- `O(N²)` time on average and reverse-sorted inputs
- Works well for small arrays and online/streaming data

---

# ⚡ Complexity Summary

| Case | Time | Space | Shifts |
| :--- | :--- | :--- | :--- |
| Best Case | `O(N)` | `O(1)` | `0` |
| Average Case | `O(N²)` | `O(1)` | `O(N²)` |
| Worst Case | `O(N²)` | `O(1)` | `O(N²)` |

---

# 🚀 Quick Revision Sheet

| Concept | Rule / Formula | Remember Trick 🧠 |
| :--- | :--- | :--- |
| Outer Loop | `i = 1` to `n - 1` | Index `0` starts sorted |
| Key Element | `key = arr[i]` | Card to insert |
| Shift Condition | `j >= 0 && arr[j] > key` | Shift bigger items right |
| Shift Action | `arr[j + 1] = arr[j]; j--` | Make room |
| Insert Action | `arr[j + 1] = key` | Drop key in the gap |
| Best Time | `O(N)` | Already sorted input |
| Worst Time | `O(N²)` | Reverse sorted input |
| Space | `O(1)` | In-place |
| Stability | Stable | Strict `>` keeps order |

---

# 🎯 5 Things To Memorize Before Interviews

| Checkpoint | Value / Rule |
| :--- | :--- |
| Time Complexity (Best / Avg / Worst) | `O(N)` / `O(N²)` / `O(N²)` |
| Auxiliary Space | `O(1)` (In-place) |
| Outer Loop Start | `i = 1` |
| Inner Loop Condition | `j >= 0 && arr[j] > key` |
| Final Placement | `arr[j + 1] = key` |

---

# 🔥 Pattern Connection

- Sorted Prefix / Unsorted Suffix Invariant
- Right-Shifting Elements In-Place
- Nearly Sorted / Online Data Sorting
- Foundation for Shell Sort
