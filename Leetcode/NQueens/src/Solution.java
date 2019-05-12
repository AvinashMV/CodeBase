/**
 * @author Avinash Vijayakumar
 * 2019-02-27
 */
public class Solution {
    class Position{
        int row,col;
        public Position(int r,int c){
            row = r;
            col = c;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.display(solution.nqueens(8));
    }

    public void display(Position[] positions){
        for(Position i:positions){
            System.out.println(i.row+" "+i.col);
        }
    }

    public Position[] nqueens(int n){
        Position[] positions = new Position[n];
        if(nqueensUtil(n,0,positions))
            return positions;
        else
            return new Position[0];
    }

    private boolean nqueensUtil(int n,int row, Position[] positions){
        if(row==n){
            return true;
        }

        for(int col=0;col<n;col++){
            boolean foundSafe = true;

            // check in current row any col is safe or not.
            for(int queen=0;queen<row;queen++){
                if(positions[queen].col ==col || positions[queen].row-positions[queen].col==row-col ||
                        positions[queen].row+positions[queen].col==row+col){
                    foundSafe = false;
                    break;
                }
            }

            if(foundSafe){
                positions[row] = new Position(row,col);
                if(nqueensUtil(n,row+1,positions)){
                    return true;
                }
            }
        }
        return false;
    }
}
