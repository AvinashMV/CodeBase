import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-04-27
 */
public class Solution {
    public static void main(String[] args) {
        int[][] arr= {{1,4},{2,3}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(arr)));

    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        if(intervals.length<1){
            return intervals;
        }
        int[][] arr = new int[intervals.length][2];
        arr[0] = intervals[0];

        int i=1,j=1;
       while(i<intervals.length){
            int[] cur = intervals[i];
            if( (cur[0]>=arr[j-1][0] && cur[0]<=arr[j-1][1]) && !(cur[1]>=arr[j-1][0] && cur[1]<=arr[j-1][1])){
                arr[j-1][1] = cur[1];
                i++;
            }
            else if((cur[0]>=arr[j-1][0] && cur[0]<=arr[j-1][1]) && (cur[1]>=arr[j-1][0] && cur[1]<=arr[j-1][1])){
                i++;
            }
            else{
                arr[j++] = intervals[i++];
            }
        }

        // System.out.println(Arrays.deepToString(arr));
       return Arrays.copyOfRange(arr,0,j);
    }
}

/*
Test case 1:
 int[][] arr= {{1,3},{2,6},{8,10},{15,18}};

Test case 2:
{{1,4}{4,5}}

Test Case 3:
{{1,4},{0,4}};

Test Case 4:
{{1,4},{2,3}};
 */