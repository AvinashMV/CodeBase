/**
 * @author Avinash Vijayakumar
 * 2019-02-22
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] wt = {10,20,30};
        int[] val = {60,100,120};
        int maxCapcity = 50;
        System.out.println(solution.knapsack01(wt,val,maxCapcity));
    }

    public int knapsack01(int[] wt,int[] val,int maxCapacity){

        int rowlen = val.length+1,collen = maxCapacity+1;
        int[][] arr = new int [rowlen][collen];
        for(int row=1;row<rowlen;row++){
            for(int col=1;col<collen;col++){
                if(wt[row-1]<=col){
                    arr[row][col] = Math.max(arr[row-1][col], val[row-1]+arr[row-1][col-wt[row-1]]);
                }else{
                    // get value from the top. Do not include the current wt.
                    arr[row][col] = arr[row-1][col];
                }
            }
        }
        return arr[rowlen-1][collen-1];
    }
}

/*
Test cases:
int[] wt = {1,3,4,5};
int[] val = {1,4,5,7};
int maxCapcity = 7;



 */