import java.util.ArrayList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2018-12-29
 */
// Longest Common Substring with non repeating characters.

public class Solution {
    public static void main(String[] args) {
        //String s = "GEEKSFORGEEKS";
        String s = "ABDEFGABEF";
        System.out.println(lcs(s));
    }

    public static int lcs(String s){
        int maxSoFar=0, curMax = 0;
        List<Character> visited = new ArrayList<>();

        char curCh;
        for(int i=0;i<s.length();i++){
            curCh = s.charAt(i);
            if(!visited.contains(curCh)){
                visited.add(curCh);
                curMax++;
                maxSoFar = Math.max(maxSoFar,curMax);

            }else{
                visited.clear();
                curMax = 0;
            }
        }
        return maxSoFar;
    }
}
