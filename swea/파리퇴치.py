import sys

t = int(sys.stdin.readline())
for case in range(t):
    n, m = map(int, sys.stdin.readline().split())
    arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    result = 0
    for i in range(n):
        for j in range(n):
            nx = j + m
            ny = i + m 
            if 0<= nx < n and 0<= ny < n:
                tmp = 0
                for k in range(i, ny):
                    tmp += sum(arr[k][j:nx])
                if result < tmp:
                    result = tmp
    print("#{0}".format(case+1), result)
