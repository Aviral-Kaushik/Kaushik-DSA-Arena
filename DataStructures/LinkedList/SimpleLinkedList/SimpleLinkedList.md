# ✅ Singly Linked List (SLL)

Simple Linked List is also known as Singly Linked List.

### 📌 Definition:
A **Singly Linked List** is a linear data structure where each element (called a node) contains:
1. **Data** – the value stored in the node.
2. **Next** – a pointer/reference to the next node in the list.

### 📦 Structure of a Node:
```
class Node {
    int data;
    Node next;
};
```

### 🔁 Representation:
``` 
[Data | Next] → [Data | Next] → [Data | Next] → NULL
```

### 📋 Basic Operations:
1. **Traversal**
    - Go through each node one by one until ```NULL``` is reached.
    - Time Complexity: **O(n)**
   
2. **Insertion**
    - **At beginning:** Create a new node and point it to the current head.
    - **At end:** Traverse to the last node and point it to the new node.
    - **At given position:** Traverse to (position-1) and update pointers.
      - Time Complexity:
        - **At beginning: O(1)**
        - **At end / position: O(n)**

3. **Deletion**
   - **At beginning:** Move head to ```head->next```.
   - **At end:** Traverse to second last node, set its next to ```NULL```.
   - **At given position:** Traverse to (position-1), update pointers to skip the node.
     - Time Complexity:
        - **At beginning: O(1)**
        - **At end / position: O(n)**

4. **Search**
   - Traverse each node and compare values.
   - Time Complexity: **O(n)**

### 📌 Advantages:
- Dynamic size.
- Efficient insertions/deletions (especially at the beginning).

### ⚠️ Disadvantages:
- No backward traversal.
- Random access not possible (unlike arrays).
- Extra memory for storing pointer.

### 📚 Applications:
- Dynamic memory allocation.
- Implementation of stacks, queues, graphs.
- Useful when number of data elements is not known in advance.

🧠 Important Points:
- The last node's next is always ```NULL```.
- Always check for ```NULL``` before accessing next.
- Keep a temporary pointer to avoid memory leaks during deletion.