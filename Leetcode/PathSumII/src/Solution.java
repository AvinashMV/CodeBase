import java.util.ArrayList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-01-22
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> mylist = new ArrayList<>();
        checkSum(root,mylist,sum);
        System.out.println(result);
        return result;
    }

    private void checkSum(TreeNode root,List<Integer> mylist,int sum){
        if(root==null)
            return;

        if(root.val==sum && root.left==null && root.right==null){
            mylist.add(root.val);
            result.add(mylist);
            return;
        }

        sum = sum - root.val;
        mylist.add(root.val);
        sum = sum - root.val;
        mylist.add(root.val);
        checkSum(root.left, new ArrayList<>(mylist), sum);
        checkSum(root.right, new ArrayList<>(mylist), sum);
    }
}
