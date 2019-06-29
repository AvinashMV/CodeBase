# Complete the latestStudent function below.
def latestStudent(attendanceData):
    if(len(attendanceData)):
        dict = {}
        for row in attendanceData:
            key = row[0]+":"+row[2]
            latness = int(row[3])-int(row[2])
            if(latness<0):
                latness = 0
            if key in dict:
                n = len(dict[key].keys())-1
                dict[key]['sum'] += latness
                dict[key][row[1]] = latness
                dict[key]['avg'] = dict[key]['sum']/n
            else:
                dict[key] = {}
                dict[key]['sum'] = latness
                dict[key][row[1]] = latness
                dict[key]['avg'] = latness
        students = {}
        for key, value in dict.items():
            avg = dict[key]['avg']
            del dict[key]['avg']
            del dict[key]['sum']
            for student in dict[key]:
                if student not in students:
                    if dict[key][student]>avg:
                        students[student] = dict[key][student]-avg
                    else:
                        students[student] = 0
                else:
                    if dict[key][student]>avg:
                        students[student] += (dict[key][student]-avg)
        max_late = -1
        max_value = max(students.itervalues())
        max_keys = [k for k in students if students[k] == max_value]
        return min(max_keys)
    else:
        return ""
        

