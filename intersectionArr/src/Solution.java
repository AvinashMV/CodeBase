import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-01-14
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {13,27,35,40,49,55,59};
        int[] arr2 = {17,35,39,40,55,58,60};

        System.out.println(findIntersection2(arr1, arr2));
    }

    // using map O(n).
    private static List<Integer> findIntersection(int[] arr1, int[] arr2){
        Set<Integer> refSet = new HashSet<Integer>();
        for (int i1 : arr1)
            refSet.add(i1);

        List<Integer> intersection = new ArrayList<>();

        for(int i:arr2){
            if(refSet.contains(i))
                intersection.add(i);
        }
        return intersection;
    }

    // much efficient O(n) without using any extra space.
    // linear search works bcoz array is sorted.
    private static List<Integer> findIntersection2 (int[] arr1,int[] arr2){
        int j=0;
        List<Integer> result = new ArrayList<>();
        for(int i:arr1){
           while(arr2[j] < i )
               j++;
           if(i==arr2[j])
               result.add(i);
        }

        return result;
    }



}
