import sys

n, k = map(int, sys.stdin.readline().split())

a = list(map(int, sys.stdin.readline().split()))
b = list(map(int, sys.stdin.readline().split()))

a.sort()
b.sort(reverse= True)

for i in range(k):
    a[i], b[i] = b[i], a[i]

print(sum(a))