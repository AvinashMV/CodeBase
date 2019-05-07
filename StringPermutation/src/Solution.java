import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-01-14
 */
public class Solution {
    public static void main(String[] args) {
        String s= "abbc";
        String b = "cbabadcbbabbcbabaabccbabc";
        System.out.println(findPermutation(s,b));
    }

    private static List<List<Integer>> findPermutation(String a, String b){
        List<List<Integer>> result = new ArrayList<>();

        int[] refArray = new int[26];
        for(int i=0;i<a.length();i++){
            refArray[a.charAt(i)-'a']++;
        }


        int slidingWindow  = a.length();
        for(int i=0;i<b.length()-slidingWindow;i++){
            int[] t = new int[26];
            for(int j=i;j<i+slidingWindow;j++){
                t[b.charAt(j)-'a']++;
            }
            if(Arrays.equals(refArray,t)){
               List<Integer> positions = new ArrayList<>();
               positions.add(i);
               positions.add(i+slidingWindow-1);
               result.add(positions);
            }
        }

        return result;
    }


}
