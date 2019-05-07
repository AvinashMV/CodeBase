import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Avinash Vijayakumar
 * 2019-04-12
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,1};
        int[] arr2 ={2,2};

        Solution solution  = new Solution();
        int[] res = solution.intersection(arr1,arr2);
        System.out.println(Arrays.toString(res));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet2 = new HashSet<>();
        Set<Integer> resultSet = new TreeSet<>();

        Arrays.stream(nums2).forEach(i->numSet2.add(i));

        for(int i:nums1){
            if(numSet2.contains(i))
                resultSet.add(i);
        }

        int[] resultArr = resultSet.stream().mapToInt(Integer::intValue).toArray();
        return resultArr;

    }
}
