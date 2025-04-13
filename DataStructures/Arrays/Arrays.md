# Array
An array is a fixed-size data structure that stores elements of the same type in contiguous memory locations.

#### Key Features of Arrays
- Stores homogeneous (same type) data.
- Allows random access using indexing.
- Has a fixed size (cannot be resized dynamically in Java). 
- Elements are stored sequentially in memory.

#### Initializing an array
```
int[] arr = new int[5]; // Creates an array of size 5 with default values (0)
int[] arr = {10, 20, 30, 40, 50}; // Array of size 5 initialized with values
```

### Types of Arrays
* 1D Array
```
int[] arr = new int[5];
```
* 2D Array
```
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
System.out.println(matrix[1][2]); // Output: 6
```
* Jagged Array (Variable Column Size)
```
int[][] jaggedArr = new int[3][];
jaggedArr[0] = new int[2]; // Row 0 has 2 columns
jaggedArr[1] = new int[4]; // Row 1 has 4 columns
```

## Time & Space Complexity of Operations

| Operation                                  | Time Complexity  | Space Complexity   |
|--------------------------------------------|------------------|--------------------|
| **Access (arr[i])**                        | **O(1)**         | **O(1)**           |
| **Search (Linear Search)**                 | **O(n)**         | **O(1)**           |
| **Search (Binary Search - Sorted Array)**  | **O(log n)**     | **O(1)**           |
| **Insertion at End**                       | **O(1)**         | **O(1)**           |
| **Insertion at Middle**                    | **O(n)**         | **O(1)**           |
| **Deletion at End**                        | **O(1)**         | **O(1)**           |
| **Deletion at Middle**                     | **O(n)**         | **O(1)**           |
| **Sorting (Merge Sort, Quick Sort)**       | **O(n log n)**   | **O(n)**           |

### Advantages & Disadvantages of Arrays
* Advantages\
✔️ Fast random access (O(1) time complexity).\
✔️ Cache friendly (stored sequentially in memory).\
✔️ Easy to implement and use.

* Disadvantages\
❌ Fixed size (cannot be resized dynamically).\
❌ Insertion & Deletion operations are costly (O(n) time complexity).\
❌ Wastage of memory if size is not properly utilized.

#### When to Use Arrays?
- When fast access (O(1)) is required.
- When data size does not change frequently.
- When memory is not a major concern.

#### Key Takeaways
✔️ Arrays are fast but fixed in size.\
✔️ Random access is O(1) but insertions & deletions are O(n).\
✔️ Use ArrayList for dynamic resizing.\
✔️ Sorting is best done with Merge Sort or Quick Sort (O(n log n)).

###  Important Problems
These are frequently asked in interviews:
- Kadane’s Algorithm (Maximum Subarray Sum)
- Dutch National Flag Problem (Sort 0s, 1s, 2s)
- Next Greater Element
- Stock Buy and Sell (Best Time to Buy/Sell)
- Trapping Rain Water
- Merge Intervals
- Rotate Array (by k steps)
- Longest Consecutive Sequence
- Missing Number / Duplicate Number
- Median of Two Sorted Arrays (Hard)