package com.solution2;

import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-05-30
 *
 * Problem: Fun with Anagrams
 *
 * Given a string of arrays, an anagram of strings should be removed.
 * Output should be sorted.
 * {"code","doce","ecod","framer","frame"} -> {"code","frame","framer"}
 *
 *
 */
public class Solution {
    public static void main(String[] args) {
        // String[] list = {"code","doce","ecod","framer","frame"};
        // String[] list = {"code","aaagmnrs","anagrams","doce"};
        String[] list = {"poke","pkoe","okpe","ekop"};
        System.out.println(remvoeAnagrams(Arrays.asList(list)));
    }

    public static List<String> remvoeAnagrams(List<String> list){
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        // set is to keep track of keys generated for anagrams.
        Set<Integer> set = new HashSet<>();

        // final result.
        List<String> result = new ArrayList<>();

        for(String str:list){
            int key =1;

            // generate the key for each string.
            for(char ch:str.toCharArray())
                key *= primes[ch-'a'];

            // if set contains the key, string is not added to the result list.
            if(!set.contains(key)){
                set.add(key);
                result.add(str);
            }
        }

        Collections.sort(result);
        return result;
    }
}
