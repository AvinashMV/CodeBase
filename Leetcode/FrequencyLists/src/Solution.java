import java.io.ObjectInputStream;
import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2018-12-31
 */
public class Solution {
    private static Map<Integer,Integer> frequencyfreq = new HashMap<>();

    public static void main(String[] args) {
        List<List<Integer>> mylist = new ArrayList<>();
        mylist.add(new ArrayList<Integer>(Arrays.asList(1,3)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(2,3)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(3,2)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(1,4)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(1,5)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(1,5)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(1,4)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(3,2)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(2,4)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(3,2)));

        //System.out.println(mylist);
        System.out.println(freqQuery(mylist));


    }
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> output = new ArrayList<>();
        Map<Integer,Integer> counter = new HashMap<>();



        for(List list:queries){
            int curValue = (int) list.get(1);
            switch ((int)list.get(0)){
                case 1:

                    if(counter.get(curValue)==null){
                        counter.put((int)curValue,1);
                        updateFreqMap(1,"add");

                    }else{
                        updateFreqMap(counter.get(curValue),"sub");
                        counter.put((int)curValue, counter.get(curValue)+1 );
                        updateFreqMap(counter.get(curValue),"add");
                    }
                    break;

                case 2:
                    if(counter.get(curValue)!=null){
                        if(counter.get(curValue)==1) {
                            counter.remove(curValue);
                            updateFreqMap(1,"sub");
                        }
                        else {
                            updateFreqMap(counter.get(curValue),"sub");
                            counter.put(curValue, counter.get(curValue) - 1);
                            updateFreqMap(counter.get(curValue),"add");
                        }
                    }
                    break;

                case 3:
                    if(frequencyfreq.get(curValue)!=null) {
                        if (frequencyfreq.get(curValue) > 0)
                            output.add(1);
                        else
                            output.add(0);
                    }
                    else
                        output.add(0);
                    break;
            }
        }
        return output;
    }

    public static void updateFreqMap(int value,String code){
        if(frequencyfreq.get(value)!=null){
            if(code.equals("add")){
                frequencyfreq.put(value, frequencyfreq.get(value)+1);
            }else{
                frequencyfreq.put(value, frequencyfreq.get(value)-1);
            }
        }else{

            if(code.equals("add")){
                frequencyfreq.put(value,1);
            }
        }

    }
}


/*
Test cases:
test case 1
 List<List<Integer>> mylist = new ArrayList<>();
        mylist.add(new ArrayList<Integer>(Arrays.asList(1,5)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(1,6)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(3,2)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(1,10)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(1,10)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(1,6)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(2,5)));
        mylist.add(new ArrayList<Integer>(Arrays.asList(3,2)));


test case 2

 */