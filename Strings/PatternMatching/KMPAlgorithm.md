# 🔍 KMP Algorithm for Pattern Searching

### 📌 Definition:
**KMP (Knuth-Morris-Pratt)** is a **linear** time string searching algorithm that avoids unnecessary comparisons by using information gathered during the pattern preprocessing phase.

### 🎯 Goal:
Efficiently search for occurrences of a **pattern (P)** in a **text (T)** in **O(n + m)** time.
- ```n``` = length of the text
- ```m``` = length of the pattern

### 💡 Key Idea:
Instead of rechecking previously matched characters after a mismatch (as in Naive), KMP **preprocesses the pattern** to know **how much to shift** without missing any potential matches.

This is done using a **Longest Prefix Suffix (LPS) array.**

### 📦 Components:
**1. 1. LPS Array (Longest Prefix Suffix):**
- LPS[i] = length of the longest prefix which is also a suffix for the substring ```pattern[0..i]```.
- Helps to decide how much the pattern should be shifted on mismatch.

**2. Search Phase:**
- Compare pattern with text using a loop. 
- On mismatch, use LPS to avoid rechecking characters.

### ⚙️ Steps:
#### ✅ Preprocessing (Build LPS):
- Time Complexity: **O(m)**
- Loop through the pattern to create the LPS array.

#### ✅ Pattern Search:
- Use LPS array to skip unnecessary comparisons.
- Time Complexity: **O(n)**

### 🧠 Example:
Text = ```ABABDABACDABABCABAB```
Pattern = ```ABABCABAB```

LPS Array for Pattern:

| Index     | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|-----------|---|---|---|---|---|---|---|---|---|
| Character | A | B | A | B | C | A | B | A | B |
| LPS       | 0 | 0 | 1 | 2 | 0 | 1 | 2 | 3 | 4 |
So, the pattern ```ABABCABAB``` is found at index 10 in the text.

### Java Code
```
public class KMPAlgorithm {

    // Method to compute LPS (Longest Prefix Suffix) array
    public static void computeLPSArray(String pattern, int[] lps) {
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                    // Do not increment i here
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Main KMP search function
    public static void KMPSearch(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();

        // Create lps[] that will hold the longest prefix suffix values for pattern
        int[] lps = new int[m];
        computeLPSArray(pattern, lps);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1]; // look for next match
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++; // move to the next character in text
                }
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPSearch(pattern, text);
    }
}
```

### ✅ Output:
```
Pattern found at index 10
```

### ⏱️ Time Complexity:
| Phase             | Time Complexity |
|-------------------|-----------------|
| LPS Preprocessing | O(m)            |
| Search            | O(n)            |
| **Total**         | **O(n + m)**    |

### 📦 Space Complexity:
O(m) for the LPS array

### ✅ Advantages:
- Linear time complexity
- Avoids unnecessary rechecking
- Deterministic performance (no worst-case slowdown)

### ❌ Limitations:
- Slightly complex to understand at first
- Only effective when pattern has repeating sub-patterns

### 🔁 Use Cases:
- Text editors (search feature)
- Plagiarism detection
- Bioinformatics (DNA sequence search)
- Search engines (keyword matching)

### Summary Table
| Feature                    | KMP Algorithm       |
|----------------------------|---------------------|
| Handles mismatches smartly | ✅ Uses LPS array    |
| Worst-case time complexity | O(n + m)            |
| Space complexity           | O(m)                |
| Preprocessing required     | ✅ (LPS computation) |
| Handles repeated patterns  | ✅ Efficient         |


