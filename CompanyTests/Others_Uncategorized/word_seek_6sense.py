def generate_directions(point, n):
    x, y = point
    possible_dir = [(x-1, y, 0), (x+1, y, 4), (x+1, y-1, 5), (x-1, y+1, 1), (x-1, y-1, 7), (x, y+1, 2), (x, y-1, 6), (x+1, y+1, 3)]
    dir_dict = {z: (x, y) for x, y, z in possible_dir}
    for z, point in dir_dict.items():
        if point[0]>=0 and point[0]<n or point[1]>=0 and point[1]<n:
            pass
        else:
            del dir_dict[z]
    return dir_dict


def search_word(word_dict, search_set):
    pos = []
    for i in search_set:
        for first_word_pos in word_dict[i[0]]:
            pos_next_dirs = generate_directions(first_word_pos, len(word_dict))
            for dir, point in pos_next_dirs.items():
                if point[0] 



    pass


if __name__ == '__main__':
    word_grid = ['TRAP', 'CARD','FACT', 'DART']
    search_set = ['CAT', 'DOG', 'FACT']
    word_dict = {}
    for row, i in enumerate(word_grid):
        for col, j in enumerate(i):
            if j in word_dict:
                word_dict[j].append((row, col))
            else:
                word_dict[j] = [(row, col)]
    print word_dict

    # search_word(word_dict, search_set)