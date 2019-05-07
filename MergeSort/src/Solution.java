import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-03-01
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] arr = {5,4,1,2,3};
        int[] arr = {90,80,70,20,30,40};
        solution.mergesort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergesort(int[] arr,int low,int high){
        if(low==high)
            return;
        int mid = (low+high)/2;
        mergesort(arr,low,mid);
        mergesort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    private void merge(int[] arr,int low,int mid,int high){
        int[] aux = new int[arr.length];

        int i=low,j=mid+1,k=low;
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                aux[k++] = arr[i++];
            }else{
                aux[k++] = arr[j++];
            }
        }

        while(i<=mid){
            aux[k++] = arr[i++];
        }

        while(j<=high){
            aux[k++]= arr[j++];
        }

        for(int index=low;index<=high;index++){
            arr[index] = aux[index];
        }
    }
}
