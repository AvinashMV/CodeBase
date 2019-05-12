import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Avinash Vijayakumar
 * 2019-01-01
 */
public class Solution {
    public static void main(String[] args) {
        String s="aaaa";
        System.out.println(substrCount(s.length(),s));
    }

    static boolean checkSubString(String s){
        if(s.length()==1)
            return true;

        if(s.length()%2==0){
            //even length
            int i=0,j=s.length()-1;
            while(i!=j){
                if(s.charAt(i)!=s.charAt(j))
                    return false;
                j--;
            }

        }else{
            // odd length
            int i=0, j=s.length()-1;
            char firstchar = s.charAt(0);
            while(i!=j){
                if(s.charAt(i)!=firstchar || s.charAt(j)!=firstchar)
                    return false;
                i++;
                j--;
            }
        }

        return true;
    }

    static long substrCount(int n, String s) {
        List<String> substrings = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                substrings.add(s.substring(i,j+1));
            }
        }
        System.out.println(substrings);

        long count =0;
        for(String i:substrings){
            if(checkSubString(i)) {
                // System.out.println(i);
                count++;
            }
        }
        return count;
    }
}

/*
Test Cases
"asasd" ans 4
"abcbaba" ans 10
"aaaa", 10
"mnonopoo",  ans = 12.
 */