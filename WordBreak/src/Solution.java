import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-05-06
 */
public class Solution {
    public static void main(String[] args) {
        String s = "catsandog";
        String[] list = {"cats", "dog", "sand", "and", "cat"};

        Solution solution = new Solution();
        System.out.println(solution.breakWordDP(s, Arrays.asList(list)));

    }
    public boolean breakWordDP(String s, List<String> wordDict){
        Set<String> dict = new HashSet<>(wordDict);
        int T[][] = new int[s.length()][s.length()];

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }

        //fill up the matrix in bottom up manner
        for(int l = 1; l <= s.length(); l++){
            for(int i=0; i < s.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = s.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str)){
                    T[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true
                for(int k=i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }
        /*if(T[0][word.length()-1] == -1){
            return false;
        }*/

        /*//create space separate word from string is possible
        StringBuffer buffer = new StringBuffer();
        int i = 0; int j = word.length() -1;
        while(i < j){
            int k = T[i][j];
            if(i == k){
                buffer.append(word.substring(i, j+1));
                break;
            }
            buffer.append(word.substring(i,k) + " ");
            i = k;
        }

        return buffer.toString();*/

        return T[0][s.length()-1] == -1?false:true;
    }
}

/*
Test Cases:

String s = "leetcode";
String[] list = {"leet","code"};

String s = "applepenapple";
String[] list = {"apple","pen"};




 */