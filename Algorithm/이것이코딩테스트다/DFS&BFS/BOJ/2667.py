# 단지번호 붙이기

import sys
from collections import deque

n = int(sys.stdin.readline())

aparts = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]


dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

result = []

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    aparts[x][y] = 0
    cnt = 1

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 > nx or n <= nx or 0 > ny or n <= ny:
                continue
            
            if aparts[nx][ny] == 1:
                cnt += 1
                aparts[nx][ny] = 0
                queue.append((nx, ny))
    return cnt

for i in range(n):
    for j in range(n):
        if aparts[i][j] == 1:
            tmp = bfs(i, j)
            if tmp != 0:
                result.append(tmp)

result.sort()

print(len(result))
for i in result:
    print(i)