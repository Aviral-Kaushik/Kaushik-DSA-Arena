# 🔍 Pattern Matching

### 📌 What is Pattern Matching?

Finding all occurrences of a pattern string P of length m in a text string T of length n.
- Output: All indices i in T where substring T[i..i+m-1] equals P.
- Naive approach checks every position → O(m×n)

### ⚙️ Common Pattern Matching Algorithms
### 1. Naive Algorithm
- Check substring starting at each position in T
- Time Complexity: O(m×n) worst case

### 2. Rabin-Karp Algorithm
- Uses rolling hash to compare pattern hash with substring hash in O(1)
- Steps:
  - Calculate hash of pattern and initial window in text
  - Slide window over text, update hash
  - If hashes match, do exact string comparison to avoid collision errors
- Average Time Complexity: O(n + m)
- Worst Case: O(m×n) (due to hash collisions)

### 3. Knuth-Morris-Pratt (KMP) Algorithm
- Builds a Longest Prefix Suffix (LPS) array for pattern to skip comparisons
- Time Complexity: O(n + m)
- Key Idea: Use previously matched info to avoid redundant checks

### 4. Boyer-Moore Algorithm
- Uses bad character and good suffix heuristics to jump ahead
- Generally faster in practice than KMP
- Average Time: sublinear in many cases, worst-case O(n×m)

### 🧠 Key Concepts in KMP
- **LPS Array**:\
  ```lps[i]``` = length of the longest proper prefix of ```P[0..i]``` which is also a suffix
- Helps know where to resume matching from pattern after mismatch

### 📌 Example: KMP LPS Computation
Pattern: ```ABABCABAB```

| Index (i) | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|-----------|---|---|---|---|---|---|---|---|---|
| Pattern   | A | B | A | B | C | A | B | A | B |
| LPS       | 0 | 0 | 1 | 2 | 0 | 1 | 2 | 3 | 4 |

### 🔧 When to Use?
- Searching in texts (e.g., DNA sequencing, plagiarism detection)
- Text editors and search utilities (Ctrl+F)
- Network intrusion detection

### ⏱️ Time Complexity
| Algorithm   | Time Complexity               | Space Complexity |
|-------------|-------------------------------|------------------|
| Naive       | O(m×n)                        | O(1)             |
| Rabin-Karp  | O(n + m) avg, worst O(m×n)    | O(1)             |
| KMP         | O(n + m)                      | O(m) (for LPS)   |
| Boyer-Moore | Best sub-linear, worst O(m×n) | O(m)             |

### ✅ How Important is Pattern Searching in Strings?
### ⭐ Importance Level: Moderate to High
### 🎯 Why It's Important:
- It tests your understanding of string manipulation, substrings, looping logic, and sometimes advanced algorithms like KMP or Rabin-Karp.
- It's often used in real-world systems like:
  - Search engines
  - Text editors
  - Plagiarism checkers
  - Log scanning tools

### ✅ Final Verdict (for You Personally):
| Concept            | Importance | Must Know?     | When to Focus          |
|--------------------|------------|----------------|------------------------|
| Brute Force Search | ⭐⭐⭐⭐☆      | ✅ Yes          | Early DSA prep         |
| KMP Algorithm      | ⭐⭐⭐⭐☆      | ✅ Yes          | After Arrays/Hashing   |
| Rabin-Karp         | ⭐⭐⭐☆☆      | ✅ Concept only | Optional for mid-level |
| Z-Algorithm        | ⭐⭐☆☆☆      | ❌ Optional     | Only if time permits   |

### 🛠️ Pro Tip:
You don’t have to memorize all the code, but knowing the intuition, use cases, and having at least one full implementation in your DSA repo is important.