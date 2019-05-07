import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-01-05
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr={4504 ,1520 ,5857,
                4094,
                4157,
                3902,
                822,
                6643,
                2422,
                7288,
                8245,
                9948,
                2822,
                1784,
                7802,
                3142,
                9739,
                5629,
                5413,
                7232}; int k=5;
        System.out.println(maxMin(k,arr));
    }

    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        k = k-1; // bcoz diff is including.
        int mindiff = Integer.MAX_VALUE, curdiff= 0;
        for(int i=0;i<arr.length-k;i++){
            curdiff = arr[i+k]-arr[i];
            mindiff = Math.min(curdiff,mindiff);
        }

        return mindiff;

    }
}

/* Test case

int[] arr={1,4,7,2}; int k=2; ans =1
int[] arr={10,100,300,200,1000,20,30}; int k=3; ans 20
int[] arr={1,2,3,4,10,20,30,40,100,200}; int k=4; ans 3
int[] arr={1,2,1,2,1}; int k=2; ans 0

 */