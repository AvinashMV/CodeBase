/**
 * @author Avinash Vijayakumar
 * 2019-03-18
 *
 * Given two sorted arrays, find the median when arrays are merged.
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {1,3,8,9,15};
        int[] arr2 ={7,11,19,21,18,25};

        Solution solution = new Solution();
        System.out.println(solution.findMedian(arr1,arr2));
    }

    public double findMedian(int[] arr1, int[]arr2){
        // arr1 must be smaller.
        if(arr1.length>arr2.length){
            return findMedian(arr2,arr1);
        }

        int l=0, h=arr1.length-1,midx = -1,midy=-1;

        while(l<=h){
            midx = (l+h)/2;
            midy = (arr1.length+arr2.length+1)/2 - midx;

            int maxleftx = midx==0?Integer.MIN_VALUE:arr1[midx-1];
            int maxlefty = midy==0?Integer.MIN_VALUE:arr2[midy-1];

            int minrightx = midx==arr1.length?Integer.MAX_VALUE:arr1[midx];
            int minrighty = midy==arr2.length?Integer.MAX_VALUE:arr2[midy];

            if(maxleftx<minrighty && maxlefty<minrightx){
                // match found.
                if( (arr1.length+arr2.length) %2==0){
                    // even length
                    return (Math.max(maxleftx,maxlefty)+Math.min(minrightx,minrighty) )/2;
                }else{
                    // odd length
                    return Math.max(maxleftx,maxlefty);
                }
            }

            else if(maxleftx>minrightx){
                // need smaller on left hand side so move left
                h = midx-1;
            }
            else if(maxlefty>minrightx){
                // need larger value on right hand side so move right
                l = midx+1;
            }

        }
        return -1;
    }
}
