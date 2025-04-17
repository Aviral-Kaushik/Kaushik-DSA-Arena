# Brute Force Technique/Approach

### 🔍 What is it?
1. Brute Force refers to a straightforward approach to solving a problem by trying all possible solutions, without applying any optimization or shortcuts.
2. **Note:** Often solutions created using Brute Force Approach offers time complexity of O( n<sup>2</sup> ) or O( 2<sup>n</sup> ).

### 🧠 Core Idea
- Check every possibility.
- Often used as the first step in problem-solving.
- Can be helpful for:
    - Understanding the problem
    - Creating a baseline solution
    - Verifying correctness of optimized solutions

### ✅ When to Use It?
- When you:
    - Need a simple, working solution fast.
    - Are solving a new or unknown problem.
    - Are validating output from an optimized method.
    - Have small input size (so performance doesn’t matter much).

### 📘 Examples
**1. Maximum SubArray Sum**\
Brute Force:
```
int maxSum = Integer.MIN_VALUE;
for (int i = 0; i < n; i++) {
    int sum = 0;
    for (int j = i; j < n; j++) {
        sum += arr[j];
        maxSum = Math.max(maxSum, sum);
    }
}
```
⏱️ Time: O(n²)
- Kadane’s Algorithm improves it to O(n).

**2. Search in Array**
```
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        return i;
    }
}
```
⏱️ Time: O(n)

**3. Two Sum Problem**\
Check all pairs:
```
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        if (arr[i] + arr[j] == target) {
            return true;
        }
    }
}
```
⏱️ Time: O(n²)
- HashMap reduces this to O(n).

### ⚠️ Drawbacks
- Slow for large inputs.
- Inefficient in terms of time complexity.
- Not scalable

### 🧠 Tips for Interviews
- Always start with Brute Force to show clarity.
- Then explain its limitations, and proceed with optimization.
- Interviewers appreciate this step-by-step refinement approach.

### 🎯 Key Takeaways
- Simple, clear, and easy to implement.
- Helps understand the problem space.
- Used to validate optimized solutions.
- Often has high time complexity → O(n²), O(2ⁿ), etc.