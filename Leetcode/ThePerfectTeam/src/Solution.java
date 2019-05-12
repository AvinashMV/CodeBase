import java.util.Collections;
import java.util.HashMap;

/**
 * @author Avinash Vijayakumar
 * 2019-01-26
 */
public class Solution {
    private static HashMap<Character,Integer> myMap = new HashMap<>();

    public static void main(String[] args) {
        String skills = "pcmpp";
        System.out.println(differentTeams(skills));
    }

    private static void setUpMap(){
        String s ="pcmbz";
        for(char ch:s.toCharArray()){
            myMap.put(ch,0);
        }
    }
    static int differentTeams(String skills) {
        setUpMap();
        for(char ch:skills.toCharArray()){
            myMap.put(ch,myMap.get(ch)+1);
        }
        return Collections.min(myMap.values());

    }
}
