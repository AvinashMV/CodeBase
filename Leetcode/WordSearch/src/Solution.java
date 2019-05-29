import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-05-21
 */
public class Solution {
    boolean [][] visited;

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";

        Solution solution = new Solution();
        System.out.println(solution.exist(board,word));
    }

    public boolean exist(char[][] board, String word) {
        visited = new boolean [board.length][board[0].length];

        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                    if(board[row][col]==word.charAt(0) && floodfillSearch(board,row,col,0,word))
                        return true;
            }
        }
        return false;
    }

    private boolean floodfillSearch(char[][]board,int row,int col,int curchar,String word){
        if(curchar==word.length())
            return true;

        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!=word.charAt(curchar)||visited[row][col]==true){
            return false;
        }

        // valid point, mark visited is true.
        visited[row][col] = true;

        if( floodfillSearch(board,row+1,col,curchar+1,word)||
        floodfillSearch(board,row-1,col,curchar+1,word)||
        floodfillSearch(board,row,col-1,curchar+1,word)||
        floodfillSearch(board,row,col+1,curchar+1,word) ){
            return true;
        }

        // reset.
        visited[row][col]= false;
        return false;
    }
}


/*
 char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
 */