import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Avinash Vijayakumar
 * 2019-05-10
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {99,99};
        int k = 1;

        int res = solution.findKthLargest(arr,k);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new TreeMap<>(Collections.reverseOrder());
        for(int i:nums){
            freqMap.compute(i,(key,val)->val==null?1:val+1);
        }

        int count = 0;
        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            count += entry.getValue();
            if(k<=count){
                return entry.getKey();
            }
        }

        return -1;
    }
}
