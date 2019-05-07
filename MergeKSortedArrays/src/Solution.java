import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-02-08
 */
/*
Given k sorted lists , each of size n, Merge them into one sorted array.
 */

public class Solution {
    public static void main(String[] args) {
        int arr[][] = { {1,54,57,89},
                        {23,29,31,33},
                        {21,25,51,99}
        } ;
        int k=3,n=4;

        Solution obj = new Solution();
        int[] result = obj.merge(arr,k,n);
        System.out.println(Arrays.toString(result));
    }

    public int[] merge(int[][]arr,int k,int n){
        int[] sorted_arr = helper(arr,0,arr.length-1);
        return sorted_arr;
    }

    private int[] helper(int[][]arr,int low,int high){
        if(low==high){
            return arr[low];
        }

        int mid = (low+high)/2;
        int[] left = helper(arr,low,mid);
        int[] right = helper(arr,mid+1,high);

        int[] combined = new int[left.length+ right.length];
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                combined[k++]=left[i++];
            }else{
                combined[k++] = right[j++];
            }
        }

        while(i<left.length){
            combined[k++]=left[i++];
        }
        while(j<right.length){
            combined[k++] = right[j++];
        }

        return combined;
    }


}
