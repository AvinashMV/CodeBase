/**
 * @author Avinash Vijayakumar
 * 2019-01-11
 */
public class Solution {
    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};
        System.out.println(findMedian(x,y));
    }

    private static double findMedian(int[] arr1, int[] arr2){
        //arr1 must be smaller than arr2.
        if(arr1.length > arr2.length){
            return findMedian(arr2,arr1);
        }
        // get the length
        int arr1_len = arr1.length;
        int arr2_len = arr2.length;

        // set up environment for binary search on x .
        int low=0, high = arr1_len-1,middlex=-1, middley=-1;
        while(low<=high){                   // DAMN IMPORTANT < AND <= MAKE LOT OF DIFFERENCE.
                                            // continue the loop if low<=high.
            middlex = (low+high)/2;
            middley = (arr1_len+arr2_len+1)/2 - middlex;

            // get 4 important elements. maxleftx, minrightx, maxlefty, minrighty;
            // Min_Value for left part bcoz you use max() and 0 instead of null value here.
            int maxleftx = (middlex==0)? Integer.MIN_VALUE:arr1[middlex-1];
            int maxlefty = (middley==0)? Integer.MAX_VALUE:arr2[middley-1];

            // Max value bcoz for right part you use min() so MAX value instead of null value here.
            int minrightx = (middlex==arr1_len)? Integer.MAX_VALUE:arr1[middlex];
            int minrighty = (middley==arr2_len)? Integer.MAX_VALUE:arr2[middley];

            if(maxleftx<=minrighty && maxlefty<=minrightx){
                // found the partition.
                if((arr1_len+arr2_len)%2==0){
                    // even length
                    return ((double)Math.max(maxleftx,maxlefty)+Math.min(minrightx,minrighty))/2;
                }else{
                    // odd length
                    return ((double) Math.max(maxleftx,maxlefty));
                }
            }
            else if(maxleftx>minrighty){
                // we need smaller value for maxleftx so move towards left.
                high = middlex-1;
            }else{
                // move right.
                low = middlex+1;
            }

        }
        return -1.0; // dummy part. It won't come here. If -1 is returned it means some error.
                    // may be arrays not sorted at all. 
    }
}
