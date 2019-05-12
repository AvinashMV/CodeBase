import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

/**
 * @author Avinash Vijayakumar
 * 2019-01-31
 */
public class Result {
    public static void main(String[] args) {
        List<List<Integer>> mylist = new ArrayList<>();
        Integer [] arr1 = {-1,3,1};
        Integer [] arr2 = {6,1,2};
        Integer[] arr3 = {4,3,1};
        Integer [] arr4 = {0,1,1};

        mylist.add(Arrays.asList(arr1));
        mylist.add(Arrays.asList(arr2));
        mylist.add(Arrays.asList(arr3));
        mylist.add(Arrays.asList(arr4));

        System.out.println(mean(mylist));
    }

    public static List<Double> mean (List<List<Integer>> two_d_array){
        List<Double> result = new ArrayList<>();
        for(List<Integer> list:two_d_array){
            int count = 0;
            for(int i:list)
                count +=i;
            double mean = (double)count/list.size();
            mean = Math.round(mean*10)/10.0;
            if(mean!=0)
                result.add(mean);
        }

        // System.out.println(result);
        return result;
    }
}
