package com.solution4;

/**
 * @author Avinash Vijayakumar
 * 2019-06-12
 *
 * Problem: whole minute dilemma
 *
 * Given array if integers, choose pairs of intergers whose sum is divisible by 60.
 *
 */
public class Solution {
    public static void main(String[] args)
    {
        int A[] = { 30,20,150,100,40};
        int n = 5;
        int K = 60;
        System.out.print(countKdivPairs(A, n, K));
    }


    /**
     *
     * @param A: array of integers.
     * @param n: number of interges in the array
     * @param K: Here it is 60.
     * @return : integer. 
     */
    public static int countKdivPairs(int A[], int n, int K)
    {
        // Create a frequency array to count
        // occurrences of all remainders when
        // divided by K
        int freq[] = new int[K];

        // Count occurrences of all remainders
        for (int i = 0; i < n; i++)
            ++freq[A[i] % K];

        // If both elements in  pairs are divisible by 'K'
        int sum = freq[0] * (freq[0] - 1) / 2;

        // count for all i and (k-i)
        // freq pairs i!=k-1 bcoz both remainders must be different.
        for (int i = 1; i <= K / 2 && i != (K - i); i++)
            sum += freq[i] * freq[K - i];

        // If K is even, exactly k/2 will combine themselves. 
        if (K % 2 == 0)
            sum += (freq[K / 2] * (freq[K / 2] - 1) / 2);
        return sum;
    }
}


/*
Logic explanation:
for k = 60, all elements which remainders are 0 combine themselves. and also at 30.
because we are combining i and 60-i. like 1 and 59 , 2 and 58, 20 and 40. So we can't combine 30 and 30. Both
must be different.

for i =0 and k/2 that is 30, It is like we are choosing any 2 out of n.
nCr shortcut is expand n till r times backwards. like say nC2 => (n* n-1 )
and divide it by r till expanded to 1. like 2*1.

so n*n-1 / 2*1 which is (n*n-1)/2.

 */

/*

Test cases:
int A[] = { 2, 2, 1, 7, 5, 3 };
int n = 6;
int K = 4;


int A[] = { 10,50,90,30 };
int n = 4;
int K = 60;


int A[] = { 30,20,150,100,40};
int n = 5;
int K = 60;


 */