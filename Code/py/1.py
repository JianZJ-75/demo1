from sympy import symbols, Eq, solve

# 定义变量n
n = symbols('n')

# 定义方程
equation = Eq((63.56 + 3.592 * n**2 / 80) * (80 - 0.04267 * n), 0.0821 * 298.15 * n)

# 求解方程
solutions = solve(equation, n)

# 打印解
print(solutions)