def possibleBipartition(self, N, dislikes):
        """
        :type N: int
        :type dislikes: List[List[int]]
        :rtype: bool
        """
        group1 = []
        group2 = []
        disLikeDict = {}
        
        for pair in dislikes:
            disLikeDict.setdefault(pair[0], []).append(pair[1])
            disLikeDict.setdefault(pair[1], []).append(pair[0])
        print disLikeDict    
        for key,value in disLikeDict.items():
            if key in group2:
                for val in value:
                    group1.append(val)
            elif key in group1:
                for val in value:
                    group2.append(val)
            else:
                group1.append(key)
                for val in value:
                    group2.append(val)
                
        a = set(group1)
        b = set(group2)
        print a
        print b
        return not(bool(a & b))

#Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
#Output: true
#Explanation: group1 [1,4], group2 [2,3]

