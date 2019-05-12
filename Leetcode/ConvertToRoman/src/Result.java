import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Avinash Vijayakumar
 * 2019-02-16
 */
public class Result {
    public static void main(String[] args) {
        Integer[] arr = {75,80,99,100,50};
        System.out.println(romanizer(Arrays.asList(arr)));
    }

    private final static TreeMap<Integer, String> intToRomanMap = new TreeMap<Integer, String>();
    static {
        intToRomanMap.put(1000, "M");
        intToRomanMap.put(900, "CM");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(400, "CD");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(90, "XC");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(40, "XL");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(9, "IX");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(4, "IV");
        intToRomanMap.put(1, "I");
    }

    private final static String ConverToRoman(int number) {
        int n =  intToRomanMap.floorKey(number);
        if ( number == n ) {
            return intToRomanMap.get(number);
        }
        return intToRomanMap.get(n) + ConverToRoman(number-n);
    }


    public static List<String> romanizer(List<Integer> numbers){
        List<String> result = new ArrayList<>();
        for(int i:numbers){
            result.add(ConverToRoman(i));
        }
        // System.out.println(result);
        return result;
    }
}
