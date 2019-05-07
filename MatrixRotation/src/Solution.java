/**
 * @author Avinash Vijayakumar
 * 2019-01-16
 */
public class Solution {
    public static void main(String[] args) {
        // always a sqaure matrix.
        // n*n matrix.
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        display(matrix,4);
        rot90clock(matrix,4);
        System.out.println("\nAfter 90 deg clock wise rotation in-place \n");
       display(matrix,4);


    }

    private static void display(int[][] arr,int len){
        for(int row=0;row<len;row++){
            for(int col=0;col<len;col++){
                System.out.print(arr[row][col]+"\t");
            }
            System.out.println();
        }
    }

    private static void swap(int[][] arr,int r1,int c1,int r2,int c2){
        int t  = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = t;
    }

    private static void rot90clock(int[][] arr,int len){
        int NumOfLevels = (int) Math.floor(len/2);
        int alen = len-1;
        for(int row = 0;row<NumOfLevels;row++,alen--){
            for(int col=row;col<alen;col++){
                swap(arr,row,col,col,alen);
                swap(arr,row,col,alen,alen-col+row);
                swap(arr,row,col,alen-col+row,row);
            }

        }
    }
}





/* Test Cases

int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

*/



/*
 private static void rot90clock(int[][] arr,int len){
        int NumOfLevels = (int) Math.floor(len/2);
        int alen = len-1;
        for(int row = 0;row<NumOfLevels;row++,alen--){
            for(int col=row;col<alen;col++){
                swap(arr,row,col,col,alen);
                swap(arr,row,col,alen,alen-col+row);
                swap(arr,row,col,alen-col+row,row);
            }

        }
    }
 */