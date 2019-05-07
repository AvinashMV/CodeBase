import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-01-09
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr={2,4,3,5,6,9};
        int target = 1;

        System.out.println(BinSearch(arr,target));
    }

    private static boolean BinSearch(int[] arr,int target){
        Arrays.sort(arr);
        int l=0, h = arr.length-1, m=-1;
        boolean found = false;

        while(l<=h){             // loop condition I failed. Shah..
            m = (l+h)/2;
            if(arr[m]==target){
                found = true;
                break;
            }

            if(target<arr[m]){
                h = m-1;
            }else{
                l = m+1;
            }
        }
        return found;
    }
}
