import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-05-03
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        Solution solution = new Solution();
        solution.display(solution.kSmallestPairs(nums1,nums2,10));

    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0){
            return result;
        }

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int[] cur = new int[2];
                cur[0]=nums1[i];
                cur[1]=nums2[j];
                result.add(cur);
            }
        }

        Collections.sort(result,(a,b)->(a[0]+a[1])-(b[0]+b[1]));
        // display(result);
        return k>=result.size()?result:result.subList(0,k);
    }

    public void display(List<int[]> list){
        for(int[] i:list){
            System.out.print(Arrays.toString(i)+" ");
        }
    }
}

/*
Test cases;
int[] nums1 = {1,7,11};
int[] nums2 = {2,4,6};

int[] nums1 = {1,1,2};
int[] nums2 = {1,2,3};

int[] nums1 = {1,2};
int[] nums2 = {3};

 */