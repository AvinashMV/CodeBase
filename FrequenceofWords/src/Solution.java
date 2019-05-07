import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Avinash Vijayakumar
 * 2019-03-08
 *
 * Given a large sentence give the frequence of each word.
 */

public class Solution {
    private HashMap<String,Integer> occurence = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "the quick brown                        fox jumps fox fox over the lazy dog brown";
        solution.buildOccurence(s);
    }

    public void buildOccurence(String s){
        // sanitise the input.
        s = s.replaceAll("\\s{2,}"," ");
        String[] words = s.split(" ");
        Arrays.stream(words)
                .forEach(word->{
                    occurence.compute(word,(key,val)->val==null?1:val+1);
                });

        System.out.println(occurence);
    }
}
