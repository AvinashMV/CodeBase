import java.util.ArrayList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-01-08
 */
public class Solution {
    private static int lo, maxlen;

    public Solution(){
        lo=0;
        maxlen=0;
    }

    public static void main(String[] args) {
        String s="faaabbaag";
        System.out.println(longestsubstr(s));

    }

    private static String longestsubstr(String s){
       for(int i=0;i<s.length()-1;i++){
            extendPalindrome(s,i,i); //odd length
            extendPalindrome(s,i,i+1); // even length
       }

       return s.substring(lo, lo+maxlen);

    }

    private static void extendPalindrome(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        if(maxlen < right-left-1){
            lo = left+1;
            maxlen = right-left-1;
        }
    }
}