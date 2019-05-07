/**
 * @author Avinash Vijayakumar
 * 2019-01-11
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numberofones(14));
    }

    private static int numberofones(int n){
        return Integer.bitCount(n);
    }
}
