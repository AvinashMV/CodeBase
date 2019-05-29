import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Avinash Vijayakumar
 * 2019-05-13
 */
public class Solution {
    class point{
        int[] arr = new int[2];
        point(int[] arg){
            arr = arg;
        }
    }

    public static void main(String[] args) {
        int[][] points = {
                {1,3},
                {-2,2}
        };

        Solution solution = new Solution();
        int[][] res = solution.kClosest(points,1);
        System.out.println(Arrays.deepToString(res));
    }

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1,p2)->(p1[0]*p1[0]+p1[1]*p1[1])-(p2[0]*p2[0]+p2[1]*p2[1]));
        return Arrays.copyOfRange(points,0,K);
    }
}
