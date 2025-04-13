# Sliding Window Technique

### What is Sliding Window?
- The Sliding Window Technique is used to optimize problems involving arrays or strings, especially when you need to examine contiguous sub-arrays/substrings.
- Instead of recalculating things again and again, we slide a window (range) and do incremental updates.

### When to Use It?
When you're asked to find:
- Maximum or minimum of sub-arrays
- Number of substrings with certain properties
- Longest/shortest substring with conditions
- Problems with contiguous elements in arrays or strings

### Core Idea:
1. Maintain a window (subset) of the input.
2. Move the window left to right.
3. Add new element (as window grows).
4. Remove old element (as window shrinks).
5. Keep track of result as window slides.

### Example 1: Maximum Sum of Sub-array of Size k
**Problem:** Find the maximum sum of a sub-array with size k.\
- **Brute Force: O(n*k)**

```
int maxSum = 0;
for (int i = 0; i <= n - k; i++) {
    int sum = 0;
    for (int j = 0; j < k; j++) {
        sum += arr[i + j];
    }
    maxSum = Math.max(maxSum, sum);
}
```

- **Optimized: Sliding Window (O(n))**
```
int maxSum(int[] arr, int k) {
    int windowSum = 0, maxSum = 0;

    for (int i = 0; i < k; i++) windowSum += arr[i]; // Initial window
    maxSum = windowSum;

    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k]; // Slide window
        maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
}
```

### Example 2: Longest Substring Without Repeating Characters
```
int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0, right = 0, maxLen = 0;

    while (right < s.length()) {
        if (!set.contains(s.charAt(right))) {
            set.add(s.charAt(right++));
            maxLen = Math.max(maxLen, right - left);
        } else {
            set.remove(s.charAt(left++));
        }
    }

    return maxLen;
}
```

Time & Space Complexity
---
| Operation                        | Time Complexity  | Space Complexity |
|----------------------------------|------------------|------------------|
| Brute Force                      | O(n * k)         | O(1)             |
| Sliding Window                   | O(n)             | O(1)             |
---

Other Common Problems Using Sliding Window
---
| Problem                                              | Description                            |
|------------------------------------------------------|----------------------------------------|
| Maximum/Minimum in sub-array of size k               | Maintain a deque to track max/min      |
| Longest substring with at most K distinct characters | Use a HashMap to track character count |
| Count of anagrams in a string                        | Use frequency maps and compare         |
| Binary sub-array with sum = k	                       | Sliding window + prefix sum            |
---

###  Key Takeaways
- Efficient for contiguous window problems.
- Turns O(n²) brute force into O(n) or O(n log n).
- Common in coding interviews.

# Variable Size Sliding Window Technique
Variable Size Sliding Window is a two-pointer technique where the window size changes dynamically based on a condition.
- You expand the window by moving the right pointer.
- You shrink the window by moving the left pointer.
- You try to satisfy or optimize a condition (e.g., longest, smallest, number of distinct elements, etc.).

### When to Use It?
- Problems involving substrings/sub-arrays.
- Conditions like:
  - "Longest substring with at most K distinct characters"
  - "Minimum window that contains all characters"
  - "Sub-array sum ≥ K"

### Template (General Pattern)
```
int left = 0;

for (int right = 0; right < n; right++) {
    // Include arr[right] in the window
    
    while (window is invalid) {
        // Shrink the window from left
        left++;
    }

    // Update the result if needed
}
```

### Example 1: Longest Substring with At Most K Distinct Characters
```
int longestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        map.put(c, map.getOrDefault(c, 0) + 1);

        while (map.size() > k) {
            char leftChar = s.charAt(left);
            map.put(leftChar, map.get(leftChar) - 1);
            if (map.get(leftChar) == 0) map.remove(leftChar);
            left++;
        }

        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
```

### Example 2: Smallest Sub-array with Sum ≥ K
```
int minSubArrayLen(int target, int[] nums) {
    int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];

        while (sum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left++];
        }
    }

    return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
}

```

Time & Space Complexity
---
| Operation                        | Time Complexity | Space Complexity |
|----------------------------------|-----------------|------------------|
| Expand/Shrink window             | O(n)            | O(k) or O(1)     |
---

Other Common Problems Using This
---
| Problem                                              | Idea                            |
|------------------------------------------------------|---------------------------------|
| Longest substring without repeating characters       | Set to track current characters |
| Minimum window substring                             | Frequency map comparison        |
| Count of sub-arrays with at most K distinct integers | Sliding window + hash map       |
---

### Key Takeaways
- Use two pointers: left and right
- Use while loop inside for loop to shrink window
- Adjust window based on problem-specific condition
- Helps turn O(n²) solutions into O(n) solutions
