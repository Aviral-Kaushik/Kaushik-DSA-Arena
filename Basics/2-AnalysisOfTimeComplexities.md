# Analysis

## 1. Analysis of Simple Loops

**Example 1:**
```
    for (int i = 0; i < n; i = i + c) {
        // Some Constant Work Θ(1)
    }
```
Time Complexity: Θ(n) / O(n)\
Loop Runs: n / c times

**Example 2:**
```
    for (int i = 0; i < n; i = i - c) {
        // Some Constant Work Θ(1)
    }
```
Time Complexity: Θ(n) / O(n)\
Loop Runs: n / c times

**Example 3:**
```
    for (int i = 0; i < n; i = i * c) {
        // Some Constant Work Θ(1)
    }
```
Time Complexity: Θ(log n) / O(log n)\
Loop Runs: log n times

**Example 4:**
```
    for (int i = 0; i < n; i = i / c) {
        // Some Constant Work Θ(1)
    }
```
Time Complexity: Θ(log n) / O(log n)\
Loop Runs: log n times

**Example 5:**
```
    for (int i = 0; i < n; i = pow(i, c)) {
        // Some Constant Work Θ(1)
    }
```
Time Complexity: Θ(log (log n)) / O(log (log n))\
Loop Runs: log (log n) times

### Key Takeaways
- If there is simple + or - in the post operation part of loop & loop is running n time, then time complexity will be O(n). 
- If there is simple * or / in the post operation part of loop & loop is running log n time, then time complexity will be O(log n). 
- If there is simple power operation in the post operation part of loop then time complexity will be O(log (log n)). 

## 2. Analysis of Multiples Loops
**Example 1: Subsequent Loops (Just add the Complexity and take the max time complexity to determine the final time complexity of the function)**
```
    void fun(int n) {
        for (int i = 0; i < n; i++) { // Some Constant Work Θ(1) }
        for (int i = 0; i < n; i = i * 2) { // Some Constant Work Θ(1) }
        for (int i = 0; i < 100; i++) { // Some Constant Work Θ(1) }
    }
```
**Time Complexity of First Loop:** O(n) \
**Time Complexity of Second Loop:** O( log n) \
**Time Complexity of Third Loop:** O(1) (Runs for a constant time)\
**After adding all the complexities:** O(n) + O( log n ) + O(1)\
**Final Time Complexity:** O(n) / Θ(n) (Max Complexity from added up complexities)

**Example 2: Nested Loops (Just multiply the complexities of nested loops & that will be final time complexity of that function)**
```
    void fun(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j = j * 2) { // Some Constant Work Θ(1) }
        }
    }
```
**Time Complexity of First Loop:** O(n) \
**Time Complexity of Second Loop:** O( log n) \
**Multiply all the complexities:** O(n log n)\
**Final Time Complexity:** O(n log n) / Θ(n log n)

**Example 3: Mixed Loops (Use the above procedures and take the max complexity to determine the final complexity of that function)**
```
    void fun(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j = j * 2) { // Some Constant Work Θ(1) }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) { // Some Constant Work Θ(1) }
        }
    }
```
**Time Complexity of First Nested Loop:** O(n log n) \
**Time Complexity of Second Nested Loop:** O(n<sup>2</sup>) \
**Add all the complexities of Nested Loop:** O(n log n) + O(n<sup>2</sup>)\
**Final Time Complexity:** O(n<sup>2</sup>) / Θ(n<sup>2</sup>)

**Example 4: Mixed Loops with different inputs (Determine the complexities of each loop and add up them to determine the final complexity of the function)**
```
    void fun(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j = j * 2) { // Some Constant Work Θ(1) }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < m; j++) { // Some Constant Work Θ(1) }
        }
    }
```
**Time Complexity of First Nested Loop:** O(n log n) \
**Time Complexity of Second Nested Loop:** O(m<sup>2</sup>) \
**Add all the complexities of Nested Loop:** O(n log n) + O(m<sup>2</sup>)\
**Final Time Complexity:** O(n log n + m<sup>2</sup>) / Θ(n log n + m<sup>2</sup>)

