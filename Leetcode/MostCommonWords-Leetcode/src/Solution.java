import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2019-03-27
 *
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 */


public class Solution {
    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};

        Solution solution = new Solution();
        solution.mostCommonWord(paragraph,banned);
    }

    public String mostCommonWord(String paragraph, String[] banned) {

        // remove all the banned words from the paragraph.
       for(String str:banned){
           paragraph = paragraph.replaceAll(str,"");
       }

       // remove ?.,;! and replace it with single space
       paragraph = paragraph.replaceAll("[\\?\\.,'!;]"," ");
       paragraph = paragraph.replaceAll("\\s{2,}"," "); // remove multiple space.
       paragraph = paragraph.trim(); // remove beginning and trailing space
       System.out.println(paragraph);

        // build occurrence map.
        HashMap<String,Integer> occurence = new HashMap<>();
        String[] words = paragraph.split(" ");
        for(String word:words){
            word = word.toLowerCase();
            occurence.compute(word,(key,val)->val==null?1:val+1);
        }
        System.out.println(occurence);

        // Track and find out the key which has max value.
        int maxSoFar = 0;
        String requiredStr = "";
        for(Map.Entry<String,Integer> entry:occurence.entrySet()){
            if(entry.getValue()>maxSoFar){
                maxSoFar = entry.getValue();
                requiredStr = entry.getKey();
            }
        }

        System.out.println(requiredStr);
        return "null";
    }
}

/*
Test cases:
String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
String[] banned = {"hit"};

"a, a, a, a, b,b,b,c, c"
["a"]
 */