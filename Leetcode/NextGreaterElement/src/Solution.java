import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Avinash Vijayakumar
 * 2019-05-20
 */
public class Solution {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);

        for(int i=0;i<nums1.length;i++){
            // get the starting index from map.
            int index = map.get(nums1[i]);

            for(int j=index+1;j<nums2.length;j++){
                if(nums2[j]>nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}
