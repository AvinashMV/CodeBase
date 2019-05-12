/**
 * @author Avinash Vijayakumar
 * 2019-03-01
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,4};
        solution.allSubsets(arr);
    }

    public void allSubsets(int[] arr){
        int n = arr.length;
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                if((i&(1<<j))>0)
                    System.out.print(arr[j]);
            }
            System.out.println();
        }

    }
}
