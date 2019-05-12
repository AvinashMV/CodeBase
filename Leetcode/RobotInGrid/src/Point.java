/**
 * @author Avinash Vijayakumar
 * 2019-02-05
 */
public class Point {
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "("+this.row+","+this.col+")";
    }

    public int row, col;

}
