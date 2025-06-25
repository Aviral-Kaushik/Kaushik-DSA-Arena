# 📘 Infix, Postfix & Prefix Expressions – Notes

### ✅ 1. What Are Expressions?
An **expression** is a combination of **operands** (like variables and constants) and 
**operators** (like ```+```, ```-```, ```*```, ```/```) used to compute a value.

### 📌 2. Expression Types
| Expression Type     | Format Example | Order of Operators        |
|---------------------|----------------|---------------------------|
| **Infix**           | `A + B`        | Operator between operands |
| **Postfix (RPN)**   | `A B +`        | Operator after operands   |
| **Prefix (Polish)** | `+ A B`        | Operator before operands  |

### 🧠 3. Why Convert Infix to Postfix/Prefix?
- Infix expressions require parentheses and operator precedence rules to evaluate correctly.
- **Postfix and Prefix expressions** eliminate ambiguity and make evaluation easier for computers using **stacks**.
- Parentheses are not needed when converting to postfix/prefix.

### 🔄 4. Conversion Rules
### 🔹 Infix → Postfix:
- Use **stack** to hold operators and maintain precedence.
- Output operands directly.
- Pop operators from the stack when precedence rules are satisfied.
- Use parentheses for grouping but discard them in output.

### 🔹 Infix → Prefix:
- Reverse the infix expression.
- Convert to postfix using similar rules.
- Reverse the result to get prefix.

### 💡 Operator Precedence (Highest to Lowest):
| Operator | Description     | Associativity |
|----------|-----------------|---------------|
| `^`      | Exponentiation  | Right to Left |
| `*`, `/` | Multiply/Divide | Left to Right |
| `+`, `-` | Add/Subtract    | Left to Right |

### 🧮 5. Evaluation of Expressions
### ✅ Postfix Evaluation (using Stack):
1. **Scan** left to right.
2. **Push** operands to stack.
3. When operator found, **pop two elements**, apply operator, **push result** back.
4. Final element in stack is the result.
Example:
```
Postfix: 2 3 1 * + 9 -
=> 3*1 = 3 → stack: [2, 3]
=> 2+3 = 5 → stack: [5]
=> 5-9 = -4 → Final result
```

### ✅ Prefix Evaluation (using Stack):
1. **Scan** right to left.
2. **Push** operands.
3. When operator is found, **pop two operands**, apply operation, **push result**.
Example:
```
Prefix: - + 2 * 3 1 9
=> 3*1 = 3 → push
=> 2+3 = 5 → push
=> 5-9 = -4 → Final result
```

### 🧾 6. Example Summary
| Infix        | Prefix     | Postfix    |
|--------------|------------|------------|
| A + B        | + A B      | A B +      |
| A + B \* C   | + A \* B C | A B C \* + |
| (A + B) \* C | \* + A B C | A B + C \* |

### ⚠️ 7. Important Notes:
- Always use **stacks** to convert or evaluate prefix/postfix.
- Associativity affects how operators of same precedence are evaluated.
- Always evaluate expressions **without parentheses** after converting.