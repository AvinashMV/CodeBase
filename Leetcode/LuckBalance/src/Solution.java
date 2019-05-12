import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-01-02
 */
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {
                {5,1},
                {2,1},
                {1,1},
                {8,1},
                {10,0},
                {5,0},
        };
        int k =3;
        System.out.println(luckBalance(k,arr));
    }

    static int luckBalance(int k, int[][] contests) {
        List<Integer> mylist  = new ArrayList<>();
        int imp=0, unimp=0;

        for(int i=0;i<contests.length;i++){
            if(contests[i][1]==0) {
                unimp += contests[i][0];
            }
            else if(contests[i][1]==1) {
                mylist.add(contests[i][0]);
                imp += contests[i][0];
            }
        }

        int lost=0,won=0;

        
        if(mylist.size()>0){
            Collections.sort(mylist,Collections.reverseOrder());
            for(int i=0;i<mylist.size();i++){
                if(k>0)
                    lost += mylist.get(i);
                if(k<0)
                    break;
                k--;
            }
            won = imp - lost;
        }

        return unimp+lost-won;
    }
}

/*
Test case
 int[][] arr = {
                {5,1},
                {2,1},
                {1,1},
                {8,1},
                {10,0},
                {5,0},
        };

int[][] arr = {
                {5,1},
                {1,1},
                {4,0},
        };

 */