from Queue import Queue


def minimumGroups(predators):
    tree_dict = {}
    start_nodes = []
    for i, j in enumerate(predators):
        if j == -1:
            start_nodes.append(i)
        if j in tree_dict:
            tree_dict[j].append(i)
        else:
            tree_dict[j] = [i]
    q = Queue()
    for i in tree_dict[-1]:
        q.put(i)
    q.put(-9999)
    final_result = []
    temp = []
    while not q.empty():
        cur = q.get()
        if cur == -9999:
            final_result.append(temp)
            temp = []
            if not q.empty():
                q.put(-9999)
        else:
            temp.append(cur)
            if cur in tree_dict:
                for i in tree_dict[cur]:
                    q.put(i)
    return final_result


if __name__ == '__main__':
    input_list = [-1, 8, 6, 0, 7, 3, 8, 9, -1, 6]
    ans = minimumGroups(input_list)
    print ans