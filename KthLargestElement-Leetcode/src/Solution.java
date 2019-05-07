import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-04-02
 */
public class Solution {
    private int k;
    private int[] nums;

    public static void main(String[] args) {
        int[] arr = {4,5,8,2};
        int k =3;

        Solution solution = new Solution(k,arr);
        System.out.println(solution.add(3));
        System.out.println(solution.add(5));
        System.out.println(solution.add(10));
        System.out.println(solution.add(9));
        System.out.println(solution.add(4));
    }

    public Solution(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        Arrays.sort(nums);
    }

    public int add(int val) {
        int[] t = new int[nums.length+1];

        // populate array t.
        int i=0,j=0;
        while(i<nums.length){
            if(nums[i]<val){
                t[j++]=nums[i++];

            }else
                break;
        }
        t[j++]=val;

        while(i<nums.length){
            t[j++] = nums[i++];
        }

        // return the last kth element.
        nums = t;
        System.out.println(Arrays.toString(nums));
        return nums[(nums.length)-k];
    }
}

/*
Test case 1
int[] arr = {};
int k =1;

Solution solution = new Solution(k,arr);
System.out.println(solution.add(-3));
System.out.println(solution.add(-2));
System.out.println(solution.add(-4));
System.out.println(solution.add(0));
System.out.println(solution.add(4));

--------------------------------------------------------


 */