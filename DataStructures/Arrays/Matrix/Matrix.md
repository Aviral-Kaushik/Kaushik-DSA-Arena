# Matrix 

### 🔍 What is a Matrix?
A 2D array used to represent data in rows and columns format. Common in problems related to grids, games, graphs, images, and dynamic programming.

In Java:
```
int[][] matrix = new int[3][4]; // 3 rows, 4 columns
```

### 🧠 Matrix Basics
- ``` matrix.length ``` → Number of rows
- ``` matrix[0].length ``` → Number of columns (assuming at least one row)

### ✅ Common Matrix Traversals
**1. Row-wise Traversal**
```
for (int i = 0; i < rows; i++)
    for (int j = 0; j < cols; j++)
        System.out.print(matrix[i][j]);
```
**2. Column-wise Traversal**
```
for (int j = 0; j < cols; j++)
    for (int i = 0; i < rows; i++)
        System.out.print(matrix[i][j]);
```

### ⚙️ Common Interview Problems
**1. Search in Sorted Matrix**
```
// Top-right corner approach
int i = 0, j = cols - 1;
while (i < rows && j >= 0) {
    if (matrix[i][j] == target) return true;
    else if (matrix[i][j] > target) j--;
    else i++;
}
```
🕒 Time: O(n + m)

**2. Spiral Traversal**\
Traverse in a spiral (layer-by-layer).

**3. Transpose of Matrix**
Convert rows to columns.
```
for (int i = 0; i < n; i++)
    for (int j = i + 1; j < n; j++)
        swap(matrix[i][j], matrix[j][i]);
```

**4. Rotate Matrix 90 Degrees (Clockwise)**
- Step 1: Transpose
- Step 2: Reverse each row

**5. Matrix Multiplication**
```
for (int i = 0; i < r1; i++)
    for (int j = 0; j < c2; j++)
        for (int k = 0; k < c1; k++)
            result[i][j] += A[i][k] * B[k][j];
```
🕒 Time: O(n³)

⏱️ Time & Space Complexity
---
| Operation       | Time Complexity |
|-----------------|-----------------|
| Traversal       | O(n × m)        |
| Transpose       | O(n × m)        |
| Rotation        | O(n²)           |
| Multiplication  | O(n³)           |
---

### 🧠 Tips for Interviews
- Always verify matrix dimensions before accessing.
- Practice corner cases like empty matrix, single row/column.
- Dry run examples to avoid index out-of-bounds errors.

### 📌 Use-Cases
- Image processing (rotate, blur, crop).
- Graphs (Adjacency Matrix).
- DP problems (2D DP table).
- Games (Minesweeper, Tic-Tac-Toe).
- Simulations (like Conway’s Game of Life).