import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-01-26
 */
public class Solution {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1,2,3,1,2,2);
        System.out.println(deleteProducts(myList,3));
    }
    public static int deleteProducts(List<Integer> ids, int m) {
        // Write your code here
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for(int i:ids){
            if(myMap.containsKey(i)){
                myMap.put(i,myMap.get(i)+1);
            }else{
                myMap.put(i,1);
            }
        }

        // choose smartly m and update the map accordingly.
        while(m!=0){
            int min = Integer.MAX_VALUE,key = -1,value =-1;
            for(int i:myMap.keySet()){
               if(myMap.get(i)<min){
                   min = myMap.get(i);
                   key = i;
               }
            }
            if(min>m){
                m = 0;
                myMap.put(key,min-m);
            }else{
                m = m - min;
                myMap.remove(key);
            }
        }

        System.out.println(myMap);
        return myMap.size();
    }
}


/*
Test cases:
 List<Integer> myList = Arrays.asList(1,1,1,2,2,3);
 System.out.println(deleteProducts(myList,2));


 List<Integer> myList = Arrays.asList(1,1,1,1)
 System.out.println(deleteProducts(myList,2));

 */