## 3. Analysis of Recursion
**This analysis must be studied from different creator and must be practice at most**\
ChatGPT Chat Link: https://chatgpt.com/share/67c080ed-3180-8002-8c86-0983270e4eb2

Usually to determine time complexity of a recursive function we have 3 methods:
1. Recursion Tree Method
2. Master Theorem (for Divide & Conquer)
3. Substitution Method

But mainly we only use recursion tree Pattern to determine time complexity aas it is less complex and can be used to determine time complexity of most of the functions.

For Finding the time complexity of a Recursive function. Firstly we need to determine the recurrence relation, and we have to divide that recurrence relation for different sub value until we identify a patten and finally on the basis of that pattern we determine the time complexity of that function.

**Step 1: Identify the recurrence relation**

A recurrence relation shows how the problem size reduces at each recursive call. It usually looks like:

    T(n) =  (number of sub problems) * T(size of each sub problem) + work outside recursion

Example:
 - Merge Sort: T(n) = 2T(n/2) + O(n)
 - Binary Search: T(n) = T(n/2) + O(1)
 - Fibonacci: T(n) = T(n - 1) + T(n - 2) + O(1)

**Step 2: Expand the Recurrence Step by Step**

Expand the recurrence a few times until you see a pattern.

**Example 1: Merge Sort** T(n) = 2T(n/2) + O(n)
- Expand once: T(n) = 2T(n/2) + O(n)
- Expand again: T(n) = 2(2T(n / 4) + O(n / 2)) + O(n) \
  &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; = 4T(n / 4) + O(n) + O(n)
- Keep expanding until you reach 𝑇(1), which is usually 𝑂(1).

Observing the pattern, you’ll find that the depth of recursion is log n , and at each level, the total work is 𝑂(n log n).

**Step 3: Identify the Recursion Depth (Number of Levels)**\
A simple trick to find how many times the function recurses is:

If the problem size is divided by 2 at each step, recursion depth = log n.\
If the problem size is reduced by 1 at each step, recursion depth = n.

Examples:

- Binary Search: T(n) = T(n / 2) + O(1)\
Since the input is halved each time, recursion depth = O(log n).
- Fibonacci:T(n)=T(n−1)+T(n−2)+O(1)\
Since two recursive calls occur at each step, the depth grows exponentially, leading to O(2<sup>n</sup>).

**Step 4: Use a Formula if Possible**
Some common recurrence relations have well-known solutions:
---
| Recurrence Relation              | Time Complexity  |
|----------------------------------|------------------|
| T(n) = T(n / 2) + O(1)           | O(log n)         |
| T(n) = T(n / 2) + O(n)           | O(n log n)       |
| T(n) = T(n − 1) + O(1)           | O(n)             |
| T(n) = T(n − 1) + T(n − 2)+ O(1) | O(2<sup>n</sup>) |
| T(n) = 2T(n - 1) + O(1)          | O(2<sup>n</sup>) |
---

### Finding a Recurrence Relation of a Recursive Function
**Example: 1**
```
void func(int n) {
    if (n <= 1) return;
    
    func(n / 2);  // Recursive call on half of n
    func(n / 2);  // Another recursive call on half of n

    for (int i = 0; i < n; i++) {  // O(n) work outside recursion
        cout << i << " ";
    }
}
```
Finding the recurrence relation:
- The function calls itself twice, each time with input n/2.
- The loop outside recursion runs O(n) operations.

So, we get the recurrence relation: T(n) = 2T(n / 2) + O(n)

**Example 2:**
```
void func(int n) {
    if (n <= 1) return;
    
    func(n - 1);  // Recursive call on (n-1)

    for (int i = 0; i < n; i++) {  // O(n) work outside recursion
        cout << i << " ";
    }
}
```
Recurrence Relation:
- The function calls itself once with input n−1.
- The loop outside recursion runs O(n) work.

So, the recurrence relation is: T(n) = T(n - 1) + O(n)