/**
 * @author Avinash Vijayakumar
 * 2019-02-10
 */
public class Solution {
    public static void main(String[] args) {
        int[] set = {1,2,3,4};
        Solution obj = new Solution();
        obj.displayAllSubsets(set);
    }

    public void displayAllSubsets(int[] set){
        int n = set.length;
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                if( (i&(1<<j)) > 0)
                    System.out.print(set[j]);
            }
            System.out.println();
        }
    }

}

/*
public void displayAllSubsets(char[] set){
        int n = set.length;
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                if( (i&(1<<j)) >0)
                    System.out.print(set[j]);
            }
            System.out.println();
        }

    }
 */