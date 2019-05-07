/**
 * @author Avinash Vijayakumar
 * 2019-03-14
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countZeros(30));
    }

    public int countZeros(int n){
        int count = 0;
        for(int i=5;n/i>=1;i*=5){
            count += n/i;
        }
        return count;
    }
}
