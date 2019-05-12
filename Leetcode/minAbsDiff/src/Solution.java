import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-01-01
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr ={-59 ,-36 ,-13, 1, -53, -92, -2, -96, -54, 75};
        System.out.println(minimumAbsoluteDifference(arr));

    }

    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int curMin = 999, minSoFar = Math.abs(arr[0]-arr[1]);
        for(int i=1;i<arr.length-1;i++){
            curMin = Math.abs(arr[i]-arr[i+1]);
            minSoFar = Math.min(curMin,minSoFar);
        }
        //display(arr);
       // System.out.println(minSoFar);
        return minSoFar;
    }
}

/*
Test cases
{-2,2,4} , 2
{3,-7,0} , 3
{-59 ,-36 ,-13, 1, -53, -92, -2, -96, -54, 75} , 1
{1 ,-3, 71, 68, 17} , 3

 */