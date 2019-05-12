/**
 * @author Avinash Vijayakumar
 * 2019-01-26
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {2,3,4,6,9};
        countPairs(arr,20);
    }

    public static  int countPairs(int[] arr,int target){
        int count = 0;
        boolean flag = false;
        for(int i=0;i<arr.length;i++){
            int j=arr.length-1;
            while((arr[i]*arr[j])>target && j>i) {
                j--;
            }
            count += j-i;
        }
        System.out.println(count);
        return count;
    }
}
