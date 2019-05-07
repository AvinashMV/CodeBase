import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2019-04-26
 */
public class Solution {
    Map<String,Integer> frequenceMap = new HashMap<>();

    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        Solution solution = new Solution();
        solution.subdomainVisits(cpdomains);
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        for(String s:cpdomains){
            String[] split1 = s.split(" ");
            int count = Integer.parseInt(split1[0]);
            String URL = split1[1];

            String[] URLSplit = URL.split("\\.");
            int len = URLSplit.length;
            StringBuilder sb = new StringBuilder();
            sb.append(URLSplit[len-1]);

            for(int i=len-2;i>-1;i--){
                // String cur = sb.toString();
                // System.out.println(cur);
                frequenceMap.compute(sb.toString(),(key,val)->val==null?count:val+count);
                sb.insert(0,".");
                sb.insert(0,URLSplit[i]);
            }
            // last one.
            // System.out.println(sb.toString());
            frequenceMap.compute(sb.toString(),(key,val)->val==null?count:val+count);
        }

        for(Map.Entry<String,Integer>entry:frequenceMap.entrySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            result.add(sb.toString());
        }

        System.out.println(result);
        return result;
    }
}
