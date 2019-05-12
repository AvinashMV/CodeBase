import java.util.ArrayList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-04-14
 */

//for each round, calculate sum and maintain arraylist of points.
// final output is sum.

public class Solution {
    public static void main(String[] args) {
        String[] arr = {"5","-2","4","C","D","9","+","+"};
        Solution solution = new Solution();
        solution.calPoints(arr);
    }

    public int calPoints(String[] ops) {
        List<Integer> points = new ArrayList<>();
        int total = 0;

        for(String i:ops){
            if(i=="+"){
                int size = points.size();
                int t = points.get(size-1)+points.get(size-2);
                points.add(t);
            }else if(i.equals("C")){
                points.remove(points.size()-1);
            }else if(i.equals("D")){
                points.add( points.get(points.size()-1)*2 );
            }else{
                points.add(Integer.parseInt(i));
            }
        }

        // System.out.println(points);
        int sum = points.stream().mapToInt(i->i).sum();
       //  System.out.println(sum);
        return total;
    }
}

/*
Test cases:
String[] arr = {"5","2","C","D","+"};
String[] arr = {"5","2","C","D","+"};


 */