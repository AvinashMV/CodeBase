def pushDominoes(dominoes):
    """
    :type dominoes: str
    :rtype: str
    """
    d = list('L' + dominoes + 'R')
    l, r, m = 0, 1, len(dominoes)
    while (r <= m + 1):
        if d[r] == '.':
            r += 1
            continue
        inv = r - l - 1
        if d[l] == d[r]:
            d[l + 1:r] = [d[l]] * inv
        elif d[r] == 'R':
            d[l + 1:r] = ['.'] * inv
        else:
            d[l + 1:l + 1 + inv / 2] = [d[l]] * (inv / 2)
            if (inv % 2) == 1:
                d[l + inv / 2 + inv % 2] = '.'
            d[l + 1 + inv / 2 + inv % 2:r] = [d[r]] * (inv / 2)

        l = r
        r += 1
    return ''.join(d[1:m + 1])

if __name__ == '__main__':
    dominoes = ".L.R...LR..L.."
    pushDominoes(dominoes)
