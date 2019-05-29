import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Avinash Vijayakumar
 * 2019-05-21
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> pq = new PriorityQueue<>(
                (a,b)->(a[0]+a[1]) - (b[0]+b[1])
        );

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int[] t = new int[2];
                t[0] = nums1[i];
                t[1] = nums2[j];
                pq.add(t);

            }
        }

        List<int[]> result = new ArrayList<>();
        while(k>0){
            result.add(pq.poll());
            k--;
        }
        return result;
    }
}
