/**
 * @author Avinash Vijayakumar
 * 2019-01-23
 */
public class Solution {
    //int targetIndex = -1;

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,0,1,2};
        int target = 0;
        Solution solution = new Solution();
        System.out.println(solution.search(arr,target));

    }

    private int findRotationPoint(int[]nums,int l,int h){
        int mid = -1, rotPoint = -1;
        while(l<=h){
            if(h<l) {
                return -1;
            }
            mid = (l+h)/2;
            if(nums[mid]>nums[mid+1]){
                rotPoint = mid;
                break;
            }
            if(nums[mid]<nums[mid-1]) {
                rotPoint = mid - 1;
                break;
            }
            if(nums[l]<nums[mid]){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
       // System.out.println(rotPoint);
        return rotPoint;
    }


    public int search(int[] nums, int target) {
        int rotPoint = findRotationPoint(nums,0,nums.length-1);
        if(rotPoint==-1){
            return binarySearch(nums,0,nums.length-1,target);
        }
        if(nums[rotPoint]==target){
            return rotPoint;
        }

        // send l and h both inclusive.
        if(nums[0]>target){
            return binarySearch(nums,rotPoint+1,nums.length-1,target);
        }
        return binarySearch(nums,0,rotPoint,target);
    }

    private int binarySearch(int[] arr,int l,int h,int target){
        // System.out.printf("in bin search");
        int res = -1;
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]==target){
                res = mid;
                break;
            }
            if(target<arr[mid])
                h = mid-1;
            else
                l = mid+1;
        }
        return res;
    }

}
