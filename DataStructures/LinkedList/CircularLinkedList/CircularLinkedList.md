# 📘 Circular Linked List

### 🔹 Definition:
A **Circular Linked List (CLL)** is a variation of a linked list in which the **last node points back to the first node**, forming a **circle** of nodes.

It can be:
- **Singly Circular Linked List** – where each node has a single pointer to the next node, and the last node points back to the head.
- **Doubly Circular Linked List** – where each node has two pointers: one to the next and one to the previous node, and the last and first nodes are linked circularly in both directions.

### 🔹 Structure of a Node (Singly Circular):
Each node contains:

- **Data:** the value stored
- **Next:** reference to the next node in the list

```
[Data | Next] -> [Data | Next] -> ... -> [Data | Next] --|
          ^                                            |
          |--------------------------------------------|
```

### 🔹 Characteristics:
- **No NULL at the end** of the list.
- **Traversal is circular:** can traverse the whole list starting from any node.
- Must use a **stopping condition**, usually by checking if the current node is back to the head.
- Commonly implemented with a **tail pointer** to simplify insertion at the end.

### 🔹 Operations:
**1. Insertion:**
- **At beginning:** New node points to head, tail points to new node, head becomes new node.
- **At end:** New node points to head, tail’s next updated to new node, tail becomes new node.
- **At a position:** Traverse to the position, adjust links.

**2. Deletion:**
- **From beginning:** Head updated, tail’s next points to new head.
- **From end:** Traverse to second last node, update its next to head.
- **From a position:** Traverse and adjust links.

**3. Traversal:**
- Use a loop and stop when the node reaches back to the head.

### 🔹 Advantages:
- Can be traversed from any node.
- Efficient in applications requiring continuous looping (e.g., scheduling).

### 🔹 Disadvantages:
- More complex to implement and manage.
- Infinite loop risk if not handled properly.

### 🔹 Applications:
- **Operating Systems:** Round-robin scheduling.
- **Gaming:** Continuous player turns.
- **Buffer Management:** Circular queues, streaming data.