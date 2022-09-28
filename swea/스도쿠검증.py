import sys

def hor(n):
    num = [0] * 9
    for i in range(9):
        num[board[n][i] -1] += 1
    for i in num:
        if i ==0 or i>1:
            return 0
    return 1

def ver(n):
    num = [0] * 9
    for i in range(9):
        num[board[i][n]-1] += 1
    for i in num:
        if i ==0 or i>1:
            return 0
    return 1

def thr(n):
    num = [0] * 9
    for i in range(n, n+3):
        for j in range(n, n+3):
            num[board[i][j]-1] += 1
    for i in num:
        if i ==0 or i>1:
            return 0
    return 1


t = int(sys.stdin.readline())
for case in range(t):
    board = [list(map(int, sys.stdin.readline().split())) for _ in range(9)]
    result = 1
    for i in range(9):
        if hor(i) == 0 or ver(i) == 0:
            result = 0
    for i in range(0, 9, 3):    
        if thr(i) == 0:
            result = 0
    print("#{0}".format(case + 1), result)

