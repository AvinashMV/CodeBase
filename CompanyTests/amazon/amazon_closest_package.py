import math
import operator


def closestLocations(totalCrates, allLocations, truckCapacity):
    if totalCrates <= truckCapacity:
        return allLocations
    truck_location = [0, 0]
    co_dict = {}
    for j, i in enumerate(allLocations):
        co_dict[j] = math.sqrt(math.pow(truck_location[0] - i[0], 2) + math.pow(truck_location[1] - i[1], 2))
    sorted_dict = sorted(co_dict.items(), key=operator.itemgetter(1))
    print sorted_dict
    count = 0
    ret_list = []
    for i, j in sorted_dict:
        if count<truckCapacity:
            ret_list.append(allLocations[i])
            count += 1

    return ret_list

if __name__ == '__main__':
    num_of_crates = 3
    locations = [[1, -3], [1, 2], [3, 4]]
    cut_off = 1
    ans = closestLocations(num_of_crates, locations, cut_off)
    print ans