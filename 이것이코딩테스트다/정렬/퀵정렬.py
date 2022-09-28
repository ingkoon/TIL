array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    if start >= end:
        return
    pivot = start
    left = start + 1
    right = end

    # 엇갈리기 전까지 반복 수행
    while left <= right:
        # 마지막 값 보다 작고, 피벗보다 큰값을 만나기 전까지 반복 수행
        while left <= end and array[pivot] > array[left]:
            left += 1
        
        # 첫 번째 값보다 크고, 피벗보다 작은 값을 만나기 전까지 반복 수행
        while right > start and array[pivot] <= array[right]:
            right -= 1
        
        # 엇갈렸을 경우
        if left > right:
            # 작은 값을 피벗과 교체
            array[pivot], array[right] = array[right], array[pivot]
        else:
            # 엇갈리지 않았을 경우 큰 값을 피벗과 교체
            array[pivot], array[left] = array[left], array[pivot]
    
    quick_sort(array, start, right -1)
    quick_sort(array, right +1, end)

quick_sort(array, 0, len(array) - 1)
print(array)