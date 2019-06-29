def check_substr(given_str):
    if len(set(given_str)) == len(given_str):
        return True
    else:
        return False

def kdistinct(locations, cut_off):
    i = 0
    j = cut_off
    ret_list = []
    while j <= len(locations) and j-i == cut_off:
        sub_str = locations[i:j]
        if check_substr(sub_str):
            ret_list.append(sub_str)
        i += 1
        j += 1
    return ret_list

if __name__ == '__main__':
    # locations = 'abcd'
    locations = 'democracy'
    cut_off = 5
    ans = kdistinct(locations, cut_off)
    print list(set(ans))



def subStringsKDist(inputStr, num):
    if len(inputStr) == 0:
        return 0
    char_set = set()
    i = 0
    j = 1
    if i<len(inputStr):
        char_set.add(inputStr[i])
    res = []
    while i<j and j<len(inputStr):
        if inputStr[j] not in char_set and len(char_set) < num:
            char_set.add(inputStr[j])
            j+=1
        else:
            res.append(inputStr[i:j])
            i+=1
            j = i+1
            char_set = set()
            char_set.add(inputStr[i])
    if j-i == num:
        res.append(inputStr[i:j])
    res = [char for char in res if len(char)==num]
    return list(set(res))

print(subStringsKDist('awaglknagawunagwkwagl',4))