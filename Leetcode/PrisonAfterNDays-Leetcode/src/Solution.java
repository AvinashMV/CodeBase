import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Avinash Vijayakumar
 * 2019-03-29
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr ={0,1,0,1,1,0,0,1};
        int N=7;
        solution.prisonAfterNDays(arr,N);
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        int len = cells.length;
        int[] prev = cells;
        int[] cur = new int[cells.length];

        N = N%14;
        if(N==0)
            N=14;

        for(int day=1;day<=N;day++){
            cur[0]=0;
            cur[len-1]=0;
            for(int i=1;i<cells.length-1;i++){
                if( (prev[i-1]==0 && prev[i+1]==0) ||  (prev[i-1]==1 && prev[i+1]==1))
                    cur[i]=1;
                else
                    cur[i]=0;
            }

            prev = cur;
            cur = new int[len];
        }

        System.out.println(Arrays.toString(prev));
        return prev;
    }
}
