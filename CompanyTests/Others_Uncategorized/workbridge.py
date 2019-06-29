import Queue as Q
def order(employee_nodes, employees_from, employees_to, host):
    dict = {}
    for i, j in zip(employees_from, employees_to):
        if i in dict:
            dict[i].append(j)
        else:
            dict[i] = [j]
    k = 0
    visited=[]
    frontier = Q.Queue()
    frontier.put(host)
    print "put done"
    u = frontier.get()
    ret_list = []
    while k < employee_nodes:
        if u not in visited:
            visited.append(u)
            k+=1
            if u in dict:
                for neigh in dict[u]:
                    frontier.put(neigh)
                    ret_list.append(neigh)
        u = frontier.get()
    if host in visited:
        visited.remove(host)
    return visited



if __name__ == '__main__':
    emp_count = 5
    efrom = [1,1,2,3,1]
    eto = [2,3,4,5,5]
    src = 1
    ans = order(emp_count, efrom, eto, src)
    print ans