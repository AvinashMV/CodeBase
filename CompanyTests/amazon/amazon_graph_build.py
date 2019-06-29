import operator


def dfs(graph, total_nodes):
    start = graph.keys()[0]
    stack = [start]
    visited = set()
    while stack:
        cur = stack.pop()
        if cur not in visited:
            visited.add(cur)
            for edge in graph[cur]:
                stack.append(edge)
    if len(visited) == total_nodes:
        return True
    else:
        return False


def min_cost(total_nodes, total_routes, network_routes, new_routes):
    graph ={}
    for i in network_routes:
        if i[0] not in graph:
            graph[i[0]] = [i[1]]
        else:
            graph[i[0]].append(i[1])
        if i[1] not in graph:
            graph[i[1]] = [i[0]]
        else:
            graph[i[1]].append(i[0])

    for j in range(1, total_nodes+1):
        if j not in graph:
            graph[j] = []

    new_routes.sort(key=operator.itemgetter(2))
    min_cost = 0
    for k in new_routes:
        graph[k[0]].append(k[1])
        graph[k[1]].append(k[0])
        min_cost += k[2]
        if dfs(graph, total_nodes):
            break
    return min_cost


if __name__ == '__main__':
    total_nodes = 6
    total_routes = 3
    network_routes = [[1, 4], [4, 5], [2, 3]]
    new_routes = [[1,2,5], [1,3, 10], [1,6,2], [5,6,5]]
    print min_cost(total_nodes, total_routes, network_routes, new_routes)