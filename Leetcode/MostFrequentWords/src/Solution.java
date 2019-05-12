import java.net.Inet4Address;
import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-04-28
 */
public class Solution {
    public static void main(String[] args) {
        // String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
         String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(words,3));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s:words){
            map.compute(s,(key,val)->val==null?1:val+1);
        }

        Queue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
                (a,b)->a.getValue()==b.getValue()? a.getKey().compareTo(b.getKey()): b.getValue()-a.getValue()
        );

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.add(entry);
        }

        List<String> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(pq.poll().getKey());
        }
        return list;

    }
}


