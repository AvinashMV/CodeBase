def solution(N, S):
    reserve= S.split(" ")
    fam_count = 0
    for row in xrange(1, N+1):
        if any((str(row)+str(seat)) in reserve for seat in ['A','B','C']):
            print "found"
        else:
            fam_count +=1

        if any((str(row)+str(seat)) in reserve for seat in ['E','F']):
            print "found"
        else:
            if ((str(row)+str('D')) in reserve) and ((str(row)+str('G')) in reserve):
                print "found"
            else:
                fam_count +=1
        if any((str(row)+str(seat)) in reserve for seat in ['H','J','K']):
            print "found"
        else:
            fam_count +=1
    return fam_count


if __name__ == '__main__':
    a=solution(2, '1A 2F 1C')
    print a