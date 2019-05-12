/**
 * @author Avinash Vijayakumar
 * 2019-02-27
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "wowpurerocks";
        System.out.println(solution.allPalindromes(s));
    }

    public int allPalindromes(String s){
        int result = s.length();

        for(int mid=1;mid<s.length();mid++){
            // count odd palindromes.
            int low = mid-1, high = mid+1;
            result +=allPalindromeUtil(s,low,high);

            // count even palindromes.
            low = mid-1;
            high = mid;
            result += allPalindromeUtil(s,low,high);
        }
        return result;
    }

    private int allPalindromeUtil(String s,int low,int high){
        int count = 0;
        while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
            low--;
            high++;
            count++;
        }
        return count;
    }
}

/*
Test cases :
String s = "hellolle"; ans =13
String s = "wowpurerocks"; ans = 14
String s = "abc"; ans = 3

 */