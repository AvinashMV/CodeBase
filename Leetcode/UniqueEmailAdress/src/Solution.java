import java.util.HashSet;
import java.util.Set;

/**
 * @author Avinash Vijayakumar
 * 2019-05-20
 */
public class Solution {
    public static void main(String[] args) {
        String[] arr = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Solution solution = new Solution();
        solution.numUniqueEmails(arr);

    }
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String email:emails){
            StringBuilder sb = new StringBuilder();
            // split on @.
            String[] split1 = email.split("@");
            sb.insert(0,split1[1]);
            sb.insert(0,"@");

            // split localname on +
            String[] split2 = split1[0].split("\\+");
            // replace . with space.
            String newlocal = split2[0].replaceAll("\\.","");
            sb.insert(0,newlocal);

            set.add(sb.toString());
        }
        System.out.println(set);
        return set.size();
    }
}
