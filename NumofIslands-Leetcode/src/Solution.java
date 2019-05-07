/**
 * @author Avinash Vijayakumar
 * 2019-04-21
 */
public class Solution {
    public static void main(String[] args) {
        char[][] grid ={
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}

        };


        Solution solution = new Solution();
        int res = solution.numIslands(grid);
        System.out.println(res);
    }

    public int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;

        int rowlen = grid.length;
        int collen = grid[0].length;

        int count = 0;

        for(int row=0;row<rowlen;row++){
            for(int col=0;col<collen;col++){
                if(grid[row][col]=='1'){
                    dfsFill(grid,row,col);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsFill(char[][]grid,int row,int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0') {
            return;
        }

        grid[row][col]='0';

        dfsFill(grid,row+1,col);
        dfsFill(grid,row-1,col);
        dfsFill(grid,row,col-1);
        dfsFill(grid,row,col+1);


    }
}


/*
char[][] grid ={
{'1','1','1','1','0'},
{'1','1','0','1','0'},
{'1','1','0','0','0'},
{'0','0','0','0','0'}

};



char[][] grid ={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}

        };


 */