import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2019-04-16
 */
public class Solution {
    public static void main(String[] args) {
        String s ="abccccdd";
        // String s ="bananas";
        Solution solution = new Solution();
        int res = solution.longestPalindrome(s);
        System.out.println(res);
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(char ch:s.toCharArray()){
            frequencyMap.compute(ch,(key,val)->val==null?1:val+1);
        }

        int totalLen = 0;
        boolean oddPresent = false;

        for(int i:frequencyMap.values()){
            if(i%2==0)
                totalLen+= i;
            else{
                oddPresent = true;
                totalLen += i-1;
            }
        }

        if(oddPresent) totalLen++;

        return totalLen;
    }
}
