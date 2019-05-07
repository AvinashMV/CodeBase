/**
 * @author Avinash Vijayakumar
 * 2019-01-15
 */
public class Solution {
    public static void main(String[] args) {
        String s="aabcccccaaa";
        System.out.println(CheckCompression(s));
    }

    private static String compress(String s){
        char cur = '$';
        int count= 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(cur==s.charAt(i)){
                count++;
            }else{
                if(cur!='$'){
                    sb.append(cur);
                    sb.append(count);
                }
                cur = s.charAt(i);
                count = 1;
            }
        }
        // last character count.
        sb.append(cur);
        sb.append(count);
        return sb.toString();
    }

    private static String CheckCompression(String s){
        String compressed  = compress(s);
        // System.out.println(compressed);
        if(compressed.length()==s.length())
            return s;
        return compressed;
    }
}
