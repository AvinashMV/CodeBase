import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Avinash Vijayakumar
 * 2019-01-09
 */
public class Solution {
    private static Map<Character,Character> mapping = new HashMap<>();

    public static void main(String[] args) {
        String s ="{[]}";
        System.out.println(isValid(s));
    }

    private static void preMap(){
        mapping.put('(',')');
        mapping.put('[',']');
        mapping.put('{','}');
    }

    private static boolean isValid(String s){
        if(s.length()==0)
            return true;

        if(s.length()<2)
            return false;

        preMap();
        Stack<Character> stack = new Stack();

        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(mapping.get(cur)!=null){
                // opening bracket.
                stack.push(cur);
            }else{
                // closing bracket.
                if(stack.isEmpty())
                    return false;
                if(cur==mapping.get(stack.peek()))
                    stack.pop();
                else{
                    return false;
                }
            }
        }
        return stack.empty();
    }
}

/* Test Cases

({[[{()}]]})
[(])
[()]{}{[()()]()}
([)]
{[]}
 */