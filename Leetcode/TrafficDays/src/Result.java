import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Avinash Vijayakumar
 * 2019-02-16
 */
public class Result {
    public static void main(String[] args) {
        System.out.println(PredictTraffic(50L,100L,150L,0));
    }

    public static long PredictTraffic(long day1,long day2,long day3, int n){
        List<Long> mylist = new ArrayList<>();
        mylist.add(day1);
        mylist.add(day2);
        mylist.add(day3);

        int count = 1;
        while(count<=n){
            long sum = mylist.get(0)+mylist.get(1)+mylist.get(2);
            long nextSum = 2* Math.round(sum/3);
            mylist.remove(0);
            mylist.add(nextSum);
            count++;
        }

        System.out.println(mylist);
        return mylist.get(mylist.size()-1);
    }
}
