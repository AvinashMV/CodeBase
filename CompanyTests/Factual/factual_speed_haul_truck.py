def get_closest(l, target):
    near_max = -1
    for i in l:
        if i<target:
            near_max = i
        else:
            break
    return near_max

def solution(readings, end_time):
    times = []
    sp_dict = {}
    for time, sp in readings:
        times.append(time)
        sp_dict[time] = sp
    near_max = get_closest(times, end_time)
    cur_dist = (float((end_time-near_max))/3600.0)*sp_dict[near_max]
    while near_max:
        prev = times.index(near_max)-1
        cur_dist += ((near_max-times[prev])/3600.0)*sp_dict[times[prev]]
        near_max = times[prev]
    return cur_dist


if __name__ == '__main__':
    readings = [(0, 90), (300, 80)]
    end_time = 600
    print solution(readings, end_time)