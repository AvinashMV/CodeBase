def numDistinctIslands(self, grid):
    """
    :type grid: List[List[int]]
    :rtype: int
    """
    big_num = 99999

    def landToWater(grid, i, j, r0, c0):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == 0 or grid[i][j] == big_num:
            return
        else:
            grid[i][j] = big_num
            shape.add((i - r0, j - c0))
            landToWater(grid, i, j + 1, r0, c0)
            landToWater(grid, i + 1, j, r0, c0)
            landToWater(grid, i - 1, j, r0, c0)
            landToWater(grid, i, j - 1, r0, c0)

    shapes = set()
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            shape = set()
            if grid[i][j] == 1:
                landToWater(grid, i, j, i, j)
                big_num -= 1
            if shape:
                shapes.add(frozenset(shape))
    return len(shapes)