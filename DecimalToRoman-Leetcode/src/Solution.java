import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * @author Avinash Vijayakumar
 * 2019-03-23
 *
 * Given a decimal number, (whole integer) convert it to roman numerals.
 *
 */
public class Solution {
    private LinkedHashMap<Integer, String> conversionMap;

    public Solution(){
        conversionMap = new LinkedHashMap<>(){
            {
                put(1,"I");
                put(4,"IV");
                put(5,"V");
                put(9,"IX");
                put(10,"X");
                put(40,"XL");
                put(50,"L");
                put(90,"XC");
                put(100,"C");
                put(400,"CD");
                put(500,"D");
                put(900,"CM");
                put(1000,"M");
            }
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.intToRoman(48);
    }

    public String intToRoman(int num) {
        int numCopy = num;
        StringBuilder sb = new StringBuilder();

        while(numCopy>0){
            int base = 0;
            for(int i:conversionMap.keySet()){
                if(i>numCopy)
                    break;
                else
                    base = i;
            }
            int quotient = numCopy/base;
            for(int i=0;i<quotient;i++)
                sb.append(conversionMap.get(base));

            numCopy = numCopy % base;
        }

        System.out.println(sb);
        return sb.toString();
    }

}
