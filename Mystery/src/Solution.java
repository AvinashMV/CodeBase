/**
 * @author Avinash Vijayakumar
 * 2019-01-26
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(mystery(2437,875));
    }

    public static int mystery(int a,int b){
        int x=a,y=b;
        while(x!=y){
            if(x>y)
                x = x-y;
            else
                y = y-x;
        }
       return x;
    }
}
