def findFrequentEntries(pairs):
    build_dict = {}
    for i in pairs:
        if i[0] in build_dict:
            build_dict[i[0]].append(i[1])
        else:
            build_dict[i[0]] = [i[1]]
    for i, j in build_dict.items():
        build_dict[i] = sorted(j)
    end_res = []
    for i, j in build_dict.items():
        fp = 0
        sp = 1
        cur_buff = [j[fp]]
        finish_flag = True
        while finish_flag and fp<len(j) and sp<len(j):
            if j[sp]-j[fp]>100 and len(cur_buff)>=3:
                finish_flag = False
            elif j[sp]-j[fp]>100 and len(cur_buff)<3:
                fp += 1
                sp = fp+1
                cur_buff = [j[fp]]
            else:
                cur_buff.append(j[sp])
                sp += 1
        if not finish_flag or len(cur_buff)>=3:
            end_res.append((i, cur_buff))
    print end_res


if __name__ == '__main__':
    pairs = [['P', 1355], ['P', 1430], ['R', 1800], ['P', 1456], ['P', 1517]]
    # pairs = [['J', 145], ['P', 100], ['P', 108], ['J', 115], ['P', 159], ['P', 315], ['J', 130]]
    # pairs = [['P',1355],['J',1910],['M',830],['P', 1315],['M',835],['P',1405],['P',1630],['M',855],['M',930],['M',915],['J',1335],['J',730],['M',1630]]
    findFrequentEntries(pairs)