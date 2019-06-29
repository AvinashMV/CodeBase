if __name__ == '__main__':
    mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    count = 0
    i = 0
    j = 0
    n = len(mat)
    m = len(mat[0])
    stack = []
    while j<m:
        stack.append(mat[i][j])
        j += 1
    j -= 1
    i += 1
    while i<n:
        stack.append(mat[i][j])
        i += 1
    i -= 1
    j -= 1
    while j>-1:
        stack.append(mat[i][j])
        j -= 1
    j += 1
    i -= 1
    while i>0:
        stack.append(mat[i][j])
        i -= 1
    stack = stack[len(stack)-m/2:] + stack[:len(stack)-m/2]
    i = 0
    j = 0
    while j<m:
        mat[i][j] = stack.pop(0)
        j += 1
    j -= 1
    i += 1
    while i<n:
        mat[i][j] = stack.pop(0)
        i += 1
    i -= 1
    j -= 1
    while j>-1:
        mat[i][j] = stack.pop(0)
        j -= 1
    j += 1
    i -= 1
    while i>0:
        mat[i][j] = stack.pop(0)
        i -= 1
    print mat
