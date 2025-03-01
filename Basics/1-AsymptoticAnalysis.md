# Asymptotic Analysis

1. In Asymptotic Analysis, we evaluate the performance of an algorithm or a function in terms of input size.
2. It does not depend upon machine, programming language etc.
3. No need to implement it, we can analyze algorithms. 

## Order of Growth
A function f(n) is said to be growing faster than g(n) if,
lim (n → ∞) g(n) / f(n) = 0 Or lim (n → ∞) f(n) / g(n) = ∞ are true.

The Order of Growth describes how the running time or space requirements of an algorithm increase relative to the input size (n). It helps in understanding the efficiency of an algorithm as the input size grows.

**Why is Order of Growth Important?** 
-  Helps in selecting the most efficient algorithm.  
- Determines scalability and performance impact.
- Guides in optimizing algorithms for large inputs.

**Key Takeaways**
- Always aim for O(1), O(log n), O(n), or O(n log n) when designing efficient solutions.
- Avoid O(n²), O(2ⁿ), or O(n!) unless unavoidable.
- Consider best, worst, and average cases while analyzing growth.

## Best, Average and Worst Cases
In general and most of the time we will only consider the worst case for analysing our algo.

Time complexity of an algorithm is analyzed under three scenarios:

- **Best Case** → Minimum time taken (optimistic scenario).
- **Worst Case** → Maximum time taken (pessimistic scenario).
- **Average Case** → Expected time taken for random input.

**Example:** Linear Search (O(n))

Finding an element X in an array of n elements:
- Best Case: X is the first element → O(1)
- Worst Case: X is not in the array or at the last index → O(n)
- Average Case: X is found somewhere in the middle → O(n/2) ≈ O(n)

**Example:** Binary Search (O(log n)):

Finding X in a sorted array of n elements:
- Best Case: X is found at the middle → O(1)
- Worst Case: X is at the extreme end or not present → O(log n)
- Average Case: Expected log-based divisions → O(log n)

**Key Takeaways**
- Best case rarely happens in real-world scenarios.
- Worst-case analysis is crucial for ensuring the algorithm does not fail under heavy load.
- Average case analysis gives a more practical measure of expected performance.
- Always optimize for worst-case scenarios unless the best case is the most frequent scenario.

# Asymptotic Notations
Asymptotic Notations are the mathematical notations used to represent order of growth of any algorithm or function. There are mainly 3 types of asymptotic notations
- **Big O:** Worst-case complexity (upper bound) (Exact or Upper Bound)
- **Theta:** Average-case complexity (tight bound) (Exact Bound)
- **Omega:** Best-case complexity (lower bound) (Exact or Lower Bound)

Mainly we only uses on Big O Notations to analyse algorithms as it represents worst case complexity.

### Big O Notation
- Represents the worst-case time complexity of an algorithm.
- Gives an upper bound on the time required as input size increases.
- Example:\
  **For Bubble Sort:** O(n²) → In the worst case, it takes quadratic time.\
  **For Binary Search:** O(log n) → Even in the worst case, it only takes logarithmic time.

✅ Use Case: Ensures an algorithm will never take more than a given time.

**Big O Notation for multiple variables**
- 100n<sup>2</sup> + 100 m + n : O (n<sup>2</sup> + m)
- 1000m<sup>2</sup> + 200mn + 30m + 20n: O(m<sup>2</sup> + mn)

**Omega Notation (Ω) – Lower Bound (Best Case)**
- Represents the best-case time complexity of an algorithm.
- Gives a lower bound on execution time.
- Example:\
**Insertion Sort:** Ω(n) (best case when already sorted).\
**Binary Search:** Ω(1) (if the element is in the middle).

✅ Use Case: Helps understand the fastest time an algorithm can run.

**Theta Notation (Θ) – Tight Bound (Average Case)**
- Represents both upper and lower bounds, meaning the algorithm will always run within this time.
- Example:\
**Merge Sort:** Θ(n log n) (Always runs in n log n time).\
**Linear Search:** Θ(n) (Always scans through n elements).

✅ Use Case: Best notation for measuring the true efficiency of an algorithm.



