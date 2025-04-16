# Moore's Voting Algorithm

### 🔍 What is it?
- An efficient algorithm to find the majority element in an array (an element that appears more than ⌊n/2⌋ times), if such an element exists.
- This algo is mainly used to solve problem in which we have to find majority element.
- An element is known as majority element if it exits more than n / 2 times in an array.

### ✅ When to Use It?
- You're asked to find:
    - Majority element (> n/2 times).
    - Element with the highest frequency.
- Given: Only one majority element exists.

### 🧠 Core Idea
Uses a count and candidate:
- If count is 0 → choose current element as candidate
- If current element == candidate → increment count
- Else → decrement count

This cancels out different elements pairwise.

### 📘 Algorithm (Java Code)
```
int majorityElement(int[] nums) {
    int count = 0;
    int candidate = 0;

    for (int num : nums) {
        if (count == 0) {
            candidate = num;
        }

        count += (num == candidate) ? 1 : -1;
    }

    return candidate;
}
```

### 🔁 Why It Works?
- Majority element survives cancellation of all minority elements.
- Think of it like voting — only the majority can win.

### ✅ Verification Step (Optional)
If the majority element is not guaranteed, verify the result:
```
int count = 0;
for (int num : nums) {
    if (num == candidate) count++;
}
if (count > nums.length / 2) return candidate;
else return -1; // No majority
```

⏱️ Time & Space Complexity
---
| Operation                | Time Complexity | Space Complexity |
|--------------------------|-----------------|------------------|
| Finding candidate        | O(n)            | O(1)             |
| Verification  (Optional) | O(n)            | O(1)             |
---

### 🧠 Example
Input: ```[3, 2, 3]```
Output: ```3``` (appears > 1 time, and n = 3)

Input: ```[2,2,1,1,1,2,2]```
Output: ```2```

### 🎯 Key Takeaways
- Use when one majority element is guaranteed.
- Very space-efficient (no HashMaps or sorting).
- Linear time, constant space.