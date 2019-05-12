/**
 * @author Avinash Vijayakumar
 * 2019-05-12
 */
public class Solution {
    public static void main(String[] args) {
        String word  = "A";
        System.out.println(lastLetters(word));
    }

    public static String lastLetters(String word){
        if(word.length()<1)
            return "";

        StringBuilder sb = new StringBuilder();
        if(word.length()>=2){
            sb.append(word.charAt(word.length()-1));
            sb.append(" ");
            sb.append(word.charAt(word.length()-2));
        }else{
            sb.append(word.charAt(word.length()-1));
        }

        return sb.toString();
    }
}
