/**
 * @author Avinash Vijayakumar
 * 2019-01-15
 */
/*
Question:
There are three types of edit that can be performed on strings: insert a character , remove or replace.
Given two strings, write a function to check if they are one edit (or zero edits) away.
 */
public class Solution {
    public static void main(String[] args) {
        // String a="pale", b="ple";
        String a="pale", b="bake";
        System.out.println(CheckOneAway(a,b));
    }

    private static int checkOnes(int[] arr){
        int ones = 0;
        for(int i:arr){
            if(i==1)
                ones++;
        }
        return ones;

    }
    private static boolean CheckOneAway(String a, String b){
        if(a.equals(b))
            return true;

        if(Math.abs(a.length()-b.length())>1)
            return false;

        int[] arr = new int[26];
        for(int i=0;i<a.length();i++){
            arr[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++){
            arr[b.charAt(i)-'a']--;
        }

        if(a.length()==b.length()){
            return checkOnes(arr) <= 1;
        }else{
            return checkOnes(arr) <= 2;
        }
    }
}
