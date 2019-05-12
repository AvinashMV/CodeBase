import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * @author Avinash Vijayakumar
 * 2019-03-15
 *
 * Given birth year and death year, of some people, find out the year in which maximum people
 * were alive.
 */


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] birthYear = {1982,1923,1988,1910,1990,2004};
        int[] deathYear = {2017,2004,2015,1988,2005,2010};
        solution.findYear(birthYear,deathYear);
    }

    public void findYear(int[] birth, int[]death){
        Map<Integer,Integer> numberLine = new TreeMap<>();

        Arrays.stream(birth)
                .forEach(i->numberLine.compute(i,(key,val)->val==null?1:val+1));

        Arrays.stream(death)
                .forEach(i ->numberLine.compute(i+1,(key,val)->val==null?-1:val-1));

        int curMax = 0, maxSoFar = 0, resultYear = -1;

        for(Map.Entry<Integer,Integer>entry:numberLine.entrySet()){
            curMax+= entry.getValue();
            if(curMax>maxSoFar){
                maxSoFar = curMax;
                resultYear = entry.getKey();
            }
        }
        System.out.println("Maximum people alive is "+maxSoFar+" in the year "+resultYear);
    }
}
