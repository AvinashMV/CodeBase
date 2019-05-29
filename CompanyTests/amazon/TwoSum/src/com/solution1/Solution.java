package com.solution1;

/**
 * @author Avinash Vijayakumar
 * 2019-05-20
 *
 * Two sum result indices. O(n^2) solution.
 *
 */
public class Solution {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i=0;i<numbers.length-1;i++){

            if(i>0 && numbers[i-1]==numbers[i])
                continue;

            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target){
                    result[0]= i+1;
                    result[1]= j+1;
                    break;
                }
            }
        }
        return result;
    }
}
