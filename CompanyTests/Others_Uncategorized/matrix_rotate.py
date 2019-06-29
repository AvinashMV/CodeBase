if __name__ == '__main__':
    matrix = [[1,2,3],[4,5,6],[7,8,9]]
    n = len(matrix)
    for j in range(n):
        sub_list = []
        for i in range(n - 1, -1, -1):
            sub_list.append(matrix[i][j])
        matrix.append(sub_list)
    print matrix
    for k in range(n):
        print matrix[0]
        # del matrix[k]
    # print matrix