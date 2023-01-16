import sys

n = sys.stdin.readline().rstrip()
x = ord(n[0]) - 96
y = int(n[1])

dx = [2, -2, 2, -2, 1, -1, 1, -1]
dy = [1, 1, -1, -1, 2, 2, -2, -2]

result = 0

for i in range(8):    
    nx = x + dx[i]
    ny = y + dy[i]
    if 1 <= nx < 8 and 1 <= ny < 8:
        result +=1

print(result)



