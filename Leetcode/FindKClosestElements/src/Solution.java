import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-05-05
 */
public class Solution {
    class pair{
        int val,differene;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k=4, x=5;
        Solution solution = new Solution();
        solution.findClosestElements(arr,k,x);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<pair> pq = new PriorityQueue<>(
                (a,b)-> a.differene==b.differene?a.val-b.val:a.differene-b.differene
        );

        Arrays.stream(arr)
                .forEach(i->{
                    pair p =new pair();
                    p.val = i;
                    p.differene = Math.abs(x - i);
                    pq.add(p);
                });




        List<Integer> res = new ArrayList<>();
        while(k>0 && !pq.isEmpty()){
            res.add(pq.poll().val);
            k--;
        }
        Collections.sort(res);
        System.out.println(res);
        return res;
    }
}
