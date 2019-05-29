package com.solution1;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author Avinash Vijayakumar
 * 2019-05-18
 */
public class MedianFinder {
    /** initialize your data structure here. */
    NavigableMap<Integer,Integer> map;
    int numOfElements;

    public MedianFinder() {
       map = new TreeMap<>();
       numOfElements = 0;
    }

    public void addNum(int num) {
        map.compute(num,(key,val)->val==null?1:val+1);
        numOfElements++;
    }

    public double findMedian() {
        if(numOfElements%2==0){
            int target = numOfElements/2;
            int count =0;
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                count += entry.getValue();
                if(count>=target+1)
                    return entry.getKey();
                else if(count==target){
                    Map.Entry<Integer,Integer> next = map.higherEntry(entry.getKey());
                    double sum = entry.getKey()+ next.getKey();
                    return sum/2.0;
                }
            }

        }else{
           int target = (int) Math.round(numOfElements/2+0.5);
           int count = 0;
           for(Map.Entry<Integer,Integer> entry:map.entrySet()){
               count += entry.getValue();
               if(count>=target)
                   return entry.getKey();
           }
        }
        return 0;
    }


    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
