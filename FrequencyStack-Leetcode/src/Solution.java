import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-03-30
 */
public class Solution {
    private LinkedHashMap<Integer, Stack<Integer>> bucket;
    private HashMap<Integer,Integer> frequency;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(5);
        solution.push(7);
        solution.push(5);
        solution.push(7);
        solution.push(4);
        solution.push(5);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }

    public Solution() {
        bucket = new LinkedHashMap<>();
        frequency = new HashMap<>();
    }

    public void push(int x) {
        // update frequency;
        frequency.compute(x,(key,val)->val==null?1:val+1);
        // update bucket.
        int freq = frequency.get(x)-1;
        if(bucket.containsKey(freq)){
            Stack<Integer> t = bucket.get(freq);
            t.add(x);

        }else{
            Stack<Integer> t = new Stack<>();
            t.add(x);
            bucket.put(freq,t);
        }
    }

    public int pop() {
        int temp = bucket.size()-1;
        int removedVal = bucket.get(temp).pop();
        //remove stack if it is empty
        if(bucket.get(temp).isEmpty()){
            bucket.remove(temp);
        }
        //update frequency
        frequency.compute(removedVal,(key,val)->val-1);
        if(frequency.get(removedVal)==0)
            frequency.remove(removedVal);
        return removedVal;

    }
}
