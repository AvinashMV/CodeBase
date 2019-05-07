import java.util.ArrayList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-02-13
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fizzBuzz(15);
    }

    public List<String> fizzBuzz(int n) {
        List<String> mylist = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i>=15 && i%15==0)
                mylist.add("FizzBuzz");
            else if(i>=5 && i%5==0)
                mylist.add("Buzz");
            else if(i>=3 && i%3==0)
                mylist.add("Fizz");
            else
                mylist.add(Integer.toString(i));
        }

        System.out.println(mylist);
        return mylist;
    }
}
