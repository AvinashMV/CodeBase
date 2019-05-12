import java.util.*;

public class Solution {
    private Set<Integer> factors = new HashSet<>();
    public static void main(String[] args) {

        Solution object = new Solution();
        System.out.println(object.getCoPrimes(109));
    }

    private void getFactors(int n){
        while(n%2==0){
            factors.add(2);
            n /=2;
        }

        for(int i=3;i<=Math.sqrt(n);i++){
            while(n%i==0){
                factors.add(i);
                n /=i;
            }
        }

        if(n>2)
            factors.add(n);
    }

    private List<Integer> getCoPrimes(int n){
        getFactors(n);
        List<Integer> coprimes = new ArrayList<>();
        for(int i=1;i<n;i++)
            coprimes.add(i);

        Iterator<Integer> iterator = factors.iterator();
        while(iterator.hasNext()){
            int primefactor = iterator.next();
            int i=0;
            while(i<coprimes.size()){
                if(coprimes.get(i) % primefactor ==0)
                    coprimes.remove(coprimes.get(i));
                i++;
            }
        }
        return coprimes;
    }

}
