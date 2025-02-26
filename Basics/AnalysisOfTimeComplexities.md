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

## 1. Analysis of Multiples Loops
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
