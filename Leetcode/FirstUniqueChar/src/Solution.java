/**
 * @author Avinash Vijayakumar
 * 2019-05-18
 */
public class Solution {
    public static void main(String[] args) {

    }
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}
