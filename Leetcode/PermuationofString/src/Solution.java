import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Avinash Vijayakumar
 * 2019-03-01
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteString("aabc"));

    }

    public List<String> permuteString(String s){
        TreeMap<Character,Integer> occurenceMap = new TreeMap<>();

        for(char ch:s.toCharArray()){
            occurenceMap.compute(ch,(key,val)->val==null?1:val+1);
        }
        char[] str = new char[occurenceMap.size()];
        int[] count = new int[occurenceMap.size()];
        int index =0;
        for(Map.Entry<Character,Integer> entry:occurenceMap.entrySet()){
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        char[] result = new char[s.length()];
        List<String> resultList = new ArrayList<>();

        permuteStringUtil(str,count,result,0,resultList);
        return resultList;

    }

    public void permuteStringUtil(char[] str,int[] count,char[] result,int level,List<String> resultList){
        if(level == result.length){
            resultList.add(new String(result));
            return;
        }

        for(int i=0;i<str.length;i++){
            if(count[i]==0)
                continue;

            result[level] = str[i];
            count[i]--;
            //recursion
            permuteStringUtil(str,count,result,level+1,resultList);
            count[i]++;
        }
    }
}
