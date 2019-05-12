import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2019-02-04
 */
/*
This is a google interview question. Given a keypad and a string, using TV remote print left, right, up and down
to navigate in virtual keypad to print given string.
 */

public class Solution {
    private static Map<Character, List<Integer>> indexMap = new HashMap<>();

    public static void main(String[] args) {
        char[][] keypad = {
                {'q','w','e','r','t','y'},
                {'a','s','d','f','g','h'},
                {'z','x','c','v','b','n'}
        };
        String s = "qbrx";

        printInstructions(keypad,s);
    }

    private static String getInstructions(List<Integer>initialPoint, List<Integer> TargetPoint){
        // first get the row diff.
        int rowdiff = TargetPoint.get(0) - initialPoint.get(0);
        int coldiff = TargetPoint.get(1) - initialPoint.get(1);

        String res = "";


        // get up or down.
        if(rowdiff>0){
            String s = "down";
            for(int t=0;t<rowdiff;t++)
                res += s+" ";
            rowdiff = 0;

        }else if(rowdiff<0){
            String s="up";
            for(int t=0;t<Math.abs(rowdiff);t++)
                res += s+" ";
            rowdiff = 0;

        }if(coldiff<0){
            String s="left";
            for(int t=0;t<Math.abs(coldiff);t++)
                res += s+" ";
            coldiff = 0;

        }else if(coldiff>0){
            String s="right";
            for(int t=0;t<coldiff;t++)
                res += s+" ";
            coldiff = 0;
        }
        res += "enter";
        return res;
    }

    public static void printInstructions(char[][] keypad, String s){
        // get the index of the required string.
        int collen = keypad.length;
        int rowlen = keypad[0].length;

        for(int row=0;row<collen;row++){
            for(int col=0;col<rowlen;col++){
                List<Integer> t = new ArrayList<>();
                t.add(row);
                t.add(col);
                indexMap.put(keypad[row][col],t);
            }
        }
        // System.out.println(indexMap);

        // get the instructions in the form of a string starting from (0,0).
        // step by step.

        List<String> instructions = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(i==0){
                List<Integer> t = new ArrayList<>();
                t.add(0);
                t.add(0);
                instructions.add(
                        getInstructions(t,indexMap.get(s.charAt(i)))
                );
            }else{
                instructions.add(
                        getInstructions(indexMap.get(s.charAt(i-1)),indexMap.get(s.charAt(i)))
                );
            }

        }

        System.out.println(instructions);
    }
}
