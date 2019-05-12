import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-03-24
 *
 * Given a array of numbers, find all list of 3 numbers whose sum = 0.
 */

public class Solution {
    List<List<Integer>> mylist = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr ={-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum2(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i-1]==nums[i])
                continue;
            int j = i+1, target = -nums[i];
            twoSum(target,j,nums);
        }
        System.out.println(mylist);
        return mylist;
    }

    public void twoSum(int target,int start,int[] nums){
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for(int i=start;i<nums.length;i++){
            if(myMap.containsKey(nums[i])){
                List<Integer> t = new ArrayList<>();
                t.add(nums[i]);
                t.add(myMap.get(nums[i]));
                t.add(-target);
                mylist.add(t);

            }
            myMap.put(target-nums[i],nums[i]);
        }
    }

    public List<List<Integer>> threeSum2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> mylist = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;

            int target = 0-nums[i],lo=i+1,hi=nums.length-1;

            while(lo<hi){
                if(nums[lo]+nums[hi]==target){
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[lo]);
                    t.add(nums[hi]);
                    mylist.add(t);

                    while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                    while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                    lo++;hi--;

                }else if(nums[lo]+nums[hi]<target)
                    lo++;
                else
                    hi--;
            }
        }
        return mylist;
    }



}

/*
int[] arr ={-1,0,1,2,-1,-4};
int[] arr = {0,0,0,0}

 */