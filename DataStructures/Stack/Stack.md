# 📘 Stack Data Structure – Notes

### 🔹 Definition:
A **Stack** is a linear data structure that follows the **LIFO** principle:
- **Last In, First Out**

This means the element inserted last is accessed first.

### 🔹 Real-Life Examples:
- Stack of plates
- Undo/Redo feature in editors
- Browser back button history

### 🔹 Basic Operations:
| Operation          | Description                                 |
|--------------------|---------------------------------------------|
| `push(x)`          | Inserts element `x` on top of the stack     |
| `pop()`            | Removes and returns the top element         |
| `peek()` / `top()` | Returns the top element without removing    |
| `isEmpty()`        | Returns `true` if stack has no elements     |
| `size()`           | Returns the number of elements in the stack |

### 🔹 Stack Implementation:
#### **1. Using Array:**
- Fixed size
- Fast, easy to implement
- Risk of overflow if size is not sufficient

#### **2. Using Linked List:**
- Dynamic size
- No overflow
- Requires extra memory for pointers

#### **3. Using Built-in Libraries:**
- Java: ```Stack<E>``` (from ```java.util```)
- Python: ```list``` or ```collections.deque```


### 🔹 Time Complexity:
| Operation | Time |
|-----------|------|
| Push      | O(1) |
| Pop       | O(1) |
| Peek/Top  | O(1) |
| isEmpty   | O(1) |

### 🔹 Space Complexity:
O(n), where n = number of elements in the stack

### 🔹 Applications of Stack:
- **Expression Evaluation** (Postfix, Infix, Prefix)
- **Parenthesis Matching**
- **Undo/Redo operations**
- **Backtracking algorithms** (Maze, Recursion)
- **Call Stack** in recursion
- **Syntax parsing**
- **DFS traversal** (graphs, trees)

### 🔹 Stack vs Queue:
| Feature   | Stack | Queue |
|-----------|-------|-------|
| Order     | LIFO  | FIFO  |
| Insertion | Top   | Rear  |
| Deletion  | Top   | Front |

### 🔹 Stack Overflow and Underflow:
- **Overflow:** Trying to push when stack is full (only in static array stack)
- **Underflow:** Trying to pop when stack is empty

### 🔹 Interview Popular Problems:
1. **Balanced Parentheses Next Greater Element**
2. **Design Stack with getMin() in O(1)**
3. **Reverse a Stack**
4. **Implement Two Stacks in One Array**
5. **Sort a Stack using recursion**
6. **Evaluate Postfix / Infix Expressions**
7. **Stock Span Problem**
8. **Largest Rectangle in Histogram**
9. **Remove K Digits to get Smallest Number**
10. **Trapping Rain Water**
11. **Delete Middle of Stack**
12. **Daily Temperatures (Monotonic Stack)**