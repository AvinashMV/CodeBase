def min_fountain(given_list):
    num_fountains = len(given_list)
    cover = [False for _ in range(num_fountains)]
    count = {}
    fount_dict = {}
    for ind, i in enumerate(given_list):
        fount_dict[ind] = [j for j in range(ind-i, ind+i+1) if j>=0 and j<len(cover)]
    sorted_keys = []
    for k in sorted(fount_dict, key=lambda k: len(fount_dict[k]), reverse=True):
        sorted_keys.append(k)
    for i in sorted_keys:
        for j in fount_dict[i]:
            if not cover[j]:
                cover[j] = True
                count[i] = True
    return len(count)


if __name__ == '__main__':
    given_list = [1, 2, 1]
    ans = min_fountain(given_list)
    print ans