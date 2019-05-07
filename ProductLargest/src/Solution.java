/**
 * @author Avinash Vijayakumar
 * 2019-01-12
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 7, 0} ;
        System.out.println("largest product is "+ largestProduct(arr));
    }

    private static int largestProduct(int[] arr){
        int posfirstmax =Integer.MIN_VALUE , possecondmax = Integer.MIN_VALUE;
        int negfirstmin = Integer.MAX_VALUE, negsecondmin = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){

            // largest positive value. Treat 0 as positive value.
            if(arr[i]>=0){
                // first update 1st max value.
                if(arr[i]>posfirstmax){
                    possecondmax = posfirstmax;
                    posfirstmax = arr[i];

                }else if(arr[i]>possecondmax){
                    possecondmax = arr[i];
                }
            }
            else{
                // lowest negative value.
                if(arr[i]<negfirstmin){
                    negsecondmin = negfirstmin;
                    negfirstmin = arr[i];

                }else if(arr[i]<negsecondmin){
                    negsecondmin = arr[i];
                }
            }
        }

        System.out.println(posfirstmax+" "+possecondmax);
        System.out.println(negfirstmin+" "+negsecondmin);

        // check and return the product.
        int product1 = 0, product2 = 0;
        if(posfirstmax!=Integer.MIN_VALUE && possecondmax!=Integer.MIN_VALUE) {
            product1 = posfirstmax * possecondmax;
        }
        if(negfirstmin!=Integer.MAX_VALUE && negsecondmin!=Integer.MAX_VALUE) {
                product2 = negfirstmin * negsecondmin;
        }


        return (product1>product2)?product1:product2;
    }
}

/*
Test cases.

{1, 4, 3, 6, 7, 0};
{-1, -3, -4, 2, 0, -5}
 */