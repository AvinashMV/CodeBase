import java.util.Stack;

/**
 * @author Avinash Vijayakumar
 * 2019-01-18
 */
public class Solution {
    private static Stack<Integer> s1 = new Stack<>();
    private static Stack<Integer> s2 = new Stack<>();

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(5);
        insert(6);
        insert(3);
        insert(7);
        insert(8);


        System.out.println(s1.peek());
        s1.pop();
        System.out.println(s1.peek());

    }

    private static void insert(int num){
        if(s1.isEmpty() || num<s1.peek()){
            s1.push(num);
        }
        else{
            if(num > s1.peek()){
                while(! s1.isEmpty())
                    s2.push(s1.pop());

                s1.push(num);

                while(!s2.isEmpty())
                    s1.push(s2.pop());
            }
        }
    }
}
