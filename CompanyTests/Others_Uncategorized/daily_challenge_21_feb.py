# Given an array of integers greater than zero, find if there is a way to
# split the array in two (without reordering any elements) such that the
# numbers before the split add up to the numbers after the split. If so,
# print the two resulting arrays.


def solution(input_arr):
    full_sum = sum(input_arr)
    curr_sum = 0
    for i in input_arr:
        if curr_sum == full_sum:
            return True
        else:
            curr_sum += i
            full_sum -= i
    return False


if __name__ == '__main__':
    input_arr = [2, 3, 2, 1, 1, 1, 2, 1, 1, 10]
    can_solve = solution(input_arr)
    print can_solve