def solution(u):
    freq_count = {}
    res = []
    for i in u:
        if i not in freq_count:
            freq_count[i] = 0
            res.append(i)
        else:
            freq_count[i] += 1
            res.append(i+str(freq_count[i]))
    print res

if __name__ == '__main__':
    given_list = ['alex', 'xylos', 'alex', 'alen', 'bob']
    solution(given_list)
