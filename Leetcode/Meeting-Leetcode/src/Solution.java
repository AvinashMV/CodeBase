import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-04-02
 */
public class Solution {
    public static void main(String[] args) {
        Interval[] meetings = {
                new Interval(15,20),
                new Interval(0,5),
                new Interval(6,10)
        };

        Solution solution = new Solution();
        System.out.println(solution.canAttendMeetings(meetings));
    }

    public boolean canAttendMeetings (Interval[] intervals){
        // sort the intervals based on start times.
        Arrays.sort(intervals,(interval1,interval2)->{
            return interval1.starttime - interval2.starttime;
        });

        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i].endtime>intervals[i+1].starttime)
                return  false;
        }

        // System.out.println(Arrays.toString(intervals));
        return true;
    }

}
