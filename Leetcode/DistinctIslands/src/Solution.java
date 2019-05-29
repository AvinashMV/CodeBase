import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Avinash Vijayakumar
 * 2019-05-21
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int numDistinctIslands(int[][] grid) {
        Set<String> result = new HashSet<>();
        int rowlen = grid.length,collen = grid[0].length;

        for(int row=0;row<rowlen;row++){
            for(int col=0;col<collen;col++){
                if(grid[row][col]==1){
                    Set<String> curSet = new LinkedHashSet<>();
                    floodfill(grid,row,col,row,col,curSet);
                    result.add(curSet.toString()); // convert all to a string.
                }
            }
        }
        return result.size();
    }

    private void floodfill(int[][] grid,int row,int col,int basex,int basey,Set<String> curset){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0){
            return;
        }

        String s = (row-basex)+"_"+(col-basey);
        curset.add(s);

        grid[row][col]=0;
        floodfill(grid,row+1,col,basex,basey,curset);
        floodfill(grid,row-1,col,basex,basey,curset);
        floodfill(grid,row,col-1,basex,basey,curset);
        floodfill(grid,row,col+1,basex,basey,curset);
    }
}
