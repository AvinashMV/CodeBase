import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Avinash Vijayakumar
 * 2019-02-05
 */
public class Solution {
    private static boolean reached;

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,0,0},
                {0,-1,-1,0},
                {0,0,0,0}
        };
        Solution obj = new Solution();
        System.out.println(obj.getPath(matrix));
    }

    List<Point> getPath(int[][] maze){
        if(maze==null || maze.length==0)
            return null;
        List<Point> path = new ArrayList<>();

        if(getPath(maze,maze.length-1,maze[0].length-1,path)){
            return path;
        }
        return null;
    }

    boolean getPath(int[][]maze,int row,int col,List<Point> path){
        if(col<0 || row<0 || maze[row][col]==-1){
            return false;
        }

        boolean atOrigin = (row==0)&& (col==0);

        if(atOrigin || getPath(maze,row-1,col,path)|| getPath(maze,row,col-1,path)){
            Point p = new Point(row,col);
            path.add(p);
            return true;
        }
        return false;
    }

}
