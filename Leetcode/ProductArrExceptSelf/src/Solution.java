import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-04-27
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Solution solution = new Solution();
        solution.productExceptSelf2(arr);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];

        left[0]=1;
        for(int i=1;i<nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }

        right[right.length-1]=1;
        for(int i= nums.length-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }

        for(int i=0;i<res.length;i++){
            res[i] = left[i]*right[i];
        }

        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(res));
        return res;
    }

    public int[] productExceptSelf2(int[] nums){
        int[] res = new int[nums.length];
        res[0] = 1;

        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int right = nums[nums.length-1];
        for(int i=res.length-2;i>=0;i--){
            res[i] = res[i]*right;
            right = right*nums[i];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
