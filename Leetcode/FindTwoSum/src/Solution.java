import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2018-12-28
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr={8,7,2,5,3,1};
        System.out.println(findSum(arr,10));
    }

    public static List<List<Integer>> findSum(int[] arr, int target){
        List<List<Integer>> mylist = new ArrayList<>();

        Map<Integer,Integer> myMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!myMap.containsKey(arr[i])){
                myMap.put(target-arr[i], arr[i]);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(myMap.get(arr[i]));
                mylist.add(temp);
            }
        }
        return mylist;
    }
}
