/**
 * @author Avinash Vijayakumar
 * 2019-03-23
 *
 * Given two arrays, find the missing number in the second array.
 * [4,6,9,5, 12], [4,9,12,6] => 5
 *
 * Logic: just xor all the elements. 
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {4,6,9,12,20};
        int[] arr2 = {4,9,12,6};

        Solution solution = new Solution();
        solution.findMissingNum(arr1,arr2);
    }

    public int findMissingNum(int[] arr1, int[] arr2){
        int missingNum = 0;

        for(int i:arr1){
            missingNum = missingNum^i;
        }

        for(int i:arr2){
            missingNum = missingNum^i;
        }

        System.out.println(missingNum);
        return missingNum;

    }
}
