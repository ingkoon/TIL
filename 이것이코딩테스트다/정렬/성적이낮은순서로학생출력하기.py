from array import array
import sys

n = int(sys.stdin.readline())

arr = []

for i in range(n):
    input_data = sys.stdin.readline().rstrip().split()

    arr.append((input_data[0], int(input_data[1])))

arr = sorted(arr, key = lambda student: student[1])

print(arr)

for student in arr:
    print(student[0], end = " ")

