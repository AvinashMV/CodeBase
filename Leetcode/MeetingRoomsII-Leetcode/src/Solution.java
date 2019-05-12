import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-05-04
 */
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {{0,30},{5,10},{15,20}};
       Solution solution = new Solution();
       solution.minMeetingRooms(arr);
    }

    public int minMeetingRooms(int[][] intervals) {
        Map<Integer,Integer> timeLap = new TreeMap<>();
        for(int i=0;i<intervals.length;i++){
            int[] cur = intervals[i];
            timeLap.compute(cur[0],(key,val)->val==null?1:val+1);
            timeLap.compute(cur[1],(key,val)->val==null?-1:val-1);
        }

        // System.out.println(timeLap);
        int rooms = 0,max = 0;
        for(int val:timeLap.values()){
            rooms +=val;
            max = Math.max(rooms,max);
        }
        System.out.println(max);
        return max;
    }
}

/*
Test cases:
//int[][] arr = {{0,30},{5,10},{5,20}}; ans = 2
// int[][] arr = {{9,10},{4,9},{4,17}};
//int[][] arr = {{2,11},{6,16},{11,16}};
 */