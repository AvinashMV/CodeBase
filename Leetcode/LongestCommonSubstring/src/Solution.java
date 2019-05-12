/**
 * @author Avinash Vijayakumar
 * 2019-01-04
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(lcs("ABABC","BABCA"));
    }

    public static int lcs(String s1, String s2){
        s1 = "$"+s1;
        s2 = "$"+s2;
        int rowlen = s2.length(), collen = s1.length();
        int[][] arr = new int[rowlen][collen];

        for(int row=1;row<rowlen;row++){
            for(int col=1;col<collen;col++){
                if(s2.charAt(row)==s1.charAt(col)){
                    arr[row][col] = (arr[row-1][col-1])+1;
                }else{
                    arr[row][col]=0;
                }
            }
        }

        //get the largest value.
        int maxSoFar = 0;
        for(int row=0;row<rowlen;row++){
            for(int col=0;col<collen;col++){
                maxSoFar = Math.max(arr[row][col],maxSoFar);
            }
        }

        return maxSoFar;
    }
}
