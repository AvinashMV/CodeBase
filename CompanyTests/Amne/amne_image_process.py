def find_sum(start_i, start_j, end_i, end_j, arr):
    for i in range(start_i, end_i):
        for j in range(start_j, end_j):
            if arr[i][j] != 1:
                return False
    return True


def process_image(arr):
    max_size = len(arr)
    flag = True
    i = max_size
    while max_size > 1 and flag:
        for ind_row in range(0, i-max_size):
            for ind_col in range(0, i-max_size):
                if find_sum(ind_row, ind_col, ind_row+max_size, ind_col+max_size, arr):
                    return max_size
        max_size -= 1
    return max_size


if __name__ == '__main__':
    inp = [[1, 1, 1, 1, 1], [1, 1, 1, 0, 0], [1, 1, 1, 0, 0], [1, 1, 1, 0, 0], [1, 1, 1, 1, 1]]
    print process_image(inp)