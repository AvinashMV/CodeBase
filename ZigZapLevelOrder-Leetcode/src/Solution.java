import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Avinash Vijayakumar
 * 2019-04-21
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> valueList = levelOrder(root);
        if(valueList.size()>1){
            for(int i=1;i<valueList.size();i+=2){
                List<Integer> t = valueList.get(i);
                Collections.reverse(t);
            }
        }

        return valueList;
    }

    private List<List<Integer>> levelOrder(TreeNode root){
        List<TreeNode> nodes = new ArrayList<>();
        List<List<Integer>> values = new ArrayList<>();

        if(root==null){
            return values;
        }

        nodes.add(root);
        while(nodes.size()!=0){
            // get the values from the nodes list.
            List<Integer> values_local = new ArrayList<>();
            List<TreeNode> nodes_next = new ArrayList<>();
            for(TreeNode cur:nodes){
                values_local.add(cur.val);
                if(cur.left!=null)
                    nodes_next.add(cur.left);
                if(cur.right!=null)
                    nodes_next.add(cur.right);
            }
            values.add(values_local);
            nodes = nodes_next;
        }

        System.out.println(values);
        return values;
    }
}
