# Bitwise Operators in Java

### What is Bitwise Operators?
- Bitwise operators in Java operate on individual bits of an integer. They perform operations faster than arithmetic operators in many cases.
- Mostly Bitwise operation is performed on integer vales.

#### 1. Bitwise And Operator (&)
Sets bit to 1 if both bits are 1.
```
    void bitwiseAnd() {
        int a = 3;
        int b = 6;
        System.out.println(a & b); // Output: 2
    }
```
**Output:** 2\
**Explanation:**
```
Binary Reperesentation of 3: 0 0 1 1
Binary Reperesentation of 6: 0 1 1 0
                         -------------
              & Operation:   0 0 1 0 
            Equivalent to:   2
```

#### 2. Bitwise Or Operator (|)
Sets bit to 1 if at least one bit is 1.
```
    void bitwiseOr() {
        int a = 3;
        int b = 6;
        System.out.println(a | b); // Output: 7
    }
```
**Output:** 7\
**Explanation:**
```
Binary Reperesentation of 3: 0 0 1 1
Binary Reperesentation of 6: 0 1 1 0
                         -------------
              | Operation:   0 1 1 1 
            Equivalent to:   7
```

#### 3. Bitwise XOR Operator (^)
Sets bit to 1 if bits are different.
```
    void bitwiseXor() {
        int a = 3;
        int b = 6;
        System.out.println(a ^ b); // Output: 5
    }
```
**Output:** 5\
**Explanation:**
```
Binary Reperesentation of 3: 0 0 1 1
Binary Reperesentation of 6: 0 1 1 0
                         -------------
              ^ Operation:   0 1 0 1 
            Equivalent to:   5
```

#### 4. Bitwise Complement (~)
Flips all bits (one’s complement).\
Output will be 2's complement of the input number.
```
    void bitwiseComplement() {
        int a = 3;
        System.out.println(~a); // Output: -4
    }
```
**Output:** -4\
**Explanation:**
```
It flips all the bits and left most bit represents signs of a number.
- If left most bit is 1 then the number will be negative.
- If left most bit is 0 then the number will be positive.
- The left most bit will not be considered in calculating the output, 
it will only determine the sign.

Binary Reperesentation of 3: 0 0 1 1
                         -------------
              ~ Operation:   1 1 0 0 
            Equivalent to:   -4
```

#### 5. Left Shift (<<)
- Shifts bits left, filling with 0s. \
- So this will shift the binary representation and append 0 at the end.
```
    void bitwiseLeftShift() {
        int a = 3;
        System.out.print(a << 1); // Output: 6
        System.out.print(a << 2); // Output: 12
        System.out.print(a << 3); // Output: 48
    }
```
**Output:** 6 12 48\
**Explanation:**
```
Binary Reperesentation of 3: 0 0 1 1
                         -------------
            << 1 Operation:   0 1 1 0 (Shift the binary representation by 1)
            Equivalent to:   6
            
Binary Reperesentation of 3: 0 0 1 1
                         -------------
            << 2 Operation:  1 1 0 0 (Shift the binary representation by 2)
            Equivalent to:   12
            
Binary Reperesentation of 3: 0 0 0 1 1
                         -------------
            << 3 Operation:  1 1 0 0 0 (Shift the binary representation by 3)
            Equivalent to:   48
```

#### 6. Signed Right Shift (>>)
- Shifts bits right, sign bit is preserved
- If the number is positive, it will keeps number positive and if the number is negative it will keep number negative.
- So this will shift the binary representation and append 0 at the start of representation.
```
    void bitwiseRightShift() {
        int a = 33;
        System.out.print(a >> 1); // Output: 16
        System.out.print(a >> 4); // Output: 2
    }
```
**Output:** 16 2\
**Explanation:**
```
Binary Reperesentation of 33: 0 0 1 0 0 0 0 1
                         -----------------------
            >> 1 Operation:   0 0 0 1 0 0 0 0 (Shift the binary representation by 1)
             Equivalent to:   16
            
Binary Reperesentation of 33: 0 0 0 0 1 0 0 0 0 1
                         --------------------------
            >> 4 Operation:   0 0 0 0 0 0 0 0 1 0 (Shift the binary representation by 4)
             Equivalent to:   2
```

#### 7. Unsigned Right Shift (>>>)
- Shifts bits right, fills with 0s.
- For Positive Numbers, unsigned right shift will work same as signed right shift.
- For negative numbers, it will append 0 at the left of binary representation so the sign will get changed.
```
    void bitwiseUnsignedRightShift() {
        int a = -5;
        System.out.print(a >>> 1); // Output: 1
        System.out.print(a >>> 4); // Output: 2
    }
```
**Output:** 1\
**Explanation:**
```
Binary Reperesentation of 33: 0 0 1 0 0 0 0 1
                         -----------------------
            >> 1 Operation:   0 0 0 1 0 0 0 0 (Shift the binary representation by 1)
             Equivalent to:   16
            
Binary Reperesentation of 33: 0 0 0 0 1 0 0 0 0 1
                         --------------------------
            >> 4 Operation:   0 0 0 0 0 0 0 0 1 0 (Shift the binary representation by 4)
             Equivalent to:   2
```