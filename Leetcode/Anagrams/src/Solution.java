/**
 * @author Avinash Vijayakumar
 * 2019-01-09
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(anagram("listen","siletb"));

    }
    private static boolean anagram(String s1, String s2){
        int[] arr = new int[26];
        if(s1.length()!=s2.length())
            return false;

        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]==1)
                return false;
        }

        return true;
    }
}
