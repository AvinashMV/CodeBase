import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author Avinash Vijayakumar
 * 2019-03-14
 */
public class Solution {
    HashMap<Character,String> unitDigit;
    HashMap<Character,String> tensDigit;

    public Solution(){
       unitDigit = new HashMap<>(){
           {
               put('0',"");
               put('1',"One");
               put('2',"Two");
               put('3',"Three");
               put('4',"Four");
               put('5',"Five");
               put('6',"Six");
               put('7',"Seven");
               put('8',"Eight");
               put('9',"Nine");

           }
       };

       tensDigit = new HashMap<>(){
           {
               put('0',"");
               put('1',"Ten");
               put('2',"Twenty");
               put('3',"Thirty");
               put('4',"Fourty");
               put('5',"Fifty");
               put('6',"Sixty");
               put('7',"Seventy");
               put('8',"Eighty");
               put('9',"Ninty");
           }
       };
    }

    public static void main(String[] args) {
        String n = "618000";
        Solution solution = new Solution();
        String res  = solution.Numbers(n);
        System.out.println(res);
    }

    public String Numbers(String n){
        if(n.length()>3){
            int begIndex = n.length()-3;
            String part2 = threeNumbers(n.substring(begIndex,n.length()));

            String part1 = threeNumbers(n.substring(0,begIndex));
            part1 = part1+" Thousand ";

            return part1+part2;
        }
        return threeNumbers(n);
    }

    public String threeNumbers(String n){
        int place = 0;
        if(n.length()>2){
            StringBuilder sb = new StringBuilder();
            sb.append(unitDigit.get(n.charAt(0)));
            if(sb.length()>1)
                sb.append(" Hundred ");
            return sb.toString()+twoNumbers(n.substring(1,n.length()));
        }
        return twoNumbers(n);
    }

    public String twoNumbers(String n){
        StringBuilder sb = new StringBuilder();
        if(n.length()>1){
            sb.append(tensDigit.get(n.charAt(0)));
            sb.append(" ");
            sb.append(unitDigit.get(n.charAt(1)));
            sb.append(" ");

        }else{
            sb.append(unitDigit.get(n.charAt(0)));
        }
        return sb.toString();

    }


}
