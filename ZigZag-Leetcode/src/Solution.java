import java.util.stream.IntStream;

/**
 * @author Avinash Vijayakumar
 * 2019-03-22
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "PAYPALISHIRING";
        System.out.println(solution.convert(s,4));
    }

    public String convert(String s, int numRows) {
        if(numRows<2)
            return s;

        StringBuilder[] sb = new StringBuilder[numRows];
        IntStream.range(0,sb.length)
                .forEach(i->sb[i]=new StringBuilder());

        int count = 0, maxrows = numRows-1;
        boolean forward = true;

        for(char ch:s.toCharArray()){
            sb[count].append(ch);

            if(forward){
                if(count==maxrows)
                {
                    forward = false;
                    count--;
                    continue;
                }
                count++;

            }else{
                // reverse direction
                if(count==0){
                    forward = true;
                    count++;
                    continue;
                }
                count--;

            }
        }

        String result="";
        for(int i=0;i<sb.length;i++){
            result+= sb[i].toString();
        }
        return result;
    }
}
