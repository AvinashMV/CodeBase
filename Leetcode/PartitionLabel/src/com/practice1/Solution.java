package com.practice1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-05-16
 */
public class Solution {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        solution.partitionLabels(s);
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] last = new int[26];
        /**This is the key step:
         * we find the last occurrence of each letter and record them in last[]*/
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < S.length(); i++) {
            if (start == -1) {
                start = i;
            }
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = -1;
            }
        }
        return result;
    }
}
