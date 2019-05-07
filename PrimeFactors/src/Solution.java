import java.util.ArrayList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-02-19
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getPrimefactors(330);

    }

    private List<Integer> getPrimefactors(int n){
        List<Integer> pfList = new ArrayList<>();
        while(n%2==0) {
            pfList.add(2);
            n = n/2;
        }

        for(int i=3;i<=Math.sqrt(n);i++){
            while(n%i==0) {
                pfList.add(i);
                n = n/i;
            }
        }

        if(n>2)
            pfList.add(n);

        System.out.println(pfList);
        return pfList;
    }

}
