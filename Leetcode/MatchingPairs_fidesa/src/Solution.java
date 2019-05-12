import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Avinash Vijayakumar
 * 2019-02-16
 */
public class Solution {


    public static void main(String[] args) {
        //findMatchingPair("ABbCca");
        findMatchingPair("zABCcba");
    }

    static int findMatchingPair(String input){
        if(input.length()==0)
            return -1;

        Stack<Character> stack = new Stack<>();
        int lastIndex = -1;
        for(int i=0;i<input.length();i++){

            if(Character.isUpperCase(input.charAt(i))){
                stack.push(input.charAt(i));
            }else{

                if(stack.isEmpty()){
                    break;
                }

                char topStack = stack.peek();
                topStack = Character.toLowerCase(topStack);
                if(topStack==input.charAt(i)) {
                    lastIndex = i;
                    stack.pop();
                }else{
                    break;
                }
            }
        }

        System.out.println(lastIndex);
        return lastIndex;
    }
}
