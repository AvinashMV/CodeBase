package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2019-05-28
 *
 * Given a string of 128 ASCII characters, find out if there is any duplicate characters in
 * the string.
 */
public class Solution {
    public static void main(String[] args) {


    }

    public static boolean findDuplicate(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.compute(ch,(key,val)->val==null?1:val+1);
        }

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()>1)
                return false;
        }
        return true;
    }

}
