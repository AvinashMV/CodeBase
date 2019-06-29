def findClosestElements(A, k, x):
    left, right = 0, len(A) - k
    while left < right:
        mid = (left + right) / 2
        print x - A[mid], A[mid+k]-x
        if x - A[mid] > A[mid + k] - x:
            left = mid + 1
        else:
            right = mid
    return A[left:left + k]


if __name__ == '__main__':
    A = [1,2,3,4,5]
    k = 4
    x = 3
    print findClosestElements(A, k, x)
