import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-05-20
 */
public class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] arr = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int N = 4;
        int res  = solution.findJudge(N,arr);
        System.out.println(res);
    }
    public int findJudge(int N, int[][] trust) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        if(trust.length==0){
            return N;
        }

        for(int i=0;i<trust.length;i++){
            int[] cur = trust[i];
            map.compute(cur[1],(key,val)->{
                if(val==null){
                    Set<Integer> t = new HashSet<>();
                    t.add(cur[0]);
                    return t;
                }else{
                    val.add(cur[0]);
                    return val;
                }
            });
        }

        Set<Integer> valueSet = new HashSet<>();
        List<Integer> judgeSet = new ArrayList<>();

        for(Map.Entry<Integer,Set<Integer>> entry:map.entrySet()){
            valueSet.addAll(entry.getValue());
            if(entry.getValue().size()==N-1)
                judgeSet.add(entry.getKey());
        }

        for(int i:judgeSet){
            if(!valueSet.contains(i)){
                return i;
            }
        }
        return -1;
    }
}

/*
Test cases:
int[][] arr = {{1,3},{2,3},{3,1}};
int N = 3;
ans = -1

int[][] arr = {{1,2}};
int N = 2;
ans 2

int[][] arr = {{1,3},{2,3}};
int N = 3;
ans 3

int[][] arr = {{1,3},{2,3},{3,1}};
int N = 3;
ans -1


int[][] arr = {{1,3},{1,4},{2,3},{2,4},{4,3}};
int N = 4;
ans 3

 */