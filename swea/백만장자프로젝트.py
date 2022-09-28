import sys

t = int(sys.stdin.readline())

for case in range(t):
    n = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))

    result = 0
    maxVal = arr[-1]

    for i in range(n-2, -1, -1):
        if arr[i] > maxVal:
            maxVal = arr[i]
        else:
            result += maxVal - arr[i]
            
    print("#{0}".format(case + 1), result)