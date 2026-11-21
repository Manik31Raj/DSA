# 🫧 Bubble Sort

---

# 📌 Problem

Sort an array of `n` elements in **ascending order** in-place by repeatedly comparing adjacent elements and swapping them if they are in the wrong order.

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

### Partition After Each Pass

```text
[ Unsorted Prefix ] | [ Sorted Suffix ]
```

### In Every Pass

```text
Compare adjacent pairs (arr[j] and arr[j + 1])
Swap if left element > right element
Larger values "bubble up" toward the end
```

---

# 🧠 Why This Approach?

In each pass `i`:

```text
Adjacent comparisons push the largest unsorted element to index (n - 1 - i)
The sorted tail grows by 1 element per pass
```

Because `n - 1` elements placed at the end automatically leaves the smallest element at index `0`:

```text
At most n - 1 passes needed
```

---

# 🔷 Method Signature & Key Logic

```java
public static int[] bubbleSort(int[] arr)
```

---

## Working

Compare adjacent elements in the unsorted prefix:

```java
if (arr[j] > arr[j + 1]) {
    int temp = arr[j];
    arr[j] = arr[j + 1];
    arr[j + 1] = temp;
    flag = true;
}
```

Shrink the inner loop boundary as the sorted suffix grows:

```java
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - 1 - i; j++) {
        ...
    }
    if (!flag) break;
}
```

---

# 🌟 Pass-by-Pass Overview

```text
Array = [6, 8, 3, 4, 2]
```

| Pass (`i`) | Inner Comparisons (`j < 4 - i`) | Swaps Made | Array After Pass |
| :--- | :--- | :--- | :--- |
| 0 | `j = 0..3` | `8↔3`, `8↔4`, `8↔2` | `[6, 3, 4, 2, 8]` |
| 1 | `j = 0..2` | `6↔3`, `6↔4`, `6↔2` | `[3, 4, 2, 6, 8]` |
| 2 | `j = 0..1` | `4↔2` | `[3, 2, 4, 6, 8]` |
| 3 | `j = 0` | `3↔2` | `[2, 3, 4, 6, 8]` |

---

# 🌟 Detailed Dry Run (Pass `i = 0`)

```text
Array = [6, 8, 3, 4, 2]
Inner loop runs for j = 0, 1, 2, 3
```

Step 1 (`j = 0`, compare `6` and `8`):

```text
6 > 8 → False → [6, 8, 3, 4, 2]
```

Step 2 (`j = 1`, compare `8` and `3`):

```text
8 > 3 → True ✔ → Swap → [6, 3, 8, 4, 2]
```

Step 3 (`j = 2`, compare `8` and `4`):

```text
8 > 4 → True ✔ → Swap → [6, 3, 4, 8, 2]
```

Step 4 (`j = 3`, compare `8` and `2`):

```text
8 > 2 → True ✔ → Swap → [6, 3, 4, 2, 8]
```

End of Pass 0:

```text
8 is locked at index 4 → [6, 3, 4, 2, 8]
```

---

# 🎯 Intuition

### Outer Loop (`i`)

```text
Tracks how many passes have completed and how many elements are locked at the right end.
```

---

### Inner Loop (`j`)

```text
Walks through adjacent pairs in the unsorted region and bubbles larger elements right.
```

---

# ⚠️ Important Notes

### Base Case Guard

```java
if (arr.length == 0 || arr.length == 1) return arr;
```

Empty or single-element arrays need no sorting.

---

### Early-Exit Flag Placement

```java
boolean flag = false; // Reset inside the outer loop on each pass for early exit on sorted arrays
```

If `flag` is declared outside the outer loop and never reset to `false` each pass, once `flag` becomes `true` in pass 0, `!flag` stays `false` for all remaining passes. Resetting `flag = false` at the start of each outer pass lets an already-sorted array finish in `O(N)` time.

---

### Stability

```text
Standard Bubble Sort IS stable
```

