package com.solution2;

import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-05-20
 */

public class Solution {
    public static void main(String[] args) {
        int[] arr = {10, 12, 10, 15, -1, 7, 6,
                5, 4, 2, 1, 1, 1};
        int target = 11;
        Solution solution = new Solution();
        solution.twoSum3(arr,target);
    }
    public void twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i=0;i<numbers.length;i++){
            int low = i+1,high = numbers.length-1;

            while(low<=high){
                int mid = (low+high)/2;
                int sum = numbers[i]+numbers[mid];
                if(sum==target){
                    /*result[0]=i+1;
                    result[1]=mid+1;*/
                    System.out.println("found: "+numbers[low]+" "+numbers[high]);
                    low++;high--;
                }

                else if(sum>target)
                    high = mid-1;
                else
                    low = mid+1;
            }
        }
    }


    // prints all combination with duplicates.
    public void twoSum2(int[] numbers, int target){
        Arrays.sort(numbers);
        int low=0,high = numbers.length-1;
        while(low<high){
            int sum = numbers[low]+numbers[high];
            if(sum==target){
                System.out.println("found: "+numbers[low]+" "+numbers[high]);
                low++;
                high--;
            }
            else if(sum>target)
                high--;
            else
                low++;
        }
    }


    public void twoSum3(int[] numbers, int target){
        Arrays.sort(numbers);
        int low=0,high = numbers.length-1;
        while(low<high){
            int sum = numbers[low]+numbers[high];
            if(sum==target){
                System.out.println("found: "+numbers[low]+" "+numbers[high]);
                while(low<high && numbers[low]==numbers[low+1])
                    low++;
                while(low<high && numbers[high]==numbers[high-1])
                    high--;
                low++;
                high--;
            }
            else if(sum>target)
                high--;
            else
                low++;
        }
    }
}
