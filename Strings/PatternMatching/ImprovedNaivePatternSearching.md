# 🔍 Improved Naive Pattern Searching (for Distinct Characters in Pattern)

**Note:** This algorithm only works if pattern contains only distinct elements.

### 📌 Problem Addressed

The standard naive algorithm always slides the pattern by one character, even if early mismatches make that unnecessary.

If **all characters in the pattern are distinct,** we can **safely skip more characters** after a mismatch — improving performance.

### 🚀 Optimization Insight
When a mismatch occurs:
- In standard naive: slide pattern by 1.
- In improved naive (with distinct pattern): skip more than 1 characters based on position of mismatch

### ⚙️ Algorithm Steps
Let ```n``` = length of text ```T```, and ```m``` = length of pattern ```P```.
1. Start with index ```i = 0``` in the text
2. While ```i <= n - m```:
    - Compare pattern with text starting at ```i```
    - If match: report ```i```, then increment ```i``` by ```m```
    - If mismatch at position ```j```: shift ```i``` by ```j + 1```
      (because all characters in pattern are distinct, so rechecking previous chars is unnecessary)

### ✅ Conditions
1. All characters in pattern P must be distinct
2. Not valid if the pattern contains repeated characters

### 💻 Java Code Example
```
public class ImprovedNaiveSearch {
    public static void search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int i = 0;
        while (i <= n - m) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.println("Pattern found at index " + i);
                i += m;  // all characters are distinct, no overlap possible
            } else if (j == 0) {
                i += 1;  // mismatch at start, just move one
            } else {
                i += j;  // mismatch after some matches → shift by j
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABCEABCDABCEABCD";
        String pattern = "ABCD"; // all distinct characters
        search(text, pattern);
    }
}
```

### 🧠 Example Walkthrough
**Text:** ```"ABCEABCDABCD"```
**Pattern:** ```"ABCD"```

1. Compare "ABCD" with substring at index 4 → match
2. Move index by 4 (length of pattern)
3. Continue scanning efficiently

### ⏱️ Time Complexity
- **Best Case:** O(n / m)
- **Worst Case:** O(n), but faster than naive due to skipping

Much better than standard naive when pattern length m is large and characters are distinct.

### 🧠 Space Complexity
- O(1) → No extra space

### ✅ Advantages
- Efficient for patterns with distinct characters
- Simple logic, easy to implement
- Improves over naive without needing complex pre-processing (like in KMP)

### ❌ Limitations
- Only works correctly if all characters in the pattern are unique
- Falls back to naive behavior otherwise