# Recursion
Recursion is a process in which a function calls itself directly or indirectly is called recursion and the corresponding function is called a recursive function. Using a recursive algorithm, certain problems can be solved quite easily. A few Java recursion examples are Towers of Hanoi (TOH), Inorder/Preorder/Postorder Tree Traversals, DFS of Graph, etc.\
It is recommended that in a recursive function there should be at least 1 base case that terminates the recursion so that infinite recursions calls doesn't happen.

### Application of Recursion
If a problem has an iterative solution then the same solution can be implemented using recursion.
1. Many algorithm techniques based on recursion:
   * Dynamic Programming
   * Backtracking
   * Divide and Conquer (Binary Search, Quick Sort, Merge Sort etc.)
2. Many problems inherently recursive
   * Tower of Hanoi
   * DFS Based Traversal
   * In Order, Pre Order, Post Order Traversals of Trees


## Tail Recursion
Tail recursion is a type of recursion where the recursive call is the last operation performed by the function, with no pending operations left after the recursive call.

#### Why Tail Recursion is Important?
* It optimizes stack space, converting recursion into an iteration internally.
* Reduces the risk of stack overflow.
* Improves performance and is memory efficient.
* Java does not support Tail Recursive Optimization so it does reduce space complexity to O(1) to O(n).
* In C++, Python, Kotlin reduces stack size to O(1) instead of O(n).

#### Normal Recursion vs Tail Recursion
- Normal Recursion
```
int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1); // Multiplication is pending after recursion
}
```
Not a Tail Recursion because multiplication happens after the recursive call.
- Tail Recursion
```
int tailFactorial(int n, int result) {
    if (n == 0) return result;
    return tailFactorial(n - 1, n * result); // No pending operation
}
```
Tail Recursion as the result is passed along as an argument, so no pending operation is left.

#### Advantages of Tail Recursion
* Java does not support Tail Recursive Optimization so it does reduce space complexity to O(1) to O(n).
* In C++, Python, Kotlin reduces stack size to O(1) instead of O(n).
* Faster execution due to fewer function calls.
* Helps in memory optimization.
