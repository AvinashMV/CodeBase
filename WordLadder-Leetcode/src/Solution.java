import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Avinash Vijayakumar
 * 2019-04-23
 */
public class Solution {
    public static void main(String[] args) {
        String beginword = "lost";
        String endword = "cost";
        String[] ladder ={"most","fist","lost","cost","fish"};

        List<String> ladderList = Arrays.stream(ladder).collect(Collectors.toList());

        Solution solution = new Solution();
        int res = solution.ladderLength(beginword,endword,ladderList);
        System.out.println(res);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // construct a set first.
        Set<String> wordset = new HashSet<>(wordList);

        // check if endword is present in wordset or not
        if(!wordset.contains(endWord)){
            return 0;
        }

        //use queue
        Queue<String> queue = new LinkedList<>();
        //add beginword in it to start with.
        queue.add(beginWord);

        // to keep of levels.
        int level = 0;

        while(!queue.isEmpty()){
            //process all the nodes in the queue.
            for(int i=queue.size();i>0;i--){ // Most imp and difficult part to understand.
                String curWord = queue.poll();

                // if curWord is the end word, that's it.
                if(curWord.equals(endWord))
                    return level+1;

                // generate combinations of it.
                for(int j=0;j<curWord.length();j++){
                    char[] newWordArr = curWord.toCharArray();

                    for(char ch='a';ch<='z';ch++){
                        newWordArr[j] = ch;
                        String newWord = new String(newWordArr);
                        if(wordset.contains(newWord) && !newWord.equals(curWord)){
                            // add the new word to queue and remove it from wordset
                            queue.add(newWord);
                            wordset.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}










/*

String beginword = "hit";
String endword = "cog";
String[] ladder ={"hot","dot","dog","lot","log","cog"};


String beginword = "lost";
String endword = "cost";

String[] ladder ={"most","fist","lost","cost","fish"};



public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset = new HashSet<>(wordList);
        if(!wordList.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int res=0;
        while(!queue.isEmpty()){
            for(int k= queue.size();k>0;k--){
                String word = queue.poll();

                if(word.equals(endWord)){
                    return res+1;
                }

                for(int i=0;i<word.length();i++){
                    char[] newWord = word.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        newWord[i] = ch;
                        String s = new String(newWord);
                        if(wordset.contains(s) && !s.equals(word)){
                            queue.add(s);
                            wordset.remove(s);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
 */