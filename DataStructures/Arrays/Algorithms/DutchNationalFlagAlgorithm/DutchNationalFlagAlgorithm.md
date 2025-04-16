# Dutch National Flag Algorithm

### 🔍 What is it?   
- An algorithm to sort an array of 0s, 1s, and 2s (or any 3 distinct values) in one pass and without using extra space.
- Developed by Edsger Dijkstra, inspired by the colors of the Dutch flag: Red (0), White (1), Blue (2).
- **Note:** This algorithm is only used to sort array in constant time without using extra space if and pnly if array only contains 0s, 1s & 2s no other element then that.

### ✅ When to Use It?
- Sorting arrays with only 3 distinct elements (like 0s, 1s, 2s).
- Asked to solve in O(n) time and O(1) space.
- **Example:** Leetcode’s Sort Colors problem.

### 🧠 Core Idea
Use three pointers:
- **low** – boundary for 0s.
- **mid** – current element.
- **high** – boundary for 2s.

Logic:
- If ```arr[mid] == 0``` → swap with ```arr[low], low++, mid++```
- If ```arr[mid] == 1``` → ```mid++```
- If ```arr[mid] == 2``` → swap with ```arr[high], high--```

### 📘 Java Code
```
void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;

    while (mid <= high) {
        if (nums[mid] == 0) {
            swap(nums, low++, mid++);
        } else if (nums[mid] == 1) {
            mid++;
        } else { // nums[mid] == 2
            swap(nums, mid, high--);
        }
    }
}

void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```

### 🔁 Example
Input: ```[2, 0, 2, 1, 1, 0]```
Output: ```[0, 0, 1, 1, 2, 2]```

⏱️ Time & Space Complexity
---
| Operation   | Complexity |
|-------------|------------|
| Time        | O(n)       |
| Space       | O(1)       |
---

### 🧠 Visualization
```
Initial:     [2, 0, 1, 2, 1, 0]
low mid high → pointers at start

After loop:  [0, 0, 1, 1, 2, 2]
```

### 🎯 Key Takeaways
- Classic 3-way partitioning technique.
- In-place, single pass sorting of 3 distinct elements.
- Highly efficient for problems like color sort, zero-one-two sort.