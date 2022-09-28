from sys import stdin

input = stdin.readline

n = int(input())

arr = []

for _ in range(n):
    tmp = int(input())
    arr.append(tmp)

arr.sort()

for i in arr:
    print(i)