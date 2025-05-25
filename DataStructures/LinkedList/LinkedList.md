# 📘 Linked List

### 🔹 What is a Linked List?
A **Linked List** is a linear data structure where each element (called a **node**) contains:
- **Data**
- A **pointer/reference** to the next node in the sequence

 Unlike arrays, linked lists do not store elements in contiguous memory.

### 🔹 Types of Linked Lists
| Type                            | Description                                                         |
|---------------------------------|---------------------------------------------------------------------|
| **Singly Linked List**          | Each node has one pointer: to the next node                         |
| **Doubly Linked List**          | Each node has two pointers: to the next and previous nodes          |
| **Circular Linked List**        | Last node points to the first node (circular chain)                 |
| **Circular Doubly Linked List** | Both ends connect, allowing traversal in both directions circularly |

### 🔹 Node Structure (Java Example)
```
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}
```

### 🔹 Basic Operations (Singly Linked List)
| Operation             | Time Complexity | Description                             |
|-----------------------|-----------------|-----------------------------------------|
| Insert at Beginning   | O(1)            | Add node at the head                    |
| Insert at End         | O(n)            | Traverse to end, add node               |
| Insert at Position    | O(n)            | Traverse to position and insert         |
| Delete from Beginning | O(1)            | Change head to head.next                |
| Delete from End       | O(n)            | Traverse to second-last and remove last |
| Search                | O(n)            | Traverse each node and compare          |
| Traverse              | O(n)            | Visit each node to print/process data   |

### 🔹 Advantages
- **Dynamic size** (no need to pre-allocate memory)
- **Efficient insertions/deletions** at beginning or middle
- No memory wastage due to fixed capacity (like arrays)

### 🔹 Disadvantages
- **Random access is not possible** (must traverse)
- More memory overhead due to pointers
- Accessing an element takes O(n) time

### 🔹 Applications
- Implementation of stacks, queues, graphs
- Used in hash table chaining
- Memory-efficient insertion/deletion in editors
- Used in polynomial arithmetic

### 🔹 Doubly Linked List: Node Example
```
class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}
```

### 🔹 Key Interview Tips
- ✅ Be able to write insertion/deletion code
- ✅ Know how to reverse a linked list (iteratively and recursively)
- ✅ Understand slow & fast pointer (Floyd's Cycle Detection)
- ✅ Be ready to explain why linked lists are better than arrays in certain situations
- ✅ Learn how to merge two sorted linked lists