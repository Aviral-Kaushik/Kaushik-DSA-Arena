# 🔍 Rabin-Karp Algorithm for Pattern Searching

### 📌 Definition:

The **Rabin-Karp algorithm** is a **string searching** algorithm that uses **hashing** to find any one of a set of pattern strings in a text.

It’s particularly efficient when:

- You want to find **multiple patterns** in the same text
- The pattern and text are **long**

### 💡 Core Idea:
- Use a **rolling hash** to compare substrings of the text with the pattern.
- If hashes match → check the actual characters to confirm.
- This avoids character-by-character comparison every time.

### ⚙️ Steps of the Algorithm:
1. Calculate the **hash of the pattern**.
2. Calculate the **initial hash** of the first window of the text of size ```m``` (where ```m = pattern.length()```)
3. Slide the window one character at a time and:
    - Update the rolling hash in O(1) time
    - If the hash matches the pattern hash:
        - Compare the actual substring to confirm (due to hash collisions)
4. Repeat until the end of the text.

### 🔢 Hash Function (Rolling Hash)
- Often uses a **polynomial rolling hash:**
    ```
  hash=(T[0]×d^(m−1)+T[1]×d^(m−2) + . . . +T[m−1]) modq
  ```

    Where:
    - ```d``` = number of characters in input alphabet (e.g., 256 for ASCII)
    - ```q``` = a large prime number (to avoid overflow and reduce collisions)

### 🧠 Java Code Example:
```
public class RabinKarpSearch {
    static final int d = 256; // Number of characters in input alphabet

    static void search(String pattern, String text, int q) {
        int m = pattern.length();
        int n = text.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        // The value of h would be "pow(d, m-1)%q"
        for (i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++) {
            // If hash values match, then only check characters one by one
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) t = (t + q);
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABCCDDAEFG";
        String pattern = "CDD";
        int q = 101; // A prime number
        search(pattern, text, q);
    }
}
```

### ✅ Output:
```
Pattern found at index 3
```

### ⏱️ Time Complexity:
| Case    | Time Complexity              |
|---------|------------------------------|
| Best    | O(n + m)                     |
| Average | O(n + m)                     |
| Worst   | O(n × m) (due to collisions) |
- ```n``` = length of text
- ```m``` = length of pattern

### 📦 Space Complexity:
- O(1) auxiliary space (not counting input)

### ✅ Advantages:
- Fast for multiple pattern matching
- Efficient hash computation using rolling hash
- Easy to implement and extend to multi-pattern search

### ❌ Limitations:
- May suffer from hash collisions
- Performance can degrade in worst case
- Requires a good hash function and prime number

### 🔁 Real-World Usage:
- Plagiarism detection (comparing many substrings)
- Spam detection
- Virus/malware scanning

### 🧠 Summary Table:
| Feature               | Rabin-Karp                          |
|-----------------------|-------------------------------------|
| Preprocessing Time    | O(m)                                |
| Best/Worst Time       | O(n + m) / O(n × m)                 |
| Space Complexity      | O(1)                                |
| Allows multiple match | ✅ Excellent for multi-pattern       |
| Uses Hashing          | ✅ Yes (rolling hash)                |
| Hash Collision Risk   | ⚠️ Possible (requires verification) |






