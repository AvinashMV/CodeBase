import java.net.Inet4Address;
import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-01-26
 */
public class DistinctPairs {
    public static void main(String[] args) {
        List<Integer> mylist = Arrays.asList(2,2,2,2,2);
        System.out.println(numberOfPairs(mylist,4));
    }
    /*public static int numberOfPairs(List<Integer> a, long k) {
        HashMap<Integer,Integer> myMap = new HashMap<>();

        int totalPairs = 0;
        for(int i:a){
            if(myMap.containsKey(i)){
                totalPairs++;
            }else{
                myMap.put((int)k-i,i);
            }
        }
        return totalPairs;
    }*/

    public static int numberOfPairs(List<Integer> a, long k){
        HashMap<Integer,Integer> myMap = new HashMap<>();
        HashSet<List<Integer>> mySet = new HashSet<>();

        int totalPairs = 0;
        for(int i:a){
            if(myMap.containsKey(i)){
                List<Integer> t = new ArrayList<>();
                t.add(i);
                t.add(myMap.get(i));
                mySet.add(t);
            }else{
                myMap.put((int)k-i,i);
            }
        }

        //System.out.println(mySet);
        return mySet.size();
    }
}

/*
Test cases:
List<Integer> mylist = Arrays.asList(1,2,3,6,7,8,9,1) , 10
 */