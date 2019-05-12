import java.util.HashMap;

/**
 * @author Avinash Vijayakumar
 * 2019-01-12
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,6};
        int money = 5;

        whatFlavors(arr,money);
    }

    private static void display(int id1, int id2) {
        if(id1>id2) {
            int t = id1;
            id1 = id2;
            id2 =t;
        }
        System.out.println(id1+" "+id2);
    }

    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer,Integer> mymap = new HashMap<>();

        // int cost1=-1, cost2=-1;
        int id1 = -1, id2 = -1;

        for(int i=0;i<cost.length;i++){
            if(mymap.keySet().contains(cost[i])){
                id1 = i;
                id2 = mymap.get(cost[i]);

                break;

            }else{
                mymap.put(money-cost[i], i);
            }
        }

        //System.out.println((id1+1)+" "+(id2+1));
        display(id1+1, id2+1);

    }
}


/*
Test cases:
int[] arr = {1,4,5,3,2};
int money = 4;

int[] arr = {2,1,3,5,6};
int money = 5



 */