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
        insert(3);
        insert(4);
        insert(5);

        delete();
        insert(6);
        delete();

    }
    private static void insert(int num){
        s1.push(num);

    }
    private static void delete(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        System.out.println("Deleted item is "+s2.pop());

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
}
