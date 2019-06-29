def game_perform_down(grid):
    j = 0
    while j < len(grid):
        i = len(grid) - 1
        while i > 0:
            if grid[i][j] == grid[i - 1][j]:
                grid[i][j] = 2 * grid[i][j]
                grid[i - 1][j] = 0
            i -= 1
        j += 1
    for i in range(len(grid[0])):
        lst = []
        for j in range(len(grid)):
            lst.append(grid[j][i])
        lst[:] = filter(None, lst)
        temp = [0] * (4 - len(lst))
        temp.extend(lst)
        for j in range(len(grid)):
            grid[j][i] = temp[j]
    return grid


def game_perform_up(grid):
    j = 0
    while j < len(grid):
        i = 0
        while i < len(grid) - 1:
            if grid[i][j] == grid[i + 1][j]:
                grid[i][j] = 2 * grid[i][j]
                grid[i + 1][j] = 0
            i += 1
        j += 1
    for i in range(len(grid[0])):
        lst = []
        for j in range(len(grid)):
            lst.append(grid[j][i])
        lst[:] = filter(None, lst)
        temp = [0] * (4 - len(lst))
        lst.extend(temp)
        for j in range(len(grid)):
            grid[j][i] = lst[j]
    return grid


def game_perform_right(grid):
    i = 0
    while i < len(grid):
        j = len(grid) - 1
        while j > 0:
            if grid[i][j] == grid[i][j - 1]:
                grid[i][j] = 2 * grid[i][j]
                grid[i][j - 1] = 0
            j -= 1
        i += 1
    for i in range(len(grid[0])):
        lst = []
        for j in range(len(grid)):
            lst.append(grid[i][j])
        lst[:] = filter(None, lst)
        temp = [0] * (4 - len(lst))
        temp.extend(lst)
        for j in range(len(grid)):
            grid[i][j] = temp[j]
    return grid


def game_perform_left(grid):
    i = 0
    while i < len(grid):
        j = 0
        while j < len(grid) - 1:
            if grid[i][j] == grid[i][j + 1]:
                grid[i][j] = 2 * grid[i][j]
                grid[i][j + 1] = 0
            j += 1
        i += 1
    for i in range(len(grid[0])):
        lst = []
        for j in range(len(grid)):
            lst.append(grid[i][j])
        lst[:] = filter(None, lst)
        temp = [0] * (4 - len(lst))
        lst.extend(temp)
        for j in range(len(grid)):
            print(j)
            grid[i][j] = lst[j]
    return grid


def game2048(grid, path):
    for ch in path:
        if ch == 'D':
            grid = game_perform_down(grid)
        elif ch == 'U':
            grid = game_perform_up(grid)
        elif ch == 'R':
            grid = game_perform_right(grid)
        elif ch == 'L':
            grid = game_perform_left(grid)
    return grid