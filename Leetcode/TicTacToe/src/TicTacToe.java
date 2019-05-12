/**
 * @author Avinash Vijayakumar
 * 2019-05-04
 */
public class TicTacToe {
    public static void main(String[] args) {
        TicTacToe obj = new TicTacToe(2);
        System.out.println(obj.move(0,1,1));
        System.out.println(obj.move(1,1,2));
        System.out.println(obj.move(1,0,1));
    }
    /** Initialize your data structure here. */
    int[][]arr;

    public TicTacToe(int n) {
        arr = new int[n][n];
    }


    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
       if(player==1){
           arr[row][col]=1;
       }else{
           arr[row][col]=2;
       }
       return check(player);
    }

    public int check(int player){

        boolean win = false;

        // check each row horizontally.
        for(int row=0;row<arr.length;row++){
            boolean curRow = true;
            for(int col=0;col<arr[0].length;col++){
                if(arr[row][col]!=player){
                    curRow = false;
                    break;
                }
            }
            if(curRow==true)
                return player;
        }

        // check vertically.
        for(int col=0;col<arr[0].length;col++){
            boolean curCol = true;
            for(int row=0;row<arr.length;row++){
                if(arr[row][col]!=player){
                    curCol= false;
                    break;
                }
            }
            if(curCol==true)
                return player;
        }

        // check diagonal
        int row=0,col=0;
        boolean curDiagonal = true;
        while(row<arr.length && col<arr[0].length){
            if(arr[row++][col++]!=player){
                curDiagonal = false;
                break;
            }
        }
        if(curDiagonal == true)
            return player;

        // check anti diagonal.
        row = 0;
        col = arr[0].length-1;
        curDiagonal = true;
        while(row>=0 && col>=0){
            if(arr[row++][col--]!=player){
                curDiagonal = false;
                break;
            }
        }
        if(curDiagonal==true)
            return player;

        return 0;
    }
}

/*
Test cases
TicTacToe obj = new TicTacToe(3);
obj.move(0,0,1);
obj.move(0,2,2);
obj.move(2,2,1);
obj.move(1,1,2);
obj.move(2,0,1);
obj.move(1,0,2);
obj.move(2,1,1);



 */