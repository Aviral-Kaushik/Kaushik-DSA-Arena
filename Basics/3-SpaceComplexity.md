# Space Complexity
- Space Complexity refers to the amount of memory an algorithm uses as a function of input size (n). It includes:
  - Fixed Part → Constants, program instructions.
  - Variable Part → Function calls, recursion stack, auxiliary data structures.
- Order of growth of memory (or RAM) space in terms of input size.
- To represent the Space Complexity in mathematical notations we use same asymptotic notations (O, Ω and Θ).

### Auxiliary Space
- Order of Growth of extra space or temporary space in terms of input size.

### Space Complexity of Common Operations

---
| Operation            | Space Complexity       |
|----------------------|------------------------|
| Variable declaration | O(1)                   |
| Array of size n      | O(n)                   |
| 2D Array (n x m)     | O(n × m)               |
| Recursive function   | O(n) (stack space)     |
| Iterative algorithm  | O(1) (no extra space)  |
---

**Example 1: Simple Loop Program to Calculate the sum of first natural number**
```
int getSum(int n) {
    int sum = 0;
    for (int i = 0; i <= n; i++) {
        sum++;
    }
    return sum;
}
```
**Space Complexity:** O(1) (Only loop and variable initialization).\
***Auxiliary Complexity:** O(1).

**Example 2: Factorial (Recursive)**
```
int factorial(int n) {
    if (n == 0) return n;
    return n * factorial(n - 1);
}
```
**Space Complexity:** O(n) (Recursive function calls leads stack allocation for n times).\
**Auxiliary Complexity:** O(n) (Stack with n size).

**Example 3: Fibonacci**
```
int fib(int n) {
    if (n == 0 || n == 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```
**Space Complexity:** O(n) (Recursive function calls leads stack allocation for n times).\
**Auxiliary Complexity:** O(n) (Stack with n size).

### Space Complexity of Sorting Algorithms
---
| Algorithm        | Space Complexity     |
|------------------|----------------------|
| Bubble Sort      | O(1)                 |
| Quick Sort       | O(log n) (recursive) |
| Merge Sort       | O(n) (extra space)   |
| Heap Sort        | O(1)                 |
---

### Key Takeaways
- Iterative solutions usually have O(1) space complexity.
- Recursive functions use O(n) space due to call stacks.
- In-place algorithms use minimal extra space (O(1) or O(log n)).
- Avoid extra space usage where possible for better performance.


