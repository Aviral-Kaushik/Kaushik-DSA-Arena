# 📘 Doubly Linked List

### ✅ Definition:
A **Doubly Linked List (DLL)** is a type of linked list in which each node contains **three fields:**
- ```data``` – The actual value/data.
- ```prev``` – A pointer to the **previous node**.
- ```next``` – A pointer to the **next node**.

### 🧠 Why Use DLL?
- Unlike a singly linked list, DLL allows **traversal in both directions** (forward and backward).
- Easier to **insert/delete nodes** from both ends and from the **middle** of the list.

### 📦 Structure of a Node:
```
public class Node {
    int data;
    Node prev; // Null By Default
    Node next; // Null By Default

    // Constructor
    public Node(int data) {
        this.data = data;
    }
}
```

### 🔧 Basic Operations:
**1. Insertion**
- **At beginning:** Update new node’s ```next``` to current head and head’s ```prev``` to new node.
- **At end:** Traverse to the last node, update its ```next```, and set new node’s ```prev```.
- **At position:** Traverse to the position, adjust both ```prev``` and ```next``` links of surrounding nodes.

**2. Deletion**
- **From beginning:** Move ```head``` to ```head.next```, update new head’s ```prev``` to null.
- **From end:** Traverse to the second-last node, update its ```next``` to null.
- **From position:** Adjust the ```prev.next``` and ```next.prev``` pointers to exclude the current node.

**3. Traversal**
- **Forward traversal:** Start from ```head```, follow ```next```.
- **Backward traversal:** Start from ```tail```, follow ```prev```.

### 🔄 Advantages:
- Two-way traversal.
- Easy deletion without traversal (if reference to node is given).
- Better performance than singly linked list in certain operations.

### 🚫 Disadvantages:
- More memory usage (extra pointer ```prev```).
- Slightly more complex insertion/deletion logic due to multiple pointers.

### 📊 Time Complexity:
| Operation            | Time Complexity |
|----------------------|-----------------|
| Insertion (anywhere) | O(1) to O(n)    |
| Deletion (anywhere)  | O(1) to O(n)    |
| Searching            | O(n)            |
| Forward Traversal    | O(n)            |
| Backward Traversal   | O(n)            |

### 🧪 Applications:
- Browser history (back and forward navigation).
- Undo/Redo operations in software.
- Implementation of LRU Cache.
- Playlist management systems.