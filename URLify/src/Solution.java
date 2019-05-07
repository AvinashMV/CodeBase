/**
 * @author Avinash Vijayakumar
 * 2019-01-15
 */
public class Solution {
    public static void main(String[] args) {
        String s="Mr John Smith    ";
        System.out.println(URLify(s,13));

    }

    private static String URLify(String s,int trueLen){
        char[] arrch = s.toCharArray();
        for(int i=trueLen-1,j=s.length()-1;i>=0;i--){
            char cur = s.charAt(i);
            if(j>=0){
                if(cur == ' '){
                    arrch[j--] = '0';
                    arrch[j--] = '2';
                    arrch[j--] = '%';
                }else{
                    arrch[j--]= cur;
                }
            }

        }

        return new String(arrch);
    }
}
