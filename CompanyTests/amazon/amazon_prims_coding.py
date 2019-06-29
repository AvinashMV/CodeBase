class Graph():

    def _init_(self, numTotalEdgeNodes):
        pass

    # self.numTotalEdgeNodes = numTotalEdgeNodes
    # self.graph = [[0 for column in range(numTotalEdgeNodes)]
    # 			for row in range(numTotalEdgeNodes)]

    def printMST(self, parent,graph):
        print "Edge \tWeight"
        for i in range(1, 6):
            print parent[i], "-", i, "\t", graph[i][parent[i]]


    def minKey(self, key, mstSet, numTotalEdgeNodes):

        # Initilaize min value
        min = 2000
        minKey = None
        min_index = -1
        for v in range(numTotalEdgeNodes):
            if key[v] < min and mstSet[v] == False:
                min = key[v]
                min_index = v

        return min_index

    def primMST(self, numTotalEdgeNodes=6, total_routes=4, networkRoutesAvailable=[[1, 2], [2, 3], [4, 5], [3, 5]],
                costNewNetworkRoutesConstruct=[[2, 6, 410], [2, 4, 800]]):

        if numTotalEdgeNodes == 0:
            return -1
        graph = [[float('inf') for i in range(numTotalEdgeNodes)] for _ in range(numTotalEdgeNodes)]
        for i, j in networkRoutesAvailable:
            graph[i - 1][j - 1] = 0
            graph[j - 1][i - 1] = 0
        if total_routes:
            for i, j, k in costNewNetworkRoutesConstruct:
                graph[i - 1][j - 1] = k
                graph[j - 1][i - 1] = k

        key = [float('inf')] * numTotalEdgeNodes
        parent = [None] * numTotalEdgeNodes
        key[0] = 0
        mstSet = [False] * numTotalEdgeNodes
        parent[0] = -1  # First node is always the root of

        for cout in range(numTotalEdgeNodes):
            u = self.minKey(key, mstSet, numTotalEdgeNodes)
            mstSet[u] = True
            for v in range(numTotalEdgeNodes):
                if graph[u][v] != float('inf') and mstSet[v] == False and key[v] > graph[u][v]:
                    key[v] = graph[u][v]
                    parent[v] = u
        res = 0
        print(parent)
        self.printMST(parent,graph)
        for i in range(1, numTotalEdgeNodes):
            if parent[i] == None:
                return -1
            res += graph[i][parent[i]]

        # print(parent[i], "-", i, "\t", graph[i][parent[i]])
        return res


if __name__ =='__main__':
	g = Graph()
	print(g.primMST())