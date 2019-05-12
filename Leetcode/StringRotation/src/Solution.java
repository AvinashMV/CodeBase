/**
 * @author Avinash Vijayakumar
 * 2019-01-15
 */
/*
Check if s2 is rotation of s1 or not.
s1 is original string.
 */

public class Solution {
    public static void main(String[] args) {
        String s1="waterbottle" , s2="ottlewaterb";
        System.out.println(checkRot(s1,s2));
    }

    private static boolean checkRot(String s1, String s2){
        if(s1.equals(s2))
            return true;
        if(s1.length()!=s2.length())
            return false;

        String left, right;

        for(int i=0;i<s1.length();i++){
            left=" ";right= " ";
            left = s1.substring(0,i+1);
            if(i+1<s1.length())
                right = s1.substring(i+1,s1.length());

            if((right+left).equals(s2))
                return true;

            // System.out.println(left+" "+right);
        }

        return false;
    }
}
