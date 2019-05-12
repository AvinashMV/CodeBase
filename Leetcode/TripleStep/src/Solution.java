/**
 * @author Avinash Vijayakumar
 * 2019-02-05
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(tripleStep(5));
    }

    public static int tripleStep(int steps){
        int a=0,b=1,c=2,d=4;
        int e = -1;
        if(steps<=3){
            switch (steps){
                case 0: return 0;
                case 1: return 1;
                case 2: return 2;
                case 3: return 4;
            }
        }
        else{
            for(int i=4;i<steps+1;i++){
                e = b+c+d;
                b=c;c=d;d=e;
            }
        }
        return e;
    }
}
