def costofatree(nums):
    max_list = nums[:]
    result = []
    while len(max_list) > 1:
        temp_list = []
        for i in range(0, len(max_list) - 1):
            temp_list.append(max_list[i] * max_list[i + 1])
        inp = [i for i, e in enumerate(temp_list) if e == min(temp_list)]
        result.append(min(temp_list))
        max_list[inp[0]] = max(max_list[inp[0]], max_list[inp[0] + 1])
        del (max_list[inp[0] + 1])
    return sum(result)


if __name__ == '__main__':
    nums = [5, 3, 1, 4, 6]
    res = costofatree(nums)
    print res