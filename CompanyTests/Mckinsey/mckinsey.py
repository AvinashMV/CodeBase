input = [(2,13),(5,3),(10,8),(13,4),(15,0),(17,10),(20,5),(25,9),(28,7),(31,0)]
retList = []
for i,j in enumerate(input):
    if i == len(input)-1:
        pass
    else:
        a = [j[1]] * (input[i][0]-input[(i+1)][0])
        retList.extend([j[1]] * abs(input[i][0]-input[(i+1)][0]))

debug = 10