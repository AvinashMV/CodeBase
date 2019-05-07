/**
 * @author Avinash Vijayakumar
 * 2019-01-24
 */
public class Solution {
    private int rowlen,collen;

    public static void main(String[] args) {
        int[][] matrix = {{1},
                            {3}
        };
        Solution solution = new Solution();
        solution.searchMatrix(matrix,3);

    }

    private int findRow(int[][]matrix, int target){
        if(matrix.length==0)
            return -1;
        int  row=0,col=0;
        rowlen = matrix[0].length-1;
        collen = matrix.length-1;
        int l = 0,h = collen;
        while(l<=h){
            int mid = (l+h)/2;
            if(l>h){
                return -1;
            }
            if(target>=matrix[mid][0] && target<=matrix[mid][rowlen])
                return mid;

            if(target<matrix[mid][0]){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }

    private boolean binSearchRow (int[][] matrix,int row,int target){
        int l=0,h=rowlen;
        while(l<=h){
            int mid = (l+h)/2;
            if(l>h)
                return false;
            if(matrix[row][mid]==target)
                return true;
            if(target<matrix[row][mid])
                h = mid-1;
            else
                l = mid+1;
        }
        return false;

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow = findRow(matrix,target);
        System.out.println(targetRow);
        if(targetRow==-1)
            return false;
        boolean res = binSearchRow(matrix,targetRow,target);
        System.out.println(res);
        return false;
    }
}


/* Test cases

 int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
 */