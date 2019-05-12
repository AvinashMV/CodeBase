import java.util.HashMap;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2019-04-03
 */
public class Solution {
    Map<String,Integer> coversionMap;

    public static void main(String[] args) {
        String s= "MCMXCIV";
        Solution solution = new Solution();
        System.out.println(solution.romanToInt(s));
    }

    public Solution(){
        coversionMap = new HashMap<>(){
            {
                put("I",1);
                put("IV",4);
                put("V",5);
                put("IX",9);
                put("X",10);
                put("XL",40);
                put("L",50);
                put("XC",90);
                put("C",100);
                put("CD",400);
                put("D",500);
                put("CM",900);
                put("M",1000);

            }
        };
    }

    public int romanToInt(String s) {
        int i=0, sum = 0;
        while(i<s.length()){
            StringBuilder sb = new StringBuilder();
            if(i<s.length()-1){
                sb.append(s.charAt(i));sb.append(s.charAt(i+1));
                if(coversionMap.containsKey(sb.toString())){
                    sum += coversionMap.get(sb.toString());
                    i+=2;
                    continue;
                }
            }

            sb = new StringBuilder();
            sb.append(s.charAt(i));
            sum += coversionMap.get(sb.toString());
            i+=1;

        }
        System.out.println(sum);
        return sum;
    }
}
