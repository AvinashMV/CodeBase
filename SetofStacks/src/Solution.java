import java.util.Arrays;
import java.util.Stack;

/**
 * @author Avinash Vijayakumar
 * 2019-01-18
 */
public class Solution {
    private static Stack<Stack<Integer>> setStacks = new Stack<>();
    private static int stacksize = 5;

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,12,14,15,19,34,56};
        for(int i:arr){
            insert(i);
        }
        System.out.println(Arrays.toString(setStacks.toArray()));
        // index starting from 0
        System.out.println(delAtIndex(7));
        System.out.println(Arrays.toString(setStacks.toArray()));
        System.out.println("everything done.");
    }

    private static int delAtIndex(int num){
        int stacknum = num / stacksize;
        Stack<Stack<Integer>> temp = new Stack<>();
        for(int i=setStacks.size()-1;i!=stacknum;i--){
            temp.push(setStacks.pop());
        }

        Stack<Integer> cur = setStacks.pop();
        int res = cur.remove(num-(stacknum*stacksize));
        setStacks.push(cur);

        while(!temp.isEmpty()){
            setStacks.push(temp.pop());
        }

        return res;
    }
    private static void insert(int num){
        if(setStacks.isEmpty()){
            Stack<Integer> t = new Stack<>();
            t.push(num);
            setStacks.push(t);
        }
        else{
            if(setStacks.peek().size()< stacksize){
                Stack<Integer> curTop = setStacks.pop();
                curTop.push(num);
                setStacks.push(curTop);
            }else{
                Stack<Integer> newStack = new Stack<>();
                newStack.push(num);
                setStacks.push(newStack);
            }
        }
    }

    private static void delete(){
        if(!setStacks.isEmpty()){
            Stack<Integer> curTop = setStacks.pop();
            System.out.println("Cur del item is "+curTop.pop());
            if(curTop.size()>0)
                setStacks.push(curTop);
        }
    }


}
