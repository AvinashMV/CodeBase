import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2019-04-03
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // String s = "leetcode";
        String s = "loveleetcode";
        System.out.println(solution.firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        if(s.length()==0)
            return -1;

        // populate the occurence map.
        Map<Character, Integer> occurence = new LinkedHashMap<>();
        for(char ch:s.toCharArray()){
            occurence.compute(ch,(key,val)-> val==null?1:val+1);
        }

        // now iterate the map and return the first key whose val is 1.
        char resultChar = '$';
        for(Map.Entry<Character,Integer> entry:occurence.entrySet()){
            if(entry.getValue()==1){
                resultChar = entry.getKey();
                break;
            }
        }

        return resultChar=='$'?-1:s.indexOf(resultChar);
    }
}
