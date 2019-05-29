package com.practice2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Avinash Vijayakumar
 * 2019-05-16
 */
public class Solution {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] dict = {"leet", "code"};
        Solution solution = new Solution();
        boolean res = solution.wordBreak(s, Arrays.asList(dict));
        System.out.println(res);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int len = s.length();
        int[][] matrix = new int[len][len];


        // for len 1,2,3 up to s.len
        for(int l=1;l<len;l++){
            for(int i=0;i<len-l+1;i++){
                int j = i+l-1;
                if(dict.contains (s.substring(i,j+1))){
                    matrix[i][j] = 1;
                    continue;
                }
                else{
                    for(int k=i+1;k<=j;k++){
                        if(matrix[i][k-1]!=0 && matrix[k][j]!=0){
                            matrix[i][j]=1;
                            break;
                        }
                    }
                }
            }
        }
        return matrix[0][len-1]==0?false:true;
    }

    public void display(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
