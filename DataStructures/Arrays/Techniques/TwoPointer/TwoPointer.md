# Two Pointer Technique

### 🔍 What is it?
A technique where two pointers are used to iterate through data structures (usually arrays or strings) to reduce time complexity and avoid nested loops.

### ✅ When to Use It?
- Working with sorted arrays or strings
- Problems involving:
    - Pair or triplet sums
    - Removing duplicates
    - Palindrome checks
    - Reversing arrays
    - Partitioning logic

### 📘 Common Pointer Styles
1. Start-End (opposite direction)\
   → Use when array is sorted.\
   → Problems like pair sum, palindrome, etc.
2. Same-Direction (forward scan)\
   → Use when you need to compare or merge elements.\
   → Problems like merging sorted arrays, removing duplicates, etc.

### 🧠 Example 1: Pair Sum in Sorted Array
```
boolean hasPairWithSum(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) return true;
        else if (sum < target) left++;
        else right--;
    }
    return false;
}
```
🕒 Time: O(n)\
🧠 Space: O(1)

### 🧠 Example 2: Check Palindrome (String)
```
boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) return false;
        left++;
        right--;
    }
    return true;
}
```

### 🧠 Example 3: Remove Duplicates from Sorted Array
```
int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}
```

Time & Space Complexity
---
| Operation | Time Complexity | 
|-----------|-----------------|
| Time      | O(n)            |
| Space     | O(1)            |
---

### 🎯 Key Takeaways
- Reduces nested loops from O(n²) to O(n) in many cases.
- Mostly used with sorted arrays or problems involving constraints.
- Easy to implement, highly interview-friendly.
- Foundation for sliding window and binary search techniques.