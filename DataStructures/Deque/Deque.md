# 📘 Deque (Double-Ended Queue) 

### ✅ 1. What is a Deque?
A **Deque** (pronounced "deck") is a **linear data structure** that allows **insertion and deletion** at 
both ends — front and rear.

**DEQUE = Double-Ended QUEue**

### 🔁 2. Key Operations
| Operation       | Description                          |
|-----------------|--------------------------------------|
| `addFirst(x)`   | Insert element at the **front**      |
| `addLast(x)`    | Insert element at the **rear**       |
| `removeFirst()` | Remove and return element from front |
| `removeLast()`  | Remove and return element from rear  |
| `peekFirst()`   | Return element at front (no remove)  |
| `peekLast()`    | Return element at rear (no remove)   |
| `isEmpty()`     | Check if deque is empty              |
| `size()`        | Number of elements                   |

### 📦 3. Types of Deques
| Type                  | Description                                   |
|-----------------------|-----------------------------------------------|
| **Input Restricted**  | Insertion only at one end, deletion from both |
| **Output Restricted** | Deletion only at one end, insertion from both |
| **General Deque**     | Insertion and deletion at both ends           |

### 🧠 4. Why Use a Deque?
- More flexible than stacks and queues
- Useful for **sliding window problems**
- Efficient **LRU cache** implementation
- Can be used to implement both **Stack and Queue**

### ⚙️ 5. Java Deque Implementation
### 🔹 Using ```ArrayDeque``` (preferred over ```LinkedList```)
```
import java.util.*;

Deque<Integer> deque = new ArrayDeque<>();

deque.addFirst(10);   // insert at front
deque.addLast(20);    // insert at rear

System.out.println(deque.removeFirst());  // 10
System.out.println(deque.removeLast());   // 20
System.out.println(deque.isEmpty());      // true
```

### 💡 6. Time Complexity
| Operation              | Time |
|------------------------|------|
| Insertion (front/rear) | O(1) |
| Deletion (front/rear)  | O(1) |
| Access (peek)          | O(1) |

### 🔄 7. Deque vs Stack vs Queue
| Feature     | Deque         | Queue  | Stack |
|-------------|---------------|--------|-------|
| Insertion   | Both ends     | Rear   | Top   |
| Deletion    | Both ends     | Front  | Top   |
| Flexibility | Highest       | Medium | Low   |
| LIFO/FIFO   | Supports both | FIFO   | LIFO  |

### 🧪 8. Common Interview Uses
- **Sliding Window Maximum** (Monotonic Deque)
- **Palindrome Checker**
- **Implementing Stack/Queue**
- **LRU Cache**
- **Balanced Parentheses (enhanced)**