package com.solution3;

import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-05-30
 *
 * Problem: can you sort?
 *
 * Given an array of integers, sort them first by there frequency of occurence and if frequency is same
 * then by value.
 * [4,5,6,5,4,3] -> [3,6,4,4,5,5].
 */

public class Solution {
    public static void main(String[] args) {
        // int[] arr = {4,5,6,5,4,3};
        int[] arr = {3,1,2,2,4};
        System.out.println(sort(arr));
    }

    public static List<Integer> sort(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();

        // priority queue will do all the work. Write the comparator.
        Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
                (a,b)->a.getValue()==b.getValue()?a.getKey()-b.getKey():a.getValue()-b.getValue()
        );

        // build frequency map
        for(int i:arr){
            map.compute(i,(key,val)->val==null?1:val+1);
        }

        // insert map entries to priority queue.
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(entry);
        }

        List<Integer> result = new ArrayList<>();

        // multiply each key , it's value times.
        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> cur = pq.poll();
            for(int i=0;i<cur.getValue();i++)
              result.add(cur.getKey());
        }

        return result;

    }
}
