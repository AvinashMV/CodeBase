from collections import defaultdict
with open('input.txt') as f:
    myList = []
    for line in f.readlines():
        myList.append(line.split(' '))


request_dict = defaultdict(list)
for row in myList:
    request_dict[row[0]].append(row[1])

with open('records_hosts_access_log_00.txt', 'w') as f:
    for key in request_dict.keys():
        writeStr = key +" " +str(len(request_dict[key]))+"\n"
        f.write(writeStr)
