public class Solution {
    public static void main(String[] args) {
        Solution ob = new Solution();
        ob.addBinary("1000","10");
    }

    private String addBinary(String a, String b){
        StringBuilder stringBuilder = new StringBuilder();
        int i=a.length()-1, j = b.length()-1;
        int sum=0, carry=0;
        while(i>=0 && j>=0){
            sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            stringBuilder.append(sum%2);
            carry = sum/2;
        }
        stringBuilder.append(carry);

        while(i>=0){
            stringBuilder.append(a.charAt(i--)-'0');
        }

        while(j>=0){
            stringBuilder.append(b.charAt(j--)-'0');
        }

        stringBuilder.reverse();
        System.out.println(stringBuilder.toString());
        return "null";
    }
}
