import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Avinash Vijayakumar
 * 2019-05-16
 */
public class Solution {
    public static void main(String[] args) {

    }

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterlogs = new ArrayList<>();
        List<String> digitlogs = new ArrayList<>();

        // separate letter and digit logs.
        for(String log:logs){
            String[] split1 = log.split(" ",2);
            if(Pattern.compile("\\d+").matcher(split1[1]).find()){
                digitlogs.add(log);
            }else{
                letterlogs.add(log);
            }
        }

        //sort letter logs.
        letterlogs.sort((log1,log2)->{
            if(log1.split(" ",2)[1].equals(log2.split(" ",2)[1]))
                return log1.compareTo(log2);
            return log1.split(" ",2)[1].compareTo(log2.split(" ",2)[1]);
        });

        letterlogs.addAll(digitlogs);
        return letterlogs.stream().toArray(String[]::new);

    }
}
