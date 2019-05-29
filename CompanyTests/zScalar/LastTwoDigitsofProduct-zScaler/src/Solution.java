/**
 * @author Avinash Vijayakumar
 * 2019-05-13
 *
 * Given array of numbers, and k, display last k digits of the product of all the numbers in the array.
 *
 */

public class Solution {
    public static void main(String[] args) {
        int[] arr = {99,98};
        int k=2;
        lastDigits(arr,k);
    }

    public static void lastDigits(int[] arr,int k){
        int powerof10 = (int) Math.pow(10,k);
        int mul = arr[0]% powerof10;

        for(int i=1;i<arr.length;i++){
            mul = mul*(arr[i]%powerof10);
            mul = mul%powerof10;
        }

        System.out.printf("%02d%n",mul);
    }
}
