import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Avinash Vijayakumar
 * 2019-01-06
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {390225 ,426456 ,688267 ,800389 ,990107 ,439248 ,240638 ,15991 ,874479 ,568754 ,729927 ,980985 ,132244 ,488186 ,5037 ,721765 ,251885 ,28458 ,23710 ,281490 ,30935 ,897665 ,768945 ,337228 ,533277 ,959855 ,927447 ,941485 ,24242 ,684459 ,312855 ,716170 ,512600 ,608266 ,779912 ,950103 ,211756 ,665028 ,642996 ,262173 ,789020 ,932421 ,390745 ,433434 ,350262 ,463568 ,668809 ,305781 ,815771 ,550800};
        int k = 3;
        System.out.println(getMinimumCost3(k,arr));

    }


    static int getMinimumCost3(int k, int[] c){
        Arrays.sort(c);
        int cost = 0;
        int count = k;
        int purchases = 0;
        for(int i=c.length-1;i>=0;i--){
            cost += (purchases+1) * c[i];
            count --;

            if(0==count){
                purchases++;
                count = k;
            }
        }
        return cost;
    }

    static int getMinimumCost2(int k, int[] c) {
        int cost = 0;
        Arrays.sort(c);
        int multiplier = 0;
        int count = k;
        for (int i = c.length - 1; i >= 0; i--) {
            cost += (multiplier + 1) * c[i];
            count--;
            if (0 == count) {
                multiplier++;
                count = k;
            }
        }
        return cost;
    }

    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        List<Integer> list = Arrays.stream(c).boxed().collect(Collectors.toList());
        List<Integer> coeff = new ArrayList<>();
        int countPerPerson = (int) Math.ceil((double)c.length/k);

        while(k>0){
            int purchases=1;
            for(int curcount=0;curcount<countPerPerson && coeff.size()<c.length; curcount++){
                coeff.add(purchases);
                purchases++;
            }
            k--;
        }


        Collections.sort(coeff,Collections.reverseOrder());
        System.out.println(coeff.size());
        System.out.println(coeff);

        int totalsum = 0;
        for(int i=0;i<list.size();i++){
            totalsum += coeff.get(i)*list.get(i);
        }

        return totalsum;
    }
}

/* test case

int[] arr = {1,3,5,7,9};
int k = 3;
ans 29

int[] arr = {1,2,3,4};
int k = 3;
ans 11


int[] arr = {2,5,6};
int k = 3;
ans 13


int[] arr = {2,5,6};
int k = 2;
ans 15


int[] arr = {390225 ,426456 ,688267 ,800389 ,990107 ,439248 ,240638 ,15991 ,874479 ,568754 ,729927 ,980985 ,132244 ,488186 ,5037 ,721765 ,251885 ,28458 ,23710 ,281490 ,30935 ,897665 ,768945 ,337228 ,533277 ,959855 ,927447 ,941485 ,24242 ,684459 ,312855 ,716170 ,512600 ,608266 ,779912 ,950103 ,211756 ,665028 ,642996 ,262173 ,789020 ,932421 ,390745 ,433434 ,350262 ,463568 ,668809 ,305781 ,815771 ,550800};
int k = 3;
ans = 163578911

int[] arr = {120854,100862 ,523789 ,849072 ,23733 ,355147 ,660925 ,59103 ,801528 ,607947 ,51312 ,754005 ,823629 ,876280 ,23088 ,668838 ,214629 ,641310 ,66064 ,541147 ,97284 ,579336 ,319949 ,193067 ,35064 ,227785 ,376976 ,146458 ,258150 ,551784 ,961936 ,189099 ,552128 ,318057 ,39381 ,41667 ,316754 ,680180 ,681303 ,7132 ,472252 ,791845 ,540485 ,464674 ,336442 ,572655 ,724577 ,627822 ,553055 ,986861 ,944776 ,588636 ,966817 ,892103 ,737744 ,478475 ,668429 ,809085 ,362250 ,597680};
int k=18;
ans


 */