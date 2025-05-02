# 🔐 Hash Table, Direct Address Table, Hash Function, Collision Handling – Detailed DSA Notes

## 📌 1. Direct Address Table (DAT)
### 🔍 Concept:
A Direct Address Table is a simple data structure used to store keys that are drawn from a small, finite universe. It uses the key itself as the index.

### 💡 How it works:
- Universe of keys: U = ```{0, 1, ..., n-1}```.
- Each key is stored at index key itself in an array T.
```
// Simple DAT in Java
int[] T = new int[1000];
T[500] = 1; // key 500 is present
```

### ✅ Pros:
- O(1) access time
- Simple and intuitive

### ❌ Cons:
- Not space efficient when the universe is large but few keys are used.
- Not practical for real-world large key sets (like strings, big ints).

## 📌 2. Hash Table
### 🔍 Concept:
A Hash Table is a data structure that maps keys to values using a hash function to compute the index.
```
Map<String, Integer> map = new HashMap<>();
map.put("apple", 2);  // key = "apple", value = 2
```

### 📦 Internal Structure:
- Array of "buckets"
- A hash function maps the key to a bucket index
- Each bucket stores:
  - Either a single entry (perfect hashing), or
  - A linked list or other structure to handle collisions

### ✅ Pros:
- O(1) average time complexity for insert, search, delete.
- Widely used in real-life systems (caches, compilers, etc.).

### ❌ Cons:
- Worst-case time = O(n) due to collisions.
- Efficient hash functions are crucial.

## 📌 3. Hash Function
### 🔍 Definition:
A Hash Function converts a key into an index (hash code) of the array (bucket).

### 🎯 Properties of a Good Hash Function:
- **Deterministic:** Same key gives same hash
- **Uniform distribution:** Spread keys evenly
- **Efficient:** Should be fast to compute
- Minimize collisions

### 🧪 Examples:
Integer Key:
```
int hash = key % tableSize;
```

String Key (Java's default hashCode()):
```
// Example hash function for a string
int hash = 0;
for (char c : key.toCharArray())
    hash = 31 * hash + c;
```

### 🧠 Java’s Internal Hash Function:
Java uses .hashCode() internally and applies further transformations for bucket indexing.

## 📌 4. Collision Handling
### 🎯 What is Collision?
Occurs when two different keys produce the same hash index.

### 🛠️ Methods of Collision Resolution:
**✅ 1. Chaining**
- Each bucket contains a linked list (or dynamic array) of entries
- On collision, simply add the key-value pair to the list
```
// In Java's HashMap, chaining is used internally
```

**✅ Pros:**
- Easy to implement
- Can handle many collisions

**❌ Cons:**
- Performance degrades with large chains

**✅ 2. Open Addressing**
- All keys are stored directly in the array.
- On collision, search for next available spot using a probing sequence.

**Types of Probing:**
**1. Linear Probing**
```
hash = (hash + 1) % size;
```
**2. Quadratic Probing**
```
hash = (hash + i*i) % size;
```
**3. Double Hashing**
```
hash = (hash1 + i * hash2) % size;
```

**✅ Pros:**
- Space efficient (no extra space for chains)

**❌ Cons:**
- Clustering (in linear probing)
- Harder to delete elements

### 🧠 Real-World Note:
Java uses a mix of chaining with balanced trees:
- Buckets start as linked lists
- If they become too long, Java switches to Red-Black Tree for better worst-case performance (since Java 8)

📌 Summary Table
---
| Feature              | Direct Address Table | Hash Table           |
|----------------------|----------------------|----------------------|
| Key Range            | Small, finite        | Large/unbounded      |
| Space Usage          | High (sparse)        | Efficient            |
| Time (Insert/Search) | O(1)                 | O(1) avg, O(n) worst |
| Collision Handling   | Not needed           | Required             |
| Real-World Use       | Rare                 | Very common          |
---