import operator
import itertools
def rearrange(elements):
   # Write your code here
   if not elements:
       return
   dictChar = []
   for items in elements:
       binary = bin(items)[2:]
       c = binary.count('1')
       dictChar.append(c)
   sorted_item = [x for y,x in sorted(zip(dictChar,elements))]
   return sorted_item