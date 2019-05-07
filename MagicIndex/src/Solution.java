/**
 * @author Avinash Vijayakumar
 * 2019-02-10
 */
/*
Given a sorted array, find an index such that index = arr[i].
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr= {-10,-5,2,2,2,3,4,8,9,12,13};
        Solution obj = new Solution();
        System.out.println(obj.findMagicIndex(arr));
    }

    public int findMagicIndex(int[] arr){
        if(arr.length==0)
            return 0;
        return helper(arr,0,arr.length-1);
    }

    private int helper2(int[] arr,int low,int high) {
        if (high < low)
            return -1;
         int mid = (low+high)/2;
        if(mid == arr[mid])
            return mid;

        if(mid>arr[mid]){
            return helper(arr,0,Math.min(mid,arr[mid]));
        }
        else{
            return helper(arr,0,mid-1);       
        }


    }





    private int helper(int[] arr,int low, int high){
        if(high<low)
            return -1;

        int mid = (low+high)/2;
        if(mid == arr[mid])
            return mid;
        if(mid>arr[mid])
            return helper(arr,mid+1,high);
        else
            return helper(arr,0,mid-1);
    }
}

/*
Test cases:
int[] arr= {-10,-5,0,3,7};
int[] arr= {0,2,5,8,17};
int[] arr= {1,2,3,4,5};
int[] arr= {-40,-20,-1,1,2,3,5,7,9,12,13};

 */