import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-02-27
 */
public class Solution {
    static class Test{
        int val1,val2;
        public Test(int v1,int v2){
            val1 = v1;
            val2 = v2;
        }

        @Override
        public String toString() {
            return val1+" "+val2;
        }
    }

    public static void main(String[] args) {
        List<Test> mylist = new ArrayList<>();
        for(int i=0;i<10;i++){
            mylist.add(new Test(i,i*3));
        }

        Collections.sort(mylist,(Test ob1,Test ob2)->ob2.val1-ob1.val1);
        System.out.println(mylist);
    }


}
