import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-03-27
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-1, 2, 1, -4};
        solution.threeSumClosest(arr,1);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int curdiff = 0, minDiff = Integer.MAX_VALUE, result = 0;

        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int lo = i+1,hi = nums.length-1;
            while(lo<hi){
                int sum = nums[lo]+nums[hi]+nums[i];
                curdiff = Math.abs(target-sum);

                if(curdiff<minDiff){
                    minDiff  = curdiff;
                    result = sum;
                }

                if(sum<target)
                    lo++;
                else
                    hi--;
            }
        }

        System.out.println(result);
        return -1;
    }
}
