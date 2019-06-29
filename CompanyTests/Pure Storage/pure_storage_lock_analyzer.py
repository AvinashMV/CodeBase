def solution(events):
    store_stack = []
    for ind, i in enumerate(events):
        temp_list = i.split(' ')
        if temp_list[0] == 'ACQUIRE':
            if temp_list[1] in store_stack:
                return ind+1
            store_stack.append(temp_list[1])
        elif temp_list[0] == 'RELEASE':
            if store_stack.pop() != temp_list[1]:
                return ind+1
    if store_stack:
        return ind+2
    else:
        return 0

if __name__ == '__main__':
    input_str = ['ACQUIRE 364', 'ACQUIRE 84', 'ACQUIRE 364', 'RELEASE 364']
    ans = solution(input_str)
    print ans