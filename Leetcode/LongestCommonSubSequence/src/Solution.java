/**
 * @author Avinash Vijayakumar
 * 2019-01-03
 */
public class Solution {
    public static void main(String[] args) {
        int res = lcs("MAC", "MCB");
        System.out.println(res);
    }

    private static int lcs(String s1, String s2){
        s1="$"+s1;
        s2="$"+s2;
        int len = Math.max(s1.length(),s2.length());

        int arr[][] = new int[len][len];

        for(int row = 1;row<len;row++){
            for(int col=1;col<len;col++){
                if(s2.charAt(row)==s1.charAt(col)){
                    arr[row][col] = arr[row-1][col-1]+1;
                }else{
                    arr[row][col] = Math.max(arr[row-1][col], arr[row][col-1]);
                }
            }
        }
        return arr[len-1][len-1];
    }
}

/*
TEST CASES
int res = lcs("HARRY", "SALLY") , 2
int res = lcs("ABCD", "ABDC") ,3
int res = lcs("AA", "BB") , 0
int res = lcs("SHINCHAN", "NOHARAAA"), 3
int res = lcs("ABCDEF", "FBDAMN"), 2

 */