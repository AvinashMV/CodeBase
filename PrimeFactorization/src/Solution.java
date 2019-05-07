import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> factors = new ArrayList<>();

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.getFactors(14);
        System.out.println(obj.factors);

    }

   /* private void getFactors(int n){
        while(n%2==0){
            factors.add(2);
            n /=2;
        }

        for(int i=3;i<=Math.sqrt(n);i++){
            while(n%i==0){
                factors.add(i);
                n /=i;
            }
        }

        if(n>2)
            factors.add(n);
    }*/


}
