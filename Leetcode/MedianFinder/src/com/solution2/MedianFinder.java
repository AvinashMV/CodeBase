package com.solution2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Avinash Vijayakumar
 * 2019-05-18
 */
public class MedianFinder {
    /** initialize your data structure here. */
    Queue<Integer> min;
    Queue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    // brillant way to keep first half in max and second half in min heap.
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if(max.size()<min.size()){
            max.add(min.poll());
        }
    }

    public double findMedian() {
        // even number of integers.
        if(max.size()==min.size())
            return (max.peek()+min.peek())/2.0;
        return max.peek();
    }
}
