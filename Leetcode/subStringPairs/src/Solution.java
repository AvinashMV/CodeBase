import java.util.ArrayList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-02-12
 */
public class Solution {
    private List<String> substrings = new ArrayList<>();

    public static void main(String[] args) {
        String s= "doqzcmbcpzrzepz";
        int k =6;
        Solution obj = new Solution();
        obj.substringPairs(s,k);
    }

    boolean checkEqual(String a,String b,int k){
        if(a.length()!=b.length())
            return false;

        for(int i=0;i<a.length();i++){
            if(i!=k){
                if(a.charAt(i)!=b.charAt(i))
                    return false;
            }else{
                if(a.charAt(i)==b.charAt(i))
                    return false;
            }
        }
        return true;
    }

    int substringPairs(String s, int k) {
        if(s.length()<k)
            return 0;

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String t = s.substring(i,j+1);
                if(t.length()>k)
                    substrings.add(t);
            }
        }

       //  System.out.println(substrings);

        int count = 0;
        for(String i:substrings){
            for(String j:substrings){
                if(checkEqual(i,j,k)) {
                    System.out.println(i+" "+j);
                    count++;
                }
            }
        }

        System.out.println(count);
        return -1;
    }

}
