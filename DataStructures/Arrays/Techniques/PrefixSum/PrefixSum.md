# Prefix Sum Technique

### 🔍 What is it?
The Prefix Sum Technique is used to preprocess an array to quickly calculate the sum of elements in a subarray in constant time.

It avoids re-computation of the sum for repeated queries.

### ✅ When to Use It?
- To answer range sum queries efficiently
- To find subarrays with given sum or conditions
- Used often in:
    - Sub array sum problems
    - Cumulative frequency
    - Difference arrays
    - 2D matrix range sum

### 🧠 How It Works
Given an array arr[], construct a prefix sum array:
```
prefix[0] = 0;
prefix[i] = prefix[i-1] + arr[i-1]; // 1-based indexing
```
Now, the sum of any sub array from index l to r is:
```
sum = prefix[r + 1] - prefix[l];
```

#### 📘 **Example 1:** Range Sum Query
**Problem:** Given an array, find the sum of elements from index l to r.
```
int[] prefixSum(int[] arr) {
    int n = arr.length;
    int[] prefix = new int[n + 1];
    prefix[0] = 0;

    for (int i = 1; i <= n; i++) {
        prefix[i] = prefix[i - 1] + arr[i - 1];
    }

    return prefix;
}
```
**Usage:**
```
int sumLtoR = prefix[r + 1] - prefix[l];
```

#### 📘 **Example 2:** Sub array Sum Equals K (Brute + Prefix + HashMap)
**Problem:** Count sub arrays with sum = k
```
int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int count = 0, sum = 0;

    for (int num : nums) {
        sum += num;
        count += map.getOrDefault(sum - k, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
}
```

#### 📘 **Example 3:** 2D Prefix Sum (Matrix)
```
// prefix[i][j] = sum of rectangle (0,0) to (i,j)
prefix[i][j] = mat[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
```
Then, use inclusion-exclusion to compute any rectangular sub matrix sum in O(1).

Time & Space Complexity
---
| Operation        | Time Complexity | Space Complexity |
|------------------|-----------------|------------------|
| Preprocessing    | O(n)            | O(n)             |
| Range sum query  | O(1)            | -                |
---

### 🧠 Common Variants
- **Difference Array:** Useful for applying multiple range updates in O(1).
- **Prefix XOR:** For XOR-based range queries.
- **2D Prefix Sum:** For sub matrix queries in constant time.

### 🎯 Key Takeaways
- Great for range-based problems.
- Transforms repeated work into constant time.
- Common in interviews and competitive programming.

# How is Prefix Sum is useful
**Question:** How is Prefix Sum technique is Useful, like I have one question as in preprocessing we are running O(n) operations so how is it reducing time complexity and why to do preprocessing if the operations is taking O(n) so why not we use other approach as O(n) is not a bad complexity at all.

### 🔁 The Core Idea of Prefix Sum
Prefix sum is a preprocessing technique used to answer range sum queries (or similar queries) efficiently.

**Suppose:**
You have an array A[] of size n, and you're asked to find the sum of elements between indices i and j, many times (say q times).

### 🧠 Without Prefix Sum
Each time you get a query (i, j), you loop from i to j and compute the sum.
Time per query: O(n) (in the worst case, when i = 0, j = n-1).
Total time for q queries: O(q * n).

### With Prefix Sum
You preprocess the prefix sum array P[] where:
```
P[0] = A[0]
P[1] = A[0] + A[1]
...
P[i] = A[0] + A[1] + ... + A[i]
```

Then to find sum(i, j), you use:
```
sum(i, j) = P[j] - P[i-1]
```
- Preprocessing time: O(n).
- Query time: O(1).
- Total time for q queries: O(n + q).

### ✅ So Why Is This Useful?
When:
- You have multiple queries (i.e., q is large).
- You want to reduce time per query to constant.
- You are fine with spending O(n) once.
Then prefix sum drastically improves efficiency.

### 📌 Key Point
1. Prefix sum doesn't reduce the complexity of a single task, but amortizes the cost across many operations.
2. Because you're not doing one operation — you're doing many. Preprocessing makes the future operations cheap.

### ✅ When Not to Use Prefix Sum?
- If you're doing only one query → no big benefit.
- If your array is dynamic (elements change frequently) → prefix sum becomes inefficient.
- If you care about memory a lot → it uses extra space.

