/**
 * @author Avinash Vijayakumar
 * 2019-03-22
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "-912a83472332";
        System.out.println(solution.myAtoi2(s));
    }


    public int myAtoi2(String str){
        String modified_str;
        modified_str = str.trim();

        if(modified_str.length()<1)
            return 0;

        modified_str = modified_str.split(" ")[0];
        boolean positive = true;

        if(modified_str.charAt(0)=='+' || modified_str.charAt(0)=='-') {
            if(modified_str.charAt(0)=='-')
                positive = false;

            modified_str = modified_str.substring(1,modified_str.length());
        }
        
        long n = 0;
        for(char ch: modified_str.toCharArray()){
            if(Character.isDigit(ch)){
                n  = n*10+ch-'0';
                // check for bounds
                if(!positive){
                    if(n*-1 <Integer.MIN_VALUE)
                        return Integer.MIN_VALUE;

                }else{
                    if(n >= Integer.MAX_VALUE)
                        return Integer.MAX_VALUE;
                }
            }else{
                break;
            }
        }
        // System.out.println(n);

        return (int)(positive?n:-1*n);
    }

    public int myAtoi(String str) {
        String modified_str;
        modified_str = str.trim();
        modified_str = modified_str.split(" ")[0];

        if(modified_str.contains(".")){
            int indexDecimal = modified_str.indexOf('.');
            modified_str = modified_str.substring(0,indexDecimal);
        }

        // check for out of bounds.
        long res;
        try{
            res = Long.parseLong(modified_str);
            System.out.println(res);
            if(res>0 && res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(res<0 && res<Integer.MIN_VALUE) return Integer.MIN_VALUE;

        }
        catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
        return (int)res;
    }
}

/*
Test cases:
 String s = "42";
 String s = "             -42";
String s = "-91283472332";
String s = "4193 with words";  



 */