/**
 * @author Avinash Vijayakumar
 * 2019-01-15
 */
public class Solution {
    public static void main(String[] args) {
        String s ="quickbrownfxjmps";
        System.out.println(is_unique(s));
    }

    private static boolean is_unique(String s){
        int[] arr2 = new int[26];
        for(int i=0;i<s.length();i++)
            arr2[s.charAt(i)-'a']++;

        for(int i:arr2)
            if(i>1)
                return false;

        return true;
    }
}
