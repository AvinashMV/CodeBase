def sorted_search(elements, target):
    if not elements or len(elements) <=0:
        return -1
    left = 0
    right = len(elements)-1
    while left < right:
        middle = (left+right+1)/2
        if elements[middle] > target:
            right = middle-1
        else:
            left = middle+1
    if elements[right] == target:
        return right
    return -1

if __name__ == '__main__':
    input_str = [2,4,6,8,10]
    ans = sorted_search(input_str, 4)
    print ans