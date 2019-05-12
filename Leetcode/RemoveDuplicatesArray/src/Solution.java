import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-01-11
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {2,2,4,4,4,5,6,6,6,6,6,8,8};
        removedup(arr);
    }

    private static int[] removedup(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1])
                System.out.println(arr[i]);
        }
        System.out.println(arr[arr.length-1]); // add the last element. 
        return arr;
    }
}
