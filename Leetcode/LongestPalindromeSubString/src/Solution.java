/**
 * @author Avinash Vijayakumar
 * 2019-05-21
 */
public class Solution {
    int glen = 1, startingPos = 0;

    public static void main(String[] args) {
        String s="babad";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(s));
    }
    public String longestPalindrome(String s) {

        for(int mid=1;mid<s.length();mid++){
            // considering s and odd palindrome
            int low = mid-1, high = mid+1;
            expand(s,low,high);

            low = mid-1;
            high = mid;
            expand(s,low,high);
        }
        System.out.println(glen);
        return s.substring(startingPos,startingPos+glen);

    }

    private void expand(String s, int low,int high){

        while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
            low--;
            high++;
        }


        int curlen = high-low-1;
        if(curlen>glen){
            startingPos = low+1;
            glen = curlen;
        }


    }
}
