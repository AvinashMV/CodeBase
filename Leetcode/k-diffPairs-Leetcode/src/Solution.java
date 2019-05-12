import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-04-12
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr ={1, 3, 1, 5, 3,4};
        int k= 0;
        Solution solution = new Solution();
        System.out.println(solution.findPairs(arr,k));
    }

    public int findPairs(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            if(i>0 && nums[i-1]==nums[i])
                continue;
            int prev = -1;

            for(int cur=i+1;cur<nums.length;cur++){
                if(prev!=-1 && nums[prev]==nums[cur])
                    continue;

                int diff = nums[cur]-nums[i];
                if(diff==k)
                    result++;
                else if(diff>k)
                    break;

                prev = cur;
            }
        }
        return result;
    }
}

/*
case 1
int[] arr ={3,1,4,1,5};
int k= 2;

case 2
int[] arr ={1,2,3,4,5};
int k= 1;

case 3

 */