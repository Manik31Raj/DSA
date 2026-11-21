# 🔄 Selection Sort

---

# 📌 Problem

Sort an array of `n` elements in **ascending order** in-place by repeatedly selecting the smallest element from the unsorted portion and moving it to its sorted position.

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

### Partition into Two Regions

```text
[ Sorted Prefix ] | [ Unsorted Suffix ]
```

### In Every Pass

```text
Find minimum in unsorted suffix
Swap it with the first unsorted element
Expand sorted prefix by 1
```

---

# 🧠 Why This Approach?

Instead of shifting elements repeatedly on every comparison:

```text
Scan the entire unsorted part first
Find the exact index (loc) of the smallest value (minVal)
Perform at most 1 swap per pass
```

Because `n - 1` elements placed in their final positions automatically puts the `n`-th element in place:

```text
Total outer passes = n - 1
```

---

# 🔷 Method Signature & Key Trackers

```java
public static int[] selectionSort(int[] arr)
```

---

## Working

Maintain two trackers at the start of each pass `i`:

```java
int minVal = arr[i];
int loc = i;
```

Scan `j` from `i + 1` to `n - 1`:

```java
if (minVal > arr[j]) {
    minVal = arr[j];
    loc = j;
}
```

Swap only if a strictly smaller element was found:

```java
if (loc != i) {
    int temp = arr[i];
    arr[i] = minVal;
    arr[loc] = temp;
}
```

---

# 🌟 Pass-by-Pass Overview

```text
Array = [6, 8, 3, 4, 2]
```

| Pass (`i`) | Start State | Min Found (`minVal` @ `loc`) | Swap? | End State |
| :--- | :--- | :--- | :--- | :--- |
| 0 | `[6, 8, 3, 4, 2]` | `2` @ index `4` | Yes (`6 ↔ 2`) | `[2, 8, 3, 4, 6]` |
| 1 | `[2, 8, 3, 4, 6]` | `3` @ index `2` | Yes (`8 ↔ 3`) | `[2, 3, 8, 4, 6]` |
| 2 | `[2, 3, 8, 4, 6]` | `4` @ index `3` | Yes (`8 ↔ 4`) | `[2, 3, 4, 8, 6]` |
| 3 | `[2, 3, 4, 8, 6]` | `6` @ index `4` | Yes (`8 ↔ 6`) | `[2, 3, 4, 6, 8]` |

---

# 🌟 Detailed Dry Run (Pass `i = 0`)

```text
Array = [6, 8, 3, 4, 2]
Initial: minVal = 6, loc = 0
```

Step 1 (`j = 1`, `arr[1] = 8`):

```text
6 > 8 → False (no change)
```

Step 2 (`j = 2`, `arr[2] = 3`):

```text
6 > 3 → True ✔ → minVal = 3, loc = 2
```

Step 3 (`j = 3`, `arr[3] = 4`):

```text
3 > 4 → False (no change)
```

Step 4 (`j = 4`, `arr[4] = 2`):

```text
3 > 2 → True ✔ → minVal = 2, loc = 4
```

Swap (`loc != i` → `4 != 0`):

```text
Swap arr[0] and arr[4] → [2, 8, 3, 4, 6]
```

---

# 🎯 Intuition

### Outer Loop (`i`)

```text
Fixes the target slot where the next smallest element belongs.
```

---

### Inner Loop (`j`)

```text
Hunts down the minimum element in the remaining unsorted array.
```

---

# ⚠️ Important Notes

### Base Case Guard

```java
if (arr.length == 0 || arr.length == 1) return arr;
```

An empty or single-element array is already sorted.

---

### Maximum Swaps

```text
At most (n - 1) swaps across the entire algorithm
```

Useful when write/swap operations to memory are expensive.

---

### Stability

```text
Standard Selection Sort is NOT stable
```

Swapping non-adjacent elements can change the relative order of duplicate values.

---

# ❌ Common Mistakes

❌ Running outer loop up to `arr.length` instead of `arr.length - 1`

❌ Starting inner loop at `j = 0` or `j = i` instead of `j = i + 1`

❌ Swapping inside the inner loop (turns it into an inefficient exchange sort)

❌ Using `minVal >= arr[j]` instead of `minVal > arr[j]` (causes unnecessary extra updates on duplicates)

❌ Missing empty / single-element array check

---

# ⚡ Complexity

## Time Complexity

### Best Case

```text
O(N²)
```

### Average Case

```text
O(N²)
```

### Worst Case

```text
O(N²)
```

Total comparisons: `(n - 1) + (n - 2) + ... + 1 = n(n - 1) / 2` (always scans the unsorted suffix even if already sorted).

---

## Space Complexity

### Auxiliary Space

```text
O(1)
```

(In-place sorting using only scalar variables)

---

# 🎯 Interview Explanation

👉

"Selection Sort divides the array into a sorted prefix and an unsorted suffix. In each pass `i` from `0` to `n - 2`, I scan the unsorted portion to find the minimum element and its index, then swap it into position `i` if needed. It takes `O(N²)` time in all cases due to nested scans, uses `O(1)` extra space, and performs at most `N - 1` swaps."

---

# 🔥 Key Insight

```text
Find minimum first, swap ONCE at the end of the pass.
```

```text
Selection Sort
= (n - 1) passes
+ O(N²) comparisons
+ O(1) space
+ At most (n - 1) swaps
```

---

# 🚀 Key Takeaways

- Sorts in-place with `O(1)` auxiliary space
- Always `O(N²)` time — does not adapt to pre-sorted input
- Minimizes writes (`O(N)` swaps total)
- Not a stable sorting algorithm
- Outer loop stops at `n - 2`; inner loop starts at `i + 1`

---

# ⚡ Complexity Summary

| Case | Time | Space | Swaps |
| :--- | :--- | :--- | :--- |
| Best Case | `O(N²)` | `O(1)` | `0` |
| Average Case | `O(N²)` | `O(1)` | `O(N)` |
| Worst Case | `O(N²)` | `O(1)` | `N - 1` |

---

# 🚀 Quick Revision Sheet

| Concept | Rule / Formula | Remember Trick 🧠 |
| :--- | :--- | :--- |
| Outer Loop | `i = 0` to `n - 2` | Last element auto-sorts |
| Inner Loop | `j = i + 1` to `n - 1` | Scan unsorted right side |
| Trackers | `minVal = arr[i]`, `loc = i` | Assume front is smallest |
| Update Condition | `minVal > arr[j]` | Strict `>` keeps first min |
| Swap Condition | `loc != i` | Skip self-swap |
| Comparisons | `n(n - 1) / 2` | Always `O(N²)` |
| Max Swaps | `n - 1` | 1 swap per pass |
| Space | `O(1)` | In-place |
| Stability | Unstable | Long-distance swaps |

---

# 🎯 5 Things To Memorize Before Interviews

| Checkpoint | Value / Rule |
| :--- | :--- |
| Time Complexity (Best / Avg / Worst) | `O(N²)` / `O(N²)` / `O(N²)` |
| Auxiliary Space | `O(1)` (In-place) |
| Outer Loop Bound | `i < arr.length - 1` |
| Inner Loop Start | `j = i + 1` |
| Maximum Swaps | `n - 1` swaps |

---

# 🔥 Pattern Connection

- In-Place Array Manipulation
- Comparison-Based Sorting
- Finding `k`-th Smallest Element (stop after `k` passes)
- Minimizing Memory Writes
