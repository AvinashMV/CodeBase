import java.util.ArrayList;

/**
 * @author Avinash Vijayakumar
 * 2018-12-27
 */
public class Solution {
    public static void main(String[] args) {
        String str = "mom";
        System.out.println(sherlockAndAnagrams(str));
    }

    // check if two strings are same of not.
    public static boolean checkAnagram(String a,String b)
    {
        if(a.length() != b.length())
            return false;

        int[] ar = new int[26];
        for (int i = 0; i < a.length(); i++)
        {
            ar[a.charAt(i) - 'a']++;
            ar[b.charAt(i) -'a']--;
        }

        for (int i = 0; i < 26; i++)
        {
            if(ar[i] != 0)
            {
                return false;
            }
        }

        return true;
    }


    static int sherlockAndAnagrams(String s){
        // Complete this function

        // get all possible substrings.
        ArrayList<String> subtrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                subtrings.add(s.substring(i,j+1));
            }
        }

        // check if any two substrings are anagrams of each other or not.
        int anms = 0;
        for (int i = 0; i < subtrings.size(); i++) {
            for (int j = 0; j < subtrings.size(); j++) {
                if(i != j && checkAnagram(subtrings.get(i),subtrings.get(j)))
                {
                    anms++;
                }
            }
        }
        return anms/2;
    }

}

/*
Test cases:
"mom" 2
"abba" 4
"kkkk" 10

 */