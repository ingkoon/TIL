
# for문을 통한 반복 구현
def factorial_iterative(n):
    result = 1
    for i in range(1, n+1):
        result *= i
    return result

# 재귀적으로 구현한 n!
def factorial_recursion(n):
    if n<= 1:
        return 1
    return n * factorial_recursion(n - 1)

n = 5
print(factorial_iterative(n))
print(factorial_recursion(n))
