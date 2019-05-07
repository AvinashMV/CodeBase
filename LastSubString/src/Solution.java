import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-02-16
 */
public class Solution {
    private static List<String> mylist = new ArrayList<>();

    public static void main(String[] args) {
        String str = "ba";
        System.out.println(compute(str));
    }

    private static void generateAllSubstrings(String s){
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String t = s.substring(i,j+1);
                mylist.add(t);
            }
        }
        System.out.println(mylist);
    }

    static String compute(String str){
        generateAllSubstrings(str);
        Collections.sort(mylist);
        return mylist.get(mylist.size()-1);
    }
}
