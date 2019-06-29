request_dict = {}


def insert_dict(request_dict, i):
    if i not in request_dict:
        request_dict[i] = 1
    else:
        request_dict[i] += 1


def solution(input_list):
    sorted_list = sorted(input_list, reverse=True)
    for ind, i in enumerate(sorted_list):
        age_cutoff = int((i/2)+7)
        filtered_rec = [j for j in sorted_list[ind+1:] if j >= age_cutoff]
        for j in filtered_rec:
            if i > 100 and j > 100:
                insert_dict(request_dict, i)
            elif i < 100:
                insert_dict(request_dict, i)


if __name__ == '__main__':
    input_list = [120, 110]
    solution(input_list)
    print sum(request_dict.values())