/**
 * @author Avinash Vijayakumar
 * 2019-05-21
 */
public class Solution {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        int levels = (int) Math.floor(matrix.length/2);
        int alen = matrix.length-1;

        for(int row=0;row<levels;row++,alen--){
            for(int col=row;col<alen;col++){
                swap(matrix,row,col,col,alen);
                swap(matrix,row,col,alen,alen-col+row);
                swap(matrix,row,col,alen-col+row,row);
            }
        }
    }

    private void swap(int[][] matrix,int row1,int col1,int row2,int col2){
        int temp = matrix[row2][col2];
        matrix[row2][col2] = matrix[row1][col1];
        matrix[row1][col1] = temp;
    }
}
