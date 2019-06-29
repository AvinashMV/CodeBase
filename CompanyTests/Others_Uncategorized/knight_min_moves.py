# def recFunc(startX, startY, endX, endY):
#     if startX == endX and startY == endY:
#         return board[0][0]
#     else:
#         if board[abs(startX - endX)][abs(startY - endY)] != 0:
#             return board[abs(startX - endX)][abs(startY - endY)]
#         else:
#             x1, y1, x2, y2 = 0, 0, 0, 0
#             if (startX <= endX):
#                 if startY <= endY:
#                     x1 = startX + 2
#                     y1 = startY + 1
#                     x2 = startX + 1
#                     y2 = startY + 2
#                 else:
#                     x1 = startX + 2
#                     y1 = startY - 1
#                     x2 = startX + 1
#                     y2 = startY - 2
#             else:
#                 if startY <= endY:
#                     x1 = startX - 2
#                     y1 = startY + 1
#                     x2 = startX - 1
#                     y2 = startY + 2
#                 else:
#                     x1 = startX - 2
#                     y1 = startY - 1
#                     x2 = startX - 1
#                     y2 = startY - 2
#             board[abs(startX - endX)][abs(startY - endY)] = min(recFunc(x1, y1, endX, endY),
#                                                                 recFunc(x2, y2, endX, endY)) + 1
#
#             board[abs(startY - endY)][abs(startX - endX)] = board[abs(startX - endX)][abs(startY - endY)]
#             return board[abs(startX - endX)][abs(startY - endY)]
#
#
# board = [[0 for _ in range(n)] for _ in range(n)]
# res = 0
# if ((startX == 1 and startY == 1 and endX == 2 and endY == 2) or (
#         startX == 2 and startY == 2 and endX == 1 and endY == 1)):
#     res = 4
# elif ((startX == 1 and startY == n and endX == 2 and endY == n - 1) or (
#         startX == 2 and startY == n - 1 and endX == 1 and endY == n)):
#     res = 4
# elif ((startX == n and startY == 1 and endX == n - 1 and endY == 2) or (
#         startX == n - 1 and startY == n - 1 and endX == n and endY == n)):
#     res = 4
# else:
#     board[1][0] = 3
#     board[0][1] = 3
#     board[1][1] = 2
#     board[2][0] = 2
#     board[0][2] = 2
#     board[2][1] = 1
#     board[1][2] = 1
#     res = recFunc(startX, startY, endX, endY)
# return res
#
#
#
# SELECT ID, "ROOT"
# FROM TREE
# WHERE P_ID IS NULL
# UNION
# SELECT DISTINCT T1.ID, "INNER"
# FROM TREE T1
# JOIN TREE T2
#   ON T2.P_ID = T1.ID
# WHERE T1.P_ID IS NOT NULL
# UNION
# SELECT N1.Id, "LEAF"
# FROM TREE T1
# LEFT JOIN TREE T2
#   ON T1.ID = T2.P_ID
# WHERE T2.P_ID IS NULL;

def consecutive(num):
    i = 1
    j = 2
    upto = int(num/2)+1
    numSum = i
    count = 0

    while i<upto or j<= upto:
        if numSum < num:
            numSum += j
            j+=1
        else:
            if numSum == num:
                count += 1
            i+=1
            j=i+1
            numSum = i
    return count


print consecutive(15)