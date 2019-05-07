import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2018-12-28
 */

public class Solution {
    private static Map<Long,Integer> greater = new HashMap<>();
    private static Map<Long,Integer> lesser = new HashMap<>();

    public static void main(String[] args) {
        List<Long> numList = new ArrayList<>();
        numList.add(1L);
        numList.add(1L);
        numList.add(1L);
        numList.add(1L);
        numList.add(1L);

        System.out.println(countTriplets(numList,1));
    }

    static void setupMap(List<Long> arr){

        for(Long i:arr){
            if(!greater.containsKey(i)){
                greater.put(i,1);
            }
            else{
                greater.put(i,greater.get(i)+1);
            }
        }

        for(Long i:arr){
            lesser.put(i,0);
        }
    }

    static long countTriplets(List<Long> arr, long r) {
        setupMap(arr);
        Long result = 0L;

        // loop through the array.
        for(Long curr:arr) {
            Long leftval = curr/r;
            Long rightval = curr*r;

            //update both the hashmap.
            greater.put(curr, greater.get(curr)-1);

            if( arr.contains(leftval) && arr.contains(rightval) ){
                //System.out.println("went in for "+curr);
                result += (lesser.get(leftval)*greater.get(rightval));
            }

            lesser.put(curr,lesser.get(curr)+1);
        }
        //System.out.println(result);
        return result;
    }

}


/* test cases
1,2,2,4  ans 4
1,3,9,9,27,81 ans 6
1,5,5,25,125 ans 4
 */