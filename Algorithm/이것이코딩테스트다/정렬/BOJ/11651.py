from sys import stdin

input = stdin.readline

n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]

result = sorted(arr, key = lambda x: (x[1], x[0]))

for i in result:
    print(i[0], i[1])

    