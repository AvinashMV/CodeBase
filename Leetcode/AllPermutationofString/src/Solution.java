import javax.crypto.spec.ChaCha20ParameterSpec;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Avinash Vijayakumar
 * 2019-02-20
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="AABC";
        solution.permute(s);
        // System.out.println(solution.permute(s));
    }

    public void permute(String input){
        Map<Character,Integer> occurrenceMap = new TreeMap<>();
        for(char ch:input.toCharArray()){
            occurrenceMap.compute(ch,(key,val)->val==null?1:val+1);
        }
        // System.out.println(occurrenceMap);
        char[] str = new char[occurrenceMap.size()];
        int[] count = new int[occurrenceMap.size()];
        char[] result = new char[input.length()];
        List<String> resList = new ArrayList<>();

        int index = 0;
        for(Map.Entry<Character,Integer> entry:occurrenceMap.entrySet() ){
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        permuteUtil(str,count,result,0,resList);
        System.out.println(resList);
    }

    private void permuteUtil(char[] str,int[] count,char[] result,int level,List<String> resList){
        if(level == result.length){
            resList.add(new String(result));
            return;
        }

        for(int i=0;i<str.length;i++){
            if(count[i]==0)
                continue;
            else{
                result[level] = str[i];
                count[i]--;
                permuteUtil(str,count,result,level+1,resList);
                count[i]++;
            }
        }
    }

}
