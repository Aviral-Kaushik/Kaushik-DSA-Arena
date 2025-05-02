# 🧠 Hashing

### 🔍 What is Hashing?
Hashing is a technique to map data to a fixed-size value (hash code) which can be used for fast data access, storage, or retrieval.

In Java, this is done using:
- ```HashMap<K, V>``` for key-value pairs.
- ```HashSet<E>``` for unique elements.

### ✅ Why Use Hashing?
- Fast lookups, insertions, deletions – typically O(1) average time.
- Used in problems involving:
    - Frequencies
    - Duplicates
    - Uniqueness
    - Counting
    - Pair sums, intersections, etc.

### ⚙️ Core Components
- **Hash Function** → Converts a key to an index
- **Hash Table** → Array storing data at computed indices
- **Collision Handling** → When two keys hash to same index:
    - Chaining (linked list at index)
    - Open addressing (linear probing)

### 📘 Java Hashing Classes
#### 1. HashMap
```
HashMap<String, Integer> map = new HashMap<>();
map.put("apple", 2);
map.get("apple");  // returns 2
map.containsKey("apple");  // true
map.remove("apple");
```

#### 2. HashSet
```
HashSet<Integer> set = new HashSet<>();
set.add(5);
set.contains(5);  // true
set.remove(5);
```
### 🧠 Popular Interview Problems
#### 1. Two Sum
Use a HashSet to check for complement.
```
Set<Integer> seen = new HashSet<>();
for (int num : nums) {
    if (seen.contains(target - num)) return true;
    seen.add(num);
}
```

#### 2. Find Duplicates
```
Set<Integer> set = new HashSet<>();
for (int num : arr) {
    if (!set.add(num)) return true;
}
```

#### 3. Frequency Count
```
Map<Integer, Integer> freq = new HashMap<>();
for (int num : arr) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```

⏱️ Time & Space Complexity
---
| Operation      | Time Complexity | Space Complexity |
|----------------|-----------------|------------------|
| Insert         | O(1)            | 	O(n)            |
| Delete         | O(1)            | 	O(n)            |
| Search/Lookup  | O(1)            | 	O(n)            |
---
**Note:** Worst-case time can degrade to O(n) if hash collisions are high.

### ⚠️ Pitfalls
* Poor hash functions → collisions → degrade performance
* HashMaps do not maintain order (use LinkedHashMap if needed)
* Cannot use primitive types directly (autoboxing needed)

🎯 Key Takeaways
- Excellent for solving problems requiring constant-time operations.
- Use HashMap for frequency or mapping.
- Use HashSet for uniqueness or existence checks.
- Backbone for advanced data structures like LRU Cache, Trie, Hash-based DP.