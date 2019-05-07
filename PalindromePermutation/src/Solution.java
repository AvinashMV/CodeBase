import java.util.HashMap;

/**
 * @author Avinash Vijayakumar
 * 2019-01-15
 */
public class Solution {
    public static void main(String[] args) {
        String s="tact coa";
        System.out.println(checkPP(s));
    }

    private static boolean checkPP(String s){
        if(s.length()<2)
            return true;

        // remove spaces.
        s = s.replaceAll("\\s+", "");

        // construct the occurrence map.
        HashMap<Character,Integer> occurrenceMap = new HashMap<>();
        for(int i =0;i<s.length();i++){
            if(occurrenceMap.containsKey(s.charAt(i))){
                occurrenceMap.put(s.charAt(i),occurrenceMap.get(s.charAt(i))+1);
            }else{
                occurrenceMap.put(s.charAt(i),1);
            }
        }

        // all characters are same.
        if(occurrenceMap.size()<2)
            return true;

        int frequenceOne = 0;
        for(char ch: occurrenceMap.keySet()){
            if(occurrenceMap.get(ch)==1) {
                frequenceOne++;
            }
            else{
                int chcount = occurrenceMap.get(ch) %2;
                if(chcount!=0)
                    return false;
            }
        }

        return frequenceOne <= 1;
    }
}
