def get_possible(self, maze, i, j):
    ret_pos = []
    u = i - 1
    while u >= 0 and maze[u][j] == 0:
        u -= 1
    ret_pos.append((u + 1, j))
    r = j + 1
    while r < len(maze[0]) and maze[i][r] == 0:
        r += 1
    ret_pos.append((i, r - 1))
    d = i + 1
    while d < len(maze) and maze[d][j] == 0:
        d += 1
    ret_pos.append((d - 1, j))
    l = j - 1
    while l >= 0 and maze[i][l] == 0:
        l -= 1
    ret_pos.append((i, l + 1))
    return ret_pos


def hasPath(self, maze, start, destination):
    """
    :type maze: List[List[int]]
    :type start: List[int]
    :type destination: List[int]
    :rtype: bool
    """
    stack = [(start[0], start[1])]
    visited = set()
    while stack:
        i, j = stack.pop()
        if (i, j) not in visited:
            visited.add((i, j))
            possible = self.get_possible(maze, i, j)
            for k, l in possible:
                if k == destination[0] and l == destination[1]:
                    return True
                elif k < len(maze) and k >= 0 and l < len(maze[0]) and l >= 0 and maze[k][l] == 0:
                    stack.append((k, l))
    return False