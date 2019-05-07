import java.net.Inet4Address;
import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-02-13
 */
public class Solution {
    private Map<Integer, Integer> myMap = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        Solution obj = new Solution();
        obj.topKFrequent(nums,k);
    }

    public void topKFrequent(int[] nums, int k) {

        for(int i:nums){
            if(myMap.containsKey(i)){
                myMap.put(i,myMap.get(i)+1);
            }else{
                myMap.put(i,1);
            }
        }

        List<temp> objList = new ArrayList<>();

        for(int i:myMap.keySet()){
            temp t= new temp();
            t.element = i;
            t.frequency = myMap.get(i);
            objList.add(t);
        }

        Collections.sort(objList , (temp ob1,temp ob2)-> ob1.frequency - ob2.frequency);
        System.out.println(objList);
        List<Integer> result = new ArrayList<>();
        int j = objList.size()-1;
        for(int i=0;i<k;i++){
            result.add(objList.get(j).element);
            j--;
        }
        System.out.println(result);

    }
}

class temp{
    int element,frequency;
}