import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-01-05
 */
public class Solution {
    private static Map<Character,Integer> myMap = new HashMap<>();
    private static Map<Character,Integer> targetMap = new HashMap<>();

    public static void main(String[] args) {
        String s="abcdefgabcdefg";
        System.out.println(reverseShuffleMerge(s));

    }
    private static void OccurenceMap(String s){
        for(int i=0;i<s.length();i++){
            if(myMap.get(s.charAt(i))==null)
                myMap.put(s.charAt(i),1);
            else
                myMap.put(s.charAt(i),myMap.get(s.charAt(i))+1);
        }
    }

    private static void TargetMap(){
        for(Character i:myMap.keySet()){
            targetMap.put(i,myMap.get(i)/2);
        }
    }

    static String reverseShuffleMerge(String s) {
        OccurenceMap(s);
        TargetMap();

        List<Character> uniqueString = new ArrayList<>();
        int targetLength = s.length()/2;

        for(int i=0;i<s.length();i++){
            if(uniqueString.size()>=targetLength)
                break;

            char cur = s.charAt(i);
            if(targetMap.get(cur)>0){
                uniqueString.add(cur);
                targetMap.put(cur,targetMap.get(cur)-1);
            }
        }

        Collections.sort(uniqueString);
        String res = "";
        for(Character ch:uniqueString)
            res +=ch;

        return res;

    }
}

/*
Test cases

String s="abba"; ans ab
String s="eggegg"; ans egg
 */