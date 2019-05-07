import java.util.HashSet;
import java.util.Set;

/**
 * @author Avinash Vijayakumar
 * 2019-01-28
 */
public class Solution {
    public static void main(String[] args) {
        String s = "asjrgapa";
        Solution obj = new Solution();
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> mySet = new HashSet<>();
        int cur = 0, maxSoFar = 0;

        for(int i=0;i<s.length();i++){
            mySet.clear();
            for(int j=i;j<s.length();j++){
                if(mySet.contains(s.charAt(j))){
                    mySet.clear();
                    maxSoFar = Math.max(cur,maxSoFar);
                    cur =1;
                    mySet.add(s.charAt(j));

                }else{
                    mySet.add(s.charAt(j));
                    cur++;
                }
            }
        }
        maxSoFar = Math.max(cur,maxSoFar);
        return maxSoFar;
    }
}


/*
String s = "abcabcbb";
String s = "bbbbb";
String s = "pwwkew";
String s = "dvdf";


 */