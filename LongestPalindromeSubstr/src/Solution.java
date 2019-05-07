/**
 * @author Avinash Vijayakumar
 * 2019-02-27
 */
public class Solution {
    private  int maxlen = 0 ,lo = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubstr("abba"));
    }

    public String longestPalindromeSubstr(String s ){

        for(int mid=1;mid<s.length();mid++){

            // count odd palindromes.
            int low = mid-1, high = mid+1;
            Util(s,low,high);

            // count even palindromes.
            low = mid-1;
            high = mid;
            Util(s,low,high);
        }
        return s.substring(lo,lo+maxlen);
    }

    private void Util(String s,int low,int high){
        while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
            low--;
            high++;
        }
        // maxSoFar = Math.max(count,maxSoFar);
        if(high-low-1>maxlen){
            maxlen = high-low-1;
            lo = low+1;
        }
    }
}

/* Test cases

forgeeksskeegfor
abba
 */