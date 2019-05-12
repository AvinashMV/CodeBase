import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Avinash Vijayakumar
 * 2019-04-24
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null)
            return result;

        queue.add(root);

        while(!queue.isEmpty()){
            // process all the nodes from that level.
            List<Integer> t = new ArrayList<>();
            for(int i=queue.size();i>0;i--){
                TreeNode curNode = queue.poll();
                t.add(curNode.val);

                if(curNode.left!=null) queue.add(curNode.left);
                if(curNode.right!=null) queue.add(curNode.right);
            }
            result.add(t);
        }
        return result;
    }
}
