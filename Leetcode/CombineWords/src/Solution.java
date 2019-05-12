/**
 * @author Avinash Vijayakumar
 * 2019-01-15
 */
public class Solution {
    public static void main(String[] args) {
        String[] words = {"Hey","today","is","a","beautiful","day!"};
        System.out.println(combine2(words));

    }

    // this is O(n square).
    private static String combine1(String[] words){
        String sentence ="";
        for(String i:words) {
            sentence = sentence+i+" ";
        }
        return sentence;
    }

    // this is more efficient.
    private static String combine2(String[] words){
        StringBuilder sb = new StringBuilder();
        for(String i:words){
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

}
