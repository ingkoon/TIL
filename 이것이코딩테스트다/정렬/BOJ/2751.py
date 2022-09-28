'''
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 수가 주어진다. 
이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 
수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
'''

from sys import stdin

input = stdin.readline

n = int(input())


arr = []
for _ in range(n):
    num = int(input())
    arr.append(num)

def quick_sort(arr, start, end):
    if start > end:
        return
    pivot = start 
    left = start + 1
    right = end

    while left <= right:
        while left <= end and arr[pivot] > arr[left]:
            left += 1
        while right > start and arr[pivot] <= arr[right]:
            right -= 1

        if left > right:
            arr[pivot], arr[right] = arr[right], arr[pivot]
        else:
            arr[pivot], arr[left] = arr[left], arr[pivot]
    
    quick_sort(arr, start, right -1)
    quick_sort(arr, right + 1, end)

quick_sort(arr, 0, len(arr) -1)
for i in range(len(arr)-1, -1, -1):
    print(arr[i])