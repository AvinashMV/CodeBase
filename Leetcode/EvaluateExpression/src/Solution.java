import java.util.HashMap;
import java.util.Stack;

/**
 * @author Avinash Vijayakumar
 * 2019-02-08
 */
public class Solution {
    private static HashMap<Character,Integer> precedence = new HashMap<>();
    public Solution(){
        precedence.put('^',4);
        precedence.put('*',3);
        precedence.put('/',3);
        precedence.put('+',2);
        precedence.put('-',2);

    }
    public static void main(String[] args) {
        String expr = "1+3/2-6*2";
        Solution obj = new Solution();
        String postfix = obj.convertToPostFix(expr);
        obj.evaluate(postfix);
    }

    public String convertToPostFix(String infix){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char ch:infix.toCharArray()){
            if(!precedence.containsKey(ch)){
                // operand, add it.
                sb.append(ch);
            }
            else{
                if(stack.isEmpty())
                    stack.push(ch);
                else{
                    while(!stack.isEmpty() && precedence.get(stack.peek())>=precedence.get(ch))
                        sb.append(stack.pop());
                    stack.push(ch);
                }
            }
        }
        // end of the string.
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public int evaluate(String postfix){
        Stack<Float> stack = new Stack<>();

        for(char ch: postfix.toCharArray()){
            if(!precedence.containsKey(ch)){
                // if it is an operand, convert to int and push it stack.
                stack.push(new Float(Character.getNumericValue(ch)));
            }else{
                float op2 = stack.pop();
                float op1 = stack.pop();
                float res = Integer.MAX_VALUE;
                switch(ch){
                    case '/':
                        res = op1/op2;
                        break;

                    case '*':
                        res = op1 * op2;
                        break;

                    case '+':
                        res = op1 + op2;
                        break;

                    case '-':
                        res = op1 - op2;
                        break;
                }
                stack.push(res);
            }
        }

        System.out.println(stack.peek());
        return -1;
    }

}
