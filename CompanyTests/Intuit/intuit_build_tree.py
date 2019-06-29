def solution(input):
    my_dict = {}
    starts = []
    dest = []
    for i in input:
        if i[0] in my_dict:
            my_dict[i[0]].append(i[1])
            dest.append(i[1])
        else:
            starts.append(i[0])
            dest.append(i[1])
            my_dict[i[0]] = [i[1]]
    strict_starts = list(set(starts) - set(dest))
    ret_dict = {}
    for i in strict_starts:
        ret_dict[i] = []
        cur = i
        visited = []
        my_stack = [cur]
        while len(my_stack):
            cur = my_stack.pop()
            if cur not in starts:
                ret_dict[i].append(cur)
            if cur not in visited:
                visited.append(cur)
                if cur in my_dict:
                    for j in my_dict[cur]:
                        my_stack.append(j)
    for key, val in ret_dict.iteritems():
        ret_dict[key] = list(set(val))

    return ret_dict

if __name__ == '__main__':
    # input = [['A', 'B']]
    # input = [['B', 'A'], ['C', 'A'], ['D', 'A'], ['A', 'F']]
    input = [['A', 'B'], ['A', 'C'], ['B', 'K'], ['C', 'K'], ['E', 'L'], ['F', 'G'], ['J', 'M'], ['E', 'F'], ['G', 'H'], ['G', 'I']]
    ans = solution(input)
    print ans