import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-05-12
 */
public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("mission statement");
        list.add("a quick bite to eat");
        list.add("a chip off the old block");
        list.add("chocolate bar");
        list.add("mission impossible");
        list.add("a man on a mission");
        list.add("block party");
        list.add("eat my words");
        list.add("bar of soap");
         generate_phrases(list);
    }

    public static List<String> generate_phrases(List<String> phrases){
        HashMap<String,List<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(String s:phrases){
            String[] split = s.split(" ",2);
            if(map.containsKey(split[0])){
                map.get(split[0]).add(split[1]);
            }else{
                List<String> t = new ArrayList<>();
                t.add(split[1]);
                map.put(split[0],t);
            }
        }

        // System.out.println(map);

        for(String s:phrases){
            StringBuilder sb = new StringBuilder(s);
            sb.append(" ");
            String[] split = s.split(" ");
            String lastword = split[split.length-1];
            if(map.containsKey(lastword)){
                List<String> t = map.get(lastword);
                for(String i:t){
                    int len = i.length();
                    sb.append(i);
                    result.add(sb.toString());
                    sb.setLength(sb.length()-len);
                }

            }
        }

        System.out.println(result);
        return result;
    }
}

/*
Test cases:
List<String> list = new ArrayList<>();
list.add("writing code");
list.add("code rocks");




 */