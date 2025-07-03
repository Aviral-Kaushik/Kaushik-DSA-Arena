# 📘 Queue Data Structure 

### ✅ 1. What is a Queue?
A **Queue** is a linear data structure that follows the **FIFO (First In, First Out)** principle.

The element added **first** is removed **first**.

### 🔄 2. Basic Operations
| Operation    | Description                                | Time Complexity  |
|--------------|--------------------------------------------|------------------|
| `enqueue(x)` | Insert element at the rear of the queue    | O(1) (amortized) |
| `dequeue()`  | Remove element from the front of the queue | O(1)             |
| `peek()`     | Get the front element without removing it  | O(1)             |
| `isEmpty()`  | Check if queue is empty                    | O(1)             |

### 🧠 3. Types of Queues
| Type                           | Description                                                            |
|--------------------------------|------------------------------------------------------------------------|
| **Simple Queue**               | FIFO order of processing                                               |
| **Circular Queue**             | Rear wraps around to utilize unused space                              |
| **Deque (Double-Ended Queue)** | Insertion/deletion from both ends                                      |
| **Priority Queue**             | Elements processed based on priority                                   |
| **Monotonic Queue**            | Maintains increasing/decreasing order, used in sliding window problems |

### 💡 4. Implementations
### 🔸 Using Array:
- Fixed size
- Risk of overflow if not circular

### 🔸 Using Linked List:
- Dynamic size
- More memory efficient

### 🔸 Using Built-in Libraries (Java):
```
Queue<Integer> q = new LinkedList<>();
PriorityQueue<Integer> pq = new PriorityQueue<>();
Deque<Integer> dq = new ArrayDeque<>();
```

### ⚙️ 5. Time & Space Complexity
| Operation | Array | Linked List |
|-----------|-------|-------------|
| Enqueue   | O(1)  | O(1)        |
| Dequeue   | O(n)* | O(1)        |
| Peek      | O(1)  | O(1)        |
| Space     | O(n)  | O(n)        |
* unless using circular logic.

### 🔄 6. Real-life Examples:
- Print queue
- Call center queues
- CPU scheduling
- Task scheduling systems
- Caching systems (LRU via Deque)

# 🧪 Frequently Asked Interview Questions on Queue
### 📍 Basic
1. Implement a Queue using Arrays/Linked List
2. Implement a Circular Queue
3. Implement a Queue using Two Stacks
4. Implement a Stack using Two Queues

### 📍 Intermediate
1. Reverse a Queue using recursion or stack
2. Design an LRU Cache using Deque + HashMap
3. Generate Binary Numbers from 1 to N using Queue
4. Find the first non-repeating character in a stream

### 📍 Advanced
1. Sliding Window Maximum using Deque (Monotonic Queue)
2. Implement a Priority Queue or Min/Max Heap
3. Rotting Oranges (BFS using Queue)
4. Shortest Path in Unweighted Graph (BFS using Queue)

### 🔄 Comparison: Queue vs Stack
| Feature    | Queue       | Stack        |
|------------|-------------|--------------|
| Principle  | FIFO        | LIFO         |
| Insert     | Rear        | Top          |
| Remove     | Front       | Top          |
| Real-World | Ticket line | Browser back |
