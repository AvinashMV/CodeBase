/**
 * @author Avinash Vijayakumar
 * 2019-02-10
 */

/*
Towers of Hanoi problem.
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.move(3,'A','B','C');

    }
    public void move(int n, char from,char to,char intermediate){
        if(n==1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }

        move(n-1,from,intermediate,to);
        System.out.println("Move disk"+n+" from "+from+" to "+to);
        move(n-1,intermediate,to,from);
    }
}
