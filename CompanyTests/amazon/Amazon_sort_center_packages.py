def IDsOfPackages(truckSpace, packagesSpace):
    target = truckSpace-30
    d = {}
    ans = []
    for i, num in enumerate(packagesSpace):
        if target-num in d:
            ans.append((target-num, num))
        d[num] = i

    if len(ans) == 0:
        return []
    elif len(ans) < 2:
        return [d[ans[0][0]], d[ans[0][1]]]
    else:
        cur_max_pair = []
        cur_max = -1
        for i, j in ans:
            temp_max = max(i, j)
            if temp_max > cur_max:
                cur_max = temp_max
                cur_max_pair = [d[i], d[j]]
        return cur_max_pair


if __name__ == '__main__':
    truckSpace = 250
    packagesSpace = [100, 180, 40, 120, 10]
    print IDsOfPackages(truckSpace, packagesSpace)