# 🔍 Comparison of String Matching Algorithms

| Feature / Algorithm           | **Naive**                | **Improved Naive**              | **Rabin-Karp**                 | **KMP (Knuth-Morris-Pratt)**   | **Boyer-Moore**                         |   |                           |
|-------------------------------|--------------------------|---------------------------------|--------------------------------|--------------------------------|-----------------------------------------|---|---------------------------|
| **Time Complexity (Best)**    | O(1)                     | O(1)                            | O(n + m)                       | O(n + m)                       | O(n/m) (best case)                      |   |                           |
| **Time Complexity (Avg)**     | O(n·m)                   | Better than Naive if distinct   | O(n + m) (with low collisions) | O(n + m)                       | O(n)                                    |   |                           |
| **Time Complexity (Worst)**   | O(n·m)                   | O(n·m)                          | O(n·m) (many collisions)       | O(n + m)                       | O(n·m) (in worst case)                  |   |                           |
| **Preprocessing Time**        | None                     | None                            | O(m)                           | O(m) (LPS array)               | O(m +                                   | Σ | ) (Bad char, good suffix) |
| **Space Complexity**          | O(1)                     | O(1)                            | O(1) or O(n) for hash          | O(m) for LPS array             | O(m +                                   | Σ | )                         |
| **Hashing Used?**             | ❌                        | ❌                               | ✅                              | ❌                              | ❌                                       |   |                           |
| **Uses Pattern Properties**   | ❌                        | ✅ (if distinct characters)      | ❌                              | ✅ (prefix/suffix via LPS)      | ✅ (bad character, good suffix)          |   |                           |
| **Suitable For**              | Small patterns and texts | Patterns with unique characters | Multiple pattern search        | Repeating patterns, all cases  | Large alphabets, long texts             |   |                           |
| **Search Direction**          | Left to right            | Left to right                   | Left to right                  | Left to right                  | Right to left                           |   |                           |
| **Best Use Case**             | Simple & small problems  | Distinct pattern characters     | Searching multiple patterns    | Searching in all kinds of text | Search with long patterns in large text |   |                           |
| **Implementation Difficulty** | Easy                     | Easy                            | Medium (hash + rolling hash)   | Medium to hard                 | Hard                                    |   |                           |


| Feature / Algorithm                   | **Naive**             | **Improved Naive**    | **Rabin-Karp**                 | **KMP (Knuth–Morris–Pratt)**      | **Boyer-Moore**                |   |                            |
|---------------------------------------|-----------------------|-----------------------|--------------------------------|-----------------------------------|--------------------------------|---|----------------------------|
| **Best Time Complexity**              | O(1) (match at start) | O(1)                  | O(n + m)                       | O(n + m)                          | O(n/m) (best case)             |   |                            |
| **Average Time Complexity**           | O(n·m)                | Better than O(n·m)    | O(n + m) (if good hash)        | O(n + m)                          | O(n)                           |   |                            |
| **Worst Time Complexity**             | O(n·m)                | O(n·m)                | O(n·m) (hash collision)        | O(n + m)                          | O(n·m) (rare)                  |   |                            |
| **Preprocessing Time**                | None                  | None                  | O(m)                           | O(m) (LPS array)                  | O(m +                          | Σ | ) (Bad char + good suffix) |
| **Space Complexity**                  | O(1)                  | O(1)                  | O(1) to O(n) (hash values)     | O(m)                              | O(m +                          | Σ | )                          |
| **Hashing Used?**                     | ❌                     | ❌                     | ✅                              | ❌                                 | ❌                              |   |                            |
| **Pattern Properties Used?**          | ❌                     | ✅ (distinct chars)    | ❌                              | ✅ (LPS: longest prefix-suffix)    | ✅ (bad char, good suffix)      |   |                            |
| **Search Direction**                  | Left to Right         | Left to Right         | Left to Right                  | Left to Right                     | Right to Left                  |   |                            |
| **Avoids Unnecessary Comparisons?**   | ❌                     | ✅ (in some cases)     | ✅ (if hash avoids mismatch)    | ✅ (via LPS)                       | ✅ (via shift heuristics)       |   |                            |
| **Supports Multiple Pattern Search?** | ❌                     | ❌                     | ✅                              | ❌                                 | ❌                              |   |                            |
| **Handles Repeating Patterns Well?**  | ❌                     | ❌                     | ✅ (via hash)                   | ✅                                 | ✅                              |   |                            |
| **Best Use Case**                     | Simple & small input  | Distinct char pattern | Multiple pattern search        | Repeating patterns or general use | Long patterns in large texts   |   |                            |
| **Ease of Implementation**            | Very Easy             | Easy                  | Medium (requires rolling hash) | Medium (LPS is tricky)            | Complex (many rules to handle) |   |                            |

### 📝 Notes on Each Algorithm:
#### 1. Naive Algorithm
- Compare pattern at each position.
- Simple but inefficient for large texts.

#### 2. Improved Naive (Distinct Pattern)
- If all characters in the pattern are distinct, skip ahead after mismatch.

#### 3. Rabin-Karp
- Uses hash function to compare pattern hash with substring hash.
- Good for **multiple pattern search**.
- Hash collisions can degrade performance.

#### 4. KMP Algorithm
- Uses **LPS array** to avoid redundant comparisons.
- Efficient and consistent.
- Great for patterns with repeating parts.

#### 5. Boyer-Moore Algorithm
- Starts matching from **right to left**.
- Uses two heuristics: **Bad Character** and **Good Suffix**.
- Best for long patterns and large texts with a big alphabet.
- Complex to implement.


### 🎯 Recommendation Table
| Scenario                                               | Recommended Algorithm  |
|--------------------------------------------------------|------------------------|
| Small size text and pattern                            | Naive / Improved Naive |
| Searching one pattern in large text                    | KMP or Boyer-Moore     |
| Searching multiple patterns                            | Rabin-Karp             |
| Pattern has unique characters                          | Improved Naive         |
| Time-efficient, worst-case optimal                     | KMP                    |
| When space is not a constraint and performance matters | Boyer-Moore            |
