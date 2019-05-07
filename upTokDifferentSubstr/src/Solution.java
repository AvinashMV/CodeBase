import java.util.HashSet;
import java.util.Set;

/**
 * @author Avinash Vijayakumar
 * 2019-02-12
 */
public class Solution {
    public static void main(String[] args) {
        String s= "boooolpptttpptab";
        int k=2;
        Solution obj = new Solution();
        obj.upToKDifferences(s,k);
    }

    int upToKDifferences(String str, int k) {
        Set<Character> myset = new HashSet<>();
        int count = 0;
        for(char ch:str.toCharArray()){
           myset.add(ch);
           if(myset.size()>k){
               count++;
               myset.clear();
               myset.add(ch);
           }
        }
        count +=1;
        System.out.println(count);
        return -1;
    }

}
