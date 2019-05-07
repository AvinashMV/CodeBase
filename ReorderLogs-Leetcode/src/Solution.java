import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Avinash Vijayakumar
 * 2019-03-31
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        solution.reorderLogFiles(logs);
    }

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterlogs = new ArrayList<>();
        List<String> digitlogs = new ArrayList<>();

        for(String s:logs){
            String[] sSplit = s.split(" ",2);
            Pattern pattern = Pattern.compile("[a-z]");
            Matcher matcher = pattern.matcher(sSplit[1]);
            if(matcher.matches())
                letterlogs.add(s);
            else
                digitlogs.add(s);
        }

        letterlogs.sort((log1,log2)->{
            String[] log1Split = log1.split(" ",2);
            String[] log2Split = log2.split(" ",2);

            return log1Split[1].compareTo(log2Split[1]);
        });

        letterlogs.addAll(digitlogs);
        System.out.println(letterlogs);
        return letterlogs.toArray(new String[letterlogs.size()]);
    }
}
