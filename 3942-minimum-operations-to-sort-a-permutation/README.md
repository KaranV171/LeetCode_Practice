# 4184. Minimum Operations to Sort a Permutation

[LeetCode problem](https://leetcode.com/problems/minimum-operations-to-sort-a-permutation)

## Problem Summary

We may perform only these operations:

1. **Reverse** the entire array.
2. **Rotate left by one**: move the first element to the end.

The goal is to transform the permutation into:

```text
[0, 1, 2, ..., n - 1]
```

Return the minimum number of operations, or `-1` if sorting is impossible.

---

## Main Idea

The position of `0` is important because the sorted array always starts with `0`.

After locating `0`, check whether the remaining values appear in increasing order in either circular direction:

- `inc`: values increase while moving forward/right.
- `dec`: values increase while moving backward/left.

For every neighboring pair, the next value must be exactly one greater:

```java
nums[curr] == nums[prev] + 1
```

If neither direction is valid, the answer is `-1`.

---

## Finding the Position of `0`

```java
int zero = -1;

for (int i = 0; i < n; i++) {
    if (nums[i] == 0) {
        zero = i;
        break;
    }
}
```

`zero` stores the index of `0`.

Example:

```text
nums  = [2, 3, 0, 1]
index =  0  1  2  3
```

Here:

```text
zero = 2
```

The `-1` initialization allows us to detect if `0` was not found:

```java
if (zero == -1) {
    return -1;
}
```

For the given problem, `nums` is guaranteed to be a permutation containing `0`, but this check is still safe.

---

## Checking `inc`

```java
boolean inc = true;
```

`inc` checks the array while moving forward through circular indexes.

Example:

```text
nums = [2, 3, 0, 1]
zero = 2
```

Moving forward from `0` gives:

```text
indices: 2 -> 3 -> 0 -> 1
values:  0 -> 1 -> 2 -> 3
```

This is a valid increasing order, so `inc` remains `true`.

```java
int prev = (zero + i - 1) % n;
int curr = (zero + i) % n;

if (nums[curr] != nums[prev] + 1) {
    inc = false;
}
```

The `% n` makes the indexes circular. For example, when `n = 4`:

```java
(3 + 1) % 4 = 0
```

So moving forward from index `3` goes back to index `0`.

---

## Checking `dec`

```java
boolean dec = true;
```

`dec` checks the array while moving backward through circular indexes.

The name `dec` refers to decreasing indexes; the values must still increase.

Example:

```text
nums = [1, 0, 3, 2]
zero = 1
```

Moving backward from `0` gives:

```text
indices: 1 -> 0 -> 3 -> 2
values:  0 -> 1 -> 2 -> 3
```

This is also a valid increasing order, so `dec` remains `true`.

```java
prev = (zero - i + 1 + n) % n;
curr = (zero - i + n) % n;

if (nums[curr] != nums[prev] + 1) {
    dec = false;
}
```

### Why add `n`?

Java can return a negative result from `%`.

Without adding `n`:

```java
zero = 1;
i = 3;
n = 4;

(zero - i) % n
= (1 - 3) % 4
= -2
```

`nums[-2]` is invalid.

Adding `n` makes the index safe:

```java
(zero - i + n) % n
= (1 - 3 + 4) % 4
= 2
```

---

# Calculating the Minimum

```java
int ans = Integer.MAX_VALUE;
```

`ans` stores the smallest valid operation count found so far.

`Math.min()` compares possible strategies and keeps the smaller one.

---

## If `inc` Is True

```java
if (inc) {
    ans = Math.min(ans, zero);
    ans = Math.min(ans, n - zero + 2);
}
```

### Option 1: Rotate only

```java
ans = Math.min(ans, zero);
```

If values increase while moving forward, rotate left until `0` reaches index `0`.

Example:

```text
[2, 3, 0, 1]
```

Here `zero = 2`:

```text
[2, 3, 0, 1]
[3, 0, 1, 2]   // 1 rotation
[0, 1, 2, 3]   // 2 rotations
```

Cost:

```text
zero = 2
```

### Option 2: Reverse, rotate, reverse

```java
ans = Math.min(ans, n - zero + 2);
```

The operation count is:

```text
1 reverse + (n - zero) rotations + 1 reverse
= n - zero + 2
```

The `+2` represents the two reverse operations.

---

## If `dec` Is True

```java
if (dec) {
    ans = Math.min(ans, zero + 2);
    ans = Math.min(ans, n - zero);
}
```

### Option 1: Rotate, then reverse

```java
ans = Math.min(ans, zero + 2);
```

The operations are:

```text
(zero + 1) rotations + 1 reverse
= zero + 2
```

Example:

```text
nums = [1, 0, 3, 2]
zero = 1
```

Rotate left twice, then reverse:

```text
[1, 0, 3, 2]
[0, 3, 2, 1]   // 1 rotation
[3, 2, 1, 0]   // 2 rotations
[0, 1, 2, 3]   // reverse
```

Total:

```text
2 rotations + 1 reverse = 3
zero + 2 = 1 + 2 = 3
```

### Option 2: Reverse, then rotate

```java
ans = Math.min(ans, n - zero);
```

The operation count is:

```text
1 reverse + (n - zero - 1) rotations
= n - zero
```

The `+1` for the reverse and the `-1` in the number of rotations cancel out.

---

## Formula Summary

| Direction | Operations | Cost |
|---|---|---:|
| `inc` | Rotate left `zero` times | `zero` |
| `inc` | Reverse, rotate, reverse | `n - zero + 2` |
| `dec` | Rotate left `zero + 1` times, reverse | `zero + 2` |
| `dec` | Reverse, then rotate | `n - zero` |

The answer is the minimum of every valid cost.

---

## Complete Solution

```java
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        if (zero == -1) {
            return -1;
        }

        boolean inc = true;
        boolean dec = true;

        for (int i = 1; i < n; i++) {
            // Check increasing order while moving forward.
            int prev = (zero + i - 1) % n;
            int curr = (zero + i) % n;

            if (nums[curr] != nums[prev] + 1) {
                inc = false;
            }

            // Check increasing order while moving backward.
            prev = (zero - i + 1 + n) % n;
            curr = (zero - i + n) % n;

            if (nums[curr] != nums[prev] + 1) {
                dec = false;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (inc) {
            ans = Math.min(ans, zero);
            ans = Math.min(ans, n - zero + 2);
        }

        if (dec) {
            ans = Math.min(ans, zero + 2);
            ans = Math.min(ans, n - zero);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
```

---

## Complexity

```text
Time Complexity:  O(n)
Space Complexity: O(1)
```

The array is scanned once, and no extra array or data structure is used.
