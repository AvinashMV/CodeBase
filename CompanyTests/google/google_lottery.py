def find_index(input_arr, ind, ele):
    for i,j in enumerate(input_arr):
        if j == ele and i>ind:
            return i
    return -1


def solution(input_arr):
    my_dict = {}
    min_lottery = 99999
    for i, j in enumerate(input_arr):
        ind = find_index(input_arr, i, j)
        if ind != -1:
            if j in my_dict:
                if ind-i+1<min_lottery:
                    min_lottery = ind-i+1
                my_dict[j].append(ind-i+1)
            else:
                if ind-i+1<min_lottery:
                    min_lottery = ind-i+1
                my_dict[j] = [ind-i+1]
    return min_lottery


if __name__ == '__main__':
    input_arr = [5,4,3,2,4,3,5,5,7]
    ans = solution(input_arr)
    print ans