from sys import stdin

input = stdin.readline

n = int(input())

arr = [input().rstrip() for _ in range(n)]
arr = set(arr)

result = sorted(arr, key=lambda x: (len(x), x))

for i in result:
    print(i)