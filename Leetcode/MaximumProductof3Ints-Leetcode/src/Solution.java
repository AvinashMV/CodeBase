import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Avinash Vijayakumar
 * 2019-04-19
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr= {-4,-3,-2,-1,60};
        Solution solution = new Solution();
        System.out.println(solution.maximumProduct(arr));
    }

    public int maximumProduct(int[] nums) {
       Arrays.sort(nums);
       int len = nums.length;
       int prod1 = nums[len-1]*nums[len-2]*nums[len-3];
       int prod2 = nums[0]*nums[1]*nums[len-1];

       return Math.max(prod1,prod2);
    }
}
