import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-01-11
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr={3,5,7,9,10,12};
        System.out.println("before sort");
        display(arr);
        int[] res = wigglesort(arr);
        display(res);
    }

    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }

    private static int[] wigglesort(int[] arr){
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i+=2){
            int temp = arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
        return arr;
    }
}
