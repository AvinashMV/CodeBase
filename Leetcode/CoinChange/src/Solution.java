import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-02-23
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1,2,3};
        int totalAmount = 4;
        int res = solution.numOfWays(coins,totalAmount);
        System.out.println(res);
    }

    public int numOfWays(int[] coins,int totalAmount){
        // Arrays.sort(coins);
        int rowlen = coins.length+1, collen = totalAmount+1;
        int[][] arr = new int[rowlen][collen];

        // initial set up.
        for(int row=0;row<rowlen;row++){
            arr[row][0] = 1;
        }

        // start the computation.
        for(int row=1;row<rowlen;row++){
            for(int col=1;col<collen;col++){
                if(coins[row-1]>col)
                    arr[row][col] = arr[row-1][col];
                else
                    arr[row][col] = arr[row-1][col]+arr[row][col-coins[row-1]];
            }
        }

        return arr[rowlen-1][collen-1];
    }
}

/*
test cases:

int[] coins = {1,2,5};
int totalAmount = 5;
ans = 5

int[] coins = {2,5,3,6};
int totalAmount = 10;
ans = 5


int[] coins = {1,2,3};
int totalAmount = 4;
ans = 4.
 */