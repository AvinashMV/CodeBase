from collections import Counter
def permute(nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """

    def backtrack(first=0):
        # if all integers are used up
        if first == n:
            output.append(nums[:])
        for i in range(first, n):
            # place i-th integer first
            # in the current permutation
            nums[first], nums[i] = nums[i], nums[first]
            # use next integers to complete the permutations
            backtrack(first + 1)
            # backtrack
            nums[first], nums[i] = nums[i], nums[first]

    n = len(nums)
    output = []
    backtrack()
    return output

def permute(nums):
    my_dict = Counter(nums)
    keys = my_dict.keys()
    values = my_dict.values()
    # for i, j in Counter(nums).iteritems():
    #     while j
    result= []
    def backtrack(keys,counter_arr,i,sub_arr):
        if i == len(nums):
            result.append(sub_arr)
        else:




ans = permute([1, 1, 2, 3])