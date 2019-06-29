if __name__ == '__main__':
    nums = [3,4,5,6,7,-1,0,1,2]
    target = 0
    low = 0
    n = len(nums)
    high = n-1
    while low<high:
        mid = (low+high)/2
        if nums[mid]<nums[high]:
            high = mid
        else:
            low = mid+1
    st = low
    low = 0
    high = n-1
    while low<=high:
        mid = (low+high)/2
        act_mid = (mid+st)%n
        print low,high,mid,act_mid
        if nums[act_mid] == target:
            print act_mid
            break
        else:
            if nums[act_mid]<target:
                low = mid+1
            else:
                high = mid-1
    print -1