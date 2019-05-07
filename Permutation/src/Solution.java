/**
 * @author Avinash Vijayakumar
 * 2019-01-15
 */
public class Solution {
    public static void main(String[] args) {
        String a="avi", b="iav";
        System.out.println(checkPermutation(a,b));
    }

    private static boolean checkPermutation(String a, String b){
        if(a.length()!=b.length())
            return false;

        int[] arr3 = new int[26];

        for(int i=0;i<a.length();i++){
            arr3[a.charAt(i)-'a']++;
            arr3[b.charAt(i)-'a']--;
        }

        for(int i:arr3) {
            if (i > 0) {
                return false;
            }
        }

        return true;
    }
}
