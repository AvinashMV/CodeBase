def maxDifference(a):
   small_odd = sys.maxsize
   max_diff= -1
   for j in a:
           diff = j - small_odd
           if diff > max_diff and diff != 0:
               max_diff = diff
           elif j < small_odd:
               small_odd = j

   return max_diff