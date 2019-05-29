package com.solution1;

/**
 * @author Avinash Vijayakumar
 * 2019-05-20
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int res = 0, max = 0;
        for(int i:nums){
            max = Math.max(i,max);
            res = res ^ i;
        }

        for(int i=0;i<=max;i++)
            res = res^i;

        return res;
    }
}