Using strict `arr[j] > arr[j + 1]` keeps equal elements in their original relative order.

---

# ❌ Common Mistakes

❌ Using `j < arr.length - 1` instead of `j < arr.length - 1 - i` (repeats unnecessary comparisons on already-sorted tail elements)

❌ Using `arr[j] >= arr[j + 1]` (causes unnecessary swaps on equal elements and can hurt stability)

❌ Not resetting `flag = false` at the start of each outer pass if using an early-exit optimization

❌ Accessing `arr[j + 1]` out of bounds when `j` reaches `arr.length - 1`

---

# ⚡ Complexity

## Time Complexity

### Best Case

```text
O(N)   (with flag reset per pass on sorted input)
```

### Average Case

```text
O(N²)
```

### Worst Case

```text
O(N²)
```

Total comparisons in worst case: `(n - 1) + (n - 2) + ... + 1 = n(n - 1) / 2`.

---

## Space Complexity

### Auxiliary Space

```text
O(1)
```

(Sorts in-place using only a temporary variable and loop indices)

---

# 🎯 Interview Explanation

👉

"Bubble Sort repeatedly compares adjacent elements and swaps them when out of order, pushing the largest unsorted element to its final spot at the end of each pass. With a per-pass swap flag, it runs in `O(N)` best-case time on already-sorted arrays, `O(N²)` average and worst-case time, and uses `O(1)` auxiliary space while preserving relative order of equal elements."

---

# 🔥 Key Insight

```text
Adjacent swaps push the maximum element of the current range to the right end.
```

```text
Bubble Sort
= Adjacent comparisons + swaps
+ Shrinking right boundary (n - 1 - i)
+ O(1) space
```

---

# 🚀 Key Takeaways

- Sorts in-place with `O(1)` auxiliary space
- Stable sort when swapping only on `arr[j] > arr[j + 1]`
- Inner loop upper bound shrinks by `i` each pass (`arr.length - 1 - i`)
- Resetting the swap flag per pass enables `O(N)` best-case early exit
- `O(N²)` time in average and worst cases

---

# ⚡ Complexity Summary

| Case | Time (with per-pass flag) | Space | Swaps |
| :--- | :--- | :--- | :--- |
| Best Case | `O(N)` | `O(1)` | `0` |
| Average Case | `O(N²)` | `O(1)` | `O(N²)` |
| Worst Case | `O(N²)` | `O(1)` | `O(N²)` |

---

# 🚀 Quick Revision Sheet

| Concept | Rule / Formula | Remember Trick 🧠 |
| :--- | :--- | :--- |
| Outer Loop | `i = 0` to `n - 2` | Number of passes |
| Inner Loop | `j = 0` to `n - 2 - i` | Skip already-sorted tail |
| Swap Condition | `arr[j] > arr[j + 1]` | Strict `>` keeps stability |
| Right Boundary | `n - 1 - i` | Largest bubbles to end |
| Best Time | `O(N)` (flag reset/pass) | Zero swaps = already sorted |
| Worst Time | `O(N²)` | Reverse-sorted array |
| Space | `O(1)` | In-place swaps |
| Stability | Stable | Equal items don't swap |

---

# 🎯 5 Things To Memorize Before Interviews

| Checkpoint | Value / Rule |
| :--- | :--- |
| Time Complexity (Best / Avg / Worst) | `O(N)` / `O(N²)` / `O(N²)` |
| Auxiliary Space | `O(1)` (In-place) |
| Inner Loop Limit | `j < arr.length - 1 - i` |
| Swap Rule | Swap adjacent only when `arr[j] > arr[j + 1]` |
| Stability | Stable |

---

# 🔥 Pattern Connection

- Adjacent Element Comparisons
- In-Place Array Sorting
- Inversion Count Intuition (each adjacent swap resolves 1 inversion)
- Early-Termination Optimization on Nearly Sorted Arrays
