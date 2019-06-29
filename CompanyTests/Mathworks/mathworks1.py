import sys
class Node:

    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data


def get_min_pair(copy_list):
    new_min = sys.maxint
    min_pair = []
    for i in range(len(copy_list)-1):
        if copy_list[i].data+copy_list[i+1].data < new_min:
            new_min = copy_list[i].data+copy_list[i+1].data
            min_pair = []
            min_pair.append(copy_list[i])
            min_pair.append(copy_list[i+1])
    return min_pair

def get_max_tree(node):
    if node == None:
        return -1
    res = node.data
    lres = get_max_tree(node.left)
    rres = get_max_tree(node.right)
    if lres > res:
        res = lres
    if rres > res:
        res = rres
    return res


if __name__ == '__main__':
    my_list = [5, 1, 2, 3]
    copy_list = []
    for i in my_list:
        copy_list.append(Node(i))
    while len(copy_list) > 1:
        min_pair = get_min_pair(copy_list)
        if min_pair[0].left == None and min_pair[0].right == None and min_pair[1].left == None and min_pair[1].right == None:
            root = Node(min_pair[0].data * min_pair[1].data)
            root.left = min_pair[0]
            root.right = min_pair[1]
        elif min_pair[0].left and min_pair[0].right and min_pair[1].left and min_pair[1].right:
            left_max = get_max_tree(min_pair[0])
            right_max = get_max_tree(min_pair[1])