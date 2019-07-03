package com.solution1;

import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-05-29
 *
 * Problem name: Usernames Systems.
 * Given an a string of arrays, if any duplicate string exist, it should be appended with
 * numbers starting from 1.
 *
 * Example
 * [bob,alice,bob,alan,alice] -> [bob,alice,bob1,alan,alice1]
 * [bob,bob,bob,bob] -> [bob,bob1,bob2,bob3]
 *
 */
public class Solution {
    public static void main(String[] args) {
        String[]  u = {"bob","alice","bob","alice","bob","alice"};
        // String[]  u = {"alex","xylos","alex","alan"};
        usernamesSystem(Arrays.asList(u));
    }

    public static List<String> usernamesSystem(List<String> u){
        Map<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        // In a map update the count for each of the name.
        for(String str:u){
            StringBuilder sb = new StringBuilder(str);
            map.compute(str,(key,val)->val==null?0:val+1);

            // if the count of the name is 0, just append it.
            if(map.get(str)==0){
                result.add(sb.toString());
            }else{

                // if count >0, append count to the string and then add it to the result.
                sb.append(map.get(str));
                result.add(sb.toString());
            }
        }
        System.out.println(result);
        return result;
    }
}
