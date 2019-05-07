import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-01-23
 */
public class Solution {
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution obj = new Solution();
        obj.groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        HashMap<Integer,List<String>> myMap = new HashMap<>();

        for(String i:strs){
            /*char[] temparry = i.toCharArray();
            Arrays.sort(temparry);
            String key = new String(temparry);*/

            int[] arr = new int[26];
            int key = 1;
            for(char ch:i.toCharArray()){
                key *= primes[ch-'a'];
            }

            if(!myMap.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(i);
                myMap.put(key,list);
            }else{
                List<String> list = myMap.get(key);
                list.add(i);
                myMap.put(key, list);
            }
        }
        System.out.println(myMap);

        // Compile the final arraylist.
        for(int key : myMap.keySet()){
            resultList.add(myMap.get(key));
        }

        return resultList;
    }
}
