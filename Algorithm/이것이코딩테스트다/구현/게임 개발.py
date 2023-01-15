import sys

n, m = map(int, sys.stdin.readline().split())
x, y, d = map(int, sys.stdin.readline().split())

board = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
print(board)
