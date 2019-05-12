import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2019-03-27
 */
public class Solution {
    private Map<Character,String> phone;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "";
        solution.letterCombinations(digits);
    }

    public Solution(){
        phone = new HashMap<>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }
        };
    }

    public List<String> letterCombinations(String digits) {
        List<String> input = new ArrayList<>();
        for(char ch:digits.toCharArray()){
            input.add(phone.get(ch));
        }

        System.out.println(input);
        char[] result = new char[digits.length()];
        List<String> output = new ArrayList<>();

        if(digits.length()==0)
            return output;

        Util(input,0,result,output);
        System.out.println(output);
        return output;
    }

    public void Util(List<String> input, int level, char[] result, List<String> output){
        if(level==result.length){
            output.add(new String(result));
            return;
        }
        String curString = input.get(level);
        for(int i=0;i<curString.length();i++){
            result[level] = curString.charAt(i);
            Util(input,level+1,result,output);
        }
    }
}
