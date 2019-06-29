class Solution:
    def __init__(self):
        self.distances = {}

    def distance(self, input):
        loc1, loc2, distance = input.split(":")
        distance = int(distance)
        if loc1 in self.distances:
            self.distances[loc1][loc2] = distance
        else:
            self.distances[loc1] = {loc2: distance}
        if loc2 in self.distances:
            self.distances[loc2][loc1] = distance
        else:
            self.distances[loc2] = {loc1: distance}
        long_dist = []
        long_city = []
        for city in self.distances:
            for con_city, dist in self.distances[city].items():
                con_dict = self.distances[con_city]
                max_val = -1
                max_con_city = None
                max_con_con_dist = 0
                for con_con_city, con_con_dist in con_dict.items():
                    if con_con_dist > max_val:
                        max_con_city = con_con_city
                        max_con_con_dist = con_con_dist
                if con_con_city == city:
                    continue
                long_dist += [dist + max_con_con_dist]
                long_city += [city + ":" + con_city + ":" + max_con_city]
        if not long_dist:
            return None
        else:
            max_dist = max(long_dist)
            max_city = long_city[long_dist.index(max_dist)]
            max_cities = max_city.split(":")
            sorted_city = sorted([max_cities[0], max_cities[-1]])

            return str(max_dist) + ":" + sorted_city[0] + ":" + max_cities[1] + ":" + sorted_city[-1]

        # print(self.distances)


if __name__ == '__main__':
    s = Solution()
    print(s.distance("CHI:NYC:719"))
    print(s.distance("NYC:LA:2448"))
    print(s.distance("NYC:H:4924"))