import operator

def solution(maxTravelDist, forwardRouteList, returnRouteList):
    fDict = {}
    rDict = {}
    for i in forwardRouteList:
        fDict[i[0]] = i[1]
    for j in returnRouteList:
        rDict[j[0]] = j[1]
    sorted_fDict = sorted(fDict.items(), key=operator.itemgetter(1))
    sorted_rDict = sorted(rDict.items(), key=operator.itemgetter(1))
    cur_max = 0
    cur_ans = []
    for i, j in sorted_fDict:
        for k, l in sorted_rDict:
            if j+l == cur_max:
                cur_ans.append((i, k))
            elif j+l <= maxTravelDist and j+l>cur_max:
                cur_ans = []
                cur_max = j+l
                cur_ans.append((i, k))
            elif j+l > maxTravelDist:
                break
    print cur_ans

if __name__ == '__main__':
    maxTravelDist = 20
    forwardRouteList = [[1, 8], [2, 15], [3, 9]]
    returnRouteList = [[1, 8], [2, 11], [3, 12]]
    # maxTravelDist = 10000
    # forwardRouteList = [[1, 3000], [2, 5000], [3, 7000], [4, 10000]]
    # returnRouteList = [[1, 2000], [2, 3000], [3, 4000], [4, 5000]]
    solution(maxTravelDist, forwardRouteList, returnRouteList)