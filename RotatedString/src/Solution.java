import java.util.stream.IntStream;

/**
 * @author Avinash Vijayakumar
 * 2019-03-18
 *
 * Given string s1 and s2 determine if s2 is rotated string of s1 or not.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1="waterbottle", s2="erbottlewat";
        System.out.println(solution.isRotated(s1,s2));
    }

    public boolean isRotated(String s1, String s2){
        String cur = s1;
        for(int i=0;i<s1.length();i++){
            String left = s1.substring(0,i+1);
            String right = "";
            if(i+1<s1.length())
                right = s1.substring(i+1,s1.length());
            if((left+right).equals(s2) || (right+left).equals(s2))
                return true;
        }
        return false;
    }
}
