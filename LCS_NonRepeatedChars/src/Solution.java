import java.util.HashSet;

/**
 * @author Avinash Vijayakumar
 * 2019-03-18
 *
 * LCS - longest common substring with non-repeated chars.
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "geeksforgeeks";
        solution.lcs(s);

    }

    public void lcs(String s){
        HashSet<Character> visitedArr = new HashSet<>();
        int count = 0,lo = 0, maxSoFar = 0;
        int index = 0;
        for(char i:s.toCharArray()){
            if(!visitedArr.contains(i)){
                visitedArr.add(i);
                count++;
                if(count>maxSoFar){
                    lo = index - count +1;
                    maxSoFar = count;
                }
                maxSoFar = Math.max(count,maxSoFar);
            }else{
                visitedArr.clear();
                visitedArr.add(i);
                count = 1;
            }
            // maintaining index.
            index++;
        }

        System.out.println(maxSoFar);
        System.out.println(s.substring(lo,lo+maxSoFar));
    }

}
