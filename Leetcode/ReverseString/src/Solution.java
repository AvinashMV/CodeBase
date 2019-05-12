/**
 * @author Avinash Vijayakumar
 * 2019-04-24
 */
public class Solution {
    public static void main(String[] args) {
        String s ="Leetcode";
        Solution solution = new Solution();
        System.out.println(solution.reverse2(s));
    }

    public String reverse(String s){
        char[] sArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=sArray.length-1;i>=0;i--){
            sb.append(sArray[i]);
        }
        return sb.toString();
    }

    public String reverse2(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString();
    }
}
