# 🧾 Naive Pattern Searching Algorithm

### 📌 Definition:
The Naive Pattern Matching Algorithm is the most basic approach to find occurrences of a pattern string ```P``` (length ```m```) within a text string ```T``` (length ```n```).
It checks all possible substrings of ```T``` of length ```m``` and compares them with ```P```.

### ⚙️ Algorithm Steps:
1. Loop through all starting positions ```i``` from 0 to ```n - m``` in text ```T```.
2. For each ```i```, compare the substring ```T[i..i + m - 1]``` with pattern ```P```.
3. If all characters match → pattern is found at index i.

### 📌 Java Code Example:
```
public class NaivePatternSearch {
    public static void search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        search(text, pattern);
    }
}
```

### ✅ Output (for above example):
```
Pattern found at index 0  
Pattern found at index 9  
Pattern found at index 12
```

### ⏱️ Time Complexity:
| Case       | Time     |                                         |
|------------|----------|-----------------------------------------|
| Best Case  | O(n)     | (if mismatch on first character)        |
| Worst Case | O(m × n) | (when all characters match except last) |

- ```n``` = length of text
- ```m``` = length of pattern

### 🧠 Space Complexity:
- O(1) → constant space (no extra data structures used)

### 📌 Use Case:
- Simple to implement
- Works well when:
  - Text and pattern are small
  - Pattern occurs rarely or mismatches quickly

### ❌ Limitations:
- Inefficient for large texts and patterns
- Always checks all positions, even when not needed

### ✅ Summary Table:
| Feature          | Value                 |
|------------------|-----------------------|
| Approach         | Brute-force           |
| Time Complexity  | O(m × n) (worst)      |
| Space Complexity | O(1)                  |
| Stability        | Stable, deterministic |
| Real-world Usage | Rare in production    |```