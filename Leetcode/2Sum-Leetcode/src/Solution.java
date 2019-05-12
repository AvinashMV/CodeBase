import java.util.Arrays;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-05-02
 *
 * Return the two largest integers whose sum is closest to the given target.
 *
 */

public class Solution {
    public static void main(String[] args) {
        /*double [] arr={18.3501,23.79,103.7919,7.33,8.13,11.24};
        int target = 9;*/
        int[] arr = {4,4,4,4,11,3,3,3,3,3,6,89,23,7,7,7};
        int target = 10;
        Solution solution = new Solution();
        solution.findClosest(arr,target);
    }

   /* public double[] findClosest(double [] arr,double target){
        Arrays.sort(arr);
        int minSoFar = Integer.MAX_VALUE;
        int low = 0, high = arr.length-1;
        double[] result = new double[2];

        while(low<high){
            double sum = arr[low]+arr[high];
            double diff = target-sum;
            if(diff<minSoFar){
                result[0] = arr[low];
                result[1] = arr[high];
            }

            if(sum<target){
                low++;
            }else{
                high--;
            }
        }
        return result;
    }*/

   // find all pairs whose sum = target.
    public void findClosest(int [] arr,int target){
        Arrays.sort(arr);
        int low = 0, high = arr.length-1;

        while(low<high){
            int sum = arr[low]+arr[high];

            if(sum==target){
                System.out.println(arr[low]+" "+arr[high]);
                while(low<high && arr[low]==arr[low+1])
                    low++;
                while(low<high && arr[high]==arr[high-1])
                    high--;

            }

            if(sum<target){
                low++;
            }else{
                high--;
            }
        }
    }

    // return the difference between target and sum - closest.
    /* public int findClosest(int [] arr,int target){
        Arrays.sort(arr);
        int minSoFar = Integer.MAX_VALUE;
        int low = 0, high = arr.length-1;
        int[] result = new int[2];
        int diff = Integer.MAX_VALUE;

        while(low<high){
            int sum = arr[low]+arr[high];
            diff = target-sum;
            if(diff<minSoFar){
                result[0] = arr[low];
                result[1] = arr[high];
            }

            if(sum<target){
                low++;
            }else{
                high--;
            }
        }
        return diff;
    }*/




}